package ru.converter.project.web.references;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/**
 * Интерфейс для работы с ресурсами WEB-слоя сервиса. Реализации:
 * {@link ConverterReference}, {@link SplitterReference}.
 * 
 * @author Alimurad A. Ramazanov
 * @since 04.01.2017
 * @version 1.0
 *
 */
public interface ReferenceBase extends Serializable {

	/**
	 * Метод для получения href ссылки на ресурс.
	 * <p>
	 * 
	 * @return может быть {@code null}.
	 */
	String getHref();

	/**
	 * Метод для получения rel-имени ссылки на ресурс.
	 * <p>
	 * 
	 * @return не может быть {@code null}.
	 */
	@NotNull
	String getRelation();

	/**
	 * Получение в зависимости от реализации либо объединенного pdf-файла, либо
	 * сконвертированного файла из нескольких pdf-файлов.
	 * <p>
	 * 
	 * @see {@link MultipartFile}, {@linkplain ConverterReference}
	 * @param file
	 *            - PDF-файл, не может быть {@code null}.
	 * @param name
	 *            - имя PDF-файла, не может быть {@code null}.
	 * @return не может быть {@code null}.
	 */
	@NotNull
	File doPost(@NotNull List<MultipartFile> file, @NotNull String name);
}
