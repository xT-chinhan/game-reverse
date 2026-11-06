package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr {
    protected lm ab;
    protected Map<String, Object> ao;
    protected com.bytedance.adsdk.ugeno.ah.sl ch;
    protected String hi;
    protected gy ny;
    protected String sl;
    protected AtomicBoolean u;
    protected String ub;
    protected Activity x;
    protected ms zb;

    public int ab() {
        return 0;
    }

    public void ah() {
    }

    public boolean c() {
        return true;
    }

    public void d() {
    }

    public void ka() {
    }

    public abstract String ms();

    protected float x() {
        return 0.55f;
    }

    public boolean xr() {
        return false;
    }

    public xr(Activity activity, lm lmVar) {
        this.zb = new ms(false, 0, "");
        this.u = new AtomicBoolean(false);
        this.x = activity;
        this.ab = lmVar;
    }

    public xr(Activity activity, lm lmVar, gy gyVar) {
        this(activity, lmVar);
        this.ny = gyVar;
    }

    public void ah(String str) {
        this.sl = str;
    }

    public void d(String str) {
        this.hi = str;
    }

    public ms xr(ch chVar) {
        return new ms(false, 0, "");
    }

    public ms ms(ch chVar) {
        return new ms(false, 0, "");
    }

    public void ms(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.ao;
        if (map2 == null) {
            this.ao = map;
        } else {
            map2.putAll(map);
        }
    }

    public void xr(String str) {
        this.ub = str;
    }

    protected String ny() {
        if (!TextUtils.isEmpty(this.ub)) {
            return this.ub;
        }
        return ms();
    }

    protected ms ah(final ch chVar) {
        if (!c()) {
            return new ms(false, 0, "");
        }
        final com.bytedance.sdk.openadsdk.core.widget.c cVar = new com.bytedance.sdk.openadsdk.core.widget.c(this.x);
        ms(cVar);
        final FrameLayout frameLayout = new FrameLayout(this.x);
        cVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (xr.this.ch != null) {
                    xr.this.ch.ms((ub) null);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.c.ms();
        msVar.ms(this.ny.d());
        msVar.xr(this.ny.ka());
        msVar.ah(this.ny.d());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms(msVar, new com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms
            public void ms(JSONObject jSONObject) {
                if (xr.this.u.get()) {
                    return;
                }
                if (jSONObject == null) {
                    xr.this.zb = new ms(false, 0, "");
                    countDownLatch.countDown();
                } else {
                    xr.this.ms(cVar, frameLayout, chVar, jSONObject);
                    xr.this.zb = new ms(true, xr.this.ab(), xr.this.ny.d(), cVar);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        this.u.set(true);
        return this.zb;
    }

    public void ms(final com.bytedance.sdk.openadsdk.core.widget.c cVar, final ViewGroup viewGroup, final ch chVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(ny());
        } catch (JSONException unused) {
            jSONObject2 = new JSONObject();
        }
        final View viewMs = ms(jSONObject, jSONObject2, new ub() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.3
            @Override // com.bytedance.adsdk.ugeno.ah.ub
            public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, com.bytedance.adsdk.ugeno.ka.c.ms msVar) {
            }

            @Override // com.bytedance.adsdk.ugeno.ah.ub
            public void ms(com.bytedance.adsdk.ugeno.ah.zb zbVar, ub.xr xrVar, ub.ms msVar) {
                JSONObject jSONObjectAh = zbVar.ah();
                if (jSONObjectAh == null) {
                    return;
                }
                String strOptString = jSONObjectAh.optString("type");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
                boolean zOptBoolean = jSONObjectAh.optBoolean("uchain", false);
                if (jSONObjectOptJSONObject != null && zOptBoolean && xr.this.ab != null) {
                    cVar.dismiss();
                    f.le();
                    com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(jSONObjectOptJSONObject);
                    HashMap map = new HashMap();
                    map.put("reward_dialog_callback", chVar);
                    new com.bytedance.sdk.component.hi.ms.xr.ms(strOptString).ms(xr.this.ab.rm()).ms(map).ms().ms();
                    return;
                }
                strOptString.hashCode();
                if (!strOptString.equals("exit_watch")) {
                    if (strOptString.equals("continue_watch")) {
                        cVar.dismiss();
                        xr.this.d(chVar);
                        return;
                    }
                    return;
                }
                cVar.dismiss();
                ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.xr();
                }
            }
        });
        if (viewMs == null) {
            return;
        }
        this.x.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.4
            @Override // java.lang.Runnable
            public void run() {
                viewGroup.addView(viewMs);
                xr xrVar = xr.this;
                xrVar.ms(cVar, viewMs, xrVar.x());
                cVar.ms(viewGroup);
                cVar.show();
            }
        });
    }

    protected void ms(com.bytedance.sdk.openadsdk.core.widget.c cVar) {
        cVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    protected void d(ch chVar) {
        if (chVar != null) {
            chVar.ms();
        }
    }

    public View ms(JSONObject jSONObject, JSONObject jSONObject2, ub ubVar) {
        com.bytedance.adsdk.ugeno.ah.sl slVar = new com.bytedance.adsdk.ugeno.ah.sl(this.x);
        this.ch = slVar;
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarMs = slVar.ms(jSONObject);
        this.ch.ms(ubVar);
        this.ch.xr(jSONObject2);
        if (ahVarMs == null) {
            return null;
        }
        return ahVarMs.ny();
    }

    public void ms(Dialog dialog, View view, float f) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.ab.od() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = ul.ah(this.x, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.ab.od() == 2) {
            view.setScaleX(f);
            view.setScaleY(f);
            view.setPivotY(0.0f);
            view.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, view.getMeasuredHeight());
            layoutParams.leftMargin = (int) (view.getMeasuredWidth() * (1.0f - f));
            layoutParams.topMargin = (int) Math.max(((ul.ka((Context) this.x) - (view.getMeasuredHeight() * f)) / 2.0f) - ul.hi((Context) this.x), ul.hi((Context) this.x));
            view.setLayoutParams(layoutParams);
        }
    }

    public static class ms {
        private String ah;
        private Dialog d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private boolean f2103ms;
        private int xr;

        public ms(boolean z, int i, String str, Dialog dialog) {
            this.f2103ms = z;
            this.xr = i;
            this.ah = str;
            this.d = dialog;
        }

        public ms(boolean z, int i, String str) {
            this(z, i, str, null);
        }

        public int ms() {
            return this.xr;
        }

        public String xr() {
            return this.ah;
        }

        public boolean ah() {
            return this.f2103ms;
        }

        public boolean d() {
            Dialog dialog = this.d;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public void ka() {
            Dialog dialog = this.d;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }
}
