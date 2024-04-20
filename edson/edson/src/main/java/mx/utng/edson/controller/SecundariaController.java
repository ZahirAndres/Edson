package mx.utng.edson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.edson.model.entity.Secundaria;
import mx.utng.edson.model.service.ISecundariaService;

@Controller
@SessionAttributes("secundaria")
public class SecundariaController {
    @Autowired 
    private ISecundariaService service;

    @GetMapping({"secundaria", "/secundaria", "/secundaria/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de secundarias");
        model.addAttribute("secundarias", service.list());
        return "secundaria-list";
    }

    @GetMapping("/secundaria/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de secundarias");
        model.addAttribute("secundaria", new Secundaria());
        return "secundaria-form";
    }

    @PostMapping("/secundaria/form")
    public String save(@Valid Secundaria secundaria, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de secundarias");
            return "secundaria-form";
        }
        service.save(secundaria);
        return "redirect:/secundaria/list";
    }

    @GetMapping("/secundaria/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Secundaria secundaria = null;
        if(id > 0){
            secundaria=service.getByID(id);
        }else{
            return "redirect:/secundaria/list";
        }
        model.addAttribute("title", "Editar secundarias");
        model.addAttribute("secundaria", secundaria);
        return "secundaria-form";
    }
    @GetMapping("/secundaria/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/secundaria/list";
    }

}
