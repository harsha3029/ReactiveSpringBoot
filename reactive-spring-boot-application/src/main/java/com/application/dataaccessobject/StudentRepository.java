package com.application.dataaccessobject;

import com.application.domainobject.StudentDO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentDO, Long>
{

	@Query(value="Select * from student", nativeQuery = true)
    List<StudentDO> getAll();
}
