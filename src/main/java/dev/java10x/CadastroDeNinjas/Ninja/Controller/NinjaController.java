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
    public String criarNinja(){return "Ninja criado";}

    //Show all ninjas
    @GetMapping("/todos")
    public List<NinjaModel> listarNinjas(){
         return ninjaService.listarNinjas();
    }

    //Show all ninjas for id
    @GetMapping("/todosId")
    public String mostrarTodosOsNinjasPorId(){
        return "mostrar ninja por id";
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
