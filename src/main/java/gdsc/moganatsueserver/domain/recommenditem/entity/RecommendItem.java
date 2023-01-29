package gdsc.moganatsueserver.domain.recommenditem.entity;


import gdsc.moganatsueserver.domain.skindisease.entity.SkinDisease;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommend_item_id")
    private Long id;
    private String itemName;
    private String itemPicture;
    private String itemExplanation;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "skin_disease_id")
    private SkinDisease skinDisease;

    @Builder
    public RecommendItem(String itemName, String itemPicture, String itemExplanation, SkinDisease skinDisease) {
        this.itemName = itemName;
        this.itemPicture = itemPicture;
        this.itemExplanation = itemExplanation;
        this.skinDisease = skinDisease;
    }



    public void mappingSkinDisease(SkinDisease skinDisease){
        this.skinDisease = skinDisease;
    }



}
