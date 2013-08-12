package models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity 
public class PointsSaison extends Model{

	@ManyToOne
    @JoinColumn(name = "utilisateur")
    public Utilisateur user;
    
    @ManyToOne
    @JoinColumn(name = "saison")
    public Saison saison;
    
    @Column(name = "pointsTotalSaison")
    public Integer pointsTotalSaison;

    @Column(name = "nbFoisPremier")
    public Integer nbFoisPremier;
    
    @Column(name = "totalScoresCorrects")
    public Integer totalScoresCorrects;
    
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
    
    public Integer getTotalScoresCorrects() {
    	return this.totalScoresCorrects;
    }
    
    public void setPointsTotalSaison(Integer points) {
    	this.pointsTotalSaison=points;
    }
    
    public void setNbFoisPremier(Integer nbFoisPremier) {
    	this.nbFoisPremier=nbFoisPremier;
    }
    
    public void setTotalScoresCorrects(Integer totalScoresCorrects) {
    	this.totalScoresCorrects=totalScoresCorrects;
    }
    
    public static void update(PointsSaison pointsSaison){
    	pointsSaison.update();
	}
    
    public void ajouterPointsTotalSaison(Integer points) {
    	this.setPointsTotalSaison(this.pointsTotalSaison + points);
		PointsSaison.update(this);
	}
    
    public void incrementerNbFoisPremier() {
    	this.setNbFoisPremier(this.nbFoisPremier + 1);
		PointsSaison.update(this);
	}
    
    public void incrementerTotalScoresCorrects() {
    	this.setTotalScoresCorrects(this.totalScoresCorrects + 1);
		PointsSaison.update(this);
	}
    
    public static Finder<Long,PointsSaison> find = new Finder<Long,PointsSaison>(Long.class, PointsSaison.class);

}
