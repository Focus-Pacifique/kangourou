package controllers;

import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.login;

public class Authentification extends Controller {

    public static class AuthenticatedUtilisateur {

        public String pseudo;
        public String password;

        public String getPseudo() {
			return pseudo;
		}

		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String validate() {
            if(Utilisateur.authenticate(pseudo, password) == null) {
            	
                return "Informations incorrecte " + pseudo + " " + password;
            }
            return null;
        }
    }

    public static Result login() {
        return ok(
            login.render(form(AuthenticatedUtilisateur.class))
        );
    }


    public static Result authenticate() {
        Form<AuthenticatedUtilisateur> loginForm = form(AuthenticatedUtilisateur.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("pseudo", loginForm.get().pseudo);
            return redirect(
                routes.Application.index()
            );
        }
    }

    //Fermer la session
    public static Result logout() {
        session().clear();
        flash("success", "Vous êtes déconnecté(e)");
        return redirect(
            routes.Authentification.login()
        );
    }

}
