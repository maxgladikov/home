package com.gladikov.home.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gladikov.home.model.Account;

public interface AccountRepository extends CrudRepository<Account,Long>{
	Optional<Account> findByUserName(String userName);
}


