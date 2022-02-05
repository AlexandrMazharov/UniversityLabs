package app.repos.rep;

import app.entity.UserTaxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTaxiRepository extends JpaRepository<UserTaxi, Long> {
    Optional<UserTaxi> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByUserEmail(String email);

}
