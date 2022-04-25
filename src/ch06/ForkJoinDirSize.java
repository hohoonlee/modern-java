package ch06;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinDirSize extends RecursiveTask<Long> {
	private final Path path;

	public ForkJoinDirSize(Path path) {
		this.path = path;
	}

	@Override
	protected Long compute() {
		long fileSize = 0;

		if(Files.isDirectory(path)) {
			try {
				List<Path> fileList = Files.list(path).collect(Collectors.toList());
				List<ForkJoinDirSize> subTaskList = new ArrayList<>();

				for(Path file : fileList) {
					ForkJoinDirSize subTask = new ForkJoinDirSize(file);
					subTask.fork();
					subTaskList.add(subTask);
				}

				Long subSize = 0l;
				for(ForkJoinDirSize subTask : subTaskList) {
					subSize += subTask.join();
				}
				return subSize;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				fileSize = Files.size(path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return fileSize;
	}

	public static void main(String[] args) {
		Path rootPath = Paths.get(".");

		ForkJoinPool pool = new ForkJoinPool();
		System.out.printf("병렬 처리 크기 : %s\n", pool.getParallelism());
		System.out.printf("합계 : %s\n", pool.invoke(new ForkJoinDirSize(rootPath)));
	}

}
