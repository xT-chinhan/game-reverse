package com.byazt.ep;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.gct.ha;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.stl.GifView;
import com.byazt.tk.k;
import com.byazt.vh.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 5})
public class q implements com.byazt.gu.qg {

    public interface n {
        void n(Drawable drawable);
    }

    @Override // com.byazt.gu.qg
    public void n(final sz szVar, final String str, ImageView imageView, com.byazt.gu.qg.n nVar) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.byazt.imu.s.n(str).s(3).n(Bitmap.Config.RGB_565).n(new m() { // from class: com.byazt.ep.q.1
                @Override // com.byazt.si.m
                public void n(cy cyVar) {
                    try {
                        Object objS = cyVar.s();
                        if (objS instanceof byte[]) {
                            if (cyVar.fs()) {
                                gifView.n((byte[]) objS, false);
                                gifView.setRepeatConfig(true);
                                gifView.qg();
                            } else {
                                gifView.setImageDrawable(com.byazt.imu.n.n((byte[]) objS, 0));
                            }
                        } else if (objS instanceof Bitmap) {
                            gifView.setImageBitmap((Bitmap) objS);
                        }
                        q.this.n(szVar, str, true);
                        com.byazt.gn.n.n();
                    } catch (Throwable th) {
                        n(1002, "", th);
                    }
                }

                @Override // com.byazt.si.m
                public void n(int i, String str2, Throwable th) {
                    q.this.n(szVar, str, false);
                }
            });
            return;
        }
        com.byazt.si.sz szVarN = com.byazt.imu.s.n(str);
        n(szVar, szVarN, str);
        szVarN.n(imageView);
    }

    @Override // com.byazt.gu.qg
    public void n(final sz szVar, final String str, final ImageView imageView, int i, int i2, com.byazt.gu.qg.n nVar) {
        com.byazt.si.sz szVarS = com.byazt.imu.s.n(str).s(3);
        n(szVar, szVarS, str);
        szVarS.n(new m() { // from class: com.byazt.ep.q.2
            @Override // com.byazt.si.m
            public void n(final cy cyVar) {
                if (imageView.isAttachedToWindow()) {
                    q.this.n(cyVar, imageView);
                } else {
                    imageView.post(new Runnable() { // from class: com.byazt.ep.q.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            q.this.n(cyVar, imageView);
                        }
                    });
                }
                q.this.n(szVar, str, true);
            }

            @Override // com.byazt.si.m
            public void n(int i3, String str2, Throwable th) {
                q.this.n(szVar, str, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(cy cyVar, ImageView imageView) {
        try {
            Object objS = cyVar.s();
            if (objS instanceof byte[]) {
                if (cyVar.fs() || qg((byte[]) objS)) {
                    if (Build.VERSION.SDK_INT <= 30) {
                        n((byte[]) objS, imageView);
                    } else {
                        com.byazt.cq.w.n(imageView, (byte[]) objS, imageView.getWidth(), imageView.getHeight());
                    }
                } else if (n((byte[]) objS)) {
                    com.byazt.cq.w.n(imageView, (byte[]) objS, imageView.getWidth(), imageView.getHeight());
                } else {
                    int iN = ha.n(imageView.getWidth(), imageView.getHeight());
                    Bitmap bitmapN = new com.byazt.gms.n(imageView.getWidth(), imageView.getHeight(), imageView.getScaleType(), Bitmap.Config.RGB_565, imageView.getWidth() / iN, imageView.getHeight() / iN).n((byte[]) objS);
                    if (bitmapN != null) {
                        imageView.setImageBitmap(bitmapN);
                    }
                }
            } else if (objS instanceof Bitmap) {
                imageView.setImageBitmap((Bitmap) objS);
            }
            com.byazt.gn.n.n();
        } catch (Throwable th) {
            k.n("ImageLoaderProvider", "Ugen load image failed", th);
        }
    }

    @Override // com.byazt.gu.qg
    public void n(sz szVar, String str, com.byazt.gu.qg.n nVar) {
        qg(szVar, str, nVar);
    }

    private void n(sz szVar, com.byazt.si.sz szVar2, String str) {
        Map<String, Object> mapQg;
        if (szVar == null || (mapQg = szVar.qg()) == null) {
            return;
        }
        Object obj = mapQg.get("image_info");
        if (obj instanceof Map) {
            szVar2.qg((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapQg.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        szVar2.s(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(sz szVar, String str, boolean z) {
        Map<String, Object> mapQg;
        if (szVar == null || TextUtils.isEmpty(str) || (mapQg = szVar.qg()) == null || mapQg.isEmpty()) {
            return;
        }
        Object obj = mapQg.get("ugen_v3_render");
        if (obj instanceof WeakReference) {
            Object obj2 = ((WeakReference) obj).get();
            if (obj2 instanceof com.byazt.gn.fs) {
                try {
                    ((com.byazt.gn.fs) obj2).n(str, z);
                } catch (Throwable th) {
                    k.n("ImageLoaderProvider", "notifyFirstFrameIfMatch error", th);
                }
            }
        }
    }

    public void qg(final sz szVar, final String str, final com.byazt.gu.qg.n nVar) {
        com.byazt.si.sz szVarS = com.byazt.imu.s.n(str).s(1);
        n(szVar, szVarS, str);
        szVarS.n(new m() { // from class: com.byazt.ep.q.3
            @Override // com.byazt.si.m
            public void n(cy cyVar) {
                Runnable runnable;
                try {
                    if (cyVar == null) {
                        com.byazt.gu.qg.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n(null);
                        }
                        q.this.n(szVar, str, true);
                        runnable = new Runnable() { // from class: com.byazt.ep.q.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.byazt.gn.n.n();
                            }
                        };
                    } else {
                        if (nVar != null) {
                            if (cyVar.s() instanceof Bitmap) {
                                nVar.n((Bitmap) cyVar.s());
                            } else if (cyVar.s() instanceof byte[]) {
                                try {
                                    nVar.n(BitmapFactory.decodeByteArray((byte[]) cyVar.s(), 0, ((byte[]) cyVar.s()).length));
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        q.this.n(szVar, str, true);
                        runnable = new Runnable() { // from class: com.byazt.ep.q.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.byazt.gn.n.n();
                            }
                        };
                    }
                    com.byazt.ag.qg.n(runnable);
                } catch (Throwable th) {
                    q.this.n(szVar, str, true);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ep.q.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.gn.n.n();
                        }
                    });
                    throw th;
                }
            }

            @Override // com.byazt.si.m
            public void n(int i, String str2, Throwable th) {
                com.byazt.gu.qg.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(null);
                }
                q.this.n(szVar, str, false);
            }
        });
    }

    private void n(byte[] bArr, final ImageView imageView) {
        try {
            k.qg("ImageLoaderProvider", "load animation image");
            n(bArr, new n() { // from class: com.byazt.ep.q.4
                @Override // com.byazt.ep.q.n
                public void n(final Drawable drawable) {
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ep.q.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28) {
                                Drawable drawable2 = drawable;
                                if (drawable2 instanceof AnimatedImageDrawable) {
                                    ((AnimatedImageDrawable) drawable2).start();
                                }
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception unused) {
        }
    }

    private void n(final byte[] bArr, final n nVar) {
        com.byazt.qit.l.qg(new com.byazt.qit.x("csj_animation_drawable") { // from class: com.byazt.ep.q.5
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableS = q.this.s(bArr);
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(drawableS);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable s(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            boolean zN = com.byazt.byp.qg.n();
            File fileQg = com.byazt.tk.x.qg(com.byazt.nf.rv.getContext(), zN, zN ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileQg);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileQg));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return drawableDecodeDrawable;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(com.byazt.nf.rv.getContext().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                return bitmapDrawable;
            } catch (Throwable th) {
                th = th;
                try {
                    k.n("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    return null;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public boolean n(byte[] bArr) {
        return com.byazt.cq.w.n(bArr, 0);
    }

    public boolean qg(byte[] bArr) {
        return TextUtils.equals("png", com.byazt.tk.cp.n(Arrays.copyOfRange(bArr, 0, com.byazt.tk.cp.n()))) && com.byazt.cq.w.n(bArr);
    }
}
