package com.byazt.dp;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.hg.u;
import com.byazt.hg.uc;
import com.byazt.hg.y;
import com.byazt.hg.yb;
import com.byazt.jx.zo;
import com.byazt.mg.PluginConstants;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 480, 13})
public class hw implements x {
    public boolean hn;
    public final hn hw;
    public final of pr;
    public com.byazt.nv.pr uc;
    public final Map<String, com.byazt.nv.hn> x = new HashMap();
    public boolean c = true;
    public boolean fw = false;
    public boolean zo = false;

    private hw(hn hnVar, of ofVar, boolean z) {
        this.hw = hnVar;
        this.pr = ofVar;
        this.hn = z;
    }

    public static hw pr(hn hnVar, of ofVar, boolean z) {
        return new hw(hnVar, ofVar, z);
    }

    @Override // com.byazt.dp.x
    public void pr() {
        for (com.byazt.nv.hn hnVar : this.x.values()) {
            if (hnVar != null) {
                hnVar.hw();
            }
        }
    }

    @Override // com.byazt.dp.x
    public void hw() {
        Iterator<com.byazt.nv.hn> it = this.x.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.byazt.dp.x
    public void hn() {
        hw();
        for (com.byazt.nv.hn hnVar : this.x.values()) {
            if (hnVar != null) {
                hnVar.hn();
            }
        }
        this.x.clear();
    }

    public static of pr(of ofVar, JSONObject jSONObject, String str) {
        String strOptString;
        boolean z;
        of ofVarPr;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        boolean z2 = false;
        if (jSONObject != null) {
            strOptString = jSONObject.optString("download_url");
            z = true;
        } else {
            strOptString = "";
            z = false;
        }
        if (TextUtils.isEmpty(strOptString)) {
            z = false;
        }
        if (ofVar.ho() == null || ofVar.ho().hw() == null || !ofVar.ho().hw().equals(strOptString)) {
            z2 = z;
        }
        if (jSONObject != null && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !jSONObjectOptJSONObject2.optBoolean("has_valid_download_url", true)) {
            z2 = true;
        }
        if (z2) {
            ofVarPr = new of();
            ofVarPr.ls(ofVar.yn());
            ofVarPr.c(ofVar.nl());
            ofVarPr.y(ofVar.fl());
            ofVarPr.nl(ofVar.cb());
            ofVarPr.y(jSONObject.optInt("lp_down_rule"));
            ofVarPr.s(4);
            ofVarPr.rc(jSONObject.optString("id"));
            ofVarPr.yb(jSONObject.optString("source"));
            com.byazt.hg.c cVar = new com.byazt.hg.c();
            cVar.x(jSONObject.optString("pkg_name"));
            cVar.hn(jSONObject.optString(Common.System.NAME));
            cVar.hw(strOptString);
            ofVarPr.pr(cVar);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (jSONObjectOptJSONObject3 != null) {
                ofVarPr.pr(new qa(jSONObjectOptJSONObject3));
                if (!jSONObjectOptJSONObject3.optBoolean("has_valid_download_url", true)) {
                    ofVarPr.m(true);
                }
            }
            String strOptString2 = jSONObject.optString("market_url");
            if (!TextUtils.isEmpty(strOptString2)) {
                ofVarPr.nl(strOptString2);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (jSONObjectOptJSONObject4 != null) {
                uc ucVarLb = ofVarPr.lb();
                if (ucVarLb == null) {
                    ucVarLb = new uc();
                }
                ucVarLb.pr(jSONObjectOptJSONObject4.optInt("score"));
                ucVarLb.pr(jSONObjectOptJSONObject4.optJSONArray("creative_tags"));
                ofVarPr.pr(ucVarLb);
                ofVarPr.nt(jSONObjectOptJSONObject4.toString());
                y yVarMo = ofVarPr.mo();
                if (yVarMo == null) {
                    yVarMo = new y();
                }
                yVarMo.pr(jSONObjectOptJSONObject4.optString("icon_url"));
                ofVarPr.pr(yVarMo);
                ofVarPr.ny(jSONObjectOptJSONObject4.optString("desc"));
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (jSONObjectOptJSONObject5 != null) {
                ofVarPr.nl(jSONObjectOptJSONObject5.optInt("app_manage_type"));
            }
            int iOptInt = jSONObject.optInt("live_interaction_type");
            String strOptString3 = jSONObject.optString("live_room_id");
            if (iOptInt > 0 && !TextUtils.isEmpty(strOptString3)) {
                ofVarPr.vj(iOptInt);
                ofVarPr.v(strOptString3);
            }
            ofVarPr.od(jSONObject.optInt("ad_type"));
            u uVarPr = u.pr(jSONObject.optJSONObject("wc_miniapp_info"));
            if (uVarPr != null) {
                ofVarPr.pr(uVarPr);
            }
            String strOptString4 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(strOptString4)) {
                com.byazt.hg.c cVarHo = ofVarPr.ho() != null ? ofVarPr.ho() : new com.byazt.hg.c();
                cVarHo.pr(strOptString4);
                ofVarPr.pr(cVarHo);
            }
        } else {
            ofVarPr = com.byazt.sd.pr.pr(ofVar.to());
        }
        if (!TextUtils.isEmpty(str)) {
            ofVarPr.z(str);
        }
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link")) != null) {
            yb ybVar = new yb();
            if (ofVar.g() != null) {
                ybVar.pr(ofVar.g());
            }
            ybVar.pr(new yb(jSONObjectOptJSONObject));
            ofVarPr.pr(ybVar);
        }
        return ofVarPr;
    }

    @Override // com.byazt.dp.x
    public void pr(Context context, JSONObject jSONObject, String str, int i, boolean z, boolean z2) {
        JSONObject jSONObjectOptJSONObject;
        if (context != null && jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
            of ofVarPr = pr(this.pr, jSONObjectOptJSONObject, pr(jSONObjectOptJSONObject, str));
            pr(context, ofVarPr, jSONObjectOptJSONObject, i, z ? com.byazt.ri.c.pr(ofVarPr) : 0, z2);
        }
    }

    private void pr(Context context, of ofVar, JSONObject jSONObject, int i, int i2, boolean z) {
        if (context == null || ofVar == null || ofVar.ho() == null || jSONObject == null || this.hw == null) {
            return;
        }
        com.byazt.nv.hn hnVar = this.x.get(ofVar.ho().hw());
        if (hnVar != null) {
            hnVar.pr(i2);
            return;
        }
        String strPr = ls.pr(i);
        if (TextUtils.isEmpty(strPr)) {
            return;
        }
        com.byazt.nv.hn hnVarPr = pr(context, ofVar, jSONObject, strPr);
        hnVarPr.pr(i2);
        if (hnVarPr instanceof com.byazt.ri.pr) {
            ((com.byazt.ri.pr) hnVarPr).c(z);
        }
        this.x.put(ofVar.ho().hw(), hnVarPr);
    }

    @Override // com.byazt.dp.x
    public void pr(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (context != null && jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
            pr(context, pr(this.pr, jSONObjectOptJSONObject, pr(jSONObjectOptJSONObject, str2)), str);
        }
    }

    private String pr(JSONObject jSONObject, String str) {
        String strOptString = jSONObject != null ? jSONObject.optString("ext") : null;
        return TextUtils.isEmpty(strOptString) ? str : strOptString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pr(Context context, of ofVar, String str) {
        if (context == 0 || ofVar == null) {
            return;
        }
        if (ofVar.ho() == null) {
            com.byazt.nv.hn hnVarHw = zo.hw(context, ofVar, str);
            if (hnVarHw instanceof com.byazt.ri.pr) {
                ((com.byazt.ri.pr) hnVarHw).c(this.hn);
                hnVarHw.x(this.zo);
            }
            hnVarHw.pr(ofVar, false);
        } else {
            final String strX = ofVar.x();
            com.byazt.nv.hn hnVar = this.x.get(ofVar.ho().hw());
            if (hnVar != null) {
                hnVar.hw(this.fw);
                hnVar.x(this.zo);
                if (hnVar instanceof com.byazt.ri.pr) {
                    ((com.byazt.ri.pr) hnVar).fw().pr(this.c);
                }
                hnVar.pr(ofVar, false);
                hnVar.pr(new com.byazt.nv.pr() { // from class: com.byazt.dp.hw.1
                    @Override // com.byazt.nv.pr
                    public void pr() {
                        com.byazt.dp.pr.pr(strX);
                    }

                    @Override // com.byazt.nv.pr
                    public void pr(long j, long j2, String str2, String str3) {
                        com.byazt.dp.pr.pr(strX, j, j2);
                    }

                    @Override // com.byazt.nv.pr
                    public void hw(long j, long j2, String str2, String str3) {
                        com.byazt.dp.pr.hw(strX, j, j2);
                    }

                    @Override // com.byazt.nv.pr
                    public void hn(long j, long j2, String str2, String str3) {
                        com.byazt.dp.pr.hn(strX, j, j2);
                    }

                    @Override // com.byazt.nv.pr
                    public void pr(long j, String str2, String str3) {
                        com.byazt.dp.pr.hw(strX);
                    }

                    @Override // com.byazt.nv.pr
                    public void pr(String str2, String str3) {
                        com.byazt.dp.pr.hn(strX);
                    }
                });
            }
        }
        if (context instanceof com.byazt.hb.hw) {
            ((com.byazt.hb.hw) context).pr(1);
        }
    }

    @Override // com.byazt.dp.x
    public void pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
            pr(pr(this.pr, jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
        }
    }

    private void pr(of ofVar, JSONObject jSONObject) {
        if (this.hw == null || ofVar == null || ofVar.ho() == null) {
            return;
        }
        String strHw = ofVar.ho().hw();
        if (this.x.containsKey(strHw)) {
            com.byazt.nv.hn hnVarRemove = this.x.remove(strHw);
            if (hnVarRemove != null) {
                try {
                    hnVarRemove.hn();
                } catch (JSONException e) {
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", TrackAction.SUCCESS);
            jSONObject2.put(NotificationCompat.CATEGORY_STATUS, "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.hw.hw("app_ad_event", jSONObject2);
        }
    }

    @Override // com.byazt.dp.x
    public void hw(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && this.hw != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
            com.byazt.nv.hn hnVar = this.x.get(pr(this.pr, jSONObjectOptJSONObject, (String) null).ho().hw());
            if (hnVar != null) {
                hnVar.x();
            }
        }
    }

    @Override // com.byazt.dp.x
    public void pr(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.dp.x
    public void pr(String str, boolean z) {
        com.byazt.nv.hn hnVar;
        if (!TextUtils.isEmpty(str) && (hnVar = this.x.get(str)) != null) {
            hnVar.pr(z);
        }
    }

    @Override // com.byazt.dp.x
    public void hw(boolean z) {
        this.fw = z;
    }

    @Override // com.byazt.dp.x
    public void hn(boolean z) {
        this.zo = z;
    }

    private com.byazt.nv.hn pr(Context context, of ofVar, final JSONObject jSONObject, String str) {
        com.byazt.nv.hn hnVarHw = zo.hw(context, ofVar, str);
        if (hnVarHw instanceof com.byazt.ri.pr) {
            ((com.byazt.ri.pr) hnVarHw).c(this.hn);
        }
        final String strX = ofVar.x();
        hnVarHw.pr(new com.byazt.nv.pr() { // from class: com.byazt.dp.hw.2
            @Override // com.byazt.nv.pr
            public void pr() {
                com.byazt.dp.pr.pr(strX);
                pr(NotificationCompat.CATEGORY_STATUS, "idle");
                if (hw.this.uc != null) {
                    hw.this.uc.pr();
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, long j2, String str2, String str3) {
                com.byazt.dp.pr.pr(strX, j, j2);
                pr(NotificationCompat.CATEGORY_STATUS, "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (hw.this.uc != null) {
                    hw.this.uc.pr(j, j2, str2, str3);
                }
            }

            @Override // com.byazt.nv.pr
            public void hw(long j, long j2, String str2, String str3) {
                com.byazt.dp.pr.hw(strX, j, j2);
                pr(NotificationCompat.CATEGORY_STATUS, "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (hw.this.uc != null) {
                    hw.this.uc.hw(j, j2, str2, str3);
                }
            }

            @Override // com.byazt.nv.pr
            public void hn(long j, long j2, String str2, String str3) {
                com.byazt.dp.pr.hn(strX, j, j2);
                pr(NotificationCompat.CATEGORY_STATUS, "download_failed", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (hw.this.uc != null) {
                    hw.this.uc.hn(j, j2, str2, str3);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, String str2, String str3) {
                com.byazt.dp.pr.hw(strX);
                pr(NotificationCompat.CATEGORY_STATUS, "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
                if (hw.this.uc != null) {
                    hw.this.uc.pr(j, str2, str3);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(String str2, String str3) {
                com.byazt.dp.pr.hn(strX);
                pr(NotificationCompat.CATEGORY_STATUS, "installed");
                if (hw.this.uc != null) {
                    hw.this.uc.pr(str2, str3);
                }
            }

            private void pr(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", TrackAction.SUCCESS);
                    jSONObject2.put("appad", jSONObject);
                    for (int i = 0; i < strArr.length; i += 2) {
                        jSONObject2.put(strArr[i], strArr[i + 1]);
                    }
                    hw.this.hw.hw("app_ad_event", jSONObject2);
                } catch (JSONException e) {
                }
            }
        });
        return hnVarHw;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 480, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public static ConcurrentHashMap<String, JSONObject> pr = new ConcurrentHashMap<>();

        public static synchronized JSONObject pr(String str) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = pr;
            if (concurrentHashMap == null) {
                return new JSONObject();
            }
            JSONObject jSONObject = concurrentHashMap.get(str);
            if (jSONObject != null) {
                return jSONObject;
            }
            return new JSONObject();
        }

        public static synchronized void pr(String str, int i, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (pr == null) {
                pr = new ConcurrentHashMap<>();
            }
            JSONObject jSONObject = pr.get(str);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                pr.put(str, jSONObject);
            }
            try {
                jSONObject.put("downloadStatus", i);
                jSONObject.put("downloadProcessRate", i2);
                jSONObject.put(PluginConstants.KEY_ERROR_CODE, 0);
                jSONObject.put("codeMsg", "get ad_down_load_id success");
            } catch (Exception e) {
            }
        }
    }
}
