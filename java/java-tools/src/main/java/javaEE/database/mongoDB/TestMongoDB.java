package javaEE.database.mongoDB;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import org.bson.Document;

import java.util.*;

/**
 * Created by dell on 2016/12/12.<br/>
 * 注意： mongodb 3.x对之前版本进行了大量改动
 * 参考文章： http://blog.csdn.net/autfish/article/details/51356537
 */
public class TestMongoDB {

    public static void main(String[] args) {
        System.out.println("[info] starting...");


        // 使用用户名、数据库、密码连接数据库
        //MongoCredential credential = MongoCredential.createCredential("guoxin01", "guoxin", "123456".toCharArray());
        //ServerAddress addr = new ServerAddress("192.168.1.137", 27017);
        //MongoClient passwdClient = new MongoClient("10.15.82.57", 27017);

        //MongoClient mongoClient = new MongoClient("10.15.82.57", 27017);

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("myTest");
        System.err.println("[info] connection ok! use database");
        mongoDatabase.drop();//删除db下所有集合，但是同名的集合默认会存在的
        mongoDatabase.createCollection("myTest");//创建一个集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("classes");
        System.out.println("[info] use collection");

        collection.drop();//删除集合原有数据
        /*
        * 检索所有文档
        * 1. 获取迭代器
        * 2. 获取游标
        * 3. 用游标检索文档
        * */
        int count = (int) collection.count();
        System.out.println("[info] total doc after delete: " + count);

        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            Document doc = mongoCursor.next();
            System.out.println("[info] selected doc: " + doc.get("name"));
        }

        /*增加一个数据*/
        Document newDoc = new Document("id", 1).append("name", "zhangsan1").append("text", "可以用map或append建doc");
        collection.insertOne(newDoc);
        /*增加一个数据*/
        Map<String, Object> newMap = new HashMap<>();
        newMap.put("id", 2);
        newMap.put("name", "name2");
        Document document = new Document(newMap);
        collection.insertOne(document);

        /*增加多个数据*/
        Document doc1 = new Document("name", "tom").append("raid", Arrays.asList(10, 10)).append("gps", new Point(new Position(10, 10)));
        Document doc2 = new Document("name", "jone").append("raid", Arrays.asList(10.1, 10)).append("gps", new Point(new Position(10.1, 10)));
        Document doc3 = new Document("name", "john").append("raid", Arrays.asList(10, 10.1)).append("gps", new Point(new Position(10, 10.1)));
        Document doc4 = new Document("name", "jack").append("raid", Arrays.asList(9.9, 10)).append("gps", new Point(new Position(9.9, 10)));
        Document doc5 = new Document("name", "mary").append("raid", Arrays.asList(10, 9.9)).append("gps", new Point(new Position(10, 9.9)));
        Document doc6 = new Document("name", "abby").append("raid", Arrays.asList(10.2, 10)).append("gps", new Point(new Position(10.2, 10)));
        Document doc7 = new Document("name", "adam").append("raid", Arrays.asList(10.3, 10)).append("gps", new Point(new Position(10.3, 10)));
        Document doc8 = new Document("name", "barry").append("raid", Arrays.asList(10.4, 10)).append("gps", new Point(new Position(10.4, 10)));
        Document doc9 = new Document("name", "anne").append("raid", Arrays.asList(10.5, 10)).append("gps", new Point(new Position(10.5, 10)));
        collection.insertMany(Arrays.asList(doc1, doc2, doc3, doc4, doc5, doc6, doc7, doc8, doc9));

        /*条件查询*/
        findIterable = collection.find(new Document("id", 2));
        Iterator<Document> iteSelect = findIterable.iterator();
        while (iteSelect.hasNext()) {
            System.out.println("[info] 条件查找id为2的：" + iteSelect.next().getString("name"));
        }

        /*查询并修改*/
        collection.findOneAndReplace(new Document("id", 2), new Document("name", "name2"));//repalce是替换一个
        //3.4版本中的过滤词在Filters，更改词在Updates
        collection.findOneAndUpdate(Filters.eq("id", 1), Updates.set("raid", "这是使用updates设置的值"));
        //collection.updateOne(new Document("id",1),set("rank", 100));

        //$geoWithinPolygon 在多边形内搜索
        List<Double> p1 = new ArrayList<>();
        List<Double> p2 = new ArrayList<>();
        List<Double> p3 = new ArrayList<>();
        p1.add(10d);
        p1.add(10d);
        p2.add(10.1);
        p2.add(10.16);
        p3.add(10.2);
        p3.add(10d);
        List<List<Double>> polygon = Arrays.asList(p1, p2, p3);
        findIterable = collection.find(Filters.geoWithinPolygon("raid", polygon));
        Iterator<Document> iteSelGeo = findIterable.iterator();
        while (iteSelGeo.hasNext()) {
            System.out.println("[info] 多边形内查找到：" + iteSelGeo.next().getString("name"));
        }

        /*使用Filters删除多个数据*/
        collection.deleteMany(Filters.or(Filters.eq("name", "tom"), Filters.eq("name", "jack")));

        System.out.println("[info] total doc finally: " + collection.count());
        System.out.println("[info] over!!!");

        mongoClient.close();
    }
}
