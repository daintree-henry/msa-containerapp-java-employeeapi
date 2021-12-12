package msa.containerapp.javarestemployeeapi.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/health")
class Health {

    @GetMapping("")
    public String Controller(){
        return "Status OK" ;
    }
}