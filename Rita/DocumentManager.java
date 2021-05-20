package com.exam.OOPGroup14;

import java.io.File;
import java.io.IOException;

public interface DocumentManager {
	void writeToFile(String text, File file) throws IOException;

   
    String readFromFile(File file) throws IOException;
}
