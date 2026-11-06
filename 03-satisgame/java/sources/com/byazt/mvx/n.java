package com.byazt.mvx;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.hm.w;
import com.byazt.nf.rv;
import com.byazt.rm.q;
import com.byazt.rm.qg;
import com.byazt.vyf.s;
import com.byazt.wb.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2058, 19})
public class n implements com.byazt.ot.n.qg {
    public static volatile n n;
    public long q;
    public final HashMap<String, l> qg = new HashMap<>();
    public final HashMap<String, l> s = new HashMap<>();

    @Override // com.byazt.ot.n.qg
    public void q() {
    }

    @Override // com.byazt.ot.n.qg
    public void qg() {
    }

    @Override // com.byazt.ot.n.qg
    public void s() {
    }

    public static n l() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private n() {
        s.cy().s().n(this);
    }

    public void n(final String str, String str2, final String str3, final JSONObject jSONObject, final String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !rv.qg().cl()) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "feed_over":
            case "feed_continue":
            case "feed_break":
            case "feed_pause":
            case "play_start":
                if (q.n() != null) {
                    q.n().post(new Runnable() { // from class: com.byazt.mvx.n.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String strOptString = str3;
                                int iOptInt = 0;
                                if (jSONObject != null) {
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = jSONObject.optString("req_id");
                                    }
                                    iOptInt = jSONObject.optInt("ad_slot_type", 0);
                                } else if (str4 != null) {
                                    JSONObject jSONObject2 = new JSONObject(str4);
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = jSONObject2.optString("req_id");
                                    }
                                    iOptInt = jSONObject2.optInt("ad_slot_type", 0);
                                }
                                if (!TextUtils.isEmpty(strOptString) && iOptInt != 0) {
                                    n.this.n(str, strOptString, iOptInt);
                                }
                            } catch (Exception e) {
                                w.n("s_feature_data_v2", (JSONObject) null, e);
                            }
                        }
                    });
                    break;
                }
                break;
        }
    }

    public void n(final String str, final pk pkVar) {
        if ((!"landingStart".equals(str) && !"landingFinish".equals(str) && !"landingContinue".equals(str) && !"landingPause".equals(str)) || pkVar == null || q.n() == null) {
            return;
        }
        q.n().post(new Runnable() { // from class: com.byazt.mvx.n.2
            @Override // java.lang.Runnable
            public void run() {
                pk pkVar2 = pkVar;
                if (pkVar2 == null || TextUtils.isEmpty(pkVar2.q())) {
                    return;
                }
                n.this.n(str, pkVar.ou(), com.byazt.vgx.w.d(pkVar));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, int i) {
        l lVar;
        l lVar2;
        l lVarRemove;
        l lVar3;
        l lVar4;
        l lVarRemove2;
        str.hashCode();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (lVar = this.s.get(str2)) != null) {
                    lVar.q(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (lVar2 = this.s.get(str2)) != null) {
                    lVar2.s(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2)) {
                    l lVar5 = this.s.get(str2);
                    if (lVar5 == null) {
                        lVar5 = new l();
                        this.s.put(str2, lVar5);
                    }
                    lVar5.n(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
                if (!TextUtils.isEmpty(str2) && (lVarRemove = this.qg.remove(str2)) != null && lVarRemove.n() != l.l) {
                    lVarRemove.qg(SystemClock.elapsedRealtime());
                    n("video_play_end", lVarRemove.n(this.q, SystemClock.elapsedRealtime()), str2, i);
                    break;
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (lVar3 = this.qg.get(str2)) != null) {
                    lVar3.q(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (lVar4 = this.qg.get(str2)) != null) {
                    lVar4.s(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (lVarRemove2 = this.s.remove(str2)) != null && lVarRemove2.n() != l.l) {
                    lVarRemove2.qg(SystemClock.elapsedRealtime());
                    n("landing_finish", lVarRemove2.n(this.q, SystemClock.elapsedRealtime()), str2, i);
                    break;
                }
                break;
            case "play_start":
                if (!TextUtils.isEmpty(str2)) {
                    l lVar6 = this.qg.get(str2);
                    if (lVar6 == null) {
                        lVar6 = new l();
                        this.qg.put(str2, lVar6);
                    }
                    lVar6.n(SystemClock.elapsedRealtime());
                    break;
                }
                break;
        }
    }

    private void n(String str, long j, String str2, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(MediationConstant.EXTRA_DURATION, Long.valueOf(j));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("req_id", str2);
            jSONObject2.putOpt("ad_slot_type", Integer.valueOf(i));
            jSONObject.putOpt("ad_info", jSONObject2);
            qg.n(str, jSONObject);
        } catch (Throwable th) {
            w.n("s_feature_data_v2", (JSONObject) null, th);
        }
    }

    @Override // com.byazt.ot.n.qg
    public void n() {
        if (s.cy().lh()) {
            return;
        }
        this.q = SystemClock.elapsedRealtime();
    }
}
