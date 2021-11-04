package com.leetor4.handler;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiarArquivosXMLDePastaOrigDest {

	public boolean copia( File srcDirOrig, File srvDirDest ){
	    
        try{

            if( srcDirOrig.isDirectory() ){

                if( !srvDirDest.exists() ){

                	srvDirDest.mkdir();
                }

                String[] children = srcDirOrig.list();

                for (int i=0; i<children.length; i++){

                    copia( new File( srcDirOrig, children[i] ), new File( srvDirDest, children[i] ) );
                }
            } 
            else{

                InputStream in = new FileInputStream( srcDirOrig );
                OutputStream out = new FileOutputStream( srvDirDest );

                byte[] buf = new byte[1024];
                int len;

                while( (len = in.read( buf ) ) > 0 ) {

                	
                    out.write( buf, 0, len );
                }

                in.close();
                out.close();
            }
        }
        catch( IOException ioex ){

            ioex.printStackTrace();
            return false;
        }

        return true;
    }
}
