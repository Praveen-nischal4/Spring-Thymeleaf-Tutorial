package com.revise.code.dao;

import com.revise.code.model.Items;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
