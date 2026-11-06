package com.byazt.mr;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.ehw.DeviceUtils;
import com.byazt.gct.pk;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 1904})
public class EmptyView extends View implements wo.n {
    public com.byazt.nj.n a;
    public int cd;
    public final AtomicBoolean cp;
    public boolean cy;
    public int d;
    public List<View> fs;
    public final AtomicBoolean hd;
    public boolean k;
    public View l;
    public volatile boolean n;
    public pk oa;
    public boolean ou;
    public boolean py;
    public n q;
    public com.byazt.ot.n.qg qg;
    public int rv;
    public volatile boolean s;
    public String sz;
    public final Handler tj;
    public boolean um;
    public List<View> w;
    public boolean wm;
    public List<View> x;

    public interface n {
        void n();

        void n(View view, Map<String, Object> map);

        void n(boolean z);

        void qg();
    }

    public static /* synthetic */ int x(EmptyView emptyView) {
        int i = emptyView.cd;
        emptyView.cd = i + 1;
        return i;
    }

    private EmptyView(Context context, View view) {
        super(com.byazt.nf.rv.getContext());
        this.s = true;
        this.cp = new AtomicBoolean(true);
        this.d = 1000;
        this.k = true;
        this.cy = false;
        this.hd = new AtomicBoolean(false);
        this.cd = 0;
        this.um = false;
        this.qg = new com.byazt.ot.n.qg() { // from class: com.byazt.mr.EmptyView.6
            @Override // com.byazt.ot.n.qg
            public void q() {
            }

            @Override // com.byazt.ot.n.qg
            public void s() {
            }

            @Override // com.byazt.ot.n.qg
            public void n() {
                if (!com.byazt.vyf.s.cy().lh() && EmptyView.this.um) {
                    EmptyView.this.um = false;
                    if (EmptyView.this.d()) {
                        com.byazt.de.qg.qg(EmptyView.this.getLifecycleId(), 1);
                    }
                    EmptyView.this.rv();
                }
            }

            @Override // com.byazt.ot.n.qg
            public void qg() {
                if (com.byazt.vyf.s.cy().lh() || EmptyView.this.um) {
                    return;
                }
                EmptyView emptyView = EmptyView.this;
                if (emptyView.n(emptyView.l)) {
                    EmptyView.this.um = true;
                    if (EmptyView.this.d()) {
                        com.byazt.de.qg.n(EmptyView.this.getLifecycleId(), 1);
                    }
                    EmptyView.this.fs();
                }
            }
        };
        this.l = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.tj = new t(com.byazt.ag.qg.qg(), this);
    }

    public EmptyView(Context context, View view, int i) {
        this(context, view);
        this.d = i;
        this.a = new com.byazt.nj.n(i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        View view;
        super.onWindowFocusChanged(z);
        n(z);
        n nVar = this.q;
        if (nVar != null) {
            nVar.n(z);
        }
        if (z) {
            if (this.um || !n(this.l)) {
                return;
            }
            this.um = true;
            fs();
            return;
        }
        if (!this.um || (view = this.l) == null) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.byazt.mr.EmptyView.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.byazt.okk.q.qg(EmptyView.this.l, 20, EmptyView.this.rv)) {
                    return;
                }
                EmptyView.this.um = false;
                EmptyView.this.rv();
            }
        }, 500L);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.wm = true;
        this.hd.set(false);
        q();
        if (!this.py && this.k) {
            n("checkWhenAddToWindow");
        }
        if (!this.um && oa()) {
            this.um = true;
            fs();
        }
        qg();
        com.byazt.vyf.s.cy().s().n(this.qg);
    }

    private void qg() {
        if (this.cp.getAndSet(false)) {
            w();
            n nVar = this.q;
            if (nVar != null) {
                nVar.n();
            }
        }
    }

    private void s() {
        if (this.cp.getAndSet(true)) {
            return;
        }
        x();
        n nVar = this.q;
        if (nVar != null) {
            nVar.qg();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hd.set(false);
        l();
        if (this.um) {
            this.um = false;
            if (d()) {
                com.byazt.de.qg.qg(getLifecycleId(), 0);
            }
            rv();
        }
        s();
        com.byazt.vyf.s.cy().s().qg(this.qg);
    }

    public void setRefClickViews(List<View> list) {
        this.w = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.x = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.fs = list;
    }

    public void n() {
        n(this.w, (com.byazt.ys.l) null);
        n(this.x, (com.byazt.ys.l) null);
        n(this.fs, (com.byazt.ys.l) null);
    }

    public void n(List<View> list, com.byazt.ys.l lVar) {
        if (com.byazt.tk.d.qg(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(lVar);
                    view.setOnTouchListener(lVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.tj.post(new Runnable() { // from class: com.byazt.mr.EmptyView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!EmptyView.this.s || EmptyView.this.n) {
                    return;
                }
                EmptyView.this.cp();
                EmptyView.this.n = true;
                EmptyView.x(EmptyView.this);
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                EmptyView.this.tj.handleMessage(messageObtain);
            }
        });
    }

    public void n(final String str) {
        this.tj.post(new Runnable() { // from class: com.byazt.mr.EmptyView.3
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, "checkWhenClicked")) {
                    if (!EmptyView.this.s) {
                        EmptyView.this.n(8, (String) null);
                    }
                    if (!EmptyView.this.n) {
                        EmptyView.this.n(EmptyView.this.hd.get() ? 10 : 9, (String) null);
                    }
                } else {
                    EmptyView.this.cp();
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                EmptyView.this.tj.handleMessage(messageObtain);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.tj.post(new Runnable() { // from class: com.byazt.mr.EmptyView.4
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.n = false;
                EmptyView.this.tj.removeMessages(1);
            }
        });
    }

    public void setNeedCheckingShow(final boolean z) {
        this.hd.set(false);
        this.tj.post(new Runnable() { // from class: com.byazt.mr.EmptyView.5
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.s = z;
                if (!z && EmptyView.this.n) {
                    EmptyView.this.l();
                } else {
                    if (!z || EmptyView.this.n) {
                        return;
                    }
                    EmptyView.this.q();
                }
            }
        });
    }

    public void setCallback(n nVar) {
        this.q = new qg(nVar);
    }

    public void setAdType(int i) {
        this.rv = i;
    }

    public void n(pk pkVar, String str) {
        this.oa = pkVar;
        this.sz = str;
        this.a.n();
        this.k = pkVar == null || pkVar.y();
        this.cy = pkVar == null || pkVar.rf();
        if (pkVar != null) {
            String strValueOf = String.valueOf(com.byazt.vgx.w.cy(pkVar));
            int iD = com.byazt.vgx.w.d(pkVar);
            if (this.rv == 0) {
                this.rv = iD;
            }
            n(pkVar, strValueOf, iD);
        }
    }

    public void setShowThresholdCheckController(com.byazt.nj.n nVar) {
        if (nVar != null) {
            this.a = nVar;
        }
    }

    public void setSkipAttachShowCheck(boolean z) {
        this.py = z;
    }

    public void setOnlyShowThresholdCheck(boolean z) {
        this.ou = z;
    }

    private void n(pk pkVar, String str, int i) {
        if (this.ou) {
            return;
        }
        com.byazt.de.q.n(pkVar, str, i, getLifecycleId());
    }

    private void n(boolean z) {
        if (this.ou) {
            return;
        }
        com.byazt.de.q.n(getLifecycleId(), z ? 1 : 2);
    }

    private void w() {
        if (this.ou) {
            return;
        }
        com.byazt.de.q.qg(getLifecycleId());
    }

    private void x() {
        if (this.ou) {
            return;
        }
        com.byazt.de.q.l(getLifecycleId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs() {
        if (this.ou) {
            return;
        }
        com.byazt.de.q.s(getLifecycleId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        if (this.ou) {
            return;
        }
        com.byazt.de.q.q(getLifecycleId());
    }

    private void tj() {
        if (this.ou) {
            return;
        }
        com.byazt.de.q.qg(getLifecycleId(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp() {
        this.a.qg(this.oa, this.rv);
        this.d = this.a.q();
        qg(oa());
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        int iN;
        String message2 = null;
        String str = message.obj instanceof String ? (String) message.obj : null;
        boolean zEquals = TextUtils.equals("checkWhenClicked", str);
        boolean z = TextUtils.equals("checkWhenAddToWindow", str) || zEquals;
        boolean z2 = this.k || this.cy;
        if (message.what != 1) {
            return;
        }
        if (this.n || (z2 && z)) {
            if (!this.um && n(this.l)) {
                this.um = true;
                if (d()) {
                    com.byazt.de.qg.n(getLifecycleId(), 0);
                }
                if (!oa()) {
                    fs();
                }
            }
            if (!z2) {
                if (com.byazt.okk.q.qg(this.l, 20, this.rv)) {
                    l();
                    n nVar = this.q;
                    if (nVar != null) {
                        nVar.n(this.l, null);
                        return;
                    }
                    return;
                }
                this.tj.sendEmptyMessageDelayed(1, this.d);
                return;
            }
            try {
                iN = com.byazt.okk.q.n(this.l, 20, this.rv);
            } catch (Throwable th) {
                message2 = th.getMessage();
                iN = 7;
            }
            boolean z3 = iN == 0;
            if (zEquals ? z3 : this.a.n(z3, z, this.k)) {
                l();
                if (zEquals) {
                    com.byazt.nj.n.qg(this.oa);
                } else {
                    qg(false);
                }
                if (this.q != null && !this.hd.get()) {
                    this.hd.set(true);
                    this.q.n(this.l, n(z, message));
                }
            } else {
                if (!zEquals && z3 && this.a.s()) {
                    qg(true);
                }
                if (!z) {
                    this.tj.sendEmptyMessageDelayed(1, this.d);
                    this.a.n(this.k);
                }
            }
            if (zEquals) {
                n(iN, message2);
            }
        }
    }

    private void qg(boolean z) {
        this.a.n(this.oa, z);
    }

    private Map<String, Object> n(boolean z, Message message) {
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
    public void n(int i, String str) {
        HashMap map = new HashMap();
        if (i == 0) {
            map.put("is_success", Boolean.TRUE);
        } else {
            map.put("is_success", Boolean.FALSE);
            if (i != 7) {
                str = com.byazt.okk.q.n(i);
            }
            map.put("error_code", Integer.valueOf(i));
            map.put("error_message", str);
        }
        map.put("checking_cnt", Integer.valueOf(this.cd));
        com.byazt.hm.n.n(this.oa, this.sz, map);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS})
    public static final class qg implements n {
        public final n n;

        public qg(n nVar) {
            this.n = nVar;
        }

        @Override // com.byazt.mr.EmptyView.n
        public void n(final boolean z) {
            if (this.n != null) {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.mr.EmptyView.qg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        qg.this.n.n(z);
                    }
                });
            }
        }

        @Override // com.byazt.mr.EmptyView.n
        public void n() {
            if (this.n != null) {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.mr.EmptyView.qg.2
                    @Override // java.lang.Runnable
                    public void run() {
                        qg.this.n.n();
                    }
                });
            }
        }

        @Override // com.byazt.mr.EmptyView.n
        public void qg() {
            if (this.n != null) {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.mr.EmptyView.qg.3
                    @Override // java.lang.Runnable
                    public void run() {
                        qg.this.n.qg();
                    }
                });
            }
        }

        @Override // com.byazt.mr.EmptyView.n
        public void n(final View view, final Map<String, Object> map) {
            if (this.n != null) {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.mr.EmptyView.qg.4
                    @Override // java.lang.Runnable
                    public void run() {
                        qg.this.n.n(view, map);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int i = this.rv;
        return i == 1 || i == 5 || i == 9;
    }

    private boolean oa() {
        int i = this.rv;
        return i == 7 || i == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLifecycleId() {
        pk pkVar = this.oa;
        if (pkVar != null) {
            return pkVar.h();
        }
        return null;
    }

    public void finalize() throws Throwable {
        super.finalize();
        tj();
        if (oa()) {
            if (!this.ou) {
                return;
            }
        } else if (!this.wm) {
            return;
        }
        com.byazt.nj.n.n(this.oa, this.rv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(View view) {
        try {
            return DeviceUtils.n() && view != null && view.isShown();
        } catch (Throwable unused) {
        }
    }
}
