package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import org.flywaydb.core.api.output.MigrateOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //criar missao
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    //listar missoes
    @GetMapping("/listar")
   public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
   }

    //listar missao por id
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    //deletar missao por id
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

    //atualizar missao
    @PutMapping("/alterar/{id}")
    public MissoesModel atualizarMissaoPorId(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
         return missoesService.atualizarMissao(id, missaoAtualizada);
    }

}
