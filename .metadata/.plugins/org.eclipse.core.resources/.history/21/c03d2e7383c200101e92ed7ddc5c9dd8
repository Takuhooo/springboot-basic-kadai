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

    // -------------------------
    // ① フォーム表示（GET /form）
    // -------------------------
    @GetMapping("/form")
    public String showForm(Model model) {

        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "contactFormView";
    }

    // -------------------------
    // ② フォーム送信（POST /form）
    // -------------------------
    @PostMapping("/form")
    public String submitForm(
            @Valid ContactForm contactForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("contactForm", contactForm);

            redirectAttributes.addFlashAttribute(
               "org.springframework.validation.BindingResult.contactForm",
               bindingResult
            );

            return "redirect:/form";
        }

        redirectAttributes.addFlashAttribute("contactForm", contactForm);

        return "redirect:/confirm";
    }

    // -------------------------
    // ③ 確認画面（GET /confirm）
    // -------------------------
    @GetMapping("/confirm")
    public String showConfirm(Model model) {

        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }

        return "confirmView";
    }
}
