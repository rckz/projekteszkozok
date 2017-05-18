package com.meglepeteskuldo.frontend.views;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Krisztián on 2017. 04. 17..
 */
public class BrowserView extends VerticalLayout {
	
	
	
	private Panel p;
	private HorizontalLayout menuHl;
	private CssLayout picturesCl;
	private VerticalLayout mainVl;
	
	private TextField filterTf;
	
	private ComboBox colorCb;
	private ComboBox consistencyCb;
	private ComboBox viscosityCb;
	
	private DateField dateDf;
	
	private Label picturesL;

	public BrowserView() {
		super();
		setContent();
	}

	private void setContent() {
		p = new Panel();		
		menuHl = new HorizontalLayout();
		//responsive lesz-é? + label-ben lesz a html-kód? ;D
		picturesCl = new CssLayout();
		mainVl = new VerticalLayout(menuHl, picturesCl);
		p.setContent(mainVl);
		
		filterTf = new TextField("Szűrés");
		colorCb = new ComboBox<>();
		consistencyCb = new ComboBox<>();
		viscosityCb = new ComboBox<>();
		dateDf = new DateField();
		
		filterTf.setPlaceholder("Szűrés névre");
		colorCb.setPlaceholder("Színszűrés");
		consistencyCb.setPlaceholder("Állagszűrés");
		viscosityCb.setPlaceholder("Viszkozitásszűrés");
		
		menuHl.addComponents(filterTf, colorCb, consistencyCb, viscosityCb, dateDf);
		
		picturesL = new Label();
		
		picturesCl.addComponent(picturesL);
		
		this.addComponent(p);
		
	}
	
}
