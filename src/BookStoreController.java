import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;


public class BookStoreController
{
    enum Command {add,del,find,dis,exit}; // команды пользователя
    Command command;
    private BookStore model;
    private BookStoreView view;
    Scanner sc = new Scanner(System.in);

    public BookStoreController(BookStore model, BookStoreView view) // КОНСТРУКТОР КЛАССА
    {
        this.model = model;
        this.view = view;
        model.addBook(new Book("Book1","Author1")); // добавляем несколько елементов
        model.addBook(new Book("Book2","Author2"));
        controllerWork();
    }
    public void controllerWork()   //метод получает пользовательские команды
    {                              // и выполняет их запуская соотв методы
        while(true)
        {
            view.displayMessage("Введите ваш запрос:");
            if(getCommand())
            {
                switch(command)
                {
                    case dis: displayBookStore();
                        break;
                    case add: {view.displayMessage("Введите название книги" +
                            " и имя автора разделив их ';' ");addInBookStore(sc.nextLine());}
                    break;
                    case del:{view.displayMessage("Введите название книги" +
                            " и имя автора разделив их ';' ");delFromBookStore(sc.nextLine());}
                    break;
                    case find:{view.displayMessage("Введите название книги для поиска");
                        findInBookStore(sc.nextLine());}
                    break;
                    case exit: exit(0);

                }
            }
            else view.displayMessage("Введена неправильная команда");
            if(command!=null)command=null;
        }
    }
    public boolean getCommand()   // метод получения пользовательских команд
    {
        switch (sc.nextLine())
        {
            case "add":command =Command.add;
            break;
            case "del":command =Command.del;
            break;
            case "find":command =Command.find;
            break;
            case "dis":command =Command.dis;
            break;
            case "exit":command =Command.exit;
            break;

        }
        return command != null;
    }

    public void findInBookStore(String name) //метод поиск книги по названию
    {
        if(model.findBook(name)!=null)view.displayMessage("Найдена: "+model.findBook(name).toString());
       else view.displayMessage(name+" не найдена");
    }
    public void addInBookStore(String name_author) //метод добавление книги в магазин
    {   String name,author;
        var t = Arrays.stream(name_author.trim().split(";")).toList();
        if(t.size()==2)
        {   name = t.getFirst();
            author = t.getLast();
            Book book =new Book(name,author);
            model.addBook(book);
            view.displayMessage(book+ " добавлена" );
        }else view.displayMessage("Некорректно введённые данные" );

    }
    public  void delFromBookStore(String name_author)  // метод удаление книги из магазина
    {
        String name,author;
        var t = Arrays.stream(name_author.trim().split(";")).toList();
        if(t.size()==2)
        {   name = t.getFirst();
            author = t.getLast();
            Book book = new Book(name,author);
            if(model.deleteBook(new Book(name,author)))view.displayMessage(book+ "удалена");
            else view.displayMessage(book+" не была удалена т.к. не была надена");
        }else view.displayMessage("Некорректно введённые данные" );

    }
    public void displayBookStore()      // метод просмотра списка всех книг
    {
        for(Book book :model.books)
        {
            view.displayBookList(book.toString()+" количество: "+ model.bookMap.get(book.hashCode()));
        }
//        view.displayBookList(model.bookMap.toString());
    }

}
