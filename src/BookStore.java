import java.util.*;

public class BookStore {

    HashMap<Integer, Integer> bookMap= new HashMap<>();// для хранения значения колиичества уникальных книг
    ArrayList<Book> books = new ArrayList<>(); // для хранения всех книг

    public void addBook(Book book)        // добавляем книги в магазин
    {
        if(bookMap.containsKey(book.hashCode()))
            bookMap.put(book.hashCode(),bookMap.get(book.hashCode())+1);
        else {books.add(book); bookMap.put(book.hashCode(),1);}
    }

    public boolean  deleteBook(Book book)   // удаляем книгу из магазина
    {
        if(bookMap.get(book.hashCode())>1)
           {
               bookMap.put(book.hashCode(),bookMap.get(book.hashCode())-1); return true;
           }
        else
        {
            bookMap.remove(book.hashCode());
            return books.removeIf(b ->b.equals(book));
        }
    }

    public Book findBook(String name)    // ищем книгу в магазине по названию
    {
        Optional<Book> book=  books.parallelStream()
                .filter(b->b.getName().equals(name))
                .findAny();
        return book.orElse(null);

    }
}
