package com.cofire.common.utils.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FormDecoder {
    private Map<String, String> parameters;

    public FormDecoder(String str) {
        this.parameters = new HashMap<>();
        parse(this.parameters, str);
    }

    public String get(String key) {
        return this.get(key, null);
    }

    public String get(String key, String defaultValue) {
        String value = this.parameters.get(key);
        return Objects.isNull(value) ? defaultValue : value;
    }

    private int getInt32(String key) {
        return this.getInt32(key, 0);
    }

    private int getInt32(String key, int defaultValue) {
        String value = this.parameters.get(key);
        return Objects.isNull(value) || value.isEmpty() ? defaultValue : Integer.parseInt(value);
    }

    public long getInt64(String key) {
        return this.getInt64(key, 0L);
    }

    private long getInt64(String key, long defaultValue) {
        String value = this.parameters.get(key);
        return Objects.isNull(value) || value.isEmpty() ? defaultValue : Long.parseLong(value);
    }

    private float getFloat32(String key) {
        return this.getFloat32(key, 0F);
    }

    private float getFloat32(String key, float defaultValue) {
        String value = this.parameters.get(key);
        return Objects.isNull(value) || value.isEmpty() ? defaultValue : Float.parseFloat(value);
    }

    public double getFloat64(String key) {
        return this.getFloat64(key, 0D);
    }

    private double getFloat64(String key, double defaultValue) {
        String value = this.parameters.get(key);
        return Objects.isNull(value) || value.isEmpty() ? defaultValue : Double.parseDouble(value);
    }

    private boolean getBool(String key) {
        return this.getBool(key, false);
    }

    private boolean getBool(String key, boolean defaultValue) {
        String value = this.parameters.get(key);
        return Objects.isNull(value) || value.isEmpty() ? defaultValue : Boolean.parseBoolean(value);
    }

    private boolean contains(String key) {
        return this.parameters.containsKey(key);
    }

    private static void parse(Map<String, String> map, String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return;
        }
        Arrays.stream(str.split(", ")).filter(kv -> kv.contains("=")).map(kv -> kv.split("=")).forEach(array -> map.put(array[0], array[1]));
    }

    public static void main(String[] args) {
        String str = "OPEN-BODY-SIG AppId=\"10037ca764636bbc01647d1ef4e10009\", Timestamp=\"20191113110803\", Nonce=\"89e0b83911dd4d85996cd6190afe5f05\", Signature=\"A+cV8CGIhmCBcbMgi4oSLZqJ1qn9kd61VVpO5fMYVpY=\" ";
        FormDecoder decoder = new FormDecoder(str);
        System.out.println(decoder.get("OPEN-BODY-SIG AppId"));
        System.out.println(decoder.get("Timestamp"));
        System.out.println(decoder.get("Nonce"));
        System.out.println(decoder.get("Signature"));
    }
}
