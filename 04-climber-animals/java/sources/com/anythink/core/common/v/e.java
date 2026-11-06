package com.anythink.core.common.v;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String a = "anythink_platform_check";
    private static volatile e b = null;
    private static volatile int d = -1;
    private final JSONObject c = new JSONObject();

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

    public final void a(final JSONArray jSONArray) {
        com.anythink.core.common.d.t.b().b(new Runnable() { // from class: com.anythink.core.common.v.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONArray jSONArray2 = jSONArray;
                    if (jSONArray2 == null || jSONArray2.length() <= 0) {
                        return;
                    }
                    if (e.d == -1 || e.d != jSONArray.length()) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                            if (jSONObject != null) {
                                String strOptString = jSONObject.optString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_NAME);
                                String strOptString2 = jSONObject.optString("network_class");
                                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                                    e.a(e.this, strOptString, strOptString2);
                                }
                            }
                        }
                        if (e.this.c.length() > 0) {
                            new StringBuilder("sendChannelCheckResult:").append(e.this.c);
                            com.anythink.core.common.u.e.a(e.this.c.toString());
                            int unused = e.d = jSONArray.length();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003f  */
    private void a(String str, String str2) throws JSONException, NoSuchMethodException, ClassNotFoundException {
        byte b2;
        try {
            try {
                Class.forName(str2);
                this.c.put(str, "");
            } catch (Throwable unused) {
                return;
            }
        } catch (ClassNotFoundException unused2) {
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 102037) {
            if (iHashCode != 114519) {
                if (iHashCode == 114533 && str.equals("t_p")) {
                    b2 = 2;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("t_b")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
        } else if (str.equals("g_m")) {
            b2 = 1;
        } else {
            b2 = -1;
        }
        if (b2 == 0) {
            Class<?> cls = Class.forName(str2);
            Method method = cls.getMethod("getVersion", new Class[0]);
            method.setAccessible(true);
            String str3 = (String) method.invoke(cls, new Object[0]);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            this.c.put(str, str3);
            return;
        }
        if (b2 != 1) {
            if (b2 != 2) {
                return;
            }
            try {
                Class<?> cls2 = Class.forName(str2);
                Method method2 = cls2.getMethod("getSdkVersion", new Class[0]);
                method2.setAccessible(true);
                String str4 = (String) method2.invoke(cls2, new Object[0]);
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                this.c.put(str, str4);
                return;
            } catch (Exception unused3) {
                return;
            }
        }
        try {
            Class<?> cls3 = Class.forName(str2);
            Method method3 = cls3.getMethod("getAdManager", new Class[0]);
            method3.setAccessible(true);
            Object objInvoke = method3.invoke(cls3, new Object[0]);
            if (objInvoke != null) {
                Method method4 = objInvoke.getClass().getMethod("getSDKVersion", new Class[0]);
                method4.setAccessible(true);
                String str5 = (String) method4.invoke(objInvoke, new Object[0]);
                if (TextUtils.isEmpty(str5)) {
                    return;
                }
                this.c.put(str, str5);
            }
        } catch (Exception unused4) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003f  */
    static /* synthetic */ void a(e eVar, String str, String str2) throws JSONException, NoSuchMethodException, ClassNotFoundException {
        byte b2;
        try {
            try {
                Class.forName(str2);
                eVar.c.put(str, "");
            } catch (Throwable unused) {
                return;
            }
        } catch (ClassNotFoundException unused2) {
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 102037) {
            if (iHashCode != 114519) {
                if (iHashCode == 114533 && str.equals("t_p")) {
                    b2 = 2;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("t_b")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
        } else if (str.equals("g_m")) {
            b2 = 1;
        } else {
            b2 = -1;
        }
        if (b2 == 0) {
            Class<?> cls = Class.forName(str2);
            Method method = cls.getMethod("getVersion", new Class[0]);
            method.setAccessible(true);
            String str3 = (String) method.invoke(cls, new Object[0]);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            eVar.c.put(str, str3);
            return;
        }
        if (b2 != 1) {
            if (b2 != 2) {
                return;
            }
            try {
                Class<?> cls2 = Class.forName(str2);
                Method method2 = cls2.getMethod("getSdkVersion", new Class[0]);
                method2.setAccessible(true);
                String str4 = (String) method2.invoke(cls2, new Object[0]);
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                eVar.c.put(str, str4);
                return;
            } catch (Exception unused3) {
                return;
            }
        }
        try {
            Class<?> cls3 = Class.forName(str2);
            Method method3 = cls3.getMethod("getAdManager", new Class[0]);
            method3.setAccessible(true);
            Object objInvoke = method3.invoke(cls3, new Object[0]);
            if (objInvoke != null) {
                Method method4 = objInvoke.getClass().getMethod("getSDKVersion", new Class[0]);
                method4.setAccessible(true);
                String str5 = (String) method4.invoke(objInvoke, new Object[0]);
                if (TextUtils.isEmpty(str5)) {
                    return;
                }
                eVar.c.put(str, str5);
            }
        } catch (Exception unused4) {
        }
    }
}
