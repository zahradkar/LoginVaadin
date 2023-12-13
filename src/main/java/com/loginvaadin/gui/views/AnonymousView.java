package com.loginvaadin.gui.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("")
@AnonymousAllowed
public class AnonymousView extends VerticalLayout {
	public AnonymousView() {
		add(new H1("Home (anonymous) view"));
	}
}
