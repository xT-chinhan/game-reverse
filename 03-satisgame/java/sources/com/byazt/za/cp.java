package com.byazt.za;

import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 29})
public class cp implements com.byazt.vh.ou, com.byazt.udb.rv {
    public long l;
    public com.byazt.vgn.q n;
    public String q;
    public String qg;
    public pk s;
    public long w;
    public com.byazt.ew.fs x;

    @Override // com.byazt.vh.ou
    public void l() {
    }

    @Override // com.byazt.vh.ou
    public void n(boolean z) {
    }

    @Override // com.byazt.vh.ou
    public void q() {
    }

    public cp(com.byazt.vgn.q qVar, String str, pk pkVar, String str2) {
        this.n = qVar;
        this.qg = str;
        this.q = str2;
        this.s = pkVar;
    }

    @Override // com.byazt.udb.rv
    public void w() {
        this.n.q();
    }

    @Override // com.byazt.udb.rv
    public void qg(boolean z) {
        this.n.n(z ? 1 : 0);
    }

    @Override // com.byazt.udb.rv
    public void x() {
        com.byazt.ew.fs fsVar = this.x;
        if (fsVar == null) {
            return;
        }
        fsVar.w(bb.n(this.s));
    }

    @Override // com.byazt.udb.rv
    public void fs() {
        this.n.l();
        com.byazt.ew.fs fsVar = this.x;
        if (fsVar == null) {
            return;
        }
        fsVar.x(bb.n(this.s));
    }

    @Override // com.byazt.udb.rv
    public void n(int i, String str) {
        this.n.s(i, str);
        tj.n(i, this.qg, this.q, this.s);
        com.byazt.ew.fs fsVar = this.x;
        if (fsVar == null) {
            return;
        }
        fsVar.n(true, bb.n(this.s), 105);
    }

    @Override // com.byazt.udb.rv
    public void n(int i) {
        this.l = System.currentTimeMillis();
        if (i == 3) {
            this.n.n("dynamic_render2_start");
        } else {
            this.n.n("dynamic_render_start");
        }
    }

    @Override // com.byazt.udb.rv
    public void qg(int i) {
        if (i == 3) {
            this.n.s("dynamic_sub_analysis2_start");
        } else {
            this.n.s("dynamic_sub_analysis_start");
        }
    }

    @Override // com.byazt.udb.rv
    public void s(int i) {
        if (i == 3) {
            this.n.s("dynamic_sub_analysis2_end");
        } else {
            this.n.s("dynamic_sub_analysis_end");
        }
    }

    @Override // com.byazt.udb.rv
    public void q(int i) {
        if (i == 3) {
            this.n.s("dynamic_sub_render2_start");
        } else {
            this.n.s("dynamic_sub_render_start");
        }
    }

    @Override // com.byazt.udb.rv
    public void l(int i) {
        if (i == 3) {
            this.n.s("dynamic_sub_render2_end");
        } else {
            this.n.s("dynamic_sub_render_end");
        }
    }

    @Override // com.byazt.udb.rv
    public void w(int i) {
        final String str;
        this.w = System.currentTimeMillis();
        if (i == 3) {
            this.n.qg("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.n.qg("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.n.n(true);
        com.byazt.qit.l.s(new com.byazt.qit.x("dynamic_success") { // from class: com.byazt.za.cp.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.hm.n.x(cp.this.s, cp.this.qg, str, null);
            }
        });
    }

    @Override // com.byazt.udb.rv
    public void n(int i, int i2, String str, boolean z) {
        this.n.n(true);
        if (i == 3) {
            this.n.n(i2, "dynamic_render2_error");
        } else {
            this.n.n(i2, "dynamic_render_error");
        }
        tj.n(i2, this.qg, this.q, this.s);
    }

    @Override // com.byazt.udb.rv
    public void rv() {
        this.n.n();
    }

    @Override // com.byazt.udb.rv
    public void tj() {
        this.n.n(true);
        this.n.qg();
        com.byazt.qit.l.s(new com.byazt.qit.x("native_success") { // from class: com.byazt.za.cp.2
            @Override // java.lang.Runnable
            public void run() {
                tj.n(cp.this.qg, cp.this.q, cp.this.s);
                com.byazt.hm.n.x(cp.this.s, cp.this.qg, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.byazt.udb.rv
    public void cp() {
        this.n.n(true);
        this.n.s();
    }

    @Override // com.byazt.udb.rv
    public void d() {
        this.n.w();
    }

    @Override // com.byazt.udb.rv
    public void oa() {
        this.n.l();
    }

    public void sz() {
        this.n.x();
        this.n.fs();
    }

    public void n(com.byazt.ew.fs fsVar) {
        this.x = fsVar;
    }

    @Override // com.byazt.vh.ou
    public void n() {
        this.n.q("ugen_render_start");
        this.n.q("ugen_sub_analysis_start");
    }

    @Override // com.byazt.vh.ou
    public void qg() {
        this.n.q("ugen_sub_analysis_end");
    }

    @Override // com.byazt.vh.ou
    public void s() {
        this.n.q("ugen_sub_render_start");
    }

    @Override // com.byazt.vh.ou
    public void n(com.byazt.vh.py pyVar) {
        if (pyVar.n() == 0) {
            this.n.q("ugen_sub_render_end");
            this.n.l("ugen_render_success");
        } else {
            this.n.qg(pyVar.n(), "ugen_render_error");
        }
        this.n.n(true);
    }

    @Override // com.byazt.vh.ou
    public void n(JSONObject jSONObject) {
        this.n.n(jSONObject);
    }
}
