package com.byazt.stl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.py;
import com.byazt.pp.q;
import com.byazt.pp.rv;
import com.byazt.pp.s;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.si.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compilance.constants.BundleKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2317})
public class DynamicLottieView extends LottieAnimationView {
    public Map<String, String> fs;
    public int l;
    public Map<String, Bitmap> n;
    public boolean q;
    public String qg;
    public boolean s;
    public int w;
    public int x;

    public void setLottieAppNameMaxLength(int i) {
        this.l = i;
    }

    public void setLottieAdTitleMaxLength(int i) {
        this.w = i;
    }

    public void setLottieAdDescMaxLength(int i) {
        this.x = i;
    }

    public DynamicLottieView(Context context) {
        super(context);
        this.n = new HashMap();
    }

    @Override // com.byazt.pp.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fs();
    }

    public void setImageLottieTosPath(String str) {
        this.qg = str;
    }

    public void setAnimationsLoop(boolean z) {
        this.s = z;
    }

    public void setOnlyLoadNetImage(boolean z) {
        this.q = z;
    }

    public void setData(Map<String, String> map) {
        this.fs = map;
    }

    public void fs() {
        if (TextUtils.isEmpty(this.qg)) {
            return;
        }
        setProgress(0.0f);
        n(this.s);
        if (this.q) {
            tj();
        } else {
            rv();
        }
    }

    private void rv() {
        setImageAssetDelegate(new q() { // from class: com.byazt.stl.DynamicLottieView.1
            @Override // com.byazt.pp.q
            public Bitmap n(final rv rvVar) {
                final String strOa = rvVar.oa();
                strOa.hashCode();
                switch (strOa) {
                    case "{appIcon}":
                        if (DynamicLottieView.this.fs != null) {
                            strOa = (String) DynamicLottieView.this.fs.get("icon");
                            break;
                        }
                        break;
                    case "{adImage}":
                    case "{slot}":
                        if (DynamicLottieView.this.fs != null) {
                            strOa = (String) DynamicLottieView.this.fs.get("imageUrl");
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.n.get(strOa);
                if (bitmap != null) {
                    return bitmap;
                }
                com.byazt.gkj.n.n().l().n(strOa).s(2).n(new tj() { // from class: com.byazt.stl.DynamicLottieView.1.2
                    @Override // com.byazt.si.tj
                    public Bitmap n(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, rvVar.n(), rvVar.qg(), false);
                        DynamicLottieView.this.n.put(strOa, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                }).n(new m<Bitmap>() { // from class: com.byazt.stl.DynamicLottieView.1.1
                    @Override // com.byazt.si.m
                    public void n(int i, String str, Throwable th) {
                    }

                    @Override // com.byazt.si.m
                    public void n(cy<Bitmap> cyVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(cyVar.s(), rvVar.n(), rvVar.qg(), false);
                        DynamicLottieView.this.n.put(strOa, bitmapCreateScaledBitmap);
                        DynamicLottieView.this.n(rvVar.d(), bitmapCreateScaledBitmap);
                    }
                });
                return (Bitmap) DynamicLottieView.this.n.get(strOa);
            }
        });
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.qg + ".json");
        if (this.fs != null) {
            py pyVar = new py(this);
            String str = this.fs.get("app_name");
            String str2 = this.fs.get(BundleKey.DESCRIPTION);
            String str3 = this.fs.get("title");
            if (this.l > 0 && str.length() > this.l) {
                str = str.substring(0, this.l - 1) + "...";
            } else if (this.l <= 0) {
                str = "";
            }
            if (this.w > 0 && str3.length() > this.w) {
                str3 = str3.substring(0, this.w - 1) + "...";
            } else if (this.l <= 0) {
                str3 = "";
            }
            if (this.x > 0 && str2.length() > this.x) {
                str2 = str2.substring(0, this.x - 1) + "...";
            } else if (this.l <= 0) {
                str2 = "";
            }
            pyVar.qg("{appName}", str);
            pyVar.qg("{adTitle}", str3);
            pyVar.qg("{adDesc}", str2);
            setTextDelegate(pyVar);
            setFontAssetDelegate(new s() { // from class: com.byazt.stl.DynamicLottieView.2
                @Override // com.byazt.pp.s
                public String qg(String str4) {
                    return null;
                }

                @Override // com.byazt.pp.s
                public Typeface n(String str4) {
                    return Typeface.MONOSPACE;
                }
            });
        }
        n();
    }

    private void tj() {
        setImageAssetDelegate(new q() { // from class: com.byazt.stl.DynamicLottieView.3
            @Override // com.byazt.pp.q
            public Bitmap n(final rv rvVar) {
                if (rvVar == null) {
                    return null;
                }
                final String strSz = rvVar.sz();
                String strOa = rvVar.oa();
                if (TextUtils.isEmpty(strSz) || !TextUtils.isEmpty(strOa)) {
                    if (TextUtils.isEmpty(strOa) || !TextUtils.isEmpty(strSz)) {
                        strSz = (TextUtils.isEmpty(strOa) || TextUtils.isEmpty(strSz)) ? "" : strSz + strOa;
                    } else {
                        strSz = strOa;
                    }
                }
                if (TextUtils.isEmpty(strSz)) {
                    return null;
                }
                Bitmap bitmap = DynamicLottieView.this.n == null ? null : (Bitmap) DynamicLottieView.this.n.get(strSz);
                if (bitmap != null) {
                    return bitmap;
                }
                com.byazt.gkj.n.n().l().n(strSz).n(new tj() { // from class: com.byazt.stl.DynamicLottieView.3.2
                    @Override // com.byazt.si.tj
                    public Bitmap n(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, rvVar.n(), rvVar.qg(), false);
                        if (DynamicLottieView.this.n != null) {
                            DynamicLottieView.this.n.put(strSz, bitmapCreateScaledBitmap);
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }).n(new m<Bitmap>() { // from class: com.byazt.stl.DynamicLottieView.3.1
                    @Override // com.byazt.si.m
                    public void n(int i, String str, Throwable th) {
                    }

                    @Override // com.byazt.si.m
                    public void n(cy<Bitmap> cyVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(cyVar.s(), rvVar.n(), rvVar.qg(), false);
                        if (DynamicLottieView.this.n != null) {
                            DynamicLottieView.this.n.put(strSz, bitmapCreateScaledBitmap);
                        }
                        DynamicLottieView.this.n(rvVar.d(), bitmapCreateScaledBitmap);
                    }
                });
                if (DynamicLottieView.this.n == null) {
                    return null;
                }
                return (Bitmap) DynamicLottieView.this.n.get(strSz);
            }
        });
        setAnimationFromUrl(this.qg);
        n();
    }

    @Override // com.byazt.pp.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }
}
