package controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import models.Matche;
import models.PointsSaison;
import models.Saison;
import models.Sys_parameter;
import models.Utilisateur;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.index;
import views.html.upload;

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
	  	  
	  public static Result upload() throws IOException {
		  play.mvc.Http.MultipartFormData body = request().body().asMultipartFormData();
		  FilePart picture = body.getFile("picture");
		  if (picture != null) {
		    String fileName = picture.getFilename();
		    String contentType = picture.getContentType(); 
		    File file = picture.getFile();
		    
		        InputStream is = new FileInputStream(file);
		        BufferedInputStream bis = new BufferedInputStream(is);
		        OutputStream os = new BufferedOutputStream(new FileOutputStream("/home/transmission/" + fileName));
		        BufferedOutputStream bos = new BufferedOutputStream(os);
		        byte[] buffer = new byte[4096];
		        int readCount;
		        while( (readCount = bis.read(buffer)) > 0)
		        {
		              bos.write(buffer, 0, readCount);
		        }
		        bos.close();


		    return redirect(routes.Application.upload());
		  } else {
		    flash("error", "Missing file");
		    return redirect(routes.Application.index());
		  }
		}
	  public static Result affiche() {
		  Utilisateur user = Utilisateur.findByPseudo(request().username());
		  Sys_parameter system = Sys_parameter.find.byId((long) 1);
		  Saison saison = system.getSaisonEnCours();
		  Integer points = PointsSaison.find.where().eq("saison", saison).eq("user", user).findList().get(0).pointsTotalSaison;
		  return ok(upload.render(user, points));
	  }
  
}