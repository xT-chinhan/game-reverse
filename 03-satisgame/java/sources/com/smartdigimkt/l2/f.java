package com.smartdigimkt.l2;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewBaseScreenATView;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements b {
    public a a;
    public com.smartdigimkt.u1.d b;
    public com.smartdigimkt.b3.c c;
    public com.smartdigimkt.a3.a d;

    public static void a(Object obj, String str, Throwable th) {
        if (obj != null) {
            com.smartdigimkt.k2.a.a(obj, "call method " + str + " fail with exception:" + th.getMessage());
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void checkDataFetchState(Object obj, String str) {
        try {
            String strOptString = new JSONObject(str).optString("pkg_name", "");
            if (TextUtils.isEmpty(strOptString)) {
                com.smartdigimkt.k2.a.a(obj, "pkg_name empty");
                return;
            }
            boolean zC = k.c(SDKContext.getInstance().d(), strOptString);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebLoginFragment.QUERY_KEY_ID, zC ? 1 : 2);
            com.smartdigimkt.k2.a.a(obj, jSONObject);
        } catch (Throwable th) {
            a(obj, "checkDataFetchState", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void controlShakeView(Object obj, String str) {
        try {
            if (!c0.d(this.d)) {
                com.smartdigimkt.k2.a.a(obj, "not support shake");
                return;
            }
            int iOptInt = new JSONObject(str).optInt("control_show", 0);
            a aVar = this.a;
            if (aVar == null) {
                com.smartdigimkt.k2.a.a(obj, "bridgeListener empty");
            } else {
                aVar.a(iOptInt);
                com.smartdigimkt.k2.a.b(obj, "");
            }
        } catch (Throwable th) {
            a(obj, "notifyClose", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void h5ShowException(Object obj, String str) {
        if (obj instanceof com.smartdigimkt.k2.d) {
            try {
                WTWebView wTWebView = ((com.smartdigimkt.k2.d) obj).a;
                if (wTWebView != null) {
                    wTWebView.h5ShowException(str);
                    com.smartdigimkt.k2.a.b(obj, "");
                } else {
                    com.smartdigimkt.k2.a.a(obj, "WTWebView empty");
                }
            } catch (Throwable th) {
                a(obj, "h5ShowException", th);
            }
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void initSuccess(Object obj, String str) {
        String string;
        if (obj instanceof com.smartdigimkt.k2.d) {
            try {
                WTWebView wTWebView = ((com.smartdigimkt.k2.d) obj).a;
                if (wTWebView != null) {
                    wTWebView.jsCallInitSuccess();
                    try {
                        Context contextD = SDKContext.getInstance().d();
                        com.smartdigimkt.b3.e eVar = this.c.w;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("js_bridge_version", 3);
                        jSONObject.put("os_platform", 1);
                        int iJ = h.j(contextD) + k.a(contextD);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("screen_width", h.k(contextD));
                        jSONObject2.put("screen_height", iJ);
                        int i = this.d.c;
                        if (i == 1 || i == 3 || i == 4) {
                            jSONObject2.put("top_padding", k.a(contextD));
                        } else {
                            jSONObject2.put("top_padding", 0);
                        }
                        jSONObject.put("device_info", jSONObject2);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, h.k(contextD));
                        jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, iJ);
                        HashMap map = this.d.u;
                        if (map != null) {
                            int iIntValue = ((Integer) k.a((Map) map, ATAdConst.KEY.AD_WIDTH, (Object) 0)).intValue();
                            if (iIntValue > 0) {
                                jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, iIntValue);
                            }
                            int iIntValue2 = ((Integer) k.a((Map) this.d.u, ATAdConst.KEY.AD_HEIGHT, (Object) 0)).intValue();
                            if (iIntValue2 > 0) {
                                jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, iIntValue2);
                            }
                            int iIntValue3 = ((Integer) k.a((Map) this.d.u, "orientation", (Object) 0)).intValue();
                            if (iIntValue3 > 0) {
                                jSONObject3.put(ATAdConst.KEY.AD_ORIENTATION, iIntValue3);
                            }
                        }
                        jSONObject.put("adview_info", jSONObject3);
                        JSONObject jSONObject4 = new JSONObject();
                        if (!TextUtils.isEmpty(this.d.n)) {
                            try {
                                jSONObject4 = new JSONObject(this.d.n);
                            } catch (Throwable unused) {
                            }
                        }
                        jSONObject.put("content_data", jSONObject4);
                        jSONObject.put(com.anythink.core.common.f.a.C0017a.d, this.d.c);
                        jSONObject.put("is_preload", wTWebView.isPreload() ? "1" : "2");
                        jSONObject.put("lang", Locale.getDefault().getLanguage());
                        JSONObject jSONObject5 = new JSONObject();
                        if (eVar != null) {
                            try {
                                jSONObject5 = new JSONObject(eVar.u1);
                            } catch (Throwable unused2) {
                            }
                        }
                        jSONObject.put("settings", jSONObject5);
                        string = jSONObject.toString();
                    } catch (Throwable unused3) {
                        string = "";
                    }
                    if (TextUtils.isEmpty(string)) {
                        com.smartdigimkt.k2.a.a(obj, "");
                    } else {
                        com.smartdigimkt.k2.a.b(obj, string);
                        wTWebView.offerDataInject();
                    }
                } else {
                    com.smartdigimkt.k2.a.a(obj, "WTWebView empty");
                }
            } catch (Throwable th) {
                a(obj, "initSuccess", th);
            }
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void notifyClick(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("cl_s_type", 0);
            int iOptInt2 = jSONObject.optInt("cl_area", 0);
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(iOptInt, iOptInt2);
                com.smartdigimkt.k2.a.b(obj, "");
            } else {
                com.smartdigimkt.k2.a.a(obj, "bridgeListener empty");
            }
        } catch (Throwable th) {
            a(obj, "notifyClick", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void notifyClose(Object obj, String str) {
        try {
            int iOptInt = new JSONObject(str).optInt(com.anythink.core.common.a.b.C0013b.a, 0);
            a aVar = this.a;
            if (aVar != null) {
                aVar.b(iOptInt);
                com.smartdigimkt.k2.a.b(obj, "");
            } else {
                com.smartdigimkt.k2.a.a(obj, "bridgeListener empty");
            }
        } catch (Throwable th) {
            a(obj, "notifyClose", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void notifyReward(Object obj, String str) {
        try {
            a aVar = this.a;
            if (aVar != null && (aVar instanceof com.smartdigimkt.a2.b)) {
                WTWebViewBaseScreenATView wTWebViewBaseScreenATView = ((com.smartdigimkt.a2.b) aVar).a;
                int i = WTWebViewBaseScreenATView.C0;
                wTWebViewBaseScreenATView.z();
                com.smartdigimkt.k2.a.b(obj, "");
            } else if (aVar == null) {
                com.smartdigimkt.k2.a.a(obj, "bridgeListener empty");
            } else {
                com.smartdigimkt.k2.a.a(obj, "bridgeListener type error");
            }
        } catch (Throwable th) {
            a(obj, "notifyReward", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void openInWebView(Object obj, String str) {
        Context context;
        int iOptInt;
        String strOptString;
        if (obj instanceof com.smartdigimkt.k2.d) {
            try {
                WTWebView wTWebView = ((com.smartdigimkt.k2.d) obj).a;
                if (wTWebView != null) {
                    context = wTWebView.getContext();
                    if (context == null) {
                        context = SDKContext.getInstance().d();
                    }
                } else {
                    context = null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    iOptInt = jSONObject.optInt("type", 1);
                    try {
                        strOptString = jSONObject.optString(ImagesContract.URL, "");
                    } catch (Throwable unused) {
                        strOptString = "";
                    }
                } catch (Throwable unused2) {
                    iOptInt = 1;
                }
                if (TextUtils.isEmpty(strOptString)) {
                    com.smartdigimkt.k2.a.a(obj, "params error");
                    return;
                }
                if (iOptInt == 1) {
                    com.smartdigimkt.s4.e.a(context, strOptString);
                } else {
                    com.smartdigimkt.s4.e.a(strOptString);
                }
                com.smartdigimkt.k2.a.b(obj, "");
            } catch (Throwable th) {
                a(obj, "openInWebView", th);
            }
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void playerViewGetProgress(Object obj, String str) {
        com.smartdigimkt.q3.f.a().a(new d(this, obj), 0L, 2);
    }

    @Override // com.smartdigimkt.l2.b
    public final void playerViewInit(Object obj, String str) {
        com.smartdigimkt.u1.d dVar = this.b;
        if (dVar == null || dVar.h == null) {
            com.smartdigimkt.k2.a.a(obj, "videoComponent empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("position_x", 0);
            int iOptInt2 = jSONObject.optInt("position_y", 0);
            int iOptInt3 = jSONObject.optInt("view_width", 0);
            int iOptInt4 = jSONObject.optInt("view_height", 0);
            int iOptInt5 = jSONObject.optInt("mute", 1);
            int iOptInt6 = jSONObject.optInt("right_top_corner", 0);
            int iOptInt7 = jSONObject.optInt("right_bottom_corner", 0);
            com.smartdigimkt.q3.f.a().a(new c(this, obj, iOptInt, iOptInt2, iOptInt3, iOptInt4, iOptInt5, jSONObject.optInt("left_top_corner", 0), iOptInt6, iOptInt7, jSONObject.optInt("left_bottom_corner", 0)));
        } catch (Throwable th) {
            a(obj, "playerViewInit", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void playerViewMute(Object obj, String str) {
        com.smartdigimkt.u1.d dVar = this.b;
        if (dVar == null || dVar.h == null) {
            com.smartdigimkt.k2.a.a(obj, "videoComponent empty");
            return;
        }
        try {
            boolean z = true;
            int iOptInt = new JSONObject(str).optInt("mute", 1);
            com.smartdigimkt.u1.d dVar2 = this.b;
            if (iOptInt != 1) {
                z = false;
            }
            dVar2.b(z);
            com.smartdigimkt.k2.a.b(obj, "");
        } catch (Throwable th) {
            a(obj, "playerViewMute", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void playerViewPauseOrResumePlay(Object obj, String str) {
        com.smartdigimkt.u1.d dVar = this.b;
        if (dVar == null || dVar.h == null) {
            com.smartdigimkt.k2.a.a(obj, "videoComponent empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("is_resume", 1);
            boolean z = jSONObject.optInt("can_resume", 1) == 1;
            if (iOptInt == 1) {
                com.smartdigimkt.u1.d dVar2 = this.b;
                if (z) {
                    dVar2.s = z;
                }
                dVar2.d();
            } else {
                com.smartdigimkt.u1.d dVar3 = this.b;
                dVar3.s = z;
                dVar3.b();
            }
            com.smartdigimkt.k2.a.b(obj, "");
        } catch (Throwable th) {
            a(obj, "playerViewPauseOrResumePlay", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void playerViewRelayout(Object obj, String str) {
        com.smartdigimkt.u1.d dVar = this.b;
        if (dVar == null || dVar.h == null) {
            com.smartdigimkt.k2.a.a(obj, "videoComponent empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("position_x", 0);
            int iOptInt2 = jSONObject.optInt("position_y", 0);
            int iOptInt3 = jSONObject.optInt("view_width", 0);
            int iOptInt4 = jSONObject.optInt("view_height", 0);
            int iOptInt5 = jSONObject.optInt("right_top_corner", 0);
            int iOptInt6 = jSONObject.optInt("right_bottom_corner", 0);
            com.smartdigimkt.q3.f.a().a(new e(this, obj, iOptInt, iOptInt2, iOptInt3, iOptInt4, jSONObject.optInt("left_top_corner", 0), iOptInt5, iOptInt6, jSONObject.optInt("left_bottom_corner", 0)));
        } catch (Throwable th) {
            a(obj, "playerViewRelayout", th);
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void playerViewRemove(Object obj, String str) {
        BasePlayerView basePlayerView;
        com.smartdigimkt.u1.d dVar = this.b;
        if (dVar == null || (basePlayerView = dVar.h) == null) {
            com.smartdigimkt.k2.a.a(obj, "videoComponent empty");
            return;
        }
        if (basePlayerView != null) {
            try {
                if (basePlayerView.getParent() != null) {
                    ((ViewGroup) dVar.h.getParent()).removeView(dVar.h);
                    dVar.h = null;
                }
            } catch (Throwable th) {
                a(obj, "playerViewRemove", th);
                return;
            }
        }
        com.smartdigimkt.k2.a.b(obj, "");
    }

    @Override // com.smartdigimkt.l2.b
    public final void renderSuccess(Object obj, String str) {
        if (obj instanceof com.smartdigimkt.k2.d) {
            try {
                WTWebView wTWebView = ((com.smartdigimkt.k2.d) obj).a;
                if (wTWebView != null) {
                    wTWebView.renderSuccess();
                    com.smartdigimkt.k2.a.b(obj, "");
                } else {
                    com.smartdigimkt.k2.a.a(obj, "WTWebView empty");
                }
            } catch (Throwable th) {
                a(obj, "renderSuccess", th);
            }
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void sendEventDA(Object obj, String str) {
        if (obj instanceof com.smartdigimkt.k2.d) {
            try {
                WTWebView wTWebView = ((com.smartdigimkt.k2.d) obj).a;
                if (wTWebView != null) {
                    wTWebView.sendEventDA(str);
                    com.smartdigimkt.k2.a.b(obj, "");
                } else {
                    com.smartdigimkt.k2.a.a(obj, "WTWebView empty");
                }
            } catch (Throwable th) {
                a(obj, "sendEventDA", th);
            }
        }
    }

    @Override // com.smartdigimkt.l2.b
    public final void showFeedbackDialog(Object obj, String str) {
        a aVar = this.a;
        if (aVar == null) {
            com.smartdigimkt.k2.a.a(obj, "bridgeListener empty");
        } else {
            aVar.b();
            com.smartdigimkt.k2.a.b(obj, "");
        }
    }
}
