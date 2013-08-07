package models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity 
public class PointsSaison extends Model{

	@OneToOne
    @JoinColumn(name = "utilisateur")
    public Utilisateur user;
    
    @OneToOne
    @JoinColumn(name = "saison")
    public Saison saison;
    
    @Column(name = "pointsTotalSaison")
    public Integer pointsTotalSaison;

    @Column(name = "nbFoisPremier")
    public Integer nbFoisPremier;
    
    public Utilisateur getUser() {
    	return this.user;
    }
    
    public Saison getSaison() {
    	return this.saison;
    }
    
    public Integer getPointsTotalSaison() {
    	return this.pointsTotalSaison;
    }
    
    public Integer getNbFoisPremier() {
    	return this.nbFoisPremier;
    }
    
    public static Finder<Long,PointsSaison> find = new Finder<Long,PointsSaison>(Long.class, PointsSaison.class);

}
