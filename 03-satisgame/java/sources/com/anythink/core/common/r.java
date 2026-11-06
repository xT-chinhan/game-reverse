package com.anythink.core.common;

import android.content.Context;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r {
    public static final int a = 35;
    public static final String b = "isDefaultOffer";
    private static volatile r g;
    Method c;
    Method d;
    Method e;
    Method f;

    private r() {
        try {
            Class<?> cls = Class.forName("com.anythink.network.myoffer.MyOfferAPI");
            this.c = cls.getDeclaredMethod("preloadTopOnOffer", Context.class, String.class, JSONObject.class);
            this.d = cls.getDeclaredMethod("getOutOfCapOfferIds", Context.class);
            this.e = cls.getDeclaredMethod("getDefaultOfferId", Context.class, String.class);
            this.f = cls.getDeclaredMethod("checkOffersOutOfCap", Context.class, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static r a() {
        if (g == null) {
            synchronized (r.class) {
                if (g == null) {
                    g = new r();
                }
            }
        }
        return g;
    }

    public final void a(Context context, String str, JSONObject jSONObject) {
        try {
            Method method = this.c;
            if (method != null) {
                method.invoke(null, context, str, jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final JSONArray a(Context context) {
        try {
            Method method = this.d;
            if (method != null) {
                return new JSONArray(method.invoke(null, context).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public final String a(Context context, String str) {
        try {
            Method method = this.e;
            return method != null ? method.invoke(null, context, str).toString() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final boolean b(Context context, String str) {
        try {
            Method method = this.f;
            if (method != null) {
                return ((Boolean) method.invoke(null, context, str)).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
