package gdsc.moganatsueserver.domain.skindisease.repository;


import gdsc.moganatsueserver.domain.skindisease.entity.SkinDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkinRepository extends JpaRepository<SkinDisease,Long> {

    Optional<SkinDisease> findById(Long id);

    SkinDisease save(SkinDisease skinDisease);



}

