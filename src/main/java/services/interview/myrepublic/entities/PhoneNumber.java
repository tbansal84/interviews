package services.interview.myrepublic.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "PhoneNumbers")
@NamedQuery(name = "PhoneNumber.findAll", query = "SELECT p FROM PhoneNumber p")
public class PhoneNumber extends AuditEntity {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(nullable = false, length = 12)
	private String number;

	@Column(name = "created_by", nullable = false, length = 25)
	private String createdBy;

	@Column(name = "created_tm", nullable = false)
	private Timestamp createdTm;

	// bi-directional many-to-one association to NumberStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status", nullable = false)
	private NumberStatus status;
	
	@Version
    private Integer version;

	public PhoneNumber() {
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTm() {
		return createdTm;
	}

	public void setCreatedTm(Timestamp createdTm) {
		this.createdTm = createdTm;
	}

	public NumberStatus getStatus() {
		return status;
	}

	public void setStatus(NumberStatus status) {
		this.status = status;
	}


}
