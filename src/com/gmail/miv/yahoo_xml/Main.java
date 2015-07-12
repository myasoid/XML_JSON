package com.gmail.miv.yahoo_xml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        String result = performRequest(request);

        System.out.println(result);

        JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Query query = (Query) unmarshaller.unmarshal(new StringReader(result));

        System.out.println(query);
        // Query{count=2, created='2015-07-12T16:43:54Z', lang='en-US', results=[Rate{id='USDEUR', name='USD/EUR',
        // rate=0.8964, date='7/11/2015', time='12:55pm', ask=0.8997, bid=0.8964}, Rate{id='USDUAH', name='USD/UAH',
        // rate=21.95, date='7/11/2015', time='12:55pm', ask=22.202, bid=21.95}]}

    }

    private static String performRequest(String urlStr) throws IOException {

        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } finally {
            http.disconnect();
        }

        return sb.toString();

    }

}