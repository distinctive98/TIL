library(RSelenium)

remDr <- remoteDriver(remoteServerAddr = "localhost", port=4445, browserName="chrome")
remDr$open()

site <- paste("http://www.yes24.com/24/goods/40936880")
remDr$navigate(site)

#스크롤 최하단으로 내리기
#webElem <- remDr$findElement("css", "body")
#remDr$executeScript("scrollTo(0, document.body.scrollHeight-200)", args = list(webElem))

reviewVector = NULL
page <- 3
endFlag <- F
repeat{
  
  for(i in 3:7){
    #펼쳐보기 클릭하기
    linkCss <- paste0("#infoset_reviewContentList > div:nth-child(",i,") > div.btn_halfMore > a > em.txt.txt_open")
    linkBtn <- remDr$findElements(using='css',linkCss)
    if(length(linkBtn) == 0) {
      endFlag <- T
      break
    }
    sapply(linkBtn,function(x){x$clickElement()})
    Sys.sleep(0.5)
    
    #리뷰 저장하기
    reviewCss <- paste0("#infoset_reviewContentList > div:nth-child(",i,") > div.reviewInfoBot.origin > div.review_cont")
    reviewPage <- remDr$findElements(using='css',reviewCss)
    reviewContent <- sapply(reviewPage,function(x){x$getElementText()})
    reviewVector <- c(reviewVector, unlist(reviewContent))
  }
  
  #끝나면 종료
  if(endFlag == T){
    break
  }
  
  #다음 페이지 넘어가기
  page <- page+1
  pageCss <- paste0("#infoset_reviewContentList > div.review_sort.sortBot > div.review_sortLft > div > a:nth-child(",page,")")
  pageBtn <- remDr$findElements(using='css',pageCss)
  sapply(pageBtn,function(x){x$clickElement()})
  Sys.sleep(0.5)
  if(page == 13){
    page <- 3
  }
  print(page)
}

write(reviewVector, "yes24.txt")