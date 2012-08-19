package controllers;

import java.util.Date;
import java.util.List;

import models.Journee;
import models.Matche;
import models.Pronostique;
import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.pronosticsForm;
import views.html.index;

@Authenticated(Secured.class)
public class Pronostiques extends Controller  {

	static Form<Pronostique> pronostiqueForm = form(Pronostique.class);
	static Form<Journee> journeeForm = form(Journee.class);
	static Form<Matche> matcheForm = form(Matche.class);
	
	public static Result calculPoints() {
		Utilisateur user = Utilisateur.findByPseudo(request().username());
		List<Utilisateur> utilisateurs = Utilisateur.find.all();
		List<Matche> matches = Matche.find.where().isNotNull("scoreEquipe1").findList();
		
		for (Matche match : matches) {
				List<Pronostique> pronostiques = Pronostique.find.where().eq("matche",match).eq("calcule",false).findList();
				if(null!=pronostiques) {
					for (Pronostique prono : pronostiques) {
						Utilisateur utilisateur = prono.utilisateur;
						if(prono.getVainqueur() == prono.getMatche().getVainqueur()) {
							if( (prono.getPronoEquipe1() == prono.getMatche().getScoreEquipe1()) && (prono.getPronoEquipe2() == prono.getMatche().getScoreEquipe2()) ) {
								utilisateur.ajouterPoints(15,utilisateur);
							} else {
								utilisateur.ajouterPoints(10,utilisateur);
							}
							
						}
						prono.setCalcule(true);
						prono.update();
					}
				}
		}
		
		return ok(
			index.render(user,Utilisateur.find.orderBy().desc("points").findList())
		);
			
	}
		
	
	public static Result pronostics(String id) {
		Long idLong;
		if (id.equalsIgnoreCase("0")) {
			System.out.println("Id vaut 0");
			Date maintenant = new Date();
			
			List<Journee> journeesFutures = Journee.find.where().gt("dateJournee", maintenant).orderBy().asc("dateJournee").findList();
			idLong = journeesFutures.get(0).id;
		} else {
			idLong = Long.parseLong(id);
		}
		Utilisateur user = Utilisateur.findByPseudo(request().username());
		List<Journee> journees = Journee.find.all();
		Journee journee = Journee.find.byId(idLong);
		
		List<Matche> matches = Journee.findMatchesById(idLong);
		
		List<Pronostique> pronostiques = Pronostique.find.where().eq("utilisateur",user).findList();
		pronostiqueForm = form(Pronostique.class);
		return ok(
		pronosticsForm.render(matches,pronostiques,pronostiqueForm,user,journees,journee)
		);
	}
  
	public static Result save(String idMatche) {
		Form<Pronostique> filledForm = pronostiqueForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(
					views.html.index.render(Utilisateur.findByPseudo(request().username()),Utilisateur.find.orderBy().desc("points").findList())
			);
		} else {
			Date maintenant = new Date();
			
			Pronostique test = filledForm.get();
			
			Utilisateur user = Utilisateur.findByPseudo(request().username());
			test.setUtilisateur(user);
			
			Matche matche = Matche.findById(Long.parseLong(idMatche));
			test.setMatche(matche);
			
			test.setCalcule(false);
			
			if(test.getPronoEquipe1() > test.getPronoEquipe2()) {
				test.setVainqueur(matche.getEquipe1());
			}else if((test.getPronoEquipe1() < test.getPronoEquipe2())) {
				test.setVainqueur(matche.getEquipe2());
			}else {
				test.setVainqueur(null);
			}
			
			// récupération de la journée en cours
			String idJournee = "0";
			List<Journee> journees = Journee.find.where().gt("dateJournee", maintenant).findList();
			for (Journee journee : journees) {
				List<Matche> matches = journee.findMatchesById(journee.id);
				if (matches.contains(matche)) {
					idJournee = journee.id.toString();
				}
			}
			
			List<Pronostique> pronostic = Pronostique.find.where().eq("utilisateur", user).eq("matche", matche).findList();
			
			if(maintenant.before(matche.dateMatche)){
				if(pronostic.isEmpty())
				{
					Pronostique.create(test);
				} else {
					test.id = pronostic.get(0).getId();
					Pronostique.update(test);
				}
				return redirect(routes.Pronostiques.pronostics(idJournee));
			} else {
				return badRequest(
						views.html.index.render(Utilisateur.findByPseudo(request().username()),Utilisateur.find.orderBy().desc("points").findList())
				);
			}
		}
	}
	  
	public static Result deletePronostique(Long id) {
		return TODO;
	}

}
