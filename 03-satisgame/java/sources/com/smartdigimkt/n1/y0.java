package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements Runnable {
    public final /* synthetic */ f1 a;
    public final /* synthetic */ BaseScreenATView b;

    public y0(BaseScreenATView baseScreenATView, f1 f1Var) {
        this.b = baseScreenATView;
        this.a = f1Var;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006b A[PHI: r0
      0x006b: PHI (r0v3 java.util.ArrayList) = (r0v2 java.util.ArrayList), (r0v15 java.util.ArrayList) binds: [B:31:0x0063, B:28:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i = this.b.P;
        int iMin = 0;
        if (i == 2) {
            arrayList = aVarA.V;
            if (arrayList == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList;
            }
        } else if (i == 3) {
            arrayList = aVarA.W;
            if (arrayList == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList;
            }
        } else if (i == 5) {
            ArrayList arrayList4 = aVarA.X;
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
            }
            arrayList2 = arrayList4;
            boolean z = arrayList2.size() >= 4;
            if (z) {
                int i2 = 0;
                while (true) {
                    if (i2 < 4) {
                        String str = (String) arrayList2.get(i2);
                        if (!TextUtils.isEmpty(str) && com.smartdigimkt.d0.s.a(3, str)) {
                            i2++;
                        }
                    } else if (!z) {
                    }
                    arrayList2.clear();
                }
            } else if (!z) {
                arrayList2.clear();
            }
        }
        if (arrayList2.size() == 0) {
            com.smartdigimkt.q3.f.a().a(new w0(this, arrayList3));
            return;
        }
        if (arrayList2.size() > 0) {
            try {
                iMin = Math.min(this.b.getResources().getDisplayMetrics().widthPixels, this.b.getResources().getDisplayMetrics().heightPixels) / 2;
            } catch (Throwable unused) {
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Bitmap bitmapB = com.smartdigimkt.i3.m.a(this.b.getContext()).b(new com.smartdigimkt.i3.o(3, (String) it.next()), iMin, iMin);
                if (bitmapB != null) {
                    arrayList3.add(bitmapB);
                }
            }
            if (arrayList3.size() != arrayList2.size()) {
                arrayList3.clear();
            }
        }
        com.smartdigimkt.q3.f.a().a(new x0(this, arrayList3));
    }
}
