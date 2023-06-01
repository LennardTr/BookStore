package src.main;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * -getQuantity of Book
 * -when a Book is addet, a quantity is set along with it
 * -quantity can be updated
 */
@RestController
public class BookInventory {
    ArrayList<Book> BookInventory;

    // GET endpoint to get a specific book by ID
    @GetMapping("/books/{id}/getQuantity")
    public int getBookQuantity(@PathVariable String id) {
        
        try {
            for (Book b :BookInventory)
            {
                if(b.getId().equals(id))
                {
                    return b.getQuantity();
                }
            }
    
            
        } catch (Exception e) {
            System.out.println("No Book with this identifier found :(");
        }
        
    }

     // GET endpoint to get a specific book by ID
     @UpdateMapping("/books/{id}/setBookQuantity/{newQuantity}")
     public void setBookQuantity(@PathVariable String id, @PathVariable int newQuantity) {
         
         try {
             for (Book b :BookInventory)
             {
                 if(b.getId().equals(id))
                 {
                   b.setQuantity(newQuantity);
                 }
             }
     
             
         } catch (Exception e) {
             System.out.println("No Book with this identifier found :(");
         }
         
     }

    
    
}
