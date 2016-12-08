package bsuir.scouting.repository;


import bsuir.scouting.model.domain.Skills;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface SkillsRepository extends BaseRepository<Skills, Long> {

    @Transactional
    @Modifying
    @Query("update Skills s set s.shooting = :shooting, s.passing = :passing, s.dribbling = :dribbling, s.defence = :defence, s.speed = :speed, s.energy = :energy, s.stamina = :stamina  where s.skillsId = :skillsId")
    void updateSkills(@Param("shooting") Long shooting, @Param("passing") Long passing, @Param("dribbling") Long dribbling, @Param("defence") Long defence, @Param("speed") Long speed, @Param("energy") Long energy, @Param("stamina") Long stamina, @Param("skillsId") Long skillsId);

}
