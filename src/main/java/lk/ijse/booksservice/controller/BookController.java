package lk.ijse.booksservice.controller;

import lk.ijse.booksservice.dto.BookDTO;
import lk.ijse.booksservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {

    private final BookService service;

    @PostMapping
    public BookDTO save(@RequestBody BookDTO dto){
        return service.save(dto);
    }

    @GetMapping
    public List<BookDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BookDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public BookDTO update(@PathVariable Long id, @RequestBody BookDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}