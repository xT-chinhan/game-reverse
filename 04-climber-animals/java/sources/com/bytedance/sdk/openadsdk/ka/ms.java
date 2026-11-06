package com.bytedance.sdk.openadsdk.ka;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.adsdk.ugeno.ah.x;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.qv;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.taptap.sdk.db.constant.Common;
import com.uc.crashsdk.export.LogType;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static boolean ms(lm lmVar) {
        return xr(lmVar) || ah(lmVar);
    }

    public static boolean xr(lm lmVar) {
        return lmVar != null && lmVar.tf() == 15;
    }

    public static boolean ah(lm lmVar) {
        return lmVar != null && lmVar.tf() == 16;
    }

    public static boolean d(lm lmVar) {
        return ka(lmVar) || c(lmVar);
    }

    public static boolean ka(lm lmVar) {
        return lmVar != null && lmVar.tf() == 17;
    }

    public static boolean c(lm lmVar) {
        return lmVar != null && lmVar.tf() == 18;
    }

    public static boolean ab(lm lmVar) {
        int[] iArrKa;
        if (lmVar == null || (iArrKa = qr.ka(lmVar)) == null || iArrKa.length < 2) {
            return true;
        }
        int i = iArrKa[0];
        int i2 = iArrKa[1];
        int iD = qr.d(lmVar);
        int iAh = qr.ah(lmVar);
        return (i >= i2 && iD >= iAh) || (i <= i2 && iD <= iAh);
    }

    public static boolean x(lm lmVar) {
        if (lmVar != null && !lm.xr(lmVar)) {
            if (d(lmVar)) {
                return true;
            }
            if (!re.xr().lx() && (op.ms(lmVar) || op.xr(lmVar) || UGenVideoOrImgPanelView.ms(lmVar))) {
                return true;
            }
        }
        return false;
    }

    private static com.bytedance.sdk.openadsdk.upie.ms.C0340ms hi(lm lmVar) {
        int[] iArrKa = qr.ka(lmVar);
        qv qvVarU = lmVar.u();
        String strAh = qvVarU != null ? qvVarU.ah() : null;
        com.bytedance.sdk.openadsdk.upie.ms.C0340ms c0340ms = new com.bytedance.sdk.openadsdk.upie.ms.C0340ms();
        if (TextUtils.isEmpty(strAh)) {
            strAh = "";
        }
        com.bytedance.sdk.openadsdk.upie.ms.C0340ms c0340msXr = c0340ms.ms(strAh).ms((iArrKa == null || iArrKa.length < 2) ? LogType.UNEXP_ANR : iArrKa[0]).xr((iArrKa == null || iArrKa.length < 2) ? 720 : iArrKa[1]);
        if (xr(lmVar)) {
            com.bykv.vk.openvk.component.video.api.ah.ms msVarAo = qr.ao(lmVar);
            c0340msXr.ah(sl(lmVar)).xr(msVarAo != null ? msVarAo.ka() : "").ms(((long) qr.c(lmVar)) * 1000);
        }
        if (d(lmVar)) {
            c0340msXr.ah(sl(lmVar));
        }
        return c0340msXr;
    }

    public static com.bytedance.sdk.openadsdk.upie.ms ny(lm lmVar) {
        if (!d(lmVar) && !ms(lmVar)) {
            return new com.bytedance.sdk.openadsdk.upie.ms.C0340ms().ah(sl(lmVar)).ms();
        }
        com.bytedance.sdk.openadsdk.upie.ms.C0340ms c0340msHi = hi(lmVar);
        JSONObject jSONObjectRm = lmVar.rm();
        if (jSONObjectRm != null) {
            try {
                jSONObjectRm.put("os", "android");
            } catch (JSONException unused) {
            }
        }
        c0340msHi.ms(jSONObjectRm);
        return c0340msHi.ms();
    }

    public static com.bytedance.sdk.openadsdk.upie.ms ms(lm lmVar, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.upie.ms.C0340ms c0340msHi = hi(lmVar);
        if (jSONObject != null) {
            try {
                jSONObject.put("os", "android");
            } catch (JSONException unused) {
            }
        }
        c0340msHi.ms(jSONObject);
        return c0340msHi.ms();
    }

    private static String sl(lm lmVar) {
        List<g> listFk;
        if (lmVar == null || (listFk = lmVar.fk()) == null || listFk.size() <= 0) {
            return null;
        }
        return listFk.get(0).ms();
    }

    public static void ms(JSONObject jSONObject, lm lmVar) {
        if (jSONObject != null) {
            if (ms(lmVar) || d(lmVar)) {
                try {
                    jSONObject.put("dynamic_join_type", lmVar.tf());
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
        }
    }

    public static void ms(boolean z, x.ms msVar) {
        JSONObject jSONObjectD;
        if (msVar == null || (jSONObjectD = msVar.d()) == null || !TextUtils.equals("${image[0].url}", jSONObjectD.optString("src"))) {
            return;
        }
        try {
            if (z) {
                jSONObjectD.put("type", "UpieImage");
            } else {
                jSONObjectD.put(Common.System.NAME, "UpieImage");
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        msVar.ms("UpieImage");
    }

    public static void ms(final ImageView imageView, final UpieImageView upieImageView) {
        ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ka.ms.1
            @Override // java.lang.Runnable
            public void run() {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.ka.ms.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int width = imageView.getWidth();
                        int height = imageView.getHeight();
                        if (width <= 90 || height <= 90) {
                            return;
                        }
                        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        ms.ah(imageView, upieImageView);
                    }
                };
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
                imageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.ka.ms.1.2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        if (imageView == view) {
                            imageView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(ImageView imageView, UpieImageView upieImageView) {
        ViewGroup.LayoutParams layoutParams;
        ViewParent parent = imageView.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int i = 0;
            while (true) {
                if (i >= viewGroup.getChildCount()) {
                    i = -1;
                    break;
                } else if (imageView == viewGroup.getChildAt(i)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams2.gravity = 17;
                    layoutParams = layoutParams2;
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams3.addRule(13);
                    layoutParams = layoutParams3;
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams4.gravity = 17;
                    layoutParams = layoutParams4;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(imageView.getWidth(), imageView.getHeight());
                }
                viewGroup.addView(upieImageView, i, layoutParams);
                viewGroup.removeView(imageView);
            }
        }
    }

    public static com.bytedance.sdk.openadsdk.upie.image.lottie.ms ch(final lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.upie.image.lottie.ms() { // from class: com.bytedance.sdk.openadsdk.ka.ms.2
            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.ms
            public void ms(Map<String, Object> map) {
                u.ms().ms(lmVar, map.get("duration"));
            }

            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.ms
            public void ms(int i, String str) {
                u.ms().ms(lmVar, i, str);
            }
        };
    }
}
