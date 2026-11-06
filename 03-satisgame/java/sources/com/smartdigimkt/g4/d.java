package com.smartdigimkt.g4;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public com.smartdigimkt.h3.b a;
    public String b = "";

    public static byte[] a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (Throwable unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public JSONObject b() {
        if (l()) {
            Context contextD = SDKContext.getInstance().d();
            if (com.smartdigimkt.r4.h.a("mcc") || com.smartdigimkt.r4.h.a("mnc")) {
                if (contextD == null) {
                    try {
                        contextD = SDKContext.getInstance().d();
                    } catch (Throwable unused) {
                    }
                }
                com.smartdigimkt.y2.b.b(contextD);
            }
        }
        return com.smartdigimkt.a4.a.a(c(), this.a, this.b);
    }

    public int c() {
        return 0;
    }

    public List d() {
        return null;
    }

    public Map e() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
        return map;
    }

    public HttpReqEntity f() {
        return null;
    }

    public JSONObject g() {
        return com.smartdigimkt.a4.a.a(c(), d());
    }

    public byte[] h() throws JSONException {
        String strI = i();
        if (TextUtils.isEmpty(strI)) {
            return new byte[0];
        }
        try {
            return strI.getBytes("utf-8");
        } catch (Throwable unused) {
            return strI.getBytes();
        }
    }

    public String i() throws JSONException {
        try {
            HashMap map = new HashMap();
            String strB = com.smartdigimkt.r4.e.b(b().toString());
            String strB2 = com.smartdigimkt.r4.e.b(g().toString());
            map.put(com.anythink.core.common.l.f.P, "1.0");
            map.put(com.anythink.core.common.l.f.W, strB);
            map.put(com.anythink.core.common.l.f.X, strB2);
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
            map.put(com.anythink.core.common.l.f.Y, com.smartdigimkt.r4.i.a(a() + sb.toString()));
            Set<String> setKeySet = map.keySet();
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str2 : setKeySet) {
                    jSONObject.put(str2, String.valueOf(map.get(str2)));
                }
                return jSONObject.toString();
            } catch (OutOfMemoryError unused) {
                System.gc();
                return "";
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public abstract int j();

    public abstract String k();

    public boolean l() {
        return this instanceof c;
    }

    public String a() {
        return SDKContext.getInstance().b();
    }
}
