url <- "https://movie.daum.net/moviedb/grade?movieId=121137&type=netizen"
text <- read_html(url,  encoding="UTF-8")

#영화평점
nodes <- html_nodes(text, ".emph_grade")
point <- html_text(nodes)

#영화리뷰
nodes <- html_nodes(text, ".desc_review")
review <- html_text(nodes, trim=TRUE)
review <- gsub("\r", "", review)

page <- cbind(point, review)
write.csv(page, "daummovie1.csv")