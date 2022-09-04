import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author xxx
 * @version 1.0
 * @Description
 * @date 2022/9/4 12:02
 */
public class MyTest {
     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");




    @Test
    public void queryBookById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        bookServiceImpl.queryBookById(9);
    }

    @Test
    public void queryAllBook(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        List<Books> booksList = bookServiceImpl.queryAllBook();
        for (Books book: booksList) {
            System.out.println(book);
        }

    }
    @Test
    public void queryBookByName(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        // Books books = bookServiceImpl.queryBookByName("狂神");
        // System.out.println(books);
    }

}
