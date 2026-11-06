package com.byazt.iy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1124, 26})
public class qg extends rv<com.byazt.gq.n, com.byazt.gq.qg> {
    public int fs;
    public final Paint rv;
    public final n tj;
    public com.byazt.gq.qg x;

    @com.byazt.cp.n(n = {0, 1, 1124, 48})
    private static class n {
        public byte n;
        public Rect qg;
        public ByteBuffer s;

        private n() {
            this.qg = new Rect();
        }
    }

    public qg(com.byazt.zv.qg qgVar, rv.n nVar) {
        super(qgVar, nVar);
        Paint paint = new Paint();
        this.rv = paint;
        this.tj = new n();
        paint.setAntiAlias(true);
    }

    @Override // com.byazt.iy.rv
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.byazt.gq.qg q() {
        if (this.x == null) {
            this.x = new com.byazt.gq.qg();
        }
        return this.x;
    }

    @Override // com.byazt.iy.rv
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.byazt.gq.n s(com.byazt.gq.w wVar) {
        return new com.byazt.gq.n(wVar);
    }

    @Override // com.byazt.iy.rv
    public int qg() {
        return this.fs;
    }

    @Override // com.byazt.iy.rv
    public void s() {
        this.tj.s = null;
        this.x = null;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.byazt.iy.rv
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Rect qg(com.byazt.gq.n nVar) throws IOException {
        List<l> listN = q.n(nVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        s sVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (l lVar : listN) {
            if (lVar instanceof com.byazt.iy.n) {
                this.fs = ((com.byazt.iy.n) lVar).s;
                z = true;
            } else if (lVar instanceof w) {
                sVar = new s(nVar, (w) lVar);
                sVar.l = arrayList;
                sVar.s = bArr;
                this.n.add(sVar);
            } else if (lVar instanceof x) {
                if (sVar != null) {
                    sVar.q.add(lVar);
                }
            } else if (lVar instanceof tj) {
                if (!z) {
                    oa oaVar = new oa(nVar);
                    oaVar.fs = i;
                    oaVar.rv = i2;
                    this.n.add(oaVar);
                    this.fs = 1;
                    break;
                }
                if (sVar != null) {
                    sVar.q.add(lVar);
                }
            } else if (lVar instanceof d) {
                d dVar = (d) lVar;
                i = dVar.qg;
                i2 = dVar.s;
                bArr = dVar.fs;
            } else if (!(lVar instanceof cp)) {
                arrayList.add(lVar);
            }
        }
        int i3 = i * i2;
        this.l = ByteBuffer.allocate(((i3 / (this.s * this.s)) + 1) * 4);
        this.tj.s = ByteBuffer.allocate(((i3 / (this.s * this.s)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.byazt.iy.rv
    public void n(fs<com.byazt.gq.n, com.byazt.gq.qg> fsVar) {
        if (fsVar == null || this.w == null) {
            return;
        }
        try {
            Bitmap bitmapN = n(this.w.width() / this.s, this.w.height() / this.s);
            Canvas canvas = this.q.get(bitmapN);
            if (canvas == null) {
                canvas = new Canvas(bitmapN);
                this.q.put(bitmapN, canvas);
            }
            Canvas canvas2 = canvas;
            if (fsVar instanceof s) {
                this.l.rewind();
                bitmapN.copyPixelsFromBuffer(this.l);
                if (this.qg == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.tj.qg);
                    byte b = this.tj.n;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        this.tj.s.rewind();
                        bitmapN.copyPixelsFromBuffer(this.tj.s);
                    }
                    canvas2.restore();
                }
                if (((s) fsVar).qg == 2 && this.tj.n != 2) {
                    this.tj.s.rewind();
                    bitmapN.copyPixelsToBuffer(this.tj.s);
                }
                this.tj.n = ((s) fsVar).qg;
                canvas2.save();
                if (((s) fsVar).n == 0) {
                    canvas2.clipRect(fsVar.tj / this.s, fsVar.cp / this.s, (fsVar.tj + fsVar.fs) / this.s, (fsVar.cp + fsVar.rv) / this.s);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.tj.qg.set(fsVar.tj / this.s, fsVar.cp / this.s, (fsVar.tj + fsVar.fs) / this.s, (fsVar.cp + fsVar.rv) / this.s);
                canvas2.restore();
            }
            Bitmap bitmapN2 = n(fsVar.fs, fsVar.rv);
            n(fsVar.n(canvas2, this.rv, this.s, bitmapN2, q()));
            n(bitmapN2);
            this.l.rewind();
            bitmapN.copyPixelsToBuffer(this.l);
            n(bitmapN);
        } catch (Exception unused) {
        }
    }
}
