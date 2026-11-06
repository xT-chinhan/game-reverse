package com.byazt.fr;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.Window;
import com.anythink.core.common.f.e;
import com.byazt.ehw.DeviceUtils;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.nf.rv;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 671, 8})
public class s {
    public static final s n = new s();
    public volatile boolean cp;
    public com.byazt.mau.qg fs;
    public volatile boolean l;
    public volatile boolean w;
    public pk x;
    public float qg = -2.0f;
    public float s = -2.0f;
    public double q = -2.0d;
    public AtomicInteger rv = new AtomicInteger();
    public AtomicInteger tj = new AtomicInteger();
    public ConcurrentHashMap<Window, com.byazt.jjx.qg> d = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Window, com.byazt.mau.qg> oa = new ConcurrentHashMap<>();

    public static s n() {
        return n;
    }

    private s() {
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS == null) {
            return;
        }
        nVarS.qg(new com.byazt.ot.n.s() { // from class: com.byazt.fr.s.1
            @Override // com.byazt.ot.n.s, com.byazt.ot.n.InterfaceC0287n
            public void n(String str, Window window) {
                super.n(str, window);
                if (!TextUtils.isEmpty(str) && str.contains("com.byted.live.lite")) {
                    s sVar = s.this;
                    sVar.n(window, sVar.x, s.this.cp);
                }
            }

            @Override // com.byazt.ot.n.s, com.byazt.ot.n.InterfaceC0287n
            public void qg(String str, Window window) {
                super.qg(str, window);
                if (!TextUtils.isEmpty(str) && str.contains("com.byted.live.lite")) {
                    s sVar = s.this;
                    sVar.qg(window, sVar.x, false);
                }
            }
        });
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        double dOptDouble = jSONObject.optDouble("day_factor", 0.0d);
        double dOptDouble2 = jSONObject.optDouble("week_factor", 0.0d);
        double dOptDouble3 = jSONObject.optDouble("battery_factor", 0.0d);
        this.q = n.n(((((double) (qg.n() ? 1 : -1)) * dOptDouble2) + (((double) (qg.s() ? 1 : -1)) * dOptDouble) + (((double) (DeviceUtils.n.qg(rv.getContext()) < 50.0f ? -1 : 1)) * dOptDouble3)) * jSONObject.optDouble("factor", 0.0d), jSONObject);
    }

    public double qg() {
        return this.q;
    }

    public boolean s() {
        return this.l;
    }

    public void n(boolean z) {
        this.l = z;
    }

    public void n(float f) {
        this.qg = f;
    }

    public void qg(float f) {
        this.s = f;
    }

    public boolean q() {
        return this.w;
    }

    public float l() {
        return this.qg;
    }

    public float w() {
        if (this.s == -2.0f) {
            AudioManager audioManager = (AudioManager) rv.getContext().getSystemService(MediaFormat.KEY_AUDIO);
            if (audioManager == null) {
                return 0.0f;
            }
            this.s = audioManager.getStreamVolume(3);
        }
        return this.s;
    }

    public void n(Context context, pk pkVar, boolean z) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        this.cp = z;
        n(window, pkVar, z);
    }

    private void n(Window window, pk pkVar) {
        if (w.x(pkVar)) {
            this.x = pkVar;
            com.byazt.jjx.qg qgVar = new com.byazt.jjx.qg(window);
            boolean zS = qgVar.s(w.d(pkVar));
            if (window == null || !zS) {
                return;
            }
            rv();
            this.d.put(window, qgVar);
        }
    }

    private void x() {
        if (w.q(this.x)) {
            this.tj.incrementAndGet();
        }
    }

    private void fs() {
        if (this.tj.get() > 0 && w.q(this.x)) {
            this.tj.decrementAndGet();
        }
    }

    private void rv() {
        if (w.q(this.x)) {
            this.rv.incrementAndGet();
        }
    }

    private void tj() {
        if (this.rv.get() > 0 && w.q(this.x)) {
            this.rv.decrementAndGet();
        }
    }

    private void n(boolean z, pk pkVar, Window window) {
        if (!z && w.w(pkVar)) {
            this.x = pkVar;
            com.byazt.mau.qg qgVar = new com.byazt.mau.qg();
            this.fs = qgVar;
            qgVar.n(ta.x(pkVar));
            this.fs.n(w.ln(pkVar));
            boolean zS = this.fs.s(w.d(pkVar));
            if (window == null || !zS) {
                return;
            }
            x();
            this.oa.put(window, this.fs);
        }
    }

    public void n(Window window, pk pkVar, boolean z) {
        if (window == null) {
            return;
        }
        n(window, pkVar);
        n(z, pkVar, window);
    }

    private Window n(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow();
        }
        return null;
    }

    public void qg(Context context, pk pkVar, boolean z) {
        qg(n(context), pkVar, z);
    }

    public void qg(Window window, pk pkVar, boolean z) {
        if (w.x(pkVar) && z) {
            qg(window, pkVar);
        }
        if (w.w(pkVar)) {
            s(window, pkVar);
        }
    }

    private void qg(Window window, pk pkVar) {
        boolean z;
        if (window == null) {
            return;
        }
        com.byazt.jjx.qg qgVar = this.d.get(window);
        if (qgVar != null) {
            boolean zQ = w.q(pkVar);
            int iD = w.d(pkVar);
            if (zQ) {
                tj();
                z = this.rv.get() == 0;
            }
            qgVar.l(iD);
        }
        if (z) {
            this.d.remove(window);
        }
    }

    private void s(Window window, pk pkVar) {
        boolean z;
        if (window == null) {
            return;
        }
        com.byazt.mau.qg qgVar = this.oa.get(window);
        if (qgVar != null) {
            int iD = w.d(pkVar);
            if (w.q(pkVar)) {
                fs();
                z = this.tj.get() == 0;
            }
            qgVar.l(iD);
        }
        if (z) {
            this.oa.remove(window);
        }
    }

    public int n(int i, pk pkVar) {
        JSONObject jSONObjectQh;
        JSONArray jSONArrayOptJSONArray;
        int i2;
        int iD = w.d(pkVar);
        if ((iD == 9 || iD == 5) && (jSONObjectQh = rv.qg().qh()) != null) {
            int iOptInt = jSONObjectQh.optInt("enable");
            double dOptDouble = jSONObjectQh.optDouble(e.a.d);
            if (iOptInt == 1 && (jSONArrayOptJSONArray = jSONObjectQh.optJSONArray("valid_type")) != null && jSONArrayOptJSONArray.length() != 0) {
                boolean z = false;
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    if (iD == jSONArrayOptJSONArray.optInt(i3)) {
                        z = true;
                    }
                }
                if (z && (i2 = (int) (dOptDouble * 100.0d)) >= 0 && i2 <= 100) {
                    return i2;
                }
            }
        }
        return i;
    }

    public void n(int i) {
        com.byazt.mau.qg qgVar = this.fs;
        if (qgVar != null) {
            int iL = qgVar.l();
            if (this.w) {
                return;
            }
            this.w = iL != i;
            return;
        }
        this.w = true;
    }
}
