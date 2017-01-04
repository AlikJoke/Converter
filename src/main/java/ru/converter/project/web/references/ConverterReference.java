package ru.converter.project.web.references;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import ru.converter.project.base.ConverterService;

/**
 * Реализация интерфейса {@link ReferenceBase}.
 * 
 * @author Alimurad A. Ramazanov
 * @since 04.01.2017
 * @version 1.0
 *
 */
@Component
public class ConverterReference implements ReferenceBase {

	private static final long serialVersionUID = 4187254945173504435L;

	public static final String PATH = "/converter";

	@Override
	public String getHref() {
		UriComponents uriComponents = UriComponentsBuilder.fromPath(PATH).build();
		return uriComponents.expand().toString();
	}

	@Override
	public File doPost(List<MultipartFile> files, String name) {
		return new ConverterService().start(files, name);
	}

	@Override
	public String getRelation() {
		return "converter";
	}

}
