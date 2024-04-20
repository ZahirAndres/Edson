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
import mx.utng.edson.model.entity.Principal;
import mx.utng.edson.model.service.IPrincipalService;

@Controller
@SessionAttributes("principal")
public class PrincipalController {
    @Autowired      
    private IPrincipalService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de principal");
        model.addAttribute("principals", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de principal");
        model.addAttribute("principal", new Principal());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Principal principal, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de principal");
            return "form";
        }

        service.save(principal);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Principal principal = null;
        if(id > 0){
            principal=service.getByID(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar principal");
        model.addAttribute("principal", principal);
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/list";
    }

}
