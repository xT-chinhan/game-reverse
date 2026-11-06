package com.byazt.ne;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.ihe.c;
import com.byazt.n.uc;
import com.byazt.wt.ls;
import com.byazt.yo.aj;
import com.byazt.yo.fw;
import com.byazt.yo.g;
import com.byazt.yo.ho;
import com.byazt.yo.m;
import com.byazt.yo.nt;
import com.byazt.yo.vk;
import com.byazt.yo.w;
import com.byazt.yo.yb;
import com.byazt.yo.zo;
import com.byazt.zp.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT, 20})
public class hn {
    public static final Map<com.byazt.iw.pr, yb> pr = Collections.synchronizedMap(new WeakHashMap());

    public static JSONObject pr(uc ucVar, String str, int i, int i2, of ofVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (k.pr(ofVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (ucVar != null) {
                c cVarNl = null;
                if (com.byazt.lpk.pr.pr(ofVar)) {
                    jSONObject.put("codec", ofVar.qi());
                } else if (ucVar.a()) {
                    cVarNl = ucVar.y();
                    jSONObject.put("codec", "h265");
                } else {
                    cVarNl = ucVar.nl();
                }
                if (cVarNl != null) {
                    jSONObject.put("video_resolution", cVarNl.aj());
                    jSONObject.put("video_size", Long.valueOf(cVarNl.c()));
                    String strK = cVarNl.k();
                    jSONObject.put("video_url", strK);
                    jSONObject.put("is_expired", ls.g(strK));
                    jSONObject.put("send_duration", Math.floor(System.currentTimeMillis() - (ls.nt(ofVar) * 1000.0d)));
                    jSONObject.put("start_duration", j);
                    jSONObject.put("player_type", i2);
                    jSONObject.put("play_speed_ratio", cVarNl.zo());
                    if (cVarNl.fw() > 0.0d) {
                        jSONObject.put(TrackAction.START, cVarNl.fw());
                    }
                }
            }
            if (ofVar != null) {
                jSONObject.put("dynamic_join_type", ofVar.ab());
                String strQn = ofVar.qn();
                if (!TextUtils.isEmpty(strQn)) {
                    jSONObject.put("union_template_id", new JSONObject(strQn).optString("template_id"));
                }
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static void pr(com.byazt.yo.hw<com.byazt.yo.k> hwVar) {
        hw(hwVar, "load_video_start");
    }

    public static void hw(com.byazt.yo.hw<m> hwVar) {
        hw(hwVar, "load_video_success");
    }

    public static void hn(com.byazt.yo.hw<w> hwVar) {
        hw(hwVar, "load_video_error");
    }

    public static void x(com.byazt.yo.hw<vk> hwVar) {
        hw(hwVar, "load_video_cancel");
    }

    public static int pr(of ofVar, uc ucVar, long j) {
        int iSd = ofVar.sd();
        com.byazt.ihe.pr prVarPr = com.byazt.zp.w.pr(iSd);
        if (iSd == 0) {
            boolean zYb = ucVar.yb();
            int iFw = ucVar.fw();
            long jNt = ucVar.nt();
            if (zYb) {
                iFw = (int) jNt;
            }
            boolean z = j >= ((long) iFw);
            boolean z2 = j >= jNt;
            if (j == 0) {
                return 2;
            }
            if (z2) {
                return 4;
            }
            return (!z || iFw == 0) ? 1 : 5;
        }
        if (iSd == 1) {
            return prVarPr.pr(ucVar) ? 1 : 2;
        }
        return 3;
    }

    public static String pr() {
        return UUID.randomUUID().toString();
    }

    public static void pr(final of ofVar, final com.byazt.iw.pr prVar, final uc ucVar, final boolean z, final String str) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.1
            @Override // java.lang.Runnable
            public void run() {
                of ofVar2 = ofVar;
                if (ofVar2 == null || prVar == null || ucVar == null) {
                    return;
                }
                long jHw = com.byazt.zp.w.pr(ofVar2.sd()).hw(ucVar);
                int iPr = hn.pr(ofVar, ucVar, jHw);
                hn.pr.put(prVar, new yb(SystemClock.elapsedRealtime(), str, iPr, ucVar, ofVar));
                nt ntVar = new nt();
                if (jHw > 0) {
                    ntVar.pr(jHw);
                }
                ntVar.pr(z);
                uc ucVar2 = ucVar;
                JSONObject jSONObjectPr = hn.pr(ucVar2, str, iPr, ucVar2.rc(), ofVar, 0L);
                hn.pr(jSONObjectPr, ucVar.c("EXTRA_PLAY_START"));
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVar, ls.hw(ofVar), jSONObjectPr, ntVar);
                hwVar.pr(ucVar.rc() == -1);
                hn.hw(hwVar, "play_start");
            }
        });
    }

    public static void pr(final com.byazt.iw.pr prVar, final yb.pr prVar2) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.4
            @Override // java.lang.Runnable
            public void run() {
                yb ybVar;
                if (prVar == null || prVar2 == null || (ybVar = (yb) hn.pr.get(prVar)) == null) {
                    return;
                }
                uc ucVarX = ybVar.x();
                of ofVarC = ybVar.c();
                if (ucVarX == null || ofVarC == null) {
                    return;
                }
                if (k.pr(ofVarC) && !lb.hw(ofVarC)) {
                    return;
                }
                if (!prVar2.m()) {
                    hn.hw(ofVarC, ucVarX, prVar2);
                }
                aj ajVar = new aj();
                ajVar.hw(prVar2.g() ? 1 : 0);
                ajVar.pr(prVar2.ho() ? 1 : 0);
                ajVar.hw(com.byazt.zp.w.pr(ofVarC.sd()).hw(ucVarX));
                long jElapsedRealtime = SystemClock.elapsedRealtime() - ybVar.pr();
                ajVar.pr(jElapsedRealtime);
                JSONObject jSONObjectPr = hn.pr(ucVarX, ybVar.hw(), ybVar.hn(), ucVarX.rc(), ofVarC, jElapsedRealtime);
                hn.pr(jSONObjectPr, ucVarX.c("EXTRA_PLAY_START"));
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVarC, ls.hw(ofVarC), jSONObjectPr, ajVar);
                hwVar.pr(prVar2.m());
                hn.hw(hwVar, hn.hw(ofVarC, "feed_play"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hw(of ofVar, String str) {
        if (ofVar != null && ls.aj(ofVar) && ls.vk(ofVar)) {
            switch (str) {
                case "feed_play":
                    return "play";
                case "feed_over":
                    return "play_over";
                case "feed_break":
                    return "play_break";
                default:
                    return str;
            }
        }
        return str;
    }

    public static String pr(com.byazt.iw.pr prVar) {
        yb ybVar;
        if (prVar == null || (ybVar = pr.get(prVar)) == null) {
            return "empty";
        }
        String strHw = ybVar.hw();
        if (TextUtils.isEmpty(strHw)) {
            return "empty";
        }
        return strHw;
    }

    public static void pr(final com.byazt.iw.pr prVar, final yb.pr prVar2, final int i) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.5
            @Override // java.lang.Runnable
            public void run() {
                yb ybVar;
                if (prVar == null || prVar2 == null || (ybVar = (yb) hn.pr.get(prVar)) == null) {
                    return;
                }
                uc ucVarX = ybVar.x();
                of ofVarC = ybVar.c();
                if (ucVarX == null || ofVarC == null) {
                    return;
                }
                long jHw = prVar2.hw();
                long jX = prVar2.x();
                if (jX <= 0 || jHw <= 0) {
                    return;
                }
                zo zoVar = new zo();
                zoVar.pr(prVar2.hn());
                zoVar.hw(jX);
                zoVar.pr(i);
                zoVar.pr(prVar2.nt());
                JSONObject jSONObjectPr = hn.pr(ucVarX, ybVar.hw(), ybVar.hn(), ucVarX.rc(), ofVarC, SystemClock.elapsedRealtime() - ybVar.pr());
                hn.pr(jSONObjectPr, ucVarX.c("EXTRA_PLAY_ACTION"));
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVarC, ls.hw(ofVarC), jSONObjectPr, zoVar);
                hwVar.pr(prVar2.m());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jHw);
                    jSONObject.put("percent", prVar2.aj());
                    hn.hw(hwVar, "feed_pause", jSONObject);
                } catch (JSONException e) {
                }
            }
        });
    }

    public static void hw(final com.byazt.iw.pr prVar, final yb.pr prVar2) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.6
            @Override // java.lang.Runnable
            public void run() {
                yb ybVar;
                if (prVar == null || prVar2 == null || (ybVar = (yb) hn.pr.get(prVar)) == null) {
                    return;
                }
                uc ucVarX = ybVar.x();
                of ofVarC = ybVar.c();
                if (ucVarX == null || ofVarC == null) {
                    return;
                }
                long jHw = prVar2.hw();
                long jX = prVar2.x();
                if (jX <= 0 || jHw <= 0) {
                    return;
                }
                com.byazt.yo.uc ucVar = new com.byazt.yo.uc();
                ucVar.pr(prVar2.hn());
                ucVar.hw(jX);
                JSONObject jSONObjectPr = hn.pr(ucVarX, ybVar.hw(), ybVar.hn(), ucVarX.rc(), ofVarC, SystemClock.elapsedRealtime() - ybVar.pr());
                hn.pr(jSONObjectPr, ucVarX.c("EXTRA_PLAY_ACTION"));
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVarC, ls.hw(ofVarC), jSONObjectPr, ucVar);
                hwVar.pr(prVar2.m());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jHw);
                    jSONObject.put("percent", prVar2.aj());
                    hn.hw(hwVar, "feed_continue", jSONObject);
                } catch (JSONException e) {
                }
            }
        });
    }

    public static void pr(final com.byazt.iw.pr prVar, final yb.pr prVar2, final String str, final int i, final boolean z) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.7
            @Override // java.lang.Runnable
            public void run() {
                yb ybVar;
                if (prVar == null || prVar2 == null || (ybVar = (yb) hn.pr.get(prVar)) == null) {
                    return;
                }
                uc ucVarX = ybVar.x();
                of ofVarC = ybVar.c();
                if (ucVarX == null || ofVarC == null) {
                    return;
                }
                long jHw = prVar2.hw();
                long jX = prVar2.x();
                if (jX < 0) {
                    return;
                }
                ho hoVar = new ho();
                hoVar.hn(prVar2.hn());
                hoVar.x(jX);
                hoVar.hn(prVar2.c());
                hoVar.x(prVar2.uc());
                hoVar.hw(i);
                hoVar.hw(com.byazt.zp.w.pr(ofVarC.sd()).hw(ucVarX));
                hoVar.pr(str);
                JSONArray jSONArrayPr = prVar2.pr();
                if (jSONArrayPr != null) {
                    hoVar.pr(jSONArrayPr);
                }
                hoVar.pr(jHw);
                hoVar.pr(prVar2.aj());
                hoVar.pr(z);
                JSONObject jSONObjectPr = hn.pr(ucVarX, ybVar.hw(), ybVar.hn(), ucVarX.rc(), ofVarC, SystemClock.elapsedRealtime() - ybVar.pr());
                hn.pr(jSONObjectPr, ucVarX.c("EXTRA_PLAY_START"));
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVarC, ls.hw(ofVarC), jSONObjectPr, hoVar);
                hwVar.pr(prVar2.m());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jHw);
                    jSONObject.put("percent", prVar2.aj());
                    hn.hw(hwVar, "play_error", jSONObject);
                } catch (JSONException e) {
                }
                hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hn.pr.remove(prVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void hn(final com.byazt.iw.pr prVar, final yb.pr prVar2) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.8
            @Override // java.lang.Runnable
            public void run() {
                yb ybVar;
                if (prVar == null || prVar2 == null || (ybVar = (yb) hn.pr.get(prVar)) == null) {
                    return;
                }
                uc ucVarX = ybVar.x();
                of ofVarC = ybVar.c();
                if (ucVarX == null || ofVarC == null) {
                    return;
                }
                long jHw = prVar2.hw();
                long jX = prVar2.x();
                com.byazt.yo.hn hnVar = new com.byazt.yo.hn();
                hnVar.hn(prVar2.hn());
                hnVar.x(jX);
                hnVar.hw(prVar2.fw());
                hnVar.hn(prVar2.zo());
                hnVar.hw(com.byazt.zp.w.pr(ofVarC.sd()).hw(ucVarX));
                hnVar.pr(jHw);
                hnVar.pr(prVar2.aj());
                JSONObject jSONObjectPr = hn.pr(ucVarX, ybVar.hw(), ybVar.hn(), ucVarX.rc(), ofVarC, SystemClock.elapsedRealtime() - ybVar.pr());
                hn.pr(jSONObjectPr, ucVarX.c("EXTRA_PLAY_START"));
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVarC, ls.hw(ofVarC), jSONObjectPr, hnVar);
                hwVar.pr(prVar2.m());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jHw);
                    jSONObject.put("percent", prVar2.aj());
                    hn.hw(hwVar, "endcard_skip", jSONObject);
                } catch (JSONException e) {
                }
                hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hn.pr.remove(prVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void pr(final com.byazt.iw.pr prVar, final yb.pr prVar2, final Map<String, Object> map, final int i) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.9
            @Override // java.lang.Runnable
            public void run() {
                yb ybVar;
                if (prVar == null || prVar2 == null || (ybVar = (yb) hn.pr.get(prVar)) == null) {
                    return;
                }
                uc ucVarX = ybVar.x();
                of ofVarC = ybVar.c();
                if (ucVarX == null || ofVarC == null) {
                    return;
                }
                long jHw = prVar2.hw();
                long jX = prVar2.x();
                if (jX <= 0) {
                    return;
                }
                com.byazt.yo.c cVar = new com.byazt.yo.c();
                cVar.hw(prVar2.hn());
                cVar.pr(jX);
                cVar.hw(prVar2.vk());
                cVar.hn(prVar2.w());
                cVar.pr(i);
                JSONObject jSONObjectPr = hn.pr(ucVarX, ybVar.hw(), ybVar.hn(), ucVarX.rc(), ofVarC, SystemClock.elapsedRealtime() - ybVar.pr());
                hn.pr(jSONObjectPr, map);
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVarC, ls.hw(ofVarC), jSONObjectPr, cVar);
                hwVar.pr(prVar2.m());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jHw);
                    jSONObject.put("percent", prVar2.aj());
                    hn.hw(hwVar, hn.hw(ofVarC, "feed_break"), jSONObject);
                } catch (JSONException e) {
                }
                hn.pr.remove(prVar);
            }
        });
    }

    public static void x(final com.byazt.iw.pr prVar, final yb.pr prVar2) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.10
            @Override // java.lang.Runnable
            public void run() {
                yb.pr prVar3;
                com.byazt.iw.pr prVar4 = prVar;
                if (prVar4 == null || (prVar3 = prVar2) == null) {
                    return;
                }
                hn.c(prVar4, prVar3);
                yb ybVar = (yb) hn.pr.get(prVar);
                if (ybVar == null) {
                    return;
                }
                uc ucVarX = ybVar.x();
                of ofVarC = ybVar.c();
                if (ucVarX == null || ofVarC == null) {
                    return;
                }
                long jHw = prVar2.hw();
                long jX = prVar2.x();
                if (jX <= 0) {
                    return;
                }
                fw fwVar = new fw();
                fwVar.hw(prVar2.hn());
                fwVar.pr(jX);
                fwVar.pr(prVar2.w());
                JSONObject jSONObjectPr = hn.pr(ucVarX, ybVar.hw(), ybVar.hn(), ucVarX.rc(), ofVarC, SystemClock.elapsedRealtime() - ybVar.pr());
                hn.pr(jSONObjectPr, ucVarX.c("EXTRA_PLAY_ACTION"));
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVarC, ls.hw(ofVarC), jSONObjectPr, fwVar);
                hwVar.pr(prVar2.m());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jHw);
                    jSONObject.put("percent", prVar2.aj());
                    hn.hw(hwVar, hn.hw(ofVarC, "feed_over"), jSONObject);
                } catch (JSONException e) {
                }
                hn.pr.remove(prVar);
            }
        });
    }

    public static void c(final com.byazt.iw.pr prVar, final yb.pr prVar2) {
        hw.pr().pr(new Runnable() { // from class: com.byazt.ne.hn.11
            @Override // java.lang.Runnable
            public void run() {
                yb.pr prVar3;
                yb ybVar;
                if (prVar == null || (prVar3 = prVar2) == null || prVar3.k() <= 0 || (ybVar = (yb) hn.pr.get(prVar)) == null) {
                    return;
                }
                uc ucVarX = ybVar.x();
                of ofVarC = ybVar.c();
                if (ucVarX == null || ofVarC == null) {
                    return;
                }
                long jX = prVar2.x();
                if (jX <= 0) {
                    return;
                }
                g gVar = new g();
                gVar.pr(prVar2.hn());
                gVar.hw(jX);
                gVar.pr(prVar2.k());
                JSONObject jSONObjectPr = hn.pr(ucVarX, ybVar.hw(), ybVar.hn(), ucVarX.rc(), ofVarC, SystemClock.elapsedRealtime() - ybVar.pr());
                hn.pr(jSONObjectPr, ucVarX.c("EXTRA_PLAY_ACTION"));
                com.byazt.yo.hw hwVar = new com.byazt.yo.hw(ofVarC, ls.hw(ofVarC), jSONObjectPr, gVar);
                hwVar.pr(prVar2.m());
                hn.hw(hwVar, "play_buffer");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(com.byazt.yo.hw hwVar, String str) {
        hw(hwVar, str, (JSONObject) null);
    }

    private static boolean c(com.byazt.yo.hw hwVar) {
        of ofVarPr;
        com.byazt.qe.hw hwVarP;
        if (hwVar == null || !hwVar.c() || (ofVarPr = hwVar.pr()) == null || (hwVarP = ofVarPr.p()) == null) {
            return false;
        }
        String strNy = hwVarP.ny();
        if (TextUtils.isEmpty(strNy)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(strNy);
            int length = jSONArray.length();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArray.getJSONObject(i).optString(Common.System.NAME);
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
    public static void hw(final com.byazt.yo.hw hwVar, String str, JSONObject jSONObject) {
        if (hwVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (hwVar.c() && !TextUtils.isEmpty(hwVar.hw()) && !c(hwVar)) {
            switch (hwVar.hw()) {
                case "embeded_ad":
                case "stream":
                case "draw_ad":
                    str = "customer_".concat(String.valueOf(str));
                    break;
            }
        }
        com.byazt.pj.pr.pr(hwVar.pr(), hwVar.hw(), str, jSONObject, new com.byazt.ttf.pr() { // from class: com.byazt.ne.hn.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObjectHn = hwVar.hn();
                if (hwVar.x() != null) {
                    hwVar.x().pr(jSONObjectHn);
                }
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectHn.toString());
                return jSONObjectHn;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(of ofVar, final uc ucVar, final yb.pr prVar) {
        com.byazt.xk.hw.pr().pr("pangle_video_play_state", (String) null, (String) null, ls.k(ofVar), new com.byazt.ttf.pr() { // from class: com.byazt.ne.hn.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("service_duration", hn.hn(ucVar));
                jSONObject2.put("player_duration", prVar.x());
                jSONObject2.put("cache_path_type", com.byazt.zp.w.x());
                jSONObject2.put(BreakpointSQLiteKey.URL, ucVar.ny());
                jSONObject2.put("path", hn.x(ucVar));
                jSONObject2.put("player_type", ucVar.rc());
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long hn(uc ucVar) {
        if (ucVar == null) {
            return 0L;
        }
        c cVarY = ucVar.a() ? ucVar.y() : ucVar.nl();
        if (cVarY == null) {
            return 0L;
        }
        return Double.valueOf(cVarY.uc() * 1000.0d).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String x(uc ucVar) {
        return new File(ucVar.c(), ucVar.fo()).getAbsolutePath();
    }

    public static synchronized uc hw(com.byazt.iw.pr prVar) {
        if (prVar == null) {
            return null;
        }
        yb ybVar = pr.get(prVar);
        if (ybVar == null) {
            return null;
        }
        return ybVar.x();
    }

    public static void pr(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception e) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
            }
        }
    }
}
