package Day_09_17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CopyFileWithFileStream {
	public static void main(String[] args) throws IOException {
		creatFile();
		String fileSrc = "C:/text/myfile.text";
		String fileDes = "C:/text/myfile_cp.text";
		copyFile(fileSrc, fileDes);
	}

	public static void creatFile() throws IOException {
		File f = new File("C:/text");
		f.mkdirs();
		File f1 = new File(f, "myfile.text");
		f1.createNewFile();
		Writer out = new FileWriter(f1, true);
		out.write("Hello,how are you");
		out.close();
		File f2 = new File(f, "myfile_cp.text");
		f2.createNewFile();
	}

	public static void copyFile(String fileSrc, String fileDes) throws IOException {
		FileInputStream in = new FileInputStream(fileSrc);
		File file = new File(fileDes);

		FileOutputStream out = new FileOutputStream(file);
		int c;
		byte buffer[] = new byte[1024];
		while ((c = in.read(buffer)) != -1) {
			for (int i = 0; i < c; i++) {
				out.write(buffer[i]);
			}
			in.close();
			out.close();
		}

	}
}
