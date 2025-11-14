package com.example.springpractice.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ButtonPressEventListener {
	//ボタンが押された回数
	private int pressCount;
	
	@EventListener
	public void onButtonPressEvent(ButtonPressEvent event) {
		this.pressCount++; //押された回数を加算
		System.out.println("ボタンが" + pressCount + "回押されました");
	}
}
