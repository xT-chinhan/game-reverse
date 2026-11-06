package com.byazt.ee;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 37})
public abstract class pr {
    public Handler fw;
    public zo hn;
    public m hw;
    public Context pr;
    public fw uc;
    public String x;
    public volatile boolean c = false;
    public final Map<String, fw> zo = new HashMap();

    public abstract Context getContext(vk vkVar);

    public abstract String pr();

    public abstract void pr(vk vkVar);

    public abstract void pr(String str);

    public Handler hw() {
        if (this.fw == null) {
            this.fw = new Handler(Looper.getMainLooper());
        }
        return this.fw;
    }

    public void pr(Looper looper) {
        if (looper == null) {
            return;
        }
        this.fw = new Handler(looper);
    }

    public void invokeMethod(final String str) {
        if (this.c) {
            return;
        }
        hw().post(new Runnable() { // from class: com.byazt.ee.pr.1
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.c) {
                    return;
                }
                nt ntVarPr = null;
                try {
                    ntVarPr = pr.this.pr(new JSONObject(str));
                } catch (Exception e) {
                    aj.hw("Exception thrown while parsing function.", e);
                }
                if (nt.pr(ntVarPr)) {
                    if (ntVarPr != null) {
                        pr.this.hw(rc.pr(new lb(ntVarPr.pr, "Failed to parse invocation.")), ntVarPr);
                        return;
                    }
                    return;
                }
                pr.this.pr(ntVarPr);
            }
        });
    }

    public void pr(String str, nt ntVar) {
        pr(str);
    }

    public void hn() {
        this.uc.pr();
        Iterator<fw> it = this.zo.values().iterator();
        while (it.hasNext()) {
            it.next().pr();
        }
        hw().removeCallbacksAndMessages(null);
        this.c = true;
    }

    public final void pr(nt ntVar) {
        if (this.c) {
            return;
        }
        String strPr = pr();
        if (strPr == null) {
            strPr = "";
        }
        fw fwVarHw = hw(ntVar.fw);
        if (fwVarHw == null) {
            if (this.hw != null) {
                pr();
            }
            hw(rc.pr(new lb(-4, "Namespace " + ntVar.fw + " unknown.")), ntVar);
            return;
        }
        uc ucVar = new uc();
        ucVar.hw = strPr;
        ucVar.pr = this.pr;
        ucVar.hn = fwVarHw;
        try {
            fw.pr prVarPr = fwVarHw.pr(ntVar, ucVar);
            if (prVarPr == null) {
                hw(rc.pr(new lb(-2, "Function " + ntVar.x + " is not registered.")), ntVar);
            } else if (prVarPr.pr) {
                hw(prVarPr.hw, ntVar);
            }
        } catch (Exception e) {
            aj.pr("call finished with error, ".concat(String.valueOf(ntVar)), e);
            hw(rc.pr(e), ntVar);
        }
    }

    public final void pr(vk vkVar, cz czVar) {
        this.pr = getContext(vkVar);
        this.hn = vkVar.x;
        this.hw = vkVar.aj;
        this.uc = new fw(vkVar, this, czVar);
        this.x = vkVar.w;
        pr(vkVar);
    }

    public final <T> void pr(String str, T t) {
        if (this.c) {
            return;
        }
        pr("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + this.hn.pr(t) + "}");
    }

    public final void hw(String str, nt ntVar) {
        JSONObject jSONObject;
        if (this.c || TextUtils.isEmpty(ntVar.uc)) {
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            aj.pr(new IllegalArgumentException("Illegal callback data: ".concat(String.valueOf(str))));
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            jSONObject = new JSONObject();
        }
        pr(ho.pr().pr("__msg_type", "callback").pr("__callback_id", ntVar.uc).pr("__params", jSONObject).hw(), ntVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nt pr(JSONObject jSONObject) {
        String strOptString;
        if (this.c) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt != null) {
                    if (objOpt instanceof JSONObject) {
                        strOptString = String.valueOf((JSONObject) objOpt);
                    } else if (objOpt instanceof String) {
                        strOptString = (String) objOpt;
                    } else {
                        strValueOf = String.valueOf(objOpt);
                        strOptString = strValueOf;
                    }
                } else {
                    strOptString = strValueOf;
                }
            } catch (Throwable th) {
                strOptString = jSONObject.optString("params");
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return nt.pr().pr(string2).hw(string).hn(strOptString3).x(strOptString).c(strOptString2).uc(strOptString4).fw(jSONObject.optString("__iframe_url")).pr();
        } catch (JSONException e) {
            aj.hw("Failed to create call.", e);
            return nt.pr(strOptString2, -1);
        }
    }

    private fw hw(String str) {
        if (TextUtils.equals(str, this.x) || TextUtils.isEmpty(str)) {
            return this.uc;
        }
        return this.zo.get(str);
    }
}
