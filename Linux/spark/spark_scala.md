문제

HDFS의 /edudata 폴더의 product_click.log 파일을 읽고 Product Id 별 갯수를 세서 다음과 같이 출력하는 Scala 코드를 작성한다.

(p004,50)
(p006,51)
(p011,49)
(p013,4)
(p008,80)
(p015,7)
(p002,66)
(p012,39)
(p001,84)
(p005,43)
(p003,54)
(p007,71)
(p009,80)
(p014,10)
(p010,58)



풀이

```scala
val RDD1 = sc.textFile("/edudata/product_click.log")
val RDD2 = RDD1.map(x => x.split(" "))
val RDD3 = RDD2.map(x => x(1))
val RDD4 = RDD3.map((_,1))
val RDD5 = RDD4.reduceByKey(_+_)
RDD5.collect.foreach(println)
```

