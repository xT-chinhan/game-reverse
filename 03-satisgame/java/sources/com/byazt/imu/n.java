package com.byazt.imu;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.byazt.si.a;
import com.byazt.si.cy;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1664, 19})
public class n {

    /* JADX INFO: renamed from: com.byazt.imu.n$n, reason: collision with other inner class name */
    public interface InterfaceC0203n {
        void n();

        void n(com.byazt.qdx.qg qgVar, cy cyVar);
    }

    public static void n(q qVar, int i, int i2, final InterfaceC0203n interfaceC0203n, String str, int i3, a aVar, boolean z) {
        k.qg("splashLoadAd", " getImageBytes url ".concat(String.valueOf(qVar)));
        com.byazt.mw.s.n().s().n(qVar, new com.byazt.qdx.n.qg() { // from class: com.byazt.imu.n.1
            @Override // com.byazt.qdx.n.qg
            public void n(cy cyVar, com.byazt.qdx.qg qgVar) {
                InterfaceC0203n interfaceC0203n2;
                if (qgVar.q() && (interfaceC0203n2 = interfaceC0203n) != null) {
                    interfaceC0203n2.n(qgVar, cyVar);
                    return;
                }
                InterfaceC0203n interfaceC0203n3 = interfaceC0203n;
                if (interfaceC0203n3 != null) {
                    interfaceC0203n3.n();
                }
            }

            @Override // com.byazt.qdx.n.qg
            public void n(int i4, String str2, Throwable th) {
                InterfaceC0203n interfaceC0203n2 = interfaceC0203n;
                if (interfaceC0203n2 != null) {
                    interfaceC0203n2.n();
                }
            }
        }, i, i2, str, i3, aVar, z);
    }

    public static Drawable n(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }
}
