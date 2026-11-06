package com.anythink.core.common.u;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String a = "anythink_platform_check";
    private static volatile e b = null;
    private static final String c = "t_b";
    private static final String d = "g_m";
    private static final String e = "t_p";
    private static final String f = "t_ps";
    private static final String g = "p_g";
    private static final String h = "l_y";
    private static final String i = "b_z";
    private static final String j = "z_y";
    private static final String k = "u_bx";
    private static final String l = "y_t";
    private static volatile int n = -1;
    private final JSONObject m = new JSONObject();

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    private e() {
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00af  */
    public final synchronized void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (n != -1 && n == jSONArray.length()) {
                        return;
                    }
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                        if (jSONObject != null) {
                            String strOptString = jSONObject.optString("network_name");
                            String strOptString2 = jSONObject.optString("network_class");
                            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                                try {
                                    try {
                                        Class.forName(strOptString2);
                                        this.m.put(strOptString, "");
                                    } catch (Throwable unused) {
                                    }
                                } catch (ClassNotFoundException unused2) {
                                }
                                switch (strOptString) {
                                    case "t_b":
                                        Class<?> cls = Class.forName(strOptString2);
                                        Method method = cls.getMethod("getVersion", new Class[0]);
                                        method.setAccessible(true);
                                        String str = (String) method.invoke(cls, new Object[0]);
                                        if (!TextUtils.isEmpty(str)) {
                                            this.m.put(strOptString, str);
                                            break;
                                        } else {
                                            break;
                                        }
                                        break;
                                    case "g_m":
                                        Class<?> cls2 = Class.forName(strOptString2);
                                        Method method2 = cls2.getMethod("getAdManager", new Class[0]);
                                        method2.setAccessible(true);
                                        Object objInvoke = method2.invoke(cls2, new Object[0]);
                                        if (objInvoke == null) {
                                            break;
                                        } else {
                                            Method method3 = objInvoke.getClass().getMethod("getSDKVersion", new Class[0]);
                                            method3.setAccessible(true);
                                            String str2 = (String) method3.invoke(objInvoke, new Object[0]);
                                            if (!TextUtils.isEmpty(str2)) {
                                                this.m.put(strOptString, str2);
                                            }
                                            break;
                                        }
                                        break;
                                    case "t_ps":
                                        Field field = Class.forName(strOptString2).getField("VERSION_NAME");
                                        field.setAccessible(true);
                                        String str3 = (String) field.get(null);
                                        if (!TextUtils.isEmpty(str3)) {
                                            this.m.put(strOptString, str3);
                                            break;
                                        } else {
                                            break;
                                        }
                                        break;
                                    case "p_g":
                                        Class<?> cls3 = Class.forName(strOptString2);
                                        Method method4 = cls3.getMethod("getSDKVersion", new Class[0]);
                                        method4.setAccessible(true);
                                        String str4 = (String) method4.invoke(cls3, new Object[0]);
                                        if (!TextUtils.isEmpty(str4)) {
                                            this.m.put(strOptString, str4);
                                            break;
                                        } else {
                                            break;
                                        }
                                        break;
                                    case "l_y":
                                    case "b_z":
                                    case "z_y":
                                        Class<?> cls4 = Class.forName(strOptString2);
                                        Method method5 = cls4.getMethod("getSdkVersion", new Class[0]);
                                        method5.setAccessible(true);
                                        String str5 = (String) method5.invoke(cls4, new Object[0]);
                                        if (!TextUtils.isEmpty(str5)) {
                                            this.m.put(strOptString, str5);
                                            break;
                                        } else {
                                            break;
                                        }
                                        break;
                                    case "u_bx":
                                        Field field2 = Class.forName(strOptString2).getField("sdkVersion");
                                        field2.setAccessible(true);
                                        String str6 = (String) field2.get(null);
                                        if (!TextUtils.isEmpty(str6)) {
                                            this.m.put(strOptString, str6);
                                            break;
                                        } else {
                                            break;
                                        }
                                        break;
                                    case "y_t":
                                        Class<?> cls5 = Class.forName(strOptString2);
                                        Method method6 = cls5.getMethod("getYouTuiADNSDKVersion", new Class[0]);
                                        method6.setAccessible(true);
                                        String str7 = (String) method6.invoke(cls5, new Object[0]);
                                        if (!TextUtils.isEmpty(str7)) {
                                            this.m.put(strOptString, str7);
                                            break;
                                        } else {
                                            break;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    if (this.m.length() > 0) {
                        com.anythink.core.common.t.f.b(this.m.toString(), (String) null);
                        n = jSONArray.length();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final synchronized void a(int i2, Map<String, Object> map) {
        try {
            if (this.m.length() > 0) {
                Iterator<String> itKeys = this.m.keys();
                JSONObject jSONObject = new JSONObject();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("version", (String) this.m.get(next));
                    if (next.equals(d) && (i2 == 46 || i2 == 15)) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            jSONObject2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    if (next.equals(g) && i2 == 92) {
                        for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                            jSONObject2.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    jSONObject.put(next, jSONObject2);
                }
                com.anythink.core.common.t.f.b(this.m.toString(), jSONObject.toString());
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    private void a(String str, String str2) throws JSONException, NoSuchMethodException, ClassNotFoundException {
        try {
            try {
                Class.forName(str2);
                this.m.put(str, "");
            } catch (Throwable unused) {
                return;
            }
        } catch (ClassNotFoundException unused2) {
        }
        switch (str) {
            case "t_b":
                Class<?> cls = Class.forName(str2);
                Method method = cls.getMethod("getVersion", new Class[0]);
                method.setAccessible(true);
                String str3 = (String) method.invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str3)) {
                    this.m.put(str, str3);
                    break;
                }
                break;
            case "g_m":
                try {
                    Class<?> cls2 = Class.forName(str2);
                    Method method2 = cls2.getMethod("getAdManager", new Class[0]);
                    method2.setAccessible(true);
                    Object objInvoke = method2.invoke(cls2, new Object[0]);
                    if (objInvoke != null) {
                        Method method3 = objInvoke.getClass().getMethod("getSDKVersion", new Class[0]);
                        method3.setAccessible(true);
                        String str4 = (String) method3.invoke(objInvoke, new Object[0]);
                        if (!TextUtils.isEmpty(str4)) {
                            this.m.put(str, str4);
                        }
                    }
                    break;
                } catch (Exception unused3) {
                    return;
                }
                break;
            case "t_ps":
                try {
                    Field field = Class.forName(str2).getField("VERSION_NAME");
                    field.setAccessible(true);
                    String str5 = (String) field.get(null);
                    if (!TextUtils.isEmpty(str5)) {
                        this.m.put(str, str5);
                    }
                    break;
                } catch (Exception unused4) {
                    return;
                }
                break;
            case "p_g":
                try {
                    Class<?> cls3 = Class.forName(str2);
                    Method method4 = cls3.getMethod("getSDKVersion", new Class[0]);
                    method4.setAccessible(true);
                    String str6 = (String) method4.invoke(cls3, new Object[0]);
                    if (!TextUtils.isEmpty(str6)) {
                        this.m.put(str, str6);
                    }
                    break;
                } catch (Exception unused5) {
                    return;
                }
                break;
            case "l_y":
            case "b_z":
            case "z_y":
                try {
                    Class<?> cls4 = Class.forName(str2);
                    Method method5 = cls4.getMethod("getSdkVersion", new Class[0]);
                    method5.setAccessible(true);
                    String str7 = (String) method5.invoke(cls4, new Object[0]);
                    if (!TextUtils.isEmpty(str7)) {
                        this.m.put(str, str7);
                    }
                    break;
                } catch (Exception unused6) {
                    return;
                }
                break;
            case "u_bx":
                try {
                    Field field2 = Class.forName(str2).getField("sdkVersion");
                    field2.setAccessible(true);
                    String str8 = (String) field2.get(null);
                    if (!TextUtils.isEmpty(str8)) {
                        this.m.put(str, str8);
                    }
                    break;
                } catch (Exception unused7) {
                    return;
                }
                break;
            case "y_t":
                Class<?> cls5 = Class.forName(str2);
                Method method6 = cls5.getMethod("getYouTuiADNSDKVersion", new Class[0]);
                method6.setAccessible(true);
                String str9 = (String) method6.invoke(cls5, new Object[0]);
                if (!TextUtils.isEmpty(str9)) {
                    this.m.put(str, str9);
                    break;
                }
                break;
        }
    }
}
