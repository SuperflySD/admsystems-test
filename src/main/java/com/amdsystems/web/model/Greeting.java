package com.amdsystems.web.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Greeting implements Serializable{

    private long id;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}