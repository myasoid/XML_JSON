package com.gmail.miv.trains;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "trains")
public class Trains {
    @Override
    public String toString() {
        return "Trains{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trains trains = (Trains) o;

        return !(list != null ? !list.equals(trains.list) : trains.list != null);

    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }

    @XmlElement(name = "train")
    public List<Train> list = new ArrayList<>();

    public Trains() {

    }

}
