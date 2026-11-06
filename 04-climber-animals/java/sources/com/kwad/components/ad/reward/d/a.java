package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean b(long j, long j2) {
        return j > 0 && j2 > 0 && j / 2460601000L == j2 / 2460601000L;
    }

    private static void c(Context context, int i) {
        int iCX = ag.cX(context);
        if (iCX % i == 0) {
            ag.m(context, 1);
        } else {
            ag.m(context, iCX + 1);
        }
    }

    private static boolean d(Context context, int i) {
        return i != 0 && ag.cX(context) % i == 0;
    }

    public static void S(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String strCY = ag.cY(context);
        int i = 0;
        if (!TextUtils.isEmpty(strCY)) {
            try {
                bVar.parseJson(new JSONObject(strCY));
                if (b(bVar.jC, jCurrentTimeMillis)) {
                    i = bVar.ur;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        bVar.jC = jCurrentTimeMillis;
        bVar.ur = i + 1;
        ag.ad(context, bVar.toJson().toString());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    private static boolean e(Context context, int i) {
        int i2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String strCY = ag.cY(context);
        if (TextUtils.isEmpty(strCY)) {
            i2 = 0;
        } else {
            try {
                bVar.parseJson(new JSONObject(strCY));
                if (b(bVar.jC, jCurrentTimeMillis)) {
                    i2 = bVar.ur;
                } else {
                    i2 = 0;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return i2 < i;
    }

    public static boolean b(Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.aG(adInfo)) {
            return false;
        }
        int iMax = Math.max(com.kwad.sdk.core.response.b.a.aH(adInfo) + 1, 1);
        boolean zD = d(context, iMax);
        c(context, iMax);
        return zD && e(context, com.kwad.sdk.core.response.b.a.aI(adInfo));
    }
}
