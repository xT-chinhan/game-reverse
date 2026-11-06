package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ZIDManager {
    public static ZIDManager d;
    public boolean a = false;
    public boolean b = false;
    public boolean c;

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(strA);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.a(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String strOptString;
        String str = null;
        if (!zIDManager.a) {
            zIDManager.a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put(an.aD, id);
                String strB = d.b(context);
                jSONObject.put(an.A, strB);
                String strC = d.c(context);
                jSONObject.put("o", strC);
                zIDManager.a(context, jSONObject);
                String strA = com.umeng.umzid.a.a("https://utoken.umeng.com/api/postZdata/v4", jSONObject.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject2 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, strB);
                        d.b(context, strC);
                        strOptString = jSONObject2.optString("aaid");
                        try {
                            if (!TextUtils.isEmpty(strOptString)) {
                                d.e(context, strOptString);
                            }
                            String string = jSONObject2.getString("uabc");
                            if (!TextUtils.isEmpty(string)) {
                                d.d(context, string);
                            }
                            String string2 = jSONObject2.getString("resetToken");
                            if (!TextUtils.isEmpty(string2)) {
                                d.c(context, string2);
                            }
                        } catch (Throwable th) {
                        }
                        str = strOptString;
                    }
                }
            } catch (Throwable th2) {
                strOptString = null;
            }
            zIDManager.a = false;
        }
        return str;
    }

    public static synchronized ZIDManager getInstance() {
        if (d == null) {
            d = new ZIDManager();
        }
        return d;
    }

    public static String getSDKVersion() {
        return "1.6.3";
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String strA = d.a(applicationContext);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        this.c = d.d(context);
        if (this.c) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1001", "传入参数Context为null");
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1003", "传入参数appkey为空");
                }
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.umzid.a.a(applicationContext)) != null && (editorEdit = sharedPreferencesA.edit()) != null) {
                editorEdit.putString("appkey", str).commit();
            }
            String strA = d.a(applicationContext);
            if (strA == null || TextUtils.isEmpty(strA)) {
                com.umeng.umzid.c.a(new a(applicationContext, iZIDCompletionCallback));
            } else {
                com.umeng.umzid.c.a(new b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(strA);
                }
            }
            SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(sharedPreferencesA2 != null ? sharedPreferencesA2.getString("uuid", "") : "")) {
                String string = "";
                SharedPreferences sharedPreferencesA3 = com.umeng.umzid.a.a(context);
                try {
                    string = UUID.randomUUID().toString();
                } catch (Throwable th) {
                }
                if (sharedPreferencesA3 != null) {
                    sharedPreferencesA3.edit().putString("uuid", string).commit();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:28:0x006e A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #4 {all -> 0x0066, blocks: (B:23:0x0061, B:26:0x0068, B:28:0x006e), top: B:114:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x007b  */
    public final JSONObject a(Context context, JSONObject jSONObject) throws JSONException {
        Locale locale;
        Calendar calendar;
        int rawOffset;
        String string;
        Object obj;
        Object string2;
        Object country;
        Object obj2;
        Method declaredMethod;
        SharedPreferences sharedPreferencesA;
        Method declaredMethod2;
        Method declaredMethod3;
        jSONObject.putOpt("z_v", Spy.getVersion());
        Object obj3 = "";
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls != null && (declaredMethod3 = cls.getDeclaredMethod("getAndroidId", Context.class)) != null) {
                declaredMethod3.setAccessible(true);
                Object objInvoke = declaredMethod3.invoke(cls, context);
                if (objInvoke != null && (objInvoke instanceof String)) {
                    obj3 = (String) objInvoke;
                }
            }
        } catch (Throwable th) {
        }
        jSONObject.putOpt("a_id", obj3);
        jSONObject.putOpt("os_v", Build.VERSION.RELEASE);
        Object string3 = null;
        if (context == null) {
            rawOffset = 8;
        } else {
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Throwable th2) {
                locale = null;
            }
            if (locale == null) {
                try {
                    locale = Locale.getDefault();
                    calendar = Calendar.getInstance(locale);
                    if (calendar != null) {
                        rawOffset = calendar.getTimeZone().getRawOffset() / BaseConstants.Time.HOUR;
                    } else {
                        rawOffset = 8;
                    }
                } catch (Throwable th3) {
                }
            } else {
                calendar = Calendar.getInstance(locale);
                if (calendar != null) {
                    rawOffset = calendar.getTimeZone().getRawOffset() / BaseConstants.Time.HOUR;
                } else {
                    rawOffset = 8;
                }
            }
        }
        jSONObject.putOpt("tz", Integer.valueOf(rawOffset));
        jSONObject.putOpt("m", Build.MODEL);
        Object obj4 = "";
        try {
            Class<?> cls2 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls2 != null && (declaredMethod2 = cls2.getDeclaredMethod("getImeiNew", Context.class)) != null) {
                declaredMethod2.setAccessible(true);
                Object objInvoke2 = declaredMethod2.invoke(cls2, context);
                if (objInvoke2 != null && (objInvoke2 instanceof String)) {
                    obj4 = (String) objInvoke2;
                }
            }
        } catch (Throwable th4) {
        }
        jSONObject.putOpt("im", obj4);
        try {
            Method declaredMethod4 = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod4.setAccessible(true);
            string = declaredMethod4.invoke(null, "net.hostname").toString();
            if (string != null) {
                try {
                    if (!string.equalsIgnoreCase("")) {
                        try {
                            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                            messageDigest.update(string.getBytes());
                            byte[] bArrDigest = messageDigest.digest();
                            StringBuffer stringBuffer = new StringBuffer();
                            for (byte b2 : bArrDigest) {
                                stringBuffer.append(Integer.toHexString(b2 & UByte.MAX_VALUE));
                            }
                            string = stringBuffer.toString();
                        } catch (Throwable th5) {
                            string = "";
                        }
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            string = null;
        }
        jSONObject.putOpt("hn", string);
        jSONObject.putOpt("s_v", "1.6.3");
        jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
        jSONObject.putOpt("s_t", "Android");
        SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
        jSONObject.putOpt("uid", sharedPreferencesA2 != null ? sharedPreferencesA2.getString("uuid", "") : "");
        jSONObject.putOpt("s_id", BaseConstants.CATEGORY_UMENG);
        try {
            obj = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e3) {
            e3.printStackTrace();
            obj = null;
        }
        jSONObject.putOpt("a_v", obj);
        try {
            string2 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e4) {
            e4.printStackTrace();
            string2 = null;
        }
        jSONObject.putOpt("a_n", string2);
        try {
            country = context.getResources().getConfiguration().locale.getCountry();
        } catch (Exception e5) {
            e5.printStackTrace();
            country = null;
        }
        jSONObject.putOpt(an.aF, country);
        if (context != null && (sharedPreferencesA = com.umeng.umzid.a.a(context)) != null) {
            string3 = sharedPreferencesA.getString("appkey", null);
        }
        jSONObject.putOpt("ak", string3);
        try {
            Class<?> cls3 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls3 == null || (declaredMethod = cls3.getDeclaredMethod("getIdfa", Context.class)) == null) {
                obj2 = "";
            } else {
                declaredMethod.setAccessible(true);
                Object objInvoke3 = declaredMethod.invoke(cls3, context);
                if (objInvoke3 == null || !(objInvoke3 instanceof String)) {
                    obj2 = "";
                } else {
                    obj2 = (String) objInvoke3;
                }
            }
        } catch (Throwable th6) {
        }
        jSONObject.putOpt("gd", obj2);
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    /* JADX WARN: Code duplicated, block: B:16:0x002f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0052  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f5 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:25:0x0042, B:27:0x0048, B:32:0x0054, B:34:0x0064, B:36:0x006a, B:38:0x0078, B:41:0x007f, B:43:0x008f, B:45:0x0095, B:47:0x00a3, B:50:0x00aa, B:52:0x00c6, B:54:0x00cc, B:57:0x00d7, B:59:0x00de, B:61:0x00e4, B:64:0x00ef, B:66:0x00f5, B:68:0x00fc, B:70:0x010a, B:72:0x011f), top: B:91:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x010a A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:25:0x0042, B:27:0x0048, B:32:0x0054, B:34:0x0064, B:36:0x006a, B:38:0x0078, B:41:0x007f, B:43:0x008f, B:45:0x0095, B:47:0x00a3, B:50:0x00aa, B:52:0x00c6, B:54:0x00cc, B:57:0x00d7, B:59:0x00de, B:61:0x00e4, B:64:0x00ef, B:66:0x00f5, B:68:0x00fc, B:70:0x010a, B:72:0x011f), top: B:91:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x011f A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:25:0x0042, B:27:0x0048, B:32:0x0054, B:34:0x0064, B:36:0x006a, B:38:0x0078, B:41:0x007f, B:43:0x008f, B:45:0x0095, B:47:0x00a3, B:50:0x00aa, B:52:0x00c6, B:54:0x00cc, B:57:0x00d7, B:59:0x00de, B:61:0x00e4, B:64:0x00ef, B:66:0x00f5, B:68:0x00fc, B:70:0x010a, B:72:0x011f), top: B:91:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0134 A[Catch: all -> 0x0157, TryCatch #1 {all -> 0x0157, blocks: (B:73:0x012e, B:75:0x0134, B:76:0x0137, B:78:0x0143, B:79:0x0146, B:81:0x0152), top: B:89:0x012e }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0143 A[Catch: all -> 0x0157, TryCatch #1 {all -> 0x0157, blocks: (B:73:0x012e, B:75:0x0134, B:76:0x0137, B:78:0x0143, B:79:0x0146, B:81:0x0152), top: B:89:0x012e }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0152 A[Catch: all -> 0x0157, TRY_LEAVE, TryCatch #1 {all -> 0x0157, blocks: (B:73:0x012e, B:75:0x0134, B:76:0x0137, B:78:0x0143, B:79:0x0146, B:81:0x0152), top: B:89:0x012e }] */
    public final String a(Context context) {
        String string;
        boolean z;
        Object string2;
        String id;
        String string3;
        String strC;
        String string4;
        String strB;
        Object string5;
        String string6;
        String strA;
        JSONObject jSONObject;
        String strOptString;
        String string7;
        String string8;
        SharedPreferences sharedPreferencesA;
        SharedPreferences sharedPreferencesA2;
        SharedPreferences sharedPreferencesA3;
        SharedPreferences sharedPreferencesA4;
        if (context != null) {
            try {
                SharedPreferences sharedPreferencesA5 = com.umeng.umzid.a.a(context);
                if (sharedPreferencesA5 != null) {
                    string = sharedPreferencesA5.getString("uabc", "");
                } else {
                    string = "";
                }
                if (new JSONObject(string).optLong("ets") > System.currentTimeMillis()) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            string = "";
            if (new JSONObject(string).optLong("ets") > System.currentTimeMillis()) {
                z = false;
            } else {
                z = true;
            }
        }
        String str = null;
        if (!z || this.b) {
            return null;
        }
        this.b = true;
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            try {
                SharedPreferences sharedPreferencesA6 = com.umeng.umzid.a.a(context);
                if (sharedPreferencesA6 != null) {
                    string2 = sharedPreferencesA6.getString("zdata", null);
                } else {
                    string2 = "";
                }
                id = Spy.getID();
                jSONObject2.put(an.aD, id);
                jSONObject2.put("o_z", string2);
                if (context != null || (sharedPreferencesA4 = com.umeng.umzid.a.a(context)) == null) {
                    string3 = "";
                } else {
                    string3 = sharedPreferencesA4.getString("oaid", "");
                    if (d.c(string3)) {
                        string3 = d.a(string3);
                    }
                }
                strC = d.c(context);
                jSONObject2.put("o_o", string3);
                jSONObject2.put("o", strC);
                if (context != null || (sharedPreferencesA3 = com.umeng.umzid.a.a(context)) == null) {
                    string4 = "";
                } else {
                    string4 = sharedPreferencesA3.getString("mac", "");
                    if (d.c(string4)) {
                        string4 = d.a(string4);
                    }
                }
                strB = d.b(context);
                jSONObject2.put(an.A, strB);
                jSONObject2.put("o_mc", string4);
                a(context, jSONObject2);
                jSONObject2.put("aaid", d.a(context));
                if (context != null || (sharedPreferencesA2 = com.umeng.umzid.a.a(context)) == null) {
                    string5 = "";
                } else {
                    string5 = sharedPreferencesA2.getString("uabc", "");
                }
                jSONObject2.put("uabc", string5);
                if (context != null || (sharedPreferencesA = com.umeng.umzid.a.a(context)) == null) {
                    string6 = "";
                } else {
                    string6 = sharedPreferencesA.getString("resetToken", "");
                }
                if (!TextUtils.isEmpty(string6)) {
                    jSONObject2.put("rt", string6);
                }
                strA = com.umeng.umzid.a.a("https://utoken.umeng.com/api/updateZdata/v4", jSONObject2.toString());
                if (!TextUtils.isEmpty(strA)) {
                    jSONObject = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, strB);
                        d.b(context, strC);
                        strOptString = jSONObject.optString("aaid");
                        try {
                            if (!TextUtils.isEmpty(strOptString)) {
                                d.e(context, strOptString);
                            }
                            string7 = jSONObject.getString("uabc");
                            if (!TextUtils.isEmpty(string7)) {
                                d.d(context, string7);
                            }
                            string8 = jSONObject.getString("resetToken");
                            if (!TextUtils.isEmpty(string8)) {
                                d.c(context, string8);
                            }
                        } catch (Throwable th) {
                        }
                        str = strOptString;
                    }
                }
            } catch (Throwable th2) {
            }
        } else {
            string2 = "";
            id = Spy.getID();
            jSONObject2.put(an.aD, id);
            jSONObject2.put("o_z", string2);
            if (context != null) {
                string3 = "";
            } else {
                string3 = "";
            }
            strC = d.c(context);
            jSONObject2.put("o_o", string3);
            jSONObject2.put("o", strC);
            if (context != null) {
                string4 = "";
            } else {
                string4 = "";
            }
            strB = d.b(context);
            jSONObject2.put(an.A, strB);
            jSONObject2.put("o_mc", string4);
            a(context, jSONObject2);
            jSONObject2.put("aaid", d.a(context));
            if (context != null) {
                string5 = "";
            } else {
                string5 = "";
            }
            jSONObject2.put("uabc", string5);
            if (context != null) {
                string6 = "";
            } else {
                string6 = "";
            }
            if (!TextUtils.isEmpty(string6)) {
                jSONObject2.put("rt", string6);
            }
            strA = com.umeng.umzid.a.a("https://utoken.umeng.com/api/updateZdata/v4", jSONObject2.toString());
            if (!TextUtils.isEmpty(strA)) {
                jSONObject = new JSONObject(strA);
                if (Boolean.valueOf(jSONObject.optBoolean("suc")).booleanValue()) {
                    d.f(context, id);
                    d.a(context, strB);
                    d.b(context, strC);
                    strOptString = jSONObject.optString("aaid");
                    if (!TextUtils.isEmpty(strOptString)) {
                        d.e(context, strOptString);
                    }
                    string7 = jSONObject.getString("uabc");
                    if (!TextUtils.isEmpty(string7)) {
                        d.d(context, string7);
                    }
                    string8 = jSONObject.getString("resetToken");
                    if (!TextUtils.isEmpty(string8)) {
                        d.c(context, string8);
                    }
                    str = strOptString;
                }
            }
        }
        this.b = false;
        return str;
    }
}
