package com.byazt.zb;

import android.text.TextUtils;
import com.byazt.vy.py;
import com.byazt.ws.tj;
import com.byazt.yc.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1166, 19})
public class n {
    public List<Integer> cp;
    public AtomicInteger s = new AtomicInteger(-1);
    public AtomicBoolean q = new AtomicBoolean();
    public final Map<Integer, Boolean> n = new HashMap();
    public final Map<Integer, Boolean> qg = new HashMap();
    public final Map<Integer, AtomicInteger> l = new HashMap();
    public final AtomicInteger w = new AtomicInteger();
    public final AtomicInteger x = new AtomicInteger();
    public final AtomicInteger fs = new AtomicInteger();
    public final List<String> rv = new ArrayList();
    public final AtomicInteger tj = new AtomicInteger(-1000);

    public List<Integer> n() {
        return this.cp;
    }

    public void n(List<Integer> list) {
        this.cp = list;
    }

    public synchronized void n(int i) {
        this.s.set(i);
    }

    public synchronized int qg() {
        return this.s.get();
    }

    public synchronized boolean s() {
        return qg() > 0;
    }

    public synchronized void qg(int i) {
        if (this.tj.get() < i) {
            this.tj.set(i);
        }
        this.n.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean s(int i) {
        Boolean bool = this.n.get(Integer.valueOf(i));
        return bool != null && bool.booleanValue();
    }

    public synchronized void q(int i) {
        this.qg.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean l(int i) {
        Boolean bool = this.qg.get(Integer.valueOf(i));
        return bool != null && bool.booleanValue();
    }

    public synchronized void q() {
        this.q.set(true);
    }

    public synchronized boolean l() {
        return this.q.get();
    }

    public synchronized boolean w() {
        AtomicInteger atomicInteger = this.l.get(-100);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized boolean x() {
        AtomicInteger atomicInteger = this.l.get(0);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized void n(int i, int i2) {
        this.l.put(Integer.valueOf(i), new AtomicInteger(i2));
    }

    public synchronized int w(int i) {
        AtomicInteger atomicInteger = this.l.get(Integer.valueOf(i));
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public synchronized void x(int i) {
        this.w.set(i);
    }

    public synchronized boolean fs() {
        return this.w.get() == 0;
    }

    public synchronized void fs(int i) {
        this.x.set(i);
    }

    public synchronized boolean rv() {
        return this.x.get() == 0;
    }

    public synchronized void rv(int i) {
        this.fs.set(i);
    }

    public synchronized boolean tj() {
        return this.fs.get() == 0;
    }

    public synchronized void n(int i, String str) {
        AtomicInteger atomicInteger = this.l.get(Integer.valueOf(i));
        if (atomicInteger != null && atomicInteger.get() != 0) {
            atomicInteger.decrementAndGet();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.rv.contains(str)) {
            this.rv.add(str);
        }
        if (i < -100 && this.x.get() != 0) {
            this.x.decrementAndGet();
        }
        if (i > 0 && this.fs.get() != 0) {
            this.fs.decrementAndGet();
        }
        if (this.w.get() != 0) {
            this.w.decrementAndGet();
        } else {
            com.byazt.rb.qg.q(MediationConstant.TAG, "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
        }
    }

    public synchronized void n(List<tj> list, List<tj> list2, List<tj> list3) {
        int size;
        if (list != null) {
            if (list.size() != 0) {
                List<tj> listQg = x.qg(list);
                int i = 0;
                if (!py.n(listQg)) {
                    size = listQg.size();
                    for (tj tjVar : listQg) {
                        for (String str : this.rv) {
                            if (!TextUtils.isEmpty(str) && tjVar != null && str.equals(tjVar.cd())) {
                                size--;
                                break;
                            }
                        }
                    }
                } else {
                    size = 0;
                }
                if (size < 0) {
                    size = 0;
                }
                this.fs.set(size);
                int size2 = list.size();
                if (list2 != null) {
                    size2 += list2.size();
                }
                if (list3 != null) {
                    size2 += list3.size();
                }
                for (tj tjVar2 : list) {
                    for (String str2 : this.rv) {
                        if (!TextUtils.isEmpty(str2) && tjVar2 != null && str2.equals(tjVar2.cd())) {
                            size2--;
                            break;
                        }
                    }
                }
                if (!py.n(list2)) {
                    for (tj tjVar3 : list2) {
                        for (String str3 : this.rv) {
                            if (!TextUtils.isEmpty(str3) && tjVar3 != null && str3.equals(tjVar3.cd())) {
                                size2--;
                                break;
                            }
                        }
                    }
                }
                if (!py.n(list3)) {
                    for (tj tjVar4 : list3) {
                        for (String str4 : this.rv) {
                            if (!TextUtils.isEmpty(str4) && tjVar4 != null && str4.equals(tjVar4.cd())) {
                                size2--;
                                break;
                            }
                        }
                    }
                }
                if (size2 >= 0) {
                    i = size2;
                }
                this.w.set(i);
            }
        }
    }

    public synchronized int cp() {
        return this.tj.get();
    }

    public synchronized void d() {
        this.s.set(-1);
        this.q.set(false);
        this.n.clear();
        this.qg.clear();
        this.l.clear();
        this.w.set(0);
        this.rv.clear();
        this.tj.set(-1000);
    }
}
