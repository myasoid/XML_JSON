package com.gmail.miv.trains;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Есть список поездов, представленный с виде XML. Вывести на экран информацию о тех поездах, которые
 отправляются сегодня с 15:00 до 19:00 или др условие.*/

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("src/" + Main.class.getPackage().getName().replace(".", "/") + "/trains.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);

            // читаем из файла
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Trains trains = (Trains) unmarshaller.unmarshal(file);
            System.out.println(trains);

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");


            Date dateDepartureAfter = new Date();
            Date dateAfter = new Date();

            try {
                dateDepartureAfter = sf.parse("1970-01-01T19:00:00");
                dateAfter = sf.parse("2013-12-15T00:00:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }

            final Date dateDepartureAfterFinal = dateDepartureAfter;
            final Date dateAfterFinal = dateAfter;

            trains.list.stream().filter(e -> e.departure.after(dateDepartureAfterFinal) && e.date.after(dateAfterFinal))
                    .forEach(e -> System.out.println(e));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
