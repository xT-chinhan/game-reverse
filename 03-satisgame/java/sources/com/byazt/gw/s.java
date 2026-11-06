package com.byazt.gw;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.ho.BaseConstants;
import com.byazt.shr.cp;
import com.byazt.shr.cy;
import com.byazt.shr.d;
import com.byazt.shr.fs;
import com.byazt.shr.hd;
import com.byazt.shr.k;
import com.byazt.shr.oa;
import com.byazt.shr.rv;
import com.byazt.shr.sz;
import com.byazt.shr.um;
import com.byazt.shr.x;
import com.byazt.vgx.w;
import com.byazt.zsl.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, 8})
public class s {
    public static final Map<com.byazt.kb.n, um> n = Collections.synchronizedMap(new WeakHashMap());

    public static JSONObject n(l lVar, String str, int i, int i2, pk pkVar, long j) {
        com.byazt.ej.l lVarLn;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f.bo, str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (com.byazt.ql.s.n(pkVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (lVar != null) {
                if (com.byazt.gks.n.n(pkVar)) {
                    jSONObject.put("codec", pkVar.u());
                    lVarLn = null;
                } else if (lVar.a()) {
                    lVarLn = lVar.lh();
                    jSONObject.put("codec", "h265");
                } else {
                    lVarLn = lVar.ln();
                }
                if (lVarLn != null) {
                    jSONObject.put("video_resolution", lVarLn.rv());
                    jSONObject.put("video_size", Long.valueOf(lVarLn.l()));
                    String strD = lVarLn.d();
                    jSONObject.put("video_url", strD);
                    jSONObject.put("is_expired", w.sz(strD));
                    jSONObject.put("send_duration", Math.floor(System.currentTimeMillis() - (w.um(pkVar) * 1000.0d)));
                    jSONObject.put("start_duration", j);
                    jSONObject.put("player_type", i2);
                    jSONObject.put("play_speed_ratio", lVarLn.fs());
                    if (lVarLn.x() > 0.0d) {
                        jSONObject.put("start", lVarLn.x());
                    }
                }
            }
            if (pkVar != null) {
                jSONObject.put("dynamic_join_type", pkVar.ds());
                String strPk = pkVar.pk();
                if (!TextUtils.isEmpty(strPk)) {
                    jSONObject.put("union_template_id", new JSONObject(strPk).optString("template_id"));
                }
                if (com.byazt.aci.n.q(pkVar) || com.byazt.aci.n.n(pkVar)) {
                    String strRv = com.byazt.aci.n.rv(pkVar);
                    if (com.byazt.ts.qg.n().n(strRv)) {
                        jSONObject.put("simple_uttie_url", strRv);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void n(com.byazt.shr.qg<oa> qgVar) {
        qg(qgVar, "load_video_start");
    }

    public static void qg(com.byazt.shr.qg<sz> qgVar) {
        qg(qgVar, "load_video_success");
    }

    public static void s(com.byazt.shr.qg<d> qgVar) {
        qg(qgVar, "load_video_error");
    }

    public static void q(com.byazt.shr.qg<cp> qgVar) {
        qg(qgVar, "load_video_cancel");
    }

    public static int n(pk pkVar, l lVar, long j) {
        int iIo = pkVar.io();
        com.byazt.ej.n nVarN = com.byazt.ql.qg.n(iIo);
        if (iIo != 0) {
            if (iIo == 1) {
                return nVarN.n(lVar) ? 1 : 2;
            }
            return 3;
        }
        boolean zHd = lVar.hd();
        int iX = lVar.x();
        long jCy = lVar.cy();
        if (zHd) {
            iX = (int) jCy;
        }
        boolean z = j >= ((long) iX);
        boolean z2 = j >= jCy;
        if (j == 0) {
            return 2;
        }
        if (z2) {
            return 4;
        }
        return (!z || iX == 0) ? 1 : 5;
    }

    public static String n() {
        return UUID.randomUUID().toString();
    }

    public static void n(final pk pkVar, final com.byazt.kb.n nVar, final l lVar, final boolean z, final String str) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.1
            @Override // java.lang.Runnable
            public void run() {
                pk pkVar2 = pkVar;
                if (pkVar2 == null || nVar == null || lVar == null) {
                    return;
                }
                long jQg = com.byazt.ql.qg.n(pkVar2.io()).qg(lVar);
                int iN = s.n(pkVar, lVar, jQg);
                s.n.put(nVar, new um(SystemClock.elapsedRealtime(), str, iN, lVar, pkVar));
                hd hdVar = new hd();
                if (jQg > 0) {
                    hdVar.n(jQg);
                }
                hdVar.n(z);
                l lVar2 = lVar;
                JSONObject jSONObjectN = s.n(lVar2, str, iN, lVar2.m(), pkVar, 0L);
                s.n(jSONObjectN, lVar.l("EXTRA_PLAY_START"));
                com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVar, w.qg(pkVar), jSONObjectN, hdVar);
                qgVar.n(lVar.m() == -1);
                s.qg(qgVar, "play_start");
            }
        });
    }

    public static void n(final com.byazt.kb.n nVar, final um.n nVar2) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.4
            @Override // java.lang.Runnable
            public void run() {
                um umVar;
                if (nVar == null || nVar2 == null || (umVar = (um) s.n.get(nVar)) == null) {
                    return;
                }
                l lVarQ = umVar.q();
                pk pkVarL = umVar.l();
                if (lVarQ == null || pkVarL == null) {
                    return;
                }
                if (!com.byazt.ql.s.n(pkVarL) || cd.qg(pkVarL)) {
                    if (!nVar2.k()) {
                        s.qg(pkVarL, lVarQ, nVar2);
                    }
                    rv rvVar = new rv();
                    rvVar.qg(nVar2.cy() ? 1 : 0);
                    rvVar.n(nVar2.hd() ? 1 : 0);
                    rvVar.qg(com.byazt.ql.qg.n(pkVarL.io()).qg(lVarQ));
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - umVar.n();
                    rvVar.n(jElapsedRealtime);
                    JSONObject jSONObjectN = s.n(lVarQ, umVar.qg(), umVar.s(), lVarQ.m(), pkVarL, jElapsedRealtime);
                    s.n(jSONObjectN, lVarQ.l("EXTRA_PLAY_START"));
                    com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVarL, w.qg(pkVarL), jSONObjectN, rvVar);
                    qgVar.n(nVar2.k());
                    s.qg(qgVar, s.qg(pkVarL, "feed_play"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(pk pkVar, String str) {
        if (pkVar == null || !w.rv(pkVar) || !w.tj(pkVar)) {
            return str;
        }
        str.hashCode();
        switch (str) {
            case "feed_over":
                return "play_over";
            case "feed_play":
                return "play";
            case "feed_break":
                return "play_break";
            default:
                return str;
        }
    }

    public static String n(com.byazt.kb.n nVar) {
        um umVar;
        if (nVar == null || (umVar = n.get(nVar)) == null) {
            return "empty";
        }
        String strQg = umVar.qg();
        return TextUtils.isEmpty(strQg) ? "empty" : strQg;
    }

    public static void n(final com.byazt.kb.n nVar, final um.n nVar2, final int i) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.5
            @Override // java.lang.Runnable
            public void run() {
                um umVar;
                if (nVar == null || nVar2 == null || (umVar = (um) s.n.get(nVar)) == null) {
                    return;
                }
                l lVarQ = umVar.q();
                pk pkVarL = umVar.l();
                if (lVarQ == null || pkVarL == null) {
                    return;
                }
                long jQg = nVar2.qg();
                long jQ = nVar2.q();
                if (jQ <= 0 || jQg <= 0) {
                    return;
                }
                fs fsVar = new fs();
                fsVar.n(nVar2.s());
                fsVar.qg(jQ);
                fsVar.n(i);
                fsVar.n(nVar2.cd());
                JSONObject jSONObjectN = s.n(lVarQ, umVar.qg(), umVar.s(), lVarQ.m(), pkVarL, SystemClock.elapsedRealtime() - umVar.n());
                s.n(jSONObjectN, lVarQ.l("EXTRA_PLAY_ACTION"));
                com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVarL, w.qg(pkVarL), jSONObjectN, fsVar);
                qgVar.n(nVar2.k());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, jQg);
                    jSONObject.put("percent", nVar2.cp());
                    s.qg(qgVar.s(), nVar2);
                    s.qg(qgVar, "feed_pause", jSONObject);
                } catch (JSONException unused) {
                }
            }
        });
    }

    public static void qg(final com.byazt.kb.n nVar, final um.n nVar2) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.6
            @Override // java.lang.Runnable
            public void run() {
                um umVar;
                if (nVar == null || nVar2 == null || (umVar = (um) s.n.get(nVar)) == null) {
                    return;
                }
                l lVarQ = umVar.q();
                pk pkVarL = umVar.l();
                if (lVarQ == null || pkVarL == null) {
                    return;
                }
                long jQg = nVar2.qg();
                long jQ = nVar2.q();
                if (jQ <= 0 || jQg <= 0) {
                    return;
                }
                com.byazt.shr.w wVar = new com.byazt.shr.w();
                wVar.n(nVar2.s());
                wVar.qg(jQ);
                JSONObject jSONObjectN = s.n(lVarQ, umVar.qg(), umVar.s(), lVarQ.m(), pkVarL, SystemClock.elapsedRealtime() - umVar.n());
                s.n(jSONObjectN, lVarQ.l("EXTRA_PLAY_ACTION"));
                com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVarL, w.qg(pkVarL), jSONObjectN, wVar);
                qgVar.n(nVar2.k());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, jQg);
                    jSONObject.put("percent", nVar2.cp());
                    s.qg(qgVar.s(), nVar2);
                    s.qg(qgVar, "feed_continue", jSONObject);
                } catch (JSONException unused) {
                }
            }
        });
    }

    public static void n(final com.byazt.kb.n nVar, final um.n nVar2, final String str, final int i, final boolean z) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.7
            @Override // java.lang.Runnable
            public void run() {
                um umVar;
                if (nVar == null || nVar2 == null || (umVar = (um) s.n.get(nVar)) == null) {
                    return;
                }
                l lVarQ = umVar.q();
                pk pkVarL = umVar.l();
                if (lVarQ == null || pkVarL == null) {
                    return;
                }
                long jQg = nVar2.qg();
                long jQ = nVar2.q();
                if (jQ < 0) {
                    return;
                }
                cy cyVar = new cy();
                cyVar.s(nVar2.s());
                cyVar.q(jQ);
                cyVar.s(nVar2.x());
                cyVar.q(nVar2.fs());
                cyVar.qg(i);
                cyVar.qg(com.byazt.ql.qg.n(pkVarL.io()).qg(lVarQ));
                cyVar.n(str);
                JSONArray jSONArrayN = nVar2.n();
                if (jSONArrayN != null) {
                    cyVar.n(jSONArrayN);
                }
                cyVar.n(jQg);
                cyVar.n(nVar2.cp());
                cyVar.n(z);
                JSONObject jSONObjectN = s.n(lVarQ, umVar.qg(), umVar.s(), lVarQ.m(), pkVarL, SystemClock.elapsedRealtime() - umVar.n());
                s.n(jSONObjectN, lVarQ.l("EXTRA_PLAY_START"));
                com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVarL, w.qg(pkVarL), jSONObjectN, cyVar);
                qgVar.n(nVar2.k());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, jQg);
                    jSONObject.put("percent", nVar2.cp());
                    s.qg(qgVar.s(), nVar2);
                    s.qg(qgVar, "play_error", jSONObject);
                } catch (JSONException unused) {
                }
                qg.n().n(new Runnable() { // from class: com.byazt.gw.s.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        s.n.remove(nVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void s(final com.byazt.kb.n nVar, final um.n nVar2) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.8
            @Override // java.lang.Runnable
            public void run() {
                um umVar;
                if (nVar == null || nVar2 == null || (umVar = (um) s.n.get(nVar)) == null) {
                    return;
                }
                l lVarQ = umVar.q();
                pk pkVarL = umVar.l();
                if (lVarQ == null || pkVarL == null) {
                    return;
                }
                long jQg = nVar2.qg();
                long jQ = nVar2.q();
                com.byazt.shr.s sVar = new com.byazt.shr.s();
                sVar.s(nVar2.s());
                sVar.q(jQ);
                sVar.qg(nVar2.rv());
                sVar.s(nVar2.tj());
                sVar.qg(com.byazt.ql.qg.n(pkVarL.io()).qg(lVarQ));
                sVar.n(jQg);
                sVar.n(nVar2.cp());
                JSONObject jSONObjectN = s.n(lVarQ, umVar.qg(), umVar.s(), lVarQ.m(), pkVarL, SystemClock.elapsedRealtime() - umVar.n());
                s.n(jSONObjectN, lVarQ.l("EXTRA_PLAY_START"));
                com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVarL, w.qg(pkVarL), jSONObjectN, sVar);
                qgVar.n(nVar2.k());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, jQg);
                    jSONObject.put("percent", nVar2.cp());
                    s.qg(qgVar.s(), nVar2);
                    s.qg(qgVar, "endcard_skip", jSONObject);
                } catch (JSONException unused) {
                }
                qg.n().n(new Runnable() { // from class: com.byazt.gw.s.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        s.n.remove(nVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void n(final com.byazt.kb.n nVar, final um.n nVar2, final Map<String, Object> map, final int i) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.9
            @Override // java.lang.Runnable
            public void run() {
                um umVar;
                if (nVar == null || nVar2 == null || (umVar = (um) s.n.get(nVar)) == null) {
                    return;
                }
                l lVarQ = umVar.q();
                pk pkVarL = umVar.l();
                if (lVarQ == null || pkVarL == null) {
                    return;
                }
                long jQg = nVar2.qg();
                long jQ = nVar2.q();
                if (jQ <= 0) {
                    return;
                }
                com.byazt.shr.l lVar = new com.byazt.shr.l();
                lVar.qg(nVar2.s());
                lVar.n(jQ);
                lVar.qg(nVar2.d());
                lVar.s(nVar2.oa());
                lVar.n(i);
                JSONObject jSONObjectN = s.n(lVarQ, umVar.qg(), umVar.s(), lVarQ.m(), pkVarL, SystemClock.elapsedRealtime() - umVar.n());
                s.n(jSONObjectN, map);
                com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVarL, w.qg(pkVarL), jSONObjectN, lVar);
                qgVar.n(nVar2.k());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, jQg);
                    jSONObject.put("percent", nVar2.cp());
                    s.qg(qgVar.s(), nVar2);
                    s.qg(qgVar, s.qg(pkVarL, "feed_break"), jSONObject);
                } catch (JSONException unused) {
                }
                s.n.remove(nVar);
            }
        });
    }

    public static void q(final com.byazt.kb.n nVar, final um.n nVar2) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.10
            @Override // java.lang.Runnable
            public void run() {
                um.n nVar3;
                com.byazt.kb.n nVar4 = nVar;
                if (nVar4 == null || (nVar3 = nVar2) == null) {
                    return;
                }
                s.l(nVar4, nVar3);
                um umVar = (um) s.n.get(nVar);
                if (umVar == null) {
                    return;
                }
                l lVarQ = umVar.q();
                pk pkVarL = umVar.l();
                if (lVarQ == null || pkVarL == null) {
                    return;
                }
                long jQg = nVar2.qg();
                long jQ = nVar2.q();
                if (jQ <= 0) {
                    return;
                }
                x xVar = new x();
                xVar.qg(nVar2.s());
                xVar.n(jQ);
                xVar.n(nVar2.oa());
                JSONObject jSONObjectN = s.n(lVarQ, umVar.qg(), umVar.s(), lVarQ.m(), pkVarL, SystemClock.elapsedRealtime() - umVar.n());
                s.n(jSONObjectN, lVarQ.l("EXTRA_PLAY_ACTION"));
                com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVarL, w.qg(pkVarL), jSONObjectN, xVar);
                qgVar.n(nVar2.k());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, jQg);
                    jSONObject.put("percent", nVar2.cp());
                    s.qg(qgVar.s(), nVar2);
                    s.qg(qgVar, s.qg(pkVarL, "feed_over"), jSONObject);
                } catch (JSONException unused) {
                }
                s.n.remove(nVar);
            }
        });
    }

    public static void l(final com.byazt.kb.n nVar, final um.n nVar2) {
        qg.n().n(new Runnable() { // from class: com.byazt.gw.s.11
            @Override // java.lang.Runnable
            public void run() {
                um.n nVar3;
                um umVar;
                if (nVar == null || (nVar3 = nVar2) == null || nVar3.sz() <= 0 || (umVar = (um) s.n.get(nVar)) == null) {
                    return;
                }
                l lVarQ = umVar.q();
                pk pkVarL = umVar.l();
                if (lVarQ == null || pkVarL == null) {
                    return;
                }
                long jQ = nVar2.q();
                if (jQ <= 0) {
                    return;
                }
                k kVar = new k();
                kVar.n(nVar2.s());
                kVar.qg(jQ);
                kVar.n(nVar2.sz());
                JSONObject jSONObjectN = s.n(lVarQ, umVar.qg(), umVar.s(), lVarQ.m(), pkVarL, SystemClock.elapsedRealtime() - umVar.n());
                s.n(jSONObjectN, lVarQ.l("EXTRA_PLAY_ACTION"));
                com.byazt.shr.qg qgVar = new com.byazt.shr.qg(pkVarL, w.qg(pkVarL), jSONObjectN, kVar);
                qgVar.n(nVar2.k());
                s.qg(qgVar, "play_buffer");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(com.byazt.shr.qg qgVar, String str) {
        qg(qgVar, str, (JSONObject) null);
    }

    private static boolean l(com.byazt.shr.qg qgVar) {
        pk pkVarN;
        com.byazt.zq.qg qgVarXd;
        if (qgVar == null || !qgVar.l() || (pkVarN = qgVar.n()) == null || (qgVarXd = pkVarN.xd()) == null) {
            return false;
        }
        String strOu = qgVarXd.ou();
        if (TextUtils.isEmpty(strOu)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(strOu);
            int length = jSONArray.length();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArray.getJSONObject(i).optString(TapEventParamConstants.PARAM_NAME);
                if ("content_did".equalsIgnoreCase(strOptString)) {
                    z = true;
                } else if ("content_utmsource".equalsIgnoreCase(strOptString)) {
                    z2 = true;
                } else if ("content_sdk_version".equalsIgnoreCase(strOptString)) {
                    z3 = true;
                }
            }
            return z && z2 && z3;
        } catch (JSONException e) {
            e.getMessage();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(final com.byazt.shr.qg qgVar, String str, JSONObject jSONObject) {
        if (qgVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (qgVar.l() && !TextUtils.isEmpty(qgVar.qg()) && !l(qgVar)) {
            String strQg = qgVar.qg();
            strQg.hashCode();
            switch (strQg) {
                case "stream":
                case "embeded_ad":
                case "draw_ad":
                    str = "customer_".concat(String.valueOf(str));
                    break;
            }
        }
        com.byazt.hm.n.n(qgVar.n(), qgVar.qg(), str, jSONObject, new com.byazt.rs.n() { // from class: com.byazt.gw.s.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObjectS = qgVar.s();
                if (qgVar.q() != null) {
                    qgVar.q().n(jSONObjectS);
                }
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectS.toString());
                return jSONObjectS;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(pk pkVar, final l lVar, final um.n nVar) {
        com.byazt.eji.s.n().n("pangle_video_play_state", (String) null, (String) null, w.d(pkVar), new com.byazt.rs.n() { // from class: com.byazt.gw.s.3
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("service_duration", s.s(lVar));
                jSONObject2.put("player_duration", nVar.q());
                jSONObject2.put("cache_path_type", com.byazt.ql.qg.q());
                jSONObject2.put(ImagesContract.URL, lVar.ou());
                jSONObject2.put("path", s.q(lVar));
                jSONObject2.put("player_type", lVar.m());
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long s(l lVar) {
        if (lVar == null) {
            return 0L;
        }
        com.byazt.ej.l lVarLh = lVar.a() ? lVar.lh() : lVar.ln();
        if (lVarLh != null) {
            return Double.valueOf(lVarLh.w() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(l lVar) {
        return new File(lVar.l(), lVar.wm()).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(JSONObject jSONObject, um.n nVar) throws JSONException {
        if (nVar.w()) {
            jSONObject.put("real_duration", nVar.l());
        }
    }

    public static synchronized l qg(com.byazt.kb.n nVar) {
        if (nVar == null) {
            return null;
        }
        um umVar = n.get(nVar);
        if (umVar == null) {
            return null;
        }
        return umVar.q();
    }

    public static void n(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception unused) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused2) {
            }
        }
    }
}
