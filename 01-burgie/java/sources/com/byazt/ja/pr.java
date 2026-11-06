package com.byazt.ja;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.ch.aj;
import com.byazt.hg.b;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.r;
import com.byazt.hg.y;
import com.byazt.oc.UpieImageView;
import com.byazt.sd.a;
import com.byazt.xk.hw;
import com.byazt.zp.zo;
import com.taptap.sdk.db.constant.Common;
import com.uc.crashsdk.export.LogType;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1045, 37})
public class pr {
    public static boolean pr(of ofVar) {
        return hw(ofVar) || hn(ofVar);
    }

    public static boolean hw(of ofVar) {
        return ofVar != null && ofVar.ab() == 15;
    }

    public static boolean hn(of ofVar) {
        return ofVar != null && ofVar.ab() == 16;
    }

    public static boolean x(of ofVar) {
        return c(ofVar) || uc(ofVar);
    }

    public static boolean c(of ofVar) {
        return ofVar != null && ofVar.ab() == 17;
    }

    public static boolean uc(of ofVar) {
        return ofVar != null && ofVar.ab() == 18;
    }

    public static boolean fw(of ofVar) {
        int[] iArrC;
        if (ofVar == null || (iArrC = qv.c(ofVar)) == null || iArrC.length < 2) {
            return true;
        }
        int i = iArrC[0];
        int i2 = iArrC[1];
        int iX = qv.x(ofVar);
        int iHn = qv.hn(ofVar);
        if ((i >= i2 && iX >= iHn) || (i <= i2 && iX <= iHn)) {
            return true;
        }
        return false;
    }

    public static boolean zo(of ofVar) {
        if (ofVar == null || of.hn(ofVar)) {
            return false;
        }
        if (x(ofVar)) {
            return true;
        }
        return !a.hw().uj() && (b.hw(ofVar) || b.x(ofVar) || r.hw(ofVar));
    }

    private static com.byazt.ic.pr.C0093pr k(of ofVar) {
        int[] iArrC = qv.c(ofVar);
        String strAj = aj(ofVar);
        com.byazt.ic.pr.C0093pr c0093pr = new com.byazt.ic.pr.C0093pr();
        if (TextUtils.isEmpty(strAj)) {
            strAj = "";
        }
        com.byazt.ic.pr.C0093pr c0093prHw = c0093pr.pr(strAj).pr((iArrC == null || iArrC.length < 2) ? LogType.UNEXP_ANR : iArrC[0]).hw((iArrC == null || iArrC.length < 2) ? 720 : iArrC[1]);
        if (hw(ofVar)) {
            com.byazt.n.pr prVarYb = qv.yb(ofVar);
            c0093prHw.hn(m(ofVar)).hw(prVarYb != null ? prVarYb.c() : "").pr(((long) qv.fw(ofVar)) * 1000);
        }
        if (x(ofVar)) {
            c0093prHw.hn(m(ofVar));
        }
        return c0093prHw;
    }

    public static String aj(of ofVar) {
        JSONObject jSONObjectOf;
        JSONObject jSONObjectOptJSONObject;
        if (ofVar == null || (jSONObjectOf = ofVar.of()) == null || (jSONObjectOptJSONObject = jSONObjectOf.optJSONObject("sdk_template_info")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("lottie_tmp_url");
    }

    public static com.byazt.ic.pr vk(of ofVar) {
        if (!x(ofVar) && !pr(ofVar)) {
            return new com.byazt.ic.pr.C0093pr().hn(m(ofVar)).pr();
        }
        com.byazt.ic.pr.C0093pr c0093prK = k(ofVar);
        JSONObject jSONObject = ofVar.to();
        if (jSONObject != null) {
            try {
                jSONObject.put("os", "android");
            } catch (JSONException e) {
            }
        }
        c0093prK.pr(jSONObject);
        return c0093prK.pr();
    }

    public static com.byazt.ic.pr pr(of ofVar, JSONObject jSONObject) {
        com.byazt.ic.pr.C0093pr c0093prK = k(ofVar);
        if (jSONObject != null) {
            try {
                jSONObject.put("os", "android");
            } catch (JSONException e) {
            }
        }
        c0093prK.pr(jSONObject);
        return c0093prK.pr();
    }

    private static String m(of ofVar) {
        List<y> listDe;
        if (ofVar != null && (listDe = ofVar.de()) != null && listDe.size() > 0) {
            return listDe.get(0).pr();
        }
        return null;
    }

    public static void pr(JSONObject jSONObject, of ofVar) {
        if (jSONObject != null) {
            if (pr(ofVar) || x(ofVar)) {
                try {
                    jSONObject.put("dynamic_join_type", ofVar.ab());
                    String strQn = ofVar.qn();
                    if (!TextUtils.isEmpty(strQn)) {
                        jSONObject.put("union_template_id", new JSONObject(strQn).optString("template_id"));
                    }
                } catch (JSONException e) {
                }
            }
        }
    }

    public static void pr(boolean z, aj.pr prVar) {
        JSONObject jSONObjectC;
        if (prVar != null && (jSONObjectC = prVar.c()) != null && TextUtils.equals("${image[0].url}", jSONObjectC.optString("src"))) {
            try {
                if (z) {
                    jSONObjectC.put("type", "UpieImage");
                } else {
                    jSONObjectC.put(Common.System.NAME, "UpieImage");
                }
            } catch (JSONException e) {
            }
            prVar.pr("UpieImage");
        }
    }

    public static void pr(final ImageView imageView, final UpieImageView upieImageView) {
        if (imageView == null || upieImageView == null) {
            return;
        }
        zo.pr(new Runnable() { // from class: com.byazt.ja.pr.1
            @Override // java.lang.Runnable
            public void run() {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.ja.pr.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int width = imageView.getWidth();
                        int height = imageView.getHeight();
                        if (width > 90 && height > 90) {
                            imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            pr.hn(imageView, upieImageView);
                        }
                    }
                };
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
                imageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.ja.pr.1.2
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
    public static void hn(ImageView imageView, UpieImageView upieImageView) {
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

    public static com.byazt.oc.pr w(final of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return new com.byazt.oc.pr() { // from class: com.byazt.ja.pr.2
            @Override // com.byazt.oc.pr
            public void pr(Map<String, Object> map) {
                hw.pr().pr(ofVar, map.get("duration"));
            }

            @Override // com.byazt.oc.pr
            public void pr(int i, String str) {
                hw.pr().hw(ofVar, i, str);
            }
        };
    }
}
