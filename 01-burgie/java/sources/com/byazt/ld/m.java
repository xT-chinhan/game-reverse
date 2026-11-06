package com.byazt.ld;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 108})
public class m implements k, Function {
    public volatile k hw;
    public volatile Function pr;

    public m(k kVar) {
        this.hw = kVar;
    }

    public m(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.hw.pr());
            case 2:
                return this.hw.hw();
            case 3:
                return Integer.valueOf(this.hw.hn());
            case 4:
                return Integer.valueOf(this.hw.x());
            case 5:
                return this.hw.c();
            case 6:
                return this.hw.uc();
            case 7:
                return this.hw.fw();
            case 8:
                return this.hw.zo();
            default:
                return null;
        }
    }

    @Override // com.byazt.ld.k
    public ImageView.ScaleType c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (ImageView.ScaleType) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.k
    public String fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.k
    public int hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ld.k
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.k
    public boolean pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ld.k
    public String uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ld.k
    public int x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ld.k
    public Bitmap.Config zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Bitmap.Config) this.pr.apply(sparseArray);
    }
}
