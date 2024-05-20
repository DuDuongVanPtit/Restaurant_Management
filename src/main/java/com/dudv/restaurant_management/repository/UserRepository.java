package com.dudv.restaurant_management.repository;

import com.dudv.restaurant_management.entity.Role;
import com.dudv.restaurant_management.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByStatusAndEmail(Integer status, String email);
    List<UserEntity> findAll();
    List<UserEntity> findByRole(Role role);
    Optional<UserEntity> findById(Long id);
    void deleteById(Long id);
}
