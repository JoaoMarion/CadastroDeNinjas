package dev.java10x.CadastroDeNinjas.Ninja.Controller;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
       return ninjaRepository.findAll();
    }

    //listar ninja por id
    public NinjaModel listarNinjaPorId(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar novo Ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
    //delete ninja por id
    public void deletarNinjaPorId(long id){
        ninjaRepository.deleteById(id);
    }

    //atualizar ninja
    public NinjaModel atualizarNinja(long id,NinjaModel ninjaAtualizado){
       ninjaRepository.findById(id);
        if(ninjaRepository.existsById(id)){
           ninjaAtualizado.setId(id);
           return ninjaRepository.save(ninjaAtualizado);
        }
        return null;

    }

}
