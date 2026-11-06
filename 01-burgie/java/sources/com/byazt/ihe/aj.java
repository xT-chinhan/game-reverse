package com.byazt.ihe;

import android.graphics.SurfaceTexture;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 588, 61})
public class aj implements fw, Function {
    public volatile fw hw;
    public volatile Function pr;

    public aj(fw fwVar) {
        this.hw = fwVar;
    }

    public aj(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.ihe.fw
    public long a() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object gVar = sparseArray.get(1);
                if (gVar != null) {
                    gVar = new g((Function) gVar);
                }
                this.hw.pr((m) gVar);
                return null;
            case 2:
                this.hw.hw(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 3:
                this.hw.hw(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 4:
                this.hw.pr(((Boolean) sparseArray.get(1)).booleanValue(), ((Long) sparseArray.get(2)).longValue(), ((Boolean) sparseArray.get(3)).booleanValue());
                return null;
            case 5:
                this.hw.hw();
                return null;
            case 6:
                this.hw.hn();
                return null;
            case 7:
                this.hw.x();
                return null;
            case 8:
                this.hw.fw();
                return null;
            case 9:
                this.hw.c();
                return null;
            case 10:
                this.hw.uc();
                return null;
            case 11:
                this.hw.pr(((Long) sparseArray.get(1)).longValue());
                return null;
            case 12:
                return Boolean.valueOf(this.hw.zo());
            case 13:
                this.hw.pr(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 14:
                this.hw.pr((SurfaceHolder) sparseArray.get(1));
                return null;
            case 15:
                return this.hw.rc();
            case 16:
                this.hw.pr((SurfaceTexture) sparseArray.get(1));
                return null;
            case 17:
                return this.hw.z();
            case 18:
                return Boolean.valueOf(this.hw.ho());
            case 19:
                return Boolean.valueOf(this.hw.g());
            case 20:
                return Boolean.valueOf(this.hw.w());
            case 21:
                return Integer.valueOf(this.hw.yb());
            case 22:
                return Integer.valueOf(this.hw.lb());
            case 23:
                return Boolean.valueOf(this.hw.vk());
            case 24:
                return Boolean.valueOf(this.hw.k());
            case 25:
                return Boolean.valueOf(this.hw.m());
            case 26:
                return Long.valueOf(this.hw.nt());
            case 27:
                return Integer.valueOf(this.hw.qa());
            case 28:
                return Long.valueOf(this.hw.a());
            case 29:
                return Long.valueOf(this.hw.cz());
            case 30:
                this.hw.hn(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 31:
                return Boolean.valueOf(this.hw.ny());
            case 32:
                Object zoVar = sparseArray.get(1);
                if (zoVar != null) {
                    zoVar = new zo((Function) zoVar);
                }
                this.hw.pr((fw.pr) zoVar);
                return null;
            case 33:
                Object zoVar2 = sparseArray.get(1);
                if (zoVar2 != null) {
                    zoVar2 = new zo((Function) zoVar2);
                }
                this.hw.hw((fw.pr) zoVar2);
                return null;
            case 34:
                this.hw.pr(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 35:
                return Integer.valueOf(this.hw.fo());
            case 36:
                this.hw.pr(((Float) sparseArray.get(1)).floatValue());
                return null;
            case 37:
                return this.hw.b();
            default:
                return null;
        }
    }

    @Override // com.byazt.ihe.fw
    public String b() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public long cz() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ihe.fw
    public int fo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.fw
    public void fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public boolean g() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.fw
    public void hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void hn(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public boolean ho() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.fw
    public void hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void hw(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void hw(fw.pr prVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        if (prVar != null) {
            prVar = new zo(prVar);
        }
        sparseArray.put(1, prVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void hw(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public boolean k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.fw
    public int lb() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.fw
    public boolean m() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.fw
    public long nt() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ihe.fw
    public boolean ny() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.fw
    public void pr(float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, Float.valueOf(f));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void pr(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void pr(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Long.valueOf(j));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void pr(SurfaceTexture surfaceTexture) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, surfaceTexture);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void pr(SurfaceHolder surfaceHolder) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, surfaceHolder);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void pr(fw.pr prVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        if (prVar != null) {
            prVar = new zo(prVar);
        }
        sparseArray.put(1, prVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void pr(m mVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(1, mVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z, long j, boolean z2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Boolean.valueOf(z));
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Boolean.valueOf(z2));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public int qa() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.fw
    public SurfaceHolder rc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (SurfaceHolder) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public void uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public boolean vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.fw
    public boolean w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.fw
    public void x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public int yb() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.fw
    public SurfaceTexture z() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (SurfaceTexture) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw
    public boolean zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
