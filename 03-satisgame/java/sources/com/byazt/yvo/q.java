package com.byazt.yvo;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.byazt.bok.w;
import com.byazt.gct.pk;
import com.byazt.lk.l;
import com.byazt.nf.rv;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1177, 5})
public class q {
    public static String n = "tt_csj_node_line_detail";

    public static void n(String str, String str2) {
        qg(str2).n(str);
    }

    public static void n(String str, String str2, String str3) {
        qg(str3).n(str, str2);
    }

    public static void n(String str) {
        com.byazt.gwu.s sVarQg = qg(str);
        Map all = sVarQg.getAll();
        if (all == null || all.isEmpty()) {
            return;
        }
        all.size();
        for (String str2 : all.keySet()) {
            Object obj = all.get(str2);
            if (str2 != null && (str2.startsWith("key_tt_csj_node_line_") || str2.startsWith("key_tt_csj_other_node_line_"))) {
                if (obj instanceof String) {
                    s((String) obj, str);
                }
                sVarQg.n(str2);
            }
        }
    }

    private static com.byazt.gwu.s qg(String str) {
        return l.n(str, n);
    }

    private static JSONObject qg(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                com.byazt.gwu.s sVarQg = com.byazt.de.l.qg(str);
                if (sVarQg == null) {
                    return null;
                }
                String strQg = sVarQg.qg(n.n(a.C0017a.c) + str2, "");
                if (TextUtils.isEmpty(strQg)) {
                    return null;
                }
                return new JSONObject(strQg);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static void s(String str, String str2) {
        final String str3;
        JSONObject jSONObjectQg;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String strOptString = jSONObject.optString("node_line_name");
            final String strOptString2 = jSONObject.optString("lifecycle_id");
            final int iOptInt = jSONObject.optInt("video_type", -1);
            final int iOptInt2 = jSONObject.optInt("download_type", -1);
            final String strOptString3 = jSONObject.optString("ad_load_id");
            final String strOptString4 = jSONObject.optString("ad_show_id");
            final String strOptString5 = jSONObject.optString("node_line_version");
            final int iOptInt3 = jSONObject.optInt("unexpected_type");
            final int iOptInt4 = jSONObject.optInt("bidding_type");
            String strOptString6 = jSONObject.optString("node_line");
            final JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("node_line_detail");
            if (!"app_node_line".equals(strOptString) || TextUtils.isEmpty(strOptString6) || strOptString6.contains("0504") || jSONArrayOptJSONArray == null || (jSONObjectQg = qg(str2, strOptString2)) == null) {
                str3 = strOptString6;
            } else {
                jSONArrayOptJSONArray.put(jSONObjectQg);
                str3 = strOptString6 + "0504";
            }
            String strOptString7 = jSONObject.optString("creative_id");
            String strOptString8 = jSONObject.optString("req_id");
            String strOptString9 = jSONObject.optString("extra");
            int iOptInt5 = jSONObject.optInt("ad_type");
            String strOptString10 = jSONObject.optString("rit");
            String strOptString11 = jSONObject.optString("ad_info");
            jSONObject.optLong("ts");
            final boolean zOptBoolean = jSONObject.optBoolean("need_node_line_detail");
            final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("key_element_info");
            final JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("no_action_array");
            final JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("motion_info");
            final JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("ad_user_interact_data");
            final int iOptInt6 = jSONObject.optInt("has_send_show_event", 0);
            final int iOptInt7 = jSONObject.optInt("has_send_click_event", 0);
            final int iOptInt8 = jSONObject.optInt("send_show_event_result", 0);
            final int iOptInt9 = jSONObject.optInt("send_click_event_result", 0);
            final int iOptInt10 = jSONObject.optInt("has_media_cache_action", 0);
            final int iOptInt11 = jSONObject.optInt("media_height_price_show", 0);
            final String strOptString12 = jSONObject.optString("style_id");
            final int iOptInt12 = jSONObject.optInt("style_category");
            final int iOptInt13 = jSONObject.optInt("component_type");
            final int iOptInt14 = jSONObject.optInt("render_sequence");
            final int iOptInt15 = jSONObject.optInt("display_area");
            final JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("container_rect");
            final JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("image_rect");
            final JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("video_rect");
            final int iOptInt16 = jSONObject.optInt("image_mode");
            com.byazt.eji.s.n().n(strOptString, strOptString10, strOptString7, strOptString8, iOptInt5, null, strOptString9, strOptString11, null, 0, new com.byazt.rs.n() { // from class: com.byazt.yvo.q.1
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        if (!TextUtils.isEmpty(strOptString2)) {
                            jSONObject3.putOpt("lifecycle_id", strOptString2);
                        }
                        if (!TextUtils.isEmpty(strOptString3)) {
                            jSONObject3.putOpt("ad_load_id", strOptString3);
                        }
                        if (!TextUtils.isEmpty(strOptString4)) {
                            jSONObject3.putOpt("ad_show_id", strOptString4);
                        }
                        int i = iOptInt;
                        if (i > 0) {
                            jSONObject3.putOpt("video_type", Integer.valueOf(i));
                        }
                        int i2 = iOptInt2;
                        if (i2 > 0) {
                            jSONObject3.putOpt("download_type", Integer.valueOf(i2));
                        }
                        jSONObject3.putOpt("key_element_info", jSONObjectOptJSONObject);
                        jSONObject3.putOpt("no_action_array", jSONArrayOptJSONArray2);
                        jSONObject3.putOpt("motion_info", jSONObjectOptJSONObject2);
                        jSONObject3.putOpt("ad_user_interact_data", jSONObjectOptJSONObject3);
                        jSONObject3.putOpt("bidding_type", Integer.valueOf(iOptInt4));
                        jSONObject3.putOpt("is_from_cache", 1);
                        jSONObject3.putOpt("node_line_version", strOptString5);
                        jSONObject3.putOpt("unexpected_type", Integer.valueOf(iOptInt3));
                        jSONObject3.putOpt("node_line", str3);
                        if (zOptBoolean) {
                            jSONObject3.putOpt("node_line_detail", jSONArrayOptJSONArray);
                        }
                        if ("ad_node_line".equals(strOptString)) {
                            jSONObject3.putOpt("has_send_show_event", Integer.valueOf(iOptInt6));
                            jSONObject3.putOpt("has_send_click_event", Integer.valueOf(iOptInt7));
                            jSONObject3.putOpt("send_show_event_result", Integer.valueOf(iOptInt8));
                            jSONObject3.putOpt("send_click_event_result", Integer.valueOf(iOptInt9));
                            jSONObject3.putOpt("has_media_cache_action", Integer.valueOf(iOptInt10));
                            jSONObject3.putOpt("media_height_price_show", Integer.valueOf(iOptInt11));
                        }
                        if ("easy_play_node_line".equals(strOptString)) {
                            if (!TextUtils.isEmpty(strOptString12)) {
                                jSONObject3.putOpt("style_id", strOptString12);
                            }
                            jSONObject3.putOpt("style_category", Integer.valueOf(iOptInt12));
                            jSONObject3.putOpt("component_type", Integer.valueOf(iOptInt13));
                            jSONObject3.putOpt("render_sequence", Integer.valueOf(iOptInt14));
                            jSONObject3.putOpt("display_area", Integer.valueOf(iOptInt15));
                        }
                        if ("view_node_line".equals(strOptString)) {
                            jSONObject3.putOpt("container_rect", jSONObjectOptJSONObject4);
                            jSONObject3.putOpt("image_rect", jSONObjectOptJSONObject5);
                            jSONObject3.putOpt("video_rect", jSONObjectOptJSONObject6);
                            int i3 = iOptInt16;
                            if (i3 > 0) {
                                jSONObject3.putOpt("image_mode", Integer.valueOf(i3));
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONObject3;
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void n(final List<qg> list, final com.byazt.wea.n nVar, final String str, final JSONObject jSONObject) {
        if (nVar == null || jSONObject == null) {
            return;
        }
        com.byazt.eji.s.n().n(str, nVar.s, nVar.q.q(), nVar.q.ou(), nVar.n, null, nVar.q.F_(), nVar.q.yk(), null, 0, new com.byazt.rs.n() { // from class: com.byazt.yvo.q.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                boolean zYx = rv.qg().yx();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    com.byazt.wea.n nVar2 = nVar;
                    jSONObject3.putOpt("bidding_type", Integer.valueOf(nVar2 != null ? q.n(nVar2.q) : 0));
                    jSONObject.putOpt("node_line_version", "1.0.0");
                    jSONObject.putOpt("unexpected_type", Integer.valueOf(nVar.l));
                    jSONObject.putOpt("node_line", q.n((List<qg>) list));
                    if ("ad_node_line".equals(str) && nVar.q != null) {
                        jSONObject.putOpt("has_media_cache_action", Integer.valueOf(nVar.q.jh()));
                        jSONObject.putOpt("media_height_price_show", Integer.valueOf(nVar.q.xb()));
                    }
                    if (zYx) {
                        jSONObject.putOpt("node_line_detail", q.qg((List<qg>) list));
                    }
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static String n(List<qg> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<qg> it = list.iterator();
        while (it.hasNext()) {
            sb.append(n(it.next()));
        }
        return sb.toString();
    }

    public static String n(qg qgVar) {
        if (qgVar == null) {
            return "";
        }
        if ("ad_load".equals(qgVar.qg())) {
            return qg(qgVar);
        }
        if ("ad_show".equals(qgVar.qg())) {
            return s(qgVar);
        }
        if (MediaFormat.KEY_VIDEO.equals(qgVar.qg())) {
            return q(qgVar);
        }
        if ("download".equals(qgVar.qg())) {
            return l(qgVar);
        }
        if (a.C0017a.c.equals(qgVar.qg())) {
            return w(qgVar);
        }
        if ("view".equals(qgVar.qg())) {
            return x(qgVar);
        }
        return "easy_play".equals(qgVar.qg()) ? fs(qgVar) : "";
    }

    private static String qg(qg qgVar) {
        if (qgVar == null) {
            return "";
        }
        String strN = qgVar.n();
        strN.hashCode();
        switch (strN) {
            case "started":
                return "0101";
            case "loaded":
                return "0104";
            case "received":
                return "0103";
            case "reqed":
                return "0102";
            default:
                return "";
        }
    }

    private static String s(qg qgVar) {
        if (qgVar == null) {
            return "";
        }
        String strN = qgVar.n();
        strN.hashCode();
        switch (strN) {
            case "started":
                return "0202";
            case "showed":
                return "0203";
            case "end":
                return "0205";
            case "clicked":
                return "0204";
            case "created":
                return "0201";
            case "invisibled":
                return "0207";
            case "visibled":
                return "0206";
            default:
                return "";
        }
    }

    private static String q(qg qgVar) {
        if (qgVar == null) {
            return "";
        }
        String strN = qgVar.n();
        strN.hashCode();
        switch (strN) {
            case "started":
                return "0303";
            case "stopped":
                return "0308";
            case "buffered":
                return "0306";
            case "completed":
                return "0309";
            case "prepared":
                return "0304";
            case "paused":
                return "0307";
            case "played":
                return "0305";
            case "end":
                return "0310";
            case "created":
                return "0301";
            case "initialized":
                return "0302";
            default:
                return "";
        }
    }

    private static String l(qg qgVar) {
        if (qgVar == null) {
            return "";
        }
        String strN = qgVar.n();
        strN.hashCode();
        switch (strN) {
            case "started":
                return "0402";
            case "market_closed":
                return "0404";
            case "download_finished":
                return "0409";
            case "market_opened":
                return "0403";
            case "download_canceled":
                return "0408";
            case "download_started":
                return "0405";
            case "end":
                return "0410";
            case "download_failed":
                return "0407";
            case "download_paused":
                return "0406";
            case "created":
                return "0401";
            default:
                return "";
        }
    }

    private static String w(qg qgVar) {
        if (qgVar == null) {
            return "";
        }
        String strN = qgVar.n();
        strN.hashCode();
        switch (strN) {
            case "started":
                return "0501";
            case "backgrounded":
                return "0503";
            case "end":
                return "0504";
            case "foregrounded":
                return "0502";
            default:
                return "";
        }
    }

    private static String x(qg qgVar) {
        if (qgVar == null) {
            return "";
        }
        String strN = qgVar.n();
        strN.hashCode();
        switch (strN) {
            case "focused":
                return "0603";
            case "end":
                return "0607";
            case "attached":
                return "0602";
            case "created":
                return "0601";
            case "detached":
                return "0606";
            case "invisibled":
                return "0605";
            case "visibled":
                return "0604";
            default:
                return "";
        }
    }

    private static String fs(qg qgVar) {
        if (qgVar == null) {
            return "";
        }
        String strN = qgVar.n();
        strN.hashCode();
        switch (strN) {
            case "started":
                return "0702";
            case "render_started":
                return "0704";
            case "loaded":
                return "0703";
            case "showed":
                return "0706";
            case "rendered":
                return "0705";
            case "end":
                return "0708";
            case "clicked":
                return "0707";
            case "created":
                return "0701";
            default:
                return "";
        }
    }

    public static JSONArray qg(List<qg> list) {
        JSONArray jSONArray = new JSONArray();
        for (qg qgVar : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("l_type", qgVar.qg());
                jSONObject.putOpt("type", qgVar.n());
                jSONObject.putOpt("ts", Long.valueOf(qgVar.s()));
                if (qgVar.q() >= 0) {
                    jSONObject.putOpt("source", Integer.valueOf(qgVar.q()));
                }
                if (qgVar.l() >= 0 && "showed".equals(qgVar.n())) {
                    boolean z = true;
                    if (qgVar.l() != 1) {
                        z = false;
                    }
                    jSONObject.putOpt("create_show_tracker", Boolean.valueOf(z));
                }
            } catch (Throwable unused) {
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static int n(pk pkVar) {
        if (pkVar == null) {
            return 0;
        }
        try {
            Map<String, Object> mapWl = pkVar.wl();
            if (mapWl == null) {
                return 0;
            }
            Object obj = mapWl.get("sdk_bidding_type");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static void n(final JSONObject jSONObject, com.byazt.wea.n nVar, final List<qg> list, final String str) {
        if (jSONObject == null || nVar == null || list == null) {
            return;
        }
        final int i = nVar.l;
        final int iN = n(nVar.q);
        final boolean zYx = rv.qg().yx();
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        final String strN = nVar.n();
        final String strQg = nVar.qg();
        final int i2 = nVar.n;
        final String str2 = nVar.s;
        final String strQ = nVar.q != null ? nVar.q.q() : null;
        final String strOu = nVar.q != null ? nVar.q.ou() : null;
        final String strF_ = nVar.q != null ? nVar.q.F_() : null;
        final String strYk = nVar.q != null ? nVar.q.yk() : null;
        com.byazt.ag.qg.l(new Runnable() { // from class: com.byazt.yvo.q.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    jSONObject.putOpt("node_line_version", "1.0.0");
                    jSONObject.putOpt("unexpected_type", Integer.valueOf(i));
                    jSONObject.putOpt("bidding_type", Integer.valueOf(iN));
                    jSONObject.putOpt("node_line", q.n((List<qg>) list));
                    if (zYx) {
                        jSONObject.putOpt("node_line_detail", q.qg((List<qg>) list));
                    }
                    jSONObject.putOpt("creative_id", strQ);
                    jSONObject.putOpt("req_id", strOu);
                    jSONObject.putOpt("extra", strF_);
                    jSONObject.putOpt("ad_info", strYk);
                    jSONObject.putOpt("ad_type", Integer.valueOf(i2));
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.putOpt("rit", str2);
                    }
                    jSONObject.putOpt("ts", Long.valueOf(jCurrentTimeMillis));
                    jSONObject.putOpt("need_node_line_detail", Boolean.valueOf(zYx));
                    q.n(n.n(str) + strN, jSONObject.toString(), strQg);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static int n(w wVar) {
        if (wVar == null) {
            return 0;
        }
        Object objN = wVar.n("source");
        if (objN instanceof Integer) {
            return ((Integer) objN).intValue();
        }
        return 0;
    }
}
