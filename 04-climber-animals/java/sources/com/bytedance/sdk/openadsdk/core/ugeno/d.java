package com.bytedance.sdk.openadsdk.core.ugeno;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.ah.hi;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.jw.h;
import com.bytedance.sdk.openadsdk.core.nw.sk;
import com.bytedance.sdk.openadsdk.core.re;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.adsdk.ugeno.ms {

    public interface ms {
        void ms(Drawable drawable);
    }

    @Override // com.bytedance.adsdk.ugeno.ms
    public void ms(hi hiVar, String str, ImageView imageView) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.bytedance.sdk.openadsdk.x.xr.ms(str).ah(3).ms(Bitmap.Config.RGB_565).ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.1
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str2, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(com.bytedance.sdk.component.c.hi hiVar2) {
                    try {
                        Object objAh = hiVar2.ah();
                        if (objAh instanceof byte[]) {
                            if (hiVar2.x()) {
                                gifView.ms((byte[]) objAh, false);
                                gifView.setRepeatConfig(true);
                                gifView.xr();
                                return;
                            } else {
                                gifView.setImageDrawable(h.ms((byte[]) objAh, 0));
                                return;
                            }
                        }
                        if (objAh instanceof Bitmap) {
                            gifView.setImageBitmap((Bitmap) objAh);
                        }
                    } catch (Throwable th) {
                        ms(1002, "", th);
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.component.c.ch chVarMs = com.bytedance.sdk.openadsdk.x.xr.ms(str);
        ms(hiVar, chVarMs, str);
        chVarMs.ms(imageView);
    }

    @Override // com.bytedance.adsdk.ugeno.ms
    public void ms(hi hiVar, String str, final ImageView imageView, int i, int i2) {
        com.bytedance.sdk.component.c.ch chVarAh = com.bytedance.sdk.openadsdk.x.xr.ms(str).ah(3);
        ms(hiVar, chVarAh, str);
        chVarAh.ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.2
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i3, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(final com.bytedance.sdk.component.c.hi hiVar2) {
                if (imageView.isAttachedToWindow()) {
                    d.this.ms(hiVar2, imageView);
                } else {
                    imageView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.ms(hiVar2, imageView);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.component.c.hi hiVar, ImageView imageView) {
        Object objAh = hiVar.ah();
        if (objAh instanceof byte[]) {
            if (!hiVar.x()) {
                byte[] bArr = (byte[]) objAh;
                if (!xr(bArr)) {
                    if (ms(bArr)) {
                        com.bytedance.sdk.component.adexpress.d.c.ms(imageView, bArr, imageView.getWidth(), imageView.getHeight());
                        return;
                    }
                    int iMs = sk.ms(imageView.getWidth(), imageView.getHeight());
                    Bitmap bitmapMs = new com.bytedance.sdk.component.c.ah.xr.ms(imageView.getWidth(), imageView.getHeight(), imageView.getScaleType(), Bitmap.Config.RGB_565, imageView.getWidth() / iMs, imageView.getHeight() / iMs).ms(bArr);
                    if (bitmapMs != null) {
                        imageView.setImageBitmap(bitmapMs);
                        return;
                    }
                    return;
                }
            }
            if (Build.VERSION.SDK_INT <= 30) {
                ms((byte[]) objAh, imageView);
                return;
            } else {
                com.bytedance.sdk.component.adexpress.d.c.ms(imageView, (byte[]) objAh, imageView.getWidth(), imageView.getHeight());
                return;
            }
        }
        if (objAh instanceof Bitmap) {
            imageView.setImageBitmap((Bitmap) objAh);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms
    public void ms(hi hiVar, String str, com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms interfaceC0196ms) {
        xr(hiVar, str, interfaceC0196ms);
    }

    private void ms(hi hiVar, com.bytedance.sdk.component.c.ch chVar, String str) {
        Map<String, Object> mapXr;
        if (hiVar == null || (mapXr = hiVar.xr()) == null) {
            return;
        }
        Object obj = mapXr.get("image_info");
        if (obj instanceof Map) {
            chVar.xr((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapXr.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        chVar.ah(str2);
    }

    public void xr(hi hiVar, String str, final com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms interfaceC0196ms) {
        com.bytedance.sdk.component.c.ch chVarAh = com.bytedance.sdk.openadsdk.x.xr.ms(str).ah(1);
        ms(hiVar, chVarAh, str);
        chVarAh.ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.3
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(com.bytedance.sdk.component.c.hi hiVar2) {
                if (hiVar2 == null) {
                    interfaceC0196ms.ms(null);
                    return;
                }
                com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms interfaceC0196ms2 = interfaceC0196ms;
                if (interfaceC0196ms2 != null) {
                    if (hiVar2.ah() instanceof Bitmap) {
                        interfaceC0196ms.ms((Bitmap) hiVar2.ah());
                        return;
                    } else {
                        if (hiVar2.ah() instanceof byte[]) {
                            try {
                                interfaceC0196ms.ms(BitmapFactory.decodeByteArray((byte[]) hiVar2.ah(), 0, ((byte[]) hiVar2.ah()).length));
                                return;
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                        return;
                    }
                }
                interfaceC0196ms2.ms(null);
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i, String str2, Throwable th) {
                com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms interfaceC0196ms2 = interfaceC0196ms;
                if (interfaceC0196ms2 != null) {
                    interfaceC0196ms2.ms(null);
                }
            }
        });
    }

    private void ms(byte[] bArr, final ImageView imageView) {
        try {
            sl.d("ImageLoaderProvider", "load animation image");
            ms(bArr, new ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.4
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
                public void ms(final Drawable drawable) {
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.4.1
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
            sl.ms(e);
        }
    }

    private void ms(final byte[] bArr, final ms msVar) {
        com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("csj_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.5
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableAh = d.this.ah(bArr);
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms(drawableAh);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable ah(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            boolean zAh = com.bytedance.sdk.openadsdk.core.multipro.xr.ah();
            File fileXr = com.bytedance.sdk.component.utils.c.xr(re.getContext(), zAh, zAh ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileXr);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileXr));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return drawableDecodeDrawable;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(re.getContext().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                return bitmapDrawable;
            } catch (Throwable th) {
                th = th;
                try {
                    sl.ah("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
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

    public boolean ms(byte[] bArr) {
        return com.bytedance.sdk.component.adexpress.d.c.ms(bArr, 0);
    }

    public boolean xr(byte[] bArr) {
        return TextUtils.equals("png", com.bytedance.sdk.component.utils.ny.ms(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.ny.ms()))) && com.bytedance.sdk.component.adexpress.d.c.ms(bArr);
    }
}
