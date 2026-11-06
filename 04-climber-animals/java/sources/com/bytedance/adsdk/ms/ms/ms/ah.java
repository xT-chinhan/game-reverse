package com.bytedance.adsdk.ms.ms.ms;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.umeng.analytics.pro.ek;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends x<com.bytedance.adsdk.ms.ms.xr.ms, com.bytedance.adsdk.ms.ms.xr.xr> {
    static final /* synthetic */ boolean c = true;
    byte[] ah;
    List<ka> d;
    List<ka> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final byte f304ms;
    public final byte xr;
    private static final byte[] ub = {-119, 80, 78, 71, ek.k, 10, 26, 10};
    private static final byte[] ao = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static final ThreadLocal<CRC32> h = new ThreadLocal<>();

    private CRC32 ms() {
        ThreadLocal<CRC32> threadLocal = h;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc33 = new CRC32();
        threadLocal.set(crc33);
        return crc33;
    }

    public ah(com.bytedance.adsdk.ms.ms.xr.ms msVar, c cVar) {
        super(msVar);
        this.d = new ArrayList();
        this.ka = new ArrayList();
        this.f304ms = cVar.u;
        this.xr = cVar.zb;
        this.sl = (cVar.hi * 1000) / (cVar.sl == 0 ? (short) 100 : cVar.sl);
        if (this.sl < 10) {
            this.sl = 100;
        }
        this.x = cVar.ah;
        this.ny = cVar.x;
        this.ch = cVar.ny;
        this.hi = cVar.ch;
    }

    private int ms(com.bytedance.adsdk.ms.ms.xr.xr xrVar) throws IOException {
        int i;
        Iterator<ka> it = this.ka.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += it.next().d + 12;
        }
        for (ka kaVar : this.d) {
            if (kaVar instanceof ch) {
                i = kaVar.d + 12;
            } else if (kaVar instanceof ab) {
                i = kaVar.d + 8;
            }
            i2 += i;
        }
        int length = i2 + ao.length;
        xrVar.ah(length);
        xrVar.ms(ub);
        xrVar.xr(13);
        int iMs = xrVar.ms();
        xrVar.ms(sl.f320ms);
        xrVar.xr(this.x);
        xrVar.xr(this.ny);
        xrVar.ms(this.ah);
        CRC32 crc32Ms = ms();
        crc32Ms.reset();
        crc32Ms.update(xrVar.xr(), iMs, 17);
        xrVar.xr((int) crc32Ms.getValue());
        for (ka kaVar2 : this.ka) {
            if (!(kaVar2 instanceof hi)) {
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).d_();
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).ms(kaVar2.ab);
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).ms(xrVar.xr(), xrVar.ms(), kaVar2.d + 12);
                xrVar.d(kaVar2.d + 12);
            }
        }
        for (ka kaVar3 : this.d) {
            if (kaVar3 instanceof ch) {
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).d_();
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).ms(kaVar3.ab);
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).ms(xrVar.xr(), xrVar.ms(), kaVar3.d + 12);
                xrVar.d(kaVar3.d + 12);
            } else if (kaVar3 instanceof ab) {
                xrVar.xr(kaVar3.d - 4);
                int iMs2 = xrVar.ms();
                xrVar.ms(ch.f306ms);
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).d_();
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).ms(kaVar3.ab + 4 + 4 + 4);
                ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).ms(xrVar.xr(), xrVar.ms(), kaVar3.d - 4);
                xrVar.d(kaVar3.d - 4);
                crc32Ms.reset();
                crc32Ms.update(xrVar.xr(), iMs2, kaVar3.d);
                xrVar.xr((int) crc32Ms.getValue());
            }
        }
        xrVar.ms(ao);
        return length;
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.x
    public Bitmap ms(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.ms.ms.xr.xr xrVar) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iMs = ms(xrVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] bArrXr = xrVar.xr();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrXr, 0, iMs, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrXr, 0, iMs, options2);
            }
            if (!c && bitmapDecodeByteArray == null) {
                throw new AssertionError();
            }
            this.zb.left = 0;
            this.zb.top = 0;
            this.zb.right = bitmapDecodeByteArray.getWidth();
            this.zb.bottom = bitmapDecodeByteArray.getHeight();
            float f = i;
            this.u.left = (int) (this.ch / f);
            this.u.top = (int) (this.hi / f);
            this.u.right = (int) ((this.ch / f) + bitmapDecodeByteArray.getWidth());
            this.u.bottom = (int) ((this.hi / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.zb, this.u, paint);
            return bitmapDecodeByteArray;
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return null;
        }
    }
}
