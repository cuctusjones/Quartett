package com.example.jens.quartett;

/**
 * Created by Jens on 02/01/2018.
 */

public class Image {
    private int id;
    private String filename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Image(int id, String filename) {

        this.id = id;
        this.filename = filename;
    }
}
