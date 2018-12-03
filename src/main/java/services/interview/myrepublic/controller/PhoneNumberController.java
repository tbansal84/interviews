package services.interview.myrepublic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import services.interview.myrepublic.service.PhoneNumberStatusService;
import services.interview.myrepublic.service.exceptions.PhoneServiceException;

@RestController
@RequestMapping("/phone/number")
public class PhoneNumberController {

	@Autowired
	private PhoneNumberStatusService phoneNumberService;

	@GetMapping(path = "/status/get/{number}")
	public String getStatus(@PathVariable("number") final String number) {
		try {
			return phoneNumberService.getStatus(number);
		} catch (PhoneServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
 
	@PutMapping(path = "/status/update/{number}/{status}")
	public void updateStatus(@PathVariable("number") final String number, @PathVariable("status") final String status) {
		try {
			phoneNumberService.updateStatus(number, status);
		} catch (PhoneServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Convert a predefined exception to an HTTP Status code
	  @ResponseStatus(value=HttpStatus.CONFLICT,
	                  reason="Data integrity violation")  // 409
	  @ExceptionHandler(PhoneServiceException.class)
	  public void conflict() {
	    // Nothing to do
	  }

}
