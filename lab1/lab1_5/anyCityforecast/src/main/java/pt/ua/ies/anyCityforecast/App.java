package pt.ua.ies.anyCityforecast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import pt.ua.ies.ipmaapiclient.Weather;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Random r = new Random();
        int[] city = {1010500,1020500,1030300,1030800,1040200,1050200,1060300,1070500,1080500,1080800,1081100,1081505,1090700,1090821,1100900,1110600,1121400,1131200,1141600,1151200,1151300,1160900,1171400,1182300,2310300,2320100,3410100,3420300,3430100,3440100,3450200,3460200,3470100,3480200,3490100};
        while (true) {
            System.out.println(Weather.apiCall(city[r.nextInt(city.length)]));
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
