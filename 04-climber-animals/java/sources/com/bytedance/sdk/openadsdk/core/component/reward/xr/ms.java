package com.bytedance.sdk.openadsdk.core.component.reward.xr;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ao;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.hi.ah.x;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private String ab;
    private String c;
    private TTBaseVideoActivity d;
    private lm ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.hi.xr.ah f2305ms;
    View xr = null;
    final Map<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> ah = Collections.synchronizedMap(new HashMap());
    private long x = 0;
    private long ny = 0;
    private long ch = 0;
    private long hi = 0;
    private long sl = 0;
    private long zb = 0;
    private boolean ub = true;
    private final ah ao = new ah();
    private boolean u = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.xr.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0278ms {
        void ms(View view, hi hiVar);

        void ms(String str, JSONObject jSONObject);
    }

    public interface xr {
        void ah(boolean z, long j, long j2, String str, String str2);

        void ms(boolean z);

        void ms(boolean z, long j, long j2, String str, String str2);

        void ms(boolean z, long j, String str, String str2);

        void ms(boolean z, String str, String str2);

        void xr(boolean z, long j, long j2, String str, String str2);
    }

    public ms(TTBaseVideoActivity tTBaseVideoActivity) {
        this.d = tTBaseVideoActivity;
    }

    public void ms(lm lmVar, String str, String str2) {
        if (this.u) {
            return;
        }
        this.u = true;
        this.ka = lmVar;
        this.c = str;
        x();
        this.ab = str2;
    }

    private void x() {
        lm lmVar = this.ka;
        if (lmVar == null || lmVar.jr() != 4) {
            return;
        }
        this.f2305ms = com.bytedance.sdk.openadsdk.core.hi.ka.ms((Context) this.d, this.ka, this.c, false);
    }

    public void ms() {
        lm lmVar;
        if (this.f2305ms == null && (lmVar = this.ka) != null && lmVar.jr() == 4) {
            this.f2305ms = com.bytedance.sdk.openadsdk.core.hi.ka.ms((Context) this.d, this.ka, this.c, false);
        }
    }

    public com.bytedance.sdk.openadsdk.core.hi.xr.ah xr() {
        return this.f2305ms;
    }

    public boolean ah() {
        return this.f2305ms != null;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.f2305ms;
        if (ahVar != null) {
            ahVar.ms(this.d);
            this.f2305ms.x();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> entry : this.ah.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().x();
            }
        }
    }

    public void ka() {
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> entry : this.ah.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.f2305ms;
        if (ahVar != null) {
            ahVar.ny();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> entry : this.ah.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().ny();
            }
        }
        try {
            ms(this.ab);
        } catch (Throwable th) {
            sl.ah("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    private void ms(final String str) {
        ab.xr(new ny("executeMultiProcessAppDownloadCallBack") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ms.this.ms(3).ms(str, "recycleRes", 0L, 0L, "", "");
                } catch (Throwable th) {
                    sl.ah("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected ao ms(int i) {
        return com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms.ms(com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext()).ms(i));
    }

    public void ms(final xr xrVar) {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.f2305ms;
        if (ahVar == null) {
            return;
        }
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms() {
                boolean z;
                if (System.currentTimeMillis() - ms.this.x > NativeExpressView.qv) {
                    ms.this.x = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms(z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - ms.this.ch > NativeExpressView.qv) {
                    ms.this.ch = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms(z2, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void xr(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - ms.this.ny > NativeExpressView.qv) {
                    ms.this.ny = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.xr(z2, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ah(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - ms.this.hi > NativeExpressView.qv) {
                    ms.this.hi = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ah(z2, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - ms.this.sl > NativeExpressView.qv) {
                    ms.this.sl = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms(z2, j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - ms.this.zb > NativeExpressView.qv) {
                    ms.this.zb = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms(z, str, str2);
                }
            }
        });
    }

    public void ms(String str, boolean z) {
        if (this.ah.containsKey(str)) {
            com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ah.get(str);
            if (ahVar != null) {
                if (z) {
                    ahVar.ms(ub.ms(this.ka));
                }
                if (ahVar instanceof x) {
                    ((x) ahVar).hi().ms(this.ub);
                } else if (ahVar instanceof com.bytedance.sdk.openadsdk.core.hi.ah.sl) {
                    ((com.bytedance.sdk.openadsdk.core.hi.ah.sl) ahVar).xr().ms(this.ub);
                }
                ahVar.xr(f.y(this.ka), false);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = com.bytedance.sdk.openadsdk.core.hi.ka.ms(this.d, str, this.ka, this.c);
        if (z) {
            ahVarMs.ms(ub.ms(this.ka));
        }
        if (ahVarMs instanceof x) {
            ((x) ahVarMs).hi().ms(this.ub);
        } else if (ahVarMs instanceof com.bytedance.sdk.openadsdk.core.hi.ah.sl) {
            ((com.bytedance.sdk.openadsdk.core.hi.ah.sl) ahVarMs).xr().ms(this.ub);
        }
        this.ah.put(str, ahVarMs);
        ahVarMs.xr(f.y(this.ka), false);
    }

    public void ms(final InterfaceC0278ms interfaceC0278ms) {
        this.f2305ms.ms(1, new ITTDownloadAdapter.OnEventLogHandler() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.3
            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler
            public boolean onEventLog(int i, String str, String str2, String str3, Object obj) {
                if (i == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if ((str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad")) && str3.equals("click_start")) {
                        interfaceC0278ms.ms(ms.this.xr, new hi());
                        ms.this.xr = null;
                        return true;
                    }
                    if (str2.equals("fullscreen_interstitial_ad") || str2.equals("rewarded_video")) {
                        str3.hashCode();
                        if (str3.equals("click_continue")) {
                            com.bytedance.sdk.openadsdk.core.zb.ah.xr(ms.this.ka, str2, "click_play_continue", (Map<String, Object>) null);
                        } else if (str3.equals("click_pause")) {
                            com.bytedance.sdk.openadsdk.core.zb.ah.xr(ms.this.ka, str2, "click_play_pause", (Map<String, Object>) null);
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            }
        });
    }

    public void ms(View view, InterfaceC0278ms interfaceC0278ms, hi hiVar) {
        if (this.f2305ms != null && view != null) {
            if (view.getId() == 2114387615) {
                interfaceC0278ms.ms("click_play_star_level", (JSONObject) null);
                return;
            }
            if (view.getId() == 2114387636) {
                interfaceC0278ms.ms("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387881) {
                interfaceC0278ms.ms("click_play_source", (JSONObject) null);
                return;
            } else {
                if (view.getId() == 2114387799) {
                    interfaceC0278ms.ms("click_play_logo", (JSONObject) null);
                    return;
                }
                return;
            }
        }
        interfaceC0278ms.ms(view, hiVar);
    }

    public ah ab() {
        return this.ao;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms interfaceC0296ms) {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.f2305ms;
        if (ahVar != null) {
            ahVar.ms(interfaceC0296ms);
        }
    }

    public class ah implements DownloadListener {
        private boolean xr = true;

        public ah() {
        }

        public void ms(boolean z) {
            this.xr = z;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            ms(this.xr);
            ms.this.ms(str, true);
            ms.this.d.ms(1);
        }
    }
}
