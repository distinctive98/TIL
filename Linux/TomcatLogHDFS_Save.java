package hdfsexam;

import java.io.*;
import java.net.*;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileSystem;

public class TomcatLogHDFS_Save {

	private static final String srcDir = "/edudata/tomcat_access_log.txt";
	
	public static void main(String[] args) {
		Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
       
        try {
        	//linux 경로 지정
        	FileSystem hdfs = FileSystem.get(conf);
            Path path = new Path(srcDir);
            FileSystem fs = FileSystem.get(URI.create(srcDir), conf);
            FSDataOutputStream out;
            
            if(fs.exists(path)) {
            	out = hdfs.append(path);
            	//log파일 접근하기
            	File dir = new File("C:\\YG\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\logs");
            	File[] files = dir.listFiles();
            	
            	BufferedReader br;
            	FileReader fr;
            	for(File file : files) {
            		//txt파일만 write
            		if(file.getName().endsWith(".txt")) {
            			fr = new FileReader(file);
            			br =new BufferedReader(fr);
            			while(br.ready()){
            				out.writeUTF(br.readLine());
            	        }
            		}
            	}
            	
            	FileStatus fStatus = fs.getFileStatus(path);
    			if(fStatus.isFile()) {
    				System.out.println("");
    				System.out.println("===========================================");
    				System.out.println("File Block Size : " + fStatus.getBlockSize());
    				System.out.println("Group of File   : " + fStatus.getGroup());
    				System.out.println("Owner of File   : " + fStatus.getOwner());
    				System.out.println("File Length     : " + fStatus.getLen());
    			}
            } else {
            	out = hdfs.create(path);
            	System.out.println("다시 실행하세요");
            }
        	
     	
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
