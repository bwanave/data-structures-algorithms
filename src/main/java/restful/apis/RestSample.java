package restful.apis;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RestSample {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ParseException, ExecutionException {
        String body = fetch();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(body);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("status"));
        System.out.println(jsonObject.get("data"));
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");

        // loop array
        Iterator<JSONObject> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject obj = iterator.next();
            System.out.println("--->" + obj);
            System.out.println(obj.get("id"));
        }
    }

    private static String fetch() throws URISyntaxException, InterruptedException, ExecutionException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("https://dummy.restapiexample.com/api/v1/employees"))
                .GET().build();
        CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        return future.get().body();
    }
}
