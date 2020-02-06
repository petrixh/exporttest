package org.vaadin.petri;

import com.vaadin.flow.component.WebComponentExporter;
import com.vaadin.flow.component.webcomponent.WebComponent;

public class ExportFormExporter extends WebComponentExporter<ExportForm> {

	public ExportFormExporter() {
		super("export-form");
	}

	@Override
	protected void configureInstance(WebComponent<ExportForm> webComponent, ExportForm component) {

	}
}
