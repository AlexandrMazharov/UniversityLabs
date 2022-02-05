package app.repos.rep;

import app.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepoitory extends  JpaRepository<Car , Long>{



}
