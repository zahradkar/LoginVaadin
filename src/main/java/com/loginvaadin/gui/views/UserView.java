package com.loginvaadin.gui.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route("user")
@RolesAllowed("USER")
public class UserView extends VerticalLayout {
	public UserView() {
		add(new H1("User view"));
	}
}
