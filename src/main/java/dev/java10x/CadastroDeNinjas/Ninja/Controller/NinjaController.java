package dev.java10x.CadastroDeNinjas.Ninja.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary="Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode="201", description = "Ninja Criado com sucesso"),
            @ApiResponse(responseCode="400", description = "Erro na criação do Ninja")
    })
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Usuario envia dados para o ninja ser atualizado")
            @RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);

        if (novoNinja == null) { // Agora funciona
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar o Ninja");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com Sucesso: " + novoNinja.getName()+ " com id " + novoNinja.getId());
    }



    @Operation(summary= "Lista todos os ninjas", description = "Rota Lista todos os ninjas do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200", description = "Ninjas listados com sucesso"),
            @ApiResponse(responseCode="404", description = "Erro na listagem dos ninjas")
    })
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
       List<NinjaDTO> ninjas = ninjaService.listarNinjas();
       return ResponseEntity.ok(ninjas);
    }


    @Operation(summary= "Lista 1 ninja por id", description = "Rota Lista o Ninja com id referente ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200", description = "Ninja Encontrado"),
            @ApiResponse(responseCode="404", description = "Erro na Procura do Ninja")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(
            @Parameter(description = "Usuário envia o id como parametro da requisição")
            @PathVariable Long id ){
           NinjaDTO ninjaListar = ninjaService.listarNinjaPorId(id);
           if(ninjaListar==null){
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("Ninja Não Encontrado");
           }
           return ResponseEntity.ok()
                   .body(ninjaListar);

    }


    @Operation(summary= "Altera Ninja por id", description = "Rota altera o Ninja com id referente ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200", description = "Ninja Encontrado"),
            @ApiResponse(responseCode="404", description = "Erro na Procura do Ninja")
    })
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuario envia o id como parametro para Requisição")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Usuario envia dados para o ninja ser atualizado")
            @RequestBody NinjaDTO ninjaAtualizado){
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


    @Operation(summary= "Deleta 1 ninja por id", description = "Rota Deleta o Ninja com id referente ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200", description = "Ninja Deletado"),
            @ApiResponse(responseCode="404", description = "Erro na Procura do Ninja")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuario envia o id como parametro para Requisição")
            @PathVariable Long id) {
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
