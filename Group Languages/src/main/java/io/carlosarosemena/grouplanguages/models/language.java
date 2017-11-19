package io.carlosarosemena.grouplanguages.models;

public class language {

    private String name;
    private String creator;
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
