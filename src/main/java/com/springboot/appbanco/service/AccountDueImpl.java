package com.springboot.appbanco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.appbanco.model.AccountDue;
import com.springboot.appbanco.repo.IAccountDueRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class AccountDueImpl implements IAccountDueService{

	@Autowired
	private IAccountDueRepo repo;
	
	@Override
	public Mono<AccountDue> create(AccountDue accD) {
		return repo.save(accD);
	}

	@Override
	public Flux<AccountDue> findByDocumentNumber(String doc) {
		return repo.findBydocumentNumber(doc);
	}

	@Override
	public Flux<AccountDue> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<AccountDue> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<AccountDue> update(AccountDue accDueD, String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).flatMap(ac-> {
			ac.setBankName(accDueD.getBankName());
			return Mono.just(ac);
		});
	}

	@Override
	public Mono<Void> delete(String id) {
		 return repo.findById(id).flatMap(client -> repo.delete(client));
	}

}
