package com.nadim.assignment_teleaus.Model;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class MainModel {
    private List<Data> data;
    private Meta meta;

    public MainModel() {
    }

    public MainModel(List<Data> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
