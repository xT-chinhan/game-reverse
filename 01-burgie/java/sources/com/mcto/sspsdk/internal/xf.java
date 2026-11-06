package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fi.BaseConstants;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class xf implements w3 {
    public static volatile xf g;
    public ag b;
    public vf c;
    public final wf d;
    public final boolean f;
    public final LinkedList a = new LinkedList();
    public boolean e = false;

    public xf() {
        this.f = false;
        synchronized (this) {
            if ("1".equals(nh.a(jd.a).a("rao"))) {
                jd.d.add(this);
                a(Boolean.valueOf(jd.e));
                wf wfVar = new wf(this);
                this.d = wfVar;
                wfVar.start();
                this.f = true;
            }
        }
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            b();
            return;
        }
        synchronized (this) {
            if (!this.e) {
                this.e = true;
                vf vfVar = this.c;
                if (vfVar != null) {
                    vfVar.removeCallbacksAndMessages(null);
                }
            }
        }
    }

    public final synchronized void b() {
        if (this.e) {
            this.e = false;
            c();
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0015 A[Catch: all -> 0x0028, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:9:0x0015, B:11:0x0019, B:13:0x001d), top: B:19:0x0001 }] */
    public final synchronized void c() {
        vf vfVar;
        if (this.f) {
            if (this.b == null) {
                ag agVar = (ag) this.a.poll();
                this.b = agVar;
                if (agVar != null) {
                    if (!this.e && (vfVar = this.c) != null) {
                        vfVar.sendEmptyMessageDelayed(0, this.b.e);
                    }
                }
            } else if (!this.e) {
                vfVar.sendEmptyMessageDelayed(0, this.b.e);
            }
        }
    }

    public static xf a() {
        if (g == null) {
            synchronized (xf.class) {
                if (g == null) {
                    g = new xf();
                }
            }
        }
        return g;
    }

    public final synchronized void a(ag agVar) {
        if (this.f) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(agVar.b, ((ag) it.next()).b)) {
                }
            }
            agVar.toString();
            if (this.a.isEmpty() && this.b == null) {
                agVar.e = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
            } else {
                agVar.e = BaseConstants.Time.MINUTE;
            }
            this.a.addLast(agVar);
            if (this.b == null) {
                c();
            }
        }
    }
}
