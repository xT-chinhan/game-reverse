package com.byazt.wgd;

import android.graphics.Bitmap;
import com.byazt.ld.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public com.byazt.ld.fw hw;
    public byte[] pr;

    public c(byte[] bArr, com.byazt.ld.fw fwVar) {
        this.pr = bArr;
        this.hw = fwVar;
    }

    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        com.byazt.sl.uc ucVarCz = hnVar.cz();
        com.byazt.qnt.pr prVarPr = ucVarCz.pr(hnVar);
        try {
            a aVarRc = hnVar.rc();
            if (aVarRc != null) {
                aVarRc.pr(10, null);
            }
            Bitmap bitmapPr = prVarPr.pr(this.pr);
            if (bitmapPr == null) {
                pr(1002, "decode failed bitmap null", null, hnVar);
            } else {
                hnVar.pr(new g(bitmapPr, this.pr, this.hw, false));
                String strFw = hnVar.fw();
                if (hnVar.yb()) {
                    if (hnVar.ny().hn()) {
                        ucVarCz.pr(hnVar.ny()).pr(strFw, bitmapPr);
                    }
                } else {
                    ucVarCz.pr(hnVar.ny()).pr(strFw, bitmapPr);
                }
            }
            if (aVarRc != null) {
                aVarRc.pr(11, bitmapPr);
            }
        } catch (Throwable th) {
            pr(1002, "decode failed:" + th.getMessage(), th, hnVar);
        }
    }

    private void pr(int i, String str, Throwable th, com.byazt.sl.hn hnVar) {
        if (this.hw == null) {
            hnVar.pr(new w());
        } else {
            hnVar.pr(new zo(i, str, th));
        }
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "decode";
    }
}
