package org.covn.repository;

import org.covn.model.db.UserResponseExt;
import org.covn.model.db.UserResponseExtIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponseExtRepository extends JpaRepository<UserResponseExt, UserResponseExtIdentity> { 

}
