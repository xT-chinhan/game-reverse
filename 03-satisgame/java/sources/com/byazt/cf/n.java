package com.byazt.cf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, 19})
public abstract class n {
    public Context n;
    public String q;
    public oa qg;
    public fs s;
    public x w;
    public Handler x;
    public volatile boolean l = false;
    public final Map<String, x> fs = new HashMap();

    public abstract Context getContext(tj tjVar);

    public abstract String n();

    public abstract void n(tj tjVar);

    public abstract void n(String str);

    public Handler qg() {
        if (this.x == null) {
            this.x = new Handler(Looper.getMainLooper());
        }
        return this.x;
    }

    public void n(Looper looper) {
        if (looper == null) {
            return;
        }
        this.x = new Handler(looper);
    }

    public void invokeMethod(final String str) {
        if (this.l) {
            return;
        }
        qg().post(new Runnable() { // from class: com.byazt.cf.n.1
            @Override // java.lang.Runnable
            public void run() {
                k kVarN;
                if (n.this.l) {
                    return;
                }
                try {
                    kVarN = n.this.n(new JSONObject(str));
                } catch (Exception e) {
                    rv.qg("Exception thrown while parsing function.", e);
                    kVarN = null;
                }
                if (!k.n(kVarN)) {
                    n.this.n(kVarN);
                } else if (kVarN != null) {
                    n.this.qg(wm.n(new hd(kVarN.n, "Failed to parse invocation.")), kVarN);
                }
            }
        });
    }

    public void n(String str, k kVar) {
        n(str);
    }

    public void s() {
        this.w.n();
        Iterator<x> it = this.fs.values().iterator();
        while (it.hasNext()) {
            it.next().n();
        }
        qg().removeCallbacksAndMessages(null);
        this.l = true;
    }

    public final void n(k kVar) {
        if (this.l) {
            return;
        }
        String strN = n();
        if (strN == null) {
            strN = "";
        }
        x xVarQg = qg(kVar.x);
        if (xVarQg == null) {
            if (this.qg != null) {
                n();
            }
            qg(wm.n(new hd(-4, "Namespace " + kVar.x + " unknown.")), kVar);
            return;
        }
        w wVar = new w();
        wVar.qg = strN;
        wVar.n = this.n;
        wVar.s = xVarQg;
        try {
            x.n nVarN = xVarQg.n(kVar, wVar);
            if (nVarN == null) {
                qg(wm.n(new hd(-2, "Function " + kVar.q + " is not registered.")), kVar);
            } else if (nVarN.n) {
                qg(nVarN.qg, kVar);
            }
        } catch (Exception e) {
            rv.n("call finished with error, ".concat(String.valueOf(kVar)), e);
            qg(wm.n(e), kVar);
        }
    }

    public final void n(tj tjVar, a aVar) {
        this.n = getContext(tjVar);
        this.s = tjVar.q;
        this.qg = tjVar.rv;
        this.w = new x(tjVar, this, aVar);
        this.q = tjVar.cp;
        n(tjVar);
    }

    public final <T> void n(String str, T t) {
        if (this.l) {
            return;
        }
        n("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + this.s.n(t) + "}");
    }

    public final void qg(String str, k kVar) {
        if (this.l || TextUtils.isEmpty(kVar.w)) {
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            rv.n(new IllegalArgumentException("Illegal callback data: ".concat(String.valueOf(str))));
        }
        n("{\"__msg_type\":\"callback\",\"__callback_id\":" + JSONObject.quote(kVar.w) + ",\"__params\":" + str + "}", kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k n(JSONObject jSONObject) {
        String strOptString;
        if (this.l) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt == null) {
                    strOptString = strValueOf;
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else {
                    if (objOpt instanceof String) {
                        strValueOf = (String) objOpt;
                    } else {
                        strValueOf = String.valueOf(objOpt);
                    }
                    strOptString = strValueOf;
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString("params");
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return k.n().n(string2).qg(string).s(strOptString3).q(strOptString).l(strOptString2).w(strOptString4).x(jSONObject.optString("__iframe_url")).n();
        } catch (JSONException e) {
            rv.qg("Failed to create call.", e);
            return k.n(strOptString2, -1);
        }
    }

    private x qg(String str) {
        if (TextUtils.equals(str, this.q) || TextUtils.isEmpty(str)) {
            return this.w;
        }
        return this.fs.get(str);
    }
}
