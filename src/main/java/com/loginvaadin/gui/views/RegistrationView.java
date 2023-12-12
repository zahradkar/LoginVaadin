package com.loginvaadin.gui.views;

import com.loginvaadin.backend.services.UserService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

/**
 * The main view that holds the registration form
 * <p>
 * This view is itself a component (specifically a VerticalLayout) to
 * which the registration form is added. This view is made accessible
 * to the end-user via the @Route annotation.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route("register")
@AnonymousAllowed
public class RegistrationView extends VerticalLayout {

	/**
	 * Construct a new Vaadin view.
	 * <p>
	 * Build the initial UI state for the user accessing the application.
	 */

//	private final UserServiceImpl userService;

	public RegistrationView(UserService userService) {
//		this.userService = userService;

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
