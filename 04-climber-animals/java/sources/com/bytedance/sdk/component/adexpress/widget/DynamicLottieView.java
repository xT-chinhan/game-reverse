package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.ah;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.ny;
import com.bytedance.adsdk.lottie.t;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.c.x;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLottieView extends LottieAnimationView {
    private int ab;
    private boolean ah;
    private int c;
    private boolean d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<String, Bitmap> f922ms;
    private Map<String, String> x;
    private String xr;

    public void setLottieAppNameMaxLength(int i) {
        this.ka = i;
    }

    public void setLottieAdTitleMaxLength(int i) {
        this.c = i;
    }

    public void setLottieAdDescMaxLength(int i) {
        this.ab = i;
    }

    public DynamicLottieView(Context context) {
        super(context);
        this.f922ms = new HashMap();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ny();
    }

    public void setImageLottieTosPath(String str) {
        this.xr = str;
    }

    public void setAnimationsLoop(boolean z) {
        this.ah = z;
    }

    public void setOnlyLoadNetImage(boolean z) {
        this.d = z;
    }

    public void setData(Map<String, String> map) {
        this.x = map;
    }

    public void ny() {
        if (TextUtils.isEmpty(this.xr)) {
            return;
        }
        setProgress(0.0f);
        ms(this.ah);
        if (this.d) {
            hi();
        } else {
            ch();
        }
    }

    private void ch() {
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.xr + ".json");
        setImageAssetDelegate(new d() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1
            @Override // com.bytedance.adsdk.lottie.d
            public Bitmap ms(final ny nyVar) {
                final String strSl = nyVar.sl();
                strSl.hashCode();
                switch (strSl) {
                    case "{appIcon}":
                        if (DynamicLottieView.this.x != null) {
                            strSl = (String) DynamicLottieView.this.x.get("icon");
                            break;
                        }
                        break;
                    case "{adImage}":
                    case "{slot}":
                        if (DynamicLottieView.this.x != null) {
                            strSl = (String) DynamicLottieView.this.x.get("imageUrl");
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.f922ms.get(strSl);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ka().ms(strSl).ah(2).ms(new x() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.2
                    @Override // com.bytedance.sdk.component.c.x
                    @ATSMethod(1)
                    public Bitmap ms(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, nyVar.ms(), nyVar.xr(), false);
                        DynamicLottieView.this.f922ms.put(strSl, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                }).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.1
                    @Override // com.bytedance.sdk.component.c.ao
                    @ATSMethod(2)
                    public void ms(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.c.ao
                    @ATSMethod(1)
                    public void ms(hi<Bitmap> hiVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(hiVar.ah(), nyVar.ms(), nyVar.xr(), false);
                        DynamicLottieView.this.f922ms.put(strSl, bitmapCreateScaledBitmap);
                        DynamicLottieView.this.ms(nyVar.hi(), bitmapCreateScaledBitmap);
                    }
                });
                return (Bitmap) DynamicLottieView.this.f922ms.get(strSl);
            }
        });
        if (this.x != null) {
            t tVar = new t(this);
            String str = this.x.get("app_name");
            String str2 = this.x.get(BundleKey.DESCRIPTION);
            String str3 = this.x.get("title");
            if (this.ka > 0 && str.length() > this.ka) {
                str = str.substring(0, this.ka - 1) + "...";
            } else if (this.ka <= 0) {
                str = "";
            }
            if (this.c > 0 && str3.length() > this.c) {
                str3 = str3.substring(0, this.c - 1) + "...";
            } else if (this.ka <= 0) {
                str3 = "";
            }
            if (this.ab > 0 && str2.length() > this.ab) {
                str2 = str2.substring(0, this.ab - 1) + "...";
            } else if (this.ka <= 0) {
                str2 = "";
            }
            tVar.xr("{appName}", str);
            tVar.xr("{adTitle}", str3);
            tVar.xr("{adDesc}", str2);
            setTextDelegate(tVar);
            setFontAssetDelegate(new ah() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.2
                @Override // com.bytedance.adsdk.lottie.ah
                public String xr(String str4) {
                    return null;
                }

                @Override // com.bytedance.adsdk.lottie.ah
                public Typeface ms(String str4) {
                    return Typeface.MONOSPACE;
                }
            });
        }
        ms();
    }

    private void hi() {
        setAnimationFromUrl(this.xr);
        setImageAssetDelegate(new d() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3
            @Override // com.bytedance.adsdk.lottie.d
            public Bitmap ms(final ny nyVar) {
                if (nyVar == null) {
                    return null;
                }
                final String strZb = nyVar.zb();
                String strSl = nyVar.sl();
                if (TextUtils.isEmpty(strZb) || !TextUtils.isEmpty(strSl)) {
                    if (TextUtils.isEmpty(strSl) || !TextUtils.isEmpty(strZb)) {
                        strZb = (TextUtils.isEmpty(strSl) || TextUtils.isEmpty(strZb)) ? "" : strZb + strSl;
                    } else {
                        strZb = strSl;
                    }
                }
                if (TextUtils.isEmpty(strZb)) {
                    return null;
                }
                Bitmap bitmap = DynamicLottieView.this.f922ms == null ? null : (Bitmap) DynamicLottieView.this.f922ms.get(strZb);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ka().ms(strZb).ms(new x() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.2
                    @Override // com.bytedance.sdk.component.c.x
                    @ATSMethod(1)
                    public Bitmap ms(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, nyVar.ms(), nyVar.xr(), false);
                        if (DynamicLottieView.this.f922ms != null) {
                            DynamicLottieView.this.f922ms.put(strZb, bitmapCreateScaledBitmap);
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.1
                    @Override // com.bytedance.sdk.component.c.ao
                    @ATSMethod(2)
                    public void ms(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.c.ao
                    @ATSMethod(1)
                    public void ms(hi<Bitmap> hiVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(hiVar.ah(), nyVar.ms(), nyVar.xr(), false);
                        if (DynamicLottieView.this.f922ms != null) {
                            DynamicLottieView.this.f922ms.put(strZb, bitmapCreateScaledBitmap);
                        }
                        DynamicLottieView.this.ms(nyVar.hi(), bitmapCreateScaledBitmap);
                    }
                });
                if (DynamicLottieView.this.f922ms == null) {
                    return null;
                }
                return (Bitmap) DynamicLottieView.this.f922ms.get(strZb);
            }
        });
        ms();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }
}
