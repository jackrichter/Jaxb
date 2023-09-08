package com.javaguides.javaxmlparser.jaxb;

import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class BookstoreService {

    private final String BOOKSTORE_XML = "bookstore-jaxb.xml";

    private List<Book> bookList = new ArrayList<>();
    private Bookstore bookstore = new Bookstore();

    @PostConstruct
    private void setup() {
        System.out.println("In PostConstruct method");

        // Create books
        Book book1 = new Book(1L, "Effective Java", "Joshua Bloch",
                "Amazon","978-0134685991");
        bookList.add(book1);

        Book book2 = new Book(2L, "Head First Java", "Kathy Sierra",
                "amazon", "978-0596009205");
        bookList.add(book2);

        // Create bookstore
        bookstore.setBookstoreName("Amazon Bookstore");
        bookstore.setLocation("NewYork");
        bookstore.setBookList(bookList);
    }


    /**
     * Marshall
     */
    public String convertObjectToXml() {
        System.out.println("Marshalling");
        StringWriter writer = new StringWriter();

        // create JAXB context and instantiate marshaller
        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // write to StringWriter
            marshaller.marshal(bookstore, writer);

            // write to file
            marshaller.marshal(bookstore, new File(BOOKSTORE_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    /**
     * Unmarshall
     */
    public Bookstore convertXmlToObject() {
        System.out.println("Unmarshalling");
        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Bookstore bookstore = (Bookstore) unmarshaller.unmarshal(new File(BOOKSTORE_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return bookstore;
    }
}
