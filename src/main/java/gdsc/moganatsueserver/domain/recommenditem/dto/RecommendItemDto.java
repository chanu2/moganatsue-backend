package gdsc.moganatsueserver.domain.recommenditem.dto;


import gdsc.moganatsueserver.domain.recommenditem.entity.RecommendItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecommendItemDto {

    private String itemName;
    private String itemPicture;
    private String itemExplanation;

    public RecommendItemDto(RecommendItem recommendItem){
        this.itemName=recommendItem.getItemName();
        this.itemPicture=recommendItem.getItemPicture();
        this.itemExplanation = recommendItem.getItemExplanation();
    }

}
