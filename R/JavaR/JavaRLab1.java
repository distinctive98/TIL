package rjava;

import org.rosuda.REngine.*;
import org.rosuda.REngine.Rserve.*;

public class JavaRLab1 {
	
	public static void getResult() throws RserveException, REXPMismatchException {
	    RConnection rc = new RConnection();
		
		rc.eval("library(KoNLP)");
		rc.eval("useSejongDic()");
		rc.eval("readLines('hotel2.txt')");
		rc.eval("data_noun <- sapply(data, extractNoun, USE.NAMES = F)");
		rc.eval("data_noun <- unlist(data_noun)");
		rc.eval("data_noun <- Filter(function(x){nchar(x) >= 2 && nchar(x) <= 6}, data_noun)");
		rc.eval("word_table <- table(data_noun)");
		rc.eval("word_max <- names(head(sort(word_table, decreasing = T), 11))");
		rc.eval("word_max <- word_max[2:11]");
		
		String[] result = rc.eval("word_max").asStrings();
		System.out.print("R이 보내온 최빈 명사들 : ");
		for(int i=0; i<result.length-1; i++) {
			System.out.print(result[i] + ", ");
		}
		System.out.println(result[result.length-1]);
		
		rc.close();
	}
	

	public static void main(String[] args) throws RserveException, REXPMismatchException {
		// TODO Auto-generated method stub
		getResult();
	}

}


/*
rc.eval(""
		+ "library(KoNLP);"
		+ "useSejongDic();"
		+ "data <- readLines(\"hotel2.txt\");"
		+ "data_noun <- sapply(data, extractNoun, USE.NAMES = F);"
		+ "data_noun <- unlist(data_noun);"
		+ "data_noun <- Filter(function(x){nchar(x) >= 2 && nchar(x) <= 6}, data_noun);"
		+ "data_noun <- gsub(\"[A-Za-z0-9]\", \"\", data_noun);"
		+ "data_noun <- gsub(\"[ㄱ-ㅎ]\", \"\", data_noun);"
		+ "data_noun <- gsub(\"[ㅜ|ㅠ]\", \"\", data_noun);"
		+ "data_noun <- gsub(\"[[:punct:]]\", \"\", data_noun);"
		+ "word_table <- table(data_noun);"
		+ "word_max <- head(sort(word_table, decreasing = T), 11);"
		+ "word_max <- word_max[2:11];");
*/
