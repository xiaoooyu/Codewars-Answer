import java.net.URL;
import java.net.MalformedURLException;

public class UrlTest {
	public static void main(String args[]) {
		try {
			URL url = new URL("https://push.teambition.com/websocket");	
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getProtocol());			
			System.out.println(url.getPath());
		} catch (MalformedURLException e) {
            e.printStackTrace();
        }
		
	}
}