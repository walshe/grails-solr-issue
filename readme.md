

##Re: Problem with new json views feature.


##Description:
When the app starts, it puts some 'User' documents into an embedded Solr repository. See Bootstrap.groovy User.groovy and SolrContext.groovy.
I am using SolrTemplate rather than Solr Repositories for various reasons (I realise those can be used to automatically expose restful services, but I need solrTemplate for various reasons)


SearchService.groovy has a search() method that does a sample solr 'highlight' search on the solr repository.




A @Restful SpringController ( http://localhost:8080/spring ) calls this service and renders all json including highlighted, facetQueryResult field etc:

    {
      "content": [
        {
          "id": "2",
          "title": "another title with an interesting words or a highlight search "
        },
        {
          "id": "3",
          "title": "another title with an extremely interesting words or a highlight search "
        }
      ],
      "facetResultPages": [
        
      ],
      "facetQueryResult": {
        "content": [
          
        ],
        "last": true,
        "totalPages": 1,
        "totalElements": 0,
        "size": 0,
        "number": 0,
        "sort": null,
        "first": true,
        "numberOfElements": 0
      },
      "highlighted": [
        {
          "entity": {
            "id": "2",
            "title": "another title with an interesting words or a highlight search "
          },
          "highlights": [
            {
              "field": {
                "name": "title_s"
              },
              "snipplets": [
                "<strong>another title with an interesting words or a highlight search </strong>"
              ]
            }
          ]
        },
        {
          "entity": {
            "id": "3",
            "title": "another title with an extremely interesting words or a highlight search "
          },
          "highlights": [
            {
              "field": {
                "name": "title_s"
              },
              "snipplets": [
                "<strong>another title with an extremely interesting words or a highlight search </strong>"
              ]
            }
          ]
        }
      ],
      "maxScore": null,
      "fieldStatsResults": {
        
      },
      "facetFields": [
        
      ],
      "facetPivotFields": [
        
      ],
      "allFacets": [
        null
      ],
      "totalPages": 1,
      "totalElements": 2,
      "size": 20,
      "number": 0,
      "sort": null,
      "first": true,
      "last": true,
      "numberOfElements": 2
    }



However if I try to do the same thing with a regular Grails controller i.e. GsonController  ( http://localhost:8080/gson ) ,
 I struggle to get it to output the same json in views/gson/index.gson

    {
      "content": [
        {
          "title": "another title with an interesting words or a highlight search ",
          "id": "2"
        },
        {
          "title": "another title with an extremely interesting words or a highlight search ",
          "id": "3"
        }
      ]
    }
    
    
    
can anyone help me how to use the Grails controller properly so that it outputs the same json as the spring controller - hopefully without haveing to
manually add lots of code to index.gson
    
    thanks
