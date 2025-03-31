package dev.java10x.CadastroDeNinjas.Missoes.Controller;

public class MissoesMapper {
    public MissoesModel map(MissoesDTO missoesDTO) {
        return MissoesModel.builder()
                .id(missoesDTO.getId())
                .missionName(missoesDTO.getMissionName())
                .missionRank(missoesDTO.getMissionRank())
                .ninja(missoesDTO.getNinja())
                .build();

    }

    public MissoesModel map(MissoesModel missoesModel) {
        return MissoesModel.builder()
                .id(missoesModel.getId())
                .missionName(missoesModel.getMissionName())
                .missionRank(missoesModel.getMissionRank())
                .ninja(missoesModel.getNinja())
                .build();
    }


}

