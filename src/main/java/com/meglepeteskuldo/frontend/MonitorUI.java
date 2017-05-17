package com.meglepeteskuldo.frontend;


import com.meglepeteskuldo.backend.entities.MUser;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

//TODO ide fognak jönni autowireddel a servicek, ugyanis azt csak itt fogja tudni beszívni
//TODO szerintem ha konstruktorukba átadjuk a gombLayoutnak meg a viewknak innen, akkor az működhet

//@Theme("mytheme")
@SpringUI
public class MonitorUI extends UI {
    private MUser user;

    private VerticalLayout mainLayout;
    private VerticalLayout contentLayout;

    private ButtonLayout buttonLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);
        mainLayout.setSizeFull();

        createContentLayout();
        buttonLayout = new ButtonLayout(contentLayout);
        mainLayout.addComponent(buttonLayout);
        mainLayout.addComponent(contentLayout);
        

        setContent(mainLayout);
    }

    private void createContentLayout() {
        contentLayout = new VerticalLayout();
        contentLayout.setSizeFull();
        
    }

    public MUser getUser() {
        return user;
    }

    public void setUser(MUser user) {
        this.user = user;
    }

    public static MonitorUI getCurrent() {
        return (MonitorUI) UI.getCurrent();
    }

    public VerticalLayout getMainLayout() {
        return mainLayout;
    }

    public HorizontalLayout getButtonLayout() {
        return buttonLayout;
    }

    public VerticalLayout getContentLayout() {
        return contentLayout;
    }
}
