package com.byazt.wgd;

import com.byazt.ld.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.DownloadTask;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g<T> extends pr {
    public boolean hn;
    public com.byazt.ld.fw hw;
    public T pr;
    public byte[] x;

    public g(T t, byte[] bArr, com.byazt.ld.fw fwVar, boolean z) {
        this.pr = t;
        this.hw = fwVar;
        this.hn = z;
        this.x = bArr;
    }

    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        String strZ = hnVar.z();
        Map<String, List<com.byazt.sl.hn>> mapFw = hnVar.cz().fw();
        List<com.byazt.sl.hn> list = mapFw.get(strZ);
        if (list == null) {
            hw(hnVar);
            return;
        }
        synchronized (list) {
            Iterator<com.byazt.sl.hn> it = list.iterator();
            while (it.hasNext()) {
                hw(it.next());
            }
            list.clear();
            mapFw.remove(strZ);
        }
    }

    private Map<String, String> hw() {
        com.byazt.ld.fw fwVar = this.hw;
        if (fwVar != null) {
            return fwVar.c();
        }
        return null;
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return TrackAction.SUCCESS;
    }

    private void hw(com.byazt.sl.hn hnVar) {
        byte[] bArrPr;
        rc rcVarW = hnVar.w();
        int iM = hnVar.m();
        if (rcVarW != null) {
            T t = this.pr;
            if (iM == 3) {
                com.byazt.ld.hw hwVarNy = hnVar.ny();
                if (this.x == null && hwVarNy.fw()) {
                    this.x = hnVar.cz().hw(hwVarNy).pr(hnVar.uc());
                }
                T t2 = (T) this.x;
                if (t2 == null) {
                    t2 = this.pr;
                }
                if (t2 instanceof byte[]) {
                    t = (T) t2;
                } else {
                    if (hnVar.yb()) {
                        bArrPr = com.byazt.op.pr.pr(hnVar);
                    } else {
                        bArrPr = hnVar.cz().hn(hnVar.ny()).pr(hnVar.uc());
                    }
                    if (!(bArrPr instanceof byte[])) {
                        rcVarW.pr(DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS, "final data is not raw", new RuntimeException("final data is not raw"));
                    }
                    t = (T) bArrPr;
                }
            } else if (iM == 2 && (t instanceof byte[])) {
                try {
                    t = (T) hnVar.cz().pr(hnVar).pr((byte[]) t);
                } catch (Throwable th) {
                    rcVarW.pr(DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS, "decode failed", th);
                    return;
                }
            }
            rcVarW.pr(new com.byazt.sl.x().pr(hnVar, t, hw(), this.hn));
        }
    }
}
