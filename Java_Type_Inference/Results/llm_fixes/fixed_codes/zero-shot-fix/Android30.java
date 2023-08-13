package androidExamples;
import java.io.IOException; // Added import statement for IOException
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpHost;

public class Android30 {

    public static String main(String[] args) {
        HttpHost target = new HttpHost("http://" + ServiceWrapper.SERVER_HOST,ServiceWrapper.SERVER_PORT);
        HttpGet get = new HttpGet("/list");
        String result=null;
        HttpEntity entity = null;
        HttpClient client = new DefaultHttpClient();
        try {
            HttpResponse response=client.execute(target, get);
            entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entity!=null)
                try {
                    entity.getContent().close(); // Updated entity.consumeContent() to entity.getContent().close()
                } catch (IOException e) {}
        }
        return result;
    }

}

class ServiceWrapper
{
    static String SERVER_HOST = "host";
    static int SERVER_PORT = 8080;
}