package com.byazt.hg;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
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
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 105})
public class e {
    public static final Set<String> aj;
    public static final Set<String> c;
    public static final Set<String> fw;
    public static volatile boolean k;
    public static final Set<String> pr;
    public static final Set<String> uc;
    public static boolean vk;
    public static final Map<String, String> w;
    public static final Set<String> zo;
    public int hw;
    public static final Set<String> hn = new HashSet();
    public static final Set<String> x = new CopyOnWriteArraySet();

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        c = copyOnWriteArraySet;
        uc = new CopyOnWriteArraySet();
        fw = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        zo = copyOnWriteArraySet2;
        aj = new CopyOnWriteArraySet();
        vk = false;
        w = new HashMap();
        pr = new CopyOnWriteArraySet();
        k = false;
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
    }

    public e(JSONObject jSONObject) {
        this.hw = jSONObject.optInt("block_auto_open");
    }

    public void pr(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.hw);
        } catch (JSONException e) {
        }
    }

    public static void hw(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                x.clear();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        x.add(strOptString);
                    }
                }
            }
        } catch (Exception e) {
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                c.clear();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        c.add(strOptString2);
                    }
                }
            }
        } catch (Exception e2) {
        }
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                uc.clear();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    String strOptString3 = jSONArrayOptJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(strOptString3)) {
                        uc.add(strOptString3);
                    }
                }
            }
        } catch (Exception e3) {
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("url_report_rule_list");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    fw.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        String strOptString4 = jSONArrayOptJSONArray4.optString(i4);
                        if (!TextUtils.isEmpty(strOptString4)) {
                            fw.add(strOptString4);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("net_url_block_list");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    zo.clear();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                        String strOptString5 = jSONArrayOptJSONArray5.optString(i5);
                        if (!TextUtils.isEmpty(strOptString5)) {
                            zo.add(strOptString5);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray("dialog_black_list");
                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                    aj.clear();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                        String strOptString6 = jSONArrayOptJSONArray6.optString(i6);
                        if (!TextUtils.isEmpty(strOptString6)) {
                            aj.add(strOptString6);
                        }
                    }
                }
            } catch (Exception e4) {
            }
        }
        vk = true;
    }

    public static void pr(com.byazt.zq.c cVar) {
        cVar.pr("turn_up_white_list", x);
        cVar.pr("turn_up_black_list_1", c);
        cVar.pr("turn_up_black_list_2", uc);
        cVar.pr("url_report_rule_list", fw);
        cVar.pr("net_url_block_list", zo);
        cVar.pr("_turn_up_is_get_list", vk);
        cVar.pr("dialog_black_list", aj);
    }

    public static void hw(com.byazt.zq.c cVar) {
        Set<String> set = x;
        set.addAll(cVar.hw("turn_up_white_list", set));
        Set<String> set2 = c;
        set2.addAll(cVar.hw("turn_up_black_list_1", set2));
        Set<String> set3 = uc;
        set3.addAll(cVar.hw("turn_up_black_list_2", set3));
        Set<String> set4 = fw;
        set4.addAll(cVar.hw("url_report_rule_list", set4));
        Set<String> set5 = zo;
        set5.addAll(cVar.hw("net_url_block_list", set5));
        vk = cVar.hw("_turn_up_is_get_list", false);
        Set<String> set6 = aj;
        set6.addAll(cVar.hw("dialog_black_list", set6));
    }

    public static int pr(of ofVar) {
        e eVarGp;
        if (ofVar == null || (eVarGp = ofVar.gp()) == null) {
            return 0;
        }
        return eVarGp.hw;
    }

    public static boolean pr(WebView webView, AtomicInteger atomicInteger, com.byazt.sd.nl nlVar, String str, boolean z, boolean z2) {
        if (str.startsWith("bytedance") || str.startsWith("nativeapp") || str.startsWith("bds")) {
            return false;
        }
        if (!com.byazt.wt.ls.pr(str, atomicInteger) && pr(webView, atomicInteger, str, true)) {
            return true;
        }
        if (nlVar == null || !TextUtils.isEmpty(hw(str, hn)) || !TextUtils.isEmpty(hw(str, x))) {
            return false;
        }
        String strHw = hw(str, fw);
        if (!TextUtils.isEmpty(strHw)) {
            hw(nlVar.zo(), str, strHw);
        }
        String strPr = pr(str, nlVar.c(z2), z, z2);
        if (!TextUtils.isEmpty(strPr) && vk) {
            pr(nlVar.zo(), str, strPr);
        }
        return !TextUtils.isEmpty(strPr);
    }

    private static boolean pr(WebView webView, AtomicInteger atomicInteger, String str, boolean z) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = w;
            if (map.containsKey(path)) {
                return pr(atomicInteger, map.get(path), str, webView, z);
            }
            if (!k) {
                for (String str2 : com.byazt.wt.y.pr("cloud_path_check_res").hw("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArrSplit = str2.split(",");
                        w.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                Map<String, String> map2 = w;
                if (map2.containsKey(path)) {
                    return pr(atomicInteger, map2.get(path), str, webView, z);
                }
            }
            com.byazt.hcx.aj ajVarX = com.byazt.tf.hn.x(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter("aid", "1181").appendQueryParameter("device_platform", "android").appendQueryParameter("device_id", com.byazt.wt.nt.pr()).appendQueryParameter("scc_mode", "raw").appendQueryParameter("scc_from", "App").toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("scene", "common");
            jSONObject.put(BreakpointSQLiteKey.URL, str);
            jSONObject.put("extra", "");
            ajVarX.pr(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ajVarX.pr(new com.byazt.hcx.fw() { // from class: com.byazt.hg.e.1
                @Override // com.byazt.hcx.fw
                public void pr(com.byazt.hcx.m mVar) {
                    try {
                        strArr[0] = mVar.c().optJSONObject("data").optString("label");
                        if (!TextUtils.isEmpty(strArr[0])) {
                            if (e.w.size() > 1000) {
                                Iterator it = e.w.entrySet().iterator();
                                for (int i = 0; i < 200; i++) {
                                    it.next();
                                    it.remove();
                                }
                            }
                            e.w.put(path, strArr[0]);
                            if (!e.k) {
                                boolean unused = e.k = true;
                                com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.hg.e.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.byazt.cr.c cVarPr = com.byazt.wt.y.pr("cloud_path_check_res");
                                        cVarPr.pr();
                                        HashSet hashSet = new HashSet();
                                        for (Map.Entry entry : e.w.entrySet()) {
                                            hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                        }
                                        cVarPr.pr("cloud_path_check_res", hashSet);
                                        boolean unused2 = e.k = false;
                                    }
                                }, 1800000L);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                    }
                    countDownLatch.countDown();
                }

                @Override // com.byazt.hcx.fw
                public void pr(int i, String str3, Throwable th) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return pr(atomicInteger, strArr[0], str, webView, z);
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean pr(AtomicInteger atomicInteger, String str, String str2, WebView webView, boolean z) {
        if (webView == null || TextUtils.isEmpty(str) || atomicInteger == null) {
            return false;
        }
        if (atomicInteger.get() == 1) {
            return true;
        }
        switch (str) {
            case "black":
                atomicInteger.set(1);
                com.byazt.wt.c.pr(webView.getContext(), (String) null, true, (com.byazt.wt.c.pr) null);
                return true;
            case "unknown":
            case "gray":
            case "white":
            default:
                return false;
        }
    }

    public static boolean pr(WebView webView, AtomicInteger atomicInteger, com.byazt.sd.nl nlVar, WebResourceRequest webResourceRequest, boolean z, boolean z2) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return pr(webView, atomicInteger, nlVar, url.toString(), z, z2);
    }

    public static boolean pr(final com.byazt.sd.nl nlVar, final int i, final String str) {
        final String strHw = hw(str, aj);
        boolean z = (vk && TextUtils.isEmpty(strHw)) ? false : true;
        final boolean z2 = z;
        com.byazt.xk.hw.pr().pr("stats_dialog_report_rule", (String) null, nlVar.zo().B_(), new com.byazt.ttf.pr() { // from class: com.byazt.hg.e.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(BreakpointSQLiteKey.URL, str);
                jSONObject2.putOpt("type", Integer.valueOf(i));
                jSONObject2.putOpt("is_block", Boolean.valueOf(z2));
                jSONObject2.putOpt("is_get_setting", Boolean.valueOf(e.vk));
                jSONObject2.putOpt("pattern", strHw);
                jSONObject2.putOpt("customer_id", com.byazt.wt.ls.ho(nlVar.zo()));
                return jSONObject2;
            }
        });
        return z;
    }

    private static String pr(String str, int i, boolean z, boolean z2) {
        boolean z3 = (!z2 || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
        switch (i) {
            case 1:
                if (vk) {
                    return hw(str, uc);
                }
                return null;
            case 2:
                if (!vk) {
                    if (z) {
                        return "local://no-setting";
                    }
                    return null;
                }
                if (z3) {
                    return "local://short-internal";
                }
                String strHw = hw(str, c);
                if (!TextUtils.isEmpty(strHw)) {
                    return strHw;
                }
                String strHw2 = hw(str, uc);
                if (TextUtils.isEmpty(strHw2)) {
                    return null;
                }
                return strHw2;
            case 3:
                if (z || !vk) {
                    return "local://preload-setting:" + vk;
                }
                if (z3) {
                    return "local://short-internal";
                }
                String strHw3 = hw(str, c);
                if (!TextUtils.isEmpty(strHw3)) {
                    return strHw3;
                }
                String strHw4 = hw(str, uc);
                if (TextUtils.isEmpty(strHw4)) {
                    return null;
                }
                return strHw4;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hw(String str, Set<String> set) {
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
            com.byazt.ca.ho.hw("JumpModel", e.getMessage());
            return null;
        }
    }

    public static void pr(final of ofVar, final String str, final String str2) {
        com.byazt.xk.hw.pr().pr("stats_block_report", (String) null, ofVar.B_(), new com.byazt.ttf.pr() { // from class: com.byazt.hg.e.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(BreakpointSQLiteKey.URL, str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("aid", ofVar.fo());
                jSONObject3.put("cid", ofVar.x());
                jSONObject3.put("req_id", ofVar.ny());
                jSONObject3.put("customer_id", com.byazt.wt.ls.ho(ofVar));
                jSONObject2.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject3.toString());
                jSONObject2.putOpt("pattern", str2);
                return jSONObject2;
            }
        });
    }

    public static void hw(final of ofVar, final String str, final String str2) {
        com.byazt.xk.hw.pr().pr("stats_url_report_rule", (String) null, ofVar.B_(), new com.byazt.ttf.pr() { // from class: com.byazt.hg.e.4
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(BreakpointSQLiteKey.URL, str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("aid", ofVar.fo());
                jSONObject3.put("cid", ofVar.x());
                jSONObject3.put("req_id", ofVar.ny());
                jSONObject3.put("customer_id", com.byazt.wt.ls.ho(ofVar));
                jSONObject2.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject3.toString());
                jSONObject2.putOpt("pattern", str2);
                return jSONObject2;
            }
        });
    }

    public static Set<String> pr() {
        return zo;
    }

    public static com.byazt.nzn.aj hw() {
        return new com.byazt.nzn.aj() { // from class: com.byazt.hg.e.5
            @Override // com.byazt.nzn.aj
            public com.byazt.nzn.nt pr(com.byazt.nzn.aj.pr prVar) throws IOException {
                String str;
                final String str2;
                final String str3;
                com.byazt.nzn.nt ntVarPr = prVar.pr(prVar.pr());
                String str4 = "";
                final String strPr = ntVarPr.pr("csj-location-record", "");
                final String strPr2 = ntVarPr.pr("csj-source-from", "");
                final String strPr3 = ntVarPr.pr("csj-extra-info", "");
                if (ntVarPr.hn() == 8848) {
                    final String strC = ntVarPr.c();
                    com.byazt.xk.hw.pr().pr("stats_net_block_url", new com.byazt.ttf.pr() { // from class: com.byazt.hg.e.5.1
                        @Override // com.byazt.ttf.pr
                        public JSONObject pr(JSONObject jSONObject) throws JSONException {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.putOpt(BreakpointSQLiteKey.URL, strC);
                            jSONObject2.putOpt("sourceFrom", strPr2);
                            jSONObject2.putOpt(MediationConstant.KEY_EXTRA_INFO, strPr3);
                            return jSONObject2;
                        }
                    });
                }
                int i = 0;
                try {
                    String[] strArrPr = e.pr(strPr);
                    if (strArrPr != null && strArrPr.length > 1) {
                        String str5 = strArrPr[0];
                        try {
                            str = strArrPr[strArrPr.length - 1];
                            str4 = str5;
                        } catch (Exception e) {
                            str = "";
                            str4 = str5;
                            str2 = str4;
                            str3 = str;
                            if (!TextUtils.isEmpty(strPr)) {
                            }
                            return ntVarPr;
                        }
                    } else {
                        str = "";
                    }
                    try {
                        i = Integer.parseInt(strPr2);
                        str2 = str4;
                        str3 = str;
                    } catch (Exception e2) {
                        str2 = str4;
                        str3 = str;
                    }
                } catch (Exception e3) {
                    str = "";
                }
                if (!TextUtils.isEmpty(strPr) || i == 0 || !TextUtils.isEmpty(e.hw(str2, e.x))) {
                    return ntVarPr;
                }
                com.byazt.xk.hw.pr().pr("stats_net_locations_url", new com.byazt.ttf.pr() { // from class: com.byazt.hg.e.5.2
                    @Override // com.byazt.ttf.pr
                    public JSONObject pr(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt(BreakpointSQLiteKey.URL, strPr);
                        jSONObject2.putOpt("sourceFrom", strPr2);
                        jSONObject2.putOpt("sourceUrl", str2);
                        jSONObject2.putOpt("destUrl", str3);
                        jSONObject2.putOpt(MediationConstant.KEY_EXTRA_INFO, strPr3);
                        return jSONObject2;
                    }
                });
                return ntVarPr;
            }
        };
    }

    public static String[] pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}
