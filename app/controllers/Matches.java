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
import views.html.inscription;
import views.html.admin;

@Authenticated(Secured.class)
public class Matches extends Controller {
	
	static Form<Matche> matcheForm = form(Matche.class);
	

	public static Result admin() {		
		
		Utilisateur user = Utilisateur.findByPseudo(request().username());
		
		/***************************************************/
		/*  RAJOUTER LES MATCHS PAR JOURNEE ET PAS TOUS   */		
		/*************************************************/
		
		List<Matche> matches = Matche.find.all();
		
		return ok(
		admin.render(matches,user,matcheForm)
		);		
	}
	
	public static Result ajoutMatche() {
	
		Utilisateur user = Utilisateur.findByPseudo(request().username());
        Form<Matche> filledForm = matcheForm.bindFromRequest();
        System.out.println(filledForm.toString());
       if(filledForm.hasErrors()) {
    	   return redirect(
					routes.Application.index()
			);
        } else {
            Matche matche = filledForm.get();
			matche.save();
			return redirect(routes.Matches.admin());  
        }
    }
	
	public static Result setResultats(String idMatche) {
		Form<Matche> filledForm = matcheForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return redirect(
					routes.Application.index()
			);
		} else {
			Matche matcheBase = Matche.findById(Long.parseLong(idMatche));
			Matche matche = filledForm.get();
			matche.id = matcheBase.getId();
			if(matche.getScoreEquipe1() > matche.getScoreEquipe2()) {
				matche.setVainqueur(matcheBase.getEquipe1());
			} else if(matche.getScoreEquipe1() < matche.getScoreEquipe2()){
				matche.setVainqueur(matcheBase.getEquipe2());
			}
			Matche.update(matche);
				
			return redirect(routes.Matches.admin());
			
		}
	}
}
