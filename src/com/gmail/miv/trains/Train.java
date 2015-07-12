package com.gmail.miv.trains;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "train")
public class Train {
    public String from;
    public String to;
    public Date date;
    public Date departure;

    public Train() {
    }

    @Override
    public String toString() {
        return "Train{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", departure='" + departure + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (from != null ? !from.equals(train.from) : train.from != null) return false;
        if (to != null ? !to.equals(train.to) : train.to != null) return false;
        if (date != null ? !date.equals(train.date) : train.date != null) return false;
        return !(departure != null ? !departure.equals(train.departure) : train.departure != null);

    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        return result;
    }
}
