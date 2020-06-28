package com.api.filmes.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.filmes.event.EventResourceCreated;

@Component
public class ListenerResourceCreated implements ApplicationListener<EventResourceCreated>{

	@Override
	public void onApplicationEvent(EventResourceCreated eventResourceCreated) {
		HttpServletResponse response = eventResourceCreated.getResponse();
		Long id = eventResourceCreated.getId();
		
		addHeaderLocation(response, id);
	}

	private void addHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
	}

}
