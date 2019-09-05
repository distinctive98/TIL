package service;

import org.rosuda.REngine.Rserve.*;
import org.springframework.stereotype.*;

@Service
public class OnePersonService {
	public String returnLeaflet(String path, String gu)  {
		RConnection r = null;
		String retStr = "";
		try {
			r = new RConnection();
			r.eval("library(Kormaps)");
			r.eval("library(leaflet)");
			r.eval("library(dplyr)");
			r.eval("library(htmlwidgets)");
			
			r.eval("gu <- '" + gu + "'");
			r.eval("DONG<-read.csv('c:/RStudy/one.csv')");
			r.eval("data(korpopmap3)");
			r.eval("Encoding(names(korpopmap3))<-'UTF-8'");
			r.eval("Encoding(korpopmap3@data$name_eng)<-'UTF-8'");
			r.eval("Encoding(korpopmap3@data$name)<-'UTF-8'");
			r.eval("Encoding(korpopmap3@data$행정구역별_읍면동)<-'UTF-8'");
			
			r.eval("korpopmap3@data$name<-gsub('·','',korpopmap3@data$name)");
			r.eval("colnames(DONG)<-c('구별','name','일인가구')");
			r.eval("dong<- DONG %>%filter(구별==gu)");
			r.eval("korpopmap3@data <- korpopmap3@data %>% filter(name %in% dong$name)");
			r.eval("id <- 3472-(korpopmap3@data$FID)");
			r.eval("korpopmap3@polygons <- korpopmap3@polygons[id]");
			
			r.eval("korpopmap3@data<-merge(korpopmap3@data,dong,by.x='name',sort=FALSE)");
			r.eval("mymap <- korpopmap3@data");
			r.eval("mypalette <- colorNumeric(palette ='RdYlBu' , domain = mymap$'일인가구')");
			r.eval("mypopup <- paste0(mymap$name,'<br> 1인가구: ',mymap$'일인가구')");
			
			r.eval("map7 <- NULL");
			r.eval("map7<-leaflet(korpopmap3) %>% addTiles() %>% setView(lat=37.52711, lng=126.987517, zoom=12) %>% addPolygons(stroke =FALSE,smoothFactor = 0.2,fillOpacity = .9,popup = mypopup,color = ~mypalette(mymap$일인가구)) %>% addLegend( values = ~mymap$일인가구,pal =mypalette ,title = '인구수',opacity = 1)");
			r.eval("map7");
			
		    String fileName = path+"/index.html";
		    System.out.println("ㅋㅋㅋ");
	       	r.eval("saveWidget(map7,'"+fileName+"',  selfcontained = F)");	
	       	//r.eval("saveWidget(map7,'"+fileName+"')");
			String s = r.eval("'index.html'").asString();
			return s;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retStr;
	}
}
