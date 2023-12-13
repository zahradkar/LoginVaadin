package com.loginvaadin.gui.views;

import com.loginvaadin.backend.entities.Book;
import com.loginvaadin.backend.services.BookService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("books")
@PermitAll
public class AuthenticatedView extends VerticalLayout {
	public AuthenticatedView(BookService service) {
		var crud = new GridCrud<>(Book.class, service);
		crud.getGrid().setColumns("title", "published", "rating");
		crud.getCrudFormFactory().setVisibleProperties("title", "published", "rating");

		add(new H1("Books in library..."), crud);
	}
}
