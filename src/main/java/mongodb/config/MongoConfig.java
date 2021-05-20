package mongodb.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;*/

/**
 * @author admin
 * @date 2020/6/3 16:36
 */
@Configuration
//@EnableMongoRepositories
public class MongoConfig {

    @Value(("${spring.mongo.hosts}"))
    private String hosts;

    @Value(("${spring.mongo.port}"))
    private String port;

    @Value(("${spring.mongo.dbname}"))
    private String dbName;

    /**
     * 获取MongoClient,配置主机、端口
     * @return
     */
    @Bean
    public MongoClient client(){
        com.mongodb.MongoClient client = new com.mongodb.MongoClient(new ServerAddress(hosts,Integer.parseInt(port)));
        return client;
    }

    /**
     * 获取MongoDbFactory,配置数据库
     * @return
     */
    /*@Bean
    public MongoDbFactory mongoDbFactory(){
        String db = new MongoClientURI("mongodb://"+hosts+"/test").getDatabase();
        return new SimpleMongoDbFactory(client(),db);
    }*/

    /**
     * 获取操作MongoDB的模板类
     * @param mongoDbFactory
     * @return
     */
    /*@Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory){
        return new MongoTemplate(mongoDbFactory);
    }*/

}
