package com.meglepeteskuldo.frontend.views;

import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.frontend.MonitorUI;
import com.meglepeteskuldo.frontend.presenter.SurprisePresenter;
import com.vaadin.ui.*;

import java.util.List;

public class BrowserView extends VerticalLayout {

	public BrowserView() {
		super();
		setContent();
	}

	private void setContent() {
		TextField filterTf = new TextField();
		TextField colorCb = new TextField();

		
		filterTf.setPlaceholder("Szűrés névre");
		colorCb.setPlaceholder("Színszűrés");

		HorizontalLayout menuHl = new HorizontalLayout();
		menuHl.addComponents(filterTf, colorCb);

		Panel surpisePanel = new Panel();
		surpisePanel.setContent(showSurpises());

		this.addComponent(menuHl);
		this.addComponent(surpisePanel);
	}

	private VerticalLayout showSurpises(){
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		List<Surprise> surprises = MonitorUI.getCurrent().getSp().getAllSurprise();
		for (Surprise surprise : surprises) {
			HorizontalLayout surpriseLayout = new HorizontalLayout();
			surpriseLayout.setSizeFull();
			surpriseLayout.addComponent(createSurpiseTags(surprise.getProductName()));
			surpriseLayout.addComponent(createSurpiseTags(surprise.getColor()));
			surpriseLayout.addComponent(createSurpiseTags(String.valueOf(surprise.getConsistency())));
			surpriseLayout.addComponent(createSurpiseTags(String.valueOf(surprise.getPrice())+"$"));

			layout.addComponent(surpriseLayout);
			layout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		}

		return layout;
	}

	private Label createSurpiseTags(String value){
		Label label = new Label(value);
		label.setWidth(100, Unit.PIXELS);
		return label;
	}
	
}
