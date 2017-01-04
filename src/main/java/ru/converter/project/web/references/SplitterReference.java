package ru.converter.project.web.references;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Реализация интерфейса {@link ReferenceBase}.
 * 
 * @author Alimurad A. Ramazanov
 * @since 04.01.2017
 * @version 1.0
 *
 */
@Component
public class SplitterReference implements ReferenceBase {

	private static final long serialVersionUID = 1L;

	public static final String PATH = "/merge";

	@Override
	public String getHref() {
		UriComponents uriComponents = UriComponentsBuilder.fromPath(PATH).build();
		return uriComponents.expand().toString();
	}

	@Override
	public String getRelation() {
		return "merge";
	}

	@Override
	public File doPost(List<MultipartFile> file, String name) {
		// TODO post for merge
		return null;
	}

}
