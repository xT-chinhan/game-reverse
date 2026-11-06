package com.bytedance.sdk.component.x.xr.xr.ah;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends d implements Handler.Callback {
    private static int ao = 200;
    private static int ub = 10;
    private int ab;
    private com.bytedance.sdk.component.x.xr.ms.xr b;
    private final int c;
    private final long ch;
    private final Object d;
    private final String h;
    private volatile Handler hi;
    private ka ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected com.bytedance.sdk.component.x.xr.ms.ka f1583ms;
    private final HashMap<String, List<com.bytedance.sdk.component.x.ms.xr>> nw;
    private final long ny;
    private final String qv;
    private final List<com.bytedance.sdk.component.x.ms.xr> sl;
    private volatile String t;
    private volatile boolean u;
    private final AtomicInteger x;
    private volatile int y;
    private final List<com.bytedance.sdk.component.x.ms.xr> zb;

    public xr(com.bytedance.sdk.component.x.ms.ka kaVar, com.bytedance.sdk.component.x.xr.xr.xr xrVar) {
        super(kaVar, xrVar);
        this.d = new Object();
        this.c = 50;
        this.ab = 30;
        this.x = new AtomicInteger(0);
        this.ny = 5000L;
        this.ch = 5000000000L;
        this.sl = new ArrayList();
        this.zb = new CopyOnWriteArrayList();
        this.u = false;
        this.h = "after_upload";
        this.qv = "prepare_upload";
        this.y = 0;
        this.t = "DEFAULT";
        this.nw = new HashMap<>();
        this.f1583ms = new com.bytedance.sdk.component.x.xr.ms.ah(kaVar, this);
        this.ka = new ka(this.xr, this.ah);
    }

    public com.bytedance.sdk.component.x.xr.ms.ka ms() {
        return this.f1583ms;
    }

    public Handler xr() {
        return this.hi;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            boolean zMs = this.xr.d().ms(this.xr.getContext());
            if (i == 1) {
                synchronized (xr.class) {
                    if (!this.zb.isEmpty()) {
                        int size = this.zb.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ms(this.zb.get(i2), 1, zMs);
                        }
                    }
                    this.u = true;
                    this.zb.clear();
                }
            } else if (i == 3) {
                xr(3, zMs);
            } else if (i == 5) {
                ArrayList arrayList = new ArrayList(this.sl);
                this.sl.clear();
                ms(arrayList, false, "timeout_dispatch", 5);
            } else if (i == 74) {
                ms((com.bytedance.sdk.component.x.ms.xr) message.obj, 74, zMs);
            } else if (i == 71) {
                ms(71, zMs);
            } else if (i == 72) {
                ms(72, zMs);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_ms", "error:" + th.getMessage(), this.xr);
        }
        return true;
    }

    private void ms(int i, boolean z) {
        xr((com.bytedance.sdk.component.x.ms.xr) null, i, z);
    }

    private void xr(int i, boolean z) {
        xr((com.bytedance.sdk.component.x.ms.xr) null, i, z);
    }

    @Override // com.bytedance.sdk.component.x.xr.xr.ah.d
    public void ah() {
        super.ah();
        this.hi = new Handler(ab(), this);
        this.ah.ms(this.hi);
        this.hi.sendEmptyMessage(1);
    }

    public boolean ms(int i, String str, com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (this.xr == null) {
            return false;
        }
        return this.f1583ms.ms(i, str, xrVar);
    }

    public void ms(com.bytedance.sdk.component.x.ms.xr xrVar, boolean z) {
        if (xrVar == null) {
            return;
        }
        if (z) {
            if (this.hi != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(xrVar);
                ms(arrayList, true, "ignore_result_dispatch", -1);
                return;
            }
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "other thread handler is null，ignore is true", this.xr);
            return;
        }
        if (this.u) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = xrVar;
            messageObtain.what = 74;
            this.hi.sendMessage(messageObtain);
            return;
        }
        this.zb.add(xrVar);
    }

    public void ms(int i, String str) {
        try {
            if (!this.xr.d().ms(this.xr.getContext())) {
                com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "AdThread NET IS NOT AVAILABLE", this.xr);
                return;
            }
            boolean zMs = ms(i, str + " check", (com.bytedance.sdk.component.x.ms.xr) null);
            com.bytedance.sdk.component.x.xr.ah.ah.xr("_flush", "notify runOnce check: ".concat(String.valueOf(zMs)), this.xr);
            if (zMs) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                this.hi.sendMessage(messageObtain);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah(th.getMessage(), this.xr);
        }
    }

    private void ms(com.bytedance.sdk.component.x.ms.xr xrVar, int i, boolean z) {
        try {
            ms(xrVar);
            xr(xrVar, i, z);
        } catch (Throwable th) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "run exception:" + th.getMessage(), this.xr);
            com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ah(), 1, this.xr);
        }
    }

    private void ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        this.x.set(0);
        com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.hi(), 1, this.xr);
        this.f1583ms.ms(xrVar);
        com.bytedance.sdk.component.x.xr.ah.ms.ms(xrVar, this.xr, "_ad");
        com.bytedance.sdk.component.x.xr.ah.ms.x(xrVar, this.xr);
    }

    private boolean xr(com.bytedance.sdk.component.x.ms.xr xrVar, boolean z) {
        return com.bytedance.sdk.component.x.xr.ah.ms.ms(this.xr) && this.xr.ah();
    }

    public boolean d() {
        return com.bytedance.sdk.component.x.xr.ah.ms.ms(this.xr) && this.ah.ah();
    }

    private void xr(com.bytedance.sdk.component.x.ms.xr xrVar, int i, boolean z) {
        if (xr(xrVar, z)) {
            com.bytedance.sdk.component.x.xr.ah.ah.ms("_error", " upload cancel cause config " + com.bytedance.sdk.component.x.xr.ah.ms.ah(xrVar, this.xr), this.xr);
            return;
        }
        boolean zD = d();
        boolean z2 = false;
        boolean z3 = com.bytedance.sdk.component.x.xr.ah.ms.ny(xrVar, this.xr) || i == 3;
        boolean zMs = com.bytedance.sdk.component.x.xr.ah.ms.ms(i);
        com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "serbusy:" + zD + " isCsjBusy:" + z3 + " flush:" + zMs, this.xr);
        if (zD && !zMs && z3) {
            if (i == 3) {
                com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "start do flush", this.xr);
                ms(72, z);
                return;
            } else {
                if (i == 74 || i == 1) {
                    boolean zHasMessages = this.hi.hasMessages(3);
                    com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(zHasMessages)), this.xr);
                    if (zHasMessages) {
                        return;
                    }
                    this.ka.ms(3, 15000L, this.hi);
                    return;
                }
                com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "server busy", this.xr);
                return;
            }
        }
        if (!z) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "AdThread NET IS NOT AVAILABLE!!!", this.xr);
            return;
        }
        boolean zMs2 = ms(i, "needUpload check", xrVar);
        if (zMs2) {
            List<com.bytedance.sdk.component.x.ms.xr> listMs = this.f1583ms.ms(i, xrVar, zD, this.y + "_" + this.t);
            if (listMs != null && listMs.size() != 0) {
                com.bytedance.sdk.component.x.xr.ah.ah.xr("_ms", "prepare get size =" + listMs.size(), this.xr);
                ms(listMs, i);
            } else {
                com.bytedance.sdk.component.x.xr.ah.ah.xr("_ms", "prepare get no event need upload", this.xr);
                ms("prepare_upload");
            }
            com.bytedance.sdk.component.x.xr.ah.ah.ms("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)), this.xr);
        }
        com.bytedance.sdk.component.x.xr.ah.ah.xr("_ms", "prepare upload no need", this.xr);
        this.nw.clear();
        ms("prepare_upload");
        z2 = zMs2;
        com.bytedance.sdk.component.x.xr.ah.ah.ms("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)), this.xr);
    }

    private void ms(String str) {
        if (this.sl.size() != 0) {
            com.bytedance.sdk.component.x.ms.d dVarD = this.xr.d();
            if (this.hi.hasMessages(5)) {
                this.hi.removeMessages(5);
            }
            long jAh = ao;
            if (dVarD != null && dVarD.u() != null) {
                jAh = dVarD.u().ah();
            }
            this.hi.sendEmptyMessageDelayed(5, jAh);
            this.sl.size();
            return;
        }
        com.bytedance.sdk.component.x.xr.ah.ah.ms("_ms", "do nothing", this.xr);
    }

    private void ms(List<com.bytedance.sdk.component.x.ms.xr> list, String str, int i) {
        ms(list, false, str, i);
    }

    private void ms(List<com.bytedance.sdk.component.x.ms.xr> list, int i) {
        com.bytedance.sdk.component.x.xr.ah.ms.ms(list, this.xr);
        com.bytedance.sdk.component.x.ms.xr xrVar = list.get(0);
        if (xrVar == null) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "adLogEvent is null", this.xr);
            return;
        }
        if (list.size() > 1 || com.bytedance.sdk.component.x.xr.ah.ms.xr(this.xr) || com.bytedance.sdk.component.x.xr.ah.ms.d(this.xr)) {
            if (xrVar.d() == 0 && xrVar.ka() == 2 && i == 74) {
                if (xrVar.xr() == 3) {
                    ms(list, "version_v3_batch", i);
                    return;
                } else {
                    xr(list, "batchOptimize", i);
                    return;
                }
            }
            ms(list, "batchRead", i);
            return;
        }
        if (xrVar.ka() == 1) {
            ms(list, "highPriority", i);
            return;
        }
        if (xrVar.d() == 0 && xrVar.ka() == 2) {
            if (xrVar.xr() == 3) {
                ms(list, "version_v3_single_directly", i);
                return;
            } else {
                xr(list, "singleOptimize", i);
                return;
            }
        }
        if (xrVar.d() == 1) {
            ms(list, "stats_directly", i);
            return;
        }
        if (xrVar.d() == 3) {
            ms(list, "adType_v3_directly", i);
        } else if (xrVar.d() == 2) {
            ms(list, "other_directly", i);
        } else {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "adLogEvent adType error", this.xr);
        }
    }

    private void xr(List<com.bytedance.sdk.component.x.ms.xr> list, String str, int i) {
        this.sl.addAll(list);
        com.bytedance.sdk.component.x.ms.d dVarD = this.xr.d();
        if (dVarD != null && dVarD.u() != null) {
            ub = dVarD.u().d();
        }
        if (this.sl.size() >= ub) {
            if (this.hi.hasMessages(5)) {
                this.hi.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.sl);
            this.sl.clear();
            ms(arrayList, false, "max_size_dispatch", i);
            return;
        }
        ms(str);
    }

    private void ms(List<com.bytedance.sdk.component.x.ms.xr> list, boolean z, String str, int i) {
        this.ka.ms(list, z, str, i, this.d, this.b);
        if (z) {
            return;
        }
        ms(i);
    }

    private void ms(int i) {
        ms("after_upload");
        com.bytedance.sdk.component.x.xr.ah.ms.xr(i);
        if (i == 72) {
            synchronized (this.d) {
                try {
                    try {
                        long jNanoTime = System.nanoTime();
                        this.d.wait(5000L);
                        long jNanoTime2 = System.nanoTime() - jNanoTime;
                        if (jNanoTime2 < 5000000000L && 5000000000L - jNanoTime2 >= 50000000) {
                            if (d()) {
                                com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "return wait serverBusy", this.xr);
                                return;
                            }
                            if (this.ah.d()) {
                                com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "return wait otherError", this.xr);
                                return;
                            }
                            com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.xr(), 1, this.xr);
                            int i2 = this.ab + 1;
                            this.ab = i2;
                            if (i2 < 50) {
                                com.bytedance.sdk.component.x.xr.ah.ah.xr("_flush", "afterUpload send flush again:" + this.ab, this.xr);
                                ms(72, "continue");
                            } else {
                                this.ab = 0;
                                if (this.hi.hasMessages(72)) {
                                    this.hi.removeMessages(72);
                                }
                                com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "afterUpload send flush end:" + this.ab, this.xr);
                            }
                            return;
                        }
                        com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "return wait timeout", this.xr);
                    } catch (InterruptedException e) {
                        com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "wait exception:" + e.getMessage(), this.xr);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            this.ab = 0;
            if (this.hi.hasMessages(72)) {
                this.hi.removeMessages(72);
            }
        }
    }
}
