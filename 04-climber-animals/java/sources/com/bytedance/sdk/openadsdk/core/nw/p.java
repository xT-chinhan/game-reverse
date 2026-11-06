package com.bytedance.sdk.openadsdk.core.nw;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.ccg.a;
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

/* JADX INFO: loaded from: classes2.dex */
public class p {
    private static final Set<String> ab;
    private static final Set<String> ah;
    private static final Set<String> c;
    private static boolean ch;
    private static final Set<String> d;
    private static final Map<String, String> hi;
    private static final Set<String> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final Set<String> f3077ms;
    private static final Set<String> ny;
    private static volatile boolean sl;
    private static final Set<String> x;
    private int xr;

    static {
        HashSet hashSet = new HashSet();
        ah = hashSet;
        d = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        ka = copyOnWriteArraySet;
        c = new CopyOnWriteArraySet();
        ab = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        x = copyOnWriteArraySet2;
        ny = new CopyOnWriteArraySet();
        ch = false;
        hi = new HashMap();
        f3077ms = new CopyOnWriteArraySet();
        sl = false;
        hashSet.addAll(Arrays.asList("dragon1967", "snssdk1128", "snssdk2329", "snssdk141", "snssdk35", "snssdk32", "snssdk1112"));
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
    }

    public p(JSONObject jSONObject) {
        this.xr = jSONObject.optInt("block_auto_open");
    }

    public void ms(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.xr);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static void xr(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                d.clear();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        d.add(strOptString);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                ka.clear();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        ka.add(strOptString2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                c.clear();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    String strOptString3 = jSONArrayOptJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(strOptString3)) {
                        c.add(strOptString3);
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
                    ab.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        String strOptString4 = jSONArrayOptJSONArray4.optString(i4);
                        if (!TextUtils.isEmpty(strOptString4)) {
                            ab.add(strOptString4);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("net_url_block_list");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    x.clear();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                        String strOptString5 = jSONArrayOptJSONArray5.optString(i5);
                        if (!TextUtils.isEmpty(strOptString5)) {
                            x.add(strOptString5);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray("dialog_black_list");
                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                    ny.clear();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                        String strOptString6 = jSONArrayOptJSONArray6.optString(i6);
                        if (!TextUtils.isEmpty(strOptString6)) {
                            ny.add(strOptString6);
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
        ch = true;
    }

    public static void ms(com.bytedance.sdk.component.d.ms.xr xrVar) {
        xrVar.ms("turn_up_white_list", d);
        xrVar.ms("turn_up_black_list_1", ka);
        xrVar.ms("turn_up_black_list_2", c);
        xrVar.ms("url_report_rule_list", ab);
        xrVar.ms("net_url_block_list", x);
        xrVar.ms("_turn_up_is_get_list", ch);
        xrVar.ms("dialog_black_list", ny);
    }

    public static void xr(com.bytedance.sdk.component.d.ms.xr xrVar) {
        Set<String> set = d;
        set.addAll(xrVar.xr("turn_up_white_list", set));
        Set<String> set2 = ka;
        set2.addAll(xrVar.xr("turn_up_black_list_1", set2));
        Set<String> set3 = c;
        set3.addAll(xrVar.xr("turn_up_black_list_2", set3));
        Set<String> set4 = ab;
        set4.addAll(xrVar.xr("url_report_rule_list", set4));
        Set<String> set5 = x;
        set5.addAll(xrVar.xr("net_url_block_list", set5));
        ch = xrVar.xr("_turn_up_is_get_list", false);
        Set<String> set6 = ny;
        set6.addAll(xrVar.xr("dialog_black_list", set6));
    }

    public static int ms(lm lmVar) {
        p pVarMo;
        if (lmVar == null || (pVarMo = lmVar.mo()) == null) {
            return 0;
        }
        return pVarMo.xr;
    }

    public static boolean ms(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.pc pcVar, String str, boolean z, boolean z2) {
        if (!str.startsWith("bytedance") && !str.startsWith("nativeapp") && !str.startsWith("bds")) {
            if (!com.bytedance.sdk.openadsdk.core.jw.f.ms(str, atomicInteger) && ms(webView, atomicInteger, str, true)) {
                return true;
            }
            if (pcVar == null || !TextUtils.isEmpty(xr(str, ah)) || !TextUtils.isEmpty(xr(str, d))) {
                return false;
            }
            String strXr = xr(str, ab);
            if (!TextUtils.isEmpty(strXr)) {
                xr(pcVar.x(), str, strXr);
            }
            String strMs = ms(str, pcVar.ka(z2), z, z2);
            if (!TextUtils.isEmpty(strMs) && ch) {
                ms(pcVar.x(), str, strMs);
            }
            if (!TextUtils.isEmpty(strMs)) {
                return true;
            }
        }
        return false;
    }

    private static boolean ms(WebView webView, AtomicInteger atomicInteger, String str, boolean z) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = hi;
            if (map.containsKey(path)) {
                return ms(atomicInteger, map.get(path), str, webView, z);
            }
            if (!sl) {
                for (String str2 : com.bytedance.sdk.openadsdk.core.jw.g.ms("cloud_path_check_res").xr("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArrSplit = str2.split(",");
                        hi.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                Map<String, String> map2 = hi;
                if (map2.containsKey(path)) {
                    return ms(atomicInteger, map2.get(path), str, webView, z);
                }
            }
            com.bytedance.sdk.component.ny.xr.ka kaVarXr = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
            kaVarXr.ms(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter("aid", "1181").appendQueryParameter("device_platform", "android").appendQueryParameter("device_id", com.bytedance.sdk.openadsdk.core.t.ah()).appendQueryParameter("scc_mode", "raw").appendQueryParameter("scc_from", "App").toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(a.j, com.anythink.core.common.m.e.Y);
            jSONObject.put("url", str);
            jSONObject.put("extra", "");
            kaVarXr.ms(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            kaVarXr.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.p.1
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    try {
                        strArr[0] = new JSONObject(xrVar.d()).optJSONObject("data").optString(TTDownloadField.TT_LABEL);
                        if (TextUtils.isEmpty(strArr[0])) {
                            return;
                        }
                        if (p.hi.size() > 1000) {
                            Iterator it = p.hi.entrySet().iterator();
                            for (int i = 0; i < 200; i++) {
                                it.next();
                                it.remove();
                            }
                        }
                        p.hi.put(path, strArr[0]);
                        if (!p.sl) {
                            boolean unused = p.sl = true;
                            com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nw.p.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.jw.g.ms("cloud_path_check_res");
                                    xrVarMs.ms();
                                    HashSet hashSet = new HashSet();
                                    for (Map.Entry entry : p.hi.entrySet()) {
                                        hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                    }
                                    xrVarMs.ms("cloud_path_check_res", hashSet);
                                    boolean unused2 = p.sl = false;
                                }
                            }, 1800000L);
                        }
                    } catch (Throwable unused2) {
                    }
                    countDownLatch.countDown();
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return ms(atomicInteger, strArr[0], str, webView, z);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0046  */
    private static boolean ms(AtomicInteger atomicInteger, String str, String str2, WebView webView, boolean z) {
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
        com.bytedance.sdk.openadsdk.core.jw.c.ms(webView.getContext(), (String) null, true, (com.bytedance.sdk.openadsdk.core.jw.c.ms) null);
        return true;
    }

    public static boolean ms(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.pc pcVar, WebResourceRequest webResourceRequest, boolean z, boolean z2) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return ms(webView, atomicInteger, pcVar, url.toString(), z, z2);
    }

    public static boolean ms(final com.bytedance.sdk.openadsdk.core.pc pcVar, final int i, final String str) {
        final String strXr = xr(str, ny);
        boolean z = (ch && TextUtils.isEmpty(strXr)) ? false : true;
        final boolean z2 = z;
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.p.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("url", str);
                    jSONObject.putOpt("type", Integer.valueOf(i));
                    jSONObject.putOpt("is_block", Boolean.valueOf(z2));
                    jSONObject.putOpt("is_get_setting", Boolean.valueOf(p.ch));
                    jSONObject.putOpt("pattern", strXr);
                    jSONObject.putOpt("customer_id", com.bytedance.sdk.openadsdk.core.jw.f.hi(pcVar.x()));
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("stats_dialog_report_rule").x(pcVar.x().lx()).xr(jSONObject.toString());
                } catch (Throwable unused) {
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr();
                }
            }
        }, "stats_dialog_report_rule");
        return z;
    }

    private static String ms(String str, int i, boolean z, boolean z2) {
        boolean z3 = (!z2 || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
        if (i == 1) {
            if (ch) {
                return xr(str, c);
            }
            return null;
        }
        if (i == 2) {
            if (!ch) {
                if (z) {
                    return "local://no-setting";
                }
                return null;
            }
            if (z3) {
                return "local://short-internal";
            }
            String strXr = xr(str, ka);
            if (!TextUtils.isEmpty(strXr)) {
                return strXr;
            }
            String strXr2 = xr(str, c);
            if (TextUtils.isEmpty(strXr2)) {
                return null;
            }
            return strXr2;
        }
        if (i != 3) {
            return null;
        }
        if (z || !ch) {
            return "local://preload-setting:" + ch;
        }
        if (z3) {
            return "local://short-internal";
        }
        String strXr3 = xr(str, ka);
        if (!TextUtils.isEmpty(strXr3)) {
            return strXr3;
        }
        String strXr4 = xr(str, c);
        if (TextUtils.isEmpty(strXr4)) {
            return null;
        }
        return strXr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xr(String str, Set<String> set) {
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
            com.bytedance.sdk.component.utils.sl.d("JumpModel", e.getMessage());
            return null;
        }
    }

    public static void ms(final lm lmVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.p.3
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", lmVar.cz());
                jSONObject2.put("cid", lmVar.df());
                jSONObject2.put("req_id", lmVar.eu());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.jw.f.hi(lmVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("stats_block_report").x(lmVar.lx()).xr(jSONObject.toString());
            }
        }, "stats_block_report");
    }

    public static void xr(final lm lmVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.p.4
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", lmVar.cz());
                jSONObject2.put("cid", lmVar.df());
                jSONObject2.put("req_id", lmVar.eu());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.jw.f.hi(lmVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("stats_url_report_rule").x(lmVar.lx()).xr(jSONObject.toString());
            }
        }, "stats_url_report_rule");
    }

    public static Set<String> ms() {
        return x;
    }

    public static com.bytedance.sdk.component.xr.ms.ny xr() {
        return new com.bytedance.sdk.component.xr.ms.ny() { // from class: com.bytedance.sdk.openadsdk.core.nw.p.5
            @Override // com.bytedance.sdk.component.xr.ms.ny
            public com.bytedance.sdk.component.xr.ms.ao ms(com.bytedance.sdk.component.xr.ms.ny.ms msVar) throws IOException {
                String str;
                com.bytedance.sdk.component.xr.ms.ao aoVarMs = msVar.ms(msVar.ms());
                String str2 = "";
                final String strMs = aoVarMs.ms("csj-location-record", "");
                final String strMs2 = aoVarMs.ms("csj-source-from", "");
                final String strMs3 = aoVarMs.ms("csj-extra-info", "");
                if (aoVarMs.ah() == 8848) {
                    final String strKa = aoVarMs.ka();
                    com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.p.5.1
                        @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                        public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", strKa);
                            jSONObject.putOpt("sourceFrom", strMs2);
                            jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, strMs3);
                            return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("stats_net_block_url").xr(jSONObject.toString());
                        }
                    }, "stats_net_block_url");
                }
                int i = 0;
                try {
                    String[] strArrMs = p.ms(strMs);
                    if (strArrMs == null || strArrMs.length <= 1) {
                        str = "";
                    } else {
                        String str3 = strArrMs[0];
                        try {
                            str = strArrMs[strArrMs.length - 1];
                            str2 = str3;
                        } catch (Exception unused) {
                            str = "";
                            str2 = str3;
                        }
                    }
                    try {
                        i = Integer.parseInt(strMs2);
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str = "";
                }
                final String str4 = str2;
                final String str5 = str;
                if (TextUtils.isEmpty(strMs) || i == 0 || !TextUtils.isEmpty(p.xr(str4, p.d))) {
                    return aoVarMs;
                }
                com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.p.5.2
                    @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                    public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("url", strMs);
                        jSONObject.putOpt("sourceFrom", strMs2);
                        jSONObject.putOpt("sourceUrl", str4);
                        jSONObject.putOpt("destUrl", str5);
                        jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, strMs3);
                        return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("stats_net_locations_url").xr(jSONObject.toString());
                    }
                }, "stats_net_locations_url");
                return aoVarMs;
            }
        };
    }

    public static String[] ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}
