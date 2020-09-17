package Day_09_17;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class Homework_pm {

	public static void main(String[] args) throws IOException {

//		File file = getFile();
//		readDemo(file);
//		writeDemo(file);

		while (true) {
			System.out.println("1.读      2.写");
			System.out.print("输入选择：");
			Scanner num = new Scanner(System.in);
			int i = num.nextInt();

			switch (i) {
			case 1:
				File file = getFile();
				readDemo(file);
				break;

			case 2:
				File file1 = getFile();
				writeDemo(file1);
				break;

			default:
				break;
			}
		}
	}

	public static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入一个文件路径：");

		while (true) {
			String line = sc.nextLine();
			File dir = new File(line);

			if (!dir.exists()) {
				System.out.println("路径不存在，重新输入：");
			} else if (dir.isDirectory()) {
				System.out.println("不是文件路径，重新输入：");
			} else {
				return dir;
			}
		}

	}

	public static void writeDemo(File file) throws IOException {
		File f = file;
		Writer out = new FileWriter(f, true);
		Scanner sc = new Scanner(System.in);
		System.out.println("输入要添加的内容：");
		String str = sc.nextLine();
		out.write(str);
		out.close();
	}

	public static void readDemo(File file) throws IOException {
		File f = file;
		Reader input = new FileReader(f);
		char[] c = new char[1024];
		int len = input.read(c);
		input.close();
		System.out.println(new String(c, 0, len));

	}
}
