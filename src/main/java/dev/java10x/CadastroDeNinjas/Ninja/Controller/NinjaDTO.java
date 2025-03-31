package dev.java10x.CadastroDeNinjas.Ninja.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.Controller.MissoesModel;
import dev.java10x.CadastroDeNinjas.Ninja.Person;
import dev.java10x.CadastroDeNinjas.Ninja.Rank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class NinjaDTO extends Person {

    private long id;
    private Rank rank;
    private String imgUrl;
    private MissoesModel missao;



    @Override
    public String toString(){
        return "Name : " + name;
    }


}
