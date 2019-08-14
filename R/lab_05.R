# 문제 1
exam1 <- function(x, y){
  if(x > y){
    result <- x-y
  } else {
    result <- y-x
  }
  return(result)
}
print(exam1(40, 20))
print(exam1(20, 10))
print(exam1(20, 20))

# 문제 2
exam2 <- function(x, y, oper){
  if(oper=="+"){
    return(x+y)
  } else if(oper=="-"){
    return(x-y)
  } else if(oper=="*"){
    return(x*y)
  } else if(oper=="%/%" | oper=="%%"){
    if(x==0){
      return("오류1")
    } else if(y==0){
      return("오류2")
    } else{
      if(oper=="%/%"){
        return(x%/%y)
      } else {
        return(x%%y)
      }
    }
  } else {
    return("규격의 연산자만 전달하세요")
  }
}
print(exam2(1, 3, "+"))
print(exam2(1, 3, "-"))
print(exam2(1, 3, "*"))
print(exam2(1, 3, "%/%"))
print(exam2(1, 3, "%%"))
print(exam2(0, 3, "%%"))
print(exam2(1, 0, "%%"))
print(exam2(1, 3, "$"))

# 문제 3
exam3 <- function(num, char="#"){
  result <- ""
  if(num > 0){
    for(i in 1:num){
      result <- paste0(result,char)
    }
  }
  return(result)
}
print(exam3(8))
print(exam3(8, "$"))
print(exam3(-2))

#문제 4
exam4 <- function(score){
  grade <- ""
  if(!is.na(score)){
    if(score >= 85){
      grade <- "상"
    } else if(score >= 70){
      grade <- "중"
    } else {
      grade <- "하"
    }
    result <- paste0(score, "는 ", grade, "등급입니다.")
    print(result)
  } else {
   print("처리불가") 
  }
}
exam4(90)
exam4(75)
exam4(50)
exam4(NA)

# 문제 5
countEvenOdd <- function(c){
  if(is.numeric(c)){
    even <- 0; odd <- 0;
    for(i in c){
      if(i%%2 == 0){
        even <- even+1
      } else {
        odd <- odd+1
      }
    }
    return(list(even=even, odd=odd))
  } else {
    return()
  }
}
countEvenOdd(c(1,2,3,4,5))
countEvenOdd(list(c(1,2,3,4,5)))

# 문제 6
vmSum <- function(c){
  if(is.vector(c) && !is.list(c)){
    if(is.numeric(c)){
      return(sum(c))
    } else {
      warning("숫자 벡터를 전달하세요")
      return(0)
    }
  } else {
    stop("벡터만 전달하세요")
  }
}
vmSum(c(1,2,3,4,5))
vmSum(c("1","2","3"))
vmSum(list(c(1,2,3,4,5)))

# 문제 7
createVector <- function(...){
  data <- list(...)
  if(length(data)==0){
    return()
  }
  
  v1 <- c() #for numeric
  v2 <- c() #for character
  v3 <- c() #for logical
  
  for(x in data){
    if(is.numeric(x)){
      v1 <- append(v1, x)
    } else if(is.character(x)){
      v2 <- append(v2, x)
    } else if(is.logical(x)) {
      v3 <- append(v3, x)
    }
  }
  
  return(list(v1, v2, v3))
}

createVector()
createVector(1)
createVector(1, "a")
createVector(1, "a", T, T, 2, "b", F, "c", "d")

# 문제 8
test1 <- scan("iotest1.txt")
cat("오름차순 :", sort(test1), "\n")
cat("내림차순 :", sort(test1, decreasing = T), "\n")
cat("합 :", sum(test1), "\n")
cat("평균 :", mean(test1), "\n")

# 문제 9
test2 <- scan("iotest2.txt", what="",encoding="UTF-8")
max = sort(summary(factor(test2)), decreasing = T)[1]
cat("가장 많이 등장한 단어는", names(max), "입니다.")
#sort(levels(factor(test2)), decreasing = T)[1]