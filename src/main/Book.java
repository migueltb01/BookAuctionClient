package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
    private StringProperty name;
    private IntegerProperty value;
    private StringProperty status;

    public Book(String name, String status, Integer value) {
        this.name = new SimpleStringProperty(name);
        this.status = new SimpleStringProperty(status);
        this.value = new SimpleIntegerProperty(value);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getValue() {
        return value.get();
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public void setValue(int value) {
        this.value.set(value);
    }

    public String getstatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setstatus(String status) {
        this.status.set(status);
    }
}
