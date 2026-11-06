package com.byazt.mn;

import android.text.TextUtils;
import com.byazt.ewt.zo;
import com.byazt.hg.of;
import com.byazt.qd.c;
import com.byazt.sd.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 403, 121})
public class x {
    public static String pr = "tt_csj_node_line_detail";

    public static void pr(String str, String str2) {
        hw(str2).pr(str);
    }

    public static void pr(String str, String str2, String str3) {
        hw(str3).pr(str, str2);
    }

    public static void pr(String str) {
        com.byazt.zq.hn hnVarHw = hw(str);
        Map all = hnVarHw.getAll();
        if (all == null || all.isEmpty()) {
            return;
        }
        all.size();
        for (String str2 : all.keySet()) {
            Object obj = all.get(str2);
            if (str2 != null && (str2.startsWith("key_tt_csj_node_line_") || str2.startsWith("key_tt_csj_other_node_line_"))) {
                if (obj instanceof String) {
                    hn((String) obj, str);
                }
                hnVarHw.pr(str2);
            }
        }
    }

    private static com.byazt.zq.hn hw(String str) {
        return com.byazt.qn.x.pr(str, pr);
    }

    private static JSONObject hw(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.byazt.zq.hn hnVarHw = c.hw(str);
            if (hnVarHw == null) {
                return null;
            }
            String strHw = hnVarHw.hw(pr.pr("app") + str2, "");
            if (TextUtils.isEmpty(strHw)) {
                return null;
            }
            return new JSONObject(strHw);
        } catch (Throwable th) {
            return null;
        }
    }

    private static void hn(String str, String str2) {
        final String str3;
        JSONObject jSONObjectHw;
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
            if ("app_node_line".equals(strOptString) && !TextUtils.isEmpty(strOptString6) && !strOptString6.contains("0504") && jSONArrayOptJSONArray != null && (jSONObjectHw = hw(str2, strOptString2)) != null) {
                jSONArrayOptJSONArray.put(jSONObjectHw);
                str3 = strOptString6 + "0504";
            } else {
                str3 = strOptString6;
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
            final String strOptString12 = jSONObject.optString("style_id");
            final int iOptInt10 = jSONObject.optInt("style_category");
            final int iOptInt11 = jSONObject.optInt("component_type");
            final int iOptInt12 = jSONObject.optInt("render_sequence");
            final int iOptInt13 = jSONObject.optInt("display_area");
            final JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("container_rect");
            final JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("image_rect");
            final JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("video_rect");
            final int iOptInt14 = jSONObject.optInt("image_mode");
            com.byazt.xk.hw.pr().pr(strOptString, strOptString10, strOptString7, strOptString8, iOptInt5, null, strOptString9, strOptString11, null, 0, new com.byazt.ttf.pr() { // from class: com.byazt.mn.x.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject2) throws JSONException {
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
                        }
                        if ("easy_play_node_line".equals(strOptString)) {
                            if (!TextUtils.isEmpty(strOptString12)) {
                                jSONObject3.putOpt("style_id", strOptString12);
                            }
                            jSONObject3.putOpt("style_category", Integer.valueOf(iOptInt10));
                            jSONObject3.putOpt("component_type", Integer.valueOf(iOptInt11));
                            jSONObject3.putOpt("render_sequence", Integer.valueOf(iOptInt12));
                            jSONObject3.putOpt("display_area", Integer.valueOf(iOptInt13));
                        }
                        if ("view_node_line".equals(strOptString)) {
                            jSONObject3.putOpt("container_rect", jSONObjectOptJSONObject4);
                            jSONObject3.putOpt("image_rect", jSONObjectOptJSONObject5);
                            jSONObject3.putOpt("video_rect", jSONObjectOptJSONObject6);
                            int i3 = iOptInt14;
                            if (i3 > 0) {
                                jSONObject3.putOpt("image_mode", Integer.valueOf(i3));
                            }
                        }
                    } catch (Throwable th) {
                    }
                    return jSONObject3;
                }
            });
        } catch (Throwable th) {
        }
    }

    public static void pr(final List<hw> list, final com.byazt.ewt.pr prVar, String str, final JSONObject jSONObject) {
        if (prVar == null || jSONObject == null) {
            return;
        }
        com.byazt.xk.hw.pr().pr(str, prVar.g, prVar.ho.x(), prVar.ho.ny(), prVar.k, null, prVar.ho.B_(), prVar.ho.td(), null, 0, new com.byazt.ttf.pr() { // from class: com.byazt.mn.x.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                boolean zSb = a.hw().sb();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    com.byazt.ewt.pr prVar2 = prVar;
                    jSONObject3.putOpt("bidding_type", Integer.valueOf(prVar2 != null ? x.pr(prVar2.ho) : 0));
                    jSONObject.putOpt("node_line_version", "1.0.0");
                    jSONObject.putOpt("unexpected_type", Integer.valueOf(prVar.nt));
                    jSONObject.putOpt("node_line", x.pr((List<hw>) list));
                    if (zSb) {
                        jSONObject.putOpt("node_line_detail", x.hw((List<hw>) list));
                    }
                } catch (Throwable th) {
                }
                return jSONObject;
            }
        });
    }

    public static String pr(List<hw> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<hw> it = list.iterator();
        while (it.hasNext()) {
            sb.append(pr(it.next()));
        }
        return sb.toString();
    }

    public static String pr(hw hwVar) {
        if (hwVar == null) {
            return "";
        }
        if ("ad_load".equals(hwVar.hw())) {
            return hw(hwVar);
        }
        if ("ad_show".equals(hwVar.hw())) {
            return hn(hwVar);
        }
        if ("video".equals(hwVar.hw())) {
            return x(hwVar);
        }
        if ("download".equals(hwVar.hw())) {
            return c(hwVar);
        }
        if ("app".equals(hwVar.hw())) {
            return uc(hwVar);
        }
        if ("view".equals(hwVar.hw())) {
            return fw(hwVar);
        }
        if (!"easy_play".equals(hwVar.hw())) {
            return "";
        }
        return zo(hwVar);
    }

    private static String hw(hw hwVar) {
        if (hwVar == null) {
            return "";
        }
        switch (hwVar.pr()) {
            case "started":
                return "0101";
            case "reqed":
                return "0102";
            case "received":
                return "0103";
            case "loaded":
                return "0104";
            default:
                return "";
        }
    }

    private static String hn(hw hwVar) {
        if (hwVar == null) {
            return "";
        }
        switch (hwVar.pr()) {
            case "created":
                return "0201";
            case "started":
                return "0202";
            case "showed":
                return "0203";
            case "clicked":
                return "0204";
            case "end":
                return "0205";
            case "visibled":
                return "0206";
            case "invisibled":
                return "0207";
            default:
                return "";
        }
    }

    private static String x(hw hwVar) {
        if (hwVar == null) {
            return "";
        }
        switch (hwVar.pr()) {
            case "created":
                return "0301";
            case "initialized":
                return "0302";
            case "started":
                return "0303";
            case "prepared":
                return "0304";
            case "played":
                return "0305";
            case "buffered":
                return "0306";
            case "paused":
                return "0307";
            case "stopped":
                return "0308";
            case "completed":
                return "0309";
            case "end":
                return "0310";
            default:
                return "";
        }
    }

    private static String c(hw hwVar) {
        if (hwVar == null) {
            return "";
        }
        switch (hwVar.pr()) {
            case "created":
                return "0401";
            case "started":
                return "0402";
            case "market_opened":
                return "0403";
            case "market_closed":
                return "0404";
            case "download_started":
                return "0405";
            case "download_paused":
                return "0406";
            case "download_failed":
                return "0407";
            case "download_canceled":
                return "0408";
            case "download_finished":
                return "0409";
            case "end":
                return "0410";
            default:
                return "";
        }
    }

    private static String uc(hw hwVar) {
        if (hwVar == null) {
            return "";
        }
        switch (hwVar.pr()) {
            case "started":
                return "0501";
            case "foregrounded":
                return "0502";
            case "backgrounded":
                return "0503";
            case "end":
                return "0504";
            default:
                return "";
        }
    }

    private static String fw(hw hwVar) {
        if (hwVar == null) {
            return "";
        }
        switch (hwVar.pr()) {
            case "created":
                return "0601";
            case "attached":
                return "0602";
            case "focused":
                return "0603";
            case "visibled":
                return "0604";
            case "invisibled":
                return "0605";
            case "detached":
                return "0606";
            case "end":
                return "0607";
            default:
                return "";
        }
    }

    private static String zo(hw hwVar) {
        if (hwVar == null) {
            return "";
        }
        switch (hwVar.pr()) {
            case "created":
                return "0701";
            case "started":
                return "0702";
            case "loaded":
                return "0703";
            case "render_started":
                return "0704";
            case "rendered":
                return "0705";
            case "showed":
                return "0706";
            case "clicked":
                return "0707";
            case "end":
                return "0708";
            default:
                return "";
        }
    }

    public static JSONArray hw(List<hw> list) {
        JSONArray jSONArray = new JSONArray();
        for (hw hwVar : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("l_type", hwVar.hw());
                jSONObject.putOpt("type", hwVar.pr());
                jSONObject.putOpt("ts", Long.valueOf(hwVar.hn()));
                if (hwVar.x() >= 0) {
                    jSONObject.putOpt("source", Integer.valueOf(hwVar.x()));
                }
                if (hwVar.c() >= 0 && "showed".equals(hwVar.pr())) {
                    boolean z = true;
                    if (hwVar.c() != 1) {
                        z = false;
                    }
                    jSONObject.putOpt("create_show_tracker", Boolean.valueOf(z));
                }
            } catch (Throwable th) {
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static int pr(of ofVar) {
        if (ofVar == null) {
            return 0;
        }
        try {
            Map<String, Object> mapZc = ofVar.zc();
            if (mapZc == null) {
                return 0;
            }
            Object obj = mapZc.get("sdk_bidding_type");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    public static void pr(JSONObject jSONObject, com.byazt.ewt.pr prVar, List<hw> list, String str) {
        if (jSONObject == null || prVar == null || list == null) {
            return;
        }
        try {
            jSONObject.putOpt("node_line_version", "1.0.0");
            jSONObject.putOpt("unexpected_type", Integer.valueOf(prVar.nt));
            jSONObject.putOpt("bidding_type", Integer.valueOf(pr(prVar.ho)));
            jSONObject.putOpt("node_line", pr(list));
            jSONObject.putOpt("node_line_detail", hw(list));
            if (prVar.ho != null) {
                jSONObject.putOpt("creative_id", prVar.ho.x());
                jSONObject.putOpt("req_id", prVar.ho.ny());
                jSONObject.putOpt("extra", prVar.ho.B_());
                jSONObject.putOpt("ad_info", prVar.ho.td());
            }
            jSONObject.putOpt("ad_type", Integer.valueOf(prVar.k));
            if (!TextUtils.isEmpty(prVar.g)) {
                jSONObject.putOpt("rit", prVar.g);
            }
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            jSONObject.putOpt("need_node_line_detail", Boolean.valueOf(a.hw().sb()));
            pr(pr.pr(str) + prVar.hw(), jSONObject.toString(), prVar.hn());
        } catch (Throwable th) {
        }
    }

    public static int pr(zo zoVar) {
        if (zoVar == null) {
            return 0;
        }
        Object objPr = zoVar.pr("source");
        if (!(objPr instanceof Integer)) {
            return 0;
        }
        return ((Integer) objPr).intValue();
    }
}
