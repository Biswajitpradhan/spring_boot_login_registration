package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailrEPO extends JpaRepository<Details, Integer>{
	
	Optional<Details> findByCardIdAndPassword(Integer cardid,String password);

	boolean existsByCardId(Integer value);

}
