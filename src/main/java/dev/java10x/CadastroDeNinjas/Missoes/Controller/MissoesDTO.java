package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesRank;
import dev.java10x.CadastroDeNinjas.Ninja.Controller.NinjaModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MissoesDTO {

    private long id;
    private String missionName;
    private MissoesRank missionRank;
    private List<NinjaModel> ninja;

}
