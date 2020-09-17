package Day_09_17;

import java.io.File;

public class Homework_am {
	public static void showDir(File dir) {
		if (dir.exists()) {
			File[] files = dir.listFiles();
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {

						showDir(files[i]);
						System.out.println(files[i]);

					} else {
						System.out.println(files[i]);

					}
				}
			}
		} else {
			System.out.println("files don't find!");
		}

	}

	public static void main(String[] args) {
		showDir(new File("C:\\cgh"));
	}
}
