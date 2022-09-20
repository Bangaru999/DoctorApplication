package DoctorApplication.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import DoctorApplication.Entity.Doctor;
import DoctorApplication.Repository.DoctorRepository;

@Service
public class DoctorService {
	
	public DoctorRepository repository;
	
	public Doctor saveDoctor( Doctor doctor) {
		return repository.save(doctor);
	}
	
	public List<Doctor> getAllDoctors(){
		return repository.findAll();
	}
	
	
}
