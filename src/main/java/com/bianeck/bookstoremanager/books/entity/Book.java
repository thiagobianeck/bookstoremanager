package com.bianeck.bookstoremanager.books.entity;

import com.bianeck.bookstoremanager.author.entity.Author;
import com.bianeck.bookstoremanager.entity.Auditable;
import com.bianeck.bookstoremanager.publishers.entity.Publisher;
import com.bianeck.bookstoremanager.users.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String isbn;

    @Column(columnDefinition = "integer default 0")
    private Integer pages;

    @Column(columnDefinition = "integer default 0")
    private Integer chapters;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Publisher publisher;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private User user;
}
