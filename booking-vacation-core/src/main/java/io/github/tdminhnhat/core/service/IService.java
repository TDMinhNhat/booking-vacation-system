package io.github.tdminhnhat.core.service;

import org.springframework.data.domain.PageImpl;

import java.util.Collection;

public interface IService<S extends Record, P, F extends Record> {
    Object add(S entity);
    Collection<Object> addList(Collection<S> list);
    Object update(P id, S entity);
    Object delete(P id);
    Object getById(P id);
    PageImpl<?> getAll(F filter);
}
