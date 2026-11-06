package com.bytedance.adsdk.ms.ms.ms;

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
public class xr extends ny<com.bytedance.adsdk.ms.ms.xr.ms, com.bytedance.adsdk.ms.ms.xr.xr> {
    private com.bytedance.adsdk.ms.ms.xr.xr ab;
    private final ms ch;
    private final Paint ny;
    private int x;

    private static class ms {
        ByteBuffer ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        byte f321ms;
        Rect xr;

        private ms() {
            this.xr = new Rect();
        }
    }

    public xr(com.bytedance.adsdk.ms.ms.ah.xr xrVar, ny.ms msVar) {
        super(xrVar, msVar);
        Paint paint = new Paint();
        this.ny = paint;
        this.ch = new ms();
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.ms.ms.ms.ny
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ms.ms.xr.xr d() {
        if (this.ab == null) {
            this.ab = new com.bytedance.adsdk.ms.ms.xr.xr();
        }
        return this.ab;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.ms.ms.ms.ny
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ms.ms.xr.ms ah(com.bytedance.adsdk.ms.ms.xr.c cVar) {
        return new com.bytedance.adsdk.ms.ms.xr.ms(cVar);
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.ny
    protected int xr() {
        return this.x;
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.ny
    protected void ah() {
        this.ch.ah = null;
        this.ab = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.adsdk.ms.ms.ms.ny
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Rect xr(com.bytedance.adsdk.ms.ms.xr.ms msVar) throws IOException {
        List<ka> listMs = d.ms(msVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        ah ahVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (ka kaVar : listMs) {
            if (kaVar instanceof com.bytedance.adsdk.ms.ms.ms.ms) {
                this.x = ((com.bytedance.adsdk.ms.ms.ms.ms) kaVar).ah;
                z = true;
            } else if (kaVar instanceof c) {
                ahVar = new ah(msVar, (c) kaVar);
                ahVar.ka = arrayList;
                ahVar.ah = bArr;
                this.f309ms.add(ahVar);
            } else if (kaVar instanceof ab) {
                if (ahVar != null) {
                    ahVar.d.add(kaVar);
                }
            } else if (kaVar instanceof ch) {
                if (!z) {
                    zb zbVar = new zb(msVar);
                    zbVar.x = i;
                    zbVar.ny = i2;
                    this.f309ms.add(zbVar);
                    this.x = 1;
                    break;
                }
                if (ahVar != null) {
                    ahVar.d.add(kaVar);
                }
            } else if (kaVar instanceof sl) {
                sl slVar = (sl) kaVar;
                i = slVar.xr;
                i2 = slVar.ah;
                bArr = slVar.x;
            } else if (!(kaVar instanceof hi)) {
                arrayList.add(kaVar);
            }
        }
        int i3 = i * i2;
        this.ka = ByteBuffer.allocate(((i3 / (this.ah * this.ah)) + 1) * 4);
        this.ch.ah = ByteBuffer.allocate(((i3 / (this.ah * this.ah)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.ny
    protected void ms(x<com.bytedance.adsdk.ms.ms.xr.ms, com.bytedance.adsdk.ms.ms.xr.xr> xVar) {
        if (xVar == null || this.c == null) {
            return;
        }
        try {
            Bitmap bitmapMs = ms(this.c.width() / this.ah, this.c.height() / this.ah);
            Canvas canvas = this.d.get(bitmapMs);
            if (canvas == null) {
                canvas = new Canvas(bitmapMs);
                this.d.put(bitmapMs, canvas);
            }
            Canvas canvas2 = canvas;
            if (xVar instanceof ah) {
                this.ka.rewind();
                bitmapMs.copyPixelsFromBuffer(this.ka);
                if (this.xr == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.ch.xr);
                    byte b = this.ch.f321ms;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        this.ch.ah.rewind();
                        bitmapMs.copyPixelsFromBuffer(this.ch.ah);
                    }
                    canvas2.restore();
                }
                if (((ah) xVar).xr == 2 && this.ch.f321ms != 2) {
                    this.ch.ah.rewind();
                    bitmapMs.copyPixelsToBuffer(this.ch.ah);
                }
                this.ch.f321ms = ((ah) xVar).xr;
                canvas2.save();
                if (((ah) xVar).f304ms == 0) {
                    canvas2.clipRect(xVar.ch / this.ah, xVar.hi / this.ah, (xVar.ch + xVar.x) / this.ah, (xVar.hi + xVar.ny) / this.ah);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.ch.xr.set(xVar.ch / this.ah, xVar.hi / this.ah, (xVar.ch + xVar.x) / this.ah, (xVar.hi + xVar.ny) / this.ah);
                canvas2.restore();
            }
            Bitmap bitmapMs2 = ms(xVar.x, xVar.ny);
            ms(xVar.ms(canvas2, this.ny, this.ah, bitmapMs2, d()));
            ms(bitmapMs2);
            this.ka.rewind();
            bitmapMs.copyPixelsToBuffer(this.ka);
            ms(bitmapMs);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }
}
