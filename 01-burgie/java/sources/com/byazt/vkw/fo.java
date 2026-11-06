package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS})
public class fo implements ny, Function {
    public volatile ny hw;
    public volatile Function pr;

    public fo(ny nyVar) {
        this.hw = nyVar;
    }

    public fo(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
                return this.hw != null ? this.hw : this.pr;
            case -4:
                Function function = (Function) sparseArray.get(1);
                if (function != null) {
                    this.pr = function;
                    this.hw = null;
                    return pr();
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return pr();
            case 2:
                return Boolean.valueOf(hw());
            case 3:
                return Integer.valueOf(hn());
            case 4:
                return Long.valueOf(x());
        }
    }

    @Override // com.byazt.vkw.ny
    public int hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.ny
    public boolean hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.ny
    public String pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.ny
    public long x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }
}
