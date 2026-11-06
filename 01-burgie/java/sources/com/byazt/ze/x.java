package com.byazt.ze;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.of;
import com.byazt.hr.RecyclerView;
import com.byazt.sd.lb;
import com.byazt.um.c;
import com.byazt.um.uc;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 16, 121})
public class x extends com.byazt.sa.pr {
    public int fo;
    public List<com.byazt.um.hn> ny;
    public boolean rc;

    public x(Context context, ViewGroup viewGroup, com.byazt.pj.x xVar, of ofVar, String str, int i) {
        super(context, viewGroup, xVar, ofVar, str, i);
    }

    @Override // com.byazt.sa.pr
    public List<com.byazt.um.hn> w() {
        this.ny = new ArrayList();
        JSONObject jSONObject = this.c.to();
        this.ny.add(0, new com.byazt.um.hn(jSONObject, "header".hashCode()));
        this.ny.add(new com.byazt.um.hn(jSONObject, "shop_content".hashCode()));
        return this.ny;
    }

    public void c(int i) {
        this.fo = i;
        if (i < 0) {
            return;
        }
        final String str = String.format("浏览%d秒可领金币", Integer.valueOf(i));
        if (this.fw instanceof uc) {
            lb.uc().post(new Runnable() { // from class: com.byazt.ze.x.1
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.fw != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((uc) x.this.fw).pr();
                            if (recyclerView.getScrollState() == 0 && !recyclerView.g()) {
                                ((uc) x.this.fw).pr(0, "header");
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            });
            ((uc) this.fw).pr(new c.x() { // from class: com.byazt.ze.x.2
                @Override // com.byazt.um.c.x
                public void pr(RecyclerView.fo foVar, int i2) {
                    com.byazt.ik.hn hnVarX = ((c.C0210c) foVar).iu().x("count_down");
                    if (hnVarX instanceof com.byazt.id.hw) {
                        ((com.byazt.id.hw) hnVarX).k(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.sa.x
    public void x(com.byazt.ik.hn<View> hnVar) {
        pr(hnVar);
    }

    @Override // com.byazt.sa.x
    public void hw(int i, int i2) {
        if (i2 > 0) {
            this.vk.set(1);
        }
    }

    @Override // com.byazt.sa.x
    public void pr(RecyclerView recyclerView, int i) {
    }

    @Override // com.byazt.sa.x
    public void pr(com.byazt.ik.hn hnVar, int i, View view, com.byazt.um.hn hnVar2) {
        if (hnVar2 == null || hnVar2.pr() == null) {
            return;
        }
        int iHashCode = hnVar2.pr().hashCode();
        if (this.w.get(Integer.valueOf(iHashCode)) == null || !this.w.containsKey(Integer.valueOf(iHashCode)) || !this.w.get(Integer.valueOf(iHashCode)).booleanValue()) {
            pr(hnVar2.pr());
            this.w.put(Integer.valueOf(iHashCode), Boolean.TRUE);
        }
    }

    @Override // com.byazt.sa.x
    public void c(com.byazt.ik.hn<View> hnVar) {
        if (hnVar == null) {
            return;
        }
        if (this.fo <= 0 && !this.rc && TextUtils.equals(hnVar.ww(), "header")) {
            c(0);
            this.rc = true;
        }
        JSONObject jSONObjectVk = hnVar.vk();
        if (jSONObjectVk == null) {
            return;
        }
        com.byazt.ch.lb.hw hwVarX = hnVar.x("video_".concat(String.valueOf(jSONObjectVk.optInt("image_mode"))));
        if (hwVarX instanceof com.byazt.hd.hw) {
            com.byazt.hd.hw hwVar = (com.byazt.hd.hw) hwVarX;
            hwVar.pr(this.m);
            hwVar.lv();
        }
    }

    @Override // com.byazt.sa.x
    public void uc(com.byazt.ik.hn<View> hnVar) {
        JSONObject jSONObjectVk;
        if (hnVar == null || (jSONObjectVk = hnVar.vk()) == null) {
            return;
        }
        com.byazt.ch.lb.hw hwVarX = hnVar.x("video_".concat(String.valueOf(jSONObjectVk.optInt("image_mode"))));
        if (hwVarX instanceof com.byazt.hd.hw) {
            ((com.byazt.hd.hw) hwVarX).mw();
        }
    }

    @Override // com.byazt.sa.hn
    public void hn(com.byazt.ik.hn hnVar) {
        of ofVarPr;
        if (hnVar != null && (ofVarPr = com.byazt.sd.pr.pr(hnVar.vk())) != null) {
            pr(ofVarPr, hnVar);
        }
    }

    @Override // com.byazt.qx.w
    public void pr(boolean z) {
    }

    @Override // com.byazt.qx.w
    public void uc() {
    }

    @Override // com.byazt.qx.w
    public void fw() {
    }

    @Override // com.byazt.qx.w
    public void pr(int i) {
    }

    @Override // com.byazt.qx.w
    public long pr() {
        return 0L;
    }

    @Override // com.byazt.qx.w
    public int hw() {
        return 0;
    }

    @Override // com.byazt.qx.w
    public void zo() {
    }

    @Override // com.byazt.qx.w
    public int hn() {
        return 0;
    }

    @Override // com.byazt.qx.w
    public void aj() {
    }

    @Override // com.byazt.qx.w
    public void vk() {
    }

    @Override // com.byazt.qx.w
    public void x(int i) {
    }

    @Override // com.byazt.qx.w
    public void pr(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.qx.w
    public void x() {
    }

    @Override // com.byazt.qx.w
    public void hw(int i) {
    }

    @Override // com.byazt.qx.w
    public void c() {
    }

    @Override // com.byazt.qx.w
    public void pr(int i, String str) {
    }

    @Override // com.byazt.qx.w
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.qx.w
    public void pr(float f) {
    }

    @Override // com.byazt.qx.w
    public void hn(int i) {
    }

    @Override // com.byazt.qx.w
    public void pr(of ofVar) {
    }

    @Override // com.byazt.qx.w
    public void pr(int i, int i2) {
    }
}
