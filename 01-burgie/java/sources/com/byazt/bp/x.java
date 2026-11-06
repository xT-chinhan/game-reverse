package com.byazt.bp;

import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 121})
public class x implements c {
    public final int pr;

    public x(int i) {
        this.pr = i;
    }

    @Override // com.byazt.bp.c
    public boolean pr(String str) {
        return true;
    }

    @Override // com.byazt.bp.c
    public void pr(final com.byazt.qe.hw hwVar, final of ofVar) {
        if (ofVar.hp() <= 0) {
            ofVar.c((System.currentTimeMillis() + 10500000) / 1000);
        }
        zo.c(new fw("PreloadStrategyShowDelete-onNetworkResponse") { // from class: com.byazt.bp.x.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.py.c.pr(x.this.pr).pr(hwVar, ofVar, false);
            }
        });
    }

    @Override // com.byazt.bp.c
    public void pr(com.byazt.qe.hw hwVar, List<of> list) {
    }

    @Override // com.byazt.bp.c
    public void hw(com.byazt.qe.hw hwVar, List<of> list) {
    }

    @Override // com.byazt.bp.c
    public void hw(String str) {
        com.byazt.py.c.pr(this.pr).hw(str);
    }

    @Override // com.byazt.bp.c
    public of pr(String str, long j) {
        return com.byazt.py.c.pr(this.pr).pr(str, false, j);
    }

    @Override // com.byazt.bp.c
    public List<of> pr(String str, long j, int i, double d) {
        List<of> listPr = com.byazt.py.c.pr(this.pr).pr(str, false, j, i, d);
        listPr.size();
        return listPr;
    }

    @Override // com.byazt.bp.c
    public void pr(com.byazt.qe.hw hwVar, of ofVar, Object obj, boolean z) {
    }

    @Override // com.byazt.bp.c
    public void pr(String str, of ofVar) {
        com.byazt.py.c.pr(this.pr).pr(str, ofVar.ri());
    }

    @Override // com.byazt.bp.c
    public void pr(final of ofVar) {
        final int iM = ls.m(ofVar);
        zo.pr(new fw("PreloadStrategyShowDelete-onShow") { // from class: com.byazt.bp.x.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.py.c.pr(x.this.pr).pr(new StringBuilder().append(iM).toString(), ofVar.ri());
            }
        });
    }
}
