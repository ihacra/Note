package com.hacra.note.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileUtils
 * 
 * @author Hacra
 * @date 2020-06-10
 */
public class FileUtils {

	/**
	 * 读取文件内容
	 * @param file
	 * @return
	 */
	public static String readFile(File file) {
		StringBuilder stringBuilder = new StringBuilder(2048);
		if (file.exists()) {
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				String temp = null;
				while ((temp = bufferedReader.readLine()) != null) {
					stringBuilder.append(temp).append("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
						bufferedReader = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fileReader != null) {
					try {
						fileReader.close();
						fileReader = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 写入文件内容
	 * @param file
	 */
	public static void writer(File file, String content) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(content);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
					bufferedWriter = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
					fileWriter = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
