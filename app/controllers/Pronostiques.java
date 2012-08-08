package controllers;

import java.util.List;

import ch.qos.logback.classic.Logger;

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
	
<<<<<<< HEAD
	public static Result pronostics(String id) {
		Utilisateur user = Utilisateur.findByNom(request().username());
//		List<Matche> matches = Matche.find.all();
		List<Journee> journees = Journee.find.all();
		Long idLong = Long.parseLong(id);
		List<Matche> matches = Journee.findMatchesById(idLong);
		
		List<Pronostique> pronostiques = Pronostique.find.where().eq("utilisateur",user).findList();
=======
	public static Result pronostics() {
		Utilisateur user = Utilisateur.findByPseudo(request().username());
		List<Matche> matches = Matche.find.all();
		//List<Pronostique> pronostiques = Pronostique.find.where().eq("utilisateur",user).in("match", matches).findList();
		List<Pronostique> pronostiques = Pronostique.find.all();
>>>>>>> Inscription utilisateur
		pronostiqueForm = form(Pronostique.class);
		return ok(
		pronosticsForm.render(matches,pronostiques,pronostiqueForm,user,journees,journeeForm)
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
			Pronostique test = filledForm.get();
			
			Utilisateur user = Utilisateur.findByNom(request().username());
			test.setUtilisateur(user);
			
			Matche matche = Matche.findById(Long.parseLong(idMatche));
			test.setMatche(matche);
			
			System.out.println(test.getUtilisateur().nom);
			Pronostique.create(test);
			return redirect(routes.Pronostiques.pronostics("1"));  
		}
	}
	  
	public static Result deletePronostique(Long id) {
		return TODO;
	}

}
