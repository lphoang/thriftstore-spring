package com.library.Library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(nullable = false, updatable = false)
    private String id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(
            nullable = false,
            name = "book_genre_id"
    )
    private BookGenre bookGenre;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(
            nullable = false,
            name = "author_id"
    )
    private Author author;
    private String title;
    private String releaseDate;
    @Lob
    private String description;
    private Double score;
    private Double price;
    private String thumbnail;

    public Book(
            BookGenre bookGenre,
            Author author,
            String title,
            String releaseDate,
            String description,
            Double score,
            Double price,
            String thumbnail) {
        this.bookGenre = bookGenre;
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
        this.score = score;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id + '\'' +
                ", title = " + title + '\'' +
                ", release date = " + releaseDate + '\'' +
                ", score = " + score + '\'' +
                ", price = " + price + '\'' +
                ", description = " + description + '\'' +
                "}";
    }
}
