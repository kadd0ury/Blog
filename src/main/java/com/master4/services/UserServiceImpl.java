package com.master4.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.master4.entities.User;
import com.master4.exceptions.ResourceNotFoundException;
import com.master4.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userrepository ;

	@Override
    @Transactional
	public Page<User> getAllUsers(Optional<Integer> pageNo, Integer pageSize, String sortBy) {

		
		Pageable paging =PageRequest.of(0, pageSize, Sort.by(sortBy));
        if(pageNo.isPresent()){
             paging = PageRequest.of(pageNo.get(), pageSize, Sort.by(sortBy));
        }
        return userrepository.findAll(paging);
		
		
		
	}

	@Override
    @Transactional
	public List<User> getAllUsers() {
		return userrepository.findAll();
	}

	@Override
    @Transactional
    
	public User findById(long id) throws ResourceNotFoundException {
		 return userrepository.findById(id).orElseThrow(
	                ()->new ResourceNotFoundException(id)
	        );
		
	}

	@Override
    @Transactional
	public void save(User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setCreated(timestamp);
        userrepository.save(user);

		
	}
	@Override
    @Transactional
	public void deleteById(long id) {
		userrepository.deleteById(id);
	}
}
