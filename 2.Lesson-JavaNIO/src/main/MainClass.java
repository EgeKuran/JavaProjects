package main;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainClass {

	public static void main(String[] args) 
	{
		Path path1 = Paths.get("C:/Users/MSI/Desktop/longtext.txt");
		
		System.out.println(path1.getParent());
		Path path2 = Paths.get("/MyDisk/Test/../sub");
		
		System.out.println(path2);
		System.out.println(path2.normalize());
		
		System.out.println(path2.subpath(0, 2));
		
//		FileSystems.getFileSystem(uri);
		
//		Files.exists(Paths.get("C:/Users/MSI/Desktop/longtext.txt"),LinkOption.NOFOLLOW_LINKS);
		Files.exists(Paths.get("C:/Users/MSI/Desktop/longtext.txt"));
		
		try {
			List<String> lines =Files.readAllLines(Paths.get("C:/Users/MSI/Desktop/longtext.txt"));
			
			for(String line : lines) 
			{
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
