package app.repos.rep;

import app.entity.UsedCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedCarRepository extends JpaRepository<UsedCar,Long> {
}
