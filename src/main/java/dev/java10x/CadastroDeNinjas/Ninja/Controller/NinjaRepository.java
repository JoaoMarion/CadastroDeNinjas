package dev.java10x.CadastroDeNinjas.Ninja.Controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel,Long> {
}
