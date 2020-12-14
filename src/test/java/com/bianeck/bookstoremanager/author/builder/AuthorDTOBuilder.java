package com.bianeck.bookstoremanager.author.builder;

import com.bianeck.bookstoremanager.author.dto.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id = 1L;
    @Builder.Default
    private final String name = "Thiago Bianeck";
    @Builder.Default
    private final Integer age = 36;

    public AuthorDTO buildAuthorDTO() {
        return new AuthorDTO(id, name, age);
    }
}
