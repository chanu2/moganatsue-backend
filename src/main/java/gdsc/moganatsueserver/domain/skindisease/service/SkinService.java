package gdsc.moganatsueserver.domain.skindisease.service;



import gdsc.moganatsueserver.domain.skindisease.dto.SkinResponseDto;
import gdsc.moganatsueserver.domain.skindisease.entity.SkinDisease;
import gdsc.moganatsueserver.domain.skindisease.exception.SkinDiseaseNotFound;
import gdsc.moganatsueserver.domain.skindisease.repository.SkinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkinService implements SkinUtils {

    private final SkinRepository skinRepository;


    // 병명 , 솔루션 ,
    @Transactional
    public SkinResponseDto getSkinInfo(Long id){
        SkinDisease skin = findSkinDisease(id);

        SkinResponseDto skinResponseDto = new SkinResponseDto();
        skinResponseDto.setDiseaseName(skin.getDiseaseName());
        skinResponseDto.setSymptom(skin.getSymptom());
        skinResponseDto.setPrescription(skin.getPrescription());
        skinResponseDto.setDiseasePicture(skin.getDiseasePicture());

        return skinResponseDto;

    }

    //병명 솔루션 생성


    @Transactional
    public SkinDisease addSkinDisease(String diseaseName, String symptom,String prescription, String diseasePicture){

        SkinDisease skin = skinRepository.save(
                SkinDisease.builder()
                        .diseaseName(diseaseName)
                        .symptom(symptom)
                        .prescription(prescription)
                        .diseasePicture(diseasePicture)
                        .build()
        );

        return skin;
    }



    @Override
    public SkinDisease findSkinDisease(Long id) {
        return skinRepository.findById(id).orElseThrow(
                ()-> SkinDiseaseNotFound.EXCEPTION);
    }
}
