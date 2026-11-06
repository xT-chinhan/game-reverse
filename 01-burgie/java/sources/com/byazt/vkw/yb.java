package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb implements nt, Function {
    public volatile nt hw;
    public volatile Function pr;

    public yb(nt ntVar) {
        this.hw = ntVar;
    }

    public yb(Function function) {
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
                    pr();
                }
                return null;
            case 1:
                pr();
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 2:
                return Boolean.valueOf(hw());
            case 3:
                return Integer.valueOf(hn());
            case 4:
                return pr((byte[]) sparseArray.get(1));
            case 5:
                return hw((byte[]) sparseArray.get(1));
            case 6:
                return pr((String) sparseArray.get(1));
            case 7:
                return hw((String) sparseArray.get(1));
            case 8:
                return hn((String) sparseArray.get(1));
            case 9:
                return x((String) sparseArray.get(1));
        }
    }

    @Override // com.byazt.vkw.nt
    public int hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.nt
    public String hn(String str) {
        if (this.hw != null) {
            return this.hw.hn(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.nt
    public String hw(String str) {
        if (this.hw != null) {
            return this.hw.hw(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.nt
    public boolean hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.nt
    public byte[] hw(byte[] bArr) {
        if (this.hw != null) {
            return this.hw.hw(bArr);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, bArr);
        return (byte[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.nt
    public String pr(String str) {
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.nt
    public void pr() {
        if (this.hw != null) {
            this.hw.pr();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.nt
    public byte[] pr(byte[] bArr) {
        if (this.hw != null) {
            return this.hw.pr(bArr);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, bArr);
        return (byte[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.nt
    public String x(String str) {
        if (this.hw != null) {
            return this.hw.x(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        return (String) this.pr.apply(sparseArray);
    }
}
