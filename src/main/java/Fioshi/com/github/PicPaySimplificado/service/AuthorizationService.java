package Fioshi.com.github.PicPaySimplificado.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class AuthorizationService {

    public String authorization() throws IOException{

            URL url = new URL("https://util.devi.tools/api/v2/authorize");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "Success";
            } else {
                return "Error";
        }
    }

}
