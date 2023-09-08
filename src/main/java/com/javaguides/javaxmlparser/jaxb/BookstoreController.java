package com.javaguides.javaxmlparser.jaxb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookstoreController {

    private final BookstoreService service;

    @GetMapping("/unmarshall")
    public String createBookObjectFromXml() {
        Bookstore bookstore = service.convertXmlToObject();
        StringBuffer stringBuffer = new StringBuffer();
        for (Book book : bookstore.getBookList()) {
            stringBuffer.append(book.toString() + "\n");
        }

        return  stringBuffer.toString();
    }

    @GetMapping("/marshall")
    public String createXmlFromObject() {
        return service.convertObjectToXml();
    }
}
