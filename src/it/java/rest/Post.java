package rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Post {

    private int id;
    private String title;


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
