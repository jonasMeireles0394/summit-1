package org.uniube.summit.domain;

import jakarta.persistence.*;

public class Image {
    private Long id;

    private String file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", file=" + file +
                '}';
    }
}
