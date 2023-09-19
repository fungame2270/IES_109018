package com.ua.pt;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.lookup.Log4jLookup;
import org.apache.logging.log4j.LogManager;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    private static int city_id;
    private static Logger logger = LogManager.getLogger(Log4jLookup.class);

    public static void  main(String[] args ) {
        try {
            city_id = Integer.parseInt(args[0]);
        } catch (Exception e) {
            logger.error("ID tem de ser int");
            System.exit(0);
        }
        if (city_id < 0){
            logger.error("ID tem de ser positivo");
            System.exit(0);
        }

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        logger.info("Calling API");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(city_id);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                System.out.printf( "Previsão para %s%nTMax: %4.1fº %nPercentagem de percipitaçao: %4.1f%%",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()),
                        Double.parseDouble(firstDay.getPrecipitaProb())
                        );
            } else {
                System.out.println( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}