package io.carlosarosemena.grouplanguages.models;

import javax.validation.constraints.Size;

public class language {

    @Size(min=2, max = 20, message = "Name must be between 2 and 20 Characters")
    private String name;
    @Size(min=2, max = 20, message = "Creator must be between 2 and 20 Characters")
    private String creator;
    @Size(min=1, message = "Version cannot be empty")
    private String version;

    public language(){

    }

    public language(String name, String creator, String version) {
        this.name = name;
        this.creator = creator;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
