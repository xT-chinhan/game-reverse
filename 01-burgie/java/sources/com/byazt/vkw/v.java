package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS})
public class v implements er, Function {
    public volatile er hw;
    public volatile Function pr;

    public v(er erVar) {
        this.hw = erVar;
    }

    public v(Function function) {
        this.pr = function;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
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
                    return pr((String) sparseArray.get(1));
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return pr((String) sparseArray.get(1));
            case 2:
                return Integer.valueOf(hw((String) sparseArray.get(1)));
            case 3:
                return Long.valueOf(hn((String) sparseArray.get(1)));
            case 4:
                return Boolean.valueOf(x((String) sparseArray.get(1)));
            case 5:
                pr((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
        }
    }

    @Override // com.byazt.vkw.er
    public long hn(String str) {
        if (this.hw != null) {
            return this.hw.hn(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.vkw.er
    public int hw(String str) {
        if (this.hw != null) {
            return this.hw.hw(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.er
    public String pr(String str) {
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.er
    public void pr(String str, String str2) {
        if (this.hw != null) {
            this.hw.pr(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.er
    public boolean x(String str) {
        if (this.hw != null) {
            return this.hw.x(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
