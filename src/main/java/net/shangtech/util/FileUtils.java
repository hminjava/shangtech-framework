package net.shangtech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * 文件工具类
 * @author songxh
 * @createtime 2014-8-3上午08:55:06
 */
public class FileUtils {
	private static String SAVE_DIR = "";
	//TODO 尽量实现可以自动寻找配置地址实在找不到再用upload也可以方法参数传递
	static{
		try {
			String classpath = FileUtils.class.getClassLoader().getResource("/").toURI().getPath();
			SAVE_DIR = classpath.substring(0, classpath.indexOf("WEB-INF")) + "upload/";
		} catch (URISyntaxException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	public static String save(File file, String originalName) throws IOException{
		String date = DateUtils.format(new java.util.Date(), "yyyyMMdd");
		String dateTime = DateUtils.format(new java.util.Date(), "yyyyMMddHHmmss");
		String extend = originalName.substring(originalName.lastIndexOf("."));
		String datePath = date + "/";
		File dir = new File(SAVE_DIR + datePath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		Random random = new Random();
		String randomName = dateTime + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
		File target = new File(SAVE_DIR + datePath + randomName + extend);
		while(target.exists()){
			randomName = dateTime + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
			target = new File(SAVE_DIR + datePath + randomName + extend);
		}
		InputStream is = new FileInputStream(file);
		OutputStream fout = new FileOutputStream(target);
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = is.read(b)) != -1) {
            fout.write(b, 0, len);
        }
        fout.close();
        is.close();
		String filePath =  "upload/" + datePath + randomName + extend;
		return filePath;
	}
	public static String saveStreamToFile(InputStream is, String originalName) throws IOException{
		String extend = originalName.substring(originalName.lastIndexOf("."));
		String date = DateUtils.format(new java.util.Date(), "yyyyMMdd");
		String dateTime = DateUtils.format(new java.util.Date(), "yyyyMMddHHmmss");
		String datePath = date + "/";
		File dir = new File(SAVE_DIR + datePath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		Random random = new Random();
		String randomName = dateTime + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
		File target = new File(SAVE_DIR + datePath + randomName + extend);
		while(target.exists()){
			randomName = dateTime + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
			target = new File(SAVE_DIR + datePath + randomName + extend);
		}
		OutputStream fout = new FileOutputStream(target);
	    byte[] b = new byte[1024];
	    int len = 0;
	    while ((len = is.read(b)) != -1) {
	        fout.write(b, 0, len);
	    }
	    fout.close();
	    is.close();
        String filePath =  "upload/" + datePath + randomName + extend;
        return filePath;
	}
}
