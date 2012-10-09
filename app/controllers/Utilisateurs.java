package controllers;

import java.util.List;

import models.Journee;
import models.Matche;
import models.Pronostique;
import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.inscription;
import views.html.membres;

@Authenticated(Secured.class)
public class Utilisateurs extends Controller {
	
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
            test.save();

            return redirect(routes.Authentification.login());  
        }
        //return redirect(routes.Authentification.login());  
    }
	
	public static Result inscription() {
		return ok(inscription.render(utilisateurForm));
	}
	
	public static Result membres() {
		Utilisateur user = Utilisateur.findByPseudo(request().username());
		List<Utilisateur> listUser = Utilisateur.find.all();
		return ok(membres.render(user,listUser));
	}
	

}
