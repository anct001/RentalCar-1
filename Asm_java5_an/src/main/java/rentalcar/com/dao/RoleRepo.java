package rentalcar.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rentalcar.com.entity.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, String>{

}
