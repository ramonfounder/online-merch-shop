//package me.thejramon.onlinemerchstore
//
//import org.springframework.boot.fromApplication
//import org.springframework.boot.test.context.TestConfiguration
//import org.springframework.boot.testcontainers.service.connection.ServiceConnection
//import org.springframework.boot.with
//import org.springframework.context.annotation.Bean
//import org.testcontainers.containers.PostgreSQLContainer
//import org.testcontainers.elasticsearch.ElasticsearchContainer
//import org.testcontainers.utility.DockerImageName
//
//@TestConfiguration(proxyBeanMethods = false)
//class TestOnlineMerchStoreApplication {
//
//    @Bean
//    @ServiceConnection
//    fun elasticsearchContainer(): ElasticsearchContainer {
//        return ElasticsearchContainer(DockerImageName.parse("docker.elastic.co/elasticsearch/elasticsearch:7.17.10"))
//    }
//
//    @Bean
//    @ServiceConnection
//    fun postgresContainer(): PostgreSQLContainer<*> {
//        return PostgreSQLContainer(DockerImageName.parse("postgres:latest"))
//    }
//
//}
//
//fun main(args: Array<String>) {
//    fromApplication<OnlineMerchStoreApplication>().with(TestOnlineMerchStoreApplication::class).run(*args)
//}
