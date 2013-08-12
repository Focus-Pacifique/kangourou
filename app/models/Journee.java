package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.data.format.Formats.DateTime;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Journee extends Model{
	
	@Id
    public Long id;
	
	@Column(name="NomJournee")
	public String nomJournee;

	@OneToOne
	@JoinColumn(name="Matche1")
    public Matche matche1;

	@OneToOne
	@JoinColumn(name="Matche2")
    public Matche matche2;

	@OneToOne
	@JoinColumn(name="Matche3")
    public Matche matche3;

	@OneToOne
	@JoinColumn(name="Matche4")
    public Matche matche4;

	@OneToOne
	@JoinColumn(name="Matche5")
    public Matche matche5;

	@OneToOne
	@JoinColumn(name="Matche6")
    public Matche matche6;

	@OneToOne
	@JoinColumn(name="Matche7")
    public Matche matche7;

	@OneToOne
	@JoinColumn(name="Matche8")
    public Matche matche8;

	@OneToOne
	@JoinColumn(name="Matche9")
    public Matche matche9;

	@OneToOne
	@JoinColumn(name="Matche10")
    public Matche matche10;
    
    @DateTime(pattern="yyyy-MM-dd")
    @Column(name="dateJournee")
    public Date dateJournee;

	@Column(name="calcule")
	public Boolean calcule;
    
    public Long getId() {
    	return this.id;
    }
    
	public String getNomJournee() {
		return nomJournee;
	}

	public void setNomJournee(String nomJournee) {
		this.nomJournee = nomJournee;
	}
	
	public Boolean getCalcule() {
		return calcule;
	}

	public void setCalcule(Boolean bool) {
		this.calcule = bool;
	}

	public Matche getMatche1() {
		return matche1;
	}

	public void setMatche1(Matche matche1) {
		this.matche1 = matche1;
	}

	public Matche getMatche2() {
		return matche2;
	}

	public void setMatche2(Matche matche2) {
		this.matche2 = matche2;
	}

	public Matche getMatche3() {
		return matche3;
	}

	public void setMatche3(Matche matche3) {
		this.matche3 = matche3;
	}

	public Matche getMatche4() {
		return matche4;
	}

	public void setMatche4(Matche matche4) {
		this.matche4 = matche4;
	}

	public Matche getMatche5() {
		return matche5;
	}

	public void setMatche5(Matche matche5) {
		this.matche5 = matche5;
	}

	public Matche getMatche6() {
		return matche6;
	}

	public void setMatche6(Matche matche6) {
		this.matche6 = matche6;
	}

	public Matche getMatche7() {
		return matche7;
	}

	public void setMatche7(Matche matche7) {
		this.matche7 = matche7;
	}

	public Matche getMatche8() {
		return matche8;
	}

	public void setMatche8(Matche matche8) {
		this.matche8 = matche8;
	}

	public Matche getMatche9() {
		return matche9;
	}

	public void setMatche9(Matche matche9) {
		this.matche9 = matche9;
	}

	public Matche getMatche10() {
		return matche10;
	}

	public void setMatche10(Matche matche10) {
		this.matche10 = matche10;
	}

	public Date getDateJournee() {
		return dateJournee;
	}

	public void setDateJournee(Date dateJournee) {
		this.dateJournee = dateJournee;
	}
	
	

	public static Finder<Long,Journee> find = new Finder<Long,Journee>(Long.class, Journee.class); 

    public static Journee findById(Long id) {
        return find.byId(id);
    }
    
    public static List<Matche> findMatchesById(Long id) {
    	Journee journee = find.byId(id);
    	List<Matche> matches = new ArrayList<Matche>();
    	matches.add(journee.getMatche1());
    	matches.add(journee.getMatche2());
    	matches.add(journee.getMatche3());
    	matches.add(journee.getMatche4());
    	matches.add(journee.getMatche5());
    	matches.add(journee.getMatche6());
    	matches.add(journee.getMatche7());
    	matches.add(journee.getMatche8());
    	matches.add(journee.getMatche9());
    	matches.add(journee.getMatche10());
    	
    	return matches;
    }

}
