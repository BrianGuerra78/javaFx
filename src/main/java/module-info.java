module org.bguerra.javafx.app.javafxappdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires spring.webflux;
    requires reactor.core;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens org.bguerra.javafx.app.javafxappdemo to javafx.base;
    opens org.bguerra.javafx.app.javafxappdemo.models to javafx.base, com.fasterxml.jackson.databind;
    exports org.bguerra.javafx.app.javafxappdemo;
}