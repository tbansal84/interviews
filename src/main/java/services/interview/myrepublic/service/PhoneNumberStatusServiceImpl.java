package services.interview.myrepublic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.interview.myrepublic.domain.PhoneNumberDomainService;
import services.interview.myrepublic.domain.exceptions.PhoneServiceDomainException;
import services.interview.myrepublic.domain.vo.PhoneNumberDTO;
import services.interview.myrepublic.service.exceptions.PhoneServiceException;

@Service
public class PhoneNumberStatusServiceImpl implements PhoneNumberStatusService {
	@Autowired
	PhoneNumberDomainService phoneNumberDomainService;

	private static Logger logger = LoggerFactory.getLogger(PhoneNumberStatusServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.service.PhoneNumberStatusService#updateStatus(
	 * java.lang.String, java.lang.String)
	 */
	public void updateStatus(String phoneNumber, String status) throws PhoneServiceException {
		PhoneNumberDTO phoneNumberVO = new PhoneNumberDTO(phoneNumber, status);
		try {
			phoneNumberDomainService.update(phoneNumberVO);
		} catch (PhoneServiceDomainException e) {
			logger.error(e.getMessage(), e);
			throw new PhoneServiceException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.service.PhoneNumberStatusService#getStatus(java
	 * .lang.String)
	 */
	public String getStatus(String phoneNumber) throws PhoneServiceException {
		String status = null;
		try {
			PhoneNumberDTO phoneNumberVO = phoneNumberDomainService.get(phoneNumber);
			if (phoneNumberVO != null) {
				status = phoneNumberVO.getStatus();
			}
		} catch (PhoneServiceDomainException e) {
			logger.error(e.getMessage(), e);
			throw new PhoneServiceException();
		}
		return status;

	}

}
