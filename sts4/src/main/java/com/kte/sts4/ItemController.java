package com.kte.sts4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kte.sts4.dao.V2_ItemDAO;
import com.kte.sts4.vo.V2_Item;
import com.kte.sts4.vo.V2_ItemList;

@Controller
@MapperScan("com.kte.sts4.dao")
public class ItemController {
	
	@Autowired V2_ItemDAO itemDAO = null;
	
	@RequestMapping(value="/mainitem.do", method=RequestMethod.GET)
	public String mainitem(Model model) {
		
		return "mainitem";
	}
	
	
	@RequestMapping(value="/deleteitem.do", method=RequestMethod.GET)
	public String deleteitem(Model model) {
		try {
			List<V2_Item> list = itemDAO.selectItemList();
			model.addAttribute("list", list);
			return "deleteitem";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:deleteitem.do";
		}
	}
	
	@RequestMapping(value="/deleteitem.do", method=RequestMethod.POST)
	public String deleteitem(@RequestParam("chk[]") String[] chk) {
		try {
			itemDAO.deleteBatch(Arrays.asList(chk));
			return "redirect:deleteitem.do";
		}
		catch(Exception e) {
			return "redirect:deleteitem.do";
		}
	}
	
	@RequestMapping(value="/insertitem.do", method = RequestMethod.GET)
	public String insertItem(Model model) {
		
		int no = itemDAO.lastNo();
		
		model.addAttribute("no", no);
		return "insertitem";
	}
	
	@RequestMapping(value="/insertitem.do", method = RequestMethod.POST)
	public String insertItem(
			@RequestParam("no[]") int[] no,
			@RequestParam("name[]") String[] name,
			@RequestParam("price[]") int[] price,
			@RequestParam("qty[]") int[] qty) {
		
		List<V2_Item> list = new ArrayList<V2_Item>();
		for(int i=0; i<no.length; i++) {
			V2_Item vo = new V2_Item(no[i], name[i], price[i], qty[i]);
			list.add(vo);
		}
		
		itemDAO.insertBatch(list);
		
		return "redirect:insertitem.do";
	}
	
	@RequestMapping(value="/updateitem.do", method = RequestMethod.GET)
	public String updateItem(Model model) {
		
		V2_ItemList vo = new V2_ItemList();
		vo.setList(itemDAO.selectItemList());
		model.addAttribute("vo", vo);
		return "updateitem";
	}
	
	@RequestMapping(value="/updateitem.do", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute("vo") V2_ItemList vo) {
		
		List<V2_Item> list = vo.getList();
		itemDAO.updateBatch(list);
		
		
		return "redirect:updateitem.do";
	}
}
