package com.harreke.utils.tools;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public class GsonUtil {
    public static <T> T toBean(JsonElement json, Type type) {
        T bean;

        try {
            bean = new Gson().fromJson(json, type);
        } catch (JsonSyntaxException e) {
            bean = null;
        }

        return bean;
    }

    public static <T> T toBean(String json, Type type) {
        T bean;

        try {
            bean = new Gson().fromJson(json, type);
        } catch (JsonSyntaxException e) {
            bean = null;
        }

        return bean;
    }

    public static <T> T toBean(String json, Class<T> classOfT) {
        T bean;

        try {
            bean = new Gson().fromJson(json, classOfT);
        } catch (JsonSyntaxException e) {
            bean = null;
        }

        return bean;
    }

    public static <T> T toBean(JsonElement json, Class<T> classOfT) {
        T bean;

        try {
            bean = new Gson().fromJson(json, classOfT);
        } catch (JsonSyntaxException ignored) {
            bean = null;
        }

        return bean;
    }

    public static String toString(Object bean) {
        if (bean != null) {
            return new Gson().toJson(bean);
        } else {
            return null;
        }
    }
}