package com.anythink.china.d;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATUserDeviceInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.u;
import com.anythink.core.common.g.c;
import com.anythink.core.common.i;
import com.anythink.core.common.l.c.d;
import com.anythink.core.common.l.c.g;
import com.anythink.core.common.l.f;
import com.anythink.core.common.l.s;
import com.anythink.core.common.u.j;
import com.anythink.core.common.u.l;
import com.anythink.core.common.u.n;
import com.anythink.core.common.u.o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.anythink.core.common.l.b {
    private static final String c = "a";
    long a;
    long b;
    private final String l;
    private final String m;
    private final String n;
    private final Context o;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean m() {
        return true;
    }

    public a(Context context, String str, String str2, String str3) {
        this.l = str;
        this.m = str2;
        this.o = context;
        this.n = str3;
    }

    @Override // com.anythink.core.common.l.b
    public final void a(int i, s sVar) {
        this.a = System.currentTimeMillis();
        this.b = SystemClock.elapsedRealtime();
        super.a(i, sVar);
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        i.a();
        return c.a().a(i.h() ? com.anythink.china.b.a.C0008a.d : com.anythink.china.b.a.C0008a.c, "");
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Accept-Encoding", "gzip");
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        try {
            return k().getBytes("utf-8");
        } catch (Exception unused) {
            return k().getBytes();
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return this.l;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.o;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return this.m;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", this.l);
            jSONObject.put("system", 1);
            jSONObject.put("platform", 1);
            jSONObject.put("package_name", l.j(this.o));
            jSONObject.put("sdk_ver", o.a());
            jSONObject.put("upid", u.a(this.o).b() ? com.anythink.core.common.d.s.b().C() : "");
            if (!TextUtils.isEmpty(com.anythink.core.common.d.s.b().n())) {
                jSONObject.put("channel", com.anythink.core.common.d.s.b().n());
            }
            if (!TextUtils.isEmpty(com.anythink.core.common.d.s.b().o())) {
                jSONObject.put("sub_channel", com.anythink.core.common.d.s.b().o());
            }
            jSONObject.put(f.K, com.anythink.core.common.d.s.b().h());
            jSONObject.put(f.L, com.anythink.core.common.d.s.b().i());
            String strD = com.anythink.core.common.d.s.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObject.put("sy_id", strD);
            }
            String strE = com.anythink.core.common.d.s.b().E();
            if (!TextUtils.isEmpty(strE)) {
                jSONObject.put("bk_id", strE);
            } else {
                com.anythink.core.common.d.s.b().k(com.anythink.core.common.d.s.b().C());
                jSONObject.put("bk_id", com.anythink.core.common.d.s.b().C());
            }
            String strL = l.l();
            if (!TextUtils.isEmpty(strL)) {
                jSONObject.put(f.af, Integer.parseInt(strL));
            }
            jSONObject.put(f.bB, com.anythink.core.common.d.s.b().F());
            if (ATSDK.isCnSDK()) {
                jSONObject.put("is_cn_sdk", "1");
            } else {
                jSONObject.put("is_cn_sdk", "0");
            }
            try {
                ATUserDeviceInfo aTUserDeviceInfoQ = com.anythink.core.common.d.s.b().Q();
                if (aTUserDeviceInfoQ != null) {
                    String devGaid = aTUserDeviceInfoQ.getDevGaid();
                    String devImei = aTUserDeviceInfoQ.getDevImei();
                    String devOaid = aTUserDeviceInfoQ.getDevOaid();
                    JSONObject jSONObject2 = new JSONObject();
                    if (!TextUtils.isEmpty(devGaid)) {
                        jSONObject2.put("set_gaid", devGaid);
                    }
                    if (!TextUtils.isEmpty(devImei)) {
                        jSONObject2.put("set_imei", devImei);
                    }
                    if (!TextUtils.isEmpty(devOaid)) {
                        jSONObject2.put("set_oaid", devOaid);
                    }
                    jSONObject.put(f.H, jSONObject2);
                    String devUID2Token = aTUserDeviceInfoQ.getDevUID2Token();
                    if (!TextUtils.isEmpty(devUID2Token)) {
                        jSONObject.put(f.bA, devUID2Token);
                    }
                }
            } catch (Exception unused) {
            }
            jSONObject.put("app_vn", l.h(this.o));
            jSONObject.put("app_vc", l.g(this.o));
            jSONObject.put(f.bQ, this.n);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    private static void a(JSONObject jSONObject) {
        try {
            ATUserDeviceInfo aTUserDeviceInfoQ = com.anythink.core.common.d.s.b().Q();
            if (aTUserDeviceInfoQ != null) {
                String devGaid = aTUserDeviceInfoQ.getDevGaid();
                String devImei = aTUserDeviceInfoQ.getDevImei();
                String devOaid = aTUserDeviceInfoQ.getDevOaid();
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(devGaid)) {
                    jSONObject2.put("set_gaid", devGaid);
                }
                if (!TextUtils.isEmpty(devImei)) {
                    jSONObject2.put("set_imei", devImei);
                }
                if (!TextUtils.isEmpty(devOaid)) {
                    jSONObject2.put("set_oaid", devOaid);
                }
                jSONObject.put(f.H, jSONObject2);
                String devUID2Token = aTUserDeviceInfoQ.getDevUID2Token();
                if (TextUtils.isEmpty(devUID2Token)) {
                    return;
                }
                jSONObject.put(f.bA, devUID2Token);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        try {
            HashMap map = new HashMap();
            String strA = j.a(i().toString());
            map.put(f.P, q());
            map.put(f.Z, strA);
            ArrayList<String> arrayList = new ArrayList(map.size());
            arrayList.addAll(map.keySet());
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(str);
                sb.append("=");
                sb.append(map.get(str));
            }
            try {
                map.put(f.Y, URLEncoder.encode(n.c(this.m + sb.toString()), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return new JSONObject(map).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        com.anythink.core.common.t.f.a("user", (String) null, this.a, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.b, (ATAdRequest) null);
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        com.anythink.core.common.t.f.a("user", adError.getPlatformCode(), adError.getPlatformMSG(), b(), "", "", "", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.l.b
    protected final d o() {
        return d.a(g.m, this.l);
    }
}
