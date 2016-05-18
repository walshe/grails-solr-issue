package solr

import org.apache.solr.client.solrj.beans.Field
import org.springframework.data.annotation.Id

class User {

    @Id
    @Field
    String id

    //@Field
    //String text

    //@Field
    //String description

    @Field("title_s")
    String title

}
