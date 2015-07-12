package com.gmail.miv.yahoo_xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "query")
public class Query {

    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public int count;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public String created;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public String lang;

    @XmlElementWrapper(name = "results")
    @XmlElement(name = "rate")
    public Rate[] results;

    @Override
    public String toString() {
        return "Query{" +
                "count=" + count +
                ", created='" + created + '\'' +
                ", lang='" + lang + '\'' +
                ", results=" + Arrays.toString(results) +
                '}';
    }

    public Query() {
    }

    public Query(int count, String created, String lang, Rate[] results) {
        this.count = count;
        this.created = created;
        this.lang = lang;
        this.results = results;
    }

}
