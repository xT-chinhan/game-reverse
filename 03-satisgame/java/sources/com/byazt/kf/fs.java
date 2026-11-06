package com.byazt.kf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.fz.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1116, 101})
public abstract class fs extends s {
    public int d;
    public int oa;
    public boolean sz;

    public abstract void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, d dVar);

    public fs(com.byazt.pl.qg qgVar, Function<SparseArray<Object>, Object> function) {
        super(qgVar, function);
        this.d = 0;
        this.oa = 0;
        this.sz = false;
    }

    public final void n(n nVar) {
        int i = this.oa;
        if (i < 60) {
            this.oa = i + 1;
            if (nVar != null) {
                nVar.n();
                return;
            }
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter click方法回调次数需要小于60次");
    }

    public final void qg(n nVar) {
        if (this.sz) {
            int i = this.d;
            if (i < 2) {
                this.d = i + 1;
                if (nVar != null) {
                    nVar.n();
                    return;
                }
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, d dVar, List<View> list4) {
        super.n(activity, viewGroup, list, list2, list3, dVar, list4);
        try {
            this.sz = true;
            n(activity, viewGroup, list, list2, list3, dVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.sg.s
    public void cp() {
        try {
            this.sz = true;
            if (this.cp != null) {
                this.cp.apply(com.byazt.of.qg.n().n(6083).n(Void.class).qg());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.sg.s
    public Bitmap dx() {
        if (this.cp != null) {
            try {
                Object objApply = this.cp.apply(com.byazt.of.qg.n().n(8267).n(Bitmap.class).qg());
                if (objApply instanceof Bitmap) {
                    return (Bitmap) objApply;
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return super.dx();
    }
}
