package com.kuang.pojo;

public class Books {
    @Override
    public String toString() {
        return "Books{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", bookcounts=" + bookcounts +
                ", detail='" + detail + '\'' +
                ", tId=" + tId +
                ", type=" + type +
                '}';
    }

    public Books(Integer bookid, String bookname, Integer bookcounts, String detail, Integer tId) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookcounts = bookcounts;
        this.detail = detail;
        this.tId = tId;
    }

    public Books() {
    }

    private Integer bookid;

    private String bookname;

    private Integer bookcounts;

    private String detail;

    private Integer tId;

    //创建一个对应的书籍类型属性,希望查询员工的同时部门信息也是查询出来
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getBookcounts() {
        return bookcounts;
    }

    public void setBookcounts(Integer bookcounts) {
        this.bookcounts = bookcounts;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }
}