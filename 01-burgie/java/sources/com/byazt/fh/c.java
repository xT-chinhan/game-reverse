package com.byazt.fh;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 890, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c {
    public int hn;
    public int hw;
    public final hn[] pr = new hn[4096];

    public synchronized void pr(hn hnVar) {
        if (hnVar == null) {
            return;
        }
        hn[] hnVarArr = this.pr;
        int i = this.hw;
        hnVarArr[i] = hnVar;
        int i2 = i + 1;
        this.hw = i2;
        if (i2 >= hnVarArr.length) {
            this.hw = 0;
        }
        int i3 = this.hn;
        if (i3 < hnVarArr.length) {
            this.hn = i3 + 1;
        }
    }

    public synchronized List<hn> pr(long j, long j2) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (j2 > j && (i = this.hn) > 0) {
            int length = this.hw - i;
            if (length < 0) {
                length += this.pr.length;
            }
            for (int i2 = 0; i2 < this.hn; i2++) {
                int length2 = length + i2;
                hn[] hnVarArr = this.pr;
                if (length2 >= hnVarArr.length) {
                    length2 -= hnVarArr.length;
                }
                hn hnVar = hnVarArr[length2];
                if (hnVar != null) {
                    long jHn = hnVar.hn();
                    if (jHn > j && jHn <= j2) {
                        arrayList.add(hnVar);
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }
}
