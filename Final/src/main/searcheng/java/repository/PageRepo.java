package java.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.model.Page;


@Repository
public interface PageRepo extends CrudRepository<Page, Integer> {
}
