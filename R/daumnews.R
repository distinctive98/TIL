t <- htmlParse(read_html("http://media.daum.net/ranking/popular/", encoding="UTF-8"))

#제목
title <- xpathSApply(t,"//div[@class='rank_news']//div/strong/a", xmlValue)
title <- gsub("[[:punct:][:cntrl:]]", "", title)

#뉴스사
news <- xpathSApply(t,"//div[@class='cont_thumb']/strong/span", xmlValue)

daumnews <- data.frame(newstitle=title, newspapername=news)
write.csv(daumnews, "daumnews.csv")