package dev.java10x.CadastroDeNinjas.Ninjas.Controller;


import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

//  Etity Transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name="tb_cadastro")
public class NinjaModel extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="missao_id") //chave estrangeira
    private MissoesModel missao;



    public NinjaModel() {
    }

    public NinjaModel(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
