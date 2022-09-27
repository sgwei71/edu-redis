package com.ibkcloud.eduredis;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.ibkcloud.eduredis.account.Account;
import com.ibkcloud.eduredis.account.AccountRepository;

//@Component
public class RedisRunner implements ApplicationRunner{
	
	@Autowired
	StringRedisTemplate redisTemplate;
	
	@Autowired
	AccountRepository accountRepository;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("sunggyu","growman");
		opsForValue.set("springboot","2.0");
		opsForValue.set("greeting","helloWorld");
		
		Account account = new Account();
		account.setEmail("sgwei71@gmail.com");
		account.setUsername("sunggyu");
		
		accountRepository.save(account);
		
		Optional<Account> findById = accountRepository.findById(account.getId());
		
		System.out.println(findById.get().getEmail());
		System.out.println(findById.get().getUsername());
	}
}

