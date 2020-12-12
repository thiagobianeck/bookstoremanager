package com.bianeck.bookstoremanager.books.repository;

import com.bianeck.bookstoremanager.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
