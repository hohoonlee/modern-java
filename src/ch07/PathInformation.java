package ch07;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInformation {
	public static void main(String[] args) {
		//Path path = Paths.get("/Users/hohoonlee/JavaProjects/modern-java");
		Path path = Paths.get("./");

		System.out.format("toString : %s\n", path.toString());
		System.out.format("getFileName : %s\n", path.getFileName());
		System.out.format("getName(0) : %s\n", path.getName(0));
		System.out.format("getNameCount : %s\n", path.getNameCount());
		// System.out.format("subpath(0,2) : %s\n", path.subpath(0,2));
		System.out.format("getParent : %s\n", path.getParent());
		System.out.format("getRoot : %s\n", path.getRoot());
		System.out.format("AbsolutePath : %s\n", path.toAbsolutePath());
		System.out.format("AbsolutePath : %s\n", path.toAbsolutePath().normalize());
		try {
			System.out.format("AbsolutePath : %s\n", path.toRealPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
