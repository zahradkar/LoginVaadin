package com.loginvaadin.gui.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;

public class LoginOverlayFooter extends Div implements BeforeEnterObserver {
	private final LoginOverlay loginOverlay = new LoginOverlay();

	public LoginOverlayFooter() {
		// tag::snippet[]
		loginOverlay.setTitle("Vaadin's library ;)");
		loginOverlay.setDescription("Basic CRUD ops with books example");
//		loginOverlay.setDescription("Demonstration of storing books in the database");
		loginOverlay.setForgotPasswordButtonVisible(false);
		var btnRegister = new Button("Not registered?");
		btnRegister.setSizeFull();
		btnRegister.addClickListener(buttonClickEvent -> getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:8080/register")));
		loginOverlay.getFooter().add(btnRegister);
		// end::snippet[]
		add(loginOverlay);
		loginOverlay.setOpened(true);
		loginOverlay.setAction("login");
		// Prevent the example from stealing focus when browsing the documentation
		loginOverlay.getElement().setAttribute("no-autofocus", "");
	}

	@Override
	public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		if (beforeEnterEvent.getLocation()
				.getQueryParameters()
				.getParameters()
				.containsKey("error")) {
			loginOverlay.setError(true);
		}
	}
}
