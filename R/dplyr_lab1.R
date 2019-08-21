mpg <- as.data.frame(ggplot2::mpg)
str(mpg)

#1-1
mpg %>% nrow
mpg %>% ncol 
nrow(mpg)
ncol(mpg)

#1-2
head(mpg, 10)
mpg %>% head(10)

#1-3
tail(mpg, 10)
mpg %>% tail(10)

#1-4
View(mpg)

#1-5
summary(mpg)

#1-6
str(mpg)

#2-1
names(mpg)[names(mpg)=="cty"] <- c("city")
mpg <- rename(mpg, city = cty)
mpg <- rename(mpg, highway = hwy)

#2-2
head(mpg)

#3-1
midwest <- as.data.frame(ggplot2::midwest)
str(midwest)

#3-2
names(midwest)[names(midwest)=="poptotal"] <- "total"
names(midwest)[names(midwest)=="popasian"] <- "asian"
midwest <- rename(midwest, total = poptotal)
midwest <- rename(midwest, asian = popasian)
str(midwest)

#3-3
midwest <- midwest %>% mutate(rate_asian = asian/total*100)

#3-4
midwest <- midwest %>% mutate(mean_asian = ifelse(rate_asian > mean(rate_asian), "large", "small"))

#4-1
mpg %>% filter(displ <= 4 | displ >= 5) %>% mutate(displ_sub = ifelse(displ <= 4, "4이하", "5이상")) %>% group_by(displ_sub) %>%  summarise(mean = mean(highway))

#4-2
mpg %>% filter(manufacturer=="audi" | manufacturer=="toyota") %>%  group_by(manufacturer) %>%  summarise(mean(city))

#4-3
mpg %>% filter(manufacturer=="chevrolet" | manufacturer=="ford" | manufacturer=="honda") %>% summarise(mean(highway))
mpg %>% filter(manufacturer %in% c("chevrolet", "ford", "honda")) %>% summarise(mean(highway))

#5-1
mpg_sub <- mpg %>% select(class, city)
str(mpg_sub)

#5-2
mpg_sub %>% filter(class=="suv" | class=="compact") %>% group_by(class) %>% summarise(mean(city))

#6-1
mpg %>% filter(manufacturer=="audi") %>% arrange(desc(highway)) %>% head(5)