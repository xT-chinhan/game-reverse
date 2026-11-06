package com.mcto.sspsdk.internal;

import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bumptech.glide.load.Key;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gj {
    public static final AtomicInteger a = new AtomicInteger(0);

    public static String a(String str) {
        return d(UUID.randomUUID().toString() + SystemClock.elapsedRealtime() + y4.r.b() + str);
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(), 2);
    }

    public static String c(String str) {
        return (TextUtils.isEmpty(str) || !rd.c || str == null || !str.regionMatches(true, 0, "http://", 0, 7)) ? str : "https://" + str.substring(7);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bArrDigest = new byte[0];
        try {
            bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(Key.STRING_CHARSET_NAME));
        } catch (Exception e) {
            r9.a("ssp_sdk", "md5(): Exception: ", e);
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArrDigest.length << 1];
        int i = 0;
        for (byte b : bArrDigest) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b & 240) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b & com.umeng.analytics.pro.cc.m];
        }
        return new String(cArr2);
    }

    public static String e(String str) {
        if (lj.b(str)) {
            return "";
        }
        try {
            return URLDecoder.decode(str, Key.STRING_CHARSET_NAME);
        } catch (Exception e) {
            r9.a("ssp_sdk", "URLEncode: ", e);
            return "";
        }
    }

    public static String f(String str) {
        if (lj.b(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, Key.STRING_CHARSET_NAME);
        } catch (Exception e) {
            r9.a("ssp_sdk", "URLEncode: ", e);
            return "";
        }
    }

    public static String a() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date());
        } catch (Exception e) {
            r9.a("ssp_sdk", "getCurrentTime(): ", e);
            return "";
        }
    }

    public static String b(int i, String str, String str2) {
        try {
            byte[] bytes = str.getBytes();
            byte[] bytes2 = str2.getBytes();
            int iMin = Math.min(i, bytes2.length);
            int length = bytes2.length - iMin;
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bytes[i2] = (byte) (bytes[i2] ^ bytes2[(i2 % iMin) + length]);
            }
            return Base64.encodeToString(bytes, 2);
        } catch (Exception e) {
            r9.a("ssp_utils", "encrypt: ", e);
            return "";
        }
    }

    public static String a(String str, boolean z) {
        if (z || !str.contains(".mp4") || str.contains("pv=0.2")) {
            return str;
        }
        if (str.contains("?")) {
            return str.concat("&pv=0.2");
        }
        return str.concat("?pv=0.2");
    }

    public static boolean b(int i) {
        if (i == 100) {
            return true;
        }
        return i != 0 && new SecureRandom().nextInt(100) <= i;
    }

    public static int a(Object obj, int i) {
        if (obj != null) {
            try {
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
                return Integer.parseInt(String.valueOf(obj));
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static long a(Object obj, long j) {
        if (obj != null) {
            try {
                if (obj instanceof Long) {
                    return ((Long) obj).longValue();
                }
                return Long.parseLong(String.valueOf(obj));
            } catch (Exception e) {
            }
        }
        return j;
    }

    public static HashMap a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String strValueOf = String.valueOf(itKeys.next());
                Object objOpt = jSONObject.opt(strValueOf);
                if (objOpt != null) {
                    map.put(strValueOf, objOpt);
                }
            }
        }
        return map;
    }

    public static void a(JSONStringer jSONStringer, String str, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            jSONStringer.key(str).value(obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static int[] a(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = jSONArray.optInt(i);
        }
        return iArr;
    }

    public static String a(Map map, String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String strValueOf = String.valueOf(value);
                if (!lj.b(strValueOf)) {
                    if (z) {
                        strValueOf = f(strValueOf);
                    }
                    if (sb.length() > 0) {
                        sb.append(str);
                    }
                    sb.append((String) entry.getKey()).append(str2).append(strValueOf);
                }
            }
        }
        return sb.toString();
    }

    public static String a(int i, String str, String str2) {
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            byte[] bytes = str2.getBytes();
            int iMin = Math.min(i, bytes.length);
            int length = bytes.length - iMin;
            for (int i2 = 0; i2 < bArrDecode.length; i2++) {
                bArrDecode[i2] = (byte) (bArrDecode[i2] ^ bytes[(i2 % iMin) + length]);
            }
            return new String(bArrDecode);
        } catch (Exception e) {
            r9.a("ssp_utils", "encrypt: ", e);
            return "";
        }
    }

    public static String a(View view) {
        if (view == null) {
            return "";
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        Rect rect = new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
        return rect.left + "_" + rect.top + "_" + rect.right + "_" + rect.bottom;
    }

    public static HashMap a(b4 b4Var, View view) {
        HashMap map = new HashMap();
        v5 v5Var = v5.KEY_CLICK_AREA;
        z3 z3Var = b4Var.a;
        if (z3Var == null) {
            z3Var = z3.GRAPHIC;
        }
        map.put(v5Var, z3Var);
        if (view != null) {
            map.put(v5.KEY_VIEW_COORDINATE, a(view));
            map.put(v5.KEY_CONTAINER_WIDTH, Integer.valueOf(hk.b(jd.a, view.getWidth())));
            map.put(v5.KEY_CONTAINER_HEIGHT, Integer.valueOf(hk.b(jd.a, view.getHeight())));
        }
        float f = b4Var.e;
        if (f >= 0.0f && b4Var.g >= 0.0f) {
            map.put(v5.KEY_TOUCH_START_X, Integer.valueOf(hk.b(jd.a, f)));
            map.put(v5.KEY_TOUCH_START_Y, Integer.valueOf(hk.b(jd.a, b4Var.f)));
            map.put(v5.KEY_TOUCH_END_X, Integer.valueOf(hk.b(jd.a, b4Var.g)));
            map.put(v5.KEY_TOUCH_END_Y, Integer.valueOf(hk.b(jd.a, b4Var.h)));
        }
        int i = b4Var.j;
        if (i != 0) {
            map.put(v5.KEY_AD_DOWNLOAD_STATE, Integer.valueOf(i));
        }
        map.put(v5.KEY_CLICK_COORDINATE, b4Var.c);
        map.put(v5.KEY_CLICK_VIEW_COORDINATE, b4Var.d);
        b4Var.toString();
        return map;
    }

    public static String a(String str, int i, int i2) {
        return "adnType:" + i + ";errCode:" + i2 + ";errMsg:" + f(str);
    }

    public static String a(int i) {
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i < 100000000) {
            return String.format(Locale.CHINA, "%.1f万", Double.valueOf(((double) i) / 10000.0d));
        }
        return String.format(Locale.CHINA, "%.1f亿", Double.valueOf(((double) i) / 1.0E8d));
    }

    public static boolean a(View view, float f, float f2, float f3) {
        float fMax = Math.max(0.0f, Math.min(f3, 100.0f)) / 100.0f;
        float width = view.getWidth();
        float f4 = width / 2.0f;
        float height = view.getHeight();
        float f5 = height / 2.0f;
        float f6 = (width * fMax) / 2.0f;
        float f7 = (height * fMax) / 2.0f;
        return f >= f4 - f6 && f <= f4 + f6 && f2 >= f5 - f7 && f2 <= f5 + f7;
    }
}
