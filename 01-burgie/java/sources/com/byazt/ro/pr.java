package com.byazt.ro;

import android.os.Looper;
import android.os.Message;
import com.byazt.ca.iu;
import com.byazt.ch.ny;
import com.byazt.ea.hn;
import com.byazt.ea.w;
import com.byazt.gu.fw;
import com.byazt.hg.of;
import com.byazt.mq.zo;
import com.byazt.qx.a;
import com.byazt.so.hw;
import com.byazt.vkw.qi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 38, 37})
public class pr implements qi.pr {
    public zo c;
    public final of hn;
    public fw hw;
    public iu pr = new iu(Looper.getMainLooper(), this);
    public hw uc;
    public com.byazt.mq.fw x;

    public pr(of ofVar) {
        this.hn = ofVar;
    }

    public void pr(zo zoVar) {
        this.c = zoVar;
    }

    public void pr(com.byazt.mq.fw fwVar) {
        this.x = fwVar;
    }

    public void pr(hw hwVar) {
        this.uc = hwVar;
    }

    public void pr(String str, String str2, final int i, final int i2, int i3) {
        if (i3 > 0) {
            this.pr.sendEmptyMessageDelayed(1, i3);
        }
        w.pr(str, str2, new hn() { // from class: com.byazt.ro.pr.1
            @Override // com.byazt.ea.hn
            public void pr(String str3) {
                try {
                    pr prVar = pr.this;
                    prVar.pr(prVar.hn, new JSONObject(str3), i, i2);
                } catch (Throwable th) {
                    if (pr.this.x != null) {
                        pr.this.x.pr(-1, "render fail");
                    }
                }
            }

            @Override // com.byazt.ea.hn
            public void pr() {
                if (pr.this.x != null) {
                    pr.this.x.pr(-1, "request fail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(of ofVar, JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
        } catch (Throwable th) {
        }
        com.byazt.gu.hw.pr prVar = new com.byazt.gu.hw.pr();
        prVar.pr(com.byazt.hc.hw.pr(ofVar, jSONObject2, jSONObject, false, null, false));
        prVar.pr((ny) new a());
        prVar.pr(i);
        prVar.hw(0.0f);
        fw fwVar = new fw(com.byazt.sd.a.getContext(), null, prVar.pr(), null);
        this.hw = fwVar;
        com.byazt.mq.fw fwVar2 = this.x;
        if (fwVar2 != null) {
            fwVar.pr(fwVar2);
        }
        zo zoVar = this.c;
        if (zoVar != null) {
            this.hw.pr(zoVar);
        }
        hw hwVar = this.uc;
        if (hwVar != null) {
            this.hw.pr(hwVar);
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1:
                com.byazt.mq.fw fwVar = this.x;
                if (fwVar != null) {
                    fwVar.pr(-2, "render timeout");
                }
                break;
        }
    }
}
