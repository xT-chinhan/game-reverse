package com.byazt.on;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import com.anythink.core.common.f.e;
import com.byazt.et.x;
import com.byazt.sx.q;
import com.byazt.xz.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.loader.ApiSpUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 789, 8})
public class s implements com.byazt.sx.n, com.byazt.sx.s {
    public final q s;
    public final Map<String, n> n = new HashMap();
    public final Map<String, Integer> qg = new HashMap();
    public final Handler q = new Handler(Looper.getMainLooper());

    public s(q qVar) {
        this.s = qVar;
    }

    @com.byazt.cp.n(n = {0, 1, 789, 546})
    private static class n {
        public long a;
        public boolean cd;
        public int cp;
        public boolean cy;
        public int d;
        public boolean fs;
        public WeakReference<x> h;
        public boolean hd;
        public WeakReference<View> hu;
        public boolean k;
        public int l;
        public String m;
        public String n;
        public int oa;
        public long ou;
        public int py;
        public int q;
        public int qg;
        public boolean rv;
        public int s;
        public int sz;
        public l t;
        public boolean tj;
        public boolean um;
        public qg ur;
        public int w;
        public int wm;
        public int x;

        private n() {
            this.n = "";
            this.qg = 0;
            this.s = 1;
            this.q = 0;
            this.l = 0;
            this.w = 0;
            this.x = 100;
            this.cp = 0;
            this.d = 0;
            this.sz = 0;
        }
    }

    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "timer".equals(str);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, l lVar) {
        String strN = com.byazt.sx.qg.n(str, i);
        n nVar = this.n.get(strN);
        boolean z = nVar != null;
        if (nVar == null) {
            nVar = new n();
            nVar.ur = new qg(this, strN);
            this.n.put(strN, nVar);
        }
        nVar.t = lVar;
        nVar.m = str;
        View viewN = n(map2);
        if (viewN != null) {
            nVar.hu = new WeakReference<>(viewN);
        }
        x xVarQg = qg(map2);
        if (xVarQg != null) {
            nVar.h = new WeakReference<>(xVarQg);
        }
        if (z && nVar.cy && !nVar.um) {
            return true;
        }
        n(nVar, map);
        if (n(strN, nVar)) {
            return true;
        }
        int i2 = nVar.q;
        if (i2 != 1) {
            if (i2 == 2) {
                nVar.k = true;
            } else {
                s(strN, nVar);
            }
        } else if (viewN == null || viewN.getVisibility() != 0) {
            nVar.k = true;
        } else {
            s(strN, nVar);
        }
        return true;
    }

    private boolean n(String str, n nVar) {
        Integer numRemove = this.qg.remove(str);
        if (numRemove == null) {
            return false;
        }
        nVar.sz = numRemove.intValue();
        if (numRemove.intValue() == 0) {
            nVar.cy = true;
            nVar.um = true;
            return true;
        }
        s(str, nVar);
        return true;
    }

    private void qg(String str, n nVar) {
        if (nVar == null || !nVar.cy || nVar.fs) {
            return;
        }
        this.qg.put(str, Integer.valueOf(nVar.um ? 0 : nVar.sz));
    }

    private static void n(n nVar, Map<String, Object> map) {
        if (map == null) {
            nVar.n = "";
            nVar.q = 0;
            nVar.l = 0;
            nVar.s = 1;
            nVar.sz = 1;
            nVar.qg = 0;
            nVar.x = 100;
            nVar.fs = false;
            nVar.rv = false;
            nVar.tj = false;
            nVar.cp = 0;
            nVar.d = 0;
            return;
        }
        Object obj = map.get(TapEventParamConstants.PARAM_NAME);
        nVar.n = obj != null ? String.valueOf(obj) : "";
        Object obj2 = map.get("condition");
        nVar.q = obj2 == null ? 0 : com.byazt.hb.s.n(String.valueOf(obj2), 0);
        Object obj3 = map.get("pauseMode");
        nVar.l = obj3 == null ? 0 : com.byazt.hb.s.n(String.valueOf(obj3), 0);
        Object obj4 = map.get("loop");
        nVar.s = obj4 == null ? 1 : com.byazt.hb.s.n(String.valueOf(obj4), 1);
        nVar.sz = nVar.s <= 0 ? -1 : nVar.s;
        Object obj5 = map.get(MediationConstant.EXTRA_DURATION);
        boolean z = obj5 != null;
        nVar.qg = z ? com.byazt.hb.s.n(String.valueOf(obj5), 0) : 0;
        Object obj6 = map.get(ApiSpUtils.SP_INTERVAL);
        int iN = obj6 == null ? 100 : com.byazt.hb.s.n(String.valueOf(obj6), 100);
        nVar.x = iN > 0 ? iN : 100;
        Object obj7 = map.get("from");
        Object obj8 = map.get("to");
        nVar.fs = (z || (obj7 == null && obj8 == null)) ? false : true;
        nVar.cp = obj7 == null ? 0 : com.byazt.hb.s.n(String.valueOf(obj7), 0);
        nVar.d = obj8 == null ? 0 : com.byazt.hb.s.n(String.valueOf(obj8), 0);
        Object obj9 = map.get("sendFrom");
        nVar.rv = (obj9 == null ? 0 : com.byazt.hb.s.n(String.valueOf(obj9), 0)) == 1;
        Object obj10 = map.get("disableRepeatStart");
        nVar.tj = (obj10 == null ? 0 : com.byazt.hb.s.n(String.valueOf(obj10), 0)) == 1;
    }

    private void s(String str, n nVar) {
        if (nVar.cy) {
            return;
        }
        nVar.cy = true;
        nVar.k = false;
        nVar.hd = false;
        nVar.cd = false;
        nVar.py = 0;
        nVar.wm = 0;
        nVar.um = false;
        nVar.w = 0;
        n(nVar, true);
        if (nVar.fs) {
            nVar.oa = nVar.cp;
            if (nVar.rv) {
                n(nVar, nVar.oa);
            }
            if (nVar.cp == nVar.d) {
                x(str, nVar);
            } else {
                qg(str, nVar, nVar.x);
            }
        } else {
            n(str, nVar, nVar.qg);
        }
        n(str, nVar, true);
    }

    private static void n(String str, n nVar, int i) {
        nVar.ur.removeMessages(2001);
        long jMax = Math.max(0, i);
        nVar.a = SystemClock.uptimeMillis() + jMax;
        nVar.ur.sendMessageDelayed(nVar.ur.obtainMessage(2001, str), jMax);
    }

    private static void qg(String str, n nVar, int i) {
        if (nVar.fs) {
            nVar.ur.removeMessages(2002);
            long jMax = Math.max(0, i);
            nVar.ou = SystemClock.uptimeMillis() + jMax;
            nVar.ur.sendMessageDelayed(nVar.ur.obtainMessage(2002, str), jMax);
        }
    }

    private static boolean n(n nVar) {
        if (nVar.hd) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        nVar.py = (int) Math.max(0L, nVar.a - jUptimeMillis);
        nVar.wm = nVar.ou != 0 ? (int) Math.max(0L, nVar.ou - jUptimeMillis) : 0;
        nVar.ur.removeMessages(2001);
        nVar.ur.removeMessages(2002);
        nVar.hd = true;
        return true;
    }

    private static boolean q(String str, n nVar) {
        if (!nVar.hd) {
            return false;
        }
        nVar.hd = false;
        if (!nVar.fs) {
            int i = nVar.py;
            nVar.py = 0;
            n(str, nVar, i);
        }
        int i2 = nVar.wm;
        nVar.wm = 0;
        qg(str, nVar, i2);
        return true;
    }

    private void n(String str, n nVar, boolean z) {
        if (!nVar.cy || nVar.um) {
            return;
        }
        View view = nVar.hu == null ? null : nVar.hu.get();
        if ((nVar.l & 2) != 0 && view != null && view.getVisibility() != 0) {
            nVar.w |= 2;
        }
        if ((nVar.l & 1) != 0 && view != null && !view.hasWindowFocus()) {
            nVar.w |= 1;
        }
        if (nVar.w != 0) {
            if (!n(nVar) || z) {
                return;
            }
            nVar.cd = true;
            n(nVar, "pause");
            return;
        }
        if (q(str, nVar) && nVar.cd) {
            nVar.cd = false;
            n(nVar, "resume");
        }
    }

    public void n(String str, int i, int i2) {
        String strN = com.byazt.sx.qg.n(str, i);
        n nVar = this.n.get(strN);
        if (nVar == null) {
            return;
        }
        if (nVar.q == 1 && i2 == 0) {
            if (nVar.k) {
                s(strN, nVar);
            } else if (nVar.um && !nVar.tj) {
                l(strN, nVar);
            }
        }
        if (!nVar.cy || (nVar.l & 2) == 0) {
            return;
        }
        if (i2 == 0) {
            nVar.w &= -3;
        } else {
            nVar.w |= 2;
        }
        n(strN, nVar, false);
    }

    public void n(String str, int i, boolean z) {
        String strN = com.byazt.sx.qg.n(str, i);
        n nVar = this.n.get(strN);
        if (nVar == null || !nVar.cy || (nVar.l & 1) == 0) {
            return;
        }
        if (z) {
            nVar.w &= -2;
        } else {
            nVar.w |= 1;
        }
        n(strN, nVar, false);
    }

    public void n(final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(z);
        } else {
            this.q.post(new Runnable() { // from class: com.byazt.on.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.this.qg(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        for (Map.Entry<String, n> entry : this.n.entrySet()) {
            String key = entry.getKey();
            n value = entry.getValue();
            if (value != null && value.cy && !value.um && (value.l & 1) != 0) {
                if (z) {
                    value.w &= -2;
                    if (value.w == 0 && q(key, value) && value.cd) {
                        value.cd = false;
                        n(value, "resume");
                    }
                } else {
                    value.w |= 1;
                    if (n(value) && !value.cd) {
                        value.cd = true;
                        n(value, "pause");
                    }
                }
            }
        }
    }

    public void qg(String str, int i) {
        String strN = com.byazt.sx.qg.n(str, i);
        n nVar = this.n.get(strN);
        if (nVar == null) {
            return;
        }
        if (nVar.q == 2 && nVar.k) {
            s(strN, nVar);
        } else {
            if (!nVar.um || nVar.tj) {
                return;
            }
            l(strN, nVar);
        }
    }

    private void l(String str, n nVar) {
        nVar.ur.removeMessages(2001);
        nVar.ur.removeMessages(2002);
        nVar.a = 0L;
        nVar.ou = 0L;
        nVar.sz = nVar.s <= 0 ? -1 : nVar.s;
        nVar.cy = false;
        nVar.um = false;
        s(str, nVar);
    }

    public void s(String str, int i) {
        n nVar = this.n.get(com.byazt.sx.qg.n(str, i));
        if (nVar == null || !nVar.cy || nVar.um) {
            return;
        }
        nVar.w |= 4;
        if (!n(nVar) || nVar.cd) {
            return;
        }
        nVar.cd = true;
        n(nVar, "pause");
    }

    public void q(String str, int i) {
        String strN = com.byazt.sx.qg.n(str, i);
        n nVar = this.n.get(strN);
        if (nVar == null || !nVar.cy || nVar.um) {
            return;
        }
        nVar.w &= -5;
        if (nVar.w == 0 && q(strN, nVar) && nVar.cd) {
            nVar.cd = false;
            n(nVar, "resume");
        }
    }

    public void l(String str, int i) {
        n nVar = this.n.get(com.byazt.sx.qg.n(str, i));
        if (nVar == null || nVar.um) {
            return;
        }
        nVar.ur.removeMessages(2001);
        nVar.ur.removeMessages(2002);
        nVar.a = 0L;
        nVar.ou = 0L;
        nVar.k = false;
        nVar.hd = false;
        nVar.um = true;
    }

    public String w(String str, int i) {
        n nVar = this.n.get(com.byazt.sx.qg.n(str, i));
        return nVar == null ? "" : nVar.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        n nVar = this.n.get(str);
        if (nVar == null) {
            return;
        }
        if (nVar.um) {
            nVar.ur.removeMessages(2001);
            nVar.ur.removeMessages(2002);
            return;
        }
        l lVar = nVar.t;
        if (lVar != null) {
            lVar.n();
        }
        nVar.sz--;
        if ((nVar.s <= 0 || nVar.sz > 0) && nVar.qg != 0) {
            n(str, nVar, nVar.qg);
            return;
        }
        nVar.ur.removeMessages(2001);
        nVar.ur.removeMessages(2002);
        nVar.a = 0L;
        nVar.ou = 0L;
        if (nVar.um) {
            return;
        }
        nVar.um = true;
        n(nVar, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str) {
        n nVar = this.n.get(str);
        if (nVar == null || !nVar.cy || nVar.hd || nVar.um || !nVar.fs) {
            return;
        }
        w(str, nVar);
    }

    private void w(String str, n nVar) {
        int iMax;
        int i = nVar.x;
        if (nVar.cp <= nVar.d) {
            iMax = Math.min(nVar.d, nVar.oa + i);
        } else {
            iMax = Math.max(nVar.d, nVar.oa - i);
        }
        nVar.oa = iMax;
        n(nVar, iMax);
        if (iMax == nVar.d) {
            x(str, nVar);
        } else {
            qg(str, nVar, nVar.x);
        }
    }

    private void x(String str, n nVar) {
        nVar.ur.removeMessages(2001);
        nVar.ur.removeMessages(2002);
        nVar.a = 0L;
        nVar.ou = 0L;
        if (nVar.um) {
            return;
        }
        l lVar = nVar.t;
        if (lVar != null) {
            lVar.n();
        }
        nVar.um = true;
        n(nVar, false);
    }

    private void n(n nVar, int i) {
        if (nVar == null || this.s == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(TapEventParamConstants.PARAM_NAME, nVar.n);
        map.put(e.a.d, Integer.valueOf(i));
        try {
            this.s.n(nVar.m, "tick", map);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static View n(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("view");
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    private static x qg(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("eventMonitor");
        if (obj instanceof x) {
            return (x) obj;
        }
        return null;
    }

    private void n(n nVar, boolean z) {
        x xVar;
        n(nVar, z ? "start" : "complete");
        if (nVar == null || nVar.h == null || (xVar = nVar.h.get()) == null) {
            return;
        }
        try {
            if (z) {
                xVar.n(nVar.n);
            } else {
                xVar.qg(nVar.n);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void n(n nVar, String str) {
        if (nVar == null || this.s == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(TapEventParamConstants.PARAM_NAME, nVar.n);
        map.put(WebLoginFragment.QUERY_KEY_ID, str);
        try {
            this.s.n(nVar.m, "timerState", map);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 789, 782})
    private static final class qg extends Handler {
        public final WeakReference<s> n;
        public final String qg;

        public qg(s sVar, String str) {
            super(Looper.getMainLooper());
            this.n = new WeakReference<>(sVar);
            this.qg = str;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            s sVar = this.n.get();
            if (sVar == null) {
                return;
            }
            String str = message.obj instanceof String ? (String) message.obj : this.qg;
            int i = message.what;
            if (i == 2001) {
                sVar.s(str);
            } else {
                if (i != 2002) {
                    return;
                }
                sVar.q(str);
            }
        }
    }

    @Override // com.byazt.sx.n
    public void n(String str, int i) {
        String strN = com.byazt.sx.qg.n(str, i);
        n nVarRemove = this.n.remove(strN);
        qg(strN, nVarRemove);
        qg(nVarRemove);
    }

    @Override // com.byazt.sx.n
    public void n(String str) {
        String strN = com.byazt.sx.qg.n(str);
        Iterator<Map.Entry<String, n>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, n> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strN)) {
                qg(next.getValue());
                it.remove();
            }
        }
        Iterator<Map.Entry<String, Integer>> it2 = this.qg.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, Integer> next2 = it2.next();
            if (next2.getKey() != null && next2.getKey().startsWith(strN)) {
                it2.remove();
            }
        }
    }

    private static void qg(n nVar) {
        if (nVar == null) {
            return;
        }
        if (nVar.ur != null) {
            nVar.ur.removeCallbacksAndMessages(null);
        }
        nVar.t = null;
        nVar.hu = null;
        nVar.h = null;
    }
}
