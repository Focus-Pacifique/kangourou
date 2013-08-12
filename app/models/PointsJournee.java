package models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity 
public class PointsJournee extends Model{

	@ManyToOne
    @JoinColumn(name="utilisateur")
    public Utilisateur user;
    
	@ManyToOne
    @JoinColumn(name="journee")
    public Journee journee;
    
    @Column(name="points")
    public Integer points;
    
    @Column(name="scoresCorrects")
    public Integer scoresCorrects;
    
    public Utilisateur getUser() {
    	return this.user;
    }
    
    public Journee getJournee() {
    	return this.journee;
    }
    
    public Integer getPoints() {
    	return this.points;
    }
    
    public void setPoints(Integer points) {
    	this.points=points;
    }
    
    public Integer getScoresCorrects() {
    	return this.scoresCorrects;
    }
    
    public void setScoresCorrects(Integer scoresCorrects) {
    	this.scoresCorrects=scoresCorrects;
    }
    
    public static void update(PointsJournee pointsJournee){
    	pointsJournee.update();
	}
    
    public void ajouterPoints(Integer points) {
		this.setPoints(this.points + points);
		PointsJournee.update(this);
	}
    
    public void incrementerScoresCorrects() {
		this.setScoresCorrects(this.scoresCorrects + 1);
		PointsJournee.update(this);
	}
    
    public static Finder<Long,PointsJournee> find = new Finder(Long.class, PointsJournee.class);

}
