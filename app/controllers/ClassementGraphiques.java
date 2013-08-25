package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import models.Equipe;
import models.Journee;
import models.Matche;
import models.PointsJournee;
import models.PointsSaison;
import models.Pronostique;
import models.Saison;
import models.Sys_parameter;
import models.Utilisateur;
import models.Sys_parameter;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import play.mvc.WebSocket.Out;
import views.html.pronosticsForm;
import views.html.index;
import views.html.otherPronostics;
import views.html.classementGraphique;

@Authenticated(Secured.class)
public class ClassementGraphiques extends Controller  {

	public static Result affiche() {
		Sys_parameter system = Sys_parameter.find.byId((long) 1);
		Saison saison = system.getSaisonEnCours();
		Journee premiereJournee = saison.getPremiereJournee();
		Journee derniereJournee= saison.getDerniereJournee();
		
		List<Journee> journeesPassees = Journee.find.where().le("id", derniereJournee.getId()).ge("id", premiereJournee.getId()).eq("calcule", 1).findList();
		
		List<Utilisateur> utilisateurs = Utilisateur.find.all();
		List<String> pointsGraphiques = new ArrayList<String>();
		
		
		for(Utilisateur user: utilisateurs) {
			String tempString="\nname: \'";
			String pseudo = user.getPseudo();
			tempString = tempString + pseudo;
			tempString = tempString + "\',\ndata: [";
			
			List<PointsJournee> pointsJournees = PointsJournee.find.where().eq("user", user).orderBy().asc("journee").findList();
			int i=0;
			int totalPoints=0;
			for(PointsJournee pointsJournee: pointsJournees) {
				if (i!= 0) {
					tempString = tempString + ", ";
				}
				totalPoints=totalPoints + pointsJournee.getPoints();
				tempString = tempString + totalPoints;
				i++;
			}
			
			tempString = tempString + "]\n";
			if(totalPoints!=0){
				pointsGraphiques.add(tempString);
			}
		}
		
		return ok(
		classementGraphique.render(journeesPassees, pointsGraphiques)
		);
	}
}