package dataBase;

import java.util.zip.*;
import java.io.*;
import java.util.Map;
import java.util.Map.Entry;
 
public class Archivos {
 
	private static final int BUFFER_SIZE = 1024;
 
        public void Zippear(Map<Integer,InputStream> colArch, String pZipFile) throws Exception {
		// objetos en memoria
		FileOutputStream fos = null;
		ZipOutputStream zipos = null;
                InputStream fis = null;
 
		// buffer
		byte[] buffer = new byte[BUFFER_SIZE];
		try {
			
                        fos = new FileOutputStream(pZipFile);
                        zipos = new ZipOutputStream(fos); 
                        ZipEntry zipEntry = null;
			int len = 0;
                        
                        
                        for(Entry ent: colArch.entrySet()){
                            fis = (InputStream) ent.getValue(); // fichero a comprimir
                            zipEntry = new ZipEntry(Integer.toString((Integer)ent.getKey())+".png");                            
                            zipos.putNextEntry(zipEntry);
                            len = 0;
                            while ((len = fis.read(buffer, 0, BUFFER_SIZE)) != -1)
				zipos.write(buffer, 0, len);
                        }
			zipos.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			// cerramos los files
			zipos.close();
			fos.close();
		} // end try
	} // end Zippear
 
	public void UnZip(String pZipFile, String pFile) throws Exception {
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		ZipInputStream zipis = null;
		FileOutputStream fos = null;
 
		try {
			fis = new FileInputStream(pZipFile);
			zipis = new ZipInputStream(new BufferedInputStream(fis));
			if (zipis.getNextEntry() != null) {
				int len = 0;
				byte[] buffer = new byte[BUFFER_SIZE];
				fos = new FileOutputStream(pFile);
				bos = new BufferedOutputStream(fos, BUFFER_SIZE);
 
				while  ((len = zipis.read(buffer, 0, BUFFER_SIZE)) != -1)
					bos.write(buffer, 0, len);
				bos.flush();
			} else {
				throw new Exception("El zip no contenia fichero alguno");
			} // end if
		} catch (Exception e) {
			throw e;
		} finally {
			bos.close();
			zipis.close();
			fos.close();
			fis.close();
		} // end try
	} 
 
}// end class