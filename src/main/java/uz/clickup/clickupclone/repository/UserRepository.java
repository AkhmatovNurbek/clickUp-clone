package uz.clickup.clickupclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.clickup.clickupclone.entity.AuthUser;
@Repository
public interface UserRepository extends JpaRepository<AuthUser , Long> {
  boolean existsByEmail(String email);
}