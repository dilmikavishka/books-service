package lk.ijse.booksservice.service;

import lk.ijse.booksservice.dto.BookDTO;
import java.util.List;

public interface BookService {
    BookDTO save(BookDTO dto);
    List<BookDTO> getAll();
    BookDTO getById(Long id);
    void delete(Long id);
    BookDTO update(Long id, BookDTO dto);
}