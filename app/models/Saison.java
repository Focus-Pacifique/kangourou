package models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity 
public class Saison extends Model{
	
	@Id
    public Long id;
    
    @Column(name = "nomSaison")
    public String nom;
    
    @OneToOne
    @JoinColumn(name = "premiereJournee")
    public Journee journee1;
    
    @OneToOne
    @JoinColumn(name = "derniereJournee")
    public Journee journee38;
    
    public String getNom() {
    	return this.nom;
    }
    
    public Journee getPremiereJournee() {
    	return this.journee1;
    }
    
    public Journee getDerniereJournee() {
    	return this.journee38;
    }
    
    public static Finder<Long,Saison> find = new Finder<Long,Saison>(Long.class, Saison.class); 

    public static Saison findById(Long id) {
        return find.byId(id);
    }
	
	public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Saison e: Saison.find.orderBy("nom").findList()) {
            options.put(e.id.toString(), e.nom);
        }
        return options;
    }

}
