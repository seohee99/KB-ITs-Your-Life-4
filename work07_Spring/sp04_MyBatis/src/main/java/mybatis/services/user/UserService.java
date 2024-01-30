package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

public interface UserService {
	
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	// int removeUser(String user) throws Exception; remove는 service layer와 관계 없으므로 삭제

	User getUser(String user) throws Exception; // select가 가장 service layer와 연결됨
	List<User> getUserList(User user) throws Exception;

}
