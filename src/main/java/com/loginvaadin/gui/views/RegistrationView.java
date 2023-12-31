package com.loginvaadin.gui.views;

import com.loginvaadin.backend.services.UserService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("register")
@AnonymousAllowed
@PageTitle("Register | Vaadin library")
public class RegistrationView extends VerticalLayout {

	public RegistrationView(UserService userService) {
		RegistrationForm registrationForm = new RegistrationForm();
		// Center the RegistrationForm
		setSizeFull();
		setHorizontalComponentAlignment(Alignment.CENTER, registrationForm);
		setJustifyContentMode(JustifyContentMode.CENTER);

		add(registrationForm);

		RegistrationFormBinder registrationFormBinder = new RegistrationFormBinder(registrationForm, userService);
		registrationFormBinder.addBindingAndValidation();
	}
}
