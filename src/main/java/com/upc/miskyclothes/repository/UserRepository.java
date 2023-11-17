package com.upc.miskyclothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.upc.miskyclothes.entities.User;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
     @Query ("select u from User u where u.apellido like %:prefix%")
     public List<User> findByApellidoStartingWith(String prefix);

}
