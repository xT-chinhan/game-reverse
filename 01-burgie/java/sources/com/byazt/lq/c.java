package com.byazt.lq;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 595, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements hw, Function {
    public volatile hw hw;
    public volatile Function pr;

    public c(hw hwVar) {
        this.hw = hwVar;
    }

    public c(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return this.hw.pr();
            case 2:
                return Boolean.valueOf(this.hw.hw());
            case 3:
                return Long.valueOf(this.hw.hn());
            default:
                return null;
        }
    }

    @Override // com.byazt.lq.hw
    public long hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.lq.hw
    public boolean hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lq.hw
    public String pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }
}
