package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.dislike.ui.ms;
import com.bytedance.sdk.openadsdk.core.hi.ah.ka;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import com.bytedance.sdk.openadsdk.core.ugeno.ny.d;
import com.bytedance.sdk.openadsdk.core.ugeno.ny.xr;
import com.bytedance.sdk.openadsdk.core.zb.ah;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.umeng.analytics.pro.cl;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTNativePageActivity extends BaseLandingPageActivity implements le.ms {
    private static WeakReference<ka> ab;
    private TTViewStub ao;
    private d b;
    ms c;
    private TextView ch;
    private int cv;
    private int g;
    private ImageView h;
    private TextView hi;
    private com.bytedance.sdk.openadsdk.core.ugeno.ah.ms i;
    private boolean le;
    private FrameLayout nw;
    private ImageView ny;
    private boolean op;
    private long p;
    private com.bytedance.sdk.openadsdk.core.zb.ka qv;
    private xr re;
    private Context sl;
    private Activity t;
    private TTViewStub u;
    private TTViewStub ub;
    private boolean w;
    private ImageView x;
    private FrameLayout yu;
    private TTViewStub zb;
    private AtomicBoolean y = new AtomicBoolean(true);
    private boolean of = true;
    private final le pc = new le(Looper.getMainLooper(), this);
    private String jw = "立即下载";

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ka == null) {
            return;
        }
        setRequestedOrientation(1);
        this.t = this;
        this.sl = this;
        getWindow().addFlags(1024);
        try {
            re.ms(this.t);
        } catch (Throwable th) {
            sl.ms(th);
        }
        setContentView(com.bytedance.sdk.openadsdk.res.ka.f(this.sl));
        this.p = System.currentTimeMillis();
        String stringExtra = getIntent().getStringExtra("title");
        ka();
        c();
        ch();
        if (this.ka != null && this.ka.ca() != null) {
            this.ka.ca().ms("landing_page");
        }
        com.bytedance.sdk.openadsdk.core.zb.ka kaVar = new com.bytedance.sdk.openadsdk.core.zb.ka(this.ka);
        this.qv = kaVar;
        kaVar.ms(true);
        this.qv.ms();
        if (this.ka != null) {
            ab();
        }
        TextView textView = this.ch;
        if (textView != null && !this.op && !this.le) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = t.ms(this.t, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        xr(4);
        ah.ms(this.ka, getClass().getName());
        if (this.op || this.le) {
            zb();
        }
    }

    private void ka() {
        if (this.ka == null || this.ka.op() == null || this.ka.op().d() != 3) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.playable.xr.ms().ms(this.ka);
    }

    private void c() {
        this.le = qf.y(this.ka);
        this.op = qf.qv(this.ka);
        if (this.le) {
            if (com.bytedance.sdk.openadsdk.core.x.d.d) {
                if (this.op) {
                    this.le = false;
                    return;
                }
                return;
            }
            this.op = false;
        }
    }

    private void ab() {
        if (ch.x(this.ka)) {
            com.bytedance.sdk.openadsdk.core.ugeno.ah.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.ah.ms(this, this.nw, this.qv, this.ka, this.ah, this.d, x());
            this.i = msVar;
            msVar.ms(new com.bytedance.sdk.openadsdk.core.ugeno.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
                public void ms(View view) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
                public void ms(int i) {
                    TTNativePageActivity.this.ms(i);
                }
            });
            this.i.ms();
            return;
        }
        ny();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        Intent intent;
        WeakReference<ka> weakReference;
        Intent intent2 = getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.getBooleanExtra("is_replace_dialog", false) && (weakReference = ab) != null && weakReference.get() != null) {
            ab.get().c(false);
            ab.get().xr(f.y(this.ka), false);
            ab = null;
        } else {
            if (lm.xr(this.ka) && f.ka(this.ka)) {
                intent = new Intent(this, (Class<?>) TTVideoWebPageActivity.class);
            } else {
                intent = new Intent(this, (Class<?>) TTWebPageActivity.class);
            }
            intent.putExtras(intent2);
            try {
                com.bytedance.sdk.component.utils.xr.ms(this.t, intent, null);
            } catch (Throwable th) {
                sl.xr("TTNativePageActivity", th);
            }
        }
        finish();
    }

    private com.bytedance.sdk.openadsdk.core.multipro.xr.ms x() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.core.multipro.xr.ms.ms(new JSONObject(stringExtra));
        } catch (JSONException e) {
            sl.ms(e);
            return null;
        }
    }

    private void ny() {
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVarOp = this.ka.op();
        if (msVarOp == null) {
            return;
        }
        int iD = msVarOp.d();
        if (iD == 2) {
            d dVar = new d(this.sl, this.nw, this.qv, this.ka, this.ah, this.d);
            this.b = dVar;
            dVar.zb();
            return;
        }
        if (iD == 3) {
            xr xrVar = new xr(this.sl, this.nw, this.qv, this.ka, this.ah, this.d);
            this.re = xrVar;
            xrVar.xr(false);
            this.re.zb();
            if (TextUtils.equals(msVarOp.ms(), "3")) {
                return;
            }
            final ImageView imageView = new ImageView(this.sl);
            float fAh = ul.ah(this.sl, 18.0f);
            float fAh2 = ul.ah(this.sl, 18.0f);
            int i = (int) fAh;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 53;
            int i2 = (int) fAh2;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.yu.addView(imageView, layoutParams);
            t.ms(this.sl, "tt_unmute", imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity tTNativePageActivity = TTNativePageActivity.this;
                    tTNativePageActivity.w = !tTNativePageActivity.w;
                    t.ms(TTNativePageActivity.this.sl, TTNativePageActivity.this.w ? "tt_mute" : "tt_unmute", imageView);
                    TTNativePageActivity.this.re.ah(TTNativePageActivity.this.w);
                }
            });
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void ch() {
        TTViewStub tTViewStub;
        this.yu = (FrameLayout) findViewById(2114387640);
        this.nw = (FrameLayout) findViewById(2114387726);
        this.ao = (TTViewStub) findViewById(2114387956);
        this.zb = (TTViewStub) findViewById(2114387776);
        this.u = (TTViewStub) findViewById(2114387798);
        TTViewStub tTViewStub2 = (TTViewStub) findViewById(2114387939);
        this.ub = tTViewStub2;
        if (this.op || this.le) {
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.h = (ImageView) findViewById(2114387849);
        } else {
            int iOp = com.bytedance.sdk.openadsdk.core.ch.ub().op();
            if (iOp == 0) {
                TTViewStub tTViewStub3 = this.zb;
                if (tTViewStub3 != null) {
                    tTViewStub3.setVisibility(0);
                }
            } else if (iOp == 1 && (tTViewStub = this.u) != null) {
                tTViewStub.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387711);
        this.x = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387710);
        this.ny = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.ch = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387633);
        this.hi = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.ms();
                }
            });
        }
    }

    private boolean hi() {
        return this.op || this.le;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.bytedance.sdk.openadsdk.core.zb.ka kaVar = this.qv;
        if (kaVar != null) {
            kaVar.ah();
        }
        d();
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ms msVar = this.i;
        if (msVar != null) {
            msVar.ah();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.zb.ka kaVar = this.qv;
        if (kaVar != null) {
            kaVar.ms(0);
        }
        if (this.of) {
            this.of = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.p);
                jSONObject.put(cl.s, System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, this.ka);
            } catch (JSONException e) {
                sl.ms(e);
            }
            ah.ms(this.ka, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.bytedance.sdk.openadsdk.c.ms.ms
                public void ms(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ms msVar = this.i;
        if (msVar != null) {
            msVar.xr();
        }
        ah();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    private boolean sl() {
        return lm.ah(this.ka);
    }

    private void xr(int i) {
        if (sl()) {
            ul.ms((View) this.ny, 4);
        } else {
            if (this.ny == null || !sl()) {
                return;
            }
            ul.ms((View) this.ny, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ah.ms msVar = this.i;
        if (msVar != null) {
            msVar.d();
        }
        xr xrVar = this.re;
        if (xrVar != null) {
            xrVar.ao();
        }
        com.bytedance.sdk.openadsdk.core.zb.ka kaVar = this.qv;
        if (kaVar != null) {
            kaVar.d();
        }
    }

    protected void ms() {
        if (this.ka == null || isFinishing()) {
            return;
        }
        if (this.c == null) {
            xr();
        }
        this.c.ms();
    }

    void xr() {
        ms msVar = new ms(this.t, this.ka.ca(), this.ah, true);
        this.c = msVar;
        com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.t, msVar, this.ka);
        this.c.ms(new ms.InterfaceC0288ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void ms() {
                TTNativePageActivity.this.ah();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void ms(int i, String str, boolean z) {
                TTNativePageActivity.this.d();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void xr() {
                TTNativePageActivity.this.d();
            }
        });
    }

    private void zb() {
        this.cv = 0;
        if (this.op) {
            this.cv = com.bytedance.sdk.openadsdk.core.x.d.f3760ms;
        } else if (this.le && !com.bytedance.sdk.openadsdk.core.x.d.d) {
            this.cv = qf.u(this.ka);
        }
        ah(this.cv);
        if (this.cv > 0 && !this.pc.hasMessages(10)) {
            if (this.op) {
                this.pc.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.le) {
                this.pc.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private void ah(int i) {
        if (i > 0) {
            if (this.op) {
                ul.ms(this.ch, i + "s后可领取奖励");
                return;
            } else {
                if (this.le) {
                    SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                    spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
                    ul.ms(this.ch, spannableString);
                    return;
                }
                return;
            }
        }
        if (this.op) {
            ul.ms(this.ch, "领取成功");
        } else if (this.le) {
            ul.ms((View) this.h, 8);
            ul.ms(this.ch, "恭喜你！福利已领取");
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what == 10 && hi()) {
            int i = this.g + 1;
            this.g = i;
            if (this.op) {
                com.bytedance.sdk.openadsdk.core.x.d.xr = i;
            }
            int iMax = Math.max(0, this.cv - this.g);
            ah(iMax);
            if (iMax <= 0 && this.le) {
                com.bytedance.sdk.openadsdk.core.x.d.d = true;
            }
            this.pc.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    public void ah() {
        if (hi()) {
            this.pc.removeMessages(10);
        }
    }

    public void d() {
        if (!hi() || this.pc.hasMessages(10)) {
            return;
        }
        this.pc.sendEmptyMessageDelayed(10, 1000L);
    }

    public static void ms(ka kaVar) {
        ab = new WeakReference<>(kaVar);
    }
}
