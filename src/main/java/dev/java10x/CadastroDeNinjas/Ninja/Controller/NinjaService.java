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

    //listar ninja por idd
    public NinjaModel listarNinjaPorId(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar novo Ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
}
