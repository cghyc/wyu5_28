package Day_09_17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CopyFileWithBufferedStream {
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

	public static void copyFile(String src, String dest) throws IOException {
		// 3、创BufferedInputStream 包装对应的节点流，用于提高效率
		BufferedInputStream bis = null;
		// 4、创建BufferedOutputStream 包装对应的节点流，用于提高效率
		BufferedOutputStream bos = null;
		try {
			// 1、创建FileInputStream
			FileInputStream fis = new FileInputStream(src);
			// 2、创建FileoutputStream
			FileOutputStream fos = new FileOutputStream(dest);

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			// 5、读取对应的文件内容
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = bis.read(b)) != -1) {
				// 6将读取内容写到目标地点
				bos.write(b, 0, len);
			}
			// bos.flush();// 强制情况缓冲区【防止数据的丢失，一般情况不要用加】
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 7、关闭流
		if (bos != null) {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (bis != null) {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
