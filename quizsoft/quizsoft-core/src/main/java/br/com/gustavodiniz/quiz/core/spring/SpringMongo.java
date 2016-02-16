package br.com.gustavodiniz.quiz.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;

@Configuration
public class SpringMongo {

//	public MongoDbFactory mongoDbFactory() throws Exception {
//		return new SimpleMongoDbFactory(new MongoClient("127.0.0.1"), "DB_QUIZ");
//	}
//
//	public MongoTemplate mongoTemplate() throws Exception {
//		MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
//		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
//						
//		return mongoTemplate;
//	}
	
	public MongoOperations getMongoOperations(){
		ApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
		return mongoOperation;
	}
	
	
	
}
