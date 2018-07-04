package com.kshrd.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.demo.model.Role;
import com.kshrd.demo.model.User;

@Repository
public interface UserRepository {

	@Select("SELECT * FROM tb_users WHERE email like #{email}")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="fullName", column="full_name"),
		@Result(property="roles", column="id", many=@Many(select="findRolesByUserId"))
		
	})
	public User loadUserByUsername(String email);
	
	@Select("SELECT r.id, r.role FROM tb_roles r INNER JOIN tb_user_roles ur ON ur.role_id=r.id WHERE ur.user_id = #{id}")
	public List<Role> findRolesByUserId(int id);
	
}
