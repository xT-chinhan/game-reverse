package com.bytedance.sdk.component.ms;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    ab ab;
    protected x ah;
    protected String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f1259ms;
    protected zb xr;
    protected Handler d = new Handler(Looper.getMainLooper());
    protected volatile boolean c = false;
    private final Map<String, ab> x = new HashMap();

    protected abstract Context getContext(ch chVar);

    protected abstract String ms();

    protected abstract void ms(ch chVar);

    protected abstract void ms(String str);

    protected ms() {
    }

    protected void invokeMethod(final String str) {
        if (this.c) {
            return;
        }
        ny.ms("Received call: ".concat(String.valueOf(str)));
        this.d.post(new Runnable() { // from class: com.bytedance.sdk.component.ms.ms.1
            @Override // java.lang.Runnable
            public void run() {
                ao aoVarMs;
                if (ms.this.c) {
                    return;
                }
                try {
                    aoVarMs = ms.this.ms(new JSONObject(str));
                } catch (Exception e) {
                    ny.xr("Exception thrown while parsing function.", e);
                    aoVarMs = null;
                }
                if (ao.ms(aoVarMs)) {
                    ny.ms("By pass invalid call: ".concat(String.valueOf(aoVarMs)));
                    if (aoVarMs != null) {
                        ms.this.xr(i.ms(new qv(aoVarMs.f1251ms, "Failed to parse invocation.")), aoVarMs);
                        return;
                    }
                    return;
                }
                ms.this.ms(aoVarMs);
            }
        });
    }

    protected void ms(String str, ao aoVar) {
        ms(str);
    }

    protected void xr() {
        this.ab.ms();
        Iterator<ab> it = this.x.values().iterator();
        while (it.hasNext()) {
            it.next().ms();
        }
        this.d.removeCallbacksAndMessages(null);
        this.c = true;
    }

    protected final void ms(ao aoVar) {
        String strMs;
        if (this.c || (strMs = ms()) == null) {
            return;
        }
        ab abVarXr = xr(aoVar.ab);
        if (abVarXr == null) {
            ny.xr("Received call with unknown namespace, ".concat(String.valueOf(aoVar)));
            if (this.xr != null) {
                ms();
            }
            xr(i.ms(new qv(-4, "Namespace " + aoVar.ab + " unknown.")), aoVar);
            return;
        }
        c cVar = new c();
        cVar.xr = strMs;
        cVar.f1254ms = this.f1259ms;
        cVar.ah = abVarXr;
        try {
            ab.ms msVarMs = abVarXr.ms(aoVar, cVar);
            if (msVarMs == null) {
                ny.xr("Received call but not registered, ".concat(String.valueOf(aoVar)));
                if (this.xr != null) {
                    ms();
                }
                xr(i.ms(new qv(-2, "Function " + aoVar.d + " is not registered.")), aoVar);
                return;
            }
            if (msVarMs.f1249ms) {
                xr(msVarMs.xr, aoVar);
            }
            if (this.xr != null) {
                ms();
            }
        } catch (Exception e) {
            ny.ms("call finished with error, ".concat(String.valueOf(aoVar)), e);
            xr(i.ms(e), aoVar);
        }
    }

    final void ms(ch chVar, nw nwVar) {
        this.f1259ms = getContext(chVar);
        this.ah = chVar.d;
        this.xr = chVar.ny;
        this.ab = new ab(chVar, this, nwVar);
        this.ka = chVar.hi;
        ms(chVar);
    }

    final <T> void ms(String str, T t) {
        if (this.c) {
            return;
        }
        String strMs = this.ah.ms(t);
        ny.ms("Sending js event: ".concat(String.valueOf(str)));
        ms("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + strMs + "}");
    }

    final void xr(String str, ao aoVar) {
        JSONObject jSONObject;
        if (this.c) {
            return;
        }
        if (TextUtils.isEmpty(aoVar.c)) {
            ny.ms("By passing js callback due to empty callback: ".concat(String.valueOf(str)));
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            ny.ms(new IllegalArgumentException("Illegal callback data: ".concat(String.valueOf(str))));
        }
        ny.ms("Invoking js callback: " + aoVar.c);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        ms(ub.ms().ms("__msg_type", "callback").ms("__callback_id", aoVar.c).ms("__params", jSONObject).xr(), aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ao ms(JSONObject jSONObject) {
        String strOptString;
        if (this.c) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        if (ms() == null) {
            return null;
        }
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
            return ao.ms().ms(string2).xr(string).ah(strOptString3).d(strOptString).ka(strOptString2).c(strOptString4).ab(jSONObject.optString("__iframe_url")).ms();
        } catch (JSONException e) {
            ny.xr("Failed to create call.", e);
            return ao.ms(strOptString2, -1);
        }
    }

    private ab xr(String str) {
        if (TextUtils.equals(str, this.ka) || TextUtils.isEmpty(str)) {
            return this.ab;
        }
        return this.x.get(str);
    }
}
