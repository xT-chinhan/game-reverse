package com.byazt.hcx;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1225, 109})
public class w implements vk, Function {
    public volatile vk hw;
    public volatile Function pr;

    public w(vk vkVar) {
        this.hw = vkVar;
    }

    public w(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.hcx.vk
    public long aj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Long.valueOf(this.hw.pr());
            case 2:
                return Long.valueOf(this.hw.hw());
            case 3:
                return Long.valueOf(this.hw.hn());
            case 4:
                return Long.valueOf(this.hw.x());
            case 5:
                return Long.valueOf(this.hw.c());
            case 6:
                return Long.valueOf(this.hw.uc());
            case 7:
                return Long.valueOf(this.hw.fw());
            case 8:
                return Long.valueOf(this.hw.zo());
            case 9:
                return Long.valueOf(this.hw.aj());
            default:
                return null;
        }
    }

    @Override // com.byazt.hcx.vk
    public long c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.hcx.vk
    public long fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.hcx.vk
    public long hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.hcx.vk
    public long hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.hcx.vk
    public long pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.hcx.vk
    public long uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.hcx.vk
    public long x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.hcx.vk
    public long zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }
}
