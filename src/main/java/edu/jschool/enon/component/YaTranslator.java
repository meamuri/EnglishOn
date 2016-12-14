package edu.jschool.enon.component;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

public class YaTranslator implements Translator{

    private static final String
            API = "trnsl.1.1.20161213T111003Z.d2c95c028db21968.0080fbb13e75a7d0717cc63849ee848bd95421e9";
    private static final String
            URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + API;

    public String translate(String word, String lang) throws IOException {
        URL urlObj = new URL(URL);
        HttpsURLConnection connection = (HttpsURLConnection)urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(word, "UTF-8") + "&lang=" + lang);

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("]");
        String translated = json.substring(start + 2, end - 1);

        if (translated.equals(word)) {
            // if return equal of entered text - we need change direction of translation
            return translate("en", word);
        } else return translated;

    }

    @Override
    public String translateEnToRu(String word) throws IOException{
        URL urlObj = new URL(URL);
        HttpsURLConnection connection = (HttpsURLConnection)urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        // &lang= направление перевода
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(word, "UTF-8") + "&lang=ru");


        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("]");

        return json.substring(start + 2, end - 1);
    }

    public String springApiTranslate(String word) {
        RestTemplate rest = (new RestTemplateBuilder()).build();
        QueryResult res = rest.getForObject(URL+"&"+word+"&lang=ru", QueryResult.class);
        return res.toString();
    }
}
