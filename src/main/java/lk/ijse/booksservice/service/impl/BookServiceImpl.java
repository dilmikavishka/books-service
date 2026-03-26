package lk.ijse.booksservice.service.impl;

import lk.ijse.booksservice.dto.BookDTO;
import lk.ijse.booksservice.entity.Book;
import lk.ijse.booksservice.mapper.BookMapper;
import lk.ijse.booksservice.repository.BookRepository;
import lk.ijse.booksservice.service.BookService;
import lk.ijse.booksservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repo;
    private final BookMapper mapper;

    @Override
    public BookDTO save(BookDTO dto) {
        Book book = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(book));
    }

    @Override
    public List<BookDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public BookDTO getById(Long id) {
        Book book = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        return mapper.toDTO(book);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public BookDTO update(Long id, BookDTO dto) {
        Book book = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setImageUrl(dto.getImageUrl());
        return mapper.toDTO(repo.save(book));
    }
}