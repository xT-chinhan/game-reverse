package com.byazt.tl;

import android.content.Context;
import android.graphics.Bitmap;
import com.byazt.imu.s;
import com.byazt.pp.tj;
import com.byazt.pp.w;
import com.byazt.qk.oa;
import com.byazt.qk.x;
import com.byazt.si.cy;
import com.byazt.si.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1454, 19})
public class n {
    public final Context n;
    public final Map<String, Bitmap> qg = new HashMap();
    public final Map<String, w> s = new HashMap();
    public boolean q = false;

    /* JADX INFO: renamed from: com.byazt.tl.n$n, reason: collision with other inner class name */
    public interface InterfaceC0355n {
        void n(String str, w wVar);
    }

    public interface qg {
        void n(String str, Bitmap bitmap);
    }

    public n(Context context) {
        this.n = context;
    }

    public Bitmap n(String str) {
        return this.qg.get(str);
    }

    public w qg(String str) {
        return this.s.get(str);
    }

    public void n(final String str, String str2, final qg qgVar) {
        if (this.q || str2 == null) {
            return;
        }
        s.n(str2).s(2).n(new m<Bitmap>() { // from class: com.byazt.tl.n.1
            @Override // com.byazt.si.m
            public void n(int i, String str3, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                if (n.this.q || cyVar == null || cyVar.s() == null) {
                    return;
                }
                Bitmap bitmapS = cyVar.s();
                n.this.qg.put(str, bitmapS);
                qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n(str, bitmapS);
                }
            }
        });
    }

    public void n(final String str, final String str2, final InterfaceC0355n interfaceC0355n) {
        if (this.q || str2 == null) {
            return;
        }
        com.byazt.phf.s.qg(str2).n(new x() { // from class: com.byazt.tl.n.2
            @Override // com.byazt.qk.x
            public void n(int i, String str3, Throwable th) {
            }

            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (n.this.q) {
                    return;
                }
                if (oaVar != null && oaVar.x() && oaVar.fs() != null) {
                    n.this.n(str, oaVar.fs(), str2, interfaceC0355n);
                } else if (oaVar != null) {
                    oaVar.x();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str, String str2, String str3, final InterfaceC0355n interfaceC0355n) {
        com.byazt.pp.x.n(str2, str3).n(new tj<w>() { // from class: com.byazt.tl.n.4
            @Override // com.byazt.pp.tj
            public void n(w wVar) {
                if (n.this.q || wVar == null) {
                    return;
                }
                n.this.s.put(str, wVar);
                InterfaceC0355n interfaceC0355n2 = interfaceC0355n;
                if (interfaceC0355n2 != null) {
                    interfaceC0355n2.n(str, wVar);
                }
            }
        }).s(new tj<Throwable>() { // from class: com.byazt.tl.n.3
            @Override // com.byazt.pp.tj
            public void n(Throwable th) {
                if (th != null) {
                    th.getMessage();
                }
            }
        });
    }

    public void n() {
        this.q = true;
        this.qg.clear();
        this.s.clear();
    }
}
