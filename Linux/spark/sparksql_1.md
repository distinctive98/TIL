```scala
case class Dessert(menuId: String, name: String, price: Int, kcal: Int)
val dessertRDD = sc.textFile("file///root/sampledata/data/dessert-menu.csv")
val dessertDF = dessertRDD.map{ record =>
    val splitRecord = record.split(",")
    val menuId = splitRecord(0)
    val name = splitRecord(1)
    val price = splitRecord(2).toInt
    val kcal = splitRecord(3).toInt
    Dessert(menuId, name, price, kcal)
  }.toDF
dessertDF.printSchema

dessertDF.registerTempTable("dessert_table")
```



```scala
case class Product(datetime: String, pid: String)
val productRDD = sc.textFile("/edudata/product_click.log")
val productDF = productRDD.map { record => 
	val split = record.split(" ")
	val datetime = split(0)
	val pid = split(1)
	Product(datetime, pid)
	}.toDF
productDF.printSchema
productDF.registerTempTable("product")
val sqlContext = new org.apache.spark.sql.SQLContext(sc)
sqlContext.sql("SELECT pid, count(*) AS cnt FROM product GROUP BY pid ORDER BY count(*) DESC").show

+----+---+                                                                      
| pid|cnt|
+----+---+
|p001| 84|
|p008| 80|
|p009| 80|
|p007| 71|
|p002| 66|
|p010| 58|
|p003| 54|
|p006| 51|
|p004| 50|
|p011| 49|
|p005| 43|
|p012| 39|
|p014| 10|
|p015|  7|
|p013|  4|
+----+---+
```