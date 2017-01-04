package ru.converter.project.base;

import java.io.File;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/**
 * Абстрактный сервис конвертации и объединения.
 * 
 * @author Alimurad A. Ramazanov
 * @since 04.01.2017
 * @version 1.0
 *
 */
public abstract class AbstractService {

	/**
	 * Метод, возвращающий путь до директории с временными файлами для
	 * конкретного сервиса.
	 * <p>
	 * 
	 * @see {@link System#getProperty(String)}
	 * 
	 * @return не может быть {@code null}.
	 */
	@NotNull
	abstract String tempDirectory();

	/**
	 * Метод для запуска работы конкретного сервиса.
	 * <p>
	 * 
	 * @see {@link MultipartFile}, {@link File}
	 * @param files
	 *            - список файлов, присланных с клиента, не может быть
	 *            {@code null}.
	 * @param name
	 *            - имя результирующего PDF-файла, не может быть {@code null}
	 *            или {@literal ""}
	 * @return результат в виде PDF-файла, не может быть {@code null}.
	 */
	@NotNull
	abstract File start(@NotNull List<MultipartFile> files, @NotNull String name);
}
