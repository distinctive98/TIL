#문제 1
v1 <- 1:10
v2 <- v1*2
max_v <- max(v2)
min_v <- min(v2)
avg_v <- mean(v2)
sum_v <- sum(v2)
v3 <- v2[-5]
v1; v2; v3; max_v; min_v; avg_v; sum_v;

#문제 3
seq(1, 10, 2)
rep(1, 5)
rep(1:3, 3)

#문제 4
v3 = seq(1, 10, 3)
names(v3) <- LETTERS[1:4]

#문제 5
count <- sample(1:100, 7)
week.korname <- c("일요일","월요일","화요일","수요일","목요일","금요일","토요일")
names(count) <- week.korname
count
  
week.korname[which.max(count)]
week.korname[which.min(count)]
week.korname[which(count > 50)]
