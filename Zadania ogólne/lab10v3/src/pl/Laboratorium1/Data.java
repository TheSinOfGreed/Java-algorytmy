package pl.Laboratorium1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.TimeZone;

public class Data implements Comparable<Data> {


    String time_simple_date_format;
    String time_simple_date_format2;
    Instant poczatek;
    Instant koniec;
    public Data(String time_simple_date_format,String time_simple_date_format2 )  {
        this.time_simple_date_format=time_simple_date_format;
        this.time_simple_date_format2=time_simple_date_format2;
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            poczatek = dateFormat.parse(time_simple_date_format).toInstant();
            koniec = dateFormat.parse(time_simple_date_format2).toInstant();

        }catch(ParseException e){
            throw new NumberFormatException();
        }
    }

    @Override

    public String toString() {
        return poczatek +" - "+koniec;
    }
    @Override
    public int compareTo(Data o) {
        if(this.poczatek.isAfter(o.poczatek)) return 1;
        if(this.poczatek.isBefore(o.poczatek)) return -1;


        return 0;
    }

}
