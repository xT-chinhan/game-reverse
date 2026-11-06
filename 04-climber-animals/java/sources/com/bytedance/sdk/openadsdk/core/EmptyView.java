package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyView extends View implements com.bytedance.sdk.component.utils.le.ms {
    private List<View> ab;
    private ms ah;
    private final AtomicBoolean ao;
    private List<View> c;
    private final AtomicBoolean ch;
    private View d;
    private int h;
    private int hi;
    private List<View> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile boolean f1878ms;
    private final Handler ny;
    private lm sl;
    private boolean u;
    private boolean ub;
    private int x;
    private volatile boolean xr;
    private String zb;

    public interface ms {
        void ms();

        void ms(View view, Map<String, Object> map);

        void ms(boolean z);

        void xr();
    }

    static /* synthetic */ int ah(EmptyView emptyView) {
        int i = emptyView.h;
        emptyView.h = i + 1;
        return i;
    }

    public EmptyView(Context context, View view) {
        super(re.getContext());
        this.xr = true;
        this.ch = new AtomicBoolean(true);
        this.hi = 1000;
        this.u = false;
        this.ub = false;
        this.ao = new AtomicBoolean(false);
        this.h = 0;
        this.d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.ny = new com.bytedance.sdk.component.utils.le(com.bytedance.sdk.openadsdk.op.ab.xr(), this);
        this.u = re.xr().xf();
        this.ub = re.xr().gz();
    }

    public EmptyView(Context context, View view, int i) {
        this(context, view);
        this.hi = i;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ms msVar = this.ah;
        if (msVar != null) {
            msVar.ms(z);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ao.set(false);
        d();
        if (this.u) {
            ms("checkWhenAddToWindow");
        }
        xr();
    }

    private void xr() {
        ms msVar;
        if (!this.ch.getAndSet(false) || (msVar = this.ah) == null) {
            return;
        }
        msVar.ms();
    }

    private void ah() {
        ms msVar;
        if (this.ch.getAndSet(true) || (msVar = this.ah) == null) {
            return;
        }
        msVar.xr();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ao.set(false);
        ka();
        ah();
    }

    public void setRefClickViews(List<View> list) {
        this.ka = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.c = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.ab = list;
    }

    public void ms() {
        ms(this.ka, (com.bytedance.sdk.openadsdk.core.xr.d) null);
        ms(this.c, (com.bytedance.sdk.openadsdk.core.xr.d) null);
        ms(this.ab, (com.bytedance.sdk.openadsdk.core.xr.d) null);
    }

    public void ms(List<View> list, com.bytedance.sdk.openadsdk.core.xr.d dVar) {
        if (com.bytedance.sdk.component.utils.ch.xr(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(dVar);
                    view.setOnTouchListener(dVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.ny.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!EmptyView.this.xr || EmptyView.this.f1878ms) {
                    return;
                }
                EmptyView.this.f1878ms = true;
                EmptyView.ah(EmptyView.this);
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                EmptyView.this.ny.handleMessage(messageObtain);
            }
        });
    }

    public void ms(final String str) {
        this.ny.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, "checkWhenClicked")) {
                    if (!EmptyView.this.xr) {
                        EmptyView.this.ms(8, (String) null);
                    }
                    if (!EmptyView.this.f1878ms) {
                        EmptyView.this.ms(EmptyView.this.ao.get() ? 10 : 9, (String) null);
                    }
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                EmptyView.this.ny.handleMessage(messageObtain);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        this.ny.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.3
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.f1878ms = false;
                EmptyView.this.ny.removeMessages(1);
            }
        });
    }

    public void setNeedCheckingShow(final boolean z) {
        this.ao.set(false);
        this.ny.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.4
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.xr = z;
                if (!z && EmptyView.this.f1878ms) {
                    EmptyView.this.ka();
                } else {
                    if (!z || EmptyView.this.f1878ms) {
                        return;
                    }
                    EmptyView.this.d();
                }
            }
        });
    }

    public void setCallback(ms msVar) {
        this.ah = new xr(msVar);
    }

    public void setAdType(int i) {
        this.x = i;
    }

    public void ms(lm lmVar, String str) {
        this.sl = lmVar;
        this.zb = str;
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int iMs;
        boolean z = false;
        boolean z2 = this.u || this.ub;
        if ((message.obj instanceof String) && (TextUtils.equals("checkWhenAddToWindow", message.obj.toString()) || TextUtils.equals("checkWhenClicked", message.obj.toString()))) {
            z = true;
        }
        if (message.what != 1) {
            return;
        }
        if (this.f1878ms || (z2 && z)) {
            String message2 = null;
            if (!z2) {
                if (f.xr(this.d, 20, this.x)) {
                    ka();
                    ms msVar = this.ah;
                    if (msVar != null) {
                        msVar.ms(this.d, null);
                        return;
                    }
                    return;
                }
                this.ny.sendEmptyMessageDelayed(1, this.hi);
                return;
            }
            try {
                iMs = f.ms(this.d, 20, this.x);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ms(th);
                message2 = th.getMessage();
                iMs = 7;
            }
            if (iMs == 0) {
                ka();
                if (this.ah != null && !this.ao.get()) {
                    this.ao.set(true);
                    this.ah.ms(this.d, ms(z, message));
                }
            } else if (!z) {
                this.ny.sendEmptyMessageDelayed(1, this.hi);
            }
            if ((message.obj instanceof String) && TextUtils.equals("checkWhenClicked", message.obj.toString())) {
                ms(iMs, message2);
            }
        }
    }

    private Map<String, Object> ms(boolean z, Message message) {
        if (!z) {
            return null;
        }
        HashMap map = new HashMap();
        if (TextUtils.equals("checkWhenAddToWindow", message.obj.toString())) {
            map.put("show_send_type", 2);
        } else if (TextUtils.equals("checkWhenClicked", message.obj.toString())) {
            map.put("show_send_type", 1);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, String str) {
        HashMap map = new HashMap();
        if (i == 0) {
            map.put("is_success", Boolean.TRUE);
        } else {
            map.put("is_success", Boolean.FALSE);
            if (i != 7) {
                str = f.ms(i);
            }
            map.put("error_code", Integer.valueOf(i));
            map.put("error_message", str);
        }
        map.put("checking_cnt", Integer.valueOf(this.h));
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.sl, this.zb, map);
    }

    public static final class xr implements ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final ms f1883ms;

        public xr(ms msVar) {
            this.f1883ms = msVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
        public void ms(final boolean z) {
            if (this.f1883ms != null) {
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.xr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xr.this.f1883ms.ms(z);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
        public void ms() {
            if (this.f1883ms != null) {
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.xr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xr.this.f1883ms.ms();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
        public void xr() {
            if (this.f1883ms != null) {
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.xr.3
                    @Override // java.lang.Runnable
                    public void run() {
                        xr.this.f1883ms.xr();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
        public void ms(final View view, final Map<String, Object> map) {
            if (this.f1883ms != null) {
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.xr.4
                    @Override // java.lang.Runnable
                    public void run() {
                        xr.this.f1883ms.ms(view, map);
                    }
                });
            }
        }
    }
}
