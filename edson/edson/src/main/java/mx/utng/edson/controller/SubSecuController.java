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
import mx.utng.edson.model.entity.SubSecu;
import mx.utng.edson.model.service.ISubSecuService;

@Controller
@SessionAttributes("subSecu")
public class SubSecuController {
    @Autowired 
    private ISubSecuService service;

    @GetMapping({"subSecu", "/subSecu", "/subSecu/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de subSecus");
        model.addAttribute("subSecus", service.list());
        return "subSecu-list";
    }

    @GetMapping("/subSecu/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de subSecus");
        model.addAttribute("subSecu", new SubSecu());
        return "subSecu-form";
    }

    @PostMapping("/subSecu/form")
    public String save(@Valid SubSecu subSecu, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de subSecus");
            return "subSecu-form";
        }
        service.save(subSecu);
        return "redirect:/subSecu/list";
    }

    @GetMapping("/subSecu/form/{id}")
    public String update(@PathVariable Long id, Model model){
        SubSecu subSecu = null;
        if(id > 0){
            subSecu=service.getByID(id);
        }else{
            return "redirect:/subSecu/list";
        }
        model.addAttribute("title", "Editar subSecus");
        model.addAttribute("subSecu", subSecu);
        return "subSecu-form";
    }
    @GetMapping("/subSecu/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/subSecu/list";
    }

}
