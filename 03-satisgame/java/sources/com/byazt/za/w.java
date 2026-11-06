package com.byazt.za;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 13})
public class w extends com.byazt.ys.n {
    public int cp;
    public int d;
    public com.byazt.gct.wm oa;
    public boolean sz;
    public int tj;

    public w(Context context, pk pkVar, String str, int i) {
        super(context, pkVar, str, i);
        this.tj = 0;
        this.cp = -1;
        this.d = -1;
        this.sz = true;
        if (pkVar == null) {
            return;
        }
        com.byazt.wu.n.n().n(pkVar.hashCode() + pkVar.ou()).put("is_express_ad", Boolean.TRUE);
    }

    @Override // com.byazt.ys.l
    public void s() {
        this.cp = 1;
        this.sz = false;
    }

    @Override // com.byazt.ys.l
    public void q() {
        this.d = 1;
        this.sz = false;
    }

    @Override // com.byazt.ys.qg, com.byazt.ys.l
    public void n(View view, com.byazt.gct.tj tjVar) {
        com.byazt.fq.n nVar = (com.byazt.fq.n) n(com.byazt.fq.n.class);
        nVar.n(n(nVar.s(), tjVar == null ? (byte) 0 : tjVar.qg()));
        super.n(view, tjVar);
    }

    @Override // com.byazt.ys.l
    public void l(int i) {
        this.tj = i;
    }

    public com.byazt.gct.rv n(String str, byte b) {
        int i;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        int iS;
        int iS2;
        View viewCp = this.x.cp();
        int[] iArrN = com.byazt.okk.s.n(viewCp);
        if (iArrN == null || iArrN.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            i = iArrN[0];
            i2 = iArrN[1];
            if (this.tj == 0 && this.sz) {
                this.x.n((com.byazt.okk.s.s(this.w, this.x.cd()) + i) - 0.5f);
                this.x.qg((com.byazt.okk.s.s(this.w, this.x.um()) + i2) - 0.5f);
                this.x.s((com.byazt.okk.s.s(this.w, this.x.a()) + i) - 0.5f);
                this.x.q((com.byazt.okk.s.s(this.w, this.x.py()) + i2) - 0.5f);
            }
        }
        int[] iArrN2 = {-1, -1};
        int[] iArrS = new int[2];
        if (this.oa == null || !this.sz) {
            str2 = "";
            str3 = str;
            str4 = "";
            str5 = str4;
        } else {
            this.x.n(this.oa.l);
            this.x.qg(this.oa.w);
            if (this.tj == 0) {
                iArrN2[0] = com.byazt.okk.s.s(this.w, this.oa.x) + i;
                iArrN2[1] = com.byazt.okk.s.s(this.w, this.oa.fs) + i2;
                iS = com.byazt.okk.s.s(this.w, this.oa.rv);
                iS2 = com.byazt.okk.s.s(this.w, this.oa.tj);
            } else {
                iArrN2[0] = this.oa.x;
                iArrN2[1] = this.oa.fs;
                iS = this.oa.rv;
                iS2 = this.oa.tj;
            }
            str3 = TextUtils.isEmpty(str) ? this.oa.cp : str;
            str2 = this.oa.d;
            str4 = this.oa.oa;
            str5 = this.oa.sz;
            iArrS[0] = iS;
            iArrS[1] = iS2;
            View viewTj = this.x.tj();
            if (iS == 0 && iS2 == 0 && viewTj != null) {
                iArrN2 = com.byazt.okk.s.n(viewTj);
                iArrS = com.byazt.okk.s.s(viewTj);
            }
        }
        this.tj = 0;
        return new com.byazt.gct.rv.n().w(this.x.cd()).l(this.x.um()).q(this.x.a()).s(this.x.py()).qg(this.x.cy()).n(this.x.hd()).qg(iArrN).n(iArrN2).s(com.byazt.okk.s.s(viewCp)).q(iArrS).q(this.x.w()).l(this.x.x()).w(this.x.fs()).s(com.byazt.vyf.s.cy().qg() ? 1 : 2).n(this.x.sz()).n(str3).qg(str4).s(str2).q(str5).n(com.byazt.okk.s.x(this.w)).qg(((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).a()).x(this.cp).fs(this.d).qg(com.byazt.okk.s.fs(this.w)).l(this.x.ou()).rv(this.x.wm()).qg(b).n(this.x.s()).n(com.byazt.oh.l.qg(this.n)).n();
    }

    @Override // com.byazt.ys.l
    public void n(com.byazt.gct.wm wmVar) {
        this.oa = wmVar;
    }
}
