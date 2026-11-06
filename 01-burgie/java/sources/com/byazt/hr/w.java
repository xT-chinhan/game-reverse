package com.byazt.hr;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 109})
public abstract class w extends RecyclerView.uc {
    public boolean zo = true;

    public abstract boolean hw(RecyclerView.fo foVar);

    public abstract boolean pr(RecyclerView.fo foVar);

    public abstract boolean pr(RecyclerView.fo foVar, int i, int i2, int i3, int i4);

    public abstract boolean pr(RecyclerView.fo foVar, RecyclerView.fo foVar2, int i, int i2, int i3, int i4);

    @Override // com.byazt.hr.RecyclerView.uc
    public boolean fw(RecyclerView.fo foVar) {
        return !this.zo || foVar.g();
    }

    @Override // com.byazt.hr.RecyclerView.uc
    public boolean pr(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar, RecyclerView.uc.hw hwVar2) {
        int i = hwVar.pr;
        int i2 = hwVar.hw;
        View view = foVar.pr;
        int left = hwVar2 == null ? view.getLeft() : hwVar2.pr;
        int top = hwVar2 == null ? view.getTop() : hwVar2.hw;
        if (foVar.yb() || (i == left && i2 == top)) {
            return pr(foVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return pr(foVar, i, i2, left, top);
    }

    @Override // com.byazt.hr.RecyclerView.uc
    public boolean hw(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar, RecyclerView.uc.hw hwVar2) {
        return (hwVar == null || (hwVar.pr == hwVar2.pr && hwVar.hw == hwVar2.hw)) ? hw(foVar) : pr(foVar, hwVar.pr, hwVar.hw, hwVar2.pr, hwVar2.hw);
    }

    @Override // com.byazt.hr.RecyclerView.uc
    public boolean hn(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar, RecyclerView.uc.hw hwVar2) {
        if (hwVar.pr == hwVar2.pr && hwVar.hw == hwVar2.hw) {
            aj(foVar);
            return false;
        }
        return pr(foVar, hwVar.pr, hwVar.hw, hwVar2.pr, hwVar2.hw);
    }

    @Override // com.byazt.hr.RecyclerView.uc
    public boolean pr(RecyclerView.fo foVar, RecyclerView.fo foVar2, RecyclerView.uc.hw hwVar, RecyclerView.uc.hw hwVar2) {
        int i;
        int i2;
        int i3 = hwVar.pr;
        int i4 = hwVar.hw;
        if (foVar2.X_()) {
            int i5 = hwVar.pr;
            i2 = hwVar.hw;
            i = i5;
        } else {
            i = hwVar2.pr;
            i2 = hwVar2.hw;
        }
        return pr(foVar, foVar2, i3, i4, i, i2);
    }

    public final void zo(RecyclerView.fo foVar) {
        uc(foVar);
    }

    public final void aj(RecyclerView.fo foVar) {
        uc(foVar);
    }

    public final void vk(RecyclerView.fo foVar) {
        uc(foVar);
    }

    public final void pr(RecyclerView.fo foVar, boolean z) {
        uc(foVar);
    }
}
