package com.anythink.basead.mraid;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;
import com.anythink.network.tap.TapATInitManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MraidWebView extends MraidBaseWebView {
    public static String TAG = "MraidWebView";
    e d;
    boolean e;
    com.anythink.core.express.b.c f;
    boolean g;

    public MraidWebView(Context context) {
        super(context);
        this.e = false;
    }

    public MraidWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
    }

    public MraidWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
    }

    public void setNeedRegisterVolumeChangeReceiver(boolean z) {
        this.g = z;
    }

    public void prepare(Context context, e eVar) {
        this.d = eVar;
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.basead.mraid.MraidWebView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                String str;
                try {
                    if (!MraidWebView.this.e) {
                        MraidWebView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        MraidWebView.this.e = true;
                        int[] iArr = new int[2];
                        MraidWebView.this.getLocationInWindow(iArr);
                        MraidWebView mraidWebView = MraidWebView.this;
                        float f = iArr[0];
                        float f2 = iArr[1];
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", f);
                            jSONObject.put("startY", f2);
                            jSONObject.put("scale", q.h(t.b().g()));
                            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                            f.a();
                            f.a((WebView) mraidWebView, "webviewshow", strEncodeToString);
                        } catch (Throwable unused) {
                        }
                        MraidWebView mraidWebView2 = MraidWebView.this;
                        int i = iArr[0];
                        int i2 = iArr[1];
                        int width = mraidWebView2.getWidth();
                        int height = MraidWebView.this.getHeight();
                        try {
                            int i3 = t.b().g().getResources().getConfiguration().orientation;
                            JSONObject jSONObject2 = new JSONObject();
                            if (i3 == 2) {
                                str = "landscape";
                            } else {
                                str = i3 == 1 ? "portrait" : "undefined";
                            }
                            jSONObject2.put(TapATInitManager.ORIENTATION_KEY, str);
                            jSONObject2.put("locked", "true");
                            float fE = q.e(t.b().g());
                            float f3 = q.f(t.b().g());
                            HashMap mapG = q.g(t.b().g());
                            int iIntValue = ((Integer) mapG.get("width")).intValue();
                            int iIntValue2 = ((Integer) mapG.get("height")).intValue();
                            HashMap map = new HashMap();
                            map.put(com.anythink.core.express.b.a.a, com.anythink.core.express.b.a.k);
                            map.put("state", com.anythink.core.express.b.a.f);
                            map.put(com.anythink.core.express.b.a.c, "true");
                            map.put(com.anythink.core.express.b.a.d, jSONObject2);
                            com.anythink.core.express.b.a.a();
                            float f4 = i;
                            float f5 = i2;
                            float f6 = width;
                            float f7 = height;
                            com.anythink.core.express.b.a.a(mraidWebView2, f4, f5, f6, f7);
                            com.anythink.core.express.b.a.a();
                            com.anythink.core.express.b.a.b(mraidWebView2, f4, f5, f6, f7);
                            com.anythink.core.express.b.a.a();
                            com.anythink.core.express.b.a.b(mraidWebView2, fE, f3);
                            com.anythink.core.express.b.a.a();
                            com.anythink.core.express.b.a.c(mraidWebView2, iIntValue, iIntValue2);
                            com.anythink.core.express.b.a.a();
                            com.anythink.core.express.b.a.a(mraidWebView2, map);
                            com.anythink.core.express.b.a.a();
                            com.anythink.core.express.b.a.a(mraidWebView2);
                        } catch (Throwable unused2) {
                        }
                        MraidWebView.a(MraidWebView.this);
                        if (MraidWebView.this.g) {
                            MraidWebView.b(MraidWebView.this);
                        }
                        if (MraidWebView.this.d != null) {
                            MraidWebView.this.d.a();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return false;
            }
        });
    }

    private void b() {
        Object object = getObject();
        com.anythink.core.express.web.b baseWebViewClient = getBaseWebViewClient();
        if (object instanceof d) {
            Context context = getContext();
            if (context instanceof Activity) {
                ((d) object).b = new WeakReference<>((Activity) context);
            }
            ((d) object).a(this.d);
        }
        if (baseWebViewClient instanceof k) {
            ((k) baseWebViewClient).c = this.d;
        }
    }

    private void c() {
        com.anythink.core.express.b.c cVar = new com.anythink.core.express.b.c(getContext());
        this.f = cVar;
        cVar.c();
        this.f.a();
        this.f.a(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.basead.mraid.MraidWebView$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.express.b.c.b {
        AnonymousClass2() {
        }

        @Override // com.anythink.core.express.b.c.b
        public final void a(double d) {
            String str = MraidWebView.TAG;
            try {
                com.anythink.core.express.b.a.a();
                com.anythink.core.express.b.a.a(MraidWebView.this, d);
            } catch (Exception e) {
                String str2 = MraidWebView.TAG;
                e.getMessage();
            }
        }
    }

    @Override // com.anythink.basead.mraid.MraidBaseWebView, com.anythink.core.express.web.BaseWebView
    public void release() {
        super.release();
        setWebViewListener(null);
        com.anythink.core.express.b.c cVar = this.f;
        if (cVar != null) {
            cVar.d();
        }
    }

    static /* synthetic */ void a(MraidWebView mraidWebView) {
        Object object = mraidWebView.getObject();
        com.anythink.core.express.web.b baseWebViewClient = mraidWebView.getBaseWebViewClient();
        if (object instanceof d) {
            Context context = mraidWebView.getContext();
            if (context instanceof Activity) {
                ((d) object).b = new WeakReference<>((Activity) context);
            }
            ((d) object).a(mraidWebView.d);
        }
        if (baseWebViewClient instanceof k) {
            ((k) baseWebViewClient).c = mraidWebView.d;
        }
    }

    static /* synthetic */ void b(MraidWebView mraidWebView) {
        com.anythink.core.express.b.c cVar = new com.anythink.core.express.b.c(mraidWebView.getContext());
        mraidWebView.f = cVar;
        cVar.c();
        mraidWebView.f.a();
        mraidWebView.f.a(mraidWebView.new AnonymousClass2());
    }
}
