package blogPostApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blogPostApp.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
