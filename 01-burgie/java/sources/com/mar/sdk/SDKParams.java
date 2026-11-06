package com.mar.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SDKParams {
    private Map<String, String> configs;
    private Map<String, Object> objConfigs;

    public SDKParams() {
        this.objConfigs = new HashMap();
        this.configs = new HashMap();
    }

    public SDKParams(Map<String, String> configs) {
        this();
        if (configs != null) {
            for (String key : configs.keySet()) {
                put(key, configs.get(key));
            }
        }
    }

    public boolean contains(String key) {
        return this.configs.containsKey(key);
    }

    public void put(String key, String value) {
        this.configs.put(key, value);
    }

    public void put(String key, boolean val) {
        this.configs.put(key, String.valueOf(val));
    }

    public void put(String key, int val) {
        this.configs.put(key, val + "");
    }

    public void put(String key, long val) {
        this.configs.put(key, val + "");
    }

    public void put(String key, short val) {
        this.configs.put(key, ((int) val) + "");
    }

    public void put(String key, float val) {
        this.configs.put(key, val + "");
    }

    public void put(String key, double val) {
        this.configs.put(key, val + "");
    }

    public void put(String key, byte val) {
        this.configs.put(key, ((int) val) + "");
    }

    public String getString(String key) {
        if (this.configs.containsKey(key)) {
            return this.configs.get(key);
        }
        return null;
    }

    public int getInt(String key) {
        String val = getString(key);
        if (val == null) {
            return 0;
        }
        try {
            if (val.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(val);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    public Float getFloat(String key) {
        float f;
        String val = getString(key);
        if (val != null) {
            try {
                if (val.isEmpty()) {
                    f = 0.0f;
                } else {
                    f = Float.parseFloat(val);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            f = 0.0f;
        }
        return Float.valueOf(f);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    public Double getDouble(String key) {
        double d;
        String val = getString(key);
        if (val != null) {
            try {
                if (val.isEmpty()) {
                    d = 0.0d;
                } else {
                    d = Double.parseDouble(val);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    public Long getLong(String key) {
        long j;
        String val = getString(key);
        if (val != null) {
            try {
                if (val.isEmpty()) {
                    j = 0;
                } else {
                    j = Long.parseLong(val);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            j = 0;
        }
        return Long.valueOf(j);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    public Boolean getBoolean(String key) {
        boolean z;
        String val = getString(key);
        if (val == null) {
            z = false;
        } else {
            try {
                if (val.isEmpty() || !Boolean.parseBoolean(val)) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    public Short getShort(String key) {
        short s;
        String val = getString(key);
        if (val != null) {
            try {
                if (val.isEmpty()) {
                    s = 0;
                } else {
                    s = Short.parseShort(val);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            s = 0;
        }
        return Short.valueOf(s);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    public Byte getByte(String key) {
        byte b;
        String val = getString(key);
        if (val != null) {
            try {
                if (val.isEmpty()) {
                    b = 0;
                } else {
                    b = Byte.parseByte(val);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            b = 0;
        }
        return Byte.valueOf(b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : this.configs.keySet()) {
            sb.append(key).append("=").append(this.configs.get(key)).append("\n");
        }
        return sb.toString();
    }

    public JSONObject toJSONOBject() throws JSONException {
        JSONObject json = new JSONObject();
        for (String key : this.configs.keySet()) {
            json.put(key, this.configs.get(key));
        }
        return json;
    }

    public Map<String, String> getConfings() {
        return this.configs;
    }

    public Map<String, Object> getObjConfings() {
        return this.objConfigs;
    }

    public void setObjConfigs(Map<String, Object> configs) {
        this.objConfigs = configs;
    }
}
