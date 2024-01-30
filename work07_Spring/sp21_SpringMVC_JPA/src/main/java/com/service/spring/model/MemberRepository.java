package com.service.spring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.spring.domain.Member;

/*
 * JpaRepository 제공하는 CRUD 기능
 * 
 * C, U : save() -- registerMember, updateMember
 * D : deleteMember()
 * R : count()
 * R : findAll() --- showAll()
 * 
 * -----------------------------------------------
 * 
 * login(id, password)
 * findByIdMember(String id)
 * String IdExist(String id)
 */
public interface MemberRepository extends JpaRepository<Member, String> {
	@Query(value = "select id from member where id=?", nativeQuery = true)
	String idExist(String id);
	
	@Query(value = "select id, password, name, address from member where id=?", nativeQuery = true)
	Member findByIdMember(String id);
	
	
	// jpql
	@Query("select m from Member m where m.id=:#{#member.id} AND m.password=:#{#member.password}")
	Member login(Member member);
}
