package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import controllers.routes;

import play.data.format.Formats.NonEmpty;
import play.data.validation.Constraints.Required;


import play.db.ebean.Model;
import play.mvc.Result;

@Entity 
public class Utilisateur extends Model{
	
	@Id
	@Required
    @Column
    public String pseudo;
	
	@Required
	@Column(name = "nom")
    public String nom;
    
    @Required
	@Column(name = "prenom")
    public String prenom;
	
    @Required
	@Column(name = "email")
    public String email;
    
	@Column(name = "points")
    public Integer points;
    
	@Required
	@Column(name = "password")
    public String password;
	
	@Column(name = "image")
    public String image = "";
    
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public static Finder<Long,Utilisateur> find = new Finder<Long,Utilisateur>(Long.class, Utilisateur.class); 

    public static Utilisateur findByPseudo(String pseudo) {
        return find.where().eq("pseudo", pseudo).findUnique();
    }
    
    public static Utilisateur authenticate(String login, String password) {
        return find.where()
            .eq("pseudo", login)
            .eq("password", password)
            .findUnique();
    }
    
    public String toString() {
        return "User(" + pseudo + ")";
    }
    
	public static void update(Utilisateur utilisateur){
		utilisateur.update();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public void ajouterPoints(Integer points, Utilisateur utilisateur) {
		utilisateur.setPoints(this.points + points);
		Utilisateur.update(utilisateur);
	}
}
