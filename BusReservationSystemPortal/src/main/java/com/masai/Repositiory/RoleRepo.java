package com.masai.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.Entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
