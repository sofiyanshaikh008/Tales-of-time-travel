package com.masai.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByUserName(String username);
}
