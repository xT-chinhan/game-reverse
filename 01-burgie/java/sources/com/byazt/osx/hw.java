package com.byazt.osx;

import com.byazt.du.lb;
import com.byazt.jv.a;
import com.byazt.jv.b;
import com.byazt.jv.gz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 442, 13})
public final class hw implements a {
    public final boolean pr;

    public hw(boolean z) {
        this.pr = z;
    }

    @Override // com.byazt.jv.a
    public gz pr(a.pr prVar) throws IOException {
        gz gzVarPr;
        fw fwVar = (fw) prVar;
        hn hnVarFw = fwVar.fw();
        com.byazt.iaw.fw fwVarUc = fwVar.uc();
        com.byazt.iaw.hn hnVar = (com.byazt.iaw.hn) fwVar.c();
        b bVarPr = fwVar.pr();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bVarPr != null && bVarPr.uc != null) {
            bVarPr.uc.pr(jCurrentTimeMillis);
        }
        fwVar.call();
        hnVarFw.pr(bVarPr);
        fwVar.call();
        gz.pr prVarPr = null;
        if (uc.hn(bVarPr.hw()) && bVarPr.x() != null) {
            if ("100-continue".equalsIgnoreCase(bVarPr.pr("Expect"))) {
                hnVarFw.pr();
                fwVar.call();
                prVarPr = hnVarFw.pr(true);
            }
            if (prVarPr == null) {
                fwVar.call();
                com.byazt.du.x xVarPr = com.byazt.du.k.pr(new pr(hnVarFw.pr(bVarPr, bVarPr.x().hw())));
                bVarPr.x().pr(xVarPr);
                xVarPr.close();
                fwVar.call();
            } else if (!hnVar.c()) {
                fwVarUc.x();
            }
        }
        hnVarFw.hw();
        if (prVarPr == null) {
            fwVar.call();
            prVarPr = hnVarFw.pr(false);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (bVarPr.uc != null) {
            bVarPr.uc.hw(jCurrentTimeMillis2);
        }
        gz gzVarPr2 = prVarPr.pr(bVarPr).pr(fwVarUc.hw().x()).pr(jCurrentTimeMillis).hw(jCurrentTimeMillis2).pr();
        fwVar.call();
        int iX = gzVarPr2.x();
        if (this.pr && iX == 101) {
            gzVarPr = gzVarPr2.vk().pr(com.byazt.xx.hn.hn).pr();
        } else {
            gzVarPr = gzVarPr2.vk().pr(hnVarFw.pr(gzVarPr2)).pr();
        }
        if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(gzVarPr.hw().pr("Connection")) || ILivePush.ClickType.CLOSE.equalsIgnoreCase(gzVarPr.hw("Connection"))) {
            fwVarUc.x();
        }
        if ((iX == 204 || iX == 205) && gzVarPr.aj().hw() > 0) {
            throw new ProtocolException("HTTP " + iX + " had non-zero Content-Length: " + gzVarPr.aj().hw());
        }
        return gzVarPr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 442, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    static final class pr extends com.byazt.du.fw {
        public long pr;

        public pr(lb lbVar) {
            super(lbVar);
        }

        @Override // com.byazt.du.fw, com.byazt.du.lb
        public void a_(com.byazt.du.hn hnVar, long j) throws IOException {
            super.a_(hnVar, j);
            this.pr += j;
        }
    }
}
