package gdsc.moganatsueserver.domain.skindisease.controller;

import gdsc.moganatsueserver.domain.skindisease.dto.AddSkinDto;
import gdsc.moganatsueserver.domain.skindisease.dto.SkinResponseDto;
import gdsc.moganatsueserver.domain.skindisease.service.SkinService;
import gdsc.moganatsueserver.global.successResponse.ResponseMessage;
import gdsc.moganatsueserver.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/skin")
public class SkinController {

    private final SkinService skinService;


    // 피부 질환 이름 사진 솔루션 가져오기
    @GetMapping ("/find/{skinId}")
    public ResponseEntity getSkin(@PathVariable Long skinId){
        SkinResponseDto skinInfo = skinService.getSkinInfo(skinId);

        return SuccessResponse.successtoResponseEntity(200,skinInfo, ResponseMessage.FIND_SKIN_SUCCESS);
    }

    @PostMapping("/add")
    public ResponseEntity addSkin(@RequestBody AddSkinDto addSkinDto){

         skinService.addSkinDisease(addSkinDto.getDiseaseName(),
                 addSkinDto.getSymptom(),
                 addSkinDto.getPrescription(),
                 addSkinDto.getDiseasePicture()
         );
        return SuccessResponse.successtoResponseEntity(200,null, ResponseMessage.FIND_SKIN_SUCCESS);
    }
}
