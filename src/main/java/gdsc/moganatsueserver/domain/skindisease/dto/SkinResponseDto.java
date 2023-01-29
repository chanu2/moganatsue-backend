package gdsc.moganatsueserver.domain.skindisease.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkinResponseDto {

    private String diseaseName;

    private String symptom;
    private String prescription;

    private String diseasePicture;


}
