package by.tr.op.bean;

import java.io.Serializable;
import java.sql.Date;

public class Poll implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String theme;
    private int authorId;
    private String state;
    private Date date;

    public Poll() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + (this.theme != null ? this.theme.hashCode() : 0);
        hash = 17 * hash + this.authorId;
        hash = 17 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 17 * hash + (this.date != null ? this.date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poll other = (Poll) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.authorId != other.authorId) {
            return false;
        }
        if (!this.theme.equals(other.theme)) {
            return false;
        }
        if (this.state.equals(other.state)) {
            return false;
        }
        if (!this.date.equals(other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Poll{" + "id=" + id + ", theme=" + theme + ", authorId=" + authorId + ", state=" + state + ", date=" + date + '}';
    }
    
}
