package com.springboot.appbanco.repo;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.appbanco.model.AccountDue;

import reactor.core.publisher.Flux;

@Repository
public interface IAccountDueRepo extends ReactiveMongoRepository<AccountDue,String>{

	public Flux<AccountDue> findBydocumentNumber(String docNumber);
	
}
