package com.kte.sts4;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kte.sts4.dao.ChatDAO;
import com.kte.sts4.vo.Chat;
import com.kte.sts4.vo.Member;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;

@RestController
public class AjaxController {

	@Autowired
	private ChatDAO chatDAO= null;
	@Autowired
	private MongoTemplate mongoTemplate = null;
	
	@RequestMapping(produces="text/plain;charset=UTF-8", value="/ajax_wordcount.do", method = {RequestMethod.GET,RequestMethod.POST} )
	public String wordCount(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String map = "function() {"
						+ "var msg = this.msg;"
						+ "if(msg) {"
							+ "msg = msg.toLowerCase().split(' '); "
							+ "for(var i=msg.length-1; i>=0; i--) {"
								+ "if(msg[i]) {"
									+ "emit(msg[i], 1);"
								+ "}"
							+ "}"
						+ "}"
					+ "}";
		
		String reduce = "function(key, values) {"
							+ "var count = 0;"
							+ "values.forEach(function(v) {"
								+ "count += v;"
							+ "});"
							+ " return count;"
						+ "}";
		
		DBCollection chatdb = mongoTemplate.getDb().getCollection("chat");
		
		MapReduceCommand cmd = new MapReduceCommand(chatdb, map, reduce, null, MapReduceCommand.OutputType.INLINE, null);
		MapReduceOutput out = chatdb.mapReduce(cmd);
		
		JSONArray jarr = new JSONArray();
		for(DBObject obj : out.results()) {
			Map<String, String> map1 = obj.toMap();
			JSONObject jobj = new JSONObject();
			jobj.put("_id", map1.get("_id"));
			jobj.put("value", map1.get("value"));
			jarr.put(jobj);
		}
		
		return jarr.toString();
	}
	
	@RequestMapping(value="/ajax_chatlist.do", method = {RequestMethod.GET,RequestMethod.POST} )
	public List<Chat> chatList(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//SELECT * FROM CHAT ORDER BY id DESC LIMIT 50
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Query query = new Query();
		
		query.with(sort);
		//query.skip(50);
		query.limit(50);
		
		List<Chat> list = mongoTemplate.find(query, Chat.class, "chat");
		return list;
	}
	
	@RequestMapping(value="/ajax_memberlist.do", method = {RequestMethod.GET,RequestMethod.POST} )
	public List<Member> memberList(HttpServletResponse response){
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		List<Member> list = chatDAO.selectMemberList();
		return list;
	}
}
