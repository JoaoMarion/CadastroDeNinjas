package dev.java10x.CadastroDeNinjas.Ninja.Controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ninjas")
//@CrossOrigin(origins = "http://localhost:3000")
public class NinjaController {

    private  final NinjaService ninjaService;


    public NinjaController(NinjaService ninjaService) {

        this.ninjaService = ninjaService;
    }

    //add Ninja
     @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);

         if (novoNinja == null) { // Agora funciona
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("Erro ao criar o Ninja");
         }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com Sucesso: " + novoNinja.getName()+ " com id " + novoNinja.getId());
    }



    //Show all ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
       List<NinjaDTO> ninjas = ninjaService.listarNinjas();
       return ResponseEntity.ok(ninjas);
    }


    //Show all ninjas for id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id ){
           NinjaDTO ninjaListar = ninjaService.listarNinjaPorId(id);
           if(ninjaListar==null){
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("Ninja Não Encontrado");
           }
           return ResponseEntity.ok()
                   .body(ninjaListar);

    }


    // alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninjaModificado = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninjaModificado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " Não encontrado");
        }

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", "Ninja alterado com sucesso");
        resposta.put("ninja", ninjaModificado);

        return ResponseEntity.ok(resposta);
    }


    //deletar ninjas
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok()
                    .body("Ninja com o id " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id " + id + " não encontrado");
        }
    }




}
