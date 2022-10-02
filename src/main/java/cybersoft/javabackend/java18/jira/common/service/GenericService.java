package cybersoft.javabackend.java18.jira.common.service;

import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface GenericService<T extends BaseEntity, D, I> {
    JpaRepository<T, I> getRepository(); // Factory Method

    JiraMapper getMapper();

    default List<T> findAll() {
        return getRepository().findAll();
    }

    default List<T> findAll(Pageable page) {
        return getRepository().findAll(page)
                .stream().toList();
    }

    default List<T> findAllByIds(List<I> ids){
        return getRepository().findAllById(ids);
    }

    default List<D> findAllDto(Class<D> clazz) {
        return getRepository().findAll().stream()
                .map(model -> getMapper().map(model, clazz))
                .collect(Collectors.toList());
    }

    default List<D> findAllDto(Pageable page, Class<D> clazz) {
        return getRepository().findAll(page).stream()
                .map(model -> getMapper().map(model, clazz))
                .collect(Collectors.toList());
    }

    default Optional<T> findById(I id) {
        return getRepository().findById(id);
    }

    default T save(T entity) {
        return getRepository().save(entity);
    }

    default D save(D d, Class<T> tClass, Class<D> dClass) {
        T model = getMapper().map(d, tClass);
        return getMapper().map(getRepository().save(model), dClass);
    }

    default void deleteById(I id) {
        getRepository().deleteById(id);
    }

    default T update(T entity) {
        return getRepository().save(entity);
    }
}
