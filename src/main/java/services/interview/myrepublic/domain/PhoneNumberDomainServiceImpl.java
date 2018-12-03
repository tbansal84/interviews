package services.interview.myrepublic.domain;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import services.interview.myrepublic.domain.exceptions.PhoneServiceDomainException;
import services.interview.myrepublic.domain.vo.PhoneNumberDTO;
import services.interview.myrepublic.entities.NumberStatus;
import services.interview.myrepublic.entities.PhoneNumber;
import services.interview.myrepublic.entities.PhoneNumberMapper;
import services.interview.myrepublic.repository.PhoneNumberRepository;
import services.interview.myrepublic.repository.PhoneNumberStatusRepository;

@Service
public class PhoneNumberDomainServiceImpl implements PhoneNumberDomainService {
	@Autowired
	PhoneNumberRepository phoneNumberRepository;
	@Autowired
	PhoneNumberStatusRepository phoneNumberStatusRepository;

	@Autowired
	PhoneNumberMapper phoneNumberMapper;

	private static Logger logger = LoggerFactory.getLogger(PhoneNumberDomainServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.domain.PhoneNumberDomainService#update(services
	 * .interview.myrepublic.domain.vo.PhoneNumberVO)
	 */
	@CachePut(value = "phonenumbers", key = "#phoneNumberDTO.phoneNumber")
	public void update(PhoneNumberDTO phoneNumberDTO) throws PhoneServiceDomainException {

		try {
			Optional<NumberStatus> o = phoneNumberStatusRepository.findById(phoneNumberDTO.getStatus());
			NumberStatus status = null;
			if (o.isPresent()) {
				status = o.get();
			}
			PhoneNumber phoneNumber = null;
			if (status != null) {
				Optional<PhoneNumber> o1 = phoneNumberRepository.findById(phoneNumberDTO.getPhoneNumber());
				if (o.isPresent()) {
					phoneNumber = o1.get();
					phoneNumber.setStatus(status);
				}
			} else {
				throw new PhoneServiceDomainException("Status could not be found");
			}
			phoneNumberRepository.save(phoneNumber);
		} catch (Exception e) {
			logger.error("Exception" + e.getMessage());
			throw new PhoneServiceDomainException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.domain.PhoneNumberDomainService#update(services
	 * .interview.myrepublic.domain.vo.PhoneNumberVO)
	 */
	@CachePut(value = "phonenumbers", key = "#phoneNumberDTO.phoneNumber")
	public void create(PhoneNumberDTO phoneNumberDTO) throws PhoneServiceDomainException {

		try {
			Optional<NumberStatus> o = phoneNumberStatusRepository.findById(phoneNumberDTO.getStatus());
			NumberStatus status = null;
			if (o.isPresent()) {
				status = o.get();
			}
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.setStatus(status);
			phoneNumberRepository.save(phoneNumber);
		} catch (Exception e) {
			logger.error("Exception" + e.getMessage());
			throw new PhoneServiceDomainException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.domain.PhoneNumberDomainService#get(java.lang.
	 * String)
	 */

	@Cacheable("phonenumbers")
	public PhoneNumberDTO get(String phoneNumber) throws PhoneServiceDomainException {
		PhoneNumber entity = null;
		try {
			Optional<PhoneNumber> o = phoneNumberRepository.findById(phoneNumber);
			if (o.isPresent()) {
				entity = o.get();
			}
		} catch (Exception e) {
			logger.error("Exception" + e.getMessage());
			throw new PhoneServiceDomainException();
		}
		return entity == null ? null : phoneNumberMapper.phoneNumberToPhoneNumberDTO(entity);

	}

}
