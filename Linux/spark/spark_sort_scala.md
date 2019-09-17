문제

HDFS의 /edudata 폴더의 product_click.log 파일을 읽고 Product Id 별 갯수를 세서 다음과 같이 클릭수가 많은 순으로 출력하는 Scala 코드를 작성한다.

(001,84)
(p009,80)
(p008,80)
(p007,71)
(p002,66)
(p010,58)
(p003,54)
(p006,51)
(p004,50)
(p011,49)
(p005,43)
(p012,39)
(p014,10)
(p015,7)
(p013,4)



풀이

```scala
val RDD1 = sc.textFile("/edudata/product_click.log")
val RDD2 = RDD1.map(x => x.split(" "))
val RDD3 = RDD2.map(x => x(1))
val RDD4 = RDD3.map((_,1))
val RDD5 = RDD4.reduceByKey(_+_)
val RDD6 = RDD5.map { elem => (elem._2, elem._1) }
val RDD7 = RDD6.sortByKey(false)
val RDD8 = RDD7.map { elem => (elem._2, elem._1) }
RDD8.collect.foreach(println)
```

