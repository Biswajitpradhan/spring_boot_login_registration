package com.example.demo;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Demo {
	static private Integer id_no;
	static private String name;
	static private String password;
	private DetailrEPO epo;
	
	public Demo(DetailrEPO epo) {
		this.epo = epo;
	}
	@RequestMapping("/")
	String index()
	{
		return "index";
	}
	@RequestMapping("log")
	String index1()
	{
		return "Login";
	}
	@PostMapping("send")
	String send(@RequestParam("id_no") String id_no,@RequestParam("name") String name,@RequestParam("pass") String password)
	{
		this.name=name;
		this.id_no=Integer.parseInt(id_no);
		this.password=password;
		return "Send";
	}
	@PostMapping("signup")
	String sign(@RequestParam("fee") String fee,@RequestParam("address") String address,Details dt)
	{
		dt.setCardid(id_no);
		dt.setName(name);
		dt.setPassword(password);
		dt.setFee(fee);
		dt.setAddress(address);
		epo.save(dt);
		return "Login";
	}
	
	@PostMapping("Login")
	String home(@RequestParam("cardId") Integer cardid,@RequestParam("password") String password,Model m)
	{
		Optional<Details> o=epo.findByCardIdAndPassword(cardid,password);
		if(o.isPresent())
		{
			return "Home";
		}
		m.addAttribute("msg", "false");
		return "Login";
	}
	
	
}
