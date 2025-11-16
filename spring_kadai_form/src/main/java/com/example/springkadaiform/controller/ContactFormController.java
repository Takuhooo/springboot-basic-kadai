package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    // 入力画面表示（GET /form）
    @GetMapping("/form")
    public String showForm(Model model) {
        // 他画面からリダイレクトされた時に contactForm が入っていなければ新規作成
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "contactFormView";
    }

    // フォーム送信処理（POST /form）
    @PostMapping("/form")
    public String submitForm(
            @Valid ContactForm contactForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {

        // ◆ バリデーション NG → 入力画面へリダイレクト
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", bindingResult);
            redirectAttributes.addFlashAttribute("contactForm", contactForm);
            return "redirect:/form";
        }

        // ◆ バリデーション OK → リダイレクトせず直接確認画面を表示
        model.addAttribute("contactForm", contactForm);
        return "confirmView";
    }
}
