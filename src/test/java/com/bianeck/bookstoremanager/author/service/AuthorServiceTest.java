package com.bianeck.bookstoremanager.author.service;

import com.bianeck.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.bianeck.bookstoremanager.author.dto.AuthorDTO;
import com.bianeck.bookstoremanager.author.entity.Author;
import com.bianeck.bookstoremanager.author.exception.AuthorAlreadyExistsException;
import com.bianeck.bookstoremanager.author.mapper.AuthorMapper;
import com.bianeck.bookstoremanager.author.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp() {
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
    }

    @Test
    @DisplayName("When new author is informed then it should be created")
    void whenNewAuthorIsInformedThenItShouldBeCreated() {
        // given
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);
        // when
        when(authorRepository.save(any(Author.class))).thenReturn(expectedCreatedAuthor);
        when(authorRepository.findByName(expectedAuthorToCreateDTO.getName())).thenReturn(Optional.empty());

        AuthorDTO createdAuthorDTO = authorService.create(expectedAuthorToCreateDTO);
        // then
        assertThat(createdAuthorDTO, is(equalTo(expectedAuthorToCreateDTO)));
    }

    @Test
    @DisplayName("When existing author is informed then an exception should be thrown")
    void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown() {
        // given
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);
        // when
        when(authorRepository.findByName(expectedAuthorToCreateDTO.getName()))
                .thenReturn(Optional.of(expectedCreatedAuthor));
        // then
        Assertions.assertThrows(AuthorAlreadyExistsException.class,
                () -> authorService.create(expectedAuthorToCreateDTO));
    }
}