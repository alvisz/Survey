package com.alviszalamans.survey.data.repository;

import com.alviszalamans.survey.data.entity.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {

}
