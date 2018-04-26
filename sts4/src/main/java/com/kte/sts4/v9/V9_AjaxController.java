package com.kte.sts4.v9;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kte.sts4.dao.V9_CustomerDAO;

@RestController
@MapperScan({"com.kte.sts4.dao"})
public class V9_AjaxController {

	@Autowired
	private V9_CustomerDAO csDAO = null;
	
	@RequestMapping(value = {"/v9_ajax_customeridcheck.do"}, 
			method = RequestMethod.GET)
	public @ResponseBody Map<String,Integer> customerIDCheck(@RequestParam("id") String id) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		try {
			map.put( "ret", csDAO.selectIDCheck(id) );
		}
		catch(Exception e) {
			map.put( "ret", -1 );
		}
		return map;
	}
}
