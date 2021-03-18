package com.saveo.package1.MedicalApp.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saveo.package1.MedicalApp.models.*;
import com.saveo.package1.MedicalApp.repositories.*;

@Service
public class MedicineServices {
	
	@Autowired
	private MedicineRepository repository;

	String l = "";

	public void saveMedicine() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Product list - Sheet1.csv"));
			int iteration = 0;
			while ((l = reader.readLine()) != null) {
				
				if (iteration == 0) {
					iteration++;
					continue;
				}
				
				iteration++;
				String[] data = l.split(",");
				String sDate = data[2];
				String[] date = sDate.split("/");
				int day = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);
				int year = Integer.parseInt(date[2]);

				
				LocalDate d = LocalDate.of(year, month, day);
				Medicine medicine = new Medicine();
				
				medicine.setName(data[0]);
				medicine.setBatchNo(data[1]);
				medicine.setExpiryDate(d);
				medicine.setBalanceQty(Integer.parseInt(data[3]));
				medicine.setPackaging(data[4]);
				medicine.setUniqueCode(data[5]);
				medicine.setSchemes(data[6]);
				medicine.setMrp(Double.parseDouble(data[7]));
				medicine.setManufacturer(data[8]);
				medicine.setHsnCode(data[9]);
				
				
				repository.save(medicine);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public List<String> searchMedicine(String value) {
		List<Medicine> medicines = repository.findByNameStartsWith(value);
		List<String> names = new ArrayList<>();
		for (Medicine m : medicines) {
			names.add(m.getName());
		}

		return names;
	}

	
	public List<Medicine> getMedicines(String id) {
		return repository.findAllByuniqueCode(id);
	}

	
	public String orderMedicine(String quantity, String uniqueId) {
		
		List<Medicine> medicines = repository.findAllByuniqueCode(uniqueId);
		for (Medicine m : medicines) {
			
			if (Integer.parseInt(quantity) > m.getBalanceQty()) {
				return "No more medicine!!!";
			}
		}
		
		UUID uuid = UUID.randomUUID();

		return "Your order id is: " + uuid.toString();
	}
}

