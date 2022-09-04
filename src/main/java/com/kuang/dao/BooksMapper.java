package com.kuang.dao;

import com.kuang.pojo.Books;
import com.kuang.pojo.BooksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BooksMapper {
    long countByExample(BooksExample example);

    int deleteByExample(BooksExample example);

    int deleteByPrimaryKey(Integer bookid);

    int insert(Books record);

    int insertSelective(Books record);

    List<Books> selectByExample(BooksExample example);

    Books selectByPrimaryKey(Integer bookid);

    int updateByExampleSelective(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByExample(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);

    //为了更方便的查询出书籍类型数据，这里专门设计两个方法
    List<Books> selectByExampleWithType(BooksExample example);

    Books selectByPrimaryKeyWithType(Integer bookid);
}