package com.mkyong.model;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<Slot> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Slot> getResult() {
        return result;
    }

    public void setResult(List<Slot> result) {
        this.result = result;
    }

}
