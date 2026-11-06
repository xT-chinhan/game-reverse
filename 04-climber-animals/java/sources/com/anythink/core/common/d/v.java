package com.anythink.core.common.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.core.activity.AnyThinkGdprAuthActivity;
import com.anythink.core.api.ATGDPRAuthCallback;
import com.anythink.core.api.AdError;
import com.anythink.core.api.NetTrafficeCallback;
import com.anythink.core.common.v.af;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private static volatile v e;
    Context b;
    int c;
    private final String d = "v";
    final int a = -100;
    private ConcurrentHashMap<Integer, Boolean> f = new ConcurrentHashMap<>(5);

    private v(Context context) {
        this.c = 2;
        if (context != null) {
            this.b = context.getApplicationContext();
        }
        this.c = af.b(this.b, u.b.a, u.a.o, 2);
    }

    public static v a(Context context) {
        if (e == null) {
            synchronized (v.class) {
                if (e == null) {
                    e = new v(context);
                }
            }
        }
        return e;
    }

    public final void a(int i) {
        this.c = i;
        af.a(this.b, u.b.a, u.a.o, i);
    }

    public final int a() {
        return this.c;
    }

    public final boolean b() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.b).b(t.b().p());
        if (bVarB == null || bVarB.R()) {
            return this.c != 1;
        }
        if (bVarB.aj() == 0) {
            return true;
        }
        int iAg = this.c;
        if (bVarB.ah() == 1) {
            iAg = bVarB.ag();
        }
        return iAg == 0;
    }

    public final boolean c() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.b).b(t.b().p());
        if (bVarB == null || bVarB.R()) {
            return this.c != 1;
        }
        if (this.c == 2) {
            return bVarB.aj() == 0;
        }
        if (bVarB.ah() == 1) {
            return bVarB.ag() == 0;
        }
        return this.c == 0 || bVarB.aj() == 0;
    }

    public final boolean b(int i) {
        if (com.anythink.core.common.j.a.a().b()) {
            return com.anythink.core.common.j.a.a().a(this.b, i);
        }
        return c();
    }

    public final boolean d() {
        return af.b(this.b, u.b.a, u.a.w, -100) == 1;
    }

    public final void a(final Context context, final ATGDPRAuthCallback aTGDPRAuthCallback) {
        t.b().b(new Runnable() { // from class: com.anythink.core.common.d.v.1
            @Override // java.lang.Runnable
            public final void run() {
                AnyThinkGdprAuthActivity.mCallback = aTGDPRAuthCallback;
                Intent intent = new Intent(context, (Class<?>) AnyThinkGdprAuthActivity.class);
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
                context.startActivity(intent);
            }
        });
    }

    public final void a(final NetTrafficeCallback netTrafficeCallback) {
        int iB = af.b(this.b, u.b.a, u.a.w, -100);
        if (iB == -100) {
            new com.anythink.core.common.m.p().a(0, new com.anythink.core.common.m.q() { // from class: com.anythink.core.common.d.v.2
                @Override // com.anythink.core.common.m.q
                public final void onLoadCanceled(int i) {
                }

                @Override // com.anythink.core.common.m.q
                public final void onLoadStart(int i) {
                }

                @Override // com.anythink.core.common.m.q
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
                        if (jSONObject.optInt("is_eu") == 1) {
                            NetTrafficeCallback netTrafficeCallback4 = netTrafficeCallback;
                            if (netTrafficeCallback4 != null) {
                                netTrafficeCallback4.onResultCallback(true);
                                return;
                            }
                            return;
                        }
                        NetTrafficeCallback netTrafficeCallback5 = netTrafficeCallback;
                        if (netTrafficeCallback5 != null) {
                            netTrafficeCallback5.onResultCallback(false);
                        }
                    } catch (Throwable unused) {
                        NetTrafficeCallback netTrafficeCallback6 = netTrafficeCallback;
                        if (netTrafficeCallback6 != null) {
                            netTrafficeCallback6.onErrorCallback("Internal error");
                        }
                    }
                }

                @Override // com.anythink.core.common.m.q
                public final void onLoadError(int i, String str, AdError adError) {
                    NetTrafficeCallback netTrafficeCallback2 = netTrafficeCallback;
                    if (netTrafficeCallback2 != null) {
                        netTrafficeCallback2.onErrorCallback(adError.printStackTrace());
                    }
                }
            });
            return;
        }
        if (iB == 1) {
            if (netTrafficeCallback != null) {
                netTrafficeCallback.onResultCallback(true);
            }
        } else if (netTrafficeCallback != null) {
            netTrafficeCallback.onResultCallback(false);
        }
    }

    public final void a(final int i, final boolean z) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.d.v.3
            @Override // java.lang.Runnable
            public final void run() {
                if (!v.this.c(i) || v.this.b(i, z)) {
                    String unused = v.this.d;
                    v vVarA = v.a(t.b().g());
                    com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
                    if (TextUtils.isEmpty(com.anythink.core.common.j.a.a().c())) {
                        if (vVarA.c == 2 && bVarB.aj() == 1 && bVarB.T() == 0) {
                            com.anythink.core.common.u.e.a(1, vVarA.c, bVarB.aj(), i);
                        }
                        if (vVarA.c == 1 && bVarB.ah() == 0 && bVarB.aj() == 0) {
                            com.anythink.core.common.u.e.a(2, vVarA.c, bVarB.aj(), i);
                        }
                    } else {
                        com.anythink.core.common.u.e.a(3, !z ? 1 : 0, bVarB.aj(), i);
                    }
                    v.this.f.put(Integer.valueOf(i), Boolean.valueOf(z));
                }
            }
        }, 2);
    }

    public final boolean c(int i) {
        return this.f.get(Integer.valueOf(i)) != null;
    }

    public final boolean b(int i, boolean z) {
        return this.f.get(Integer.valueOf(i)) == null || this.f.get(Integer.valueOf(i)).booleanValue() != z;
    }
}
