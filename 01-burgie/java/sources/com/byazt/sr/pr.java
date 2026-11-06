package com.byazt.sr;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.byazt.az.hw;
import com.byazt.ch.a;
import com.byazt.ch.g;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.byazt.dd.fw;
import com.byazt.ea.zo;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import com.byazt.ik.hn;
import com.byazt.mw.PageWebView;
import com.byazt.wt.c;
import com.byazt.wt.rc;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1437, 37})
public class pr implements a, lb {
    public JSONObject aj;
    public hn c;
    public hw fw;
    public com.byazt.qk.pr hn;
    public ViewGroup hw;
    public Context pr;
    public com.byazt.ql.pr uc;
    public Map<String, Object> vk;
    public of x;
    public vk zo;

    public pr(Context context, ViewGroup viewGroup, com.byazt.qk.pr prVar, of ofVar) {
        this.pr = context;
        this.hw = viewGroup;
        this.hn = prVar;
        this.x = ofVar;
    }

    public void pr(com.byazt.ql.pr prVar) {
        this.uc = prVar;
    }

    public void pr(DownloadListener downloadListener) {
        PageWebView.pr(this.aj, downloadListener);
    }

    public void pr() {
        com.byazt.qk.pr prVar = this.hn;
        if (prVar == null) {
            com.byazt.ql.pr prVar2 = this.uc;
            if (prVar2 != null) {
                prVar2.pr(-1);
                return;
            }
            return;
        }
        JSONObject jSONObjectPr = zo.pr().pr(prVar.pr(), this.hn.hw());
        if (jSONObjectPr == null) {
            com.byazt.pk.hn.pr(this.hn, new com.byazt.pk.hn.hw() { // from class: com.byazt.sr.pr.1
                @Override // com.byazt.pk.hn.hw
                public void pr(JSONObject jSONObject) {
                    pr.this.pr(jSONObject);
                }

                @Override // com.byazt.pk.hn.hw
                public void pr() {
                    if (pr.this.uc != null) {
                        pr.this.uc.pr(-1);
                    }
                }
            });
        } else {
            pr(jSONObjectPr);
        }
    }

    public void pr(final JSONObject jSONObject) {
        final ho hoVar = new ho(this.pr);
        final JSONObject jSONObject2 = this.x.to();
        this.aj = jSONObject2;
        g gVar = new g();
        gVar.pr(this.pr);
        HashMap map = new HashMap();
        map.put("key_reward_page", this.vk);
        gVar.pr(map);
        hoVar.pr("reward_page", gVar);
        hoVar.pr((lb) this);
        com.byazt.sd.lb.uc().post(new Runnable() { // from class: com.byazt.sr.pr.2
            @Override // java.lang.Runnable
            public void run() {
                pr.this.c = hoVar.pr(jSONObject);
                if (pr.this.c == null) {
                    if (pr.this.uc != null) {
                        pr.this.uc.pr(-1);
                    }
                } else {
                    hoVar.hw(jSONObject2);
                    pr.this.hw.addView(pr.this.c.aj(), new FrameLayout.LayoutParams(pr.this.c.e(), pr.this.c.s()));
                    if (pr.this.uc != null) {
                        pr.this.uc.pr(pr.this.c.aj());
                    }
                }
            }
        });
    }

    @Override // com.byazt.ch.lb
    public void pr(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        if (ntVar != null && ntVar.hw() == 1) {
            pr(ntVar, ntVar.hn());
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(hn hnVar, String str, fw.pr prVar) {
    }

    private void pr(nt ntVar, JSONObject jSONObject) {
        if (jSONObject == null) {
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        switch (strOptString) {
            case "clickEvent":
                hw hwVar = this.fw;
                if (hwVar != null) {
                    hwVar.pr(ntVar.pr().aj(), this.zo);
                    break;
                }
                break;
            case "openPolicy":
                c.pr(this.pr, this.x);
                break;
        }
    }

    public void pr(hw hwVar) {
        this.fw = hwVar;
    }

    @Override // com.byazt.ch.a
    public void pr(hn hnVar, MotionEvent motionEvent) {
        this.zo.hn(motionEvent.getDeviceId());
        this.zo.hw(motionEvent.getToolType(0));
        this.zo.x(motionEvent.getSource());
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.zo.c((int) motionEvent.getRawX());
                this.zo.uc((int) motionEvent.getRawY());
                this.zo.pr(motionEvent.getRawX());
                this.zo.hw(motionEvent.getRawY());
                this.zo.pr(System.currentTimeMillis());
                this.zo.hw(motionEvent.getToolType(0));
                this.zo.hn(motionEvent.getDeviceId());
                this.zo.x(motionEvent.getSource());
                this.zo.hw(true);
                rc.pr(motionEvent);
                break;
            case 1:
                this.zo.hn(motionEvent.getRawX());
                this.zo.x(motionEvent.getRawY());
                this.zo.hw(System.currentTimeMillis());
                break;
            case 2:
                this.zo.hn(motionEvent.getRawX());
                this.zo.x(motionEvent.getRawY());
                break;
        }
    }

    public void pr(Map<String, Object> map) {
        this.vk = map;
    }

    public void hw() {
        PageWebView.pr(this.aj);
    }
}
