package com.revise.code.service;

import java.util.List;

import com.revise.code.model.Items;

public interface ItemsService {

	public Items save(Items items);
	public  List<Items> findAll();
	public Items findById(int id);
	public void deleteById(int theId);
}
