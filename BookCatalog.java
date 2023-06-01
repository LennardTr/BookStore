

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.*;


/**
 * -Create
 * -reade
 * -Update
 * -Delete
 * => Operations on Books
 * 
 */

@RestController
public class BookCatalog {

    private ArrayList<Book> BooksInCatalog;

    @PostMapping("/createCatalog")
    BookCatalog(@RequestBody ArrayList<Book> books)
    {
        BooksInCatalog = books;
    }

    // POST endpoint to create a new book
    @PostMapping("/addBook")
    public void addBookToCatalog(@RequestBody Book book)
    {
      
        BooksInCatalog.add(book);

    }

    // PUT endpoint to update an existing book
    @GetMapping("/books/{id}/get")
    public Book getBook(@PathVariable String id)
    {
        try {
            for (Book b : BooksInCatalog)
            {
                if(b.getId().equals(id))
                {
                    return b;
                }
            }
    
            
        } catch (Exception e) {
            System.out.println("No Book with this identifier found :(");
        }
        
        
    }

    @DeleteMapping("/books/{id}/delete")
     public void deleteBook(@PathVariable String id)
     {
         for (Book b : BooksInCatalog)
         {
             if(b.getId().equals(id))
             {
                 BooksInCatalog.remove(b);
             }
         }   
     }

     @UpdateMapping("/books/{id}/updateTitle/{newTitle}")
     public void updateBookTitle(@PathVariable String id, @PathVariable String newTitle)
     {
         for (Book b : BooksInCatalog)
         {
             if(b.getId().equals(id))
             {
                b.setTitle(newTitle);
             }
         }   
     }

     @UpdateMapping("/books/{id}/updateAuthor/{newAuthor}")
     public void updateBookAuthor(@PathVariable String id, @PathVariable String newAuthor)
     {
         for (Book b : BooksInCatalog)
         {
             if(b.getId().equals(id))
             {
                b.setAuthor(newAuthor);
             }
         }   
     }

     @UpdateMapping("/books/{id}/changePubYear/{newPubYear}")
     public void updateBookPubYear(@PathVariable String id, @PathVariable String newYear)
     {
         for (Book b : BooksInCatalog)
         {
             if(b.getId().equals(id))
             {
                b.setPubYear(newYear);
             }
         }   
     }

    
}