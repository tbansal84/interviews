package services.interview.myrepublic.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * The persistent class for the PhoneNumbersHistory database table.
 * 
 */
@Entity
@Table(name="PhoneNumbersHistory")
@NamedQuery(name="PhoneNumbersHistory.findAll", query="SELECT p FROM PhoneNumbersHistory p")
public class PhoneNumbersHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false) 
	private long id;

	@Column(nullable=false, length=12)
	private String number;

	@Column(length=500)
	private String remarks;

	@Column(name="updated_by", nullable=false, length=25)
	private String updatedBy;

	@Column(name="updated_tm", nullable=false)
	private Timestamp updatedTm;

	//bi-directional many-to-one association to NumberStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status", nullable=false)
	private NumberStatus numberStatus;

	public PhoneNumbersHistory() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedTm() {
		return this.updatedTm;
	}

	public void setUpdatedTm(Timestamp updatedTm) {
		this.updatedTm = updatedTm;
	}

	public NumberStatus getNumberStatus() {
		return this.numberStatus;
	}

	public void setNumberStatus(NumberStatus numberStatus) {
		this.numberStatus = numberStatus;
	}

}