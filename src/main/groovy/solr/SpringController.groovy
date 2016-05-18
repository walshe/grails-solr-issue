package solr

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spring")
class SpringController {

    @Autowired
    SearchService searchService

    @RequestMapping(value =  "", method = [RequestMethod.GET])
    def search() {
        return searchService.search()

    }



}
