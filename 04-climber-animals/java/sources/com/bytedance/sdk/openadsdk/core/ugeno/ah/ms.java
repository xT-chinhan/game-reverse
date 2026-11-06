package com.bytedance.sdk.openadsdk.core.ugeno.ah;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.e.a;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.jw.c;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.d;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.ab.ab;
import com.bytedance.sdk.openadsdk.core.zb.ka;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements xr.ms {
    private Activity ab;
    protected com.bytedance.sdk.openadsdk.core.ugeno.d.ms ah;
    private com.bytedance.sdk.openadsdk.core.multipro.xr.ms ao;
    private ka c;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ch;
    protected String d;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms h = new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.ms.8
        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ah(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(long j, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void xr(long j, long j2, String str, String str2) {
        }
    };
    private JSONObject hi;
    protected int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected lm f3401ms;
    private com.bytedance.adsdk.ugeno.xr.ah ny;
    private d sl;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr u;
    private com.bytedance.adsdk.ugeno.widget.image.xr ub;
    private ViewGroup x;
    protected xr xr;
    private String zb;

    protected void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
    }

    protected void ms(JSONObject jSONObject) {
    }

    public ms(Activity activity, ViewGroup viewGroup, ka kaVar, lm lmVar, String str, int i, com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar) {
        this.f3401ms = lmVar;
        this.ab = activity;
        this.c = kaVar;
        this.x = viewGroup;
        this.d = str;
        this.ka = i;
        this.ao = msVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.d.ms msVar) {
        this.ah = msVar;
    }

    public void ms() {
        this.xr = new xr(this.ab, this.c, this.d, this.ka);
        if (this.f3401ms.b() != null) {
            try {
                xr(new JSONObject(this.f3401ms.b().toString()));
                return;
            } catch (JSONException e) {
                sl.ms(e);
                return;
            }
        }
        int iQv = this.f3401ms.qv();
        if (iQv == 5 || iQv == 4) {
            xr(new JSONObject());
        } else {
            com.bytedance.sdk.openadsdk.core.re.xr.ms(this.f3401ms.h(), new com.bytedance.sdk.openadsdk.core.re.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.ms.1
                @Override // com.bytedance.sdk.openadsdk.core.re.xr.ms
                public void ms(JSONObject jSONObject) {
                    ms.this.xr(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.re.xr.ms
                public void ms(int i, String str) {
                    ms.this.c.ms(-3, "ad meta info load fail");
                    if (ms.this.ah != null) {
                        ms.this.ah.ms(-3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(JSONObject jSONObject) {
        this.hi = jSONObject;
        d(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms(this.f3401ms.y(), "lp_" + this.f3401ms.qv(), this.f3401ms.t(), new com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms
            public void ms(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    ms.this.c.ms(-1, "template info load fail");
                    if (ms.this.ah != null) {
                        ms.this.ah.ms(-1);
                        return;
                    }
                    return;
                }
                try {
                    jSONObject.put("creative", ms.this.f3401ms.rm());
                    ms.this.ms(jSONObject);
                    ms.this.ms(jSONObject2, jSONObject);
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(JSONObject jSONObject, JSONObject jSONObject2) {
        this.c.xr();
        this.xr.ms(this);
        this.xr.ms(jSONObject, jSONObject2, new ab() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.ms.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(int i, String str) {
                if (ms.this.ah != null) {
                    ms.this.ah.ms(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                ms.this.ny = ahVar;
                ms.this.x.addView(ahVar.ny(), new FrameLayout.LayoutParams(ahVar.pc(), ahVar.jw()));
                if (ms.this.ah != null) {
                    ms.this.ah.ms(ahVar.ny());
                }
                ms.this.ka();
                ms.this.ms(ahVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        lm lmVar = this.f3401ms;
        if (lmVar == null || qr.ny(lmVar) != 200) {
            return;
        }
        com.bytedance.adsdk.ugeno.xr.ah ahVarAh = this.ny.ah("video");
        if (ahVarAh instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) ahVarAh;
            this.u = xrVar;
            xrVar.ka(true);
            ny();
        }
        com.bytedance.adsdk.ugeno.xr.ah ahVarAh2 = this.ny.ah("mute");
        if (ahVarAh2 instanceof com.bytedance.adsdk.ugeno.widget.image.xr) {
            this.ub = (com.bytedance.adsdk.ugeno.widget.image.xr) ahVarAh2;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
            shapeDrawable.setIntrinsicWidth(ul.ah(this.ab, 28.0f));
            shapeDrawable.setIntrinsicHeight(ul.ah(this.ab, 28.0f));
            this.ub.ny().setBackground(shapeDrawable);
        }
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = this.ao;
        if (msVar != null) {
            ms(msVar.x);
        } else {
            ms(true);
        }
    }

    private void ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = this.u;
        if (xrVar != null) {
            xrVar.d(z);
        }
        com.bytedance.adsdk.ugeno.widget.image.xr xrVar2 = this.ub;
        if (xrVar2 == null || xrVar2.ny() == null) {
            return;
        }
        t.ms((Context) this.ab, z ? "tt_mute" : "tt_unmute", (ImageView) this.ub.ny());
    }

    private void d(final JSONObject jSONObject) {
        if (this.sl != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.sl.c());
                jSONObject2.put("is_support_func_desc", "true");
                jSONObject.put(a.C0080a.c, jSONObject2);
                ah(jSONObject);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String strC = c();
        this.zb = strC;
        if (TextUtils.isEmpty(strC)) {
            com.bytedance.sdk.openadsdk.core.ugeno.d.ms msVar = this.ah;
            if (msVar != null) {
                msVar.ms(-4);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.ch.ab.xr(new ny("tt_pl_download_check") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.ms.4
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3;
                ms.this.sl = re.ms().ms(ms.this.f3401ms, ms.this.zb);
                try {
                    if (ms.this.sl != null) {
                        jSONObject3 = new JSONObject(ms.this.sl.c());
                    } else if (ms.this.f3401ms.zx() != null) {
                        jSONObject3 = new JSONObject(ms.this.f3401ms.zx());
                    } else {
                        jSONObject3 = new JSONObject();
                    }
                    jSONObject3.put("is_support_func_desc", "true");
                    jSONObject.put(a.C0080a.c, jSONObject3);
                    jSONObject3.put("download_url", ms.this.zb);
                    ms.this.ah(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ah.xr.ms
    public void ms(zb zbVar) {
        JSONObject jSONObjectAh;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar;
        if (zbVar == null || zbVar.xr() != 1 || (jSONObjectAh = zbVar.ah()) == null) {
            return;
        }
        String strOptString = jSONObjectAh.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                ms(this.f3401ms);
                break;
            case "clickVideo":
                com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar2 = this.u;
                if (xrVar2 != null) {
                    xrVar2.qk();
                    break;
                }
                break;
            case "openAppFunctionDesc":
                ah(this.f3401ms);
                break;
            case "downloadEvent":
                xr(true);
                d(xr(zbVar));
                break;
            case "downloadDirect":
                ah(xr(zbVar));
                break;
            case "muteVideo":
                if (this.ub != null && (xrVar = this.u) != null) {
                    ms(!xrVar.x());
                    break;
                }
                break;
            case "openAppPolicy":
                xr(this.f3401ms);
                break;
            case "openInfringement":
                c.ms(this.ab, this.d, this.f3401ms);
                break;
        }
    }

    private void xr(boolean z) {
        x();
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ch;
        if (ahVar instanceof com.bytedance.sdk.openadsdk.core.hi.ah.sl) {
            ((com.bytedance.sdk.openadsdk.core.hi.ah.sl) ahVar).xr().ms(z);
        }
    }

    private void ah(boolean z) {
        xr(false);
        d(z);
    }

    private boolean xr(zb zbVar) {
        if (zbVar == null) {
            return false;
        }
        View viewNy = zbVar.ms().ny();
        if (!(viewNy instanceof TextView)) {
            return false;
        }
        CharSequence text = ((TextView) viewNy).getText();
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return text.toString().contains("下载");
    }

    private void ms(lm lmVar) {
        String strZx;
        if (lmVar == null) {
            return;
        }
        if (this.sl != null) {
            com.bytedance.sdk.openadsdk.core.nw.c cVarPh = lmVar.ph();
            if (cVarPh != null) {
                this.sl.ms(cVarPh.d());
                this.sl.ms(cVarPh.ah());
            }
            strZx = this.sl.c();
        } else {
            strZx = lmVar.zx();
        }
        Activity activity = this.ab;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).ah();
        }
        c.ms(this.ab, lmVar.df(), strZx, new c.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.ms.5
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                ms.this.d(true);
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }
        });
    }

    private void xr(lm lmVar) {
        String strZx;
        if (lmVar == null) {
            return;
        }
        if (this.sl != null) {
            com.bytedance.sdk.openadsdk.core.nw.c cVarPh = lmVar.ph();
            if (cVarPh != null) {
                this.sl.ms(cVarPh.d());
                this.sl.ms(cVarPh.ah());
            }
            strZx = this.sl.c();
        } else {
            strZx = lmVar.zx();
        }
        Activity activity = this.ab;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).ah();
        }
        c.ms(this.ab, lmVar.df(), new c.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.ms.6
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                ms.this.d(true);
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }
        }, strZx);
    }

    private void ah(lm lmVar) {
        String strNy;
        if (lmVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nw.c cVarPh = lmVar.ph();
        d dVar = this.sl;
        if (dVar != null) {
            strNy = dVar.d();
        } else {
            strNy = cVarPh == null ? "" : cVarPh.ny();
        }
        c.xr(this.ab, strNy, lmVar.df(), new c.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.ms.7
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                ms.this.d(true);
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                if (ms.this.ab instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) ms.this.ab).d();
                }
            }
        });
    }

    private String c() {
        JSONObject jSONObject = this.hi;
        if (jSONObject == null) {
            return ab();
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("download_buttons");
        if (jSONArrayOptJSONArray == null) {
            return ab();
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return ab();
        }
        String strOptString = jSONObjectOptJSONObject.optString("url");
        return TextUtils.isEmpty(strOptString) ? ab() : strOptString;
    }

    private String ab() {
        return f.ao(this.f3401ms);
    }

    private void x() {
        if (this.ch == null) {
            com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = com.bytedance.sdk.openadsdk.core.hi.ka.ms(this.ab, this.zb, this.f3401ms, this.d);
            this.ch = ahVarMs;
            ahVarMs.ms(ub.ms(this.f3401ms));
            this.ch.ms(this.h, false);
            this.ch.c(false);
        }
        this.ch.ms(this.ab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        x();
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.ab, this.f3401ms, "embeded_ad_landingpage", this.ka);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(true);
        this.ch.xr(z);
        this.ch.ms(this.f3401ms, false);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ch);
        this.ch.xr(f.y(this.f3401ms), false);
    }

    public void xr() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = this.u;
        if (xrVar != null) {
            xrVar.tz();
        }
    }

    private void ny() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = this.u;
        if (xrVar != null) {
            xrVar.ms(this.ao);
        }
    }

    public void ah() {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ch;
        if (ahVar != null) {
            ahVar.x();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = this.u;
        if (xrVar != null) {
            xrVar.sa();
        }
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ch;
        if (ahVar != null) {
            ahVar.ny();
        }
    }
}
