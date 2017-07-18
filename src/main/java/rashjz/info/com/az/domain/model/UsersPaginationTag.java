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
public class UsersPaginationTag extends SimpleTagSupport {
    
    private String uri;
    private String keyValue;
    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private Integer enabled;
    private int offset;
    private int count;
    private int max = 10;
    private int steps = 10;
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
            link.append(">").append("<a href=\"#\">" + text + "</a></li>");
        } else {
            
            link.append(">").append("<a href=\"" + uri + "?offset=" + page + "&&keyValue=" + keyValue + "&&username=" + username + "&&firstname=" +  firstname +  "&&lastname=" + lastname +  "&&phone=" + phone + "&&enabled=" + enabled + "\">" + text + "</a></li>");
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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
