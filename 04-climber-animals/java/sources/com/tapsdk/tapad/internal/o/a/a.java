package com.tapsdk.tapad.internal.o.a;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.internal.tracker.experiment.ExpTdsTrackerConfig;
import com.tapsdk.tapad.internal.tracker.experiment.entities.ExpTrackMessage;
import com.tapsdk.tapad.internal.tracker.experiment.entities.b;
import com.tapsdk.tapad.internal.tracker.experiment.g;
import com.tapsdk.tapad.internal.tracker.experiment.j.e;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.v;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static volatile a d;
    final ExpTdsTrackerConfig a;
    final OkHttpClient b;
    final com.tapsdk.tapad.internal.network.a c;

    private a() {
        OkHttpClient okHttpClientBuild = new OkHttpClient().newBuilder().build();
        this.b = okHttpClientBuild;
        this.c = new com.tapsdk.tapad.internal.network.a.g().a("").a(okHttpClientBuild).a();
        TapAdConfig tapAdConfig = TapAdManager.get().tapAdConfig;
        this.a = new ExpTdsTrackerConfig.b().c(g.b).a(tapAdConfig.mMediaId + "_" + tapAdConfig.mMediaVersion + "_1").b(tapAdConfig.mMediaKey).c("commercial.iem.taptap.cn").e("tap-adn-log").d("adn-sdk-eventtracker").f("3.16.3.45").b(31603045).a(TapAdManager.get().appContext);
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    private b.e a(List<ExpTrackMessage> list) {
        b.e.a aVarD = b.e.b6().d(list.get(0).tdsTrackerConfig.g);
        aVarD.b(b(list));
        return aVarD.build();
    }

    private String a(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(TapHttpUtil.HMAC_SHA1);
        mac.init(new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), TapHttpUtil.HMAC_SHA1));
        return new String(Base64.encode(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2), StandardCharsets.UTF_8);
    }

    private List<b.c> a(Map<String, String> map, Map<String, String> map2) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(b.c.T5().a(entry.getKey()).b(entry.getValue()).build());
        }
        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
            String value = "";
            b.c.a aVarA = b.c.T5().a(entry2.getKey() == null ? "" : entry2.getKey());
            if (entry2.getValue() != null) {
                value = entry2.getValue();
            }
            arrayList.add(aVarA.b(value).build());
        }
        return arrayList;
    }

    private Map<String, String> a(ExpTdsTrackerConfig expTdsTrackerConfig) {
        HashMap map = new HashMap();
        map.put("sdk_version", String.valueOf(expTdsTrackerConfig.i));
        map.put(com.tapsdk.tapad.internal.tracker.experiment.a.b, String.valueOf(expTdsTrackerConfig.j));
        map.put("device_id", GUIDHelper.INSTANCE.getUID());
        map.put("t_log_id", UUID.randomUUID().toString());
        map.put("version", com.tapsdk.tapad.internal.tracker.experiment.b.a);
        map.put("dv", com.tapsdk.tapad.internal.tracker.experiment.j.b.d());
        map.put("md", com.tapsdk.tapad.internal.tracker.experiment.j.b.e());
        map.put("cpu", com.tapsdk.tapad.internal.tracker.experiment.j.b.a());
        map.put(com.tapsdk.tapad.internal.tracker.experiment.a.i, expTdsTrackerConfig.p);
        map.put("app_version", expTdsTrackerConfig.n);
        map.put("ram", expTdsTrackerConfig.q);
        map.put("rom", expTdsTrackerConfig.r);
        map.put("network_type", expTdsTrackerConfig.s);
        map.put("mobile_type", expTdsTrackerConfig.t);
        map.put("os", com.tapsdk.tapad.internal.tracker.experiment.j.b.g());
        map.put("sv", com.tapsdk.tapad.internal.tracker.experiment.j.b.f());
        map.put("brand", Build.BRAND);
        map.put("manufacturer", Build.BRAND);
        return map;
    }

    private List<b.C0635b> b(List<ExpTrackMessage> list) {
        ArrayList arrayList = new ArrayList();
        for (ExpTrackMessage expTrackMessage : list) {
            Log.d("trackerData", "contents:" + expTrackMessage.logContentsMap + "\n common params" + expTrackMessage.logCommonParams + "\n");
            arrayList.add(b.C0635b.V5().p0((int) expTrackMessage.createTime).a(a(expTrackMessage.logContentsMap, expTrackMessage.logCommonParams)).build());
        }
        return arrayList;
    }

    private byte[] c(List<ExpTrackMessage> list) {
        return a(list).toByteArray();
    }

    public synchronized boolean a(HashMap<String, String> map) {
        boolean z;
        ExpTrackMessage expTrackMessage = new ExpTrackMessage(this.a, map, new Date().getTime() / 1000, a(this.a));
        ArrayList arrayList = new ArrayList();
        arrayList.add(expTrackMessage);
        z = false;
        try {
            byte[] bArrC = c(arrayList);
            byte[] bArrA = e.a(bArrC);
            HashMap map2 = new HashMap();
            String upperCase = com.tapsdk.tapad.internal.tracker.experiment.j.a.a(bArrA).toUpperCase();
            String strValueOf = String.valueOf(new Date().getTime() / 1000);
            String str = String.format("LOG %s:%s", this.a.d, a(String.format(Locale.getDefault(), "POST\n%s\napplication/x-protobuf\nx-log-apiversion:0.6.0\nx-log-bodyrawsize:%d\nx-log-compresstype:lz4\nx-log-signaturemethod:hmac-sha1\nx-log-timestamp:%s\n/putrecords/%s/%s", upperCase, Integer.valueOf(bArrC.length), strValueOf, this.a.a, this.a.c), this.a.e));
            map2.put("x-log-timestamp", strValueOf);
            map2.put("Content-MD5", upperCase);
            map2.put("Content-Length", String.valueOf(bArrA.length));
            map2.put("x-log-bodyrawsize", String.valueOf(bArrC.length));
            map2.put("Authorization", str);
            map2.put("Content-Type", "application/x-protobuf");
            map2.put("x-log-apiversion", "0.6.0");
            map2.put("x-log-compresstype", "lz4");
            map2.put("x-log-signaturemethod", "hmac-sha1");
            map2.put("Host", this.a.b);
            map2.put("accept", "*/*");
            map2.put("Accept-Encoding", "identity");
            map2.put("is_sdk_debug", "1");
            String strB = v.a().b(this.a.b);
            if (!TextUtils.isEmpty(strB)) {
                map2.put("user-agent", strB);
            }
            int iA = this.c.a("https://" + this.a.b + "/putrecords/" + this.a.a + "/" + this.a.c, (Map<String, String>) null, map2, bArrA);
            if (iA >= 200 && iA <= 300) {
                z = true;
            }
        } catch (Exception e) {
            TapADLogger.w("log cl error:" + e.getMessage());
            return false;
        }
        return z;
    }
}
