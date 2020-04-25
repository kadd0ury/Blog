package com.master4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.master4.entities.User;
import com.master4.exceptions.ResourceNotFoundException;

public interface UserService {
	
    public Page<User> getAllUsers(Optional<Integer> pageNo, Integer pageSize, String sortBy);
    public List<User> getAllUsers();

    User findById(long id) throws ResourceNotFoundException;

    void save(User user);

    void deleteById(long id);

    //User findByIdWithTags(@Param("id") long id);
	
	

}
