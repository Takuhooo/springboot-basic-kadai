package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberListController {
	
	@GetMapping("/numbers")
	public String showNumberList() {
		// ビュー名を返すだけ（Modelには何も入れない）
		return "numberList";
	}
}
