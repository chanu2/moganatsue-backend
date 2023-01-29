package gdsc.moganatsueserver.domain.recommenditem.repository;


import gdsc.moganatsueserver.domain.recommenditem.entity.RecommendItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendItemRepository extends JpaRepository<RecommendItem, Long> {
    RecommendItemRepository save(RecommendItemRepository skinDisease);

    @Query("select r from RecommendItem r"+
            " join fetch r.skinDisease s"+
            " where s.id = :skinId")
    List<RecommendItem> findRecommend(@Param(value="skinId") Long skinId);


}
