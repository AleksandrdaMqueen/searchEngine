package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Page;


@Repository
public interface PageRepo extends CrudRepository<Page, Integer> {
}
