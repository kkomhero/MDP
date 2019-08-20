package com.mbg.otdev.esDemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "#{config.saveIndexName}", type = "greetings")
//@Document(indexName = "myIndex", type = "greetings")
public class Greeting {


    //@Field( type = FieldType.Keyword)
    @Id
    private String id;

    //@Field( type = FieldType.Keyword)
    private String username;

    //@Field( type = FieldType.Keyword)
    private String message;

    //@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date greetingday;

    public Date getGreetingday() {
        return greetingday;
    }

    public void setGreetingday(Date greetingday) {
        this.greetingday = greetingday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
