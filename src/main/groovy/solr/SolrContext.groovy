package solr

import grails.core.GrailsApplication
import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.HttpSolrServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.solr.core.SolrOperations
import org.springframework.data.solr.core.SolrTemplate
import org.springframework.data.solr.repository.config.EnableSolrRepositories
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactory

@Configuration
@EnableSolrRepositories(basePackages = ['solr'],multicoreSupport = true)
class SolrContext {

    @Autowired
    GrailsApplication grailsApplication

    @Bean
    public SolrServer solrServer() {

        EmbeddedSolrServerFactory factory = new EmbeddedSolrServerFactory('./embeddedsolr')
        factory.getSolrServer()

    }

    @Bean
    public SolrOperations solrTemplate() {
        return new SolrTemplate(solrServer())
    }

}
