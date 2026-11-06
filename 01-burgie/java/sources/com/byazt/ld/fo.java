package com.byazt.ld;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.InputStream;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS})
public class fo implements ny, Function {
    public volatile ny hw;
    public volatile Function pr;

    public fo(ny nyVar) {
        this.hw = nyVar;
    }

    public fo(Function function) {
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
                pr(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 3:
                hw(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 4:
                hn(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 5:
                pr();
                return null;
            case 6:
                return pr((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 7:
                return pr((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
            case 8:
                return Boolean.valueOf(hw((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3)));
        }
    }

    @Override // com.byazt.ld.ny
    public void hn(double d) {
        if (this.hw != null) {
            this.hw.hn(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Double.valueOf(d));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.ny
    public void hw(double d) {
        if (this.hw != null) {
            this.hw.hw(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Double.valueOf(d));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.ny
    public boolean hw(String str, String str2, String str3) {
        if (this.hw != null) {
            return this.hw.hw(str, str2, str3);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.ld.ny
    public g pr(String str) {
        ?? hoVar;
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            hoVar = Apply;
            hoVar = new ho((Function) Apply);
        }
        hoVar = Apply;
        return (g) hoVar;
    }

    @Override // com.byazt.ld.ny
    public InputStream pr(String str, String str2) {
        if (this.hw != null) {
            return this.hw.pr(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (InputStream) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.ny
    public InputStream pr(String str, String str2, String str3) {
        if (this.hw != null) {
            return this.hw.pr(str, str2, str3);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return (InputStream) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.ny
    public void pr() {
        if (this.hw != null) {
            this.hw.pr();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.ny
    public void pr(double d) {
        if (this.hw != null) {
            this.hw.pr(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Double.valueOf(d));
        this.pr.apply(sparseArray);
    }
}
