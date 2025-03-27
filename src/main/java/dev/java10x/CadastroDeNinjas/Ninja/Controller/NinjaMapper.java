package dev.java10x.CadastroDeNinjas.Ninja.Controller;

public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {
        return NinjaModel.builder()
                .id(ninjaDTO.getId())
                .name(ninjaDTO.getName())
                .email(ninjaDTO.getEmail())
                .age(ninjaDTO.getAge())
                .imgUrl(ninjaDTO.getImgUrl())
                .rank(ninjaDTO.getRank())
                .missao(ninjaDTO.getMissao())
                .build();
    }


    public NinjaDTO map(NinjaModel ninjaModel) {
        return NinjaDTO.builder()
                .id(ninjaModel.getId())
                .name(ninjaModel.getName())
                .email(ninjaModel.getEmail())
                .age(ninjaModel.getAge())
                .imgUrl(ninjaModel.getImgUrl())
                .rank(ninjaModel.getRank())
                .missao(ninjaModel.getMissao())
                .build();
    }
}
