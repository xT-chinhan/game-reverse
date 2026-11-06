package com.byazt.bp;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 20})
public class hn implements c {
    public static ReferenceQueue<Object> hw = new ReferenceQueue<>();
    public final int hn;
    public Map<Object, pr> pr = new ConcurrentHashMap();

    public hn(int i) {
        this.hn = i;
    }

    @Override // com.byazt.bp.c
    public boolean pr(String str) {
        return true;
    }

    @Override // com.byazt.bp.c
    public void pr(final com.byazt.qe.hw hwVar, final of ofVar) {
        if (!TextUtils.isEmpty(hwVar.cz())) {
            return;
        }
        if (ofVar.hp() <= 0) {
            ofVar.c((System.currentTimeMillis() + 10500000) / 1000);
        }
        zo.c(new fw("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.bp.hn.1
            @Override // java.lang.Runnable
            public void run() {
                int unused = hn.this.hn;
                hwVar.x();
                com.byazt.py.c.pr(hn.this.hn).pr(hwVar, ofVar, false);
            }
        });
    }

    @Override // com.byazt.bp.c
    public void pr(final com.byazt.qe.hw hwVar, final List<of> list) {
        if (!TextUtils.isEmpty(hwVar.cz())) {
            return;
        }
        hwVar.x();
        com.byazt.hg.zo.hn hnVarPr = com.byazt.hg.zo.pr(this.hn);
        if (((hnVarPr != null ? hnVarPr.vk() : 0) & 1) != 1) {
            return;
        }
        hwVar.x();
        of ofVar = list.get(0);
        if (ofVar != null) {
            try {
                if (hnVarPr.pr("disable_trans_cache", new com.byazt.hg.zo.hw.pr().pr(hwVar).pr(ofVar).pr())) {
                    hwVar.x();
                    return;
                }
            } catch (Exception e) {
            }
        }
        zo.c(new fw("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.bp.hn.2
            @Override // java.lang.Runnable
            public void run() {
                for (of ofVar2 : list) {
                    if (ofVar2.hp() <= 0) {
                        ofVar2.c((System.currentTimeMillis() + 10500000) / 1000);
                    }
                    ofVar2.i(104);
                    int unused = hn.this.hn;
                    hwVar.x();
                    com.byazt.py.c.pr(hn.this.hn).pr(hwVar, ofVar2, false);
                }
            }
        });
    }

    @Override // com.byazt.bp.c
    public void hw(final com.byazt.qe.hw hwVar, final List<of> list) {
        if (!TextUtils.isEmpty(hwVar.cz())) {
            return;
        }
        zo.c(new fw("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.bp.hn.3
            @Override // java.lang.Runnable
            public void run() {
                for (of ofVar : list) {
                    if (ofVar.hp() <= 0) {
                        ofVar.c((System.currentTimeMillis() + 10500000) / 1000);
                    }
                    int unused = hn.this.hn;
                    hwVar.x();
                    com.byazt.py.c.pr(hn.this.hn).pr(hwVar.x(), ofVar.ri(), false);
                }
            }
        });
    }

    @Override // com.byazt.bp.c
    public void hw(String str) {
        for (Reference<? extends Object> referencePoll = hw.poll(); referencePoll != null; referencePoll = hw.poll()) {
            pr prVar = this.pr.get(referencePoll);
            if (prVar != null) {
                com.byazt.py.c.pr(this.hn).pr(prVar.pr, prVar.hw, false);
            }
        }
        com.byazt.py.c.pr(this.hn).hw(str);
        com.byazt.py.c.pr(this.hn).hn(str);
    }

    @Override // com.byazt.bp.c
    public of pr(String str, long j) {
        com.byazt.hg.zo.hn hnVarPr = com.byazt.hg.zo.pr(this.hn);
        of ofVarPr = com.byazt.py.c.pr(this.hn).pr(str, true, j);
        if (ofVarPr != null && hnVarPr != null) {
            try {
                if (hnVarPr.pr("delete_on_load", new com.byazt.hg.zo.hw.pr().pr(ofVarPr).pr())) {
                    com.byazt.py.c.pr(this.hn).pr(str, ofVarPr.ri());
                }
            } catch (Exception e) {
            }
        }
        return ofVarPr;
    }

    @Override // com.byazt.bp.c
    public List<of> pr(String str, long j, int i, double d) {
        com.byazt.hg.zo.hn hnVarPr = com.byazt.hg.zo.pr(this.hn);
        List<of> listPr = com.byazt.py.c.pr(this.hn).pr(str, true, j, i, d);
        for (of ofVar : listPr) {
            if (ofVar != null && hnVarPr != null) {
                try {
                    if (hnVarPr.pr("delete_on_load", new com.byazt.hg.zo.hw.pr().pr(ofVar).pr())) {
                        try {
                            com.byazt.py.c.pr(this.hn).pr(str, ofVar.ri());
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                }
            }
        }
        listPr.size();
        return listPr;
    }

    @Override // com.byazt.bp.c
    public void pr(final com.byazt.qe.hw hwVar, final of ofVar, final Object obj, boolean z) {
        final String strX = hwVar.x();
        com.byazt.hg.zo.hn hnVarPr = com.byazt.hg.zo.pr(this.hn);
        int iVk = hnVarPr != null ? hnVarPr.vk() : 0;
        if (z) {
            if (ofVar.ja() != 0) {
                this.pr.put(new PhantomReference(obj, hw), new pr(strX, ofVar.ri()));
            }
        } else {
            if ((iVk & 2) != 2) {
                return;
            }
            try {
                if (hnVarPr.pr("disable_trans_cache", new com.byazt.hg.zo.hw.pr().pr(hwVar).pr(ofVar).pr())) {
                    return;
                }
            } catch (Exception e) {
            }
            zo.c(new fw("PreloadStrategyRecovery-onLoad") { // from class: com.byazt.bp.hn.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ofVar.ja() != 0) {
                        hn.this.pr.put(new PhantomReference(obj, hn.hw), new pr(strX, ofVar.ri()));
                    }
                    ofVar.i(105);
                    com.byazt.py.c.pr(hn.this.hn).pr(hwVar, ofVar, true);
                }
            });
        }
    }

    @Override // com.byazt.bp.c
    public void pr(final of ofVar) {
        final int iM = ls.m(ofVar);
        zo.c(new fw("PreloadStrategyRecovery-onShow") { // from class: com.byazt.bp.hn.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.byazt.py.c.pr(hn.this.hn).pr(new StringBuilder().append(iM).toString(), ofVar.ri());
                System.currentTimeMillis();
            }
        });
    }

    @Override // com.byazt.bp.c
    public void pr(String str, of ofVar) {
        com.byazt.py.c.pr(this.hn).pr(str, ofVar.ri());
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 116})
    private static class pr {
        public String hw;
        public String pr;

        public pr(String str, String str2) {
            this.pr = str;
            this.hw = str2;
        }
    }
}
