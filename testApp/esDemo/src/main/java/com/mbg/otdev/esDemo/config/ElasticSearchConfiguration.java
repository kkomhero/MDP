package com.mbg.otdev.esDemo.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories
//@ComponentScan(basePackages = { "com.baeldung.spring.data.es.service" })
public class ElasticSearchConfiguration {

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;


    @Bean
    public Client client() throws Exception {
        String host = clusterNodes.split(":")[0];
        Integer port = Integer.parseInt(clusterNodes.split(":")[1]);

//        Settings esSettings = Settings.settingsBuilder().put("cluster.name", clusterName).build();
//
//        return TransportClient.builder()
//                .settings(esSettings)
//                .build()
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));

        System.out.println(host);
        System.out.println(port);
        System.out.println(InetAddress.getByName(host));

//        TransportClient client = new PreBuiltTransportClient(
//                Settings.builder().put("client.transport.sniff",true).put("cluster.name",clusterName).build())
//                .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));

        Settings esSetting = Settings.builder()
                .put("cluster.name", clusterName)
                //.put("client.transport.sniff", true)
                .build();

        TransportClient client = new PreBuiltTransportClient(esSetting);
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(host), port);
        client.addTransportAddresses(transportAddress);

        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }


//    TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
//            .addTransportAddress(new TransportAddress(InetAddress.getByName("host1"), 9300))
//            .addTransportAddress(new TransportAddress(InetAddress.getByName("host2"), 9300));


}

