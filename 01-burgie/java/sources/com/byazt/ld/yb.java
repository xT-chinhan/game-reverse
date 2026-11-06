package com.byazt.ld;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb implements nt, Function {
    public volatile nt hw;
    public volatile Function pr;

    public yb(nt ntVar) {
        this.hw = ntVar;
    }

    public yb(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.ld.nt
    public boolean aj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hw.pr();
            case 2:
                return this.hw.hw();
            case 3:
                return this.hw.hn();
            case 4:
                return this.hw.x();
            case 5:
                this.hw.setResult(sparseArray.get(1));
                return null;
            case 6:
                return Integer.valueOf(this.hw.c());
            case 7:
                return Integer.valueOf(this.hw.uc());
            case 8:
                return this.hw.fw();
            case 9:
                return Boolean.valueOf(this.hw.zo());
            case 10:
                return Boolean.valueOf(this.hw.aj());
            case 11:
                zo zoVarVk = this.hw.vk();
                return zoVarVk != null ? new aj(zoVarVk) : zoVarVk;
            case 12:
                return Integer.valueOf(this.hw.w());
            default:
                return null;
        }
    }

    @Override // com.byazt.ld.nt
    public int c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ld.nt
    public Map fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.nt
    public Object hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.nt
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.nt
    public String pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.nt
    public void setResult(Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, obj);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.nt
    public int uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.ld.nt
    public zo vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.pr.apply(sparseArray);
        ?? ajVar = Apply;
        if (Apply != 0) {
            ajVar = new aj((Function) Apply);
        }
        return (zo) ajVar;
    }

    @Override // com.byazt.ld.nt
    public int w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ld.nt
    public Object x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.nt
    public boolean zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
