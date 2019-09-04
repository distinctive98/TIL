iris <- iris
names(iris) <- c("SLENGTH", "SWIDTH", "PLENGTH", "PWIDTH", "SPECIES")

library(DBI)
library(RJDBC)

drv <- JDBC("oracle.jdbc.driver.OracleDriver","C:/YG/ojdbc6.jar")
conn <- dbConnect(drv,"jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest")

# DB 저장
dbWriteTable(conn, "IRIS", iris)
result <- dbReadTable(conn, "IRIS")

# 시각화
library(ggplot2)

# 문제 1
ggplot(result, aes(SLENGTH, SWIDTH, fill=SPECIES))+geom_point(shape=22)
ggsave("db1.jpg")

# 문제 2
ggplot(result, aes(PLENGTH, PWIDTH, fill=SPECIES))+geom_point(shape=22)
ggsave("db2.jpg")