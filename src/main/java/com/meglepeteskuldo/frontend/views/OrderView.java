package com.meglepeteskuldo.frontend.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Krisztián on 2017. 04. 17..
 */
public class OrderView extends VerticalLayout{
    //ide mehet a form szerű dolog küldéssel
	//Most nézem kétféle küldést csináltál melyik lesz végül? (3-as, és 5-ös)
	//Vagy netalántán az egyikből következik a másik?
	
	public OrderView() {
		super();
		setContent();
	}
	
	private void setContent(){
		TextField nameTf = new TextField("Fantázianév");
		ComboBox colorCb = new ComboBox<>("Szín");//lehetne colorpicker is
		ComboBox consistencyCb = new ComboBox<>("Állag");
		ComboBox viscosityCb = new ComboBox<>("Viszkozitás");
		DateField dateDf = new DateField("Keletkezett");
		Button sendBt = new Button("Küldés");
		
		nameTf.setPlaceholder("Fantázianév more");
		sendBt.addClickListener(this::doSend);
		
		this.addComponents(nameTf, colorCb, consistencyCb, viscosityCb, dateDf, sendBt);
	}
	
	private void doSend(ClickEvent e){
		
	}
}
