package ru.converter.project.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class ConverterService extends AbstractService {

	@Override
	public File start(List<MultipartFile> files, String name) {
		if (files == null || files.size() != 1 || !StringUtils.hasLength(name))
			throw new IllegalArgumentException("File and filename should be not null or empty");
		try {
			XWPFDocument document = new XWPFDocument(files.get(0).getInputStream());
			PdfOptions options = PdfOptions.create();
			File pdf = new File(service.tempDirectory() + "//" + name + ".pdf");
			OutputStream out = new FileOutputStream(pdf);
			PdfConverter.getInstance().convert(document, out, options);
			return pdf;
		} catch (Throwable e) {
			throw new RuntimeException("Error while convert file to pdf");
		}
	}

	private static final AbstractService service = new ConverterService();

	@Override
	String tempDirectory() {
		return System.getProperty("java.io.tmpdir") + "//converter";
	}
}
