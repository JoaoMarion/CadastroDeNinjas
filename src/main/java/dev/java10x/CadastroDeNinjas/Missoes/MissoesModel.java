package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String missionName;

    private MissoesRank missaoRank;

    @OneToMany(mappedBy = "missao")
    private NinjaModel ninja;
}
