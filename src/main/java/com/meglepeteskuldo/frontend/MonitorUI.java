package com.meglepeteskuldo.frontend;



import com.vaadin.annotations.Theme;
import org.springframework.beans.factory.annotation.Autowired;

import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.frontend.presenter.OrderPresenter;
import com.meglepeteskuldo.frontend.presenter.SurprisePresenter;
import com.meglepeteskuldo.frontend.presenter.UserPresenter;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

//TODO ide fognak jönni autowireddel a servicek, ugyanis azt csak itt fogja tudni beszívni
//TODO szerintem ha konstruktorukba átadjuk a gombLayoutnak meg a viewknak innen, akkor az működhet

//@Theme("ValoTheme")
@SpringUI
@PreserveOnRefresh
public class MonitorUI extends UI {
	
	@Autowired
	private OrderPresenter op;
	
	@Autowired
	private UserPresenter up;
	
	@Autowired
	private SurprisePresenter sp;

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
        mainLayout.setExpandRatio(buttonLayout, 1.0f);
        mainLayout.setExpandRatio(contentLayout, 9.0f);

        buttonLayout.getHomeButton().click();
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
    
    public OrderPresenter getOp() {
		return op;
	}

	public UserPresenter getUp() {
		return up;
	}

	public SurprisePresenter getSp() {
		return sp;
	}
}
