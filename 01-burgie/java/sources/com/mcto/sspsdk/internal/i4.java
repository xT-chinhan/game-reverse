package com.mcto.sspsdk.internal;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class i4 implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ j4 b;

    public i4(j4 j4Var, e eVar) {
        this.b = j4Var;
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j4 j4Var = this.b;
        e eVar = this.a;
        j4Var.getClass();
        if (eVar.x == 0 || eVar.H == 0) {
            z9 z9Var = new z9(j4Var);
            if (eVar.H == 0) {
                TextView textView = j4Var.r;
                int iA = hk.a(j4Var.getContext(), 6.0f);
                Rect rect = new Rect();
                textView.getHitRect(rect);
                rect.left -= iA;
                rect.top -= 100;
                rect.right += 100;
                rect.bottom += 100;
                z9Var.a.add(new TouchDelegate(rect, j4Var.r));
            }
            if (eVar.x == 0) {
                TextView textView2 = j4Var.p;
                int iA2 = hk.a(j4Var.getContext(), 6.0f);
                Rect rect2 = new Rect();
                textView2.getHitRect(rect2);
                rect2.left -= 100;
                rect2.top -= 100;
                rect2.right += 100;
                rect2.bottom += iA2;
                z9Var.a.add(new TouchDelegate(rect2, j4Var.p));
            }
            j4Var.setTouchDelegate(z9Var);
        }
    }
}
