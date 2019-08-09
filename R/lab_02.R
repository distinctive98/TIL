#문제 2
v1 <- seq(10, 38, 2)
m1 <- matrix(v1, nrow=3, byrow=T)
m2 <- m1+100
m_max_v <- max(m1)
m_min_v <- min(m1)
row_max <- c(max(m1[1,]):max(m1[3,]))
col_max <- max(m1[,1:5])
m1; m2; m_max_v; m_min_v; row_max; col_max

#문제 6
n1 <- c(1,2,3)
n2 <- c(4,5,6)
n3 <- c(7,8,9)
m1 <- cbind(n1, n2, n3)
colnames(m1) <- NULL

#문제 7
m2 <- matrix(1:9, nrow=3, byrow=T)

#문제 8
colnames(m2) <- c("col1", "col2", "col3")
rownames(m2) <- c("row1", "row2", "row3")

#문제 9
alpha <- matrix(letters[1:6], nrow=2)
alpha2 <- rbind(alpha, letters[24:26]); alpha2
alpha3 <- cbind(alpha, c('s', 'p')); alpha3