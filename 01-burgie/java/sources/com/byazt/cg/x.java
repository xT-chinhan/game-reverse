package com.byazt.cg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 121})
public class x extends hn {
    public final RectF aj;
    public com.byazt.al.pr<Float, Float> fw;
    public boolean k;
    public final RectF vk;
    public final Paint w;
    public final List<hn> zo;

    public x(com.byazt.dx.zo zoVar, zo zoVar2, List<zo> list, com.byazt.dx.uc ucVar, Context context) {
        hn hnVar;
        zo.hw hwVarK;
        super(zoVar, zoVar2);
        this.zo = new ArrayList();
        this.aj = new RectF();
        this.vk = new RectF();
        this.w = new Paint();
        this.k = true;
        com.byazt.eqw.hw hwVarCz = zoVar2.cz();
        if (hwVarCz != null) {
            com.byazt.al.pr<Float, Float> prVarPr = hwVarCz.pr();
            this.fw = prVarPr;
            pr(prVarPr);
            this.fw.pr(this);
        } else {
            this.fw = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(ucVar.g().size());
        int size = list.size() - 1;
        hn hnVar2 = null;
        while (true) {
            if (size >= 0) {
                zo zoVar3 = list.get(size);
                hn hnVarPr = hn.pr(this, zoVar3, zoVar, ucVar, context);
                if (hnVarPr != null) {
                    longSparseArray.put(hnVarPr.x().c(), hnVarPr);
                    if (hnVar2 != null) {
                        hnVar2.pr(hnVarPr);
                        hnVar2 = null;
                    } else {
                        this.zo.add(0, hnVarPr);
                        if (zoVar3 != null && (hwVarK = zoVar3.k()) != null) {
                            switch (AnonymousClass1.pr[hwVarK.ordinal()]) {
                                case 1:
                                case 2:
                                    hnVar2 = hnVarPr;
                                    break;
                            }
                        }
                    }
                }
                size--;
            } else {
                for (int i = 0; i < longSparseArray.size(); i++) {
                    hn hnVar3 = (hn) longSparseArray.get(longSparseArray.keyAt(i));
                    if (hnVar3 != null && (hnVar = (hn) longSparseArray.get(hnVar3.x().m())) != null) {
                        hnVar3.hw(hnVar);
                    }
                }
                return;
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.cg.x$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[zo.hw.values().length];
            pr = iArr;
            try {
                iArr[zo.hw.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[zo.hw.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public void hw(boolean z) {
        this.k = z;
    }

    @Override // com.byazt.cg.hn
    public void pr(boolean z) {
        super.pr(z);
        Iterator<hn> it = this.zo.iterator();
        while (it.hasNext()) {
            it.next().pr(z);
        }
    }

    @Override // com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        boolean zClipRect;
        super.hw(canvas, matrix, i);
        com.byazt.dx.c.pr("CompositionLayer#draw");
        this.vk.set(0.0f, 0.0f, this.hn.zo(), this.hn.aj());
        matrix.mapRect(this.vk);
        boolean z = this.hw.vk() && this.zo.size() > 1 && i != 255;
        if (z) {
            this.w.setAlpha(i);
            com.byazt.ptr.vk.pr(canvas, this.vk, this.w);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.zo.size() - 1; size >= 0; size--) {
            if (!(!this.k && "__container".equals(this.hn.uc())) && !this.vk.isEmpty()) {
                zClipRect = canvas.clipRect(this.vk);
            } else {
                zClipRect = true;
            }
            if (zClipRect) {
                this.zo.get(size).pr(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.byazt.dx.c.hw("CompositionLayer#draw");
    }

    @Override // com.byazt.cg.hn, com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        super.pr(rectF, matrix, z);
        for (int size = this.zo.size() - 1; size >= 0; size--) {
            this.aj.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.zo.get(size).pr(this.aj, this.pr, true);
            rectF.union(this.aj);
        }
    }

    public List<hn> g() {
        return this.zo;
    }

    @Override // com.byazt.cg.hn
    public void pr(float f) {
        super.pr(f);
        if (this.fw != null) {
            f = ((this.fw.fw().floatValue() * this.hn.pr().m()) - this.hn.pr().uc()) / (this.hw.iu().lb() + 0.01f);
        }
        if (this.fw == null) {
            f -= this.hn.hn();
        }
        if (this.hn.hw() != 0.0f && !"__container".equals(this.hn.uc())) {
            f /= this.hn.hw();
        }
        for (int size = this.zo.size() - 1; size >= 0; size--) {
            this.zo.get(size).pr(f);
        }
    }
}
