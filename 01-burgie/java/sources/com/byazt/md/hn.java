package com.byazt.md;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.af.w;
import com.byazt.ca.b;
import com.byazt.hcx.m;
import com.byazt.hg.g;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.sd.lb;
import com.byazt.zp.zo;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 238, 20})
public class hn {
    public final AtomicBoolean c = new AtomicBoolean(true);
    public Map<String, Object> fw;
    public final Context hn;
    public final g hw;
    public w pr;
    public hw uc;
    public String x;

    public interface hw {
        void pr();

        void pr(String str, boolean z);
    }

    public interface pr {
        void pr();
    }

    public hn(w wVar, g gVar, Context context, Map<String, Object> map) {
        this.pr = wVar;
        this.hn = context;
        this.hw = gVar;
        this.fw = map;
    }

    public hn pr(String str) {
        this.x = str;
        return this;
    }

    public void pr(hw hwVar) {
        this.uc = hwVar;
    }

    public static boolean pr(w wVar, boolean z) {
        g gVarQa = wVar != null ? wVar.qa() : null;
        if (gVarQa == null || !gVarQa.hw(z)) {
            return false;
        }
        return true;
    }

    public static boolean pr(g gVar, boolean z) {
        if (gVar == null || !gVar.hw(z)) {
            return false;
        }
        return true;
    }

    public int pr(final pr prVar) {
        g gVar = this.hw;
        pr(gVar);
        hw(gVar);
        lb.uc().postDelayed(new Runnable() { // from class: com.byazt.md.hn.1
            @Override // java.lang.Runnable
            public void run() {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr();
                }
            }
        }, 500L);
        return 1;
    }

    private void pr(g gVar) {
        if (gVar != null && !TextUtils.isEmpty(gVar.x())) {
            final String strX = gVar.x();
            zo.pr(new Runnable() { // from class: com.byazt.md.hn.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.hw(hn.this.hn.getApplicationContext(), strX, 0, 17, 0, 0);
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    private void hw(final g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            a.pr().pr(gVar.hw(), new fo.hn<m>() { // from class: com.byazt.md.hn.3
                @Override // com.byazt.sd.fo.hn
                public void pr(int i, String str) {
                    hn.this.pr();
                    hn.this.hn(gVar);
                }

                @Override // com.byazt.sd.fo.hn
                public void pr(m mVar) {
                    if (mVar == null || !mVar.fw() || TextUtils.isEmpty(mVar.zo())) {
                        hn.this.pr();
                        hn.this.hn(gVar);
                    } else {
                        try {
                            hn.this.pr(new JSONObject(mVar.zo()));
                        } catch (Throwable th) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        com.byazt.pj.pr.hw(com.byazt.lx.hw.pr(this.pr, this.fw), this.x, 4);
        hw hwVar = this.uc;
        if (hwVar != null) {
            hwVar.pr("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                hw(jSONObject);
            }
        } catch (Throwable th) {
            pr();
        }
    }

    private void hw(JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("is_apply_coupon");
        String strOptString = jSONObject.optString("error_type");
        of ofVarPr = com.byazt.lx.hw.pr(this.pr, this.fw);
        if (zOptBoolean && TrackAction.SUCCESS.equals(strOptString)) {
            com.byazt.pj.pr.hw(ofVarPr, this.x, 1);
        } else if (zOptBoolean && "has_applied".equals(strOptString)) {
            com.byazt.pj.pr.hw(ofVarPr, this.x, 2);
        } else if (!zOptBoolean) {
            com.byazt.pj.pr.hw(ofVarPr, this.x, 3);
        }
        if (this.uc != null) {
            if (zOptBoolean && TrackAction.SUCCESS.equals(strOptString)) {
                this.uc.pr();
            } else {
                this.uc.pr(strOptString, zOptBoolean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(g gVar) {
        if (this.c.getAndSet(false)) {
            hw(gVar);
        }
    }
}
