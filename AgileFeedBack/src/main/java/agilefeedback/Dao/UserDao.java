package agilefeedback.Dao;

import agilefeedback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    // méthodes personnalisées si besoin, ex :
    User findByEmail(String email);
}
