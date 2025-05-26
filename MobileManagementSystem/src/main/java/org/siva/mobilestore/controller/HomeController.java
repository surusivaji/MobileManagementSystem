package org.siva.mobilestore.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.siva.mobilestore.model.Mobile;
import org.siva.mobilestore.service.IMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private IMobileService mobileService;
	
	@GetMapping("/")
	public String indexPage() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, @RequestParam(defaultValue = "0") Integer pageNo) {
		Page<Mobile> page = mobileService.getAllMobiles(pageNo);
		model.addAttribute("isSearch", false);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("mobiles", page.getContent());
		return "Dashboard";
	}
	
	@GetMapping("/addMobile")
	public String addMobilePage() {
		return "AddMobile";
	}
	
	
	@PostMapping("/saveMobileInformation")
	public String saveMobileInformation(@ModelAttribute Mobile mobile, @RequestParam("image") MultipartFile multipartFile, HttpSession session) {
		try {
			File file = new ClassPathResource("static/images").getFile();
			Path path = Paths.get(file.getAbsolutePath()+File.separator+"Mobiles"+File.separator+multipartFile.getOriginalFilename());
			Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			mobile.setImageUrl(multipartFile.getOriginalFilename());
			Mobile save = mobileService.saveMobile(mobile);
			if (save!=null) {
				System.out.println(mobile);
				session.setAttribute("successMsg", "Mobile saved successfully..!!");
			}
			else {
				session.setAttribute("failMsg", "Something went wrong");
			}
			return "redirect:/dashboard";
		} catch (Exception e) {
			session.setAttribute("failMsg", "Something went wrong while uploading the image");
			return "redirect:/addMobile";
		}
	}
	
	@GetMapping("/editMobileInformation/{id}")
	public String editMobileInformation(@PathVariable("id") Integer id, Model model, HttpSession session) {
		Mobile mobile = mobileService.getMobileById(id);
		if (mobile!=null) {
			model.addAttribute("mobile", mobile);
			return "EditMobile";
		}
		else {
			session.setAttribute("warningMsg", "Mobile information not found..!!!");
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/updateMobileInformation")
	public String updateMobileInformation(@ModelAttribute Mobile mobile, HttpSession session, @RequestParam("image") MultipartFile multipartFile) {
		try {			
			Mobile oldMobileInfo = mobileService.getMobileById(mobile.getId());
			if (multipartFile.isEmpty()) {
				mobile.setImageUrl(oldMobileInfo.getImageUrl());
			}
			else {
				File file = new ClassPathResource("static/images").getFile();
				Path path = Paths.get(file.getAbsolutePath()+File.separator+"Mobiles"+File.separator+multipartFile.getOriginalFilename());
				Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				mobile.setImageUrl(multipartFile.getOriginalFilename());
			}
			Mobile updateMobile = mobileService.saveMobile(mobile);
			if (updateMobile!=null) {
				System.out.println(updateMobile);
				session.setAttribute("successMsg", "Mobile information updated successfully..!!!");
			}
			else {
				session.setAttribute("failMsg", "Something went wrong while updating the information..!!!");
			}
			return "redirect:/dashboard";
		} catch (Exception e) {
			session.setAttribute("failMsg", "Something went wrong while uploading the image...!!!");
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/deleteMobileInformation/{id}")
	public String deleteMobileInformation(@PathVariable("id") Integer id, HttpSession session) {
		Mobile mobile = mobileService.getMobileById(id);
		if (mobile!=null) {
			boolean isDelete = mobileService.deleteMobile(mobile);
			if (isDelete) {
				session.setAttribute("successMsg", "Mobile information successfully deleted...!!!");
			}
			else {
				session.setAttribute("failMsg", "Something went wrong on the server...!!!");
			}
			return "redirect:/dashboard";
		}
		else {
			session.setAttribute("warningMsg", "Mobile information is not found...!!!");
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/search")
	public String searchMobiles(Model model, @RequestParam("ch") String ch) {
		model.addAttribute("isSearch", true);
		List<Mobile> mobiles = mobileService.searchMobilesByBrand(ch);
		model.addAttribute("mobiles", mobiles);
		return "Dashboard";
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

