log <- read.table("product_click.log")

#문제 1
data1 <- table(log[2])
#ymax <- max(unname(data1))
png(filename = "clicklog1.png", height=600, width=900, bg="white")
barplot(data1, main="세로바 그래프 실습", xlab="상품ID", ylab="클릭 수", col=terrain.colors(length(data1)))
dev.off()

#문제 2
data2 <- table(str_sub(log$V1, start=9, end=10))
png(filename = "clicklog2.png", height=600, width=600, bg="white")
pie(data2, main="파이 그래프 실습", labels=paste(names(data2), "-", as.integer(names(data2))+1), col=rainbow(length(data2)), clockwise = T)
dev.off()