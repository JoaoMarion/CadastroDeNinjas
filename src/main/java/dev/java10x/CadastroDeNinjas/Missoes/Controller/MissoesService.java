package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //listar Missoes
    public List<MissoesModel> listarMissoes(){
         return missoesRepository.findAll();
    }

    //listar missao por id
    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null );
    }

    //criar nova missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //deletar missao por id
    public void deletarMissaoPorId(long id){
        missoesRepository.deleteById(id);
    }

    //Atualizar missao
    public MissoesModel atualizarMissao(long id, MissoesModel missaoAtualizada){
        missoesRepository.findById(id);
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }


}
