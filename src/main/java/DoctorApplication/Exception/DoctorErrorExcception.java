package DoctorApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DoctorErrorExcception {
	
	@ResponseBody
	@ExceptionHandler(DoctorNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String doctorNotFoundHandler(DoctorNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(DoctorExistedException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	String doctorExistedHandler(DoctorExistedException ex) {
		return ex.getMessage();
	}

}
