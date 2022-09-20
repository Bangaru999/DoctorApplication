package DoctorApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class DoctorNotFoundException  extends Exception{
	
	public DoctorNotFoundException(Integer id) {
		super("Doctor not found with id"+id);
	}

}
