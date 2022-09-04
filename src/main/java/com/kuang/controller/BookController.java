package com.kuang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuang.pojo.Books;
import com.kuang.pojo.BooksExample;
import com.kuang.pojo.Msg;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/toAllBook")
    public String toAllBook(){
        return "allBook";
    }


    @RequestMapping("/allBook")
    @ResponseBody
    public Msg list(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小

        PageHelper.startPage(pn,5);
        List<Books> emps = bookService.queryAllBook();
        for (Books books:emps) {
            System.out.println(books);
        }
        PageInfo page = new PageInfo(emps, 5);

        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/queryBook")
    @ResponseBody
    public Msg queryBook(String queryBookName){
        System.out.println(queryBookName);
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andBooknameEqualTo(queryBookName);
        List<Books> books = bookService.queryBookByName(booksExample);
        PageInfo page = new PageInfo(books, 5);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping(value = "/queryBookById/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Msg queryBookById(@PathVariable("id")Integer id){
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        return Msg.success().add("Book", books);
    }

    //Ajax增加员工方法，此处使用restful风格
    //由于提交过来的属性和Books类的属性相同，所以此处直接使用Books来接收
    @RequestMapping(value = "/addBook" ,method = RequestMethod.POST)
    @ResponseBody
    public Msg addBookAjax(Books books){
        bookService.addBook(books);
        return Msg.success();
    }


    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        System.out.println("执行到了这里toUpdateBook");
        Books bookById = bookService.queryBookById(id);
        System.out.println(bookById);
        model.addAttribute("books",bookById);
        return "updateBook";
    }

    /**
     * 更新员工
     * @param books
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateBook/{bookID}",method=RequestMethod.PUT)
    @ResponseBody
    public Msg updateBook(Books books, HttpServletRequest request){
        System.out.println("请求体中的值："+request.getParameter("bookName"));
        System.out.println("将要更新的书籍数据:"+books);
        bookService.updateBook(books);
        return Msg.success();
    }

 /*   @ResponseBody
    @RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
    public Msg saveEmp(Employee employee, HttpServletRequest request){
        System.out.println("请求体中的值："+request.getParameter("gender"));
        System.out.println("将要更新的员工数据："+employee);
        employeeService.updateEmp(employee);
        return Msg.success()	;
    }*/

    @ResponseBody
    @RequestMapping(value="/deleteBook/{bookid}",method= RequestMethod.DELETE)
    public Msg deleteBook(@PathVariable("bookid") String ids){

        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
                bookService.deleteBookById(Integer.parseInt(string));
            }
        }else {
            int id = Integer.parseInt(ids);
            bookService.deleteBookById(id);
        }
        return Msg.success();
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }


    //非Ajax增加员工方法
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }


}
