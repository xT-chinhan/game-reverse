package com.smartdigimkt.sdk.basead.webtemplet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import com.anythink.core.common.f.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.b;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.k2.e;
import com.smartdigimkt.k2.g;
import com.smartdigimkt.k2.j;
import com.smartdigimkt.k2.k;
import com.smartdigimkt.k2.l;
import com.smartdigimkt.k2.m;
import com.smartdigimkt.k2.n;
import com.smartdigimkt.k2.o;
import com.smartdigimkt.k2.p;
import com.smartdigimkt.k2.q;
import com.smartdigimkt.k2.r;
import com.smartdigimkt.k2.t;
import com.smartdigimkt.k2.u;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.s4.d;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.basead.ui.web.BaseWebView;
import com.smartdigimkt.sdk.basead.webtemplet.adformat.WTCommonJSBridgePlugin;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.e0;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WTWebView extends BaseWebView {
    public static final /* synthetic */ int B = 0;
    public m A;
    public long c;
    public n d;
    public c e;
    public a f;
    public boolean g;
    public u h;
    public t i;
    public com.smartdigimkt.k2.c j;
    public Object k;
    public e l;
    public r m;
    public volatile boolean n;
    public volatile boolean o;
    public final Object p;
    public boolean q;
    public final List r;
    public volatile boolean s;
    public String t;
    public long u;
    public boolean v;
    public long w;
    public long x;
    public long y;
    public long z;

    public WTWebView(Context context) {
        super(context);
        this.c = 3000L;
        this.n = false;
        this.o = false;
        this.p = new Object();
        this.q = false;
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = false;
        this.t = "";
        this.v = false;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = new m(this);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.web.BaseWebView
    public final void a() {
        super.a();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        requestFocus();
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setTextZoom(100);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                settings.setSafeBrowsingEnabled(false);
            }
        } catch (Throwable unused) {
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        try {
            settings.setAllowUniversalAccessFromFileURLs(false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            settings.setMixedContentMode(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod(com.smartdigimkt.r4.e.a("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, 0);
        } catch (Throwable unused2) {
        }
        settings.setDatabaseEnabled(true);
        String str = SDKContext.getInstance().I;
        settings.setDatabasePath(str);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(str);
        try {
            Method declaredMethod2 = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(settings, Boolean.FALSE);
        } catch (Throwable unused3) {
        }
        try {
            Method declaredMethod3 = WebSettings.class.getDeclaredMethod(com.smartdigimkt.r4.e.a("c2V0QWxsb3dVbml2ZXJzYWxBY2Nlc3NGcm9tRmlsZVVSTHM="), Boolean.TYPE);
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(settings, Boolean.TRUE);
        } catch (Throwable unused4) {
        }
        t tVar = new t();
        this.i = tVar;
        tVar.b = new g(this);
        setWebChromeClient(this.i);
        u uVar = new u();
        this.h = uVar;
        uVar.b = new g(this);
        setWebViewClient(this.h);
        this.l = new e(this);
        setWebViewTransparent();
    }

    public final void b() {
        r rVar;
        synchronized (this.p) {
            if (this.n && this.o && (rVar = this.m) != null) {
                k kVar = ((j) rVar).a.c;
                if (kVar != null) {
                    kVar.a();
                }
                this.m = null;
            }
        }
    }

    public Object getJsCommunicationObject() {
        return this.k;
    }

    public Object getJsObject(String str) {
        e eVar = this.l;
        if (eVar == null) {
            return null;
        }
        if (e.b == null) {
            eVar.getClass();
            e.b = new HashMap();
        }
        WTWebView wTWebView = eVar.a;
        Class cls = (Class) e.b.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!WTCommonJSBridgePlugin.class.isAssignableFrom(cls)) {
                return null;
            }
            WTCommonJSBridgePlugin wTCommonJSBridgePlugin = (WTCommonJSBridgePlugin) cls.newInstance();
            wTCommonJSBridgePlugin.initialize(wTWebView);
            return wTCommonJSBridgePlugin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void h5ShowException(String str) {
        String strOptString;
        if (this.d != null) {
            com.smartdigimkt.m3.g.a().a(this.d);
            this.d = null;
        }
        int iOptInt = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            iOptInt = jSONObject.optInt("error_code", 0);
            strOptString = jSONObject.optString("error_message", "");
        } catch (Throwable unused) {
            strOptString = "unknown";
        }
        a(iOptInt == -999 ? 3 : 2, iOptInt + "," + strOptString);
        a(iOptInt + "", strOptString);
        com.smartdigimkt.k2.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this, iOptInt, strOptString, getUrl());
        }
    }

    public void initData(c cVar, a aVar, boolean z) {
        com.smartdigimkt.b3.e eVar;
        this.e = cVar;
        this.f = aVar;
        this.g = z;
        if (aVar == null || (eVar = aVar.s) == null) {
            return;
        }
        this.c = eVar.A1;
    }

    public boolean isPreload() {
        return this.g;
    }

    public void jsCallInitSuccess() {
        this.x = System.currentTimeMillis();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (TextUtils.isEmpty(this.t)) {
            this.t = str;
            this.u = System.currentTimeMillis();
            if (this.d == null) {
                this.d = new n(this);
                com.smartdigimkt.m3.g gVarA = com.smartdigimkt.m3.g.a();
                gVarA.a.a(this.d, this.c);
            }
        }
        super.loadUrl(str);
    }

    public void notifyInnerAdEvent(int i, Map<String, Object> map) {
        if (this.s) {
            f.a().a(new q(this, i, map), 0L, 2);
            return;
        }
        synchronized (this.r) {
            this.r.add(new l(i, map));
        }
    }

    public void offerDataInject() {
        c cVar;
        int i;
        this.y = System.currentTimeMillis();
        String string = "";
        try {
            Context context = getContext();
            if (context == null) {
                context = SDKContext.getInstance().d();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject(this.e.Q);
            if (SDMSDK.getInstance().isUseLocalLogo()) {
                String strA = a(context);
                if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strA)) {
                    try {
                        jSONObject2.put("tp_logo_u", strA);
                        jSONObject2.put("a_c_u", strA);
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("seatbid");
                        if (jSONArrayOptJSONArray != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                                if (jSONObjectOptJSONObject != null) {
                                    jSONObjectOptJSONObject.put("tp_logo_u", strA);
                                    jSONObjectOptJSONObject.put("a_c_u", strA);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            jSONObject.put(i.a.g, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            String str = this.e.f;
            if (!TextUtils.isEmpty(str)) {
                if (this.e.c() > 0 || this.e.b() > 0) {
                    jSONObject3.put("image_width", this.e.c());
                    jSONObject3.put("image_height", this.e.b());
                } else {
                    f.a().getClass();
                    if (!f.c()) {
                        e0.a().getClass();
                        int[] iArrA = d.a(e0.a(1, str));
                        if (iArrA != null) {
                            jSONObject3.put("image_width", iArrA[0]);
                            jSONObject3.put("image_height", iArrA[1]);
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(this.e.i) && (i = (cVar = this.e).G) > 0 && cVar.H > 0) {
                jSONObject3.put("video_width", i);
                jSONObject3.put("video_height", this.e.H);
            }
            jSONObject.put("material_info", jSONObject3);
            string = jSONObject.toString();
        } catch (Throwable unused2) {
        }
        com.smartdigimkt.o2.a.a().a(this, "offer_data_inject", string);
        this.z = System.currentTimeMillis();
        this.s = true;
        synchronized (this.r) {
            if (!this.r.isEmpty()) {
                for (l lVar : this.r) {
                    notifyInnerAdEvent(lVar.a, lVar.b);
                }
                this.r.clear();
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.web.BaseWebView, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.q) {
            return;
        }
        this.q = true;
        notifyInnerAdEvent(301, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("wt_view_width", Integer.valueOf(i));
            map.put("wt_view_height", Integer.valueOf(i2));
            notifyInnerAdEvent(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, map);
        } catch (Throwable unused) {
        }
    }

    public void prepare(r rVar) {
        this.m = rVar;
        getViewTreeObserver().addOnPreDrawListener(new o(this));
    }

    public void release() {
        try {
            if (this.d != null) {
                com.smartdigimkt.m3.g.a().a(this.d);
                this.d = null;
            }
            setVisibility(8);
            setDownloadListener(null);
            this.k = null;
            if (this.A != null) {
                this.A = null;
            }
            if (this.j != null) {
                this.j = null;
            }
            destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void renderSuccess() {
        if (this.d != null) {
            com.smartdigimkt.m3.g.a().a(this.d);
            this.d = null;
        }
        this.o = true;
        com.smartdigimkt.k2.c cVar = this.j;
        if (cVar != null) {
            cVar.b(this);
        }
        b();
        a(1, "");
        if (!this.e.i() || TextUtils.isEmpty(this.e.h)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("cta_text", this.e.h);
        notifyInnerAdEvent(121, map);
    }

    public void sendEventDA(String str) {
        f.a().c(new p(this, str));
    }

    public void setJsCommunicationObject(Object obj) {
        this.k = obj;
    }

    public void setWebViewListener(com.smartdigimkt.k2.c cVar) {
        this.j = cVar;
        t tVar = this.i;
        if (tVar != null) {
            tVar.a = this.A;
        }
        u uVar = this.h;
        if (uVar != null) {
            uVar.a = this.A;
        }
    }

    public void setWebViewTransparent() {
        setBackgroundColor(0);
        setBackgroundDrawable(null);
        setBackground(null);
    }

    public WTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 3000L;
        this.n = false;
        this.o = false;
        this.p = new Object();
        this.q = false;
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = false;
        this.t = "";
        this.v = false;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = new m(this);
    }

    public WTWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 3000L;
        this.n = false;
        this.o = false;
        this.p = new Object();
        this.q = false;
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = false;
        this.t = "";
        this.v = false;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = new m(this);
    }

    public static String a(Context context) {
        Bitmap bitmapDecodeResource;
        if (context == null) {
            return "";
        }
        try {
            int iA = com.smartdigimkt.r4.k.a(context, "myoffer_ad_logo_default", "drawable");
            if (iA == 0 || (bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), iA)) == null) {
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmapDecodeResource.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                bitmapDecodeResource.recycle();
                String strA = com.smartdigimkt.r4.e.a(byteArrayOutputStream.toByteArray());
                return TextUtils.isEmpty(strA) ? "" : "data:image/png;base64," + strA;
            } catch (Throwable th) {
                bitmapDecodeResource.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            th2.getMessage();
            return "";
        }
    }

    public final void a(String str, String str2) {
        com.smartdigimkt.l2.a aVar;
        Object obj = this.k;
        if (obj == null || !(obj instanceof com.smartdigimkt.l2.f) || (aVar = ((com.smartdigimkt.l2.f) obj).a) == null) {
            return;
        }
        aVar.a(str, str2);
    }

    public final synchronized void a(int i, String str) {
        if (!this.v && !this.a) {
            this.v = true;
            c cVar = this.e;
            a aVar = this.f;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.u;
            long j2 = jCurrentTimeMillis - j;
            long j3 = this.w;
            long j4 = this.x;
            long j5 = this.y;
            long j6 = this.z;
            String str2 = this.t;
            if (cVar != null && aVar != null) {
                com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
                cVar2.a = "1004762";
                cVar2.a(aVar);
                cVar2.l = cVar.a;
                if (cVar instanceof b) {
                    cVar2.m = ((b) cVar).c0;
                }
                cVar2.n = String.valueOf(i);
                cVar2.o = String.valueOf(j2);
                com.smartdigimkt.b3.e eVar = cVar.w;
                cVar2.p = eVar != null ? eVar.t1 : "";
                cVar2.q = eVar != null ? com.smartdigimkt.c0.j.a(new StringBuilder(), cVar.w.s1, "") : "";
                cVar2.r = cVar.w != null ? com.smartdigimkt.c0.j.a(new StringBuilder(), cVar.w.w1, "") : "";
                cVar2.s = cVar.w != null ? com.smartdigimkt.c0.j.a(new StringBuilder(), cVar.w.x1, "") : "";
                cVar2.t = str;
                cVar2.u = String.valueOf(j3);
                cVar2.v = String.valueOf(j4);
                cVar2.w = String.valueOf(j5);
                cVar2.x = String.valueOf(j6);
                cVar2.y = String.valueOf(j);
                cVar2.z = str2;
                cVar2.A = cVar.w != null ? com.smartdigimkt.c0.j.a(new StringBuilder(), cVar.w.y1, "") : "";
                com.smartdigimkt.n3.k.a(cVar2);
            }
        }
    }
}
