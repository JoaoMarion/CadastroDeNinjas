package dev.java10x.CadastroDeNinjas.Ninja.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
       List<NinjaModel> ninjas = ninjaRepository.findAll();
       return ninjas.stream()
               .map(ninjaMapper::map)
               .collect(Collectors.toList());
    }

    //listar ninja por id
    public NinjaDTO listarNinjaPorId(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Criar novo Ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //delete ninja por id
    public void deletarNinjaPorId(long id){
        ninjaRepository.deleteById(id);
    }

    //atualizar ninja
    public NinjaDTO atualizarNinja(long id,NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ninja com id " + id + " não foi encontrado.");
    }

}
