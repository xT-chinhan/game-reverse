package com.anythink.core.basead.a;

import android.util.Log;
import com.anythink.core.basead.adx.api.IATAdxHandler;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cg;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.o;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b implements IATAdxHandler {
    public static String a = "anythink_adx_handler";
    private ad b;
    private by c;
    private n d;
    private boolean e;
    private boolean f;

    public b(ad adVar, by byVar, n nVar) {
        this.b = adVar;
        this.c = byVar;
        this.d = nVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0075 A[Catch: all -> 0x008c, TryCatch #2 {all -> 0x008c, blocks: (B:15:0x002a, B:17:0x0033, B:23:0x004c, B:25:0x0056, B:26:0x005a, B:28:0x0064, B:22:0x0049, B:30:0x0075, B:31:0x007f, B:33:0x0083, B:34:0x0086, B:19:0x003b), top: B:49:0x002a, outer: #0, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0083 A[Catch: all -> 0x008c, TryCatch #2 {all -> 0x008c, blocks: (B:15:0x002a, B:17:0x0033, B:23:0x004c, B:25:0x0056, B:26:0x005a, B:28:0x0064, B:22:0x0049, B:30:0x0075, B:31:0x007f, B:33:0x0083, B:34:0x0086, B:19:0x003b), top: B:49:0x002a, outer: #0, inners: #1 }] */
    @Override // com.anythink.core.basead.adx.api.IATAdxHandler
    public final synchronized void notifyWin(Map<String, Object> map) {
        cg cgVar;
        if (this.e) {
            Log.e(a, "notifyWin: win or loss has been sent, do anything");
            return;
        }
        this.e = true;
        if (this.b != null && this.c != null) {
            Log.i(a, "notifyWin, extraMap: ".concat(String.valueOf(map)));
            try {
                ad adVar = this.b;
                by byVar = this.c;
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
                        com.anythink.core.common.d.a().a(this.d.aQ(), (String) obj3);
                    }
                    if (dValueOf == null) {
                        dValueOf = Double.valueOf(o.a(byVar));
                        string = "TopOn";
                    }
                    cgVar = adVar.v;
                    if (cgVar != null) {
                        cgVar.a(dValueOf, string);
                    }
                    com.anythink.core.c.d.c.a(adVar, byVar, 4);
                    return;
                }
                if (dValueOf == null) {
                    dValueOf = Double.valueOf(o.a(byVar));
                    string = "TopOn";
                }
                cgVar = adVar.v;
                if (cgVar != null) {
                    cgVar.a(dValueOf, string);
                }
                com.anythink.core.c.d.c.a(adVar, byVar, 4);
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
                ay ayVar = new ay(2, this.c, this.d);
                String string = "";
                if (map != null) {
                    Object obj = map.get("bidding_name");
                    string = obj instanceof String ? obj.toString() : "";
                    Object obj2 = map.get("waterfall_info");
                    if (obj2 instanceof String) {
                        com.anythink.core.common.d.a().a(this.d.aQ(), (String) obj2);
                    }
                }
                try {
                    if (loss_reason == IATAdxHandler.LOSS_REASON.LOSS_TO_AUCTION_FLOOR) {
                        string = "";
                        f fVarA = this.d.a();
                        if (fVarA != null) {
                            fVarA.i();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                ayVar.a(d, string, str);
                com.anythink.core.c.d.c.a(adVar, ayVar, false, 28);
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
        f commonAdManager;
        if (this.f) {
            Log.e(a, "destroy: has call destroy(), do nothing");
            return;
        }
        this.f = true;
        Log.i(a, "destroy, placementId: " + this.d.aQ() + ", adSourceId: " + this.c.G());
        try {
            ad adVar = this.b;
            if (adVar != null && (commonAdManager = adVar.getCommonAdManager()) != null && commonAdManager.e() != null) {
                commonAdManager.e().a(this.d.aQ(), this.c, this.d.aR());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
