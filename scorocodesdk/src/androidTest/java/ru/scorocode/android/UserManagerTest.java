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
public class UserManagerTest extends InstrumentationTestCase {

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testUserRegistrationSuccess() throws Exception {
        String fileName = "success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testUserRegistrationInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }

    @Test
    public void testUserLoginSuccess() throws Exception {
        String fileName = "user_login_success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testUserLoginInternalServerError() throws Exception {
        String fileName = "error_502.json";

        server.enqueue(new MockResponse()
                .setResponseCode(502)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

    }

    @Test
    public void testUserLogoutSuccess() throws Exception {
        String fileName = "success.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
    }


    @Test
    public void testUserLogoutInternalServerError() throws Exception {
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