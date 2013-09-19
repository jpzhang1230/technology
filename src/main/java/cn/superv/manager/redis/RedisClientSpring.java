package cn.superv.manager.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisClientSpring {
	private static final Logger logger = LoggerFactory.getLogger(RedisClientSpring.class);
	private static ShardedJedisPool pool;
	private static ApplicationContext applicationContext;

	static {
		applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		pool=(ShardedJedisPool)applicationContext.getBean("shardedJedisPool");
	}

	public static void main(String[] args) {
		logger.info("start connect to redis server...");
		// 从连接池获取对象
		ShardedJedis jedis = pool.getResource();
		String age = jedis.get("age");
		logger.info("age={}", age);

		// 释放对象
		pool.returnResource(jedis);
	}

}
