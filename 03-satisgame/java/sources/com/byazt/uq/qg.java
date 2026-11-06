package com.byazt.uq;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 26})
public final class qg {
    /* JADX WARN: Code duplicated, block: B:15:0x0045  */
    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    public static void n(com.byazt.zq.qg qgVar, boolean z, String str) {
        Boolean bool;
        String str2;
        String str3;
        int i;
        String str4;
        if (s.n() && !TextUtils.isEmpty(str) && z) {
            try {
                Activity activityN = n();
                Boolean bool2 = Boolean.FALSE;
                String str5 = null;
                if (activityN != null) {
                    String strW = q.w();
                    sz.n(activityN);
                    CharSequence title = activityN.getTitle();
                    String name = activityN.getClass().getName();
                    Boolean boolValueOf = Boolean.valueOf(activityN.hasWindowFocus());
                    if (title != null) {
                        String string = title.toString();
                        if (TextUtils.isEmpty(string)) {
                            bool = boolValueOf;
                            str2 = null;
                            str3 = name;
                            str5 = strW;
                        } else {
                            bool = boolValueOf;
                            str5 = strW;
                            str2 = string;
                            str3 = name;
                        }
                    } else {
                        bool = boolValueOf;
                        str2 = null;
                        str3 = name;
                        str5 = strW;
                    }
                } else {
                    bool = bool2;
                    str2 = null;
                    str3 = null;
                }
                int i2 = TextUtils.isEmpty(str5) ? 0 : 1;
                if (s.x() && TextUtils.isEmpty(str5)) {
                    String strN = fs.n();
                    if (TextUtils.isEmpty(strN)) {
                        i = i2;
                        str4 = str5;
                    } else {
                        i = 2;
                        str4 = strN;
                    }
                } else {
                    i = i2;
                    str4 = str5;
                }
                n.n(str, new n.C0367n(str2, str3, str4, bool, qgVar != null ? qgVar.oa() : " ", i));
            } catch (Throwable unused) {
            }
        }
    }

    public static void n(pk pkVar, String str) {
        if (pkVar == null || TextUtils.isEmpty(pkVar.hu()) || !s.n()) {
            return;
        }
        try {
            n.C0367n c0367nN = n.n(pkVar.hu());
            if (n(s.qg(), pkVar.hu())) {
                JSONObject jSONObject = new JSONObject();
                if (c0367nN != null) {
                    jSONObject.put("top_page_title", c0367nN.n);
                    jSONObject.put("top_page_name", c0367nN.qg);
                    jSONObject.put("t_name", c0367nN.s);
                    jSONObject.put("has_window_focus", c0367nN.q.booleanValue());
                    jSONObject.put("media_extra", c0367nN.l);
                    jSONObject.put("l_source", c0367nN.w);
                } else {
                    sz.n(jSONObject, (Activity) null);
                    if (TextUtils.isEmpty(jSONObject.optString("t_name"))) {
                        if (s.x()) {
                            String strN = fs.n();
                            jSONObject.put("t_name", strN);
                            jSONObject.put("l_source", TextUtils.isEmpty(strN) ? 0 : 2);
                        }
                    } else {
                        jSONObject.put("l_source", 1);
                    }
                    com.byazt.zq.qg qgVarXd = pkVar.xd();
                    if (qgVarXd != null) {
                        jSONObject.put("media_extra", !TextUtils.isEmpty(qgVarXd.oa()) ? qgVarXd.oa() : " ");
                    }
                }
                jSONObject.put("app_version", com.byazt.vgx.w.tj());
                jSONObject.put("app_no_tab", x.s());
                jSONObject.put("start2req_time", SystemClock.elapsedRealtime() - com.byazt.vyf.l.l);
                com.byazt.hm.n.qg(pkVar, str, "load_feature", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static void n(List<pk> list, String str) {
        n.C0367n c0367nQg;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str) || !s.n() || (c0367nQg = n.qg(str)) == null) {
            return;
        }
        Iterator<pk> it = list.iterator();
        while (it.hasNext()) {
            n(it.next(), c0367nQg);
        }
    }

    private static void n(pk pkVar, n.C0367n c0367n) {
        if (pkVar == null || c0367n == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("top_page_title", c0367n.n);
            jSONObject.put("top_page_name", c0367n.qg);
            jSONObject.put("t_name", c0367n.s);
            jSONObject.put("load_component_id", rv.n(com.byazt.vyf.s.cy().ou(), pkVar.xd() != null ? pkVar.xd().a() : 0, c0367n.qg, c0367n.s).n());
            pkVar.n(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void n(pk pkVar, String str, View view, boolean z) {
        if (pkVar == null || view == null || !s.n()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            sz.n(jSONObject, (Activity) null);
            n(pkVar, jSONObject);
            if (n(s.qg(), pkVar.hu())) {
                k.n(jSONObject, view, s.s());
                jSONObject.put("is_preload", z);
                jSONObject.put("app_version", com.byazt.vgx.w.tj());
                com.byazt.hm.n.qg(pkVar, str, "show_feature", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static void n(final pk pkVar, final String str, Activity activity, String str2, boolean z) {
        if (pkVar == null || !s.n()) {
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject();
            sz.n(jSONObject, activity);
            n(pkVar, jSONObject);
            if (n(s.qg(), pkVar.hu())) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = " ";
                }
                jSONObject.put("rit_scene", str2);
                jSONObject.put("is_preload", z);
                jSONObject.put("app_version", com.byazt.vgx.w.tj());
                com.byazt.ag.qg.n(new com.byazt.qit.x("stage_feature") { // from class: com.byazt.uq.qg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.byazt.hm.n.qg(pkVar, str, "show_feature", jSONObject);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private static void n(pk pkVar, JSONObject jSONObject) {
        try {
            oa.qg("step0/3 recordShowHistory,showExtra=" + (jSONObject != null ? jSONObject.toString() : AbstractJsonLexerKt.NULL));
            if (pkVar != null && jSONObject != null) {
                JSONObject jSONObjectN = pkVar.n();
                String strOptString = jSONObjectN != null ? jSONObjectN.optString("load_component_id", "") : "";
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = "unknown";
                }
                rv.n nVarN = rv.n(com.byazt.vyf.s.cy().ou(), pkVar.xd() != null ? pkVar.xd().a() : 0, jSONObject.optString("top_page_name", " "), jSONObject.optString("t_name", " "));
                cp.n(strOptString, nVarN.n(), nVarN.s, nVarN.q);
            }
        } catch (Throwable unused) {
        }
    }

    private static Activity n() {
        try {
            com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
            WeakReference<Activity> weakReferenceN = nVarS != null ? nVarS.n() : null;
            if (weakReferenceN != null) {
                return weakReferenceN.get();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean n(float f, String str) {
        if (f <= 0.0f) {
            return false;
        }
        if (f >= 1.0f) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((str != null ? str.hashCode() : (int) System.nanoTime()) & Integer.MAX_VALUE) % 1000000 < ((int) (f * 1000000.0f));
    }
}
