package com.bytedance.sdk.openadsdk.ah;

import android.app.Application;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile d f1646ms;
    private final ms ah = new ms();
    private ah xr;

    private d() {
    }

    public static d ms() {
        if (f1646ms == null) {
            synchronized (d.class) {
                if (f1646ms == null) {
                    f1646ms = new d();
                }
            }
        }
        return f1646ms;
    }

    public Application.ActivityLifecycleCallbacks xr() {
        return this.ah;
    }

    public void ms(ah ahVar) {
        this.xr = ahVar;
    }

    private void ms(final xr xrVar) {
        this.ah.ms(new ms.InterfaceC0260ms() { // from class: com.bytedance.sdk.openadsdk.ah.d.1
            @Override // com.bytedance.sdk.openadsdk.ah.ms.InterfaceC0260ms
            public void ms() {
                xrVar.ms();
            }

            @Override // com.bytedance.sdk.openadsdk.ah.ms.InterfaceC0260ms
            public void xr() {
                xrVar.xr();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> functionMs;
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (iIntValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 5);
            return sparseArray2;
        }
        if (iIntValue != 14) {
            switch (iIntValue) {
                case 2:
                    return this.ah.ms();
                case 3:
                    return TTAppContextHolder.getContext();
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    ah ahVar = this.xr;
                    if (ahVar != null && (functionMs = ahVar.ms(4)) != null) {
                        return functionMs.apply(sparseArray);
                    }
                    return null;
                case 9:
                    Object obj = sparseArray.get(0);
                    if (obj instanceof Function) {
                        ms(new xr((Function) obj));
                    }
                    return null;
                case 10:
                    ah ahVar2 = this.xr;
                    if (ahVar2 == null) {
                        return null;
                    }
                    return ahVar2.ms(((Integer) sparseArray.get(0)).intValue());
                default:
                    return null;
            }
        }
        return this.ah.xr();
    }
}
