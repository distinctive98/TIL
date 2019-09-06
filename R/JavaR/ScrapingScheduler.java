package service;

import java.io.*;

import org.rosuda.REngine.*;
import org.rosuda.REngine.Rserve.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

@Service
public class ScrapingScheduler {
	@Scheduled(fixedDelay=10000)
	public void scheduleRun() throws RserveException, REXPMismatchException, IOException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("data<-source('c:/RStudy/news.R'); data$value");
		RList list = x.asList();
		
		String[] newstitle = list.at("newstitle").asStrings();
		String[] newspapername = list.at("newspapername").asStrings();
		String[] datetime = list.at("datetime").asStrings();
		for(String data : newspapername) {
			System.out.println(data);
		}
		
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/Temp/daumnews_schedule.csv")));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Temp/daumnews_schedule.csv", true));
		for(int i=0; i<datetime.length; i++) {
			String row = newstitle[i] + "," + newspapername[i] + "," + datetime[i];
			bw.append(row);
			bw.append("\r\n");
		}
		
		bw.close();
		rc.close();
	}
}
