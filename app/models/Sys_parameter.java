package models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity 
public class Sys_parameter extends Model{
    
	@Id
	public Long id;
	
	@OneToOne
	@JoinColumn(name = "saisonEnCours")
    public Saison saisonEnCours;
    
    public Saison getSaisonEnCours() {
    	return this.saisonEnCours;
    }
    
    public static Finder<Long,Sys_parameter> find = new Finder<Long,Sys_parameter>(Long.class, Sys_parameter.class);

}
