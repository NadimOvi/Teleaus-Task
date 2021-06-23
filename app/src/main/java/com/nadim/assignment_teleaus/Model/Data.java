package com.nadim.assignment_teleaus.Model;

import org.parceler.Parcel;

@Parcel
public class Data {
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String type;
    private Profile profile;
    private String verified_at;
    private String created_at;
    private String updated_at;

    public Data() {
    }

    public Data(Integer id, String first_name, String last_name, String email, String username, String type, Profile profile, String verified_at, String created_at, String updated_at) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.type = type;
        this.profile = profile;
        this.verified_at = verified_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getVerified_at() {
        return verified_at;
    }

    public void setVerified_at(String verified_at) {
        this.verified_at = verified_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
