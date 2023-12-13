package com.loginvaadin.gui.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route("auth")
@PermitAll
public class AuthenticatedView extends VerticalLayout {
	public AuthenticatedView() {
		add(new H1("Authenticated view"));
	}
}
