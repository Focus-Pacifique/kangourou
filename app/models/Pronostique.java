package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Pronostique extends Model {

	@Id
	public Long id;
	
	@ManyToOne
    @JoinColumn(name="matche")
	public Matche matche;
	
	@ManyToOne
    @JoinColumn(name="utilisateur")
	public Utilisateur utilisateur;
	
	@Column(name="pronoEquipe1")
	public Integer pronoEquipe1;
	
	@Column(name="pronoEquipe2")
	public Integer pronoEquipe2;
	
	@Column(name="calcule")
	public Boolean calcule;
	
	public Boolean getCalcule() {
		return calcule;
	}
	public void setCalcule(Boolean calcule) {
		this.calcule = calcule;
	}

	public static Finder<Long,Pronostique> find = new Finder(
		    Long.class, Pronostique.class
		  );
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Matche getMatche() {
		return matche;
	}
	public void setMatche(Matche matche) {
		this.matche = matche;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Integer getPronoEquipe1() {
		return pronoEquipe1;
	}
	public void setPronoEquipe1(Integer pronoEquipe1) {
		this.pronoEquipe1 = pronoEquipe1;
	}
	public Integer getPronoEquipe2() {
		return pronoEquipe2;
	}
	public void setPronoEquipe2(Integer pronoEquipe2) {
		this.pronoEquipe2 = pronoEquipe2;
	}
	
	public static void create(Pronostique pronostique){
		pronostique.save();
	}
	
	public static void update(Pronostique pronostique){
		pronostique.update();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	
}
