package tw.com.tools;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class ImageTools {
	
	private static String imagePath;

	public static String getImagePath() {
		return imagePath;
	}

	public static void setImagePath(String imagePath) {
		ImageTools.imagePath = imagePath;
	}
	
	public static boolean uploadFile(InputStream inputStr,String fileName) throws IOException {
		String  filePath = getImagePath()+File.separator+fileName;
		File outFile = new File(filePath);
		try(BufferedInputStream bfIn = new BufferedInputStream(inputStr);
			FileOutputStream fOut = new FileOutputStream(outFile)){
			byte[] buffer = new byte[1024];
			int index = -1;
			while( (index = bfIn.read(buffer)) != -1) {
				fOut.write(buffer, 0, index);
			}
		}
		
		return true;
	}

	public static List<String> getImageList() throws IOException {
		Path filePath = Paths.get(getImagePath());
		List<String> fileNameList = 
				Files.list(filePath).map(p->p.getFileName().toString()).collect(Collectors.toList());
		return fileNameList;
	}
	public static void main(String[] args) throws IOException {
		ImageTools.setImagePath("C:\\upload_images");
//		FileInputStream fin = new FileInputStream("C:\\Users\\xvpow\\OneDrive\\Desktop\\upload\\peace.png");
//		ImageTools.uploadFile(fin, "peace.png");
		System.out.println(ImageTools.getImageList());
	}
}
