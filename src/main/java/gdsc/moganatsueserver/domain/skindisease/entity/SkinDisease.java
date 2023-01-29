package gdsc.moganatsueserver.domain.skindisease.entity;


import gdsc.moganatsueserver.domain.recommenditem.entity.RecommendItem;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkinDisease {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skin_disease_id")
    private Long id;

    private String diseaseName;

    private String symptom;
    private String prescription;

    private String diseasePicture;

    @OneToMany(mappedBy = "skinDisease",cascade = CascadeType.ALL)
    private List<RecommendItem> recommendItemList = new ArrayList<>();


    @Builder
    public SkinDisease(String diseaseName,String symptom, String prescription, String diseasePicture) {
        this.diseaseName = diseaseName;
        this.symptom = symptom;
        this.prescription = prescription;
        this.diseasePicture = diseasePicture;
    }

    public void addRecommendItem(RecommendItem recommendItem){
        recommendItemList.add(recommendItem);
        recommendItem.mappingSkinDisease(this);
    }


}
