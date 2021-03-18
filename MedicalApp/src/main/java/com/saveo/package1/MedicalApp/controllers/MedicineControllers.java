package com.saveo.package1.MedicalApp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saveo.package1.MedicalApp.models.*;
import com.saveo.package1.MedicalApp.services.*;
import com.saveo.package1.MedicalApp.services.MedicineServices;


@RestController
public class MedicineControllers {
	
	@Autowired
	private MedicineServices serv;
	
	
	@RequestMapping("/uploadCSV")
	public void saveMedicine() {
		serv.saveMedicine();
		}
	
	
	@RequestMapping("/searchMedicine/{value}")
	public List<String> searchMedicine(@PathVariable String value) {
		return serv.searchMedicine(value);
	}
	
	
	@RequestMapping("/getMedicineDetails/{uniqueId}")
	public List<Medicine> getMedicine(@PathVariable String uniqueId){
		return serv.getMedicines(uniqueId);
	}
	
	
	@PostMapping("/placeorder")
	
	public String orderMedicine(@RequestBody Map<String, Object> payload) {
		return serv.orderMedicine(payload.get("quantity").toString(),payload.get("c_unique_id").toString());
	}
	
}
