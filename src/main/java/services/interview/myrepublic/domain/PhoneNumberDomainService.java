package services.interview.myrepublic.domain;

import services.interview.myrepublic.domain.exceptions.PhoneServiceDomainException;
import services.interview.myrepublic.domain.vo.PhoneNumberDTO;

public interface PhoneNumberDomainService {

	void update(PhoneNumberDTO phoneNumberVO) throws PhoneServiceDomainException;

	PhoneNumberDTO get(String phoneNumber) throws PhoneServiceDomainException;

}