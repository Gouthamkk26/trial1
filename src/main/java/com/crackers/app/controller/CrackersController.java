package com.crackers.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crackers.app.dao.CrackersDao;
import com.crackers.app.model.Crackers;

@Controller
@SessionAttributes("category")
public class CrackersController 
{
	@Autowired
	CrackersDao crackersDao;

	@RequestMapping(value = "/ShowMenuItemListCustomer", method = RequestMethod.POST)
	public String showMenuItemsCustomer(ModelMap model,Crackers crackers,@RequestParam String category) 
	{
		List<Crackers> crackersItemsCustomer = crackersDao.getMenuItemsCustomer(category);
		model.put("category",category);
		model.put("crackersItemListCustomer", crackersItemsCustomer);	
		return "crackersItemsListCustomer";
	}
	
	
	@RequestMapping(value = "/ShowMenuItemListCustomer", method = RequestMethod.GET)
	public String showMenuItemsCustomer1(ModelMap model,@ModelAttribute("retrieve") Crackers crackers) 
	{
		String c=(String) model.get("category");
		List<Crackers> crackersItemsCustomer = crackersDao.getMenuItemsCustomer(c);
		model.put("crackersItemListCustomer", crackersItemsCustomer);	
		return "crackersItemsListCustomer";
	}
	
	
	@RequestMapping (value="/ShowMenuItemListCustomer1",method=RequestMethod.POST)
	public String showSortItems(ModelMap model,@RequestParam String sort,Crackers crackers)
	{
		if(sort.equals("asc"))
		{
			String c=(String) model.get("category");
			List<Crackers> crackerssort1=crackersDao.getSortItems(c);
			model.put("sort",crackerssort1);
			return "crackersItemsListCustomer";
		}
		else
		{
			String c=(String) model.get("category");
			List<Crackers> crackerssort1=crackersDao.getSortItems1(c);
			model.put("sort",crackerssort1);
			return "crackersItemsListCustomer";
		}
	}
}