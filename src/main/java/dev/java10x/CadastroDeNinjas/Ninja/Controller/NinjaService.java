package dev.java10x.CadastroDeNinjas.Ninja.Controller;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
