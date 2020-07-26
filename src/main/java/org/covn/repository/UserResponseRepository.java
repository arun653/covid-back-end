package org.covn.repository;

import org.covn.model.db.UserResponse;
import org.covn.model.db.UserResponseIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponseRepository extends JpaRepository<UserResponse, UserResponseIdentity> { 

}
