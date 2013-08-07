package controllers;

import java.util.Date;
import java.util.List;

import models.Matche;
import models.PointsSaison;
import models.Saison;
import models.Sys_parameter;
import models.Utilisateur;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.index;

@Authenticated(Secured.class)
public class Application extends Controller {

  
	  public static Result index() {
		  Date maintenant = new Date();
		  List<Matche> prochainMatchs = Matche.find.where().gt("dateMatche", maintenant).orderBy().asc("dateMatche").findList();
		  Matche prochainMatch=new Matche();
		  Utilisateur user = Utilisateur.findByPseudo(request().username());
		  Sys_parameter system = Sys_parameter.find.byId((long) 1);
		  Saison saison = system.getSaisonEnCours();
		  List<PointsSaison> pointsSaisons = PointsSaison.find.where().eq("saison", saison).orderBy().desc("pointsTotalSaison").findList();
		  Integer points = PointsSaison.find.where().eq("saison", saison).eq("user", user).findList().get(0).pointsTotalSaison;
		  if (prochainMatchs.isEmpty()){
			  prochainMatch=null;
		  } else {
			  prochainMatch = prochainMatchs.get(0);
		  }
		  
		  return ok(index.render(user,pointsSaisons,prochainMatch,points)
				  );
		  
	  }
  
}