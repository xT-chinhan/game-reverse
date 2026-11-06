package com.byazt.ll;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.gct.hd;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.gct.v;
import com.byazt.gct.w;
import com.byazt.gct.wv;
import com.byazt.iz.fs;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 26})
public class qg implements q {
    public final pk n;
    public final s qg;
    public boolean s;
    public AppDownloadListener w;
    public final Map<String, ITTInnerDownloadAdapter> q = new HashMap();
    public boolean l = true;
    public boolean x = false;
    public boolean fs = false;

    private qg(s sVar, pk pkVar, boolean z) {
        this.qg = sVar;
        this.n = pkVar;
        this.s = z;
    }

    public static qg n(s sVar, pk pkVar, boolean z) {
        return new qg(sVar, pkVar, z);
    }

    @Override // com.byazt.ll.q
    public void n() {
        for (ITTInnerDownloadAdapter iTTInnerDownloadAdapter : this.q.values()) {
            if (iTTInnerDownloadAdapter != null) {
                iTTInnerDownloadAdapter.onResume();
            }
        }
    }

    @Override // com.byazt.ll.q
    public void qg() {
        for (ITTInnerDownloadAdapter iTTInnerDownloadAdapter : this.q.values()) {
            if (iTTInnerDownloadAdapter != null) {
                iTTInnerDownloadAdapter.onPause();
            }
        }
    }

    @Override // com.byazt.ll.q
    public void s() {
        qg();
        for (ITTInnerDownloadAdapter iTTInnerDownloadAdapter : this.q.values()) {
            if (iTTInnerDownloadAdapter != null) {
                iTTInnerDownloadAdapter.onDestroy();
            }
        }
        this.q.clear();
    }

    public static pk n(pk pkVar, JSONObject jSONObject, String str) {
        String strOptString;
        boolean z;
        pk pkVarN;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (jSONObject != null) {
            strOptString = jSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL);
            z = true;
        } else {
            strOptString = "";
            z = false;
        }
        if (TextUtils.isEmpty(strOptString)) {
            z = false;
        }
        boolean z2 = (pkVar.k() == null || pkVar.k().qg() == null || !pkVar.k().qg().equals(strOptString)) ? z : false;
        if (jSONObject != null && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !jSONObjectOptJSONObject2.optBoolean("has_valid_download_url", true)) {
            z2 = true;
        }
        if (z2) {
            pkVarN = new pk();
            pkVarN.df(pkVar.mk());
            pkVarN.l(pkVar.v());
            pkVarN.j(pkVar.xa());
            pkVarN.v(pkVar.lx());
            pkVarN.j(jSONObject.optInt("lp_down_rule"));
            pkVarN.fi(4);
            pkVarN.h(jSONObject.optString("id"));
            pkVarN.cd(jSONObject.optString("source"));
            com.byazt.gct.l lVar = new com.byazt.gct.l();
            lVar.q(jSONObject.optString("pkg_name"));
            lVar.s(jSONObject.optString(TapEventParamConstants.PARAM_NAME));
            lVar.qg(strOptString);
            pkVarN.n(lVar);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (jSONObjectOptJSONObject3 != null) {
                pkVarN.n(new um(jSONObjectOptJSONObject3));
                if (!jSONObjectOptJSONObject3.optBoolean("has_valid_download_url", true)) {
                    pkVarN.k(true);
                }
            }
            String strOptString2 = jSONObject.optString("market_url");
            if (!TextUtils.isEmpty(strOptString2)) {
                pkVarN.v(strOptString2);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (jSONObjectOptJSONObject4 != null) {
                w wVarCd = pkVarN.cd();
                if (wVarCd == null) {
                    wVarCd = new w();
                }
                wVarCd.n(jSONObjectOptJSONObject4.optInt("score"));
                wVarCd.n(jSONObjectOptJSONObject4.optJSONArray("creative_tags"));
                pkVarN.n(wVarCd);
                pkVarN.hd(jSONObjectOptJSONObject4.toString());
                v vVarXu = pkVarN.xu();
                if (vVarXu == null) {
                    vVarXu = new v();
                }
                vVarXu.n(jSONObjectOptJSONObject4.optString(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL));
                pkVarN.n(vVarXu);
                pkVarN.m(jSONObjectOptJSONObject4.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DESC));
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (jSONObjectOptJSONObject5 != null) {
                pkVarN.v(jSONObjectOptJSONObject5.optInt("app_manage_type"));
            }
            int iOptInt = jSONObject.optInt("live_interaction_type");
            String strOptString3 = jSONObject.optString("live_room_id");
            if (iOptInt > 0 && !TextUtils.isEmpty(strOptString3)) {
                pkVarN.ci(iOptInt);
                pkVarN.dg(strOptString3);
            }
            pkVarN.ic(jSONObject.optInt("ad_type"));
            wv wvVarN = wv.n(jSONObject.optJSONObject("wc_miniapp_info"));
            if (wvVarN != null) {
                pkVarN.n(wvVarN);
            }
            String strOptString4 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(strOptString4)) {
                com.byazt.gct.l lVarK = pkVarN.k() != null ? pkVarN.k() : new com.byazt.gct.l();
                lVarK.n(strOptString4);
                pkVarN.n(lVarK);
            }
        } else {
            pkVarN = com.byazt.vgx.qg.n(pkVar.pv());
        }
        if (!TextUtils.isEmpty(str)) {
            pkVarN.t(str);
        }
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link")) != null) {
            hd hdVar = new hd();
            if (pkVar.sz() != null) {
                hdVar.n(pkVar.sz());
            }
            hdVar.n(new hd(jSONObjectOptJSONObject));
            pkVarN.n(hdVar);
        }
        return pkVarN;
    }

    @Override // com.byazt.ll.q
    public void n(Context context, JSONObject jSONObject, String str, int i, boolean z, boolean z2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(f.R)) == null) {
            return;
        }
        pk pkVarN = n(this.n, jSONObjectOptJSONObject, n(jSONObjectOptJSONObject, str));
        n(context, pkVarN, jSONObjectOptJSONObject, i, z ? com.byazt.oh.l.n(pkVarN) : 0, z2);
    }

    private void n(Context context, pk pkVar, JSONObject jSONObject, int i, int i2, boolean z) {
        if (context == null || pkVar == null || pkVar.k() == null || jSONObject == null || this.qg == null) {
            return;
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.q.get(pkVar.k().qg());
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.setCheckCompliance(i2);
            return;
        }
        String strN = com.byazt.vgx.w.n(i);
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = n(context, pkVar, jSONObject, strN);
        iTTInnerDownloadAdapterN.setCheckCompliance(i2);
        if (iTTInnerDownloadAdapterN instanceof com.byazt.oh.n) {
            ((com.byazt.oh.n) iTTInnerDownloadAdapterN).n(z);
        }
        this.q.put(pkVar.k().qg(), iTTInnerDownloadAdapterN);
    }

    @Override // com.byazt.ll.q
    public void n(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(f.R)) == null) {
            return;
        }
        n(context, n(this.n, jSONObjectOptJSONObject, n(jSONObjectOptJSONObject, str2)), str);
    }

    private String n(JSONObject jSONObject, String str) {
        String strOptString = jSONObject != null ? jSONObject.optString("ext") : null;
        return TextUtils.isEmpty(strOptString) ? str : strOptString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n(Context context, pk pkVar, String str) {
        if (context == 0 || pkVar == null) {
            return;
        }
        if (pkVar.k() == null) {
            ITTInnerDownloadAdapter iTTInnerDownloadAdapterQg = fs.qg(context, pkVar, str);
            if (iTTInnerDownloadAdapterQg instanceof com.byazt.oh.n) {
                ((com.byazt.oh.n) iTTInnerDownloadAdapterQg).n(this.s);
                iTTInnerDownloadAdapterQg.setShowDLFactorsCard(this.fs);
            }
            iTTInnerDownloadAdapterQg.handleAdClick(pkVar, false);
        } else {
            final String strQ = pkVar.q();
            ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.q.get(pkVar.k().qg());
            if (iTTInnerDownloadAdapter != null) {
                iTTInnerDownloadAdapter.setOpenMarketInterceptorForDSP(this.x);
                iTTInnerDownloadAdapter.setShowDLFactorsCard(this.fs);
                if (iTTInnerDownloadAdapter instanceof com.byazt.oh.n) {
                    ((com.byazt.oh.n) iTTInnerDownloadAdapter).n().n(this.l);
                }
                iTTInnerDownloadAdapter.handleAdClick(pkVar, false);
                iTTInnerDownloadAdapter.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.ll.qg.1
                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onIdle() {
                        com.byazt.ll.n.n(strQ);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onDownloadActive(long j, long j2, String str2, String str3) {
                        com.byazt.ll.n.n(strQ, j, j2);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onDownloadPaused(long j, long j2, String str2, String str3) {
                        com.byazt.ll.n.qg(strQ, j, j2);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onDownloadFailed(long j, long j2, String str2, String str3) {
                        com.byazt.ll.n.s(strQ, j, j2);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onDownloadFinished(long j, String str2, String str3) {
                        com.byazt.ll.n.qg(strQ);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onInstalled(String str2, String str3) {
                        com.byazt.ll.n.s(strQ);
                    }
                });
            }
        }
        if (context instanceof com.byazt.rv.n) {
            ((com.byazt.rv.n) context).n(1);
        }
    }

    @Override // com.byazt.ll.q
    public void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(f.R)) == null) {
            return;
        }
        n(n(this.n, jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void n(pk pkVar, JSONObject jSONObject) {
        if (this.qg == null || pkVar == null || pkVar.k() == null) {
            return;
        }
        String strQg = pkVar.k().qg();
        if (this.q.containsKey(strQg)) {
            ITTInnerDownloadAdapter iTTInnerDownloadAdapterRemove = this.q.remove(strQg);
            if (iTTInnerDownloadAdapterRemove != null) {
                try {
                    iTTInnerDownloadAdapterRemove.onDestroy();
                } catch (JSONException unused) {
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", "success");
            jSONObject2.put("status", "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.qg.qg("app_ad_event", jSONObject2);
        }
    }

    @Override // com.byazt.ll.q
    public void qg(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || this.qg == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(f.R)) == null) {
            return;
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.q.get(n(this.n, jSONObjectOptJSONObject, (String) null).k().qg());
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.cancelDownload();
        }
    }

    @Override // com.byazt.ll.q
    public void n(boolean z) {
        this.l = z;
    }

    @Override // com.byazt.ll.q
    public void n(String str, boolean z) {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter;
        if (TextUtils.isEmpty(str) || (iTTInnerDownloadAdapter = this.q.get(str)) == null) {
            return;
        }
        iTTInnerDownloadAdapter.setCheckReplaceDialogWithLp(z);
    }

    @Override // com.byazt.ll.q
    public void qg(boolean z) {
        this.x = z;
    }

    @Override // com.byazt.ll.q
    public void s(boolean z) {
        this.fs = z;
    }

    private ITTInnerDownloadAdapter n(Context context, pk pkVar, final JSONObject jSONObject, String str) {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterQg = fs.qg(context, pkVar, str);
        if (iTTInnerDownloadAdapterQg instanceof com.byazt.oh.n) {
            ((com.byazt.oh.n) iTTInnerDownloadAdapterQg).n(this.s);
        }
        final String strQ = pkVar.q();
        iTTInnerDownloadAdapterQg.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.ll.qg.2
            @Override // com.byazt.pmn.AppDownloadListener
            public void onIdle() {
                com.byazt.ll.n.n(strQ);
                n("status", "idle");
                if (qg.this.w == null) {
                    return;
                }
                qg.this.w.onIdle();
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadActive(long j, long j2, String str2, String str3) {
                com.byazt.ll.n.n(strQ, j, j2);
                n("status", "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (qg.this.w == null) {
                    return;
                }
                qg.this.w.onDownloadActive(j, j2, str2, str3);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadPaused(long j, long j2, String str2, String str3) {
                com.byazt.ll.n.qg(strQ, j, j2);
                n("status", "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (qg.this.w == null) {
                    return;
                }
                qg.this.w.onDownloadPaused(j, j2, str2, str3);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFailed(long j, long j2, String str2, String str3) {
                com.byazt.ll.n.s(strQ, j, j2);
                n("status", "download_failed", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (qg.this.w == null) {
                    return;
                }
                qg.this.w.onDownloadFailed(j, j2, str2, str3);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFinished(long j, String str2, String str3) {
                com.byazt.ll.n.qg(strQ);
                n("status", "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
                if (qg.this.w == null) {
                    return;
                }
                qg.this.w.onDownloadFinished(j, str2, str3);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onInstalled(String str2, String str3) {
                com.byazt.ll.n.s(strQ);
                n("status", "installed");
                if (qg.this.w == null) {
                    return;
                }
                qg.this.w.onInstalled(str2, str3);
            }

            private void n(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("appad", jSONObject);
                    for (int i = 0; i < strArr.length; i += 2) {
                        jSONObject2.put(strArr[i], strArr[i + 1]);
                    }
                    qg.this.qg.qg("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        });
        return iTTInnerDownloadAdapterQg;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 48})
    public static class n {
        public static ConcurrentHashMap<String, JSONObject> n = new ConcurrentHashMap<>();

        public static synchronized JSONObject n(String str) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = n;
            if (concurrentHashMap == null) {
                return new JSONObject();
            }
            JSONObject jSONObject = concurrentHashMap.get(str);
            if (jSONObject != null) {
                return jSONObject;
            }
            return new JSONObject();
        }

        public static synchronized void n(String str, int i, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (n == null) {
                n = new ConcurrentHashMap<>();
            }
            JSONObject jSONObject = n.get(str);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                n.put(str, jSONObject);
            }
            try {
                jSONObject.put("downloadStatus", i);
                jSONObject.put("downloadProcessRate", i2);
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "get ad_down_load_id success");
            } catch (Exception unused) {
            }
        }
    }
}
