package com.byazt.ea;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.ca.ho;
import com.byazt.ch.g;
import com.byazt.hg.qo;
import com.byazt.jt.GifView;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.sd.a;
import com.byazt.wt.yb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 121})
public class x implements com.byazt.llk.hw {

    public interface pr {
        void pr(Drawable drawable);
    }

    @Override // com.byazt.llk.hw
    public void pr(final g gVar, final String str, ImageView imageView, com.byazt.llk.hw.pr prVar) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.byazt.ub.hw.pr(str).hn(3).pr(Bitmap.Config.RGB_565).pr(new rc() { // from class: com.byazt.ea.x.1
                @Override // com.byazt.ld.rc
                public void pr(nt ntVar) {
                    try {
                        Object objHn = ntVar.hn();
                        if (objHn instanceof byte[]) {
                            if (ntVar.zo()) {
                                gifView.pr((byte[]) objHn, false);
                                gifView.setRepeatConfig(true);
                                gifView.hw();
                            } else {
                                gifView.setImageDrawable(yb.pr((byte[]) objHn, 0));
                            }
                        } else if (objHn instanceof Bitmap) {
                            gifView.setImageBitmap((Bitmap) objHn);
                        }
                        x.this.pr(gVar, str, true);
                    } catch (Throwable th) {
                        pr(1002, "", th);
                    }
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str2, Throwable th) {
                    x.this.pr(gVar, str, false);
                }
            });
            return;
        }
        com.byazt.ld.g gVarPr = com.byazt.ub.hw.pr(str);
        pr(gVar, gVarPr, str);
        gVarPr.pr(imageView);
    }

    @Override // com.byazt.llk.hw
    public void pr(final g gVar, final String str, final ImageView imageView, int i, int i2, com.byazt.llk.hw.pr prVar) {
        com.byazt.ld.g gVarHn = com.byazt.ub.hw.pr(str).hn(3);
        pr(gVar, gVarHn, str);
        gVarHn.pr(new rc() { // from class: com.byazt.ea.x.2
            @Override // com.byazt.ld.rc
            public void pr(final nt ntVar) {
                if (imageView.isAttachedToWindow()) {
                    x.this.pr(ntVar, imageView);
                } else {
                    imageView.post(new Runnable() { // from class: com.byazt.ea.x.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            x.this.pr(ntVar, imageView);
                        }
                    });
                }
                x.this.pr(gVar, str, true);
            }

            @Override // com.byazt.ld.rc
            public void pr(int i3, String str2, Throwable th) {
                x.this.pr(gVar, str, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(nt ntVar, ImageView imageView) {
        try {
            Object objHn = ntVar.hn();
            if (objHn instanceof byte[]) {
                if (!ntVar.zo() && !hw((byte[]) objHn)) {
                    if (pr((byte[]) objHn)) {
                        com.byazt.js.uc.pr(imageView, (byte[]) objHn, imageView.getWidth(), imageView.getHeight());
                        return;
                    }
                    int iPr = qo.pr(imageView.getWidth(), imageView.getHeight());
                    Bitmap bitmapPr = new com.byazt.qnt.pr(imageView.getWidth(), imageView.getHeight(), imageView.getScaleType(), Bitmap.Config.RGB_565, imageView.getWidth() / iPr, imageView.getHeight() / iPr).pr((byte[]) objHn);
                    if (bitmapPr != null) {
                        imageView.setImageBitmap(bitmapPr);
                        return;
                    }
                    return;
                }
                if (Build.VERSION.SDK_INT <= 30) {
                    pr((byte[]) objHn, imageView);
                    return;
                } else {
                    com.byazt.js.uc.pr(imageView, (byte[]) objHn, imageView.getWidth(), imageView.getHeight());
                    return;
                }
            }
            if (objHn instanceof Bitmap) {
                imageView.setImageBitmap((Bitmap) objHn);
            }
        } catch (Throwable th) {
            ho.pr("ImageLoaderProvider", "Ugen load image failed", th);
        }
    }

    @Override // com.byazt.llk.hw
    public void pr(g gVar, String str, com.byazt.llk.hw.pr prVar) {
        hw(gVar, str, prVar);
    }

    private void pr(g gVar, com.byazt.ld.g gVar2, String str) {
        Map<String, Object> mapHw;
        if (gVar != null && (mapHw = gVar.hw()) != null) {
            Object obj = mapHw.get("image_info");
            if (obj instanceof Map) {
                gVar2.hw((String) ((Map) obj).get(str));
            }
            String str2 = (String) mapHw.get("cache_dir");
            if (!TextUtils.isEmpty(str2)) {
                gVar2.hn(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(g gVar, String str, boolean z) {
        Map<String, Object> mapHw;
        if (gVar == null || TextUtils.isEmpty(str) || (mapHw = gVar.hw()) == null || mapHw.isEmpty()) {
            return;
        }
        Object obj = mapHw.get("ugen_v3_render");
        if (!(obj instanceof WeakReference)) {
            return;
        }
        Object obj2 = ((WeakReference) obj).get();
        if (!(obj2 instanceof com.byazt.gu.fw)) {
            return;
        }
        try {
            ((com.byazt.gu.fw) obj2).pr(str, z);
        } catch (Throwable th) {
            ho.pr("ImageLoaderProvider", "notifyFirstFrameIfMatch error", th);
        }
    }

    public void hw(final g gVar, final String str, final com.byazt.llk.hw.pr prVar) {
        com.byazt.ld.g gVarHn = com.byazt.ub.hw.pr(str).hn(1);
        pr(gVar, gVarHn, str);
        gVarHn.pr(new rc() { // from class: com.byazt.ea.x.3
            @Override // com.byazt.ld.rc
            public void pr(nt ntVar) {
                try {
                    if (ntVar == null) {
                        com.byazt.llk.hw.pr prVar2 = prVar;
                        if (prVar2 != null) {
                            prVar2.pr(null);
                        }
                        x.this.pr(gVar, str, true);
                        return;
                    }
                    if (prVar != null) {
                        if (ntVar.hn() instanceof Bitmap) {
                            prVar.pr((Bitmap) ntVar.hn());
                        } else if (ntVar.hn() instanceof byte[]) {
                            try {
                                prVar.pr(BitmapFactory.decodeByteArray((byte[]) ntVar.hn(), 0, ((byte[]) ntVar.hn()).length));
                            } catch (Throwable th) {
                            }
                        }
                    }
                    x.this.pr(gVar, str, true);
                } catch (Throwable th2) {
                    x.this.pr(gVar, str, true);
                    throw th2;
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i, String str2, Throwable th) {
                com.byazt.llk.hw.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(null);
                }
                x.this.pr(gVar, str, false);
            }
        });
    }

    private void pr(byte[] bArr, final ImageView imageView) {
        try {
            ho.hw("ImageLoaderProvider", "load animation image");
            pr(bArr, new pr() { // from class: com.byazt.ea.x.4
                @Override // com.byazt.ea.x.pr
                public void pr(final Drawable drawable) {
                    com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.ea.x.4.1
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
        } catch (Exception e) {
        }
    }

    private void pr(final byte[] bArr, final pr prVar) {
        com.byazt.xlm.c.hw(new com.byazt.xlm.fw("csj_animation_drawable") { // from class: com.byazt.ea.x.5
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableHn = x.this.hn(bArr);
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(drawableHn);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable hn(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            boolean zPr = com.byazt.iy.hw.pr();
            File fileHw = com.byazt.ca.fw.hw(a.getContext(), zPr, zPr ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileHw);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileHw));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th) {
                    }
                    return drawableDecodeDrawable;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(a.getContext().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                }
                return bitmapDrawable;
            } catch (Throwable th3) {
                th = th3;
                try {
                    ho.pr("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    return null;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    public boolean pr(byte[] bArr) {
        return com.byazt.js.uc.pr(bArr, 0);
    }

    public boolean hw(byte[] bArr) {
        return TextUtils.equals("png", com.byazt.ca.w.pr(Arrays.copyOfRange(bArr, 0, com.byazt.ca.w.pr()))) && com.byazt.js.uc.pr(bArr);
    }
}
