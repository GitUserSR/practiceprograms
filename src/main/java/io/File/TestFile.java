package io.File;

import java.io.File;
import java.io.IOException;

/**
 * Created by srapolu on 6/5/17.
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        String s = null;
        Integer.valueOf(s);
        File file = new File(".");
        String fileName = file.getCanonicalPath();
        System.out.println(fileName);
    }
}
