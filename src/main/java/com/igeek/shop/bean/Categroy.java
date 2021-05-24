package com.igeek.shop.bean;

public class Categroy {
    private String cid;
    private String cname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Categroy() {
        super();
    }

    public Categroy(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }
}
