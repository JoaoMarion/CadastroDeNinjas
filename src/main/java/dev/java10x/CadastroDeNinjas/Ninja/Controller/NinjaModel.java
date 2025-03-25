package dev.java10x.CadastroDeNinjas.Ninja.Controller;


import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import dev.java10x.CadastroDeNinjas.Ninja.Person;
import dev.java10x.CadastroDeNinjas.Ninja.Rank;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//  Etity Transforma uma classe em uma entidade do banco de dados



@Entity
@Table(name="tb_cadastro")
@Data
@NoArgsConstructor
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

    public NinjaModel(long id,String name, int age, String email, MissoesModel missao){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.missao = missao;
    }

    @Override
    public String toString(){
        return "Name : " + name;
    }




}

