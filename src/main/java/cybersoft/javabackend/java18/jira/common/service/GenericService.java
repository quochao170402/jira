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

    default List<D> findAll(Pageable page, Class<D> clazz) {
        return getRepository().findAll(page)
                .stream()
                .map(model -> getMapper().map(model, clazz))
                .toList();
    }


    default List<D> findAll(Class<D> clazz){
        return getRepository().findAll()
                .stream()
                .map(model -> getMapper().map(model, clazz))
                .toList();
    }

    default Optional<T> findById(I id) {
        return getRepository().findById(id);
    }

    default D save(D dto, Class<T> classEntity, Class<D> classDto) {
        return getMapper().map(
                getRepository().save(
                        getMapper().map(dto, classEntity)
                )
                , classDto
        );
    }


    default T update(T entity, I id) {
        return getRepository().save(entity);
    }

    default void delete(I id) {
        getRepository().deleteById(id);
    }
}
