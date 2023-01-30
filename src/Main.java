import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        try{
            fetchData();
        }catch(IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }catch(InterruptedException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        }
        public static void fetchData() throws IOException, InterruptedException{
            String url = "https://api.chucknorris.io/jokes/categories";
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            HttpClient httpClient = HttpClient.newBuilder().build();

            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse.statusCode());
            System.out.println(httpResponse.body());
            System.out.println("finished");
        }
    }
