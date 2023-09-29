package gwt;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.sample.stockwatcher.client.GreetingService;
import com.google.gwt.sample.stockwatcher.client.GreetingServiceAsync;
import com.google.gwt.core.client.GWT;

public class gwt_class_2 extends GWTTestCase {

  public String getModuleName() {
    return "com.google.gwt.sample.stockwatcher.StockWatcher";
  }

  public void testSimple() {
    GreetingServiceAsync greetingService = GWT.create(GreetingServiceAsync.class);
    greetingService.greetServer("Bob",
        new AsyncCallback<String>() {
          public void onFailure(Throwable caught) {
            System.out.println(caught);
            fail("big time failure");
            finishTest();
          }

          public void onSuccess(String result) {
            System.out.println("success, biatch");
            assertTrue(true);
          }
        });
    delayTestFinish(1000);
  }

}