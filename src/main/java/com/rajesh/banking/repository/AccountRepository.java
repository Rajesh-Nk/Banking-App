package com.rajesh.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajesh.banking.entity.Account;

public interface AccountRepository extends JpaRepository< Account,Long  > {

}
