package src.work.文件IO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class fileSearch {


    public static void main(String[] args) {
        String path = "D://";
        String str = ".java";
        File filepath = new File(path);
        List<File> result = new ArrayList<>();
        Search(filepath, str, result);
        for (File e : result) {
            System.out.println(e.getName());
        }
        System.out.println(result.size());

    }

    private static void Search(File filepath, String str, List<File> result) {

        File[] files = filepath.listFiles();
        if (files == null) {
            return;
        }
        for (File E : files) {
            if (E.isFile()) {
                result.add(E);
            } else if (E.isDirectory()) {
                Search(E, str, result);
            }
        }
    }

}
