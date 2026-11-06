package com.byazt.txb;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.vf.wo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 775, 26})
public final class qg {
    public static final qg n = new qg();
    public volatile l<s> qg = l.n(2);

    public static qg n() {
        return n;
    }

    public void n(int i) {
        if (this.qg == null) {
            return;
        }
        this.qg.qg(i);
        qg(i);
    }

    public s n(wo.n nVar, final String str) {
        s sVar = this.qg != null ? (s) this.qg.n() : null;
        if (sVar != null) {
            sVar.n(nVar);
            sVar.post(new Runnable() { // from class: com.byazt.txb.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return sVar;
        }
        return qg(nVar, str);
    }

    public Handler n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "csj-handler";
        }
        return n((wo.n) null, str);
    }

    private s qg(wo.n nVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        try {
            handlerThread.start();
            return new s(handlerThread.getLooper(), nVar);
        } catch (InternalError e) {
            n(str, e);
            return new n(Looper.getMainLooper(), nVar);
        }
    }

    private void n(final String str, InternalError internalError) {
        try {
            com.byazt.sf.s sVar = (com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.qp.q.qg(null));
            if (sVar == null) {
                return;
            }
            final String stackTraceString = Log.getStackTraceString(internalError);
            sVar.n("exception", (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.txb.qg.2
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("scene", "shutdown_handler");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.putOpt("thread_name", str);
                    jSONObject3.putOpt("exception", stackTraceString);
                    jSONObject2.putOpt("object", jSONObject3);
                    return jSONObject2;
                }
            });
        } catch (Throwable unused) {
        }
    }

    public boolean n(Handler handler) {
        if (this.qg == null) {
            if (handler != null) {
                handler.getLooper().quit();
            }
            return false;
        }
        if (!(handler instanceof s)) {
            return false;
        }
        s sVar = (s) handler;
        if (this.qg.n(sVar)) {
            return true;
        }
        sVar.n();
        return true;
    }

    public void qg() {
        qg(0);
        this.qg = null;
    }

    private void qg(int i) {
        s sVar;
        while (this.qg.qg() > i && (sVar = (s) this.qg.n()) != null) {
            sVar.n();
        }
    }
}
