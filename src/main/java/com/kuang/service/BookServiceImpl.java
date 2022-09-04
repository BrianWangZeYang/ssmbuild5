package com.kuang.service;

import com.kuang.dao.BooksMapper;
import com.kuang.pojo.Books;
import com.kuang.pojo.BooksExample;

import java.util.List;

/**
 * @author xxx
 * @version 1.0
 * @Description
 * @date 2022/8/22 23:20
 */
public class BookServiceImpl implements BookService {

    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper){
        this.booksMapper = booksMapper;
    }
    @Override
    public int addBook(Books book) {
        int addBook = booksMapper.insertSelective(book);
        return addBook;
    }

    @Override
    public int deleteBookById(int id) {
        return booksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateByPrimaryKeySelective(books);
    }

    @Override
    public Books queryBookById(int id) {
        return booksMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return  booksMapper.selectByExampleWithType(null);
    }

    @Override
    public List<Books> queryBookByName(BooksExample booksExample) {
        return booksMapper.selectByExample(booksExample);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {

    }

}
