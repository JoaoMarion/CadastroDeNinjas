package dev.java10x.CadastroDeNinjas;

import dev.java10x.CadastroDeNinjas.Ninja.Controller.NinjaDTO;

public class Main {
    public static void main(String[] args) {


        NinjaDTO ninja = NinjaDTO.builder()
                .name("Naruto")
                .build();


        System.out.println(ninja);
    }
}
