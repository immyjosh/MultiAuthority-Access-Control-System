package javabeat.net.io;

import static com.CipherExample.decrypt;
import static com.CipherExample.encrypt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/**
 * Split File Example
 *
 * @author Krishna
 *
 */
public class SplitFileExample {
    
    public String spli(String filename){
	 String FILE_NAME = "C:/Users/THALA KAMESH/Google Drive/upload/Upload-Edit/"+filename;


        
	 int PART_SIZE =5000;
	
            
           
		try {
                 
			
            
		File inputFile = new File(FILE_NAME);
		FileInputStream inputStream;
		String newFileName;
		FileOutputStream filePart;
		int fileSize = (int) inputFile.length();
		int nChunks = 0, read = 0, readLength = PART_SIZE;
		byte[] byteChunkPart; 
                    
                    
                 
                    
			inputStream = new FileInputStream(inputFile);
			while (fileSize > 0) {
				if (fileSize <= 500) {
					readLength = fileSize;
				}
				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, readLength);
				fileSize -= read;
				assert (read == byteChunkPart.length);
				nChunks++;
				newFileName = FILE_NAME 
                                        //+ ".txt"
						+ Integer.toString(nChunks - 1);
				filePart = new FileOutputStream(new File(newFileName));
				filePart.write(byteChunkPart);
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;
			}
			inputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	//}
        return null;
}
}

