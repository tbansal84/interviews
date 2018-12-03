package services.interview.myrepublic.service;

import services.interview.myrepublic.service.exceptions.PhoneServiceException;

public interface PhoneNumberStatusService {

	void updateStatus(String phoneNumber, String status) throws PhoneServiceException;

	String getStatus(String phoneNumber) throws PhoneServiceException;

}