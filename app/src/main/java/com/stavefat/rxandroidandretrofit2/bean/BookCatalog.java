package com.stavefat.rxandroidandretrofit2.bean;

/**
 * ================================================
 * ProjectName: RxandroidAndRetrofit2
 * Author: ngh(stevefat)
 * CreateDate :16-7-8下午4:19
 * ================================================
 */
public class BookCatalog extends BaseInfo {
    private int booksid; //书籍的sid
    private int sid;  //目录sid
    private int pid;  //父目录id
    private String text; //目录名字

    public int getBooksid() {
        return booksid;
    }

    public void setBooksid(int booksid) {
        this.booksid = booksid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
