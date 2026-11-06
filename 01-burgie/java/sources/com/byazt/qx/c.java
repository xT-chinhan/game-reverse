package com.byazt.qx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends com.byazt.az.pr {
    public int g;
    public int k;
    public int m;
    public com.byazt.hg.fo vk;
    public boolean w;

    public c(Context context, of ofVar, String str, int i) {
        super(context, ofVar, str, i);
        this.k = 0;
        this.m = -1;
        this.g = -1;
        this.w = true;
        if (ofVar == null) {
            return;
        }
        com.byazt.lxw.pr.pr().pr(ofVar.hashCode() + ofVar.ny()).put("is_express_ad", Boolean.TRUE);
    }

    @Override // com.byazt.az.x
    public void hn() {
        this.m = 1;
        this.w = false;
    }

    @Override // com.byazt.az.x
    public void x() {
        this.g = 1;
        this.w = false;
    }

    @Override // com.byazt.az.hw, com.byazt.az.x
    public void pr(View view, com.byazt.hg.vk vkVar) {
        com.byazt.yx.pr prVar = (com.byazt.yx.pr) pr(com.byazt.yx.pr.class);
        prVar.pr(pr(prVar.hn(), vkVar == null ? (byte) 0 : vkVar.hw()));
        super.pr(view, vkVar);
    }

    @Override // com.byazt.az.x
    public void c(int i) {
        this.k = i;
    }

    public com.byazt.hg.aj pr(String str, byte b) {
        int i;
        int i2;
        String str2;
        String str3;
        String str4;
        int iHn;
        int iHn2;
        View viewW = this.fw.w();
        int[] iArrPr = er.pr(viewW);
        if (iArrPr != null && iArrPr.length == 2) {
            i = iArrPr[0];
            i2 = iArrPr[1];
            if (this.k == 0 && this.w) {
                this.fw.pr((er.hn(this.uc, this.fw.lb()) + i) - 0.5f);
                this.fw.hw((er.hn(this.uc, this.fw.qa()) + i2) - 0.5f);
                this.fw.hn((er.hn(this.uc, this.fw.a()) + i) - 0.5f);
                this.fw.x((er.hn(this.uc, this.fw.cz()) + i2) - 0.5f);
            }
        } else {
            i = 0;
            i2 = 0;
        }
        int[] iArrPr2 = {-1, -1};
        int[] iArrHn = new int[2];
        String str5 = "";
        if (this.vk == null || !this.w) {
            str2 = str;
            str3 = "";
            str4 = str3;
        } else {
            this.fw.pr(this.vk.c);
            this.fw.hw(this.vk.uc);
            if (this.k == 0) {
                iArrPr2[0] = er.hn(this.uc, this.vk.fw) + i;
                iArrPr2[1] = er.hn(this.uc, this.vk.zo) + i2;
                iHn = er.hn(this.uc, this.vk.aj);
                iHn2 = er.hn(this.uc, this.vk.vk);
            } else {
                iArrPr2[0] = this.vk.fw;
                iArrPr2[1] = this.vk.zo;
                iHn = this.vk.aj;
                iHn2 = this.vk.vk;
            }
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            } else {
                str2 = this.vk.w;
            }
            String str6 = this.vk.k;
            String str7 = this.vk.m;
            str4 = this.vk.g;
            iArrHn[0] = iHn;
            iArrHn[1] = iHn2;
            View viewVk = this.fw.vk();
            if (iHn == 0 && iHn2 == 0 && viewVk != null) {
                iArrPr2 = er.pr(viewVk);
                iArrHn = er.hn(viewVk);
                str3 = str6;
                str5 = str7;
            } else {
                str3 = str6;
                str5 = str7;
            }
        }
        this.k = 0;
        return new com.byazt.hg.aj.pr().uc(this.fw.lb()).c(this.fw.qa()).x(this.fw.a()).hn(this.fw.cz()).hw(this.fw.nt()).pr(this.fw.yb()).hw(iArrPr).pr(iArrPr2).hn(er.hn(viewW)).x(iArrHn).x(this.fw.uc()).c(this.fw.fw()).uc(this.fw.zo()).hn(com.byazt.sd.zo.nt().hw() ? 1 : 2).pr(this.fw.g()).pr(str2).hw(str5).hn(str3).x(str4).pr(er.fw(this.uc)).hw(((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).a()).fw(this.m).zo(this.g).hw(er.zo(this.uc)).c(this.fw.ny()).aj(this.fw.fo()).hw(b).pr(this.fw.hn()).pr(com.byazt.ri.c.hw(this.pr)).pr();
    }

    @Override // com.byazt.az.x
    public void pr(com.byazt.hg.fo foVar) {
        this.vk = foVar;
    }
}
