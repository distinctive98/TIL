library(RSelenium)
remDr <- remoteDriver(remoteServerAddr = "localhost", port=4445, browserName="chrome")
remDr$open()

url<-'https://www.agoda.com/ko-kr/shilla-stay-seocho/hotel/seoul-kr.html?cid=-204'
remDr$navigate(url)

#나중에 하기 클릭
more<-remDr$findElements(using='css','#SearchBoxContainer > div > div > div.Popup__container.Popup__container--garage-door > div > div > div.AlertMessage.CalendarAlertMessage > a')
sapply(more,function(x){x$clickElement()})

#스크롤 내리기
remDr$executeScript("scrollBy(0, 12000)")

#메세지 닫기 클릭
more<-remDr$findElements(using='css','#dismiss-btn > p')
sapply(more,function(x){x$clickElement()})

reple <- NULL

#리뷰 읽기
for(i in 1:15){
  if(i<=3){
    linkCss <- paste0("#reviewSection > div:nth-child(6) > div > span.Review-paginator-numbers > span:nth-child(",i,")")
  } else {
    linkCss <- paste0("#reviewSection > div:nth-child(6) > div > span.Review-paginator-numbers > span:nth-child(4)")  
  }
  
  linkPage <- remDr$findElements(using='css',linkCss)
  sapply(linkPage,function(x){x$clickElement()})
  Sys.sleep(1)
  
  doms <- remDr$findElements(using = "css selector", ".Review-comment-bodyText")
  reple_v <- sapply(doms, function (x) {x$getElementText()})
  reple <- c(reple, unlist(reple_v))
}

write(reple, "hotel.txt")
