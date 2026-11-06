package com.anythink.basead.mraid;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.api.push.ILivePush;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    protected static final String a = "MraidJSBridge";
    public static int d = 1500;
    protected Context b;
    protected MraidBaseWebView c;
    private com.anythink.core.express.b.b e;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Context context, MraidBaseWebView mraidBaseWebView) {
        this.b = context;
        this.c = mraidBaseWebView;
        try {
            if (context instanceof com.anythink.core.express.b.b) {
                this.e = (com.anythink.core.express.b.b) context;
                return;
            }
            if (mraidBaseWebView.getObject() != null && (mraidBaseWebView.getObject() instanceof com.anythink.core.express.b.b)) {
                this.e = (com.anythink.core.express.b.b) mraidBaseWebView.getObject();
            }
            if (mraidBaseWebView.getMraidObject() == null || !(mraidBaseWebView.getMraidObject() instanceof com.anythink.core.express.b.b)) {
                return;
            }
            this.e = (com.anythink.core.express.b.b) mraidBaseWebView.getMraidObject();
        } catch (Exception unused) {
        }
    }

    public final void a(String str) {
        MraidBaseWebView mraidBaseWebView = this.c;
        com.anythink.core.express.b.a.a();
        com.anythink.core.express.b.a.a(mraidBaseWebView, "open");
        try {
            String strOptString = new JSONObject(str).optString("url");
            if (this.e == null || TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.e.open(strOptString);
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        com.anythink.core.express.b.a.a();
        com.anythink.core.express.b.a.a(this.c, ILivePush.ClickType.CLOSE);
        try {
            com.anythink.core.express.b.b bVar = this.e;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        com.anythink.core.express.b.a.a();
        com.anythink.core.express.b.a.a(this.c, "unload");
        try {
            com.anythink.core.express.b.b bVar = this.e;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(String str) {
        com.anythink.core.express.b.a.a();
        com.anythink.core.express.b.a.a(this.c, "useCustomClose");
        try {
            String strOptString = new JSONObject(str).optString("shouldUseCustomClose");
            if (TextUtils.isEmpty(strOptString) || this.e == null) {
                return;
            }
            this.e.useCustomClose(strOptString.toLowerCase().equals("true"));
        } catch (Throwable unused) {
        }
    }

    public final void c(String str) {
        com.anythink.core.express.b.a.a();
        com.anythink.core.express.b.a.a(this.c, "expand");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            String strOptString2 = jSONObject.optString("shouldUseCustomClose");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || this.e == null) {
                return;
            }
            this.e.expand(strOptString, strOptString2.toLowerCase().equals("true"));
        } catch (Throwable unused) {
        }
    }

    private void d(String str) {
        com.anythink.core.express.b.a.a();
        com.anythink.core.express.b.a.a(this.c, "setOrientationProperties");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("allowOrientationChange");
            String strOptString2 = jSONObject.optString("forceOrientation");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && this.e != null) {
                strOptString.toLowerCase().equals("true");
                String lowerCase = strOptString2.toLowerCase();
                int iHashCode = lowerCase.hashCode();
                if (iHashCode == 729267099) {
                    lowerCase.equals("portrait");
                } else if (iHashCode == 1430647483) {
                    lowerCase.equals("landscape");
                }
            }
        } catch (Throwable unused) {
        }
    }
}
