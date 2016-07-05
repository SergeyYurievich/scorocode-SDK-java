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
public class DataManagerTest extends InstrumentationTestCase {

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testInsertSuccess() throws Exception {
        String fileName = "insert_success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testInsertInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }


    @Test
    public void testRemoveSuccess() throws Exception {
        String fileName = "remove_update_success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testRemoveInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }


    @Test
    public void testUpdateSuccess() throws Exception {
        String fileName = "remove_update_success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testUpdateInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }


    @Test
    public void testUpdateByIdSuccess() throws Exception {
        String fileName = "insert_success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testUpdateByIdInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }


    @Test
    public void testFindSuccess() throws Exception {
        String fileName = "insert_success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testFindInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }

    @Test
    public void testCountSuccess() throws Exception {
        String fileName = "count_success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testCountInternalServerError() throws Exception {
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