package mybatis.services.user.impl;

import java.util.List;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;
import mybatis.services.user.UserService;

public class MyBatisUserServiceImpl12 implements UserService{
	
	private UserDAO userDAO;
	

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
		System.out.println("::" + getClass().getName());
	}

	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
		
	}

	@Override
	public User getUser(String user) throws Exception {
		
		return userDAO.getUser(user);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return userDAO.getUserList(user);
	}

}
