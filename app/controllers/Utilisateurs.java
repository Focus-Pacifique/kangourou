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
            test.image = "images/inconnu.jpg";
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
		Sys_parameter system = Sys_parameter.find.byId((long) 1);
		Saison saison = system.getSaisonEnCours();
		Integer points = PointsSaison.find.where().eq("saison", saison).eq("user", user).findList().get(0).pointsTotalSaison;
		return ok(membres.render(user,listUser,points));
	}
	
	public static Result profil() {
		Utilisateur user = Utilisateur.findByPseudo(request().username());
		Sys_parameter system = Sys_parameter.find.byId((long) 1);
		Saison saison = system.getSaisonEnCours();
		Integer points = PointsSaison.find.where().eq("saison", saison).eq("user", user).findList().get(0).pointsTotalSaison;
		return ok(profilUtilisateur.render(user,utilisateurForm,points));
	}
	
	public static Result updateProfil(String pseudo) {
		Form<Utilisateur> filledForm = utilisateurForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return redirect(
				routes.Application.index()
			);
		} else {
			Utilisateur user = filledForm.get();
			Utilisateur userBase = Utilisateur.findByPseudo(pseudo);
			if(null!=user.getEmail() && user.getEmail()!=userBase.getEmail()) {
				userBase.setEmail(user.getEmail());
			}
			if(null!=user.getNom() && user.getNom()!=userBase.getNom()) {
				userBase.setNom(user.getNom());
			}
			if(null!=user.getPrenom() && user.getPrenom()!=userBase.getPrenom()) {
				userBase.setPrenom(user.getPrenom());
			}
			if(null!=user.getPassword() && user.getPassword()!=userBase.getPassword()) {
				userBase.setPassword(user.getPassword());
			}
			Utilisateur.update(userBase);
			return redirect(routes.Utilisateurs.profil());
			
		}
	}
}
