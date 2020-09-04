package com.jpa.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.jpa.audit.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>, RevisionRepository<Book, Integer, Integer> {

}
