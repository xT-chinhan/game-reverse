package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.anythink.core.common.d.j;
import com.bytedance.adsdk.ugeno.ah.qv;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UGenVideoOrImgPanelView extends NativeExpressView {
    private final NativeVideoTsView ah;
    private View b;
    private final View d;
    private final Context i;
    private final CopyOnWriteArrayList<Message> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final lm f3605ms;
    private final ms nw;
    private boolean op;
    private ViewGroup re;
    private final AtomicBoolean w;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.d xr;
    private volatile boolean yu;

    public UGenVideoOrImgPanelView(Context context, lm lmVar, NativeVideoTsView nativeVideoTsView, View view, ViewGroup viewGroup, String str, boolean z) {
        super(context, lmVar, new com.bytedance.sdk.openadsdk.ao.xr.ah.xr(null), str);
        this.ka = new CopyOnWriteArrayList<>();
        ms msVar = new ms(Looper.getMainLooper());
        this.nw = msVar;
        this.w = new AtomicBoolean(true);
        this.yu = false;
        this.op = false;
        this.i = context;
        this.f3605ms = lmVar;
        this.ah = nativeVideoTsView;
        this.d = view;
        this.re = viewGroup;
        msVar.ms(this);
        this.op = z;
        u();
    }

    public void u() {
        lm lmVar;
        JSONObject jSONObjectWe;
        JSONArray jSONArrayOptJSONArray;
        if (this.w.getAndSet(false) && (lmVar = this.f3605ms) != null) {
            if ((this.ah == null && this.d == null) || lmVar.kz() == 166 || (jSONObjectWe = this.f3605ms.we()) == null || (jSONArrayOptJSONArray = jSONObjectWe.optJSONArray("components")) == null) {
                return;
            }
            this.y = re.xr().d(f.ny(this.f3605ms));
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                final int iOptInt = jSONObjectOptJSONObject.optInt("render_sequence");
                final int iOptInt2 = jSONObjectOptJSONObject.optInt("displayAreaAndroid");
                String strOptString = jSONObjectOptJSONObject.optString("ugen_md5");
                String strOptString2 = jSONObjectOptJSONObject.optString("ugen_url");
                final String strOptString3 = jSONObjectOptJSONObject.optString("ugen_id");
                JSONObject jSONObjectXr = ch.xr(strOptString, strOptString2);
                if (jSONObjectXr != null && jSONObjectXr.length() > 0) {
                    ms(jSONObjectXr, iOptInt2, strOptString3, iOptInt);
                } else {
                    ch.ms(strOptString, strOptString2, new com.bytedance.sdk.openadsdk.core.ugeno.ah() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.1
                        @Override // com.bytedance.sdk.openadsdk.core.ugeno.ah
                        public void ms(String str) {
                            try {
                                UGenVideoOrImgPanelView.this.ms(new JSONObject(str), iOptInt2, strOptString3, iOptInt);
                            } catch (Throwable th) {
                                sl.ms(th);
                            }
                        }
                    });
                }
            }
        }
    }

    public static boolean ms(lm lmVar) {
        JSONObject jSONObjectWe;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        return (lmVar == null || (jSONObjectWe = lmVar.we()) == null || (jSONArrayOptJSONArray = jSONObjectWe.optJSONArray("components")) == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || TextUtils.isEmpty(jSONObjectOptJSONObject.optString("ugen_url"))) ? false : true;
    }

    public void setAdSlot(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.x = xrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final JSONObject jSONObject, final int i, final String str, final int i2) {
        if (jSONObject == null) {
            return;
        }
        NativeVideoTsView nativeVideoTsView = this.ah;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.2
                @Override // java.lang.Runnable
                public void run() {
                    UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                    uGenVideoOrImgPanelView.ms(uGenVideoOrImgPanelView.ah, jSONObject, i, str, i2);
                }
            });
            return;
        }
        View view = this.d;
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 0) {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView.ms(uGenVideoOrImgPanelView.re, jSONObject, i, str, i2);
                    } else {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView2.ms(uGenVideoOrImgPanelView2.d, jSONObject, i, str, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(View view, JSONObject jSONObject, int i, String str, int i2) {
        if (i2 == 3) {
            jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(this.f3605ms, com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(view), jSONObject, this.op);
        }
        JSONObject jSONObjectMs = ch.ms(this.f3605ms, view, this.op);
        if (jSONObjectMs != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObjectMs.put("ugen_id", str);
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.xr.ms();
        msVar.ka(jSONObjectMs);
        msVar.ms(jSONObject);
        msVar.ms((qv) new t());
        msVar.xr(view.getHeight());
        msVar.ms(view.getWidth());
        msVar.ms(com.bytedance.sdk.openadsdk.core.ch.ub().ka());
        msVar.ch(this.f3605ms.ka());
        com.bytedance.sdk.openadsdk.core.ugeno.express.xr xrVarMs = msVar.ms();
        if (i2 == 3) {
            this.xr = new com.bytedance.sdk.openadsdk.core.ugeno.express.c(this.i, this.f3605ms, xrVarMs, this.re);
        } else {
            this.xr = new com.bytedance.sdk.openadsdk.core.ugeno.express.d(this.i, this.f3605ms, xrVarMs, this.re);
        }
        this.xr.ms(this);
        ah(i, str);
    }

    private void ah(final int i, final String str) {
        this.xr.ms(new com.bytedance.sdk.component.adexpress.xr.ab() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.4
            @Override // com.bytedance.sdk.component.adexpress.xr.ab
            public void ms(View view, u uVar) {
                View childAt;
                if ((UGenVideoOrImgPanelView.this.ah == null && UGenVideoOrImgPanelView.this.d == null) || view == null) {
                    return;
                }
                UGenVideoOrImgPanelView.this.b = view;
                boolean zMs = UGenVideoOrImgPanelView.this.ms(view, i);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (viewGroup.getChildCount() > 0 && (childAt = viewGroup.getChildAt(0)) != null && childAt.getVisibility() == 8) {
                        HashMap map = new HashMap();
                        map.put("error_code", 105);
                        map.put(j.w.E, 1);
                        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ch.ms(UGenVideoOrImgPanelView.this.f3605ms, false, str, 3, (Map<String, Object>) map);
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ch.ms(UGenVideoOrImgPanelView.this.f3605ms, zMs, str, 3, (Map<String, Object>) null);
            }

            @Override // com.bytedance.sdk.component.adexpress.xr.ab
            public void ms(int i2, String str2) {
                HashMap map = new HashMap();
                map.put("error_code", Integer.valueOf(i2));
                map.put("error_msg", str2);
                map.put(j.w.E, 1);
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ch.ms(UGenVideoOrImgPanelView.this.f3605ms, false, str, 3, (Map<String, Object>) map);
            }
        });
    }

    static class ms extends Handler {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        UGenVideoOrImgPanelView f3614ms;

        private ms(Looper looper) {
            super(looper);
        }

        public void ms(UGenVideoOrImgPanelView uGenVideoOrImgPanelView) {
            this.f3614ms = uGenVideoOrImgPanelView;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0025  */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            View view;
            super.handleMessage(message);
            UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.f3614ms;
            if (uGenVideoOrImgPanelView == null || uGenVideoOrImgPanelView.yu || message == null) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof WeakReference) {
                Object obj2 = ((WeakReference) obj).get();
                if (obj2 instanceof View) {
                    view = (View) obj2;
                } else {
                    view = null;
                }
            } else {
                view = null;
            }
            if (view == null) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                this.f3614ms.ah(view);
            } else {
                if (i != 2) {
                    return;
                }
                this.f3614ms.xr(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(View view, int i) {
        boolean zAh = false;
        if (this.yu) {
            return false;
        }
        if (i != 0) {
            if (i == 2) {
                if (this.re != null) {
                    zAh = xr(view);
                } else {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 2;
                    messageObtain.obj = new WeakReference(view);
                    this.ka.add(messageObtain);
                    zAh = true;
                }
            } else if (this.ah != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                view.setVisibility(0);
                this.ah.addView(view);
                zAh = true;
            } else if (this.d != null) {
                zAh = ms(view);
            }
        } else if (this.re != null) {
            zAh = ah(view);
        } else {
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 0;
            messageObtain2.obj = new WeakReference(view);
            this.ka.add(messageObtain2);
            zAh = true;
        }
        if (this.d == null) {
            view.bringToFront();
            ms(this.y);
        }
        return zAh;
    }

    private boolean ms(final View view) {
        if (view == null) {
            return false;
        }
        ViewGroup viewGroup = this.re;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            return false;
        }
        this.d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.5
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                UGenVideoOrImgPanelView.this.d.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                UGenVideoOrImgPanelView.this.re.getLocationInWindow(iArr2);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (UGenVideoOrImgPanelView.this.re instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UGenVideoOrImgPanelView.this.d.getWidth(), UGenVideoOrImgPanelView.this.d.getHeight());
                    layoutParams.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.re.addView(view, layoutParams);
                }
                if (UGenVideoOrImgPanelView.this.re instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UGenVideoOrImgPanelView.this.d.getWidth(), UGenVideoOrImgPanelView.this.d.getHeight());
                    layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.re.addView(view, layoutParams2);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xr(final View view) {
        ViewGroup viewGroup = this.re;
        if (viewGroup == null || view == null || this.ah == null) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.6
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.re.getWidth(), UGenVideoOrImgPanelView.this.re.getHeight()));
                view.setVisibility(0);
                UGenVideoOrImgPanelView.this.ah.removeView(view);
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                UGenVideoOrImgPanelView.this.ah.addView(view);
                Rect rect = new Rect();
                UGenVideoOrImgPanelView.this.re.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                UGenVideoOrImgPanelView.this.ah.getGlobalVisibleRect(rect2);
                view.setTranslationY(rect.top - rect2.top);
                for (ViewParent parent2 = UGenVideoOrImgPanelView.this.ah.getParent(); parent2 != null; parent2 = parent2.getParent()) {
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).setClipChildren(false);
                        if (parent2.hashCode() == UGenVideoOrImgPanelView.this.re.hashCode()) {
                            return;
                        }
                    }
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ah(final View view) {
        if (view == null) {
            return false;
        }
        ViewGroup viewGroup = this.re;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.7
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.re.getWidth(), UGenVideoOrImgPanelView.this.re.getHeight()));
                view.setVisibility(0);
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                UGenVideoOrImgPanelView.this.re.removeView(view);
                UGenVideoOrImgPanelView.this.re.addView(view);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xr.x
    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
        super.ms(view, i, ahVar);
        View view2 = this.ah;
        if (view2 == null) {
            view2 = this.d;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ch.ms(this.f3605ms, com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ch.ms(view2, ahVar), com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ch.ms(ahVar), 3, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xr.x
    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar, int i2) {
        super.ms(view, i, ahVar, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(boolean z) {
        if (this.ah == null) {
            return;
        }
        this.y = z;
        this.ah.xr(z, true);
        com.bykv.vk.openvk.component.video.api.d.ah nativeVideoController = this.ah.getNativeVideoController();
        if (nativeVideoController != null) {
            nativeVideoController.xr(z);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.d dVar = this.xr;
        if (dVar == null) {
            return;
        }
        dVar.setSoundMute(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void zb() {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.8
            @Override // java.lang.Runnable
            public void run() {
                UGenVideoOrImgPanelView.this.yu = true;
                if (UGenVideoOrImgPanelView.this.b != null) {
                    ViewParent parent = UGenVideoOrImgPanelView.this.b.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(UGenVideoOrImgPanelView.this.b);
                    }
                }
                UGenVideoOrImgPanelView.super.zb();
                if (UGenVideoOrImgPanelView.this.xr != null) {
                    UGenVideoOrImgPanelView.this.xr.hi();
                }
            }
        });
    }
}
