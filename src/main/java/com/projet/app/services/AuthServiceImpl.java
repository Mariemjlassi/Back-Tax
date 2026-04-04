package com.projet.app.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet.app.dto.SignUpRequest;
import com.projet.app.models.DBUser;
import com.projet.app.repository.DBUserRepository;
@Service
public class AuthServiceImpl implements AuthService{
	
	
	private final DBUserRepository dbUserRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public AuthServiceImpl(DBUserRepository dbUserRepository,PasswordEncoder passwordEncoder) {
		this.dbUserRepository = dbUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
    public DBUser createUser(SignUpRequest signupRequest) {
        
        if (dbUserRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }
        DBUser user = new DBUser();
        BeanUtils.copyProperties(signupRequest,user);

        
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        DBUser createdUser = dbUserRepository.save(user);
        user.setId(createdUser.getId());
        return user;
	
	}
	
}
