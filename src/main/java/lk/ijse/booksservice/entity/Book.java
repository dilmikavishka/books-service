package lk.ijse.booksservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PostgreSQL SERIAL
    private Long id;
    private String title;
    private String author;
    private String imageUrl;
}