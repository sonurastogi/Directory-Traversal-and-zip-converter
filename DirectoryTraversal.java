import com.FileToZipConverter;
import java.io.File;

public class DirectoryTraversal extends FileToZipConverter  {
    public static void main(String[] args) {

String path="Directory1";
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            traverse(directory);
        } else {
            System.out.println("Directory not found.");
        }
    }

    public static void traverse(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    traverse(file); // Recursive call for subdirectories
                } else if(file.getAbsolutePath().endsWith(".log")){
		DirectoryTraversal t= new DirectoryTraversal();
		System.out.println("File: " + file.getName());
		//t.zip(file.getAbsolutePath());
		t.zip(file);
		file.delete();
                }
            }
        }
    }
}
