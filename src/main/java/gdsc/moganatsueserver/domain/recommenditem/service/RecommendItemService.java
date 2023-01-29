package gdsc.moganatsueserver.domain.recommenditem.service;



import gdsc.moganatsueserver.domain.recommenditem.dto.RecommendItemDto;
import gdsc.moganatsueserver.domain.recommenditem.entity.RecommendItem;
import gdsc.moganatsueserver.domain.recommenditem.repository.RecommendItemRepository;
import gdsc.moganatsueserver.domain.skindisease.entity.SkinDisease;
import gdsc.moganatsueserver.domain.skindisease.service.SkinUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecommendItemService {

    private final RecommendItemRepository recommendItemRepository;
    private final SkinUtils skinUtils;

    @Transactional
    public void addRecommendItem(String itemName, String itemPicture, String itemExplanation,Long skinId){

        SkinDisease skinDisease = skinUtils.findSkinDisease(skinId);

        RecommendItem recommendItem = recommendItemRepository.save(
                RecommendItem.builder()
                        .itemName(itemName)
                        .itemPicture(itemPicture)
                        .itemExplanation(itemExplanation)
                        .skinDisease(skinDisease)
                        .build()
        );

        skinDisease.addRecommendItem(recommendItem);


    }

    public List<RecommendItemDto> getRecommendItem(Long skinId){

        List<RecommendItem> recommends = recommendItemRepository.findRecommend(skinId);

        log.info("recommends.size={}",recommends.size());

        return recommends.stream().map(r -> new RecommendItemDto(r)).collect(Collectors.toList());
    }




}
