package com.target.myretail.utils;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;

public class JsonUtilsTest {

    @Test
    public void getValueFromResponse() {
        JsonUtils.getValueFromResponse(getSampleJson(), "title");

        String name = JsonUtils.getProductTitle();
        Assert.assertNotNull(name);
        Assert.assertNotEquals("title is not empty", "", name);
        Assert.assertEquals("Sample Widget", name);

    }

    private String getSampleJson() {
        return "{\"widget\": {\n" +
                "    \"debug\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Widget\",\n" +
                "        \"name\": \"main_window\",\n" +
                "        \"width\": 500,\n" +
                "        \"height\": 500\n" +
                "    },\n" +
                "    \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 250,\n" +
                "        \"alignment\": \"center\"\n" +
                "    },\n" +
                "    \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "        \"name\": \"text1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 100,\n" +
                "        \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}}    \n";
    }
}