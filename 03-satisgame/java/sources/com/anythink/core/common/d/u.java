package com.anythink.core.common.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.core.activity.AnyThinkGdprAuthActivity;
import com.anythink.core.api.ATGDPRAuthCallback;
import com.anythink.core.api.AdError;
import com.anythink.core.api.NetTrafficeCallback;
import com.anythink.core.common.u.ad;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class u {
    public static final int a = -100;
    private static volatile u e;
    Context b;
    int c;
    private final String d = "u";
    private ConcurrentHashMap<Integer, Boolean> f = new ConcurrentHashMap<>(5);

    public interface a extends NetTrafficeCallback {
        void a(boolean z, boolean z2);
    }

    private u(Context context) {
        this.c = 2;
        if (context != null) {
            this.b = context.getApplicationContext();
            if (s.b().g() == null) {
                s.b().a(this.b);
            }
        }
        this.c = ad.b(this.b, t.b.a, t.a.p, 2);
    }

    public static u a(Context context) {
        if (e == null) {
            synchronized (u.class) {
                if (e == null) {
                    e = new u(context);
                }
            }
        }
        return e;
    }

    public final void a(int i) {
        this.c = i;
        ad.a(this.b, t.b.a, t.a.p, i);
    }

    public final int a() {
        return this.c;
    }

    public final boolean b() {
        try {
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.b).b(s.b().p());
            if (bVarB != null && !bVarB.J()) {
                if (bVarB.Y() == 0) {
                    return true;
                }
                int iV = this.c;
                if (bVarB.W() == 1) {
                    iV = bVarB.V();
                }
                return iV == 0;
            }
            return this.c != 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean c() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.b).b(s.b().p());
        if (bVarB == null || bVarB.J()) {
            return this.c != 1;
        }
        if (this.c == 2) {
            return bVarB.Y() == 0;
        }
        if (bVarB.W() == 1) {
            return bVarB.V() == 0;
        }
        return this.c == 0 || bVarB.Y() == 0;
    }

    public final boolean b(int i) {
        if (com.anythink.core.common.i.a.a().b()) {
            return com.anythink.core.common.i.a.a().a(this.b, i);
        }
        return c();
    }

    public final boolean d() {
        return ad.b(this.b, t.b.a, t.a.x, -100) == 1;
    }

    private int f() {
        return ad.b(this.b, t.b.a, t.a.x, -100);
    }

    public final int e() {
        return ad.b(this.b, t.b.a, t.a.y, -100);
    }

    public final void a(final Context context, final ATGDPRAuthCallback aTGDPRAuthCallback) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.d.u.1
            @Override // java.lang.Runnable
            public final void run() {
                AnyThinkGdprAuthActivity.mCallback = aTGDPRAuthCallback;
                Intent intent = new Intent(context, (Class<?>) AnyThinkGdprAuthActivity.class);
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
                context.startActivity(intent);
            }
        });
    }

    public final void a(final int i, final boolean z) {
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cZ, new Runnable() { // from class: com.anythink.core.common.d.u.3
            @Override // java.lang.Runnable
            public final void run() {
                if (!u.this.c(i) || u.this.b(i, z)) {
                    u uVarA = u.a(s.b().g());
                    com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
                    if (TextUtils.isEmpty(com.anythink.core.common.i.a.a().c())) {
                        if (uVarA.c == 2 && bVarB.Y() == 1 && bVarB.L() == 0) {
                            com.anythink.core.common.t.f.a(1, uVarA.c, bVarB.Y(), i);
                        }
                        if (uVarA.c == 1 && bVarB.W() == 0 && bVarB.Y() == 0) {
                            com.anythink.core.common.t.f.a(2, uVarA.c, bVarB.Y(), i);
                        }
                    } else {
                        com.anythink.core.common.t.f.a(3, !z ? 1 : 0, bVarB.Y(), i);
                    }
                    u.this.f.put(Integer.valueOf(i), Boolean.valueOf(z));
                }
            }
        }));
    }

    public final boolean c(int i) {
        return this.f.get(Integer.valueOf(i)) != null;
    }

    public final boolean b(int i, boolean z) {
        return this.f.get(Integer.valueOf(i)) == null || this.f.get(Integer.valueOf(i)).booleanValue() != z;
    }

    public final void a(final NetTrafficeCallback netTrafficeCallback, String str) {
        int iB = ad.b(this.b, t.b.a, t.a.x, -100);
        int iE = e();
        if (iB == -100 || iE == -100) {
            new com.anythink.core.common.l.r(str).a(0, new com.anythink.core.common.l.s() { // from class: com.anythink.core.common.d.u.2
                @Override // com.anythink.core.common.l.s
                public final void onLoadCanceled(int i) {
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadStart(int i) {
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadFinish(int i, Object obj) {
                    try {
                        if (!(obj instanceof JSONObject)) {
                            NetTrafficeCallback netTrafficeCallback2 = netTrafficeCallback;
                            if (netTrafficeCallback2 != null) {
                                netTrafficeCallback2.onErrorCallback("There is no result.");
                                return;
                            }
                            return;
                        }
                        JSONObject jSONObject = (JSONObject) obj;
                        if (!jSONObject.has("is_eu")) {
                            NetTrafficeCallback netTrafficeCallback3 = netTrafficeCallback;
                            if (netTrafficeCallback3 != null) {
                                netTrafficeCallback3.onErrorCallback("There is no result.");
                                return;
                            }
                            return;
                        }
                        int iOptInt = jSONObject.optInt("is_eu");
                        boolean z = true;
                        int iOptInt2 = jSONObject.optInt("pre_sw", 1);
                        NetTrafficeCallback netTrafficeCallback4 = netTrafficeCallback;
                        if (netTrafficeCallback4 != null) {
                            if (netTrafficeCallback4 instanceof a) {
                                a aVar = (a) netTrafficeCallback4;
                                boolean z2 = iOptInt == 1;
                                if (iOptInt2 != 1) {
                                    z = false;
                                }
                                aVar.a(z2, z);
                                return;
                            }
                            if (iOptInt != 1) {
                                z = false;
                            }
                            netTrafficeCallback4.onResultCallback(z);
                        }
                    } catch (Throwable unused) {
                        NetTrafficeCallback netTrafficeCallback5 = netTrafficeCallback;
                        if (netTrafficeCallback5 != null) {
                            netTrafficeCallback5.onErrorCallback("Internal error");
                        }
                    }
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadError(int i, String str2, AdError adError) {
                    NetTrafficeCallback netTrafficeCallback2 = netTrafficeCallback;
                    if (netTrafficeCallback2 != null) {
                        netTrafficeCallback2.onErrorCallback(adError.printStackTrace());
                    }
                }
            });
        } else if (netTrafficeCallback != null) {
            if (netTrafficeCallback instanceof a) {
                ((a) netTrafficeCallback).a(iB == 1, iE == 1);
            } else {
                netTrafficeCallback.onResultCallback(iB == 1);
            }
        }
    }
}
