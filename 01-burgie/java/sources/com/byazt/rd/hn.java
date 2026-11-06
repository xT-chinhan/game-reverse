package com.byazt.rd;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.Window;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 89, 20})
public class hn {
    public static final hn pr = new hn();
    public volatile boolean c;
    public of fw;
    public volatile boolean uc;
    public volatile boolean w;
    public com.byazt.bt.hw zo;
    public float hw = -2.0f;
    public float hn = -2.0f;
    public double x = -2.0d;
    public AtomicInteger aj = new AtomicInteger();
    public AtomicInteger vk = new AtomicInteger();
    public ConcurrentHashMap<Window, com.byazt.en.hw> k = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Window, com.byazt.bt.hw> m = new ConcurrentHashMap<>();

    public static hn pr() {
        return pr;
    }

    private hn() {
        com.byazt.wt.pr prVarHn = zo.nt().hn();
        if (prVarHn == null) {
            return;
        }
        prVarHn.hw(new com.byazt.wt.pr.hn() { // from class: com.byazt.rd.hn.1
            @Override // com.byazt.wt.pr.hn, com.byazt.wt.pr.InterfaceC0225pr
            public void pr(String str, Window window) {
                super.pr(str, window);
                if (!TextUtils.isEmpty(str) && str.contains("com.byted.live.lite")) {
                    hn hnVar = hn.this;
                    hnVar.pr(window, hnVar.fw, hn.this.w);
                }
            }

            @Override // com.byazt.wt.pr.hn, com.byazt.wt.pr.InterfaceC0225pr
            public void hw(String str, Window window) {
                super.hw(str, window);
                if (!TextUtils.isEmpty(str) && str.contains("com.byted.live.lite")) {
                    hn hnVar = hn.this;
                    hnVar.hw(window, hnVar.fw, false);
                }
            }
        });
    }

    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        double dOptDouble = jSONObject.optDouble("day_factor", 0.0d);
        double dOptDouble2 = jSONObject.optDouble("week_factor", 0.0d);
        double dOptDouble3 = jSONObject.optDouble("battery_factor", 0.0d);
        this.x = pr.pr(((((double) (hw.pr() ? 1 : -1)) * dOptDouble2) + (((double) (hw.hn() ? 1 : -1)) * dOptDouble) + (((double) (DeviceUtils.pr.hw(a.getContext()) < 50.0f ? -1 : 1)) * dOptDouble3)) * jSONObject.optDouble("factor", 0.0d), jSONObject);
    }

    public double hw() {
        return this.x;
    }

    public boolean hn() {
        return this.c;
    }

    public void pr(boolean z) {
        this.c = z;
    }

    public void pr(float f) {
        this.hw = f;
    }

    public void hw(float f) {
        this.hn = f;
    }

    public boolean x() {
        return this.uc;
    }

    public float c() {
        return this.hw;
    }

    public float uc() {
        if (this.hn == -2.0f) {
            AudioManager audioManager = (AudioManager) a.getContext().getSystemService(MediaFormat.KEY_AUDIO);
            if (audioManager == null) {
                return 0.0f;
            }
            this.hn = audioManager.getStreamVolume(3);
        }
        return this.hn;
    }

    public void pr(Context context, of ofVar, boolean z) {
        Window window;
        if (!(context instanceof Activity)) {
            window = null;
        } else {
            window = ((Activity) context).getWindow();
        }
        this.w = z;
        pr(window, ofVar, z);
    }

    private void pr(Window window, of ofVar) {
        if (ls.fw(ofVar)) {
            this.fw = ofVar;
            com.byazt.en.hw hwVar = new com.byazt.en.hw(window);
            boolean zHn = hwVar.hn(ls.k(ofVar));
            if (window != null && zHn) {
                aj();
                this.k.put(window, hwVar);
            }
        }
    }

    private void fw() {
        if (ls.x(this.fw)) {
            this.vk.incrementAndGet();
        }
    }

    private void zo() {
        if (this.vk.get() > 0 && ls.x(this.fw)) {
            this.vk.decrementAndGet();
        }
    }

    private void aj() {
        if (ls.x(this.fw)) {
            this.aj.incrementAndGet();
        }
    }

    private void vk() {
        if (this.aj.get() > 0 && ls.x(this.fw)) {
            this.aj.decrementAndGet();
        }
    }

    private void pr(boolean z, of ofVar, Window window) {
        if (!z && ls.uc(ofVar)) {
            this.fw = ofVar;
            com.byazt.bt.hw hwVar = new com.byazt.bt.hw();
            this.zo = hwVar;
            hwVar.pr(qv.fw(ofVar));
            this.zo.pr(ls.iu(ofVar));
            boolean zHn = this.zo.hn(ls.k(ofVar));
            if (window != null && zHn) {
                fw();
                this.m.put(window, this.zo);
            }
        }
    }

    public void pr(Window window, of ofVar, boolean z) {
        if (window == null) {
            return;
        }
        pr(window, ofVar);
        pr(z, ofVar, window);
    }

    private Window pr(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow();
        }
        return null;
    }

    public void hw(Context context, of ofVar, boolean z) {
        hw(pr(context), ofVar, z);
    }

    public void hw(Window window, of ofVar, boolean z) {
        if (ls.fw(ofVar) && z) {
            hw(window, ofVar);
        }
        if (ls.uc(ofVar)) {
            hn(window, ofVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    private void hw(Window window, of ofVar) {
        if (window == null) {
            return;
        }
        com.byazt.en.hw hwVar = this.k.get(window);
        boolean z = true;
        if (hwVar != null) {
            boolean zX = ls.x(ofVar);
            int iK = ls.k(ofVar);
            if (zX) {
                vk();
                if (this.aj.get() != 0) {
                    z = false;
                } else {
                    hwVar.c(iK);
                }
            } else {
                hwVar.c(iK);
            }
        }
        if (z) {
            this.k.remove(window);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    private void hn(Window window, of ofVar) {
        if (window == null) {
            return;
        }
        com.byazt.bt.hw hwVar = this.m.get(window);
        boolean z = true;
        if (hwVar != null) {
            int iK = ls.k(ofVar);
            if (ls.x(ofVar)) {
                zo();
                if (this.vk.get() != 0) {
                    z = false;
                } else {
                    hwVar.c(iK);
                }
            } else {
                hwVar.c(iK);
            }
        }
        if (z) {
            this.m.remove(window);
        }
    }

    public int pr(int i, of ofVar) {
        JSONObject jSONObjectP;
        JSONArray jSONArrayOptJSONArray;
        int i2;
        int iK = ls.k(ofVar);
        if ((iK == 9 || iK == 5) && (jSONObjectP = a.hw().p()) != null) {
            int iOptInt = jSONObjectP.optInt("enable");
            double dOptDouble = jSONObjectP.optDouble(Constants.VALUE_FIELD);
            if (iOptInt == 1 && (jSONArrayOptJSONArray = jSONObjectP.optJSONArray("valid_type")) != null && jSONArrayOptJSONArray.length() != 0) {
                boolean z = false;
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    if (iK == jSONArrayOptJSONArray.optInt(i3)) {
                        z = true;
                    }
                }
                if (z && (i2 = (int) (dOptDouble * 100.0d)) >= 0 && i2 <= 100) {
                    return i2;
                }
            } else {
                return i;
            }
        }
        return i;
    }

    public void pr(int i) {
        com.byazt.bt.hw hwVar = this.zo;
        if (hwVar != null) {
            int iC = hwVar.c();
            if (!this.uc) {
                this.uc = iC != i;
                return;
            }
            return;
        }
        this.uc = true;
    }
}
