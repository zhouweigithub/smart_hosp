package com.ruoyi.system.dto.req;

import java.io.Serializable;

public class WareHouseOutBoundReq implements Serializable {

    /**
     * 入库记录
     */
    private String id;

    /**
     * 出库数量
     */
    private int num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
