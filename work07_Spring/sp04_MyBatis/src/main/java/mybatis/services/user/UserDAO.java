package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

// Template 시능
/*
 * mybatis-userservice-mapping10.xml
 * 쿼리문 태그 id 값이 template 기능의 이름이 된다
 * 쿼리문 태그 parameterType이 Template 기능의 인자값
 * 쿼리문 태그 resultMap, resultType의 값이 template 기능의 리턴 타입과 연결
 */
public interface UserDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String user) throws Exception;

	User getUser(String user) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
