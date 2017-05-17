package com.meglepeteskuldo.frontend.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Krisztián on 2017. 04. 17..
 */
public class OrderView extends VerticalLayout{
    //ide mehet a form szerű dolog küldéssel
	
	private ComboBox nameCb;
	private ComboBox optionsCb;
	
	private TextArea addressTa;
	private TextArea msgTa;
	
	private Button sendBt;
	
	public OrderView() {
		super();
		setContent();
	}
	
	private void setContent(){
		nameCb = new ComboBox<>();
		optionsCb = new ComboBox<>();
		addressTa = new TextArea();
		msgTa = new TextArea();
		sendBt = new Button("Küldés");
		
		nameCb.setPlaceholder("Termék fantázianeve");
		optionsCb.setPlaceholder("Csomag opciók");
		addressTa.setPlaceholder("Csomag címzése");
		msgTa.setPlaceholder("Üzenet a címzettnek");
		sendBt.addClickListener(this::doSend);
		
		this.addComponents(nameCb, optionsCb, addressTa, msgTa, sendBt);
	}
	
	private void doSend(ClickEvent e){
		
	}
}
