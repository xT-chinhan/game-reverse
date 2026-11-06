package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ka, zb, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final boolean ab;
    private final Matrix ah;
    private final String c;
    private List<zb> ch;
    private final Path d;
    private com.bytedance.adsdk.lottie.ms.xr.ao hi;
    private final RectF ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Paint f246ms;
    private final com.bytedance.adsdk.lottie.x ny;
    private final List<ah> x;
    private final RectF xr;

    private static List<ah> ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, List<com.bytedance.adsdk.lottie.model.xr.ah> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            ah ahVarMs = list.get(i).ms(xVar, cVar, ahVar);
            if (ahVarMs != null) {
                arrayList.add(ahVarMs);
            }
        }
        return arrayList;
    }

    static com.bytedance.adsdk.lottie.model.ms.sl ms(List<com.bytedance.adsdk.lottie.model.xr.ah> list) {
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.adsdk.lottie.model.xr.ah ahVar = list.get(i);
            if (ahVar instanceof com.bytedance.adsdk.lottie.model.ms.sl) {
                return (com.bytedance.adsdk.lottie.model.ms.sl) ahVar;
            }
        }
        return null;
    }

    public d(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.ao aoVar, com.bytedance.adsdk.lottie.c cVar) {
        this(xVar, ahVar, aoVar.ms(), aoVar.ah(), ms(xVar, cVar, ahVar, aoVar.xr()), ms(aoVar.xr()));
    }

    d(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, String str, boolean z, List<ah> list, com.bytedance.adsdk.lottie.model.ms.sl slVar) {
        this.f246ms = new com.bytedance.adsdk.lottie.ms.ms();
        this.xr = new RectF();
        this.ah = new Matrix();
        this.d = new Path();
        this.ka = new RectF();
        this.c = str;
        this.ny = xVar;
        this.ab = z;
        this.x = list;
        if (slVar != null) {
            com.bytedance.adsdk.lottie.ms.xr.ao aoVarCh = slVar.ch();
            this.hi = aoVarCh;
            aoVarCh.ms(ahVar);
            this.hi.ms(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            ah ahVar2 = list.get(size);
            if (ahVar2 instanceof ch) {
                arrayList.add((ch) ahVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((ch) arrayList.get(size2)).ms(list.listIterator(list.size()));
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        this.ny.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.x.size());
        arrayList.addAll(list);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ah ahVar = this.x.get(size);
            ahVar.ms(arrayList, this.x.subList(0, size));
            arrayList.add(ahVar);
        }
    }

    List<zb> xr() {
        if (this.ch == null) {
            this.ch = new ArrayList();
            for (int i = 0; i < this.x.size(); i++) {
                ah ahVar = this.x.get(i);
                if (ahVar instanceof zb) {
                    this.ch.add((zb) ahVar);
                }
            }
        }
        return this.ch;
    }

    Matrix ah() {
        com.bytedance.adsdk.lottie.ms.xr.ao aoVar = this.hi;
        if (aoVar != null) {
            return aoVar.d();
        }
        this.ah.reset();
        return this.ah;
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.zb
    public Path d() {
        this.ah.reset();
        com.bytedance.adsdk.lottie.ms.xr.ao aoVar = this.hi;
        if (aoVar != null) {
            this.ah.set(aoVar.d());
        }
        this.d.reset();
        if (this.ab) {
            return this.d;
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ah ahVar = this.x.get(size);
            if (ahVar instanceof zb) {
                this.d.addPath(((zb) ahVar).d(), this.ah);
            }
        }
        return this.d;
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(Canvas canvas, Matrix matrix, int i) {
        if (this.ab) {
            return;
        }
        this.ah.set(matrix);
        com.bytedance.adsdk.lottie.ms.xr.ao aoVar = this.hi;
        if (aoVar != null) {
            this.ah.preConcat(aoVar.d());
            i = (int) (((((this.hi.ms() == null ? 100 : this.hi.ms().ab().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.ny.ch() && ka() && i != 255;
        if (z) {
            this.xr.set(0.0f, 0.0f, 0.0f, 0.0f);
            ms(this.xr, this.ah, true);
            this.f246ms.setAlpha(i);
            com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.xr, this.f246ms);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ah ahVar = this.x.get(size);
            if (ahVar instanceof ka) {
                ((ka) ahVar).ms(canvas, this.ah, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean ka() {
        int i = 0;
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            if ((this.x.get(i2) instanceof ka) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        this.ah.set(matrix);
        com.bytedance.adsdk.lottie.ms.xr.ao aoVar = this.hi;
        if (aoVar != null) {
            this.ah.preConcat(aoVar.d());
        }
        this.ka.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ah ahVar = this.x.get(size);
            if (ahVar instanceof ka) {
                ((ka) ahVar).ms(this.ka, this.ah, z);
                rectF.union(this.ka);
            }
        }
    }
}
