/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        //TestCases tests = new TestCases(); // Initialize your test class
        Search_Amazon search = new Search_Amazon();
        //TODOcall your test case functions one after other here

        //tests.testCase01();
        search.SearchAmazon();

        //END Tests

        search.endTest();
        //End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
