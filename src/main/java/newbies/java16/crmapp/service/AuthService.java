package newbies.java16.crmapp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import newbies.java16.crmapp.dao.AuthDao;
import newbies.java16.crmapp.dto.UserLoginDto;
import newbies.java16.crmapp.model.User;

public class AuthService {
	private AuthDao dao;
	private User user;

	public AuthService() {
		dao = new AuthDao();
	}

	public User toUser(String email, String password) {
		UserLoginDto dto = null;
		try {
			dto = dao.login(email, password);
		} catch (SQLException e) {
			return user;
		}
		user = new User();
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setRole(dto.getRoleId());
		return user;
	}

	public boolean login(String email, String password) {
		UserLoginDto dto = null;
		try {
			dto = dao.login(email, password);
		} catch (SQLException e) {
			return false;
		}
		if (dto == null) {
			return false;
		} else {
			return BCrypt.checkpw(password, BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
		}
	}

	public boolean sigup(String email, String password, String name) {
		try {
			if (dao.checkUser(email)) {
				return dao.createUser(email, password, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
