package gdsc.moganatsueserver.domain.recommenditem.controller;


import gdsc.moganatsueserver.domain.recommenditem.dto.AddRecommendItem;
import gdsc.moganatsueserver.domain.recommenditem.dto.RecommendItemDto;
import gdsc.moganatsueserver.domain.recommenditem.service.RecommendItemService;
import gdsc.moganatsueserver.global.successResponse.ResponseMessage;
import gdsc.moganatsueserver.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/recommend")
@RequiredArgsConstructor
public class RecommendItemController {

    private final RecommendItemService recommendItemService;

    // 추천 아이템 추가
    @PostMapping("/add/{skinId}")
    public ResponseEntity addRecommend(@PathVariable Long skinId, @RequestBody AddRecommendItem item){

        recommendItemService.addRecommendItem(item.getItemName(),
                item.getItemPicture(),
                item.getItemExplanation(),
                skinId);
        return SuccessResponse.successtoResponseEntity(200,null, ResponseMessage.FIND_ITEM_SUCCESS);
    }

    // 피부질환에 따른 추천아이템 가져오기
    @GetMapping("/list/{skinId}")
    public ResponseEntity getRecommend(@PathVariable Long skinId){

        log.info("skinId={}",skinId);

        List<RecommendItemDto> recommendItem = recommendItemService.getRecommendItem(skinId);

        return SuccessResponse.successtoResponseEntity(200,recommendItem, ResponseMessage.FIND_ITEM_SUCCESS);
    }

}
