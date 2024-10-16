package com.revise.code.controller;

import java.util.Arrays;
import java.util.List;


import com.revise.code.model.Items;
import com.revise.code.service.ItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/items")
public class ItemController {
	
private ItemsService itemsService;
	
      @Value("${category}")
      private List<String> categoryString;

	@Autowired
	public ItemController(ItemsService theitemService)
	{
		this.itemsService = theitemService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor stringTimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTimmerEditor);
	}
	
	
	

	@GetMapping("/showForm")
	public String getItemsForm(Model model)
	{
		Items item = new Items();
		model.addAttribute("items",item);
		
		//adding ategories
		//List<String> categories = Arrays.asList(categoryString.split(","));
		model.addAttribute("category", categoryString);
		
		return "views/items-form";
	}
	
	@GetMapping("/list")
	public String getEmployees(Model model) {
		
		List<Items> itemList =  itemsService.findAll();		
		model.addAttribute("items", itemList);                                     //add data to the model
		
		return "views/list-item";
	}
	
	 @PostMapping("/save")
	 @Transactional
	    public String saveItems(@Valid @ModelAttribute("items") Items item, BindingResult bindingResult,Model  model) {
	       
		 model.addAttribute("category", categoryString);
	        if (bindingResult.hasErrors()) {
	            return "views/items-form";
	        } else {
	           
	        	model.addAttribute("category", categoryString);
	    	
	        	itemsService.save(item);
	            return "redirect:/items/list";
	        }
	    }
	 
	 @GetMapping("/updateData")
	 public String updateData(@RequestParam("itemId") int itemId ,Model model)
	 {
	
		 model.addAttribute("category", categoryString);
		 Items items = itemsService.findById(itemId);
		 model.addAttribute("items", items);
		 return "/views/items-form";
	 }
	 
	 @Transactional
	 @GetMapping("/deleteData")
	 public String deleteData(@RequestParam("itemId") int itemId)
	 {
		 itemsService.deleteById(itemId);
		 return "redirect:/items/list";
	 }
}
