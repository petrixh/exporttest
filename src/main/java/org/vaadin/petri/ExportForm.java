package org.vaadin.petri;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ExportForm extends VerticalLayout {

	public ExportForm() {
		add(new TextField("Name"));
		add(new TextField("Address"));
		add(new TextField("Dob"));
		add(new Button("Submit Exported Form", this::onSubmit));
	}

	private void onSubmit(ClickEvent<Button> buttonClickEvent) {
		Notification.show("Form submitted");
	}
}
