package com.byazt.jt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.byazt.dx.LottieAnimationView;
import com.byazt.dx.aj;
import com.byazt.dx.cz;
import com.byazt.dx.hn;
import com.byazt.dx.x;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.ld.vk;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 2092})
public class DynamicLottieView extends LottieAnimationView {
    public int c;
    public int fw;
    public boolean hn;
    public String hw;
    public Map<String, Bitmap> pr;
    public int uc;
    public boolean x;
    public Map<String, String> zo;

    public void setLottieAppNameMaxLength(int i) {
        this.c = i;
    }

    public void setLottieAdTitleMaxLength(int i) {
        this.uc = i;
    }

    public void setLottieAdDescMaxLength(int i) {
        this.fw = i;
    }

    public DynamicLottieView(Context context) {
        super(context);
        this.pr = new HashMap();
    }

    @Override // com.byazt.dx.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        zo();
    }

    public void setImageLottieTosPath(String str) {
        this.hw = str;
    }

    public void setAnimationsLoop(boolean z) {
        this.hn = z;
    }

    public void setOnlyLoadNetImage(boolean z) {
        this.x = z;
    }

    public void setData(Map<String, String> map) {
        this.zo = map;
    }

    public void zo() {
        if (TextUtils.isEmpty(this.hw)) {
            return;
        }
        setProgress(0.0f);
        pr(this.hn);
        if (this.x) {
            vk();
        } else {
            aj();
        }
    }

    private void aj() {
        setImageAssetDelegate(new x() { // from class: com.byazt.jt.DynamicLottieView.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code duplicated, block: B:14:0x002b  */
            @Override // com.byazt.dx.x
            public Bitmap pr(final aj ajVar) {
                final String strM = ajVar.m();
                switch (strM) {
                    case "{slot}":
                    case "{adImage}":
                        if (DynamicLottieView.this.zo != null) {
                            strM = (String) DynamicLottieView.this.zo.get("imageUrl");
                            break;
                        }
                        break;
                    case "{appIcon}":
                        if (DynamicLottieView.this.zo != null) {
                            strM = (String) DynamicLottieView.this.zo.get("icon");
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.pr.get(strM);
                if (bitmap != null) {
                    return bitmap;
                }
                com.byazt.bg.pr.pr().c().pr(strM).hn(2).pr(new vk() { // from class: com.byazt.jt.DynamicLottieView.1.2
                    @Override // com.byazt.ld.vk
                    public Bitmap pr(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, ajVar.pr(), ajVar.hw(), false);
                        DynamicLottieView.this.pr.put(strM, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                }).pr(new rc<Bitmap>() { // from class: com.byazt.jt.DynamicLottieView.1.1
                    @Override // com.byazt.ld.rc
                    public void pr(nt<Bitmap> ntVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(ntVar.hn(), ajVar.pr(), ajVar.hw(), false);
                        DynamicLottieView.this.pr.put(strM, bitmapCreateScaledBitmap);
                        DynamicLottieView.this.pr(ajVar.k(), bitmapCreateScaledBitmap);
                    }

                    @Override // com.byazt.ld.rc
                    public void pr(int i, String str, Throwable th) {
                    }
                });
                return (Bitmap) DynamicLottieView.this.pr.get(strM);
            }
        });
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.hw + ".json");
        if (this.zo != null) {
            cz czVar = new cz(this);
            String str = this.zo.get(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
            String str2 = this.zo.get(BundleKey.DESCRIPTION);
            String str3 = this.zo.get(BundleKey.TITLE);
            if (this.c > 0 && str.length() > this.c) {
                str = str.substring(0, this.c - 1) + "...";
            } else if (this.c <= 0) {
                str = "";
            }
            if (this.uc > 0 && str3.length() > this.uc) {
                str3 = str3.substring(0, this.uc - 1) + "...";
            } else if (this.c <= 0) {
                str3 = "";
            }
            if (this.fw > 0 && str2.length() > this.fw) {
                str2 = str2.substring(0, this.fw - 1) + "...";
            } else if (this.c <= 0) {
                str2 = "";
            }
            czVar.hw("{appName}", str);
            czVar.hw("{adTitle}", str3);
            czVar.hw("{adDesc}", str2);
            setTextDelegate(czVar);
            setFontAssetDelegate(new hn() { // from class: com.byazt.jt.DynamicLottieView.2
                @Override // com.byazt.dx.hn
                public Typeface pr(String str4) {
                    return Typeface.MONOSPACE;
                }

                @Override // com.byazt.dx.hn
                public String hw(String str4) {
                    return null;
                }
            });
        }
        pr();
    }

    private void vk() {
        setImageAssetDelegate(new x() { // from class: com.byazt.jt.DynamicLottieView.3
            @Override // com.byazt.dx.x
            public Bitmap pr(final aj ajVar) {
                Bitmap bitmap;
                if (ajVar == null) {
                    return null;
                }
                final String strG = ajVar.g();
                String strM = ajVar.m();
                if (TextUtils.isEmpty(strG) || !TextUtils.isEmpty(strM)) {
                    if (!TextUtils.isEmpty(strM) && TextUtils.isEmpty(strG)) {
                        strG = strM;
                    } else if (!TextUtils.isEmpty(strM) && !TextUtils.isEmpty(strG)) {
                        strG = strG + strM;
                    } else {
                        strG = "";
                    }
                }
                if (!TextUtils.isEmpty(strG)) {
                    if (DynamicLottieView.this.pr != null) {
                        bitmap = (Bitmap) DynamicLottieView.this.pr.get(strG);
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null) {
                        return bitmap;
                    }
                    com.byazt.bg.pr.pr().c().pr(strG).pr(new vk() { // from class: com.byazt.jt.DynamicLottieView.3.2
                        @Override // com.byazt.ld.vk
                        public Bitmap pr(Bitmap bitmap2) {
                            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, ajVar.pr(), ajVar.hw(), false);
                            if (DynamicLottieView.this.pr != null) {
                                DynamicLottieView.this.pr.put(strG, bitmapCreateScaledBitmap);
                            }
                            return bitmapCreateScaledBitmap;
                        }
                    }).pr(new rc<Bitmap>() { // from class: com.byazt.jt.DynamicLottieView.3.1
                        @Override // com.byazt.ld.rc
                        public void pr(nt<Bitmap> ntVar) {
                            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(ntVar.hn(), ajVar.pr(), ajVar.hw(), false);
                            if (DynamicLottieView.this.pr != null) {
                                DynamicLottieView.this.pr.put(strG, bitmapCreateScaledBitmap);
                            }
                            DynamicLottieView.this.pr(ajVar.k(), bitmapCreateScaledBitmap);
                        }

                        @Override // com.byazt.ld.rc
                        public void pr(int i, String str, Throwable th) {
                        }
                    });
                    if (DynamicLottieView.this.pr != null) {
                        return (Bitmap) DynamicLottieView.this.pr.get(strG);
                    }
                    return null;
                }
                return null;
            }
        });
        setAnimationFromUrl(this.hw);
        pr();
    }

    @Override // com.byazt.dx.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uc();
    }
}
