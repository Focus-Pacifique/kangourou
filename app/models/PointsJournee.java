package models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity 
public class PointsJournee extends Model{

	@OneToOne
    @JoinColumn(name = "utilisateur")
    public Utilisateur user;
    
    @OneToOne
    @JoinColumn(name = "journee")
    public Journee journee;
    
    @Column(name = "points")
    public Integer points;
    
    public Utilisateur getUser() {
    	return this.user;
    }
    
    public Journee getJournee() {
    	return this.journee;
    }
    
    public Integer getPoints() {
    	return this.points;
    }
    
    public static Finder<Long,PointsJournee> find = new Finder<Long,PointsJournee>(Long.class, PointsJournee.class);

}
