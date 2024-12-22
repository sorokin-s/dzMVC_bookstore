import java.util.*;

public class BookStore {

    HashMap<Book,Integer> bookMap= new HashMap<>();

    public void addBook(Book book)        // добавляем книги в магазин
    {  int numUniqueBooks=1;              // переменная для учёта количества
                                          // одинаковых книг (здесь это не реализовано)
       bookMap.put(book,numUniqueBooks);
    }
    public int  deleteBook(Book book)   // удаляем книгу из магазина
    {
      return bookMap.remove(book);
    }
    public Book findBook(String name)    // ищем книгу в магазине по названию
    {
     Optional<Book> book = bookMap.keySet()
               .parallelStream()
               .filter(b->b.getName().equals(name) )
               .findAny();
        return book.orElse(null);
    }
}
