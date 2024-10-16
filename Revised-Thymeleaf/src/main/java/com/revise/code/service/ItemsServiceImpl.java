package com.revise.code.service;

import java.util.List;
import java.util.Optional;

import com.revise.code.dao.ItemsRepository;
import com.revise.code.model.Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService {

	private ItemsRepository itemsRepository;
	
	@Autowired
	public ItemsServiceImpl(ItemsRepository myItemRepo)
	{
		this.itemsRepository =myItemRepo;
	}
	
	@Override
	public Items save(Items items) {
		// TODO Auto-generated method stub
		return itemsRepository.save(items);
	}

	@Override
	public List<Items> findAll() {
		
	 List<Items> itemList =	itemsRepository.findAll();
		return itemList;
	}

	@Override
	public Items findById(int id) {
	  Optional<Items> singItem  = itemsRepository.findById(id);
	  
	  Items item=null;
	  
	  if(singItem.isPresent())
	  {
		  item =singItem.get();
	  }else
	  {
		  throw new RuntimeException("Items not found with it "+id);
		  }
		return item;
	}

	@Override
	public void deleteById(int theId) {
		
		itemsRepository.deleteById(theId);		
	}

}
