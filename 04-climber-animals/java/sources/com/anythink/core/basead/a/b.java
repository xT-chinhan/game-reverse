package com.anythink.core.basead.a;

import android.util.Log;
import com.anythink.core.basead.adx.api.IATAdxHandler;
import com.anythink.core.common.d.t;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.cd;
import com.anythink.core.common.h.n;
import com.anythink.core.common.v.p;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b implements IATAdxHandler {
    public static String a = "anythink_adx_handler";
    private ad b;
    private bv c;
    private n d;
    private boolean e;
    private boolean f;

    public b(ad adVar, bv bvVar, n nVar) {
        this.b = adVar;
        this.c = bvVar;
        this.d = nVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0075 A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:15:0x002a, B:17:0x0033, B:23:0x004c, B:25:0x0056, B:26:0x005a, B:28:0x0064, B:22:0x0049, B:30:0x0075, B:31:0x0089, B:33:0x008d, B:34:0x0090, B:19:0x003b), top: B:46:0x002a, outer: #2, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008d A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:15:0x002a, B:17:0x0033, B:23:0x004c, B:25:0x0056, B:26:0x005a, B:28:0x0064, B:22:0x0049, B:30:0x0075, B:31:0x0089, B:33:0x008d, B:34:0x0090, B:19:0x003b), top: B:46:0x002a, outer: #2, inners: #1 }] */
    @Override // com.anythink.core.basead.adx.api.IATAdxHandler
    public final synchronized void notifyWin(Map<String, Object> map) {
        cd cdVar;
        if (this.e) {
            Log.e(a, "notifyWin: win or loss has been sent, do anything");
            return;
        }
        this.e = true;
        if (this.b != null && this.c != null) {
            Log.i(a, "notifyWin, extraMap: ".concat(String.valueOf(map)));
            try {
                ad adVar = this.b;
                bv bvVar = this.c;
                String string = "";
                Double dValueOf = null;
                if (map != null) {
                    Object obj = map.get("second_price");
                    if (obj != null) {
                        try {
                            dValueOf = Double.valueOf(Double.parseDouble(obj.toString()));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    Object obj2 = map.get("bidding_name");
                    string = obj2 instanceof String ? obj2.toString() : "";
                    Object obj3 = map.get("waterfall_info");
                    if (obj3 instanceof String) {
                        com.anythink.core.common.d.a().a(this.d.aI(), (String) obj3);
                    }
                    if (dValueOf == null) {
                        dValueOf = Double.valueOf(p.a(bvVar));
                        string = "TopOn";
                        new StringBuilder("notifyWin: fix second price to: ").append(dValueOf);
                    }
                    cdVar = adVar.v;
                    if (cdVar != null) {
                        cdVar.a(dValueOf, string);
                    }
                    com.anythink.core.b.d.c.a(adVar, bvVar, 4);
                    return;
                }
                if (dValueOf == null) {
                    dValueOf = Double.valueOf(p.a(bvVar));
                    string = "TopOn";
                    new StringBuilder("notifyWin: fix second price to: ").append(dValueOf);
                }
                cdVar = adVar.v;
                if (cdVar != null) {
                    cdVar.a(dValueOf, string);
                }
                com.anythink.core.b.d.c.a(adVar, bvVar, 4);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
            throw th;
        }
    }

    @Override // com.anythink.core.basead.adx.api.IATAdxHandler
    public final synchronized void notifyLose(IATAdxHandler.LOSS_REASON loss_reason, double d, Map<String, Object> map) {
        String str;
        if (this.e) {
            Log.e(a, "notifyWin: win or loss has been sent, do anything");
            return;
        }
        this.e = true;
        if (this.b != null && this.c != null) {
            if (d <= 0.0d) {
                Log.e(a, "notifyLose, winnerPrice: " + d + " <= 0, do nothing");
                return;
            }
            Log.i(a, "notifyLose, lossCode: " + loss_reason + ", winnerPrice: " + d + ", extraMap: " + map);
            try {
                int i = AnonymousClass1.a[loss_reason.ordinal()];
                if (i != 1) {
                    str = i != 2 ? "103" : "102";
                } else {
                    str = "100";
                }
                ad adVar = this.b;
                aw awVar = new aw(2, this.c, this.d);
                String string = "";
                if (map != null) {
                    Object obj = map.get("bidding_name");
                    string = obj instanceof String ? obj.toString() : "";
                    Object obj2 = map.get("waterfall_info");
                    if (obj2 instanceof String) {
                        com.anythink.core.common.d.a().a(this.d.aI(), (String) obj2);
                    }
                }
                try {
                    if (loss_reason == IATAdxHandler.LOSS_REASON.LOSS_TO_AUCTION_FLOOR) {
                        string = "";
                        f fVarA = f.a(t.b().g(), this.d.aI(), this.d.aK());
                        if (fVarA != null) {
                            fVarA.d();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                awVar.a(d, string, str);
                com.anythink.core.b.d.c.a(adVar, awVar, false, 28);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.a.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[IATAdxHandler.LOSS_REASON.values().length];
            a = iArr;
            try {
                iArr[IATAdxHandler.LOSS_REASON.LOSS_TO_AUCTION_FLOOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IATAdxHandler.LOSS_REASON.LOSS_TO_HIGHER_BID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IATAdxHandler.LOSS_REASON.LOSS_TO_NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.anythink.core.basead.adx.api.IATAdxHandler
    public final synchronized void destroy() {
        if (this.f) {
            Log.e(a, "destroy: has call destroy(), do nothing");
            return;
        }
        this.f = true;
        Log.i(a, "destroy, placementId: " + this.d.aI() + ", adSourceId: " + this.c.z());
        try {
            com.anythink.core.common.a.a().a(this.d.aI(), this.c, this.d.aJ());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
