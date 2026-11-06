package com.byazt.xv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, 5})
public class uc extends hw implements com.byazt.aa.aj.pr {
    public boolean a;
    public boolean cz;
    public int fo;
    public int g;
    public int ho;
    public int k;
    public int lb;
    public String m;
    public int nt;
    public long ny;
    public boolean qa;
    public boolean rc;
    public int w;
    public Handler yb;
    public final List<fw> z;

    public uc(Context context) {
        super(context);
        this.k = 0;
        this.m = "";
        this.g = 0;
        this.ho = 0;
        this.nt = 0;
        this.yb = new com.byazt.aa.aj(Looper.getMainLooper(), this);
        this.lb = 0;
        this.qa = false;
        this.a = false;
        this.cz = false;
        this.ny = 0L;
        this.fo = 0;
        this.rc = false;
        this.z = new ArrayList();
    }

    @Override // com.byazt.xv.hw
    public void uc() {
        super.uc();
        if (this.c != null) {
            Object obj = this.c.get(Common.System.NAME);
            if (obj != null) {
                this.m = String.valueOf(obj);
                return;
            } else {
                this.m = "";
                return;
            }
        }
        this.m = "";
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        if (this.c != null) {
            Object obj = this.c.get(Common.System.NAME);
            if (obj != null) {
                this.m = String.valueOf(obj);
            } else {
                this.m = "";
            }
            Object obj2 = this.c.get("condition");
            if (obj2 != null) {
                this.g = com.byazt.aa.hn.pr(String.valueOf(obj2), 0);
            } else {
                this.g = 0;
            }
            Object obj3 = this.c.get("pauseMode");
            if (obj3 != null) {
                this.ho = com.byazt.aa.hn.pr(String.valueOf(obj3), 0);
            } else {
                this.ho = 0;
            }
            Object obj4 = this.c.get("loop");
            if (obj4 != null) {
                this.w = com.byazt.aa.hn.pr(String.valueOf(obj4), 1);
            } else {
                this.w = 1;
            }
            int i = this.w;
            if (i <= 0) {
                this.lb = -1;
            } else {
                this.lb = i;
            }
            Object obj5 = this.c.get("duration");
            if (obj5 != null) {
                this.k = com.byazt.aa.hn.pr(String.valueOf(obj5), 0);
            } else {
                this.k = 0;
            }
        }
        int i2 = this.g;
        if (i2 != 0) {
            if (i2 == 1) {
                if (this.hw == null || this.hw.aj() == null || this.hw.aj().getVisibility() != 0) {
                    this.qa = true;
                } else {
                    hn();
                }
            } else if (i2 == 2) {
                this.qa = true;
            } else {
                hn();
            }
        } else {
            hn();
        }
        return true;
    }

    private void hn() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.qa = false;
        this.cz = false;
        this.fo = 0;
        this.rc = false;
        this.nt = 0;
        m();
        hw(this.k);
        x();
    }

    public void pr(int i) {
        if (this.g == 1 && this.qa && i == 0) {
            hn();
        }
        if (!this.a || (this.ho & 2) == 0) {
            return;
        }
        if (i == 0) {
            this.nt &= -3;
        } else {
            this.nt |= 2;
        }
        x();
    }

    public void pr() {
        if (this.g == 2 && this.qa) {
            hn();
        }
    }

    public void pr(boolean z) {
        if (!this.a || (this.ho & 1) == 0) {
            return;
        }
        if (z) {
            this.nt &= -2;
        } else {
            this.nt |= 1;
        }
        x();
    }

    private void x() {
        if (!this.a) {
            return;
        }
        View viewAj = this.hw != null ? this.hw.aj() : null;
        if ((this.ho & 2) != 0 && viewAj != null && viewAj.getVisibility() != 0) {
            this.nt |= 2;
        }
        if ((this.ho & 1) != 0 && viewAj != null && !viewAj.hasWindowFocus()) {
            this.nt |= 1;
        }
        if (this.nt != 0) {
            c();
        } else {
            k();
        }
    }

    private void hw(int i) {
        this.yb.removeMessages(1001);
        long jMax = Math.max(0, i);
        this.ny = SystemClock.uptimeMillis() + jMax;
        this.yb.sendEmptyMessageDelayed(1001, jMax);
    }

    private void c() {
        if (this.cz) {
            return;
        }
        this.fo = (int) Math.max(0L, this.ny - SystemClock.uptimeMillis());
        this.yb.removeMessages(1001);
        this.cz = true;
    }

    private void k() {
        if (!this.cz) {
            return;
        }
        this.cz = false;
        int i = this.fo;
        this.fo = 0;
        hw(i);
    }

    @Override // com.byazt.aa.aj.pr
    public void pr(Message message) {
        int i;
        int i2;
        switch (message.what) {
            case 1001:
                this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
                int i3 = this.lb - 1;
                this.lb = i3;
                if (i3 < 0 && (i2 = this.k) != 0) {
                    hw(i2);
                } else if (i3 > 0 && (i = this.k) != 0) {
                    hw(i);
                } else {
                    this.yb.removeMessages(1001);
                    this.ny = 0L;
                    if (!this.rc) {
                        this.rc = true;
                        g();
                    }
                }
                break;
        }
    }

    public void pr(fw fwVar) {
        if (fwVar != null && !this.z.contains(fwVar)) {
            this.z.add(fwVar);
        }
    }

    private void m() {
        if (this.z.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.z).iterator();
        while (it.hasNext()) {
            ((fw) it.next()).pr(this.m);
        }
    }

    private void g() {
        if (this.z.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.z).iterator();
        while (it.hasNext()) {
            ((fw) it.next()).hw(this.m);
        }
    }

    public String hw() {
        return this.m;
    }
}
