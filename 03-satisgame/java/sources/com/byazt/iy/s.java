package com.byazt.iy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1124, 8})
public class s extends fs<com.byazt.gq.n, com.byazt.gq.qg> {
    public static final /* synthetic */ boolean w = true;
    public List<l> l;
    public final byte n;
    public List<l> q;
    public final byte qg;
    public byte[] s;
    public static final byte[] k = {-119, 80, 78, 71, 13, 10, 26, 10};
    public static final byte[] cy = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    public static final ThreadLocal<CRC32> hd = new ThreadLocal<>();

    private CRC32 n() {
        ThreadLocal<CRC32> threadLocal = hd;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc33 = new CRC32();
        threadLocal.set(crc33);
        return crc33;
    }

    public s(com.byazt.gq.n nVar, w wVar) {
        super(nVar);
        this.q = new ArrayList();
        this.l = new ArrayList();
        this.n = wVar.sz;
        this.qg = wVar.oa;
        this.d = (wVar.cp * 1000) / (wVar.d == 0 ? (short) 100 : wVar.d);
        if (this.d < 10) {
            this.d = 100;
        }
        this.fs = wVar.s;
        this.rv = wVar.fs;
        this.tj = wVar.rv;
        this.cp = wVar.tj;
    }

    private int n(com.byazt.gq.qg qgVar) throws IOException {
        int i;
        Iterator<l> it = this.l.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += it.next().q + 12;
        }
        for (l lVar : this.q) {
            if (lVar instanceof tj) {
                i = lVar.q + 12;
            } else if (lVar instanceof x) {
                i = lVar.q + 8;
            }
            i2 += i;
        }
        int length = i2 + cy.length;
        qgVar.s(length);
        qgVar.n(k);
        qgVar.qg(13);
        int iN = qgVar.n();
        qgVar.n(d.n);
        qgVar.qg(this.fs);
        qgVar.qg(this.rv);
        qgVar.n(this.s);
        CRC32 crc32N = n();
        crc32N.reset();
        crc32N.update(qgVar.qg(), iN, 17);
        qgVar.qg((int) crc32N.getValue());
        for (l lVar2 : this.l) {
            if (!(lVar2 instanceof cp)) {
                ((com.byazt.gq.n) this.x).d_();
                ((com.byazt.gq.n) this.x).n(lVar2.x);
                ((com.byazt.gq.n) this.x).n(qgVar.qg(), qgVar.n(), lVar2.q + 12);
                qgVar.q(lVar2.q + 12);
            }
        }
        for (l lVar3 : this.q) {
            if (lVar3 instanceof tj) {
                ((com.byazt.gq.n) this.x).d_();
                ((com.byazt.gq.n) this.x).n(lVar3.x);
                ((com.byazt.gq.n) this.x).n(qgVar.qg(), qgVar.n(), lVar3.q + 12);
                qgVar.q(lVar3.q + 12);
            } else if (lVar3 instanceof x) {
                qgVar.qg(lVar3.q - 4);
                int iN2 = qgVar.n();
                qgVar.n(tj.n);
                ((com.byazt.gq.n) this.x).d_();
                ((com.byazt.gq.n) this.x).n(lVar3.x + 4 + 4 + 4);
                ((com.byazt.gq.n) this.x).n(qgVar.qg(), qgVar.n(), lVar3.q - 4);
                qgVar.q(lVar3.q - 4);
                crc32N.reset();
                crc32N.update(qgVar.qg(), iN2, lVar3.q);
                qgVar.qg((int) crc32N.getValue());
            }
        }
        qgVar.n(cy);
        return length;
    }

    @Override // com.byazt.iy.fs
    public Bitmap n(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.byazt.gq.qg qgVar) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iN = n(qgVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] bArrQg = qgVar.qg();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrQg, 0, iN, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrQg, 0, iN, options2);
            }
            if (!w && bitmapDecodeByteArray == null) {
                throw new AssertionError();
            }
            this.oa.left = 0;
            this.oa.top = 0;
            this.oa.right = bitmapDecodeByteArray.getWidth();
            this.oa.bottom = bitmapDecodeByteArray.getHeight();
            float f = i;
            this.sz.left = (int) (this.tj / f);
            this.sz.top = (int) (this.cp / f);
            this.sz.right = (int) ((this.tj / f) + bitmapDecodeByteArray.getWidth());
            this.sz.bottom = (int) ((this.cp / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.oa, this.sz, paint);
            return bitmapDecodeByteArray;
        } catch (IOException unused2) {
            return null;
        }
    }
}
