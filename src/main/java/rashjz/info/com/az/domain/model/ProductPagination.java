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
public class ProductPagination extends SimpleTagSupport{
    private String url;
    private String uri;
    private String keyValue;
    private String catgs;
    private String brands;
    private String gendertype;
    private String toDate;
    private String fromDate;
    private String title;
    private Integer price;
    private Integer offset;
    private Integer count;
    private Integer max = 10;
    private Integer steps = 10;
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
                    out.write(constructLink((itr / 10 + 1) - 1 * steps, String.valueOf(itr / 10 + 1), "active", true));
                } else {
                    out.write(constructLink(itr / 10 * steps, String.valueOf(itr / 10 + 1), null, false));
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
            System.out.println("55555555555555555555555555");
            System.out.println("text-----"+text);
            link.append(">").append("<a href=\"#\">" + text + "</a></li>");
        } else {
            System.out.println("2222 "+price+ " "+title+" "+toDate+"f "+gendertype);
            System.out.println(!title.equals(""));
             url="<a href=\"" + uri + "?offset=" + page + "&&keyValue=" + keyValue;
            if(title!=null && !title.equals("")){
                
               url=url+"&&title=" + title;
                System.out.println("1");
            }
            if(price!=null){
                url=url+"&&price=" + price;
                System.out.println("2");
            }
            if(toDate!=null && !toDate.equals("")){
                url=url+"&&toDate=" + toDate;
                System.out.println("3");
            }
            if(fromDate!=null && !fromDate.equals("")){
                url=url+"&&fromDate=" + fromDate;
                System.out.println("4");
            }
            if(catgs!=null && !catgs.equals("")){
                url=url+"&&catgs=" + catgs;
                System.out.println("5");
            }
            if(brands!=null && !brands.equals("")){
                url=url+"&&brands=" + brands;
                System.out.println("6");
            }
            if(gendertype!=null && !gendertype.equals("")){
                url=url+"&&gender=" + gendertype;
            }
            url=url+"\">" + text + "</a></li>";
            System.out.println("44444444444444444 "+url);
            link.append(">").append(url);
//            else{ 
//            link.append(">").append("<a href=\"").append(uri).append("?offset=").append(page).append("&&keyValue=").append(keyValue).append("&&title=").append(title).append("&&toDate=").append(toDate).append("&&fromDate=").append(fromDate).append("&&catgs=").append(catgs).append("&&brands=").append(brands).append("&&gendertype=").append(gendertype).append("\">").append(text).append("</a></li>");
//            }
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

    public String getCatgs() {
        return catgs;
    }

    public void setCatgs(String catgs) {
        this.catgs = catgs;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getGendertype() {
        return gendertype;
    }

    public void setGendertype(String gendertype) {
        this.gendertype = gendertype;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
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
