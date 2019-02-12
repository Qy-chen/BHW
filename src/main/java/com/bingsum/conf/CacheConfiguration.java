package com.bingsum.conf;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
//标注启动了缓存
@EnableCaching
public class CacheConfiguration {

 /*
  * ehcache 主要的管理器
  */
 @Bean(name = "appEhCacheCacheManager")
 public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
     return new EhCacheCacheManager (bean.getObject ());
 }


 @Bean
 public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
     EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
     cacheManagerFactoryBean.setConfigLocation (new ClassPathResource ("ehcache.xml"));
     cacheManagerFactoryBean.setShared (true);
     return cacheManagerFactoryBean;
 }
}