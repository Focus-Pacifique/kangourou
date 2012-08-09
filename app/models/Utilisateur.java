package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.Formats.NonEmpty;
import play.data.validation.Constraints.Required;


import play.db.ebean.Model;

@Entity 
public class Utilisateur extends Model{
	
	@Id
    @NonEmpty
    @Column
    public String pseudo;
	
    @NonEmpty
	@Column(name = "nom")
    public String nom;
    
    @NonEmpty
	@Column(name = "prenom")
    public String prenom;
	
    @NonEmpty
	@Column(name = "email")
    public String email;
    
	@Column(name = "points")
    public Integer points;
    
	@NonEmpty
	@Column(name = "password")
    public String password;
    
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

}
