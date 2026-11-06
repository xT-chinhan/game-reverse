package com.byazt.qx;

import com.byazt.hg.of;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 50})
public class vk implements com.byazt.ch.ny, com.byazt.mq.aj {
    public long c;
    public com.byazt.eq.zo fw;
    public of hn;
    public String hw;
    public com.byazt.ko.pr pr;
    public long uc;
    public String x;

    public vk(com.byazt.ko.pr prVar, String str, of ofVar, String str2) {
        this.pr = prVar;
        this.hw = str;
        this.x = str2;
        this.hn = ofVar;
    }

    @Override // com.byazt.mq.aj
    public void uc() {
        this.pr.pr();
    }

    @Override // com.byazt.mq.aj
    public void hw(boolean z) {
        this.pr.pr(z ? 1 : 0);
    }

    @Override // com.byazt.mq.aj
    public void fw() {
        com.byazt.eq.zo zoVar = this.fw;
        if (zoVar == null) {
            return;
        }
        zoVar.uc(b.pr(this.hn));
    }

    @Override // com.byazt.mq.aj
    public void zo() {
        this.pr.hw();
        com.byazt.eq.zo zoVar = this.fw;
        if (zoVar == null) {
            return;
        }
        zoVar.fw(b.pr(this.hn));
    }

    @Override // com.byazt.mq.aj
    public void pr(int i, String str) {
        this.pr.pr(i, str);
        aj.pr(i, this.hw, this.x, this.hn);
        com.byazt.eq.zo zoVar = this.fw;
        if (zoVar == null) {
            return;
        }
        zoVar.pr(true, b.pr(this.hn), 105);
    }

    @Override // com.byazt.mq.aj
    public void pr(int i) {
        this.c = System.currentTimeMillis();
        if (i == 3) {
            this.pr.pr("dynamic_render2_start");
        } else {
            this.pr.pr("dynamic_render_start");
        }
    }

    @Override // com.byazt.mq.aj
    public void hw(int i) {
        if (i == 3) {
            this.pr.hw("dynamic_sub_analysis2_start");
        } else {
            this.pr.hw("dynamic_sub_analysis_start");
        }
    }

    @Override // com.byazt.mq.aj
    public void hn(int i) {
        if (i == 3) {
            this.pr.hw("dynamic_sub_analysis2_end");
        } else {
            this.pr.hw("dynamic_sub_analysis_end");
        }
    }

    @Override // com.byazt.mq.aj
    public void x(int i) {
        if (i == 3) {
            this.pr.hw("dynamic_sub_render2_start");
        } else {
            this.pr.hw("dynamic_sub_render_start");
        }
    }

    @Override // com.byazt.mq.aj
    public void c(int i) {
        if (i == 3) {
            this.pr.hw("dynamic_sub_render2_end");
        } else {
            this.pr.hw("dynamic_sub_render_end");
        }
    }

    @Override // com.byazt.mq.aj
    public void uc(int i) {
        final String str;
        this.uc = System.currentTimeMillis();
        if (i == 3) {
            this.pr.hn("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.pr.hn("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.pr.pr(true);
        com.byazt.xlm.c.hn(new com.byazt.xlm.fw("dynamic_success") { // from class: com.byazt.qx.vk.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.pj.pr.fw(vk.this.hn, vk.this.hw, str, null);
            }
        });
    }

    @Override // com.byazt.mq.aj
    public void pr(int i, int i2, String str, boolean z) {
        this.pr.pr(true);
        if (i == 3) {
            this.pr.hw(i2, "dynamic_render2_error");
        } else {
            this.pr.hw(i2, "dynamic_render_error");
        }
        aj.pr(i2, this.hw, this.x, this.hn);
    }

    @Override // com.byazt.mq.aj
    public void aj() {
        this.pr.hn();
    }

    @Override // com.byazt.mq.aj
    public void vk() {
        this.pr.pr(true);
        this.pr.c();
        com.byazt.xlm.c.hn(new com.byazt.xlm.fw("native_success") { // from class: com.byazt.qx.vk.2
            @Override // java.lang.Runnable
            public void run() {
                aj.pr(vk.this.hw, vk.this.x, vk.this.hn);
                com.byazt.pj.pr.fw(vk.this.hn, vk.this.hw, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.byazt.mq.aj
    public void w() {
        this.pr.pr(true);
        this.pr.m();
    }

    @Override // com.byazt.mq.aj
    public void k() {
        this.pr.g();
    }

    @Override // com.byazt.mq.aj
    public void m() {
        this.pr.hw();
    }

    public void g() {
        this.pr.ho();
        this.pr.nt();
    }

    public void pr(com.byazt.eq.zo zoVar) {
        this.fw = zoVar;
    }

    @Override // com.byazt.ch.ny
    public void pr() {
        this.pr.x("ugen_render_start");
        this.pr.x("ugen_sub_analysis_start");
    }

    @Override // com.byazt.ch.ny
    public void hw() {
        this.pr.x("ugen_sub_analysis_end");
    }

    @Override // com.byazt.ch.ny
    public void hn() {
        this.pr.x("ugen_sub_render_start");
    }

    @Override // com.byazt.ch.ny
    public void pr(com.byazt.ch.cz czVar) {
        if (czVar.pr() == 0) {
            this.pr.x("ugen_sub_render_end");
            this.pr.c("ugen_render_success");
        } else {
            this.pr.hn(czVar.pr(), "ugen_render_error");
        }
        this.pr.pr(true);
    }

    @Override // com.byazt.ch.ny
    public void pr(JSONObject jSONObject) {
        this.pr.pr(jSONObject);
    }

    @Override // com.byazt.ch.ny
    public void x() {
    }

    @Override // com.byazt.ch.ny
    public void c() {
    }

    @Override // com.byazt.ch.ny
    public void pr(boolean z) {
    }
}
