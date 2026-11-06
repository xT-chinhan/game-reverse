package com.byazt.jp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj {
    public static Context n = null;
    public static long q = -1;
    public static n qg = null;
    public static long s = -1;

    public static void n(final Activity activity, final List<oa> list, final int i, final int i2) {
        n(new cy() { // from class: com.byazt.jp.tj.1
            @Override // com.byazt.jp.cy
            public void n() {
                com.byazt.qa.q.n().n(activity, list, i, i2);
            }
        });
    }

    public static void n(cy cyVar) {
        com.byazt.qt.qg.n().n(cyVar);
    }

    public static boolean n() {
        if (TextUtils.isEmpty(com.byazt.qt.n.d().oa())) {
            return false;
        }
        return com.byazt.qt.qg.n().pk();
    }

    public static void n(Context context, n nVar) {
        if (s == -1) {
            s = System.currentTimeMillis();
            if (nVar != null && nVar.s()) {
                com.byazt.rb.qg.n();
            }
            com.byazt.rb.qg.qg("TMe", "call init time " + s);
            n = context;
            qg = nVar;
        }
    }

    public static long qg() {
        return s;
    }

    public static long s() {
        return q;
    }

    public static void n(JSONObject jSONObject) {
        if (n == null || qg == null) {
            return;
        }
        if (q == -1) {
            q = System.currentTimeMillis();
            com.byazt.rb.qg.qg("TMe", "call start up time " + q);
        }
        n(n, qg, jSONObject);
        com.byazt.it.q.qg();
    }

    private static void n(Context context, n nVar, JSONObject jSONObject) {
        com.byazt.qt.n.d().s(nVar.n());
        com.byazt.qt.n.d().s(nVar.k());
        com.byazt.gi.n.n().w();
        com.byazt.it.s.n(nVar, context.getApplicationContext(), jSONObject);
        com.byazt.gi.n.n().x();
    }

    public static void n(w wVar) {
        com.byazt.qt.n.d().n(wVar, false);
    }

    public static void n(String str) {
        com.byazt.rb.qg.n(MediationConstant.TAG, "app运行中setPulisherDid: ".concat(String.valueOf(str)));
        com.byazt.qt.n.d().q(str);
    }

    public static void n(com.byazt.zq.q qVar) {
        com.byazt.qt.n.d().qg().qg(com.byazt.ya.l.n(qVar));
        com.byazt.qt.n.d().wm();
        com.byazt.it.s.n(com.byazt.ya.l.n(qVar));
    }

    public static void n(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 3);
        if (context != null) {
            com.byazt.vy.s.n(context, intent, null);
        }
    }

    public static void n(Context context, int[] iArr) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 1);
        intent.putExtra("permissions", iArr);
        if (context != null) {
            com.byazt.vy.s.n(context, intent, null);
        }
    }

    public static String q() {
        return com.byazt.sg.qg.n();
    }

    public static void n(int i) {
        HashMap map = new HashMap();
        map.put(com.byazt.ju.n.l, Integer.valueOf(i));
        Map<String, com.byazt.ju.q> mapQg = com.byazt.ya.qg.n().qg();
        if (mapQg == null || mapQg.size() == 0) {
            return;
        }
        for (com.byazt.ju.q qVar : com.byazt.ya.qg.n().s()) {
            if (qVar != null) {
                qVar.n(map);
            }
        }
    }

    public static int n(s sVar) {
        com.byazt.ju.q qVarN = com.byazt.ya.qg.n().n(MediationConstant.ADN_GDT);
        if (qVarN == null) {
            return 0;
        }
        return qVarN.n(sVar);
    }

    public static boolean l() {
        return com.byazt.qt.n.d().k();
    }

    public static void qg(String str) {
        com.byazt.qt.n.d().l(str);
    }

    public static String w() {
        return com.byazt.qt.n.d().cy();
    }

    public static Map<String, String> x() {
        return com.byazt.qt.n.d().hd();
    }

    public static boolean fs() {
        return com.byazt.vyf.s.cy().sh();
    }

    public static String s(String str) {
        str.hashCode();
        switch (str) {
            case "tt_pangle_preview_ext":
                return com.byazt.nc.q.s();
            case "tt_pangle_preview_creative_id":
                return com.byazt.nc.q.qg();
            case "tt_pangle_preview_ad_id":
                return com.byazt.nc.q.n();
            default:
                return null;
        }
    }

    public static String rv() {
        return com.byazt.qt.n.d().um();
    }

    public static String tj() {
        return com.byazt.qt.n.d().oa();
    }

    public static String cp() {
        return ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).n(false);
    }

    public static boolean n(String str, String str2) {
        return com.byazt.it.n.n(str, str2);
    }

    public static boolean qg(String str, String str2) {
        return com.byazt.it.n.qg(str, str2);
    }

    @Deprecated
    public static boolean q(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(com.byazt.qt.n.d().oa())) {
            return false;
        }
        return com.byazt.qt.qg.n().s(str);
    }

    @Deprecated
    public static com.byazt.sbw.n l(String str) {
        return com.byazt.ya.n.n(str);
    }

    @Deprecated
    public static com.byazt.ju.q w(String str) {
        return com.byazt.ya.qg.n().n(str);
    }

    @Deprecated
    public static void qg(int i) {
        com.byazt.qt.qg.n().s(i);
    }

    @Deprecated
    public static void d() {
        com.byazt.qt.qg.n().s(com.byazt.ri.n.n().qg("if_test", 0));
    }

    public static Map<String, Object> oa() {
        return com.byazt.qt.n.d().j();
    }

    public static void n(com.byazt.vv.n nVar) {
        if (!com.byazt.it.s.qg()) {
            com.byazt.qt.n.d().n(nVar);
        } else if (nVar != null) {
            nVar.n();
        }
    }
}
