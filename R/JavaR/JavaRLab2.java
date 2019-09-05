package rjava;

import org.rosuda.REngine.*;
import org.rosuda.REngine.Rserve.*;

public class JavaRLab2 {

	public static void main(String[] args) throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("data<-source('c:/RStudy/lab.R'); data$value");
		RList list = x.asList();
		
		String[] noun = list.at("data_noun").asStrings();
		String[] freq = list.at("Freq").asStrings();
		
		for(int i=0; i<noun.length; i++) {
			System.out.println(noun[i] + " " + freq[i]);
		}
	}

}
