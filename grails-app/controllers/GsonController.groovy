import grails.converters.JSON
import solr.SearchService

class GsonController {

    SearchService searchService

    def index() {
        //render searchService.search() as JSON

        render model: [content:searchService.search()] , view: 'index'
    }

    def test(){

        render 'hello'
    }
}
