package ru.scorocode.android;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ScriptManagerTest extends InstrumentationTestCase {

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testScriptsSuccess() throws Exception {
        String fileName = "success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testScriptsInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }

    @Test
    public void testStatSuccess() throws Exception {
        String fileName = "stat_success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testStatInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

}