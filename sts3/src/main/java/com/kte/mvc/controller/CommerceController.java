package com.kte.mvc.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kte.mvc.dao.V3_CartXMLDAO;
import com.kte.mvc.dao.V3_ItemXMLDAO;
import com.kte.mvc.dao.V3_OrderXMLDAO;
import com.kte.mvc.vo.V3_Cart;
import com.kte.mvc.vo.V3_Item;
import com.kte.mvc.vo.V3_Order;

@Controller
public class CommerceController {

	@Autowired
	private V3_ItemXMLDAO ixDAO = null;
	@Autowired
	private V3_OrderXMLDAO oxDAO = null;
	@Autowired
	private V3_CartXMLDAO cxDAO = null;
	
	@RequestMapping(value = "/admin_item_insert.do", method = RequestMethod.GET)
	public String adminItemInsert(Model model) {

		V3_Item vo = new V3_Item();

		model.addAttribute("vo", vo);
		return "adminiteminsert";
	}

	@RequestMapping(value = "/admin_item_insert.do", method = RequestMethod.POST)
	public String adminItemInsert(@ModelAttribute("vo") V3_Item vo, MultipartHttpServletRequest request) {
		try {
			// jsp에서 첨부된 파일을 Map로 받음
			Map<String, MultipartFile> map = request.getFileMap();

			for (int i = 0; i < map.size(); i++) {
				// Map에서 name값을 키로 하여 1개를 꺼내어 tmp에 보관함
				MultipartFile tmp = map.get("file_" + (i + 1));
				// tmp값이 null이 아니고 파일명이 공백이 아니면 => 파일이 첨부되었다면
				if (tmp != null && !tmp.getOriginalFilename().equals("")) {
					if (i == 0)
						vo.setImg1(tmp.getBytes());
					if (i == 1)
						vo.setImg2(tmp.getBytes());
					if (i == 2)
						vo.setImg3(tmp.getBytes());
					if (i == 3)
						vo.setImg4(tmp.getBytes());
					if (i == 4)
						vo.setImg5(tmp.getBytes());
				}
			}

			ixDAO.insertItem3(vo);
			return "redirect:/";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@RequestMapping(value = "/shop.do", method = RequestMethod.GET)
	public String shop(Model model) {
		List<V3_Item> list = ixDAO.selectItemList();
		model.addAttribute("list", list);
		return "shop";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/get_blob_img.do", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getBlobImg(@RequestParam("code") String code, HttpServletRequest request) {
		byte[] imgs = null;
		//헤드 => 이진데이터를 어떠한 type으로 표현할 것인가?
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_JPEG);
		try {
			//기본값으로 default.jpg이미지를 보관함.
			InputStream is= request.getSession().getServletContext()
					.getResourceAsStream("/resources/imgs/default.png");
			imgs = IOUtils.toByteArray(is);	

			//DAO로 코드번호를 전달하면 이미지를 읽어서 vo에 저장해서 리턴 
			V3_Item vo = ixDAO.selectBlobImg(code);
				
			if(vo.getImg1() != null) {
	 			imgs = vo.getImg1();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			ResponseEntity<byte[]> r_data = new ResponseEntity<byte[]>(imgs, header,HttpStatus.OK);
			return r_data;
		}
	}
	
	@RequestMapping(value = "/shop_detail.do", method = RequestMethod.GET)
	public String shopDetail(Model model, @RequestParam("code") String code) {
		V3_Item vo = ixDAO.selectItemOne(code);
		model.addAttribute("vo", vo);
		
		return "shopdetail";
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/get_blob_img1.do", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getBlobImg1(@RequestParam("code") String code, @RequestParam("idx") String idx, HttpServletRequest request) {
		byte[] imgs = null;
		//헤드 => 이진데이터를 어떠한 type으로 표현할 것인가?
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_JPEG);
		try {
			//기본값으로 default.jpg이미지를 보관함.
			InputStream is= request.getSession().getServletContext().getResourceAsStream("/resources/imgs/default.png");
			imgs = IOUtils.toByteArray(is);	
			
			V3_Item obj = new V3_Item();
			obj.setCode(code);
			obj.setImg_tabel_name(idx);
			
			//DAO로 코드번호를 전달하면 이미지를 읽어서 vo에 저장해서 리턴 
			V3_Item vo = ixDAO.selectBlobImg1(obj);
				
			if(vo.getImg1() != null) {
	 			imgs = vo.getImg1();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			ResponseEntity<byte[]> r_data = new ResponseEntity<byte[]>(imgs, header,HttpStatus.OK);
			return r_data;
		}
	}
	
	@RequestMapping(value = "/order.do", method = RequestMethod.GET)
	public String order(HttpSession httpsession, Model model) {
		//post에서 세션에 담겨져있던 값 가져오기
		String code = (String) httpsession.getAttribute("order_code");
		
		//로그인 상태 확인
		String email = (String) httpsession.getAttribute("_email");
		if(email == null) {
			return "redirect:memberlogin.do";
		}
		else {
			if(code != null) {
				int cnt = (Integer) httpsession.getAttribute("order_cnt");
				//code, cnt, email을 이용하여 order테이블에 추가
				V3_Order vo = new V3_Order();
				vo.setEmail(email);
				vo.setCnt(cnt);
				vo.setItem_no(code);
				
				oxDAO.insertOrder(vo);
				httpsession.setAttribute("order_code", null);
			}

			List<V3_Order> list = oxDAO.selectOrderList(email);
			model.addAttribute("list", list);
			return "order";
		}
	}
	
	@RequestMapping(value = "/order.do", method = RequestMethod.POST)
	public String order(@RequestParam("code") String code, @RequestParam("cnt") int cnt, HttpSession httpsession) {
		//세션에 값을 넣음
		httpsession.setAttribute("order_code", code);
		httpsession.setAttribute("order_cnt", cnt);
		
		//order.do GET으로 페이지 이동
		return "redirect:order.do";
	}
	
	@RequestMapping(value = "/cart.do", method = RequestMethod.POST)
	public String cart(@RequestParam("code") String code, @RequestParam("cnt") int cnt, HttpSession httpsession) {
		//세션에 값을 넣음
		httpsession.setAttribute("cart_code", code);
		httpsession.setAttribute("cart_cnt", cnt);
		//cart.do GET으로 페이지 이동
		return "redirect:cart.do";
	}
	
	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cart(HttpSession httpsession, Model model) {
		//post에서 세션에 담겨져있던 값 가져오기
				String code = (String) httpsession.getAttribute("cart_code");
				String user = httpsession.getId();
				//로그인 상태 확인
				
				if(code == null) {
					return "redirect:memberlogin.do";
				}
				else {
					if(code != null) {
						int cnt = (Integer) httpsession.getAttribute("cart_cnt");
						V3_Cart vo = new V3_Cart();
						vo.setCart_item(code);
						vo.setCart_user(user);
						vo.setCart_cnt(cnt);
						
						cxDAO.insertCart(vo);
						
						httpsession.setAttribute("cart_code", null);
					}

					List<V3_Cart> list = cxDAO.selectCartList(code);
					model.addAttribute("list", list);
					return "cart";
				}
	}
	
	
}
