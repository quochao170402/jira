package cybersoft.javabackend.java18.jira.common.service;

import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenericService<T extends BaseEntity, D, I> {
    JpaRepository<T, I> getRepository();
    JiraMapper getMapper();

    default List<T> findAll() {
        return getRepository().findAll().stream().toList();
    }

    default List<T> findAll(Pageable page) {
        return getRepository().findAll(page).stream().toList();
    }

    default List<D> findAllDto(Class<D> clazz){
        return getRepository().findAll()
                .stream()
                .map(model -> getMapper().map(model, clazz))
                .toList();
    }

    default Optional<T> findById(I id) {
        return getRepository().findById(id);
    }

    default T save(T entity) {
        return getRepository().save(entity);
    }

    default T update(T entity, I id) {
        return getRepository().save(entity);
    }

    default void delete(I id) {
        getRepository().deleteById(id);
    }
}
