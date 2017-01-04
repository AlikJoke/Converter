package ru.converter.project.test.converter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.net.MediaType;

import ru.converter.project.base.ConverterService;

public class ConverterTest extends Assert {

	private File file;

	@Before
	public void initializeFile() {
		file = new File("src/test/resources/UIR_OT4ET.docx");
	}

	@Test
	public void convertTest() throws Exception {
		Assert.assertNotNull(file);
		Assert.assertTrue(file.exists());

		MultipartFile result = new MockMultipartFile(file.getName(), file.getName(),
				MediaType.MICROSOFT_WORD.toString(), Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		File pdf = new ConverterService().start(Arrays.asList(result), "UIR_OT4ET");
		Assert.assertNotNull(pdf);
		Assert.assertTrue(pdf.length() > 0);
		Assert.assertTrue("pdf".equalsIgnoreCase(FilenameUtils.getExtension(pdf.getName())));
	}
}
