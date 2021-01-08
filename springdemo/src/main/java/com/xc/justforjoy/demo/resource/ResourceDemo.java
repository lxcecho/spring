package com.xc.justforjoy.demo.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.*;

/**
 * @author lxcecho
 * @since 2021/1/8
 */
public class ResourceDemo {

	public static void main(String[] args) {
		try {
			FileSystemResource fileSystemResource =
					new FileSystemResource("G:\\spring-framework\\springdemo\\src\\main\\java\\com\\xc\\justforjoy\\demo\\resource\\test.txt");
			File file = fileSystemResource.getFile();
			// 获取文件内容长度
			System.out.println(file.length());
			// 将 Hello lxcecho 写入到文件中
			OutputStream outputStream = fileSystemResource.getOutputStream();
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
			bufferedWriter.write("hello lxcecho");
			bufferedWriter.flush();
			outputStream.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
