package Fioshi.com.github.PicPaySimplificado.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class NotifyService {

    public String notifyng(User user) throws IOException {
        String urlStr = "https://util.devi.tools/api/v1/notify";
        try {
            int responseCode = getResponseCode(urlStr);
            if (responseCode == HttpURLConnection.HTTP_OK ||
                    responseCode == HttpURLConnection.HTTP_CREATED ||
                    responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                return "Notificação enviada para: " + user.getName() + " " + user.getSurname()
                        ;
            } else {
                return "O serviço falhou";
            }
        } catch (IOException e) {
            return "Failed to send notification due to an error: " + e.getMessage();
        }
    }

    private static int getResponseCode(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        String jsonInputString = "{\"message\":\""  + "\"}";
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        return responseCode;
    }
}
