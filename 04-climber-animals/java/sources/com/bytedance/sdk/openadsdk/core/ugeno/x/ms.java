package com.bytedance.sdk.openadsdk.core.ugeno.x;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.ah.ao;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.ka.c;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.sdk.openadsdk.core.jw.re;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.ugeno.ab;
import com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView;
import com.bytedance.sdk.openadsdk.core.xr.xr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ao, ub {
    private xr ab;
    private com.bytedance.sdk.openadsdk.core.ugeno.c.ms ah;
    private com.bytedance.sdk.openadsdk.core.ugeno.d.ms c;
    private Map<String, Object> ch;
    private lm d;
    private ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f3574ms;
    private JSONObject ny;
    private hi x;
    private ViewGroup xr;

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(ah ahVar, String str, c.ms msVar) {
    }

    public ms(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar, lm lmVar) {
        this.f3574ms = context;
        this.xr = viewGroup;
        this.ah = msVar;
        this.d = lmVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.d.ms msVar) {
        this.c = msVar;
    }

    public void ms(DownloadListener downloadListener) {
        PageWebView.ms(this.ny, downloadListener);
    }

    public void ms() {
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar = this.ah;
        if (msVar == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.d.ms msVar2 = this.c;
            if (msVar2 != null) {
                msVar2.ms(-1);
                return;
            }
            return;
        }
        JSONObject jSONObjectMs = ab.ms().ms(msVar.ms(), this.ah.xr());
        if (jSONObjectMs == null) {
            com.bytedance.sdk.openadsdk.core.re.xr.ms(this.ah, new com.bytedance.sdk.openadsdk.core.re.xr.InterfaceC0306xr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.x.ms.1
                @Override // com.bytedance.sdk.openadsdk.core.re.xr.InterfaceC0306xr
                public void ms(JSONObject jSONObject) {
                    ms.this.ms(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.re.xr.InterfaceC0306xr
                public void ms() {
                    if (ms.this.c != null) {
                        ms.this.c.ms(-1);
                    }
                }
            });
        } else {
            ms(jSONObjectMs);
        }
    }

    public void ms(final JSONObject jSONObject) {
        final sl slVar = new sl(this.f3574ms);
        final JSONObject jSONObjectRm = this.d.rm();
        this.ny = jSONObjectRm;
        com.bytedance.adsdk.ugeno.ah.hi hiVar = new com.bytedance.adsdk.ugeno.ah.hi();
        hiVar.ms(this.f3574ms);
        HashMap map = new HashMap();
        map.put("key_reward_page", this.ch);
        hiVar.ms(map);
        slVar.ms("reward_page", hiVar);
        slVar.ms((ub) this);
        nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.x.ms.2
            @Override // java.lang.Runnable
            public void run() {
                ms.this.ka = slVar.ms(jSONObject);
                if (ms.this.ka == null) {
                    if (ms.this.c != null) {
                        ms.this.c.ms(-1);
                    }
                } else {
                    slVar.xr(jSONObjectRm);
                    ms.this.xr.addView(ms.this.ka.ny(), new FrameLayout.LayoutParams(ms.this.ka.pc(), ms.this.ka.jw()));
                    if (ms.this.c != null) {
                        ms.this.c.ms(ms.this.ka.ny());
                    }
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        if (zbVar != null && zbVar.xr() == 1) {
            ms(zbVar, zbVar.ah());
        }
    }

    private void ms(zb zbVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (!strOptString.equals("clickEvent")) {
            if (strOptString.equals("openPolicy")) {
                com.bytedance.sdk.openadsdk.core.jw.c.ms(this.f3574ms, this.d);
            }
        } else {
            xr xrVar = this.ab;
            if (xrVar != null) {
                xrVar.ms(zbVar.ms().ny(), this.x);
            }
        }
    }

    public void ms(xr xrVar) {
        this.ab = xrVar;
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ao
    public void ms(ah ahVar, MotionEvent motionEvent) {
        this.x.ah(motionEvent.getDeviceId());
        this.x.xr(motionEvent.getToolType(0));
        this.x.d(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.x.ah(motionEvent.getRawX());
                this.x.d(motionEvent.getRawY());
                this.x.xr(System.currentTimeMillis());
                return;
            } else {
                if (actionMasked != 2) {
                    return;
                }
                this.x.ah(motionEvent.getRawX());
                this.x.d(motionEvent.getRawY());
                return;
            }
        }
        this.x.ka((int) motionEvent.getRawX());
        this.x.c((int) motionEvent.getRawY());
        this.x.ms(motionEvent.getRawX());
        this.x.xr(motionEvent.getRawY());
        this.x.ms(System.currentTimeMillis());
        this.x.xr(motionEvent.getToolType(0));
        this.x.ah(motionEvent.getDeviceId());
        this.x.d(motionEvent.getSource());
        this.x.ms(true);
        re.ms(motionEvent);
    }

    public void ms(Map<String, Object> map) {
        this.ch = map;
    }

    public void xr() {
        PageWebView.ms(this.ny);
    }
}
