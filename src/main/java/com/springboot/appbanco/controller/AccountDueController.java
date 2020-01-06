package com.springboot.appbanco.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.appbanco.model.AccountDue;
import com.springboot.appbanco.service.IAccountDueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api(tags = "AccountDue")
@RestController
public class AccountDueController {

	@Autowired
	IAccountDueService service;
	
	@PostMapping("/Create")
	private Mono<AccountDue> add (@RequestBody AccountDue accD){
		
		return service.create(accD);
	}
	
	@GetMapping("/searchByDocNumber/{docNum}")
	private Flux<AccountDue> searchByDocNumber (@PathVariable String docNum){
		
		return service.findByDocumentNumber(docNum);
	}
	
	
	
	@ApiOperation(value = "Search all AccountDue", notes = "Returning AccountDues.")
	  @GetMapping("/SearchAll")
	  public Flux<AccountDue> findAll() {
	    return service.findAll();
	  }

	  @GetMapping("/SearchById/{id}")
	  public Mono<AccountDue> findById(@PathVariable String id) {
	    return service.findById(id);
	    
	  }

	  @PutMapping("/Edit/{id}")
	  public Mono<AccountDue> update(@RequestBody AccountDue accD, @PathVariable String id) {
	    return service.update(accD, id);
	  }

	  @DeleteMapping("/Remove/{id}")
	  public Mono<Void> delete(@PathVariable String id) {
	    return service.delete(id);
	  }
	
}
