package example.example.util;

import java.util.HashMap;
import java.util.Map;

public class TestDataRepository {
    private static Map<String, String> testDataMap = new HashMap<>();

    public static void storeTestData(String key, String value) {
        testDataMap.put(key, value);
    }

    public static String retrieveTestData(String key) {
        return testDataMap.get(key);
    }
}

