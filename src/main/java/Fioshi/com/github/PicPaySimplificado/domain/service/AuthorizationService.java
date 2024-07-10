package Fioshi.com.github.PicPaySimplificado.domain.service;

import Fioshi.com.github.PicPaySimplificado.infra.exception.AuthorizationException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class AuthorizationService {

    @SneakyThrows
    public void authorization() {

        URL url = null;

        int responseCode;
        try {

            url = new URL("https://util.devi.tools/api/v2/authorize");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            responseCode = connection.getResponseCode();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (responseCode != HttpURLConnection.HTTP_OK)
            throw new AuthorizationException("Pagamento não aprovado");

    }
}
