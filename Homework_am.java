package Day_09_17;

import java.io.File;
import java.util.Scanner;

public class Homework_am {

	public static File getDir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入一个文件夹路径：");

		while (true) {
			String line = sc.nextLine();
			File dir = new File(line);

			if (!dir.exists()) {
				System.out.println("路径不存在，重新输入：");
			} else if (dir.isFile()) {
				System.out.println("不是文件夹路径，重新输入：");
			} else {
				return dir;
			}
		}
	}

	public static void showDir(File dir) {
		if (dir.exists()) {
			File[] files = dir.listFiles();
			if (files != null) {
//				for (int i = 0; i < files.length; i++) {
//					if (files[i].isDirectory()) {
//
//						showDir(files[i]);
//						System.out.println(files[i]);
//
//					} else {
//						System.out.println(files[i]);
//
//					}
//				}
				for (File f : files) {
					if (f.isDirectory()) {
						showDir(f);
						System.out.println(f);
					} else {
						System.out.println(f);
					}
				}
			}
		} else {
			System.out.println("files don't find!");
		}
	}

	public static void main(String[] args) {
		File dir = getDir();
		showDir(dir);
	}
}
