package com.example.userServices.Repository;

import com.example.userServices.Entaties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    public Optional<User> findByEmailAndPassword(String email, String password);
}
