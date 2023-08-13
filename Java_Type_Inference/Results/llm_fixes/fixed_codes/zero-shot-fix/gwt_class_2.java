import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.GWT;

// ID = 971712

public class gwt_class_2 extends GWTTestCase {

  public String getModuleName() {
    return "com.google.gwt.sample.stockwatcher.StockWatcher";
  }

  public void testSimple() {
    GreetingServiceAsync greetingService = new GreetingServiceAsyncMock();
    greetingService.greetServer("Bob", new AsyncCallback<String>() {
      public void onFailure(Throwable caught) {
        System.out.println(caught);
        fail("big time failure");
        finishTest();
      }

      public void onSuccess(String result) {
        System.out.println("success, biatch");
        assertTrue(true);
        finishTest();
      }
    });
    delayTestFinish(1000);
  }

  // Mock implementation of GreetingServiceAsync
  private static class GreetingServiceAsyncMock implements GreetingServiceAsync {

    public void greetServer(String name, AsyncCallback<String> callback) {
      // Mock response
      String result = "Hello, " + name + "!";
      callback.onSuccess(result);
    }
  }

}

interface GreetingServiceAsync {
  void greetServer(String name, AsyncCallback<String> callback);
}