# 문제 26
L1 <- list(name="scott", sal=3000)

# 문제 27
L2 <- L1
names(L2) <- NULL
L2

# 문제 28
L3 <- list(c(3,5,7), c("A", "B", "C"))
L3[[2]][1] <- "Alpha"

# 문제 29
L4 <- list(alpha=0:4, beta=sqrt(1:5), gamma=log(1:5))
L4$alpha <- L4$alpha+10

# 문제 30
L5 <- list(math=list(95, 90), writing=list(90, 85), reading=list(85, 80))
mean(unlist(L5))

# 제어문
# 문제 1
(grade <- sample(1:6, 1))
if(grade <= 3){
  cat(grade, "은 저학년입니다.")
} else {
  cat(grade, "은 고학년입니다.")
}

# 문제 2
(choice <- sample(1:5, 1))
if(choice==1){
  result <- 300+50
} else if(choice==2){
  result <- 300-50
} else if(choice==3){
  result <- 300*50
} else if(choice==4){
  result <- 300%/%50
} else {
  result <- 300%%50
}
cat("결과값 :", result)

# 문제 3
time <- 32150
hour <- time%/%3600
min <- time%%3600%/%60
sec <- time%%3600%%60
cat(hour, "시간", min, "분", sec, "초")

# 문제 4
(count <- sample(3:10, 1))
(deco <- sample(1:3, 1))
result <- switch(EXPR=deco, "*", "$", "#")
for(i in 1:count){
   cat(result)
}

# 문제 5
(score <- sample(0:100, 1))
num <- as.character(score%/%10)
cat(score, "점은", switch(EXPR=num, "10"="A", "9"="A", "8"="B", "7"="C", "6"="D", "F"), "입니다")

# 문제 6
alpha <- paste(LETTERS, letters, sep="")
alpha