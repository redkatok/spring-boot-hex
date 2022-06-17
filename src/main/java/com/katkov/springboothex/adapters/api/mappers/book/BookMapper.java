package com.katkov.springboothex.adapters.api.mappers.book;

import com.katkov.springboothex.domain.domaindto.book.AddBookDomainDto;
import com.katkov.springboothex.domain.mvcdto.book.AddBookMvcDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@SuppressWarnings({"SummaryJavadoc", "InvalidJavadocPosition", "MissingJavadocType"})
public interface BookMapper {

    AddBookDomainDto toDomainDto(AddBookMvcDto company);

    AddBookMvcDto toMvcDto(AddBookDomainDto addBookDomainDto);

    @AfterMapping
    default void validateUserDomainDtoState(@MappingTarget AddBookDomainDto addBookDomainDto) {
        addBookDomainDto.validateSelf();
    }

}
