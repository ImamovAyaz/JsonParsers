package org.example.jsonParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

public class JsonToObject {
    public static ArrayList<String> parseArray(String json) {
        ArrayList<String> result = new ArrayList<>();
        boolean startWith = json.startsWith("[");
        boolean endsWith = json.endsWith("]");
        if (startWith && endsWith) {
            String substring = json.substring(1, json.length() - 1);
            List<String> list = Arrays.asList(substring.split("\\{|},\\{|}"));
            list.forEach(element -> {
                if (element.length() > 0) {
                    result.add(String.format("{%s}", element));
                }
            });
        }
        return result;
    }

    public static <T> T func(Class<T> tClass, String json) throws Exception {
        boolean startWith = json.startsWith("{");
        boolean endsWith = json.endsWith("}");
        if (startWith && endsWith) {
            String substring = json.substring(1, json.length() - 1);
            String[] split = substring.split(",");
            HashMap<String, String> hashMap = new HashMap<>();
            Arrays.stream(split).forEach(element -> {
                String replace = element.replace("\"", "");
                String[] elementMap = replace.split(":");
                hashMap.put(elementMap[0].trim(), elementMap[1].trim());
            });

            Constructor<T> constructor = tClass.getConstructor();
            T object = constructor.newInstance();
            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object obj = null;
                if (field.isAnnotationPresent(JsonElement.class)) {
                    if (type.equals(int.class) || type.equals(Integer.class)) {
                        obj = Integer.valueOf(hashMap.get(getKey(field)));
                    }
                    if (type.equals(String.class)) {
                        obj = hashMap.get(getKey(field));
                    }
                    field.set(object, obj);
                }
            }
            return object;
        }
        return null;
    }

    private static String getKey(Field field) {
        JsonElement jsonElement = field.getAnnotation(JsonElement.class);
        String key = jsonElement.key();
        if (key.equals("")) {
            return field.getName();
        } else {
            return key;
        }
    }
}
