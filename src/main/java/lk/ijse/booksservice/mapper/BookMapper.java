package lk.ijse.booksservice.mapper;

import lk.ijse.booksservice.dto.BookDTO;
import lk.ijse.booksservice.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookDTO dto){
        return Book.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .imageUrl(dto.getImageUrl())
                .build();
    }

    public BookDTO toDTO(Book entity){
        return BookDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .imageUrl(entity.getImageUrl())
                .build();
    }
}