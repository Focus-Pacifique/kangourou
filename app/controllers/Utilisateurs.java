package controllers;

import models.Pronostique;
import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.inscription;

public class Utilisateurs extends Controller {
	
	static Form<Utilisateur> utilisateurForm = form(Utilisateur.class);
	
	public static Result save() {
        Form<Utilisateur> filledForm = utilisateurForm.bindFromRequest();
        System.out.println(filledForm.toString());
       if(filledForm.hasErrors()) {
            return badRequest(
                   // views.html.login.render()
            );
        } else {
            Utilisateur test = filledForm.get();
            test.points = 0;
            test.save();

            return redirect(routes.Authentification.login());  
        }
        //return redirect(routes.Authentification.login());  
    }
	
	public static Result inscription() {
		return ok(inscription.render(utilisateurForm));
	}

}
