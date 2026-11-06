package com.byazt.pa;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.byazt.nn.fw;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.vkw.nt;
import com.byazt.vkw.ny;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.MARCode;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.d;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, 37})
public class pr {
    public static volatile String k;
    public k c;
    public com.byazt.vkw.pr fw;
    public com.byazt.hh.hw hn;
    public g uc;
    public ny vk;
    public com.byazt.hh.c x;
    public com.byazt.vkw.hn zo;
    public static final byte[] aj = new byte[0];
    public static final Map<String, AtomicInteger> m = new ConcurrentHashMap();
    public static final Map<String, Long> g = new ConcurrentHashMap();
    public static final Map<String, Long> ho = new ConcurrentHashMap();
    public static final Map<String, Integer> nt = new ConcurrentHashMap();
    public static final Map<String, Integer> yb = new ConcurrentHashMap();
    public final String pr = "x-pglcypher";
    public boolean hw = com.byazt.nn.x.pr();
    public nt w = (nt) uc.pr("encrypt_service");

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    protected static final class hw {
        public final int hn;
        public final String hw;
        public final String pr;

        public hw(String str, String str2, int i) {
            this.pr = str;
            this.hw = str2;
            this.hn = i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.pa.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    protected static final class C0161pr {
        public final byte[] c;
        public final Throwable fw;
        public final String hn;
        public final int hw;
        public final boolean pr;
        public final String uc;
        public final boolean x;
        public final hw zo;

        public C0161pr(com.byazt.hcx.hn hnVar, hw hwVar) {
            if (hnVar == null) {
                this.pr = false;
                this.hw = 0;
                this.hn = null;
                this.x = false;
                this.c = null;
                this.uc = "error";
                this.fw = null;
            } else {
                this.pr = hnVar.pr();
                this.hw = hnVar.hw();
                this.hn = hnVar.hn();
                this.x = hnVar.x();
                this.c = hnVar.c();
                this.uc = hnVar.uc();
                this.fw = hnVar.fw();
            }
            this.zo = hwVar;
        }

        public C0161pr(boolean z, int i, String str, boolean z2, byte[] bArr, String str2, Throwable th, hw hwVar) {
            this.pr = z;
            this.hw = i;
            this.hn = str;
            this.x = z2;
            this.c = bArr;
            this.uc = str2;
            this.fw = th;
            this.zo = hwVar;
        }
    }

    public pr(com.byazt.vkw.pr prVar, com.byazt.hh.hw hwVar, k kVar, g gVar, com.byazt.hh.c cVar) {
        this.fw = prVar;
        this.hn = hwVar;
        this.c = kVar;
        this.x = cVar;
        this.uc = gVar;
        this.vk = (ny) uc.pr("mediation_settings", prVar);
        this.zo = (com.byazt.vkw.hn) uc.pr("embed_applog", this.fw);
    }

    public boolean pr() {
        nt ntVar = (nt) uc.pr("encrypt_service");
        ny nyVar = this.vk;
        return (nyVar == null || nyVar.hw() || ntVar == null || !ntVar.hw()) ? false : true;
    }

    public String pr(int i) {
        if (i >= 4) {
            return "application/octet-stream";
        }
        return "application/octet-stream;tt-data=a";
    }

    public int hw() {
        if (((k) uc.pr("csj_settings", this.fw)).pr()) {
            return 4;
        }
        return 3;
    }

    public static String hw(int i) {
        switch (i) {
            case 120:
                return "ldpi";
            case 160:
            default:
                return "mdpi";
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA /* 240 */:
                return "hdpi";
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                return "xhdpi";
            case 480:
                return "xxhdpi";
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK /* 640 */:
                return "xxxhdpi";
        }
    }

    public static String hn() {
        if (TextUtils.isEmpty(k)) {
            synchronized (pr.class) {
                if (TextUtils.isEmpty(k)) {
                    String strHw = ((g) uc.pr("device_info_new")).hw((Boolean) null);
                    if (!TextUtils.isEmpty(strHw)) {
                        k = com.byazt.nn.hn.pr(strHw);
                    }
                }
            }
        }
        return k;
    }

    public boolean pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optInt(PluginConstants.KEY_ERROR_CODE) == 20000 || TrackAction.SUCCESS.equals(jSONObject.optString("message"));
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public boolean hw(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optString("message").equalsIgnoreCase(TrackAction.SUCCESS);
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    public com.byazt.mqu.pr pr(List<com.byazt.hh.pr> list) {
        return null;
    }

    public String pr(Context context) {
        try {
            if (hn(context)) {
                return "tv";
            }
            if (hw(context)) {
                return "android_pad";
            }
            return "android";
        } catch (Throwable th) {
            return "android";
        }
    }

    public static boolean hw(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean hn(Context context) {
        try {
            if ((context.getResources().getConfiguration().uiMode & 15) != 4) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static JSONObject pr(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            nt ntVar = (nt) uc.pr("encrypt_service");
            String strHn = ntVar != null ? ntVar.hn(str) : null;
            if (!TextUtils.isEmpty(strHn)) {
                jSONObject.put("message", strHn);
                jSONObject.put("cypher", 3);
            } else {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            try {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            } catch (Throwable th2) {
                fw.pr(th2.getMessage());
            }
        }
        return jSONObject;
    }

    public byte[] hn(JSONObject jSONObject) throws Throwable {
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
                } catch (Exception e) {
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
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public boolean pr(String str, com.byazt.av.pr prVar) {
        if (TextUtils.isEmpty(str) || prVar == null || prVar.pr || !pr(prVar) || uc(str)) {
            return false;
        }
        return aj(str);
    }

    public boolean pr(com.byazt.av.pr prVar) {
        if (prVar == null || prVar.pr) {
            return false;
        }
        Throwable th = prVar.uc;
        return (th instanceof UnknownHostException) || (th instanceof SocketTimeoutException) || (th instanceof NullPointerException);
    }

    private boolean uc(String str) {
        Map<String, Long> map = ho;
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

    public void hw(String str) {
        ho.put(str, Long.valueOf(System.currentTimeMillis() + 300000));
        fw(str);
        AtomicInteger atomicInteger = m.get(str);
        if (atomicInteger != null) {
            atomicInteger.set(0);
        }
        g.remove(str);
    }

    public void hn(String str) {
        Map<String, AtomicInteger> map = m;
        AtomicInteger atomicInteger = map.get(str);
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            AtomicInteger atomicInteger2 = (AtomicInteger) ((ConcurrentHashMap) map).putIfAbsent(str, atomicInteger);
            if (atomicInteger2 != null) {
                atomicInteger = atomicInteger2;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, Long> map2 = g;
        Long l = map2.get(str);
        long jX = x();
        if (l != null && jCurrentTimeMillis - l.longValue() > jX) {
            atomicInteger.set(0);
        }
        int iIncrementAndGet = atomicInteger.incrementAndGet();
        map2.put(str, Long.valueOf(jCurrentTimeMillis));
        if (iIncrementAndGet == 1) {
            fw(str);
        }
    }

    private void fw(String str) {
        com.byazt.hh.hw hwVar = this.hn;
        if (hwVar != null && hwVar.pr() != null) {
            nt.put(str, Integer.valueOf(this.hn.pr().zo()));
        }
        yb.put(str, Integer.valueOf(com.byazt.yt.c.vk()));
    }

    private int zo(String str) {
        AtomicInteger atomicInteger = m.get(str);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    private boolean aj(String str) {
        com.byazt.hh.hw hwVar;
        if (!vk(str) || zo(str) < c() || (hwVar = this.hn) == null || hwVar.pr() == null) {
            return false;
        }
        com.byazt.hh.hn hnVarPr = this.hn.pr();
        if (!hnVarPr.fw()) {
            return false;
        }
        Integer num = nt.get(str);
        if (hnVarPr.zo() - (num == null ? 0 : num.intValue()) < 5) {
            return false;
        }
        Integer num2 = yb.get(str);
        return com.byazt.yt.c.vk() - (num2 == null ? 0 : num2.intValue()) >= 5;
    }

    private boolean vk(String str) {
        return (this.c == null || TextUtils.isEmpty(str) || x(str).isEmpty()) ? false : true;
    }

    private int c() {
        int iLb;
        k kVar = this.c;
        if (kVar != null && (iLb = kVar.lb()) > 0) {
            return iLb;
        }
        return 10;
    }

    public List<hw> x(String str) {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        JSONArray jSONArrayPr = this.c.pr(str);
        if (jSONArrayPr == null || jSONArrayPr.length() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayPr.length(); i++) {
            Object objOpt = jSONArrayPr.opt(i);
            if (objOpt instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) objOpt;
                String strOptString = jSONObject.optString("ip");
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(new hw(strOptString, jSONObject.optString("family", w(strOptString)), jSONObject.optInt("priority", i + 1)));
                }
            } else {
                String strOptString2 = jSONArrayPr.optString(i);
                if (!TextUtils.isEmpty(strOptString2)) {
                    arrayList.add(new hw(strOptString2, w(strOptString2), i + 1));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        return hw(arrayList);
    }

    public C0161pr pr(String str, byte[] bArr, Map<String, String> map, String str2, hw hwVar) {
        com.byazt.hcx.c cVar;
        if (TextUtils.isEmpty(str) || bArr == null || hwVar == null || TextUtils.isEmpty(hwVar.pr) || TextUtils.isEmpty(c(str)) || (cVar = (com.byazt.hcx.c) uc.pr("direct_connect")) == null) {
            return null;
        }
        com.byazt.hcx.hn hnVarPr = cVar.pr(str, bArr, pr(map), str2, hwVar.pr, 10000);
        if (hnVarPr == null) {
            return new C0161pr(false, 0, null, false, null, "error", new IllegalStateException("direct_connect_service_null"), hwVar);
        }
        return new C0161pr(hnVarPr, hwVar);
    }

    public String pr(Throwable th, String str) {
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

    public long x() {
        k kVar = this.c;
        if (kVar != null) {
            long jYb = kVar.yb();
            if (jYb > 0) {
                return jYb;
            }
            return 600000L;
        }
        return 600000L;
    }

    public String pr(hw hwVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(hwVar.pr).append(" ").append(hwVar.hw);
        if (!TextUtils.isEmpty(str)) {
            sb.append(" ").append(str);
        }
        return sb.toString();
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URI.create(str).getHost();
        } catch (Throwable th) {
            return "";
        }
    }

    private List<hw> hw(List<hw> list) {
        g gVar = this.uc;
        boolean z = gVar == null || gVar.n();
        ArrayList arrayList = new ArrayList();
        for (hw hwVar : list) {
            if (hwVar != null && !TextUtils.isEmpty(hwVar.pr) && TextUtils.equals("ipv4", hwVar.hw) && z) {
                arrayList.add(hwVar);
            }
        }
        Collections.sort(arrayList, new Comparator<hw>() { // from class: com.byazt.pa.pr.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int compare(hw hwVar2, hw hwVar3) {
                return hwVar2.hn - hwVar3.hn;
            }
        });
        return arrayList;
    }

    private String w(String str) {
        return (!TextUtils.isEmpty(str) && str.contains(":")) ? "ipv6" : "ipv4";
    }

    private Map<String, String> pr(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        if (this.uc != null && !map2.containsKey("User-Agent")) {
            map2.put("User-Agent", this.uc.hw(false));
        }
        return map2;
    }

    public void pr(String str, Throwable th, List<com.byazt.hh.pr> list, String str2, boolean z) {
        com.byazt.hh.hw hwVar = this.hn;
        if (hwVar == null || hwVar.pr() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", "exception");
            jSONObject.put("scene", "applog_failed");
            jSONObject2.put("bucket", str);
            if (th != null) {
                jSONObject2.put(Constants.ERROR_MSG_FIELD, pr(th, th.getMessage()));
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("direct_ip", str2);
            }
            jSONObject2.put("connect_result", z ? TrackAction.SUCCESS : IdentityVerifyStateKt.VERIFY_STATE_FAILED);
            JSONArray jSONArrayHn = hn(list);
            if (jSONArrayHn != null) {
                jSONObject2.put("event_count", jSONArrayHn.length());
                jSONObject2.put(d.ar, jSONArrayHn);
            }
            jSONObject.put("object", jSONObject2);
            this.hn.pr().pr(jSONObject);
        } catch (Throwable th2) {
        }
    }

    private JSONArray hn(List<com.byazt.hh.pr> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.byazt.hh.pr prVar : list) {
            if (prVar != null) {
                String strPr = com.byazt.nn.x.pr(prVar);
                if (!TextUtils.isEmpty(strPr) && com.byazt.yt.hw.pr.contains(strPr)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(NotificationCompat.CATEGORY_EVENT, strPr);
                        JSONObject jSONObjectHn = com.byazt.nn.x.hn(prVar.pr());
                        if (jSONObjectHn != null) {
                            jSONObject.put("req_id", jSONObjectHn.optString("req_id"));
                            jSONObject.put("cid", jSONObjectHn.optString("cid"));
                            jSONObject.put(MediationConstant.EXTRA_ADID, jSONObjectHn.optString(MediationConstant.EXTRA_ADID));
                            jSONObject.put("rit", jSONObjectHn.optString("rit"));
                            jSONObject.put("ad_slot_type", jSONObjectHn.optInt("ad_slot_type"));
                        }
                        JSONObject jSONObjectVk = com.byazt.nn.x.vk(prVar);
                        if (jSONObjectVk != null) {
                            jSONObject.put("sdk_event_index", jSONObjectVk.optInt("sdk_event_index"));
                            jSONObject.put("sdk_session_id", jSONObjectVk.optString("sdk_session_id"));
                        }
                        jSONArray.put(jSONObject);
                    } catch (Throwable th) {
                    }
                }
            }
        }
        return jSONArray;
    }
}
