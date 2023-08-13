package gwt;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.sample.stockwatcher.client.GreetingServiceAsync;
import com.google.gwt.sample.stockwatcher.client.GreetingService;
import com.google.gwt.user.client.rpc.AsyncCallback;
//ID = 971712


/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class gwt_class_2 extends GWTTestCase {

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.google.gwt.sample.stockwatcher.StockWatcher";
  }

  /**
   * Add as many tests as you like.
   */
  public void testSimple() {
      GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
      greetingService.greetServer("Bob",
       new AsyncCallback<String>() {
        public void onFailure(Throwable caught) {
         // Show the RPC error message to the user
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