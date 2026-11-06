package com.tapsdk.tapad.internal.j;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.TapAdReq;
import com.tapsdk.tapad.model.entities.TapAdResp;
import java.io.IOException;
import java.io.InputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static String c;
    private static String d;
    private static int f;
    private static JSONObject a = new JSONObject();
    private static int b = 0;
    private static int e = 0;

    public static int a() {
        return e;
    }

    public static void a(int i) {
    }

    public static void a(TapAdReq.d dVar) {
        c = dVar.toString();
    }

    public static void a(TapAdResp.h hVar) {
        d = hVar.toString();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    public static boolean a(Context context, int i, String str) throws JSONException, IOException {
        String str2;
        String str3;
        AssetManager assets = context.getAssets();
        if ("TapTap沙盒&云玩_1".equals(str)) {
            str2 = "ads_taptap.json";
        } else {
            str2 = "TapTap沙盒&云玩_2".equals(str) ? "ads_taptap_2.json" : "ads.json";
        }
        InputStream inputStreamOpen = assets.open(str2);
        BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(inputStreamOpen));
        String utf8 = bufferedSourceBuffer.readUtf8();
        bufferedSourceBuffer.close();
        JSONObject jSONObject = new JSONObject(utf8);
        b = i;
        if (i == 0) {
            str3 = "tap";
        } else if (i == 1) {
            str3 = TapAdConfig.a.c;
        } else if (i == 2) {
            str3 = TapAdConfig.a.a;
        } else if (i == 3) {
            str3 = TapAdConfig.a.b;
        } else if (i == 4) {
            str3 = "soul";
        } else {
            str3 = "tap";
        }
        a = jSONObject.getJSONObject(str3);
        if (a.length() < 1) {
            b = 0;
            throw new IOException("缺少广告位信息");
        }
        Log.e("ads", i + "");
        Log.e("ads", a.toString());
        if (inputStreamOpen != null) {
            inputStreamOpen.close();
        }
        return true;
    }

    public static Long b() {
        return 0L;
    }

    public static void b(int i) {
        e = i;
    }

    public static int c() {
        return b;
    }

    public static String d() {
        TapADLogger.e("" + c);
        return c;
    }

    public static String e() {
        return d;
    }

    public static JSONObject f() {
        return a;
    }
}
