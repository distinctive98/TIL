mpg <- as.data.frame(ggplot2::mpg)
str(mpg)

#7
#7-1
mpg_temp <- mpg
mpg_temp <- mpg_temp %>% mutate(sum = cty+hwy)

#7-2
mpg_temp <- mpg_temp %>% mutate(avg = sum/2)

#7-3
mpg_temp %>%  arrange(desc(avg)) %>% head(3)

#7-4
mpg %>% mutate(sum = cty+hwy, avg = sum/2) %>% arrange(desc(avg)) %>% head(3)


#8
#8-1
mpg %>% group_by(class) %>% summarise(mean(cty))

#8-2
mpg %>% group_by(class) %>% summarise(mean = mean(cty)) %>% arrange(desc(mean))

#8-3
mpg %>% group_by(manufacturer) %>% summarise(mean = mean(hwy)) %>% arrange(desc(mean)) %>% head(3)

#8-4
mpg %>% filter(class=="compact") %>% group_by(manufacturer) %>% summarise(n = n()) %>% arrange(desc(n))


#9
fuel <- data.frame(fl = c("c", "d", "e", "p", "r"), price_fl = c(2.35, 2.38, 2.11, 2.76, 2.22), stringsAsFactors = F)
fuel
#9-1
mpg <- left_join(mpg, fuel, by = "fl")

#9-2
mpg %>% select(model, fl, price_fl) %>% head(5)


#10
midwest <- as.data.frame(ggplot2::midwest)
#10-1
midwest <- midwest %>% mutate(kidsRatio = (poptotal-popadults)/poptotal*100)

#10-2
midwest %>% select(kidsRatio) %>% arrange(desc(kidsRatio)) %>% head(5)

#10-3
midwest <- midwest %>% mutate(kidsGrade = ifelse(kidsRatio >= 40, "large", ifelse(kidsRatio >= 30, "middle", "small")))

#10-4
midwest <- midwest %>% mutate(asianRatio = popasian/poptotal*100)
midwest %>% select(state, county, asianRatio) %>% arrange(asianRatio) %>% head(10)


#11
mpg[c(65, 124, 131, 153, 212), "hwy"] <- NA
#11-1
table(is.na(mpg$drv))
table(is.na(mpg$hwy))

#11-2
mpg %>% filter(!is.na(hwy)) %>% group_by(drv) %>% summarise(mean = mean(hwy)) %>% arrange(desc(mean))


#12
mpg[c(10, 14, 58, 93), "drv"] <- "k"
mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42)
#12-1
mpg$drv <- ifelse(!mpg$drv %in% c("4", "f", "r"), NA, mpg$drv)

#12-2
boxplot(mpg$cty)$stats
mpg$cty <- ifelse(!(9<=mpg$cty & mpg$cty<=26), NA, mpg$cty)