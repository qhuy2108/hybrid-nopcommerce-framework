package javaOOP.animalWorld;

public class Annimals {
    private String annimalName;
    protected int animalAge = 5;

    protected String getAnnimalName(){
        return annimalName;
    }

    protected void setAnnimalName(String annimalName) {
        this.annimalName = annimalName;
    }
}
