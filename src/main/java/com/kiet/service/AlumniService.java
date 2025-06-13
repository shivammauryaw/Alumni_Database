package com.kiet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.model.Alumni;
import com.kiet.repository.AlumniRepository;


@Service
public class AlumniService {
	
	private AlumniRepository repository;

	public AlumniService(AlumniRepository repository) {
		super();
		this.repository = repository;
	
	}

	public List<Alumni> retrieveAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Alumni retrieveById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public Alumni addFeedback(Alumni alumni) {
		// TODO Auto-generated method stub
		return repository.save(alumni);
	}

	public void removebyid(int id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
	}
	
	 public List<Alumni> retrieveByBatch(String batch) {
	        return repository.findByBatch(batch);
	    }

    // Add this method to get distinct batches
    public List<String> getAllBatches() {
        return repository.findAll().stream()
                .map(Alumni::getBatch)
                .distinct()
                .toList();
    }


}
