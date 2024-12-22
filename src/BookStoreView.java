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

    public void displayBookList(HashMap<Book,Integer> hashMap) // выводим список всех книг
    {
        hashMap.forEach((map,k)->System.out.println(map.toString()));
    }
    public void displayMessage(String reply)
    {
        System.out.println(reply);
    }

}
