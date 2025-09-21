package io.github.tdminhnhat.core.controller;

import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface IManagementController<S extends Record, P, F extends Record> {
    ResponseEntity<?> add(S entity);
    ResponseEntity<Collection<?>> addList(Collection<S> list);
    ResponseEntity<?> update(P id, S entity);
    ResponseEntity<?> delete(P id);
    ResponseEntity<?> getById(P id);
    ResponseEntity<PageImpl<?>> getAll(F filter);
}
