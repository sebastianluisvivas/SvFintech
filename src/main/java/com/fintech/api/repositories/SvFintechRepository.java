package com.fintech.api.repositories;

import com.fintech.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SvFintechRepository extends JpaRepository<User, Long>  {

}
