package DoctorApplication.Exception;

public class DoctorExistedException extends Exception{
	
	public DoctorExistedException() {
		super("doctor already exists in database");
	}
}
