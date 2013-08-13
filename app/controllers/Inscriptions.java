package controllers;

import java.io.File;
import java.util.List;

import models.Journee;
import models.Matche;
import models.PointsSaison;
import models.Pronostique;
import models.Saison;
import models.Sys_parameter;
import models.Utilisateur;
import play.api.mvc.MultipartFormData;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.inscription;
import views.html.membres;
import views.html.profilUtilisateur;

public class Inscriptions extends Controller {
	
	static Form<Utilisateur> utilisateurForm = form(Utilisateur.class);
	
	public static Result save() {
        Form<Utilisateur> filledForm = utilisateurForm.bindFromRequest();
        System.out.println(filledForm.toString());
       if(filledForm.hasErrors()) {
            return badRequest(
                  views.html.inscription.render(utilisateurForm)
            );
        } else {
            Utilisateur test = filledForm.get();
            test.points = 0;
            test.image = "images/inconnu.jpg";
            test.save();

            Sys_parameter system = Sys_parameter.find.byId((long) 1);
            Saison saison = system.getSaisonEnCours();

            PointsSaison pointsSaison = new PointsSaison();
            pointsSaison.user = test;
            pointsSaison.saison = saison;
            pointsSaison.pointsTotalSaison = 0;
            pointsSaison.nbFoisPremier = 0;
            pointsSaison.totalScoresCorrects= 0;
            pointsSaison.save();

            return redirect(routes.Authentification.login());  
        }
        //return redirect(routes.Authentification.login());  
    }
	
	public static Result inscription() {
		return ok(inscription.render(utilisateurForm));
	}
	
}
