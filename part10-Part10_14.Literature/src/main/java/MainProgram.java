
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        while (true){            
            System.out.print("Input the name of the book, empty stops: ");            
            String bookName = scanner.nextLine();
            if(bookName.equals("")){
                break;
            }                       
            System.out.print("Input the age recommendation: ");
            int recommendedAge = Integer.valueOf(scanner.nextLine());
            Book book = new Book(bookName, recommendedAge);
            books.add(book);
            System.out.println("");
        }
        
        System.out.println("");
        System.out.println(books.size() + " books in total.");
        System.out.println("");
        System.out.println("Books: "); 
        
        Comparator<Book> comparator = Comparator
                        .comparing(Book::getAge)
                        .thenComparing(Book::getName);
        Collections.sort(books, comparator);
        
        for(Book book : books){
            System.out.println(book.toString());
        }

    }

}
