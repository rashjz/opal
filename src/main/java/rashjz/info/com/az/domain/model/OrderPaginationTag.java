/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.domain.model;

import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Azik
 */
public class OrderPaginationTag extends SimpleTagSupport{
    private String url;
   private String uri;
    private String keyValue;
    private String orderUsername;
//    private String firstname;
//    private String lastname;
    private String productId;
    private Integer countOrder;
    private String statusId;
    private String toDate;
    private String fromDate;
    private Integer offset;
    private Integer count;
    private Integer max = 3;
    private Integer steps = 3;
    private String previous = "Previous";
    private String next = "Next";
    
       private Writer getWriter() {
        JspWriter out = getJspContext().getOut();
        return out;
    }
       
    @Override
    public void doTag() throws JspException {
        Writer out = getWriter();

        try {
            out.write("<nav>");
            out.write("<ul class=\"pagination\">");

            if (offset < steps) {
                out.write(constructLink(1, previous, "disabled", true));
            } else {
                out.write(constructLink(offset - steps, previous, null, false));
            }

            for (int itr = 0; itr < count; itr += steps) {
                if (offset == itr) {
                    out.write(constructLink((itr / 3 + 1) - 1 * steps, String.valueOf(itr / 3 + 1), "active", true));
                } else {
                    out.write(constructLink(itr / 3 * steps, String.valueOf(itr / 3 + 1), null, false));
                }
            }

            if (offset + steps >= count) {
                out.write(constructLink(offset + steps, next, "disabled", true));
            } else {
                out.write(constructLink(offset + steps, next, null, false));
            }

            out.write("</ul>");
            out.write("</nav>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Paginator tag", ex);
        }
    } 
    
     private String constructLink(int page, String text, String className, boolean disabled) {
        StringBuilder link = new StringBuilder("<li");
        if (className != null) {
            link.append(" class=\"");
            link.append(className);
            link.append("\"");
        }
        if (disabled) {
            link.append(">").append("<a href=\"#\">" + text + "</a></li>");
        } else {
            url="<a href=\"" + uri + "?offset=" + page + "&&keyValue=" + keyValue;
            if(statusId!=null){
                url=url+"&&statusId.Id=" + statusId;
            }
            if(orderUsername!=null && !orderUsername.equals("")){
                
               url=url+"&&orderUsername=" + orderUsername;
            }
            if(productId!=null){
                url=url+"&&product=" + productId;
            }
            if(toDate!=null && !toDate.equals("")){
                url=url+"&&toDate=" + toDate;
            }
            if(fromDate!=null && !fromDate.equals("")){
                url=url+"&&fromDate=" + fromDate;
            }
            if(countOrder!=null && !countOrder.equals("")){
                url=url+"&&count=" + countOrder;
            }     
            url=url+"\">" + text + "</a></li>";
            link.append(">").append(url);
            
            
//            link.append(">").append("<a href=\"" + uri + "?offset=" + page + "&&keyValue=" + keyValue+ "&&username=" + username +  "&&statusId=" + statusId +"&&toDate=" + toDate + "&&fromDate=" + fromDate + "\">" + text + "</a></li>");
        }
        return link.toString();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String orderUsername() {
        return orderUsername;
    }

    public void setOrderUsername(String orderUsername) {
        this.orderUsername = orderUsername;
    }

//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getCountOrder() {
        return countOrder;
    }

    public void setCountOrder(Integer countOrder) {
        this.countOrder = countOrder;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

  
     
    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
     
     

}
