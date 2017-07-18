/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.domain;

import java.util.ArrayList;
import java.util.List;
import rashjz.info.com.az.entity.Orders;


/**
 *
 * @author Azik
 */
public class PagingResultOrder {
    
    private List<Orders> list = new ArrayList<>();
    private Integer totalResult = 0;
    private String username;
    private String productId;
    private String countOrder;
    private String statusId;
    private float toDate;
    private String fromDate;

    public List<Orders> getList() {
        return list;
    }

    public void setList(List<Orders> list) {
        this.list = list;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCountOrder() {
        return countOrder;
    }

    public void setCountOrder(String countOrder) {
        this.countOrder = countOrder;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public float getToDate() {
        return toDate;
    }

    public void setToDate(float toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    
    
    
    
}
