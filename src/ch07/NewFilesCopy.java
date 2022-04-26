package ch07;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NewFilesCopy {
	public static void copyFile(Path source, Path target, CopyOption[] options) {
		if(Files.isDirectory(source) || Files.notExists(source)) {
			System.out.println("파일이 존재하지 않거나, 디렉토리 입니다.");
			return;
		}

		try {
			if(Files.exists(source)) {
				System.out.println("파일이 존재합니다.");
			}

			Files.copy(source, target, options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Usage : java NewFilesCopy <source file> <target file>");
			return;
		}

		Path source = Paths.get(args[0]);
		Path target = Paths.get(args[1]);

		CopyOption[] options = {StandardCopyOption.REPLACE_EXISTING};

		copyFile(source, target, options);
	}

}
