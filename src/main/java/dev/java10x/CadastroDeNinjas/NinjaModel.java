package dev.java10x.CadastroDeNinjas;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//  Etity Transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name="tb_cadastro")
public abstract class NinjaModel {
    @Id
    @GeneratedValue()
    protected long id;
    protected String name, email;
    protected int age;

    public NinjaModel() {
    }

    public NinjaModel(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
