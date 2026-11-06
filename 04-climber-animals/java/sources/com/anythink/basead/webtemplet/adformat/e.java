package com.anythink.basead.webtemplet.adformat;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.ui.RoundCornerRelativeLayout;
import com.anythink.basead.webtemplet.WTWebView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.y;
import com.anythink.network.tap.TapATInitManager;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements b {
    final String a = getClass().getSimpleName();
    w b;
    x c;
    private a d;
    private com.anythink.basead.ui.component.a e;

    public final void a(w wVar, x xVar) {
        this.b = wVar;
        this.c = xVar;
    }

    public final void a(a aVar) {
        this.d = aVar;
    }

    public final a a() {
        return this.d;
    }

    public final void a(com.anythink.basead.ui.component.a aVar) {
        this.e = aVar;
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void initSuccess(Object obj, String str) {
        String string;
        if (obj instanceof com.anythink.basead.webtemplet.e) {
            try {
                WTWebView wTWebView = ((com.anythink.basead.webtemplet.e) obj).a;
                if (wTWebView != null) {
                    wTWebView.jsCallInitSuccess();
                    try {
                        Context contextG = t.b().g();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.anythink.basead.webtemplet.a.b.c.a, 2);
                        jSONObject.put(com.anythink.basead.webtemplet.a.b.c.b, 1);
                        int iK = m.k(contextG) + q.b(contextG);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("screen_width", m.j(contextG));
                        jSONObject2.put("screen_height", iK);
                        int i = this.c.j;
                        if (i == 1 || i == 3 || i == 4) {
                            jSONObject2.put("top_padding", q.b(contextG));
                        } else {
                            jSONObject2.put("top_padding", 0);
                        }
                        jSONObject.put(com.anythink.basead.webtemplet.a.b.c.d, jSONObject2);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, m.j(contextG));
                        jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, iK);
                        if (this.c.w != null) {
                            Object obj2 = this.c.w.get(ATAdConst.KEY.AD_WIDTH);
                            if (obj2 != null) {
                                jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, obj2);
                            }
                            Object obj3 = this.c.w.get(ATAdConst.KEY.AD_HEIGHT);
                            if (obj3 != null) {
                                jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, obj3);
                            }
                            Object obj4 = this.c.w.get(TapATInitManager.ORIENTATION_KEY);
                            if (obj4 != null) {
                                jSONObject3.put(ATAdConst.KEY.AD_ORIENTATION, obj4);
                            }
                        }
                        jSONObject.put(com.anythink.basead.webtemplet.a.b.c.e, jSONObject3);
                        JSONObject jSONObject4 = new JSONObject();
                        if (!TextUtils.isEmpty(this.c.v)) {
                            try {
                                jSONObject4 = new JSONObject(this.c.v);
                            } catch (Throwable unused) {
                            }
                        }
                        jSONObject.put(com.anythink.basead.webtemplet.a.b.c.f, jSONObject4);
                        jSONObject.put("format", this.c.j);
                        jSONObject.put(com.anythink.basead.webtemplet.a.b.c.i, wTWebView.isPreload() ? "1" : "2");
                        jSONObject.put(com.anythink.basead.webtemplet.a.b.c.j, Locale.getDefault().getLanguage());
                        string = jSONObject.toString();
                    } catch (Throwable unused2) {
                        string = "";
                    }
                    if (TextUtils.isEmpty(string)) {
                        com.anythink.basead.webtemplet.a.a(obj, "");
                        return;
                    } else {
                        com.anythink.basead.webtemplet.a.b(obj, string);
                        wTWebView.offerDataInject();
                        return;
                    }
                }
                com.anythink.basead.webtemplet.a.a(obj, "WTWebView empty");
            } catch (Throwable th) {
                b(obj, "initSuccess", th);
            }
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void renderSuccess(Object obj, String str) {
        if (obj instanceof com.anythink.basead.webtemplet.e) {
            try {
                WTWebView wTWebView = ((com.anythink.basead.webtemplet.e) obj).a;
                if (wTWebView != null) {
                    wTWebView.renderSuccess();
                    com.anythink.basead.webtemplet.a.b(obj, "");
                } else {
                    com.anythink.basead.webtemplet.a.a(obj, "WTWebView empty");
                }
            } catch (Throwable th) {
                b(obj, "renderSuccess", th);
            }
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void h5ShowException(Object obj, String str) {
        if (obj instanceof com.anythink.basead.webtemplet.e) {
            try {
                WTWebView wTWebView = ((com.anythink.basead.webtemplet.e) obj).a;
                if (wTWebView != null) {
                    wTWebView.h5ShowException(str);
                    com.anythink.basead.webtemplet.a.b(obj, "");
                } else {
                    com.anythink.basead.webtemplet.a.a(obj, "WTWebView empty");
                }
            } catch (Throwable th) {
                b(obj, "h5ShowException", th);
            }
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void sendEventDA(Object obj, String str) {
        if (obj instanceof com.anythink.basead.webtemplet.e) {
            try {
                WTWebView wTWebView = ((com.anythink.basead.webtemplet.e) obj).a;
                if (wTWebView != null) {
                    wTWebView.sendEventDA(str);
                    com.anythink.basead.webtemplet.a.b(obj, "");
                } else {
                    com.anythink.basead.webtemplet.a.a(obj, "WTWebView empty");
                }
            } catch (Throwable th) {
                b(obj, "sendEventDA", th);
            }
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewInit(final Object obj, String str) {
        com.anythink.basead.ui.component.a aVar = this.e;
        if (aVar != null && aVar.l() != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                final int iOptInt = jSONObject.optInt("position_x", 0);
                final int iOptInt2 = jSONObject.optInt("position_y", 0);
                final int iOptInt3 = jSONObject.optInt("view_width", 0);
                final int iOptInt4 = jSONObject.optInt("view_height", 0);
                final int iOptInt5 = jSONObject.optInt("mute", 1);
                final int iOptInt6 = jSONObject.optInt("right_top_corner", 0);
                final int iOptInt7 = jSONObject.optInt("right_bottom_corner", 0);
                final int iOptInt8 = jSONObject.optInt("left_top_corner", 0);
                final int iOptInt9 = jSONObject.optInt("left_bottom_corner", 0);
                t.b().b(new Runnable() { // from class: com.anythink.basead.webtemplet.adformat.e.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        View viewM = e.this.e.m();
                        if (viewM == null) {
                            viewM = e.this.e.l();
                        }
                        if (viewM == null) {
                            com.anythink.basead.webtemplet.a.a(obj, "playerViewContainer empty");
                            return;
                        }
                        viewM.setX(iOptInt);
                        viewM.setY(iOptInt2);
                        ViewGroup.LayoutParams layoutParams = viewM.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iOptInt3;
                            layoutParams.height = iOptInt4;
                            viewM.setLayoutParams(layoutParams);
                        }
                        e.this.e.a(iOptInt5 == 1, (List<Bitmap>) null, (com.anythink.basead.j.e) null);
                        if (viewM instanceof RoundCornerRelativeLayout) {
                            ((RoundCornerRelativeLayout) viewM).setRadius(iOptInt8, iOptInt6, iOptInt7, iOptInt9);
                        }
                        viewM.requestLayout();
                        com.anythink.basead.webtemplet.a.b(obj, "");
                        if (e.this.d != null) {
                            e.this.d.b();
                        }
                    }
                });
                return;
            } catch (Throwable th) {
                b(obj, "playerViewInit", th);
                return;
            }
        }
        com.anythink.basead.webtemplet.a.a(obj, "videoComponent empty");
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewGetProgress(final Object obj, String str) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.webtemplet.adformat.e.2
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.e != null && e.this.e.l() != null) {
                    long jI = e.this.e.i();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", jI);
                        com.anythink.basead.webtemplet.a.a(obj, jSONObject);
                        return;
                    } catch (Throwable th) {
                        e.b(obj, "playerViewGetProgress", th);
                        return;
                    }
                }
                com.anythink.basead.webtemplet.a.a(obj, "videoComponent empty");
            }
        }, 2);
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewMute(Object obj, String str) {
        com.anythink.basead.ui.component.a aVar = this.e;
        if (aVar != null && aVar.l() != null) {
            try {
                boolean z = true;
                int iOptInt = new JSONObject(str).optInt("mute", 1);
                com.anythink.basead.ui.component.a aVar2 = this.e;
                if (iOptInt != 1) {
                    z = false;
                }
                aVar2.c(z);
                com.anythink.basead.webtemplet.a.b(obj, "");
                return;
            } catch (Throwable th) {
                b(obj, "playerViewMute", th);
                return;
            }
        }
        com.anythink.basead.webtemplet.a.a(obj, "videoComponent empty");
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewRemove(Object obj, String str) {
        com.anythink.basead.ui.component.a aVar = this.e;
        if (aVar != null && aVar.l() != null) {
            try {
                this.e.b();
                com.anythink.basead.webtemplet.a.b(obj, "");
                return;
            } catch (Throwable th) {
                b(obj, "playerViewRemove", th);
                return;
            }
        }
        com.anythink.basead.webtemplet.a.a(obj, "videoComponent empty");
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewPauseOrResumePlay(Object obj, String str) {
        com.anythink.basead.ui.component.a aVar = this.e;
        if (aVar != null && aVar.l() != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("is_resume", 1);
                boolean z = jSONObject.optInt("can_resume", 1) == 1;
                if (iOptInt == 1) {
                    this.e.a(z);
                } else {
                    this.e.b(z);
                }
                com.anythink.basead.webtemplet.a.b(obj, "");
                return;
            } catch (Throwable th) {
                b(obj, "playerViewPauseOrResumePlay", th);
                return;
            }
        }
        com.anythink.basead.webtemplet.a.a(obj, "videoComponent empty");
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewRelayout(final Object obj, String str) {
        com.anythink.basead.ui.component.a aVar = this.e;
        if (aVar != null && aVar.l() != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                final int iOptInt = jSONObject.optInt("position_x", 0);
                final int iOptInt2 = jSONObject.optInt("position_y", 0);
                final int iOptInt3 = jSONObject.optInt("view_width", 0);
                final int iOptInt4 = jSONObject.optInt("view_height", 0);
                final int iOptInt5 = jSONObject.optInt("right_top_corner", 0);
                final int iOptInt6 = jSONObject.optInt("right_bottom_corner", 0);
                final int iOptInt7 = jSONObject.optInt("left_top_corner", 0);
                final int iOptInt8 = jSONObject.optInt("left_bottom_corner", 0);
                t.b().b(new Runnable() { // from class: com.anythink.basead.webtemplet.adformat.e.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        View viewM = e.this.e.m();
                        if (viewM == null) {
                            e.this.e.l();
                        }
                        if (viewM == null) {
                            com.anythink.basead.webtemplet.a.a(obj, "videoComponent empty");
                            return;
                        }
                        viewM.setX(iOptInt);
                        viewM.setY(iOptInt2);
                        ViewGroup.LayoutParams layoutParams = viewM.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iOptInt3;
                            layoutParams.height = iOptInt4;
                            viewM.setLayoutParams(layoutParams);
                        }
                        if (viewM instanceof RoundCornerRelativeLayout) {
                            ((RoundCornerRelativeLayout) viewM).setRadius(iOptInt7, iOptInt5, iOptInt6, iOptInt8);
                        }
                        viewM.requestLayout();
                        com.anythink.basead.webtemplet.a.b(obj, "");
                    }
                });
                return;
            } catch (Throwable th) {
                b(obj, "playerViewRelayout", th);
                return;
            }
        }
        com.anythink.basead.webtemplet.a.a(obj, "videoComponent empty");
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void notifyClick(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("cl_s_type", 0);
            int iOptInt2 = jSONObject.optInt("cl_area", 0);
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(iOptInt, iOptInt2);
                com.anythink.basead.webtemplet.a.b(obj, "");
            } else {
                com.anythink.basead.webtemplet.a.a(obj, "bridgeListener empty");
            }
        } catch (Throwable th) {
            b(obj, "notifyClick", th);
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void openInWebView(Object obj, String str) {
        Context context;
        int iOptInt;
        String strOptString;
        if (obj instanceof com.anythink.basead.webtemplet.e) {
            try {
                WTWebView wTWebView = ((com.anythink.basead.webtemplet.e) obj).a;
                if (wTWebView != null) {
                    context = wTWebView.getContext();
                    if (context == null) {
                        context = t.b().g();
                    }
                } else {
                    context = null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    iOptInt = jSONObject.optInt("type", 1);
                    try {
                        strOptString = jSONObject.optString("url", "");
                    } catch (Throwable unused) {
                        strOptString = "";
                    }
                } catch (Throwable unused2) {
                    iOptInt = 1;
                }
                if (!TextUtils.isEmpty(strOptString)) {
                    if (iOptInt == 1) {
                        y.a(context, strOptString);
                    } else {
                        y.a(strOptString);
                    }
                    com.anythink.basead.webtemplet.a.b(obj, "");
                    return;
                }
                com.anythink.basead.webtemplet.a.a(obj, "params error");
            } catch (Throwable th) {
                b(obj, "openInWebView", th);
            }
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void showFeedbackDialog(Object obj, String str) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
            com.anythink.basead.webtemplet.a.b(obj, "");
        } else {
            com.anythink.basead.webtemplet.a.a(obj, "bridgeListener empty");
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void notifyClose(Object obj, String str) {
        try {
            int iOptInt = new JSONObject(str).optInt(com.anythink.core.common.a.b.C0077b.a, 0);
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(iOptInt);
                com.anythink.basead.webtemplet.a.b(obj, "");
            } else {
                com.anythink.basead.webtemplet.a.a(obj, "bridgeListener empty");
            }
        } catch (Throwable th) {
            b(obj, "notifyClose", th);
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void controlShakeView(Object obj, String str) {
        try {
            if (!com.anythink.basead.b.e.a(this.c)) {
                com.anythink.basead.webtemplet.a.a(obj, "not support shake");
                return;
            }
            int iOptInt = new JSONObject(str).optInt("control_show", 0);
            a aVar = this.d;
            if (aVar != null) {
                aVar.b(iOptInt);
                com.anythink.basead.webtemplet.a.b(obj, "");
            } else {
                com.anythink.basead.webtemplet.a.a(obj, "bridgeListener empty");
            }
        } catch (Throwable th) {
            b(obj, "notifyClose", th);
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void notifyReward(Object obj, String str) {
        try {
            a aVar = this.d;
            if (aVar != null && (aVar instanceof d)) {
                ((d) aVar).c();
                com.anythink.basead.webtemplet.a.b(obj, "");
            } else if (aVar == null) {
                com.anythink.basead.webtemplet.a.a(obj, "bridgeListener empty");
            } else {
                com.anythink.basead.webtemplet.a.a(obj, "bridgeListener type error");
            }
        } catch (Throwable th) {
            b(obj, "notifyReward", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Object obj, String str, Throwable th) {
        if (obj == null || th == null) {
            return;
        }
        com.anythink.basead.webtemplet.a.a(obj, "call method " + str + " fail with exception:" + th.getMessage());
    }
}
