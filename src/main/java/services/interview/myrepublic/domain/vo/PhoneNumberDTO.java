package services.interview.myrepublic.domain.vo;

public class PhoneNumberDTO {

	public PhoneNumberDTO(String phoneNumber, String status) {
		super();
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	private String phoneNumber;
	private String status;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public PhoneNumberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
