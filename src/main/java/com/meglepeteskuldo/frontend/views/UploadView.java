package com.meglepeteskuldo.frontend.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class UploadView extends VerticalLayout {
	
	private ComboBox colorCb;
	private ComboBox consistencyCb;
	private ComboBox viscosityCb;
	
	private TextField nameTf;
	
	private Button sendBt;
	
	private DateField dateDf;
	
	public UploadView() {
		super();
		setContent();
	}
	
	
	private void setContent(){
		nameTf = new TextField("Fantázianév");
		colorCb = new ComboBox<>("Szín");
		consistencyCb = new ComboBox<>("Állag");
		viscosityCb = new ComboBox<>("Viszkozitás");
		dateDf = new DateField("Keletkezett");
		sendBt = new Button("Küldés");
		
		nameTf.setPlaceholder("Fantázianév more");
		sendBt.addClickListener(this::doSend);
		
		this.addComponents(nameTf, colorCb, consistencyCb, viscosityCb, dateDf, sendBt);
	}
	
	private void doSend(ClickEvent e){
		
	}
}
