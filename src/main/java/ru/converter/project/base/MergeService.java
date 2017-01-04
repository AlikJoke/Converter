package ru.converter.project.base;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MergeService extends AbstractService {

	@Override
	String tempDirectory() {
		return System.getProperty("java.io.tmpdir") + "//merge";
	}

	@Override
	File start(List<MultipartFile> files, String name) {
		// TODO start() for MergeService
		return null;
	}

}
