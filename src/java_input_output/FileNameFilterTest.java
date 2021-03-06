package java_input_output;

import java.io.File;
import java.io.FilenameFilter;

/**
 * File filter
 *
 * @author 唐龙
 */
public class FileNameFilterTest {
	public static void main(String[] args) {
		String dir = CommonFileName.dirName;
		System.out.println("-------------目录下所有的内容--------------");
		FileNameFilterTest.getAllFiles(dir);

		System.out.println("-------------符合过滤器条件的文件--------------");
		String sf = "java";//过滤后缀名为".java"的文件
		FilenameFilter myFilenameFilter = new MyFilenameFilter(sf);
		FileNameFilterTest.getFilesByFilter(myFilenameFilter, dir);
	}

	/**列出指定目录下所有文件和子目录的路径*/
	public static void getAllFiles(String dirName) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符。
		if (!dirName.endsWith(File.separator)) {
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);
		// 如果dir对应的文件不存在，或者不是一个文件夹，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("文件或目录\"" + dirName + "\"不存在！");
			return;
		}
		// 列出源文件夹下所有文件（包括子目录）
		File[] fileArray = dirFile.listFiles();
		int len = fileArray.length;
		for (int i = 0; i<len; i++) {
			if (fileArray[i].isFile()) {
				System.out.println(fileArray[i].getAbsolutePath());
			} else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getAbsolutePath());
				FileNameFilterTest.getAllFiles(fileArray[i].getAbsolutePath());
			}
		}
	}

	/**获取在指定目录下符合指定后缀文件名的所有文件*/
	public static void getFilesByFilter(FilenameFilter filter,String dirPath) {
		// 如果目录路径不是以文件分隔符结尾则自动添加文件分隔符。
		if (!dirPath.endsWith(File.separator)) {
			dirPath = dirPath + File.separator;
		}
		File dir_File = new File(dirPath);
		// 如果指定的目录不存在或不是一个目录则返回
		if (!dir_File.exists() || (!dir_File.isDirectory())) {
			System.out.println("文件或目录\"" + dir_File + "\"不存在！");
			return;
		}
		// 列出指定目录下的所有符合过滤器条件的文件（包括子目录）
		File[] fileArray = dir_File.listFiles(filter);
		int len = fileArray.length;
		for (int i = 0; i<len; i++) {
			if (fileArray[i].isFile()) {
				System.out.println(fileArray[i].getAbsolutePath() + " 是文件!");
			} else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getAbsolutePath() + " 是目录!");
				FileNameFilterTest.getFilesByFilter(filter, fileArray[i].getAbsolutePath());
			}
		}
	}
}

/**
 * 文件过滤器类
 */
class MyFilenameFilter implements FilenameFilter {
	private String sf = ""; // 定义文件的后缀名

	public MyFilenameFilter(String surfix) {
		this.sf = surfix;
	}

	// 重写FilenameFilter接口中的accept方法，判断指定的文件是否在指定的目录中
	@Override
	public boolean accept(File dir, String name) {
		if (new File(dir, name).isFile()) {
			return name.endsWith(sf);//如果当前的File对象是一个文件，则返回它是否以指定的后缀结束
		} else {
			return true;//如果是文件夹，则直接返回true
		}
	}
}