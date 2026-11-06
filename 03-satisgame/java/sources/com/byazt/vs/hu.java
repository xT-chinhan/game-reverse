package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 793})
public class hu extends com.byazt.cf.q<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    public hu(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }

    public static void n(com.byazt.cf.cy cyVar, final com.byazt.gcl.s sVar) {
        cyVar.n("mallTopbarClick", new com.byazt.cf.q.qg() { // from class: com.byazt.vs.hu.1
            @Override // com.byazt.cf.q.qg
            public com.byazt.cf.q n() {
                return new hu(sVar);
            }
        });
    }

    @Override // com.byazt.cf.q
    public void n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.vyf.s.cy().pk();
        WeakReference<com.byazt.gcl.s> weakReference = this.n;
        if (weakReference == null) {
            return;
        }
        if (weakReference.get() == null || jSONObject == null) {
            s();
            return;
        }
        String strOptString = jSONObject.optString("schema");
        if (strOptString.isEmpty()) {
            s();
        } else {
            n(strOptString, jSONObject.optBoolean("sync_auth", false));
        }
    }

    private void n(final String str, boolean z) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        if (2 == com.byazt.wq.qg.n().l()) {
            n(str, jSONObject);
            return;
        }
        int iN = com.byazt.wq.qg.n().n(new com.byazt.wc.qg() { // from class: com.byazt.vs.hu.2
            @Override // com.byazt.wc.qg
            public void n(Object obj) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("code")) {
                        Object obj2 = map.get("code");
                        if (obj2 instanceof String) {
                            try {
                                int i = Integer.parseInt((String) obj2);
                                if (i == 1) {
                                    hu.this.n(str, jSONObject);
                                    return;
                                }
                                try {
                                    jSONObject.putOpt("code", Integer.valueOf(i));
                                } catch (JSONException unused) {
                                }
                                hu.this.n(i, "授权失败");
                                hu.this.n(jSONObject);
                                return;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                    }
                }
                try {
                    jSONObject.putOpt("code", -1);
                } catch (JSONException unused3) {
                }
                hu.this.n(-1, "授权失败");
                hu.this.n(jSONObject);
            }
        }, z);
        jSONObject.putOpt("code", Integer.valueOf(iN));
        if (iN != 1) {
            n(iN, "执行授权失败");
            n(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, JSONObject jSONObject) {
        int iN = com.byazt.wq.qg.n().n(str);
        try {
            jSONObject.putOpt("code", Integer.valueOf(iN));
        } catch (JSONException unused) {
        }
        if (iN != 1) {
            n(iN, "schema 解析失败");
        }
        n(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        com.byazt.tk.h.n(com.byazt.nf.rv.getContext(), "努力加载中，请稍后再试", 1);
    }

    @Override // com.byazt.cf.q
    public void q() {
        this.n = null;
    }
}
