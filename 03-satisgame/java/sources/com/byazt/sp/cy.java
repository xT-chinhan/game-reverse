package com.byazt.sp;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements cp, l, oa, tj, com.byazt.bd.n.InterfaceC0134n {
    public final com.byazt.bd.n<Float, Float> fs;
    public final String l;
    public final com.byazt.eg.s q;
    public final com.byazt.bd.cy rv;
    public final com.byazt.pp.fs s;
    public q tj;
    public final boolean w;
    public final com.byazt.bd.n<Float, Float> x;
    public final Matrix n = new Matrix();
    public final Path qg = new Path();

    public cy(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.d dVar) {
        this.s = fsVar;
        this.q = sVar;
        this.l = dVar.n();
        this.w = dVar.l();
        com.byazt.bd.n<Float, Float> nVarN = dVar.qg().n();
        this.x = nVarN;
        sVar.n(nVarN);
        nVarN.n(this);
        com.byazt.bd.n<Float, Float> nVarN2 = dVar.s().n();
        this.fs = nVarN2;
        sVar.n(nVarN2);
        nVarN2.n(this);
        com.byazt.bd.cy cyVarTj = dVar.q().tj();
        this.rv = cyVarTj;
        cyVarTj.n(sVar);
        cyVarTj.n(this);
    }

    @Override // com.byazt.sp.tj
    public void n(ListIterator<s> listIterator) {
        if (this.tj != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.tj = new q(this.s, this.q, "Repeater", this.w, arrayList, null);
    }

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        this.tj.n(list, list2);
    }

    @Override // com.byazt.sp.oa
    public Path q() {
        Path pathQ = this.tj.q();
        this.qg.reset();
        float fFloatValue = this.x.x().floatValue();
        float fFloatValue2 = this.fs.x().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.n.set(this.rv.qg(i + fFloatValue2));
            this.qg.addPath(pathQ, this.n);
        }
        return this.qg;
    }

    @Override // com.byazt.sp.l
    public void n(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.x.x().floatValue();
        float fFloatValue2 = this.fs.x().floatValue();
        float fFloatValue3 = this.rv.qg().x().floatValue() / 100.0f;
        float fFloatValue4 = this.rv.s().x().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.n.set(matrix);
            float f = i2;
            this.n.preConcat(this.rv.qg(f + fFloatValue2));
            this.tj.n(canvas, this.n, (int) (i * com.byazt.nu.rv.n(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        this.tj.n(rectF, matrix, z);
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        this.s.invalidateSelf();
    }
}
