import com.google.gwt.http.client.*;
import com.google.gwt.user.client.*;

public class GwtClass8 {
    public static void main(String[] args) throws RequestException{
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST,"j_spring_security_check");
        requestBuilder.setHeader("Content-Type", "application/x-www-form-urlencoded");
        
        requestBuilder.setRequestData("j_username=test1" +
                "&j_password=abc");

        requestBuilder.setCallback(new RequestCallback() {
            public void onError(Request request, Throwable exception)
            {
                Window.alert("ERROR !!!"+exception.getMessage());
            }
            
            public void onResponseReceived(Request request, Response response)
            {
                if (response.getStatusCode() != Response.SC_UNAUTHORIZED && response.getStatusCode() != Response.SC_OK)
                { 
                    onError(request, new RequestException(response.getStatusText() + ":\n" + response.getText())); 
                    return; 
                }

                if (response.getStatusCode() == Response.SC_UNAUTHORIZED)
                { 
                    Window.alert("You have entered an incorrect username or password. Please try again."); 
                }
                else
                { 
                    String height = 800+"";
                    String width = 600+"";

                    Window.alert("Authorization succeeded, you may enter....");
                    Window.open("MainScreen.html", "Main screen!!", "height=" + height + ",width=" + width
                            + ",scrollbars=yes,resizable=yes,titlebar=no,toolbar=no,status=yes,close=no,left=0,top=0");
                } 

            }
        });
        requestBuilder.send();
    }
}