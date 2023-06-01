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
 * Users place Orders for Books
 * 
 */
@RestController
public class BookOrders {

    /**Orders include:
     * -Book id
     * -quantity ordered
     * -date Of The Order
     * 
     * When order is placed ->update inventory
     * 
     */
  
   
   

   @GetMapping("/orders/{bookId}/{quantity}/{date}")
   public Order placeOrder(@PathVariable String bookId, @PathVariable int quantity, @PathVariable int date) {
       // Add your order placement logic here
       // Update inventory, process the order, etc.
       Order newO = new Order(bookId, quantity, date);
       
   }
   public class Order
   {
    String BookId;
    int quantity;
    int date;

   Order( String bookId, int quantity, int date)
   {
    this.BookId = bookId;
    this.quantity = quantity;
    this.date = date;
   }

   }
}
