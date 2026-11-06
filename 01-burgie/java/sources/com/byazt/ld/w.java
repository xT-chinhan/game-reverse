package com.byazt.ld;

import android.graphics.Bitmap;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 109})
public class w implements vk, Function {
    public volatile vk hw;
    public volatile Function pr;

    public w(vk vkVar) {
        this.hw = vkVar;
    }

    public w(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hw.pr((Bitmap) sparseArray.get(1));
            default:
                return null;
        }
    }

    @Override // com.byazt.ld.vk
    public Bitmap pr(Bitmap bitmap) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bitmap);
        return (Bitmap) this.pr.apply(sparseArray);
    }
}
