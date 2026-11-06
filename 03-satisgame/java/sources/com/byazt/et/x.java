package com.byazt.et;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 21})
public class x extends qg implements com.byazt.hb.rv.n {
    public boolean a;
    public int cd;
    public int cp;
    public int cy;
    public int d;
    public Handler hd;
    public final List<fs> hu;
    public int k;
    public boolean m;
    public String oa;
    public long ou;
    public boolean py;
    public int sz;
    public boolean um;
    public int wm;

    public x(Context context) {
        super(context);
        this.d = 0;
        this.oa = "";
        this.sz = 0;
        this.k = 0;
        this.cy = 0;
        this.hd = new com.byazt.hb.rv(Looper.getMainLooper(), this);
        this.cd = 0;
        this.um = false;
        this.a = false;
        this.py = false;
        this.ou = 0L;
        this.wm = 0;
        this.m = false;
        this.hu = new ArrayList();
    }

    @Override // com.byazt.et.qg
    public void w() {
        super.w();
        if (this.l != null) {
            Object obj = this.l.get(TapEventParamConstants.PARAM_NAME);
            if (obj != null) {
                this.oa = String.valueOf(obj);
                return;
            } else {
                this.oa = "";
                return;
            }
        }
        this.oa = "";
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        if (this.l != null) {
            Object obj = this.l.get(TapEventParamConstants.PARAM_NAME);
            if (obj != null) {
                this.oa = String.valueOf(obj);
            } else {
                this.oa = "";
            }
            Object obj2 = this.l.get("condition");
            if (obj2 != null) {
                this.sz = com.byazt.hb.s.n(String.valueOf(obj2), 0);
            } else {
                this.sz = 0;
            }
            Object obj3 = this.l.get("pauseMode");
            if (obj3 != null) {
                this.k = com.byazt.hb.s.n(String.valueOf(obj3), 0);
            } else {
                this.k = 0;
            }
            Object obj4 = this.l.get("loop");
            if (obj4 != null) {
                this.cp = com.byazt.hb.s.n(String.valueOf(obj4), 1);
            } else {
                this.cp = 1;
            }
            int i = this.cp;
            if (i <= 0) {
                this.cd = -1;
            } else {
                this.cd = i;
            }
            Object obj5 = this.l.get(MediationConstant.EXTRA_DURATION);
            if (obj5 == null) {
                this.d = 0;
            } else {
                this.d = com.byazt.hb.s.n(String.valueOf(obj5), 0);
            }
        }
        int i2 = this.sz;
        if (i2 == 0) {
            d();
        } else if (i2 == 1) {
            if (this.qg == null || this.qg.rv() == null || this.qg.rv().getVisibility() != 0) {
                this.um = true;
            } else {
                d();
            }
        } else if (i2 == 2) {
            this.um = true;
        } else {
            d();
        }
        return true;
    }

    private void d() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.um = false;
        this.py = false;
        this.wm = 0;
        this.m = false;
        this.cy = 0;
        cy();
        qg(this.d);
        oa();
    }

    public void n(int i) {
        if (this.sz == 1 && this.um && i == 0) {
            d();
        }
        if (!this.a || (this.k & 2) == 0) {
            return;
        }
        if (i == 0) {
            this.cy &= -3;
        } else {
            this.cy |= 2;
        }
        oa();
    }

    public void n() {
        if (this.a || this.m) {
            return;
        }
        d();
    }

    public void qg() {
        if (this.a || this.um) {
            this.hd.removeMessages(1001);
            this.a = false;
            this.um = false;
            this.py = false;
            this.cy = 0;
            this.wm = 0;
            this.ou = 0L;
            this.cd = 0;
            if (this.m) {
                return;
            }
            this.m = true;
            hd();
        }
    }

    public void s() {
        if (this.a) {
            int i = this.cy;
            if ((i & 4) != 0) {
                return;
            }
            this.cy = i | 4;
            sz();
            cd();
        }
    }

    public void q() {
        if (this.a) {
            int i = this.cy;
            if ((i & 4) == 0) {
                return;
            }
            int i2 = i & (-5);
            this.cy = i2;
            if (i2 == 0 && this.py) {
                k();
            }
            um();
        }
    }

    public void n(boolean z) {
        if (!this.a || (this.k & 1) == 0) {
            return;
        }
        if (z) {
            this.cy &= -2;
        } else {
            this.cy |= 1;
        }
        oa();
    }

    private void oa() {
        if (this.a) {
            View viewRv = this.qg != null ? this.qg.rv() : null;
            if ((this.k & 2) != 0 && viewRv != null && viewRv.getVisibility() != 0) {
                this.cy |= 2;
            }
            if ((this.k & 1) != 0 && viewRv != null && !viewRv.hasWindowFocus()) {
                this.cy |= 1;
            }
            if (this.cy != 0) {
                sz();
            } else {
                k();
            }
        }
    }

    private void qg(int i) {
        this.hd.removeMessages(1001);
        long jMax = Math.max(0, i);
        this.ou = SystemClock.uptimeMillis() + jMax;
        this.hd.sendEmptyMessageDelayed(1001, jMax);
    }

    private void sz() {
        if (this.py) {
            return;
        }
        this.wm = (int) Math.max(0L, this.ou - SystemClock.uptimeMillis());
        this.hd.removeMessages(1001);
        this.py = true;
    }

    private void k() {
        if (this.py) {
            this.py = false;
            int i = this.wm;
            this.wm = 0;
            qg(i);
        }
    }

    @Override // com.byazt.hb.rv.n
    public void n(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        this.n.n(this.qg, this.w, this.s.qg(), this.s);
        int i3 = this.cd - 1;
        this.cd = i3;
        if (i3 < 0 && (i2 = this.d) != 0) {
            qg(i2);
            return;
        }
        if (i3 > 0 && (i = this.d) != 0) {
            qg(i);
            return;
        }
        this.hd.removeMessages(1001);
        this.ou = 0L;
        if (this.m) {
            return;
        }
        this.m = true;
        hd();
    }

    public void n(fs fsVar) {
        if (fsVar == null || this.hu.contains(fsVar)) {
            return;
        }
        this.hu.add(fsVar);
    }

    private void cy() {
        n(this.oa);
    }

    public void n(String str) {
        if (this.hu.isEmpty()) {
            return;
        }
        if (str == null) {
            str = this.oa;
        }
        Iterator it = new ArrayList(this.hu).iterator();
        while (it.hasNext()) {
            ((fs) it.next()).n(str);
        }
    }

    private void hd() {
        qg(this.oa);
    }

    public void qg(String str) {
        if (this.hu.isEmpty()) {
            return;
        }
        if (str == null) {
            str = this.oa;
        }
        Iterator it = new ArrayList(this.hu).iterator();
        while (it.hasNext()) {
            ((fs) it.next()).qg(str);
        }
    }

    private void cd() {
        if (this.hu.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.hu).iterator();
        while (it.hasNext()) {
            ((fs) it.next()).s(this.oa);
        }
    }

    private void um() {
        if (this.hu.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.hu).iterator();
        while (it.hasNext()) {
            ((fs) it.next()).q(this.oa);
        }
    }

    public String l() {
        return this.oa;
    }
}
