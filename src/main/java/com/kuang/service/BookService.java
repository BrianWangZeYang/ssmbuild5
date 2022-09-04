package com.kuang.service;

import com.kuang.pojo.Books;
import com.kuang.pojo.BooksExample;

import java.util.List;

/**
 * @author xxx
 * @version 1.0
 * @Description
 * @date 2022/8/22 23:19
 */
public interface BookService {
    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询，返回一个Book
    Books queryBookById(int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //通过名字模糊查询书籍
    List<Books> queryBookByName(BooksExample booksExample);

    //批量删除书籍
    void deleteBatch(List<Integer> ids);
}
