package com.saveo.package1.MedicalApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saveo.package1.MedicalApp.models.*;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, String> {
	
	List<Medicine> findByNameStartsWith(String rating);
	List<Medicine> findAllByuniqueCode(String uniqueId);

}