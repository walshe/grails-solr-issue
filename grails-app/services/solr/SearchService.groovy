package solr

import org.springframework.data.domain.PageRequest
import org.springframework.data.solr.core.SolrTemplate
import org.springframework.data.solr.core.query.Criteria
import org.springframework.data.solr.core.query.HighlightOptions
import org.springframework.data.solr.core.query.HighlightQuery
import org.springframework.data.solr.core.query.SimpleHighlightQuery
import org.springframework.data.solr.core.query.result.HighlightPage

import javax.annotation.Resource

class SearchService {

    @Resource
    SolrTemplate solrTemplate

    def search(){

        HighlightQuery highlightQuery = new SimpleHighlightQuery(new Criteria('title_s').contains('interesting'), new PageRequest(0,20))

        highlightQuery.setHighlightOptions(new HighlightOptions().addField('title_s').setSimplePrefix("<strong>").setSimplePostfix("</strong>"))

        return solrTemplate.queryForHighlightPage(highlightQuery, User)

        //return solrTemplate.getById(["1","2","3"],User)
    }
}
