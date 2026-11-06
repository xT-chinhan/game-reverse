package com.anythink.basead.ui.f;

import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public interface a {
        void a(int i, int i2);
    }

    public static void a(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 0;
        if (z) {
            layoutParams.height = 0;
        }
        view.setLayoutParams(layoutParams);
    }

    private static float a(com.anythink.basead.ui.b bVar, boolean z, x xVar) {
        return a(bVar, z, xVar, true);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x003d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0043  */
    public static float a(com.anythink.basead.ui.b bVar, boolean z, x xVar, boolean z2) {
        int iR;
        float f;
        double dBw;
        if (xVar == null || xVar.o == null) {
            iR = 1;
        } else if (z) {
            iR = xVar.o.q();
        } else {
            iR = xVar.o.r();
        }
        float f2 = 1.0f;
        if (bVar != null) {
            if (iR == 2) {
                f = 1.5f;
            } else if (iR != 3) {
                if (iR == 4) {
                    f = 0.5f;
                }
                if (xVar != null || xVar.o == null) {
                    dBw = 1.0d;
                } else {
                    dBw = xVar.o.bw();
                }
                a(bVar, f2, (z || !z2) ? dBw : 1.0d);
            } else {
                f = 0.75f;
            }
            f2 = f;
            if (xVar != null) {
                dBw = 1.0d;
            } else {
                dBw = 1.0d;
            }
            a(bVar, f2, (z || !z2) ? dBw : 1.0d);
        }
        return f2;
    }

    public static void a(com.anythink.basead.ui.b bVar, float f, double d) {
        if (bVar != null) {
            bVar.setClickAreaScaleFactor(f);
            bVar.setClickViewAlpha(d);
        }
    }

    public static boolean a(long j, x xVar) {
        if (xVar != null && xVar.o != null && xVar.o.bx() < 0) {
            return true;
        }
        if (j <= 0) {
            return false;
        }
        return xVar == null || xVar.o == null || System.currentTimeMillis() - j > xVar.o.bx();
    }
}
