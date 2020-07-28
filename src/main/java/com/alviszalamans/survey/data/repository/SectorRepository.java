package com.alviszalamans.survey.data.repository;

import com.alviszalamans.survey.data.entity.Sector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends CrudRepository<Sector, Long> {
}
