package com.javaguides.javaxmlparser.jaxb;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@XmlRootElement(namespace = "com.javaguides.javaxmlparser.jaxb")
@Component
public class Bookstore {

    private List<Book> bookList;

    private String bookstoreName;
    private String location;

    @XmlElementWrapper(name = "book_list")
    @XmlElement(name = "book")
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getBookstoreName() {
        return bookstoreName;
    }

    public void setBookstoreName(String bookstoreName) {
        this.bookstoreName = bookstoreName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
