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

@Authenticated(Secured.class)
public class Pronostiques extends Controller  {

	static Form<Pronostique> pronostiqueForm = form(Pronostique.class);
	static Form<Journee> journeeForm = form(Journee.class);
	
	public static Result pronostics(String id) {
		Utilisateur user = Utilisateur.findByPseudo(request().username());
//		List<Matche> matches = Matche.find.all();
		List<Journee> journees = Journee.find.all();
		Long idLong = Long.parseLong(id);
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
		System.out.println(filledForm.toString());
		if(filledForm.hasErrors()) {
			return badRequest(
					views.html.index.render(Utilisateur.findByPseudo(request().username()))
			);
		} else {
			Date maintenant = new Date();
			
			Pronostique test = filledForm.get();
			
			Utilisateur user = Utilisateur.findByPseudo(request().username());
			test.setUtilisateur(user);
			
			Matche matche = Matche.findById(Long.parseLong(idMatche));
			test.setMatche(matche);
			
			test.setCalcule(false);
			
			List<Pronostique> pronostic = Pronostique.find.where().eq("utilisateur", user).eq("matche", matche).findList();
			
			if(maintenant.before(matche.dateMatche)){
				if(pronostic.isEmpty())
				{
					System.out.println(test.getUtilisateur().nom);
					Pronostique.create(test);
				} else {
					test.id = pronostic.get(0).getId();
					Pronostique.update(test);
					System.out.println("UPDATE !!!");
				}
				return redirect(routes.Pronostiques.pronostics("1"));
			} else {
				return badRequest(
						views.html.index.render(Utilisateur.findByPseudo(request().username()))
				);
			}
		}
	}
	  
	public static Result deletePronostique(Long id) {
		return TODO;
	}

}
