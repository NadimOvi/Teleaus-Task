package com.nadim.assignment_teleaus.Model;

import org.parceler.Parcel;

@Parcel
public class Meta {
    private Integer last_page;
    private String next_page_url;
    private String prev_page_url;
    private Integer total;

    public Meta() {
    }

    public Meta(Integer last_page, String next_page_url, String prev_page_url, Integer total) {
        this.last_page = last_page;
        this.next_page_url = next_page_url;
        this.prev_page_url = prev_page_url;
        this.total = total;
    }

    public Integer getLast_page() {
        return last_page;
    }

    public void setLast_page(Integer last_page) {
        this.last_page = last_page;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(String prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
