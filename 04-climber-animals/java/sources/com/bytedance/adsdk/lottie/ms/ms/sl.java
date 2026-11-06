package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class sl implements ch, zb {
    private final com.bytedance.adsdk.lottie.model.xr.ny c;
    private final String d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Path f252ms = new Path();
    private final Path xr = new Path();
    private final Path ah = new Path();
    private final List<zb> ka = new ArrayList();

    public sl(com.bytedance.adsdk.lottie.model.xr.ny nyVar) {
        this.d = nyVar.ms();
        this.c = nyVar;
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ch
    public void ms(ListIterator<ah> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            ah ahVarPrevious = listIterator.previous();
            if (ahVarPrevious instanceof zb) {
                this.ka.add((zb) ahVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        for (int i = 0; i < this.ka.size(); i++) {
            this.ka.get(i).ms(list, list2);
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.zb
    public Path d() {
        this.ah.reset();
        if (this.c.ah()) {
            return this.ah;
        }
        int i = AnonymousClass1.f253ms[this.c.xr().ordinal()];
        if (i == 1) {
            ms();
        } else if (i == 2) {
            ms(Path.Op.UNION);
        } else if (i == 3) {
            ms(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            ms(Path.Op.INTERSECT);
        } else if (i == 5) {
            ms(Path.Op.XOR);
        }
        return this.ah;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.ms.ms.sl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f253ms;

        static {
            int[] iArr = new int[com.bytedance.adsdk.lottie.model.xr.ny.ms.values().length];
            f253ms = iArr;
            try {
                iArr[com.bytedance.adsdk.lottie.model.xr.ny.ms.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f253ms[com.bytedance.adsdk.lottie.model.xr.ny.ms.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f253ms[com.bytedance.adsdk.lottie.model.xr.ny.ms.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f253ms[com.bytedance.adsdk.lottie.model.xr.ny.ms.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f253ms[com.bytedance.adsdk.lottie.model.xr.ny.ms.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void ms() {
        for (int i = 0; i < this.ka.size(); i++) {
            this.ah.addPath(this.ka.get(i).d());
        }
    }

    private void ms(Path.Op op) {
        this.xr.reset();
        this.f252ms.reset();
        for (int size = this.ka.size() - 1; size > 0; size--) {
            zb zbVar = this.ka.get(size);
            if (zbVar instanceof d) {
                d dVar = (d) zbVar;
                List<zb> listXr = dVar.xr();
                for (int size2 = listXr.size() - 1; size2 >= 0; size2--) {
                    Path pathD = listXr.get(size2).d();
                    pathD.transform(dVar.ah());
                    this.xr.addPath(pathD);
                }
            } else {
                this.xr.addPath(zbVar.d());
            }
        }
        zb zbVar2 = this.ka.get(0);
        if (zbVar2 instanceof d) {
            d dVar2 = (d) zbVar2;
            List<zb> listXr2 = dVar2.xr();
            for (int i = 0; i < listXr2.size(); i++) {
                Path pathD2 = listXr2.get(i).d();
                pathD2.transform(dVar2.ah());
                this.f252ms.addPath(pathD2);
            }
        } else {
            this.f252ms.set(zbVar2.d());
        }
        this.ah.op(this.f252ms, this.xr, op);
    }
}
