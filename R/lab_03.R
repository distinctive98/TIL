#문제 10
a <- array(1:24, dim=c(2,3,4))
a
a[2,,]
a[,1,]
a[,,3]
a <- a+100
a[,,4]*100
a[1,2:3,]
a[2,,2] <- a[2,,2]+100
a[,,1] <- a[,,1]-2
a <- a*10
remove(a)

#문제 11
df1 <- data.frame(x=1:5, y=seq(2,10,2))

#문제 12
df2 <- data.frame(col1=1:5, col2=letters[1:5], col3=6:10)

#문제 13
제품명 <- c("사과", "딸기", "수박")
가격 <- c(1800, 1500, 3000)
판매량 <- c(24, 38, 13)
df3 <- data.frame(제품명, 가격, 판매량, stringsAsFactors = F)

#문제 14
mean(df3$가격)
mean(df3$판매량)

#문제 15
name <- c("Potter", "Elsa", "Gates", "Wendy", "Ben")
gender <- factor(c("M", "F", "M", "F", "M"))
math <- c(85, 76, 99, 88, 40)
df4 <- data.frame(name, gender, math, stringsAsFactors = F)
str(df4)
stat <- c(76, 73, 95, 82, 35)
df4$stat <- stat
df4$score <- df4$math+df4$stat
df4$grade <- ifelse(df4$score>=150, "A",
                    ifelse(df4$score>=100, "B", 
                           ifelse(df4$score>=70, "C")))

#문제 16
str(emp)

#문제 17
emp[3:5,]

#문제 18
emp[,"ename"]

#문제 19
emp[,c("ename", "sal")]

#문제 20
emp[emp$job=="SALESMAN", c("ename", "sal", "job")]

#문제 21
subset(emp, select=c("ename", "sal", "job"), subset=(1000 <= sal & sal <= 3000))

#문제 22
subset(emp, select=c("ename", "job", "sal"), subset=(job != "ANALYST"))

#문제 23
subset(emp, select=c("ename", "job"), subset=(job=="SALESMAN" | job=="ANALYST"))

#문제 24
subset(emp, select=c("ename", "comm"), subset=(is.na(emp$comm)))

#문제 25
emp[order(emp$sal),]