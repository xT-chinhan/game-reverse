package com.byazt.tiu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 13})
public class hw extends aj<com.byazt.fe.pr, com.byazt.fe.hw> {
    public final Paint aj;
    public com.byazt.fe.hw fw;
    public final pr vk;
    public int zo;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        public ByteBuffer hn;
        public Rect hw;
        public byte pr;

        private pr() {
            this.hw = new Rect();
        }
    }

    public hw(com.byazt.eu.hw hwVar, aj.pr prVar) {
        super(hwVar, prVar);
        Paint paint = new Paint();
        this.aj = paint;
        this.vk = new pr();
        paint.setAntiAlias(true);
    }

    @Override // com.byazt.tiu.aj
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public com.byazt.fe.hw x() {
        if (this.fw == null) {
            this.fw = new com.byazt.fe.hw();
        }
        return this.fw;
    }

    @Override // com.byazt.tiu.aj
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public com.byazt.fe.pr hn(com.byazt.fe.uc ucVar) {
        return new com.byazt.fe.pr(ucVar);
    }

    @Override // com.byazt.tiu.aj
    public int hw() {
        return this.zo;
    }

    @Override // com.byazt.tiu.aj
    public void hn() {
        this.vk.hn = null;
        this.fw = null;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.byazt.tiu.aj
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Rect hw(com.byazt.fe.pr prVar) throws IOException {
        List<c> listPr = x.pr(prVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        hn hnVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (c cVar : listPr) {
            if (cVar instanceof com.byazt.tiu.pr) {
                this.zo = ((com.byazt.tiu.pr) cVar).hn;
                z = true;
            } else if (cVar instanceof uc) {
                hnVar = new hn(prVar, (uc) cVar);
                hnVar.c = arrayList;
                hnVar.hn = bArr;
                this.pr.add(hnVar);
            } else if (cVar instanceof fw) {
                if (hnVar != null) {
                    hnVar.x.add(cVar);
                }
            } else if (cVar instanceof vk) {
                if (!z) {
                    m mVar = new m(prVar);
                    mVar.zo = i;
                    mVar.aj = i2;
                    this.pr.add(mVar);
                    this.zo = 1;
                    break;
                }
                if (hnVar != null) {
                    hnVar.x.add(cVar);
                }
            } else if (cVar instanceof k) {
                k kVar = (k) cVar;
                i = kVar.hw;
                i2 = kVar.hn;
                bArr = kVar.zo;
            } else if (!(cVar instanceof w)) {
                arrayList.add(cVar);
            }
        }
        int i3 = i * i2;
        this.c = ByteBuffer.allocate(((i3 / (this.hn * this.hn)) + 1) * 4);
        this.vk.hn = ByteBuffer.allocate(((i3 / (this.hn * this.hn)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.byazt.tiu.aj
    public void pr(zo<com.byazt.fe.pr, com.byazt.fe.hw> zoVar) {
        Canvas canvas;
        if (zoVar == null || this.uc == null) {
            return;
        }
        try {
            Bitmap bitmapPr = pr(this.uc.width() / this.hn, this.uc.height() / this.hn);
            Canvas canvas2 = this.x.get(bitmapPr);
            if (canvas2 != null) {
                canvas = canvas2;
            } else {
                Canvas canvas3 = new Canvas(bitmapPr);
                this.x.put(bitmapPr, canvas3);
                canvas = canvas3;
            }
            if (zoVar instanceof hn) {
                this.c.rewind();
                bitmapPr.copyPixelsFromBuffer(this.c);
                if (this.hw == 0) {
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas.save();
                    canvas.clipRect(this.vk.hw);
                    switch (this.vk.pr) {
                        case 1:
                            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                            break;
                        case 2:
                            this.vk.hn.rewind();
                            bitmapPr.copyPixelsFromBuffer(this.vk.hn);
                            break;
                    }
                    canvas.restore();
                }
                if (((hn) zoVar).hw == 2 && this.vk.pr != 2) {
                    this.vk.hn.rewind();
                    bitmapPr.copyPixelsToBuffer(this.vk.hn);
                }
                this.vk.pr = ((hn) zoVar).hw;
                canvas.save();
                if (((hn) zoVar).pr == 0) {
                    canvas.clipRect(zoVar.vk / this.hn, zoVar.w / this.hn, (zoVar.vk + zoVar.zo) / this.hn, (zoVar.w + zoVar.aj) / this.hn);
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.vk.hw.set(zoVar.vk / this.hn, zoVar.w / this.hn, (zoVar.vk + zoVar.zo) / this.hn, (zoVar.w + zoVar.aj) / this.hn);
                canvas.restore();
            }
            Bitmap bitmapPr2 = pr(zoVar.zo, zoVar.aj);
            pr(zoVar.pr(canvas, this.aj, this.hn, bitmapPr2, x()));
            pr(bitmapPr2);
            this.c.rewind();
            bitmapPr.copyPixelsToBuffer(this.c);
            pr(bitmapPr);
        } catch (Exception e) {
        }
    }
}
