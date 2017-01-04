package ru.converter.project.base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.net.MediaType;

public class MergeService extends AbstractService {

	@Override
	String tempDirectory() {
		return System.getProperty("java.io.tmpdir") + "//merge";
	}

	@SuppressWarnings("deprecation")
	@Override
	File start(List<MultipartFile> files, String name) {
		if (files == null || files.isEmpty() || !StringUtils.hasLength(name))
			throw new RuntimeException("List of files and name of file should be not null or empty");
		PDFMergerUtility ut = new PDFMergerUtility();
		files.stream().filter(file -> file.getContentType().equalsIgnoreCase(MediaType.PDF.toString()))
				.forEach(file -> {
					try {
						ut.addSource(new ConverterService().start(Arrays.asList(file), name));
					} catch (IOException e) {
						throw new RuntimeException("Error while merge documents: stage convert to pdf");
					}
				});
		String filename = tempDirectory() + "//" + name;
		ut.setDestinationFileName(filename);
		try {
			ut.mergeDocuments();
			return new File(filename);
		} catch (IOException e) {
			throw new RuntimeException("Error while merge documents");
		}
	}

}
