package com.smartdigimkt.i2;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.smartdigimkt.n1.j3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    public static void a(ImageView imageView, boolean z) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = 0;
        if (z) {
            layoutParams.height = 0;
        }
        imageView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0031  */
    /* JADX WARN: Code duplicated, block: B:31:0x0037  */
    public static float a(j3 j3Var, boolean z, com.smartdigimkt.a3.a aVar, boolean z2) {
        int i;
        float f;
        double d;
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.e eVar2;
        if (aVar == null || (eVar2 = aVar.s) == null) {
            i = 1;
        } else if (z) {
            i = eVar2.z;
        } else {
            i = eVar2.P;
        }
        float f2 = 1.0f;
        if (j3Var != null) {
            if (i == 2) {
                f = 1.5f;
            } else if (i != 3) {
                if (i == 4) {
                    f = 0.5f;
                }
                if (aVar != null || (eVar = aVar.s) == null) {
                    d = 1.0d;
                } else {
                    d = eVar.o1;
                }
                double d2 = (z || !z2) ? d : 1.0d;
                j3Var.setClickAreaScaleFactor(f2);
                j3Var.setClickViewAlpha(d2);
            } else {
                f = 0.75f;
            }
            f2 = f;
            if (aVar != null) {
                d = 1.0d;
            } else {
                d = 1.0d;
            }
            if (z) {
            }
            j3Var.setClickAreaScaleFactor(f2);
            j3Var.setClickViewAlpha(d2);
        }
        return f2;
    }
}
