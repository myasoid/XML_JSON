package com.gmail.miv.yahoo_xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rate")
public class Rate {
    @XmlAttribute
    public String id;
    @XmlElement(name = "Name")
    public String name;
    @XmlElement(name = "Rate")
    public double rate;
    @XmlElement(name = "Date")
    public String date;
    @XmlElement(name = "Time")
    public String time;
    @XmlElement(name = "Ask")
    public double ask;
    @XmlElement(name = "Bid")
    public double bid;



    public Rate() {
    }

    public Rate(String id, String name, double rate, String date, String time, double ask, double bid) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.date = date;
        this.time = time;
        this.ask = ask;
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", ask=" + ask +
                ", bid=" + bid +
                '}';
    }
}
