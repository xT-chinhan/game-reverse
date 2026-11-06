package com.mcto.sspsdk.internal;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class t1 {
    public static volatile t1 h;
    public long a;
    public u1 b;
    public String[] c;
    public int d = 0;
    public final HashMap e;
    public final AtomicBoolean f;
    public final s1 g;

    public t1() {
        Looper looper;
        this.a = 0L;
        HashMap map = new HashMap();
        this.e = map;
        this.f = new AtomicBoolean(false);
        synchronized (s9.class) {
            if (s9.c == null) {
                HandlerThread handlerThread = new HandlerThread("ssp_temp");
                s9.c = handlerThread;
                handlerThread.start();
            }
            looper = s9.c.getLooper();
        }
        this.g = new s1(this, looper);
        try {
            String strA = nh.a(jd.a).a("dinl");
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            JSONArray jSONArray = new JSONObject(strA).getJSONArray("json");
            map.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strOptString = jSONObject.optString("pn");
                this.e.put(strOptString, new xa(strOptString, jSONObject.optString("an"), jSONObject.optString("ints"), jSONObject.optString("upts"), jSONObject.optString("avn")));
            }
            this.a = Long.parseLong(nh.a(jd.a).a("dsts"));
        } catch (Exception e) {
        }
    }

    public static t1 a() {
        if (h == null) {
            synchronized (t1.class) {
                if (h == null) {
                    h = new t1();
                }
            }
        }
        return h;
    }

    public final void a(HashMap map) {
        HashMap map2 = new HashMap();
        for (Map.Entry entry : this.e.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                xa xaVar = (xa) entry.getValue();
                xaVar.g = "0";
                xaVar.e = "" + System.currentTimeMillis();
                map2.put(entry.getKey(), xaVar);
            }
        }
        this.e.clear();
        this.e.putAll(map);
        kl.a(this.e, map2);
        kl.a(this.e);
    }
}
