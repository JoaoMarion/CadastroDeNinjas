package dev.java10x.CadastroDeNinjas.Ninja.Controller;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //add Ninja
     @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Show all ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
         return ninjaService.listarNinjas();
    }

    //Show all ninjas for id
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id ){
        return ninjaService.listarNinjaPorId(id);
    }

    // alterar dados dos ninjas
    @PutMapping("/alterarId")
    public String alterarNinjaPorId(){
         return "Alterar ninja por id";
    }


    //deletar ninjas
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
         return "Ninja deletado por ID";
    }




}
