package com.byazt.sd;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.of;
import com.byazt.vkw.qi;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 24})
public class EmptyView extends View implements qi.pr {
    public int aj;
    public View c;
    public List<View> fw;
    public String g;
    public volatile boolean hn;
    public boolean ho;
    public volatile boolean hw;
    public int k;
    public int lb;
    public of m;
    public boolean nt;
    public com.byazt.wt.pr.hw pr;
    public boolean qa;
    public List<View> uc;
    public final Handler vk;
    public final AtomicBoolean w;
    public pr x;
    public final AtomicBoolean yb;
    public List<View> zo;

    public interface pr {
        void hw();

        void pr();

        void pr(View view, Map<String, Object> map);

        void pr(boolean z);
    }

    public static /* synthetic */ int uc(EmptyView emptyView) {
        int i = emptyView.lb;
        emptyView.lb = i + 1;
        return i;
    }

    public EmptyView(Context context, View view) {
        super(a.getContext());
        this.hn = true;
        this.w = new AtomicBoolean(true);
        this.k = 1000;
        this.ho = false;
        this.nt = false;
        this.yb = new AtomicBoolean(false);
        this.lb = 0;
        this.qa = false;
        this.pr = new com.byazt.wt.pr.hw() { // from class: com.byazt.sd.EmptyView.6
            @Override // com.byazt.wt.pr.hw
            public void pr() {
                if (!zo.nt().y() && EmptyView.this.qa) {
                    EmptyView.this.qa = false;
                    if (EmptyView.this.uc()) {
                        com.byazt.qd.hw.hw(EmptyView.this.getLifecycleId(), 1);
                    }
                    com.byazt.qd.x.x(EmptyView.this.getLifecycleId());
                }
            }

            @Override // com.byazt.wt.pr.hw
            public void hw() {
                if (!zo.nt().y() && !EmptyView.this.qa) {
                    EmptyView emptyView = EmptyView.this;
                    if (emptyView.pr(emptyView.c)) {
                        EmptyView.this.qa = true;
                        if (EmptyView.this.uc()) {
                            com.byazt.qd.hw.pr(EmptyView.this.getLifecycleId(), 1);
                        }
                        com.byazt.qd.x.hn(EmptyView.this.getLifecycleId());
                    }
                }
            }

            @Override // com.byazt.wt.pr.hw
            public void hn() {
            }

            @Override // com.byazt.wt.pr.hw
            public void x() {
            }
        };
        this.c = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.vk = new com.byazt.ca.iu(com.byazt.zp.zo.hw(), this);
        this.ho = a.hw().kx();
        this.nt = a.hw().hv();
    }

    public EmptyView(Context context, View view, int i) {
        this(context, view);
        this.k = i;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        View view;
        super.onWindowFocusChanged(z);
        com.byazt.qd.x.pr(getLifecycleId(), z ? 1 : 2);
        pr prVar = this.x;
        if (prVar != null) {
            prVar.pr(z);
        }
        if (z) {
            if (!this.qa && pr(this.c)) {
                this.qa = true;
                com.byazt.qd.x.hn(getLifecycleId());
                return;
            }
            return;
        }
        if (this.qa && (view = this.c) != null) {
            view.postDelayed(new Runnable() { // from class: com.byazt.sd.EmptyView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ww.hw(EmptyView.this.c, 20, EmptyView.this.aj)) {
                        EmptyView.this.qa = false;
                        com.byazt.qd.x.x(EmptyView.this.getLifecycleId());
                    }
                }
            }, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yb.set(false);
        x();
        if (this.ho) {
            pr("checkWhenAddToWindow");
        }
        if (!this.qa && fw()) {
            this.qa = true;
            com.byazt.qd.x.hn(getLifecycleId());
        }
        hw();
        zo.nt().hn().pr(this.pr);
    }

    private void hw() {
        if (this.w.getAndSet(false)) {
            com.byazt.qd.x.hw(getLifecycleId());
            pr prVar = this.x;
            if (prVar != null) {
                prVar.pr();
            }
        }
    }

    private void hn() {
        if (!this.w.getAndSet(true)) {
            com.byazt.qd.x.c(getLifecycleId());
            pr prVar = this.x;
            if (prVar != null) {
                prVar.hw();
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.yb.set(false);
        c();
        if (this.qa) {
            this.qa = false;
            if (uc()) {
                com.byazt.qd.hw.hw(getLifecycleId(), 0);
            }
            com.byazt.qd.x.x(getLifecycleId());
        }
        hn();
        zo.nt().hn().hw(this.pr);
    }

    public void setRefClickViews(List<View> list) {
        this.uc = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.fw = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.zo = list;
    }

    public void pr() {
        pr(this.uc, (com.byazt.az.x) null);
        pr(this.fw, (com.byazt.az.x) null);
        pr(this.zo, (com.byazt.az.x) null);
    }

    public void pr(List<View> list, com.byazt.az.x xVar) {
        if (com.byazt.ca.k.hw(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(xVar);
                    view.setOnTouchListener(xVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.vk.post(new Runnable() { // from class: com.byazt.sd.EmptyView.2
            @Override // java.lang.Runnable
            public void run() {
                if (EmptyView.this.hn && !EmptyView.this.hw) {
                    EmptyView.this.hw = true;
                    EmptyView.uc(EmptyView.this);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 1;
                    EmptyView.this.vk.handleMessage(messageObtain);
                }
            }
        });
    }

    public void pr(final String str) {
        this.vk.post(new Runnable() { // from class: com.byazt.sd.EmptyView.3
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, "checkWhenClicked")) {
                    if (!EmptyView.this.hn) {
                        EmptyView.this.pr(8, (String) null);
                    }
                    if (!EmptyView.this.hw) {
                        int i = 9;
                        if (EmptyView.this.yb.get()) {
                            i = 10;
                        }
                        EmptyView.this.pr(i, (String) null);
                    }
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                EmptyView.this.vk.handleMessage(messageObtain);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.vk.post(new Runnable() { // from class: com.byazt.sd.EmptyView.4
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.hw = false;
                EmptyView.this.vk.removeMessages(1);
            }
        });
    }

    public void setNeedCheckingShow(final boolean z) {
        this.yb.set(false);
        this.vk.post(new Runnable() { // from class: com.byazt.sd.EmptyView.5
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.hn = z;
                if (!z && EmptyView.this.hw) {
                    EmptyView.this.c();
                } else if (z && !EmptyView.this.hw) {
                    EmptyView.this.x();
                }
            }
        });
    }

    public void setCallback(pr prVar) {
        this.x = new hw(prVar);
    }

    public void setAdType(int i) {
        this.aj = i;
    }

    public void pr(of ofVar, String str) {
        this.m = ofVar;
        this.g = str;
        if (ofVar != null) {
            String strValueOf = String.valueOf(ls.m(ofVar));
            int iK = ls.k(ofVar);
            if (this.aj == 0) {
                this.aj = iK;
            }
            com.byazt.qd.x.pr(ofVar, strValueOf, iK, getLifecycleId());
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        boolean z;
        boolean z2 = this.ho || this.nt;
        if ((message.obj instanceof String) && (TextUtils.equals("checkWhenAddToWindow", message.obj.toString()) || TextUtils.equals("checkWhenClicked", message.obj.toString()))) {
            z = true;
        } else {
            z = false;
        }
        switch (message.what) {
            case 1:
                if (this.hw || (z2 && z)) {
                    if (!this.qa && pr(this.c)) {
                        this.qa = true;
                        if (uc()) {
                            com.byazt.qd.hw.pr(getLifecycleId(), 0);
                        }
                        if (!fw()) {
                            com.byazt.qd.x.hn(getLifecycleId());
                        }
                    }
                    String message2 = null;
                    if (!z2) {
                        if (ww.hw(this.c, 20, this.aj)) {
                            c();
                            pr prVar = this.x;
                            if (prVar != null) {
                                prVar.pr(this.c, null);
                            }
                        } else {
                            this.vk.sendEmptyMessageDelayed(1, this.k);
                        }
                    } else {
                        int iPr = 7;
                        try {
                            iPr = ww.pr(this.c, 20, this.aj);
                        } catch (Throwable th) {
                            message2 = th.getMessage();
                        }
                        if (iPr == 0) {
                            c();
                            if (this.x != null && !this.yb.get()) {
                                this.yb.set(true);
                                this.x.pr(this.c, pr(z, message));
                            }
                        } else if (!z) {
                            this.vk.sendEmptyMessageDelayed(1, this.k);
                        }
                        if ((message.obj instanceof String) && TextUtils.equals("checkWhenClicked", message.obj.toString())) {
                            pr(iPr, message2);
                            break;
                        }
                    }
                }
                break;
        }
    }

    private Map<String, Object> pr(boolean z, Message message) {
        if (z) {
            HashMap map = new HashMap();
            if (TextUtils.equals("checkWhenAddToWindow", message.obj.toString())) {
                map.put("show_send_type", 2);
            } else if (TextUtils.equals("checkWhenClicked", message.obj.toString())) {
                map.put("show_send_type", 1);
            }
            return map;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, String str) {
        HashMap map = new HashMap();
        if (i == 0) {
            map.put("is_success", Boolean.TRUE);
        } else {
            map.put("is_success", Boolean.FALSE);
            if (i != 7) {
                str = ww.pr(i);
            }
            map.put(Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
            map.put("error_message", str);
        }
        map.put("checking_cnt", Integer.valueOf(this.lb));
        com.byazt.pj.pr.pr(this.m, this.g, map);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 2133})
    public static final class hw implements pr {
        public final pr pr;

        public hw(pr prVar) {
            this.pr = prVar;
        }

        @Override // com.byazt.sd.EmptyView.pr
        public void pr(final boolean z) {
            if (this.pr != null) {
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.EmptyView.hw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hw.this.pr.pr(z);
                    }
                });
            }
        }

        @Override // com.byazt.sd.EmptyView.pr
        public void pr() {
            if (this.pr != null) {
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.EmptyView.hw.2
                    @Override // java.lang.Runnable
                    public void run() {
                        hw.this.pr.pr();
                    }
                });
            }
        }

        @Override // com.byazt.sd.EmptyView.pr
        public void hw() {
            if (this.pr != null) {
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.EmptyView.hw.3
                    @Override // java.lang.Runnable
                    public void run() {
                        hw.this.pr.hw();
                    }
                });
            }
        }

        @Override // com.byazt.sd.EmptyView.pr
        public void pr(final View view, final Map<String, Object> map) {
            if (this.pr != null) {
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.EmptyView.hw.4
                    @Override // java.lang.Runnable
                    public void run() {
                        hw.this.pr.pr(view, map);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uc() {
        int i = this.aj;
        return i == 1 || i == 5 || i == 9;
    }

    private boolean fw() {
        int i = this.aj;
        return i == 7 || i == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLifecycleId() {
        of ofVar = this.m;
        if (ofVar != null) {
            return ofVar.z();
        }
        return null;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.x.hw(getLifecycleId(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(View view) {
        try {
            return DeviceUtils.pr() && view != null && view.isShown();
        } catch (Throwable th) {
            return false;
        }
    }
}
