public class Main {
    public static void main(String[] args)
    {

        BookStore bookStore = new BookStore();
        BookStoreView bookStoreView = new BookStoreView();
        BookStoreController controller = new BookStoreController(bookStore,bookStoreView);
    }
}