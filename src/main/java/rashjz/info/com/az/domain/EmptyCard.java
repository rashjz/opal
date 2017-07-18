/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.domain;

import java.io.Serializable;

/**
 *
 * @author Mobby
 */
public class EmptyCard implements Serializable {

    String total;
    String count;
    Integer orderid;

    public EmptyCard() {
    }

    public String getTotal() {
        return total;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "EmptyCard{" + "total=" + total + ", count=" + count + '}';
    }

}
