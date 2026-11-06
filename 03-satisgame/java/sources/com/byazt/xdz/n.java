package com.byazt.xdz;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.hls.x;
import com.byazt.vf.cp;
import com.byazt.vf.k;
import com.byazt.vf.oa;
import com.byazt.vf.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.compilance.bean.IdentityVerifyStateKt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, 19})
public class n {
    public static volatile String d;
    public com.byazt.vf.s fs;
    public cp l;
    public com.byazt.vr.l q;
    public com.byazt.vr.qg s;
    public wm tj;
    public oa w;
    public com.byazt.vf.n x;
    public static final byte[] rv = new byte[0];
    public static final Map<String, AtomicInteger> oa = new ConcurrentHashMap();
    public static final Map<String, Long> sz = new ConcurrentHashMap();
    public static final Map<String, Long> k = new ConcurrentHashMap();
    public static final Map<String, Integer> cy = new ConcurrentHashMap();
    public static final Map<String, Integer> hd = new ConcurrentHashMap();
    public final String n = "x-pglcypher";
    public boolean qg = com.byazt.hls.q.n();
    public k cp = (k) com.byazt.qp.q.n("encrypt_service");

    public static String qg(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i != 480) {
            return i != 640 ? "mdpi" : "xxxhdpi";
        }
        return "xxhdpi";
    }

    public com.byazt.zad.n n(List<com.byazt.vr.n> list) {
        return null;
    }

    public String n(int i) {
        return i >= 4 ? "application/octet-stream" : "application/octet-stream;tt-data=a";
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, 226})
    protected static final class qg {
        public final String n;
        public final String qg;
        public final int s;

        public qg(String str, String str2, int i) {
            this.n = str;
            this.qg = str2;
            this.s = i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.xdz.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    protected static final class C0391n {
        public final qg fs;
        public final byte[] l;
        public final boolean n;
        public final boolean q;
        public final int qg;
        public final String s;
        public final String w;
        public final Throwable x;

        public C0391n(com.byazt.qk.s sVar, qg qgVar) {
            if (sVar == null) {
                this.n = false;
                this.qg = 0;
                this.s = null;
                this.q = false;
                this.l = null;
                this.w = "error";
                this.x = null;
            } else {
                this.n = sVar.n();
                this.qg = sVar.qg();
                this.s = sVar.s();
                this.q = sVar.q();
                this.l = sVar.l();
                this.w = sVar.w();
                this.x = sVar.x();
            }
            this.fs = qgVar;
        }

        public C0391n(boolean z, int i, String str, boolean z2, byte[] bArr, String str2, Throwable th, qg qgVar) {
            this.n = z;
            this.qg = i;
            this.s = str;
            this.q = z2;
            this.l = bArr;
            this.w = str2;
            this.x = th;
            this.fs = qgVar;
        }
    }

    public n(com.byazt.vf.n nVar, com.byazt.vr.qg qgVar, cp cpVar, oa oaVar, com.byazt.vr.l lVar) {
        this.x = nVar;
        this.s = qgVar;
        this.l = cpVar;
        this.q = lVar;
        this.w = oaVar;
        this.tj = (wm) com.byazt.qp.q.n("mediation_settings", nVar);
        this.fs = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog", this.x);
    }

    public boolean n() {
        k kVar = (k) com.byazt.qp.q.n("encrypt_service");
        wm wmVar = this.tj;
        return (wmVar == null || wmVar.qg() || kVar == null || !kVar.qg()) ? false : true;
    }

    public int qg() {
        return ((cp) com.byazt.qp.q.n("csj_settings", this.x)).n() ? 4 : 3;
    }

    public static String s() {
        if (TextUtils.isEmpty(d)) {
            synchronized (n.class) {
                if (TextUtils.isEmpty(d)) {
                    String strQg = ((oa) com.byazt.qp.q.n("device_info_new")).qg((Boolean) null);
                    if (!TextUtils.isEmpty(strQg)) {
                        d = com.byazt.hls.s.n(strQg);
                    }
                }
            }
        }
        return d;
    }

    public boolean n(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optInt("code") == 20000 || "success".equals(jSONObject.optString("message"));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public boolean qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    public String n(Context context) {
        try {
            if (s(context)) {
                return "tv";
            }
            return qg(context) ? "android_pad" : "android";
        } catch (Throwable unused) {
            return "android";
        }
    }

    public static boolean qg(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean s(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject n(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                k kVar = (k) com.byazt.qp.q.n("encrypt_service");
                String strS = kVar != null ? kVar.s(str) : null;
                if (!TextUtils.isEmpty(strS)) {
                    jSONObject.put("message", strS);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            x.n(th.getMessage());
        }
        return jSONObject;
    }

    public byte[] s(JSONObject jSONObject) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(jSONObject.toString().getBytes());
                    gZIPOutputStream2.close();
                } catch (Exception unused) {
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public boolean n(String str, com.byazt.jeb.n nVar) {
        if (TextUtils.isEmpty(str) || nVar == null || nVar.n || !n(nVar) || w(str)) {
            return false;
        }
        return rv(str);
    }

    public boolean n(com.byazt.jeb.n nVar) {
        if (nVar == null || nVar.n) {
            return false;
        }
        Throwable th = nVar.w;
        return (th instanceof UnknownHostException) || (th instanceof SocketTimeoutException) || (th instanceof NullPointerException);
    }

    private boolean w(String str) {
        Map<String, Long> map = k;
        Long l = map.get(str);
        if (l == null) {
            return false;
        }
        if (System.currentTimeMillis() < l.longValue()) {
            return true;
        }
        map.remove(str);
        return false;
    }

    public void qg(String str) {
        k.put(str, Long.valueOf(System.currentTimeMillis() + 300000));
        x(str);
        AtomicInteger atomicInteger = oa.get(str);
        if (atomicInteger != null) {
            atomicInteger.set(0);
        }
        sz.remove(str);
    }

    public void s(String str) {
        Map<String, AtomicInteger> map = oa;
        AtomicInteger atomicInteger = map.get(str);
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            AtomicInteger atomicInteger2 = (AtomicInteger) ((ConcurrentHashMap) map).putIfAbsent(str, atomicInteger);
            if (atomicInteger2 != null) {
                atomicInteger = atomicInteger2;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, Long> map2 = sz;
        Long l = map2.get(str);
        long jQ = q();
        if (l != null && jCurrentTimeMillis - l.longValue() > jQ) {
            atomicInteger.set(0);
        }
        int iIncrementAndGet = atomicInteger.incrementAndGet();
        map2.put(str, Long.valueOf(jCurrentTimeMillis));
        if (iIncrementAndGet == 1) {
            x(str);
        }
    }

    private void x(String str) {
        com.byazt.vr.qg qgVar = this.s;
        if (qgVar != null && qgVar.n() != null) {
            cy.put(str, Integer.valueOf(this.s.n().fs()));
        }
        hd.put(str, Integer.valueOf(com.byazt.asa.l.tj()));
    }

    private int fs(String str) {
        AtomicInteger atomicInteger = oa.get(str);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    private boolean rv(String str) {
        com.byazt.vr.qg qgVar;
        if (!tj(str) || fs(str) < l() || (qgVar = this.s) == null || qgVar.n() == null) {
            return false;
        }
        com.byazt.vr.s sVarN = this.s.n();
        if (!sVarN.x()) {
            return false;
        }
        Integer num = cy.get(str);
        if (sVarN.fs() - (num == null ? 0 : num.intValue()) < 5) {
            return false;
        }
        Integer num2 = hd.get(str);
        return com.byazt.asa.l.tj() - (num2 == null ? 0 : num2.intValue()) >= 5;
    }

    private boolean tj(String str) {
        return (this.l == null || TextUtils.isEmpty(str) || q(str).isEmpty()) ? false : true;
    }

    private int l() {
        int iCd;
        cp cpVar = this.l;
        if (cpVar == null || (iCd = cpVar.cd()) <= 0) {
            return 10;
        }
        return iCd;
    }

    public List<qg> q(String str) {
        if (this.l == null || TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        JSONArray jSONArrayN = this.l.n(str);
        if (jSONArrayN == null || jSONArrayN.length() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayN.length(); i++) {
            Object objOpt = jSONArrayN.opt(i);
            if (objOpt instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) objOpt;
                String strOptString = jSONObject.optString("ip");
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(new qg(strOptString, jSONObject.optString("family", cp(strOptString)), jSONObject.optInt("priority", i + 1)));
                }
            } else {
                String strOptString2 = jSONArrayN.optString(i);
                if (!TextUtils.isEmpty(strOptString2)) {
                    arrayList.add(new qg(strOptString2, cp(strOptString2), i + 1));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        return qg(arrayList);
    }

    public C0391n n(String str, byte[] bArr, Map<String, String> map, String str2, qg qgVar) {
        com.byazt.qk.l lVar;
        if (TextUtils.isEmpty(str) || bArr == null || qgVar == null || TextUtils.isEmpty(qgVar.n) || TextUtils.isEmpty(l(str)) || (lVar = (com.byazt.qk.l) com.byazt.qp.q.n("direct_connect")) == null) {
            return null;
        }
        com.byazt.qk.s sVarN = lVar.n(str, bArr, n(map), str2, qgVar.n, 10000);
        if (sVarN == null) {
            return new C0391n(false, 0, null, false, null, "error", new IllegalStateException("direct_connect_service_null"), qgVar);
        }
        return new C0391n(sVarN, qgVar);
    }

    public String n(Throwable th, String str) {
        if (th == null) {
            return str == null ? "" : str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getSimpleName());
        if (!TextUtils.isEmpty(th.getMessage())) {
            sb.append(":").append(th.getMessage());
        }
        return sb.toString();
    }

    public long q() {
        cp cpVar = this.l;
        if (cpVar == null) {
            return 600000L;
        }
        long jHd = cpVar.hd();
        if (jHd > 0) {
            return jHd;
        }
        return 600000L;
    }

    public String n(qg qgVar, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(qgVar.n).append(" ").append(qgVar.qg);
        if (!TextUtils.isEmpty(str)) {
            sb.append(" ").append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" ").append(str2);
        }
        return sb.toString();
    }

    public String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URI.create(str).getHost();
        } catch (Throwable unused) {
            return "";
        }
    }

    private List<qg> qg(List<qg> list) {
        oa oaVar = this.w;
        boolean z = oaVar == null || oaVar.j();
        ArrayList arrayList = new ArrayList();
        for (qg qgVar : list) {
            if (qgVar != null && !TextUtils.isEmpty(qgVar.n) && TextUtils.equals("ipv4", qgVar.qg) && z) {
                arrayList.add(qgVar);
            }
        }
        Collections.sort(arrayList, new Comparator<qg>() { // from class: com.byazt.xdz.n.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(qg qgVar2, qg qgVar3) {
                return qgVar2.s - qgVar3.s;
            }
        });
        return arrayList;
    }

    private String cp(String str) {
        return (!TextUtils.isEmpty(str) && str.contains(":")) ? "ipv6" : "ipv4";
    }

    private Map<String, String> n(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        if (this.w != null && !map2.containsKey(RequestParamsUtils.USER_AGENT_KEY)) {
            map2.put(RequestParamsUtils.USER_AGENT_KEY, this.w.qg(false));
        }
        return map2;
    }

    public void n(String str, Throwable th, List<com.byazt.vr.n> list, String str2, boolean z) {
        com.byazt.vr.qg qgVar = this.s;
        if (qgVar == null || qgVar.n() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", "exception");
            jSONObject.put("scene", "applog_failed");
            jSONObject2.put("bucket", str);
            if (th != null) {
                jSONObject2.put("error_msg", n(th, th.getMessage()));
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("direct_ip", str2);
            }
            jSONObject2.put("connect_result", z ? "success" : IdentityVerifyStateKt.VERIFY_STATE_FAILED);
            JSONArray jSONArrayS = s(list);
            if (jSONArrayS != null) {
                jSONObject2.put("event_count", jSONArrayS.length());
                jSONObject2.put("events", jSONArrayS);
            }
            jSONObject.put("object", jSONObject2);
            this.s.n().n(jSONObject);
        } catch (Throwable unused) {
        }
    }

    private JSONArray s(List<com.byazt.vr.n> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.byazt.vr.n nVar : list) {
            if (nVar != null) {
                String strN = com.byazt.hls.q.n(nVar);
                if (!TextUtils.isEmpty(strN) && com.byazt.asa.qg.n.contains(strN)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(NotificationCompat.CATEGORY_EVENT, strN);
                        JSONObject jSONObjectS = com.byazt.hls.q.s(nVar.n());
                        if (jSONObjectS != null) {
                            jSONObject.put("req_id", jSONObjectS.optString("req_id"));
                            jSONObject.put("cid", jSONObjectS.optString("cid"));
                            jSONObject.put(MediationConstant.EXTRA_ADID, jSONObjectS.optString(MediationConstant.EXTRA_ADID));
                            jSONObject.put("rit", jSONObjectS.optString("rit"));
                            jSONObject.put("ad_slot_type", jSONObjectS.optInt("ad_slot_type"));
                        }
                        JSONObject jSONObjectTj = com.byazt.hls.q.tj(nVar);
                        if (jSONObjectTj != null) {
                            jSONObject.put("sdk_event_index", jSONObjectTj.optInt("sdk_event_index"));
                            jSONObject.put("sdk_session_id", jSONObjectTj.optString("sdk_session_id"));
                        }
                        jSONArray.put(jSONObject);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return jSONArray;
    }
}
