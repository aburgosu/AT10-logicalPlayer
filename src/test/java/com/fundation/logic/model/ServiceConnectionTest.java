package com.fundation.logic.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ServiceConnectionTest {

    @Test
    public void convert() {
    }

    @Test
    public void getStatus() {
        ServiceConnection service = new ServiceConnection();
        int actual = service.getStatus();
        int expected = ServiceConnection.WAITING;
        assertEquals(actual,expected);
    }

    @Test
    public void readConfigurationEndpoint_localhost_true() {
        ServiceConnection service = new ServiceConnection();
        String actual = service.readConfigurationEndpoint();
        String expected = "http://127.0.0.1/convert";
        assertEquals(actual,expected);
    }
}
