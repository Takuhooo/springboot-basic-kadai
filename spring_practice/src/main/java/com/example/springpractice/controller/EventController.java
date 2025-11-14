package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springpractice.event.ButtonPressEventPublisher;

@Controller
public class EventController {
	private final ButtonPressEventPublisher eventPublisher;
	
	public EventController(ButtonPressEventPublisher eventPublisher) {
		//イベント発行クラスの依存性を注入
		this.eventPublisher = eventPublisher;
	}
	
	//URLアクセス時に実行されるメソッド
	@GetMapping("/event")
	public String event() {
		return "eventView";
	}
	
	//ボタン押下時に実行されるメソッド
	@GetMapping("/pressButton")
	public String pressButton() {
		//イベントを発行
		eventPublisher.publishButtonPressEvent();
		
		//元の画面にリダイレクト
		return "redirect:/event";
	}
}
