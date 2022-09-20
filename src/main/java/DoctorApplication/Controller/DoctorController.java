package DoctorApplication.Controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import DoctorApplication.Entity.Doctor;
import DoctorApplication.Exception.DoctorException;
import DoctorApplication.Exception.DoctorExistedException;
import DoctorApplication.Exception.DoctorNotFoundException;
import DoctorApplication.Repository.DoctorRepository;
import DoctorApplication.Service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@GetMapping("/doctor/all")
	public List<Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}
	
	@GetMapping("/doctor/{id}")
	Doctor getDoctor(@PathVariable Integer id) throws DoctorException, DoctorNotFoundException {
		return doctorRepository.findById(id).orElseThrow(()-> new DoctorNotFoundException(id));
	}
	
	
	@PostMapping("/doctor/save")
	public Doctor saveDoctor(@RequestBody Doctor doctor) throws DoctorExistedException {
		
		if(doctorRepository.existsById(doctor.getId())){
			throw new  DoctorExistedException();
		}
		return doctorRepository.save(doctor);
	}
	
	
	
	
	@PutMapping("/doctors/salary/{id}/{salary}")
	ResponseEntity<Doctor> updateSalary(@PathVariable Integer id, @PathVariable int salary) throws  DoctorNotFoundException, DoctorExistedException, DoctorException{
		Doctor d=getDoctor(id);
		/*if(doctorRepository.existsById(id)){
			throw new  DoctorExistedException();
		}*/
		d.setSalary(salary);
		doctorRepository.save(d);
		return ResponseEntity.ok(d);
	}
	
	@DeleteMapping("/delete/doctor/{id}")
	void deleteDoctor(@PathVariable Integer id) {
		doctorRepository.deleteById(id);
	}
	
	

	
	
	/*@GetMapping("/descending")
	public List<Doctor>getAllDoctorsDescendingBySalary(){
		List<Doctor> list= doctorRepository.findAll();
		list.sort(new Comparator() {
			public int Compare(Doctor d1, Doctor d2) {
				if(d2.getSalary()==d1.getSalary()) {
					//List<Doctor> s=doctorRepository.findAll(Sort.by(Sort.Direction.DESC, "salary"));
					List<Doctor> l= l.sort(Comparator.comparing(Doctor::getSalary).thenComparing(Doctor::getName));
					/return d1.getName().compareTo(d2.getName());
				}
				return (int)(d2.getSalary()-d1.getSalary());
			}
		@Override
		public int compare(Object d1, Object d2) {
			return 0;
		}
	});
		return list;

}*/
	@GetMapping("/desc")
	public List<Doctor>getAllDoctorsDescendingBySalary1(){
		List<Doctor> s=doctorRepository.findAll();
		//Function<Doctor, Integer> bySalary = Doctor::getSalary;
		//Function<Doctor, String> byName = Doctor::getName;
		
		//Comparator<Doctor> ltf = Comparator.comparing(Doctor::getSalary).thenComparing(Doctor::getName);
		//s.stream().sorted(ltf).forEach(System.out::println);
		
		return doctorRepository.findAll(Sort.by(Direction.DESC,"salary").and(Sort.by(Sort.Direction.ASC, "name")));
				}
	}

	


