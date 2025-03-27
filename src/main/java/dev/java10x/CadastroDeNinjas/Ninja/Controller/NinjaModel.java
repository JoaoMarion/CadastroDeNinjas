package dev.java10x.CadastroDeNinjas.Ninja.Controller;


import dev.java10x.CadastroDeNinjas.Missoes.Controller.MissoesModel;
import dev.java10x.CadastroDeNinjas.Ninja.Person;
import dev.java10x.CadastroDeNinjas.Ninja.Rank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//  Etity Transforma uma classe em uma entidade do banco de dados



@Entity
@Table(name="tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class NinjaModel extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name="missao_id") //chave estrangeira
    private MissoesModel missao;



    @Override
    public String toString(){
        return "Name : " + name;
    }




}

