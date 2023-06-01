import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookCatalogController {

    private List<Book> booksInCatalog;

    @Autowired
    public BookCatalogController() {
        booksInCatalog = new ArrayList<>();
    }

    // POST endpoint to create a new book
    @PostMapping("/books")
    public ResponseEntity<Void> addBookToCatalog(@RequestBody Book book) {
        booksInCatalog.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // GET endpoint to retrieve a book by id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        for (Book book : booksInCatalog) {
            if (book.getId().equals(id)) {
                return ResponseEntity.ok(book);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE endpoint to delete a book by id
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        for (Book book : booksInCatalog) {
            if (book.getId().equals(id)) {
                booksInCatalog.remove(book);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    // PUT endpoint to update the title of a book by id
    @PutMapping("/books/{id}/title")
    public ResponseEntity<Void> updateBookTitle(@PathVariable String id, @RequestBody String newTitle) {
        for (Book book : booksInCatalog) {
            if (book.getId().equals(id)) {
                book.setTitle(newTitle);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    // PUT endpoint to update the author of a book by id
    @PutMapping("/books/{id}/author")
    public ResponseEntity<Void> updateBookAuthor(@PathVariable String id, @RequestBody String newAuthor) {
        for (Book book : booksInCatalog) {
            if (book.getId().equals(id)) {
                book.setAuthor(newAuthor);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    // PUT endpoint to update the publication year of a book by id
    @PutMapping("/books/{id}/publicationYear")
    public ResponseEntity<Void> updateBookPublicationYear(@PathVariable String id, @RequestBody String newPublicationYear) {
        for (Book book : booksInCatalog) {
            if (book.getId().equals(id)) {
                book.setPublicationYear(newPublicationYear);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}