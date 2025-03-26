package dev.java10x.CadastroDeNinjas.Ninja;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Person {

    protected String name;

    @Column(unique = true)
    protected String email;

    @Column(name="Idade")
    protected int age;
}
