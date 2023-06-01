package src.main;
/**
 * -unique iD
 * -title
 * -Author
 * -pub-Year
 */
public class Book {

     private String title;
     private String id;
     private String author;
     private int pubYear;
     private int howMany;

     Book(String title, String id, String author, int pubYear, int quantity) {
          this.title = title;
          this.id = id;
          this.author = author;
          this.pubYear = pubYear;
          this.quantity = quantity;
     }

     // Getter for title
     public String getTitle() {
          return title;
     }

     // Setter for title
     public void setTitle(String title) {
          this.title = title;
     }

      // Getter for number
      public String getNumber() {
          return howMany;
     }

     // Setter for number
     public void setNumber(int number) {
          this.number= number;
     }
     // Getter for id
     public String getId() {
          return id;
     }

     // Setter for id
     public void setId(String id) {
          this.id = id;
     }

     // Getter for author
     public String getAuthor() {
          return author;
     }

     // Setter for author
     public void setAuthor(String author) {
          this.author = author;
     }

     // Getter for pubYear
     public int getPubYear() {
          return pubYear;
     }

     // Setter for pubYear
     public void setPubYear(int pubYear) {
          this.pubYear = pubYear;
     }

}