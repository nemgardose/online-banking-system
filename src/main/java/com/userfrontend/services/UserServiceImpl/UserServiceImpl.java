package com.userfrontend.services.UserServiceImpl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.userfrontend.dao.RoleDao;
import com.userfrontend.dao.UserDao;
import com.userfrontend.model.User;
import com.userfrontend.model.security.UserRole;
import com.userfrontend.services.AccountService;
import com.userfrontend.services.UserService;

import jdk.internal.org.jline.utils.Log;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	private AccountService accountService;
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public User createUser(User user, Set<UserRole> userRoles) {
		
		User localUser = userDao.findByUsername(user.getUsername());
		
		if(localUser != null) {
			Log.info("User with username {} already exists. Nothing will be done ", user.getUsername());
		} else {
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			
			for(UserRole ur: userRoles) {
				roleDao.save(ur.getRole());
			}
			
            user.getUserRoles().addAll(userRoles);

            user.setPrimaryAccount(accountService.createPrimaryAccount());
            user.setSavingsAccount(accountService.createSavingsAccount());

            localUser = userDao.save(user);
		}
		
		return localUser;
		
	}
	
	public boolean checkUserExists(String username, String email) {
		if(checkUsernameExists(username) || checkEmailExists(email)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkUsernameExists(String username) {
		if(findByUsername(username) != null) {
			return true;
		}
		return false;
	}
	
	public boolean checkEmailExists(String email) {
		if(findByEmail(email) != null) {
			return true;
		}
		return false;
	}
	
    public User saveUser (User user) {
        return userDao.save(user);
    }
}
