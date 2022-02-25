package newbies.java16.crmapp.service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import newbies.java16.crmapp.dao.AuthDao;
import newbies.java16.crmapp.dto.UserLoginDto;

public class AuthService {
	private AuthDao dao;

	public AuthService() {
		dao = new AuthDao();
	}

	public boolean login(String email, String password) {
		UserLoginDto dto = null;
		try {
			dto = dao.login(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		if (dto == null) {
			return false;
		} else {
			return BCrypt.checkpw(password,BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()) );
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
