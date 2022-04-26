package ch07;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChecker {
	public static void main(String[] args) {
		if(args.length < 1) {
			printUsage();
			return;
		}

		Path path = Paths.get(args[0]);
		if(Files.exists(path) && !Files.notExists(path)) {
			System.out.println("Path가 존재합니다.");
		}else {
			System.out.println("Path가 존재하지 않거나 문제가 있습니다.");
		}

		System.out.println("is directory ? " + Files.isDirectory(path));
		System.out.println("is readable ? " + Files.isReadable(path));
		System.out.println("is writable ? " + Files.isWritable(path));
		System.out.println("is executable ? " + Files.isExecutable(path));
		System.out.println("is regular files ? " + Files.isRegularFile(path));

	}

	public static void printUsage() {
		System.out.println("java FileChecker <path information>");
	}

}
