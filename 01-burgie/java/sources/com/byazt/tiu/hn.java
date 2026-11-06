package com.byazt.tiu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.cc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 20})
public class hn extends zo<com.byazt.fe.pr, com.byazt.fe.hw> {
    public List<c> c;
    public byte[] hn;
    public final byte hw;
    public final byte pr;
    public List<c> x;
    public static final /* synthetic */ boolean uc = true;
    public static final byte[] ho = {-119, 80, 78, 71, cc.k, 10, 26, 10};
    public static final byte[] nt = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    public static final ThreadLocal<CRC32> yb = new ThreadLocal<>();

    private CRC32 pr() {
        ThreadLocal<CRC32> threadLocal = yb;
        CRC32 crc32 = threadLocal.get();
        if (crc32 == null) {
            CRC32 crc33 = new CRC32();
            threadLocal.set(crc33);
            return crc33;
        }
        return crc32;
    }

    public hn(com.byazt.fe.pr prVar, uc ucVar) {
        super(prVar);
        this.x = new ArrayList();
        this.c = new ArrayList();
        this.pr = ucVar.g;
        this.hw = ucVar.m;
        this.k = (ucVar.w * 1000) / (ucVar.k == 0 ? (short) 100 : ucVar.k);
        if (this.k < 10) {
            this.k = 100;
        }
        this.zo = ucVar.hn;
        this.aj = ucVar.zo;
        this.vk = ucVar.aj;
        this.w = ucVar.vk;
    }

    private int pr(com.byazt.fe.hw hwVar) throws IOException {
        Iterator<c> it = this.c.iterator();
        int i = 33;
        while (it.hasNext()) {
            i += it.next().x + 12;
        }
        for (c cVar : this.x) {
            if (cVar instanceof vk) {
                i += cVar.x + 12;
            } else if (cVar instanceof fw) {
                i += cVar.x + 8;
            }
        }
        int length = i + nt.length;
        hwVar.hn(length);
        hwVar.pr(ho);
        hwVar.hw(13);
        int iPr = hwVar.pr();
        hwVar.pr(k.pr);
        hwVar.hw(this.zo);
        hwVar.hw(this.aj);
        hwVar.pr(this.hn);
        CRC32 crc32Pr = pr();
        crc32Pr.reset();
        crc32Pr.update(hwVar.hw(), iPr, 17);
        hwVar.hw((int) crc32Pr.getValue());
        for (c cVar2 : this.c) {
            if (!(cVar2 instanceof w)) {
                ((com.byazt.fe.pr) this.fw).d_();
                ((com.byazt.fe.pr) this.fw).pr(cVar2.fw);
                ((com.byazt.fe.pr) this.fw).pr(hwVar.hw(), hwVar.pr(), cVar2.x + 12);
                hwVar.x(cVar2.x + 12);
            }
        }
        for (c cVar3 : this.x) {
            if (cVar3 instanceof vk) {
                ((com.byazt.fe.pr) this.fw).d_();
                ((com.byazt.fe.pr) this.fw).pr(cVar3.fw);
                ((com.byazt.fe.pr) this.fw).pr(hwVar.hw(), hwVar.pr(), cVar3.x + 12);
                hwVar.x(cVar3.x + 12);
            } else if (cVar3 instanceof fw) {
                hwVar.hw(cVar3.x - 4);
                int iPr2 = hwVar.pr();
                hwVar.pr(vk.pr);
                ((com.byazt.fe.pr) this.fw).d_();
                ((com.byazt.fe.pr) this.fw).pr(cVar3.fw + 4 + 4 + 4);
                ((com.byazt.fe.pr) this.fw).pr(hwVar.hw(), hwVar.pr(), cVar3.x - 4);
                hwVar.x(cVar3.x - 4);
                crc32Pr.reset();
                crc32Pr.update(hwVar.hw(), iPr2, cVar3.x);
                hwVar.hw((int) crc32Pr.getValue());
            }
        }
        hwVar.pr(nt);
        return length;
    }

    @Override // com.byazt.tiu.zo
    public Bitmap pr(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.byazt.fe.hw hwVar) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iPr = pr(hwVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] bArrHw = hwVar.hw();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrHw, 0, iPr, options);
            } catch (IllegalArgumentException e) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrHw, 0, iPr, options2);
            }
            if (!uc && bitmapDecodeByteArray == null) {
                throw new AssertionError();
            }
            this.m.left = 0;
            this.m.top = 0;
            this.m.right = bitmapDecodeByteArray.getWidth();
            this.m.bottom = bitmapDecodeByteArray.getHeight();
            float f = i;
            this.g.left = (int) (this.vk / f);
            this.g.top = (int) (this.w / f);
            this.g.right = (int) ((this.vk / f) + bitmapDecodeByteArray.getWidth());
            this.g.bottom = (int) ((this.w / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.m, this.g, paint);
            return bitmapDecodeByteArray;
        } catch (IOException e2) {
            return null;
        }
    }
}
