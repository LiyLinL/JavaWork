package com.liy.generator.exception;

public abstract class CustExpection extends RuntimeException {

    protected String msg;

    protected Object[] list;

    public CustExpection(String msg, Object[] list) {
        this.msg = msg;
        this.list = list;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }

    public Object[] getList() {
        return list;
    }

    public void setList( Object[] list ) {
        this.list = list;
    }
}
