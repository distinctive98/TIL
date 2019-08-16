t <- htmlParse(read_html("http://www.saramin.co.kr/zf_user/search?search_area=main&search_done=y&search_optional_item=n&searchType=default_mysearch&searchword=%EC%9E%90%EB%B0%94", encoding="UTF-8"))

#기술이름
tech_name <- xpathSApply(t,"//div[@class='info_sfilter smart_filter']//label[@class='lbl_sfilter']/span[@class='txt']", xmlValue)
tech_name <- gsub("[[:punct:]]", "", tech_name)

#채용건수
info_count <- xpathSApply(t,"//div[@class='info_sfilter smart_filter']//span[@class='count']", xmlValue)
info_count <- gsub("[[:punct:]]", "", info_count)

saramin <- data.frame(tech_name, info_count)
write.csv(saramin, "saramin.csv", row.names = F)