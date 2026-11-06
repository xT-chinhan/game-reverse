package com.byazt.gct;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.anythink.core.common.g.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1759})
public class ae {
    public static final Map<String, String> cp;
    public static volatile boolean d;
    public static final Set<String> fs;
    public static final Set<String> l;
    public static final Set<String> n;
    public static final Set<String> rv;
    public static boolean tj;
    public static final Set<String> w;
    public static final Set<String> x;
    public int qg;
    public static final Set<String> s = new HashSet();
    public static final Set<String> q = new CopyOnWriteArraySet();

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        l = copyOnWriteArraySet;
        w = new CopyOnWriteArraySet();
        x = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        fs = copyOnWriteArraySet2;
        rv = new CopyOnWriteArraySet();
        tj = false;
        cp = new HashMap();
        n = new CopyOnWriteArraySet();
        d = false;
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.gwu.s fs() {
        return com.byazt.lk.l.qg(com.byazt.vgx.s.q(), "cloud_path_check_res", 0, com.byazt.p001if.n.n());
    }

    public ae(JSONObject jSONObject) {
        this.qg = jSONObject.optInt("block_auto_open");
    }

    public void n(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.qg);
        } catch (JSONException unused) {
        }
    }

    public static void qg(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                q.clear();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        q.add(strOptString);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                l.clear();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        l.add(strOptString2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                w.clear();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    String strOptString3 = jSONArrayOptJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(strOptString3)) {
                        w.add(strOptString3);
                    }
                }
            }
        } catch (Exception unused3) {
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("url_report_rule_list");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    x.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        String strOptString4 = jSONArrayOptJSONArray4.optString(i4);
                        if (!TextUtils.isEmpty(strOptString4)) {
                            x.add(strOptString4);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("net_url_block_list");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    fs.clear();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                        String strOptString5 = jSONArrayOptJSONArray5.optString(i5);
                        if (!TextUtils.isEmpty(strOptString5)) {
                            fs.add(strOptString5);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray("dialog_black_list");
                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                    rv.clear();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                        String strOptString6 = jSONArrayOptJSONArray6.optString(i6);
                        if (!TextUtils.isEmpty(strOptString6)) {
                            rv.add(strOptString6);
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
        tj = true;
    }

    public static void n(com.byazt.gwu.l lVar) {
        lVar.n("turn_up_white_list", q);
        lVar.n("turn_up_black_list_1", l);
        lVar.n("turn_up_black_list_2", w);
        lVar.n("url_report_rule_list", x);
        lVar.n("net_url_block_list", fs);
        lVar.n("_turn_up_is_get_list", tj);
        lVar.n("dialog_black_list", rv);
    }

    public static void qg(com.byazt.gwu.l lVar) {
        Set<String> set = q;
        set.addAll(lVar.qg("turn_up_white_list", set));
        Set<String> set2 = l;
        set2.addAll(lVar.qg("turn_up_black_list_1", set2));
        Set<String> set3 = w;
        set3.addAll(lVar.qg("turn_up_black_list_2", set3));
        Set<String> set4 = x;
        set4.addAll(lVar.qg("url_report_rule_list", set4));
        Set<String> set5 = fs;
        set5.addAll(lVar.qg("net_url_block_list", set5));
        tj = lVar.qg("_turn_up_is_get_list", false);
        Set<String> set6 = rv;
        set6.addAll(lVar.qg("dialog_black_list", set6));
    }

    public static int n(pk pkVar) {
        ae aeVarHw;
        if (pkVar == null || (aeVarHw = pkVar.hw()) == null) {
            return 0;
        }
        return aeVarHw.qg;
    }

    public static boolean n(WebView webView, AtomicInteger atomicInteger, com.byazt.gcl.s sVar, String str, boolean z, boolean z2) {
        if (!str.startsWith("bytedance") && !str.startsWith("nativeapp") && !str.startsWith("bds")) {
            if (!com.byazt.vgx.w.n(str, atomicInteger) && n(webView, atomicInteger, str, true)) {
                return true;
            }
            if (sVar == null || !TextUtils.isEmpty(qg(str, s)) || !TextUtils.isEmpty(qg(str, q))) {
                return false;
            }
            String strQg = qg(str, x);
            if (!TextUtils.isEmpty(strQg)) {
                qg(sVar.fs(), str, strQg);
            }
            String strN = n(str, sVar.l(z2), z, z2);
            if (!TextUtils.isEmpty(strN) && tj) {
                n(sVar.fs(), str, strN);
            }
            if (!TextUtils.isEmpty(strN)) {
                return true;
            }
        }
        return false;
    }

    private static boolean n(WebView webView, AtomicInteger atomicInteger, String str, boolean z) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = cp;
            if (map.containsKey(path)) {
                return n(atomicInteger, map.get(path), str, webView, z);
            }
            if (!d) {
                for (String str2 : fs().qg("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArrSplit = str2.split(",");
                        cp.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                Map<String, String> map2 = cp;
                if (map2.containsKey(path)) {
                    return n(atomicInteger, map2.get(path), str, webView, z);
                }
            }
            com.byazt.qk.rv rvVarQ = com.byazt.phf.s.q(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter("aid", "1181").appendQueryParameter("device_platform", "android").appendQueryParameter(TapEventParamConstants.PARAM_DEVICE_ID, com.byazt.ehw.l.n()).appendQueryParameter("scc_mode", "raw").appendQueryParameter("scc_from", "App").toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("scene", com.anythink.core.common.l.f.Z);
            jSONObject.put(ImagesContract.URL, str);
            jSONObject.put("extra", "");
            rvVarQ.n(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            rvVarQ.n(new com.byazt.qk.x() { // from class: com.byazt.gct.ae.1
                @Override // com.byazt.qk.x
                public void n(com.byazt.qk.oa oaVar) {
                    try {
                        strArr[0] = oaVar.l().optJSONObject(com.anythink.core.common.l.f.R).optString("label");
                        if (TextUtils.isEmpty(strArr[0])) {
                            return;
                        }
                        if (ae.cp.size() > 1000) {
                            Iterator it = ae.cp.entrySet().iterator();
                            for (int i = 0; i < 200; i++) {
                                it.next();
                                it.remove();
                            }
                        }
                        ae.cp.put(path, strArr[0]);
                        if (!ae.d) {
                            boolean unused = ae.d = true;
                            com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.gct.ae.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.byazt.gwu.s sVarFs = ae.fs();
                                    sVarFs.n();
                                    HashSet hashSet = new HashSet();
                                    for (Map.Entry entry : ae.cp.entrySet()) {
                                        hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                    }
                                    sVarFs.n("cloud_path_check_res", hashSet);
                                    boolean unused2 = ae.d = false;
                                }
                            }, c.a);
                        }
                    } catch (Throwable unused2) {
                    }
                    countDownLatch.countDown();
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str3, Throwable th) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return n(atomicInteger, strArr[0], str, webView, z);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0046  */
    private static boolean n(AtomicInteger atomicInteger, String str, String str2, WebView webView, boolean z) {
        byte b;
        if (webView == null || TextUtils.isEmpty(str) || atomicInteger == null) {
            return false;
        }
        if (atomicInteger.get() == 1) {
            return true;
        }
        switch (str) {
            case "unknown":
                b = 1;
                break;
            case "gray":
                b = 2;
                break;
            case "black":
                b = 0;
                break;
            case "white":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b != 0) {
            return false;
        }
        atomicInteger.set(1);
        com.byazt.okk.n.n(webView.getContext(), (String) null, true, (com.byazt.okk.n.InterfaceC0282n) null);
        return true;
    }

    public static boolean n(WebView webView, AtomicInteger atomicInteger, com.byazt.gcl.s sVar, WebResourceRequest webResourceRequest, boolean z, boolean z2) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return n(webView, atomicInteger, sVar, url.toString(), z, z2);
    }

    public static boolean n(final com.byazt.gcl.s sVar, final int i, final String str) {
        final String strQg = qg(str, rv);
        boolean z = (tj && TextUtils.isEmpty(strQg)) ? false : true;
        final boolean z2 = z;
        com.byazt.eji.s.n().n("stats_dialog_report_rule", (String) null, sVar.fs().F_(), new com.byazt.rs.n() { // from class: com.byazt.gct.ae.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(ImagesContract.URL, str);
                jSONObject2.putOpt("type", Integer.valueOf(i));
                jSONObject2.putOpt("is_block", Boolean.valueOf(z2));
                jSONObject2.putOpt("is_get_setting", Boolean.valueOf(ae.tj));
                jSONObject2.putOpt("pattern", strQg);
                jSONObject2.putOpt("customer_id", com.byazt.vgx.w.cd(sVar.fs()));
                return jSONObject2;
            }
        });
        return z;
    }

    private static String n(String str, int i, boolean z, boolean z2) {
        boolean z3 = (!z2 || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
        if (i == 1) {
            if (tj) {
                return qg(str, w);
            }
            return null;
        }
        if (i == 2) {
            if (!tj) {
                if (z) {
                    return "local://no-setting";
                }
                return null;
            }
            if (z3) {
                return "local://short-internal";
            }
            String strQg = qg(str, l);
            if (!TextUtils.isEmpty(strQg)) {
                return strQg;
            }
            String strQg2 = qg(str, w);
            if (TextUtils.isEmpty(strQg2)) {
                return null;
            }
            return strQg2;
        }
        if (i != 3) {
            return null;
        }
        if (z || !tj) {
            return "local://preload-setting:" + tj;
        }
        if (z3) {
            return "local://short-internal";
        }
        String strQg3 = qg(str, l);
        if (!TextUtils.isEmpty(strQg3)) {
            return strQg3;
        }
        String strQg4 = qg(str, w);
        if (TextUtils.isEmpty(strQg4)) {
            return null;
        }
        return strQg4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(String str, Set<String> set) {
        if (str == null) {
            return null;
        }
        try {
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && Pattern.compile(str2).matcher(str).find()) {
                    return str2;
                }
            }
            return null;
        } catch (Exception e) {
            com.byazt.tk.k.qg("JumpModel", e.getMessage());
            return null;
        }
    }

    public static void n(final pk pkVar, final String str, final String str2) {
        com.byazt.eji.s.n().n("stats_block_report", (String) null, pkVar.F_(), new com.byazt.rs.n() { // from class: com.byazt.gct.ae.3
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(ImagesContract.URL, str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("aid", pkVar.wm());
                jSONObject3.put("cid", pkVar.q());
                jSONObject3.put("req_id", pkVar.ou());
                jSONObject3.put("customer_id", com.byazt.vgx.w.cd(pkVar));
                jSONObject2.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject3.toString());
                jSONObject2.putOpt("pattern", str2);
                return jSONObject2;
            }
        });
    }

    public static void qg(final pk pkVar, final String str, final String str2) {
        com.byazt.eji.s.n().n("stats_url_report_rule", (String) null, pkVar.F_(), new com.byazt.rs.n() { // from class: com.byazt.gct.ae.4
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(ImagesContract.URL, str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("aid", pkVar.wm());
                jSONObject3.put("cid", pkVar.q());
                jSONObject3.put("req_id", pkVar.ou());
                jSONObject3.put("customer_id", com.byazt.vgx.w.cd(pkVar));
                jSONObject2.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject3.toString());
                jSONObject2.putOpt("pattern", str2);
                return jSONObject2;
            }
        });
    }

    public static Set<String> n() {
        return fs;
    }

    public static com.byazt.tbt.rv qg() {
        return new com.byazt.tbt.rv() { // from class: com.byazt.gct.ae.5
            @Override // com.byazt.tbt.rv
            public com.byazt.tbt.cy n(com.byazt.tbt.rv.n nVar) throws IOException {
                String str;
                com.byazt.tbt.cy cyVarN = nVar.n(nVar.n());
                String str2 = "";
                final String strN = cyVarN.n("csj-location-record", "");
                final String strN2 = cyVarN.n("csj-source-from", "");
                final String strN3 = cyVarN.n("csj-extra-info", "");
                if (cyVarN.q() == 8848) {
                    final String strW = cyVarN.w();
                    com.byazt.eji.s.n().n("stats_net_block_url", new com.byazt.rs.n() { // from class: com.byazt.gct.ae.5.1
                        @Override // com.byazt.rs.n
                        public JSONObject n(JSONObject jSONObject) throws JSONException {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.putOpt(ImagesContract.URL, strW);
                            jSONObject2.putOpt("sourceFrom", strN2);
                            jSONObject2.putOpt(MediationConstant.KEY_EXTRA_INFO, strN3);
                            return jSONObject2;
                        }
                    });
                }
                int i = 0;
                try {
                    String[] strArrN = ae.n(strN);
                    if (strArrN == null || strArrN.length <= 1) {
                        str = "";
                    } else {
                        String str3 = strArrN[0];
                        try {
                            str = strArrN[strArrN.length - 1];
                            str2 = str3;
                        } catch (Exception unused) {
                            str = "";
                            str2 = str3;
                        }
                    }
                    try {
                        i = Integer.parseInt(strN2);
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str = "";
                }
                final String str4 = str2;
                final String str5 = str;
                if (TextUtils.isEmpty(strN) || i == 0 || !TextUtils.isEmpty(ae.qg(str4, ae.q))) {
                    return cyVarN;
                }
                com.byazt.eji.s.n().n("stats_net_locations_url", new com.byazt.rs.n() { // from class: com.byazt.gct.ae.5.2
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt(ImagesContract.URL, strN);
                        jSONObject2.putOpt("sourceFrom", strN2);
                        jSONObject2.putOpt("sourceUrl", str4);
                        jSONObject2.putOpt("destUrl", str5);
                        jSONObject2.putOpt(MediationConstant.KEY_EXTRA_INFO, strN3);
                        return jSONObject2;
                    }
                });
                return cyVarN;
            }
        };
    }

    public static String[] n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}
