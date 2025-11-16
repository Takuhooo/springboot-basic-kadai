package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    // ▼ 入力画面（GET）
    @GetMapping("/form")
    public String showForm(Model model) {

        // Model に contactForm が無ければ新規作成して入れる
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }

        return "contactFormView";
    }

    // ▼ 入力内容送信（POST）
    @PostMapping("/form")
    public String submitForm(
            @Valid ContactForm contactForm,
            BindingResult bindingResult,
            Model model) {

        // ▼ バリデーションエラーあり → 入力画面に戻す
        if (bindingResult.hasErrors()) {
            return "contactFormView";
        }

        // ▼ OK → 直接確認画面へ
        model.addAttribute("contactForm", contactForm);

        return "confirmView";
    }
}
