package com.meglepeteskuldo.frontend;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by Krisztián on 2017. 04. 17..
 */
public class ButtonLayout extends HorizontalLayout {
    private Button homeButton;
    private Button browserButton;
    private Button orderButton;
    private Button loginButton;

    public ButtonLayout() {
        setWidth(100, Unit.PERCENTAGE);
        setHeight(40, Unit.PIXELS);
        //setMargin(true);
        setSpacing(true);
        init();
    }

    private void init() {
        homeButton = new Button("Főoldal");
        customizeButton(homeButton);

        browserButton = new Button("Böngészés");
        customizeButton(browserButton);

        orderButton = new Button("Rendelés");
        customizeButton(orderButton);

        loginButton = new Button("Belépés");
        customizeButton(loginButton);
        loginButton.setStyleName("link");
    }

    private void customizeButton(Button button){
        //button.setWidth(70, Unit.PIXELS);
        //button.setHeight(30, Unit.PIXELS);
        //button.addStyleName("button-navigation");
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }
}
