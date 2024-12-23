import java.util.ArrayList;
import java.util.HashMap;

public class BookStoreView
{
    public BookStoreView()
    {
        System.out.println("Приложение \"Управление магазином книг\".");
        System.out.println("С учётом патерна MVC");
        System.out.println("Список команд доступных пользователю\n" +
                "add,del,find,dis,exit\n(после ввода команды нажимайте enter\n" +
                "и потом вводите данные если требуется)\n");
    }

    public void displayBookList(String strBook) // выводим список всех книг
    {
       System.out.println(strBook);
    }
    public void displayMessage(String reply)
    {
        System.out.println(reply);
    }

}
