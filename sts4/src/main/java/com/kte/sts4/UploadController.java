package com.kte.sts4;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kte.sts4.dao.V8_FileDAO;
import com.kte.sts4.vo.V8_File;

@Controller
@MapperScan("com.kte.sts4.dao")
public class UploadController {
	
	@Autowired V8_FileDAO fileDAO = null;
	
	@RequestMapping(value="adminupdate.do", method=RequestMethod.POST)
	public String adminUpdate(@RequestParam("no") int no, @RequestParam("text") String text, MultipartHttpServletRequest request) {
		try {
			V8_File vo = new V8_File();
			vo.setNo(no);
			vo.setText(text);
			
			MultipartFile file = request.getFile("file");
			if(file != null && !file.getOriginalFilename().equals("")) {
				vo.setFilename(file.getOriginalFilename());	//파일명
				vo.setFile(file.getBytes());	//실제 파일 데이터
				fileDAO.updateFile(vo);
			}
			else {
				fileDAO.updateFileNull(vo);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:adminupload.do";
	}
	
	@RequestMapping(value="admindelete.do", method=RequestMethod.POST)
	public String adminDelete(@RequestParam("txt_fileno") int no) {
		try {
			fileDAO.deleteFile(no);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:adminupload.do";
	}
	
	@RequestMapping(value="adminupload.do", method=RequestMethod.GET)
	public String adminUpload(Model model) {
		
		List<V8_File> list = fileDAO.selectFileList();
		
		model.addAttribute("list", list);
		
		return "adminupload";
	}
	
	@RequestMapping(value="adminupload.do", method=RequestMethod.POST)
	public String adminUpload(@RequestParam("text") String text, MultipartHttpServletRequest request) {
		try {
			V8_File vo = new V8_File();
			vo.setText(text);
			MultipartFile file = request.getFile("file");
			if(file != null && !file.getOriginalFilename().equals("")) {
				vo.setFile(file.getBytes());
				vo.setFilename(file.getOriginalFilename());
			}
			fileDAO.insertFile(vo);
			return "adminupload";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
	
			return "redirect:adminupload.do";
		}
		
	}
	
	@RequestMapping(value = "/displayfile.do", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(@RequestParam("no") int no, HttpServletRequest request) {
		try {
			V8_File vo = new V8_File();
			vo.setNo(no);
			V8_File vo1 = fileDAO.selectFileOne(vo);

			String fn = vo1.getFilename();
			int idx = fn.lastIndexOf(".");
			String str = fn.substring(idx+1);
			
			final HttpHeaders headers = new HttpHeaders();
			
			if(str.equalsIgnoreCase("jpg") || str.equalsIgnoreCase("png") || str.equalsIgnoreCase("gif")) {
				headers.add("Content-Type", "image/jpg");
			}
			else if(str.equalsIgnoreCase("pdf")) {
				headers.add("Content-Type", "application/pdf");
			}
			//headers.add("Content-Disposition", "attachment; filename=\"file.pdf\"");	//다운로드 용
			headers.add("Content-Disposition", "inline; filename='"+vo1.getFilename()+"'");	//미리보기 용
			
			return new ResponseEntity<byte[]>(vo1.getFile(), headers, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("ERROR - " + e.getMessage());
			return null;
		}
	}

	
	
	
	
	@RequestMapping(value="filelist.do", method=RequestMethod.GET)
	public String fileList(Model model) {
		
		
		return "filelist";
	}
}
