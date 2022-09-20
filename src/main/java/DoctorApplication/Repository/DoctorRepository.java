package DoctorApplication.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import DoctorApplication.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	
Doctor findByName(String name);
}
