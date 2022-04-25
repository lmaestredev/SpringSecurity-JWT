package io.getarrays.userservice.repo;

import io.getarrays.userservice.domain.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Appuser, Long> {
    Appuser findByUsername(String username);
}
