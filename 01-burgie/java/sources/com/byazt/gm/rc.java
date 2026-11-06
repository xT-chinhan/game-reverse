package com.byazt.gm;

import com.byazt.mg.PluginConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 91})
public class rc extends com.byazt.ee.x<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sd.nl> pr;

    public rc(com.byazt.sd.nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    public static void pr(com.byazt.ee.yb ybVar, final com.byazt.sd.nl nlVar) {
        ybVar.pr("mallTopbarClick", new com.byazt.ee.x.hw() { // from class: com.byazt.gm.rc.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new rc(nlVar);
            }
        });
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.sd.zo.nt().of();
        WeakReference<com.byazt.sd.nl> weakReference = this.pr;
        if (weakReference == null) {
            return;
        }
        if (weakReference.get() == null || jSONObject == null) {
            hn();
            return;
        }
        String strOptString = jSONObject.optString("schema");
        if (strOptString.isEmpty()) {
            hn();
        } else {
            pr(strOptString, jSONObject.optBoolean("sync_auth", false));
        }
    }

    private void pr(final String str, boolean z) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        if (2 == com.byazt.eg.hw.pr().c()) {
            pr(str, jSONObject);
            return;
        }
        int iPr = com.byazt.eg.hw.pr().pr(new com.byazt.mh.hw() { // from class: com.byazt.gm.rc.2
            @Override // com.byazt.mh.hw
            public void pr(Object obj) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey(PluginConstants.KEY_ERROR_CODE)) {
                        Object obj2 = map.get(PluginConstants.KEY_ERROR_CODE);
                        if (obj2 instanceof String) {
                            try {
                                int i = Integer.parseInt((String) obj2);
                                if (i == 1) {
                                    rc.this.pr(str, jSONObject);
                                    return;
                                }
                                try {
                                    jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
                                } catch (JSONException e) {
                                }
                                rc.this.pr(i, "授权失败");
                                rc.this.pr(jSONObject);
                                return;
                            } catch (NumberFormatException e2) {
                            }
                        }
                    }
                }
                try {
                    jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, -1);
                } catch (JSONException e3) {
                }
                rc.this.pr(-1, "授权失败");
                rc.this.pr(jSONObject);
            }
        }, z);
        jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(iPr));
        if (iPr != 1) {
            pr(iPr, "执行授权失败");
            pr(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, JSONObject jSONObject) {
        int iPr = com.byazt.eg.hw.pr().pr(str);
        try {
            jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(iPr));
        } catch (JSONException e) {
        }
        if (iPr != 1) {
            pr(iPr, "schema 解析失败");
        }
        pr(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, String str) {
        com.byazt.ca.b.pr(com.byazt.sd.a.getContext(), "努力加载中，请稍后再试", 1);
    }

    @Override // com.byazt.ee.x
    public void x() {
        this.pr = null;
    }
}
