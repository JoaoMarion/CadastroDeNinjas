package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesRank;
import dev.java10x.CadastroDeNinjas.Ninja.Controller.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String missionName;

    @Enumerated(EnumType.STRING)
    private MissoesRank missionRank;

    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List<NinjaModel> ninja;


}
