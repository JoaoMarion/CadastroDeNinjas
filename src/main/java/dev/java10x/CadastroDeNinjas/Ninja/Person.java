package dev.java10x.CadastroDeNinjas.Ninja;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Person {

    protected String name;

    @Column(unique = true)
    protected String email;

    @Column(name="Idade")
    protected int age;
}
