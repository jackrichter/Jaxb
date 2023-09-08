package com.javaguides.javaxmlparser.jaxb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "book")
@XmlType(propOrder = {"id", "title", "author", "publisher", "isbn"})
@Component
public class Book {

    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;

}
