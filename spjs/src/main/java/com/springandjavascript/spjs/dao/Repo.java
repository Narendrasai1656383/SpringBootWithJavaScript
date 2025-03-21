package com.springandjavascript.spjs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springandjavascript.spjs.entity.User;
@Repository
public interface Repo extends JpaRepository<User,String>{

}
