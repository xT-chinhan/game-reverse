package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {
    protected String ah;
    protected boolean c;
    private nw ch;
    protected com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah d;
    protected String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected lm f3140ms;
    private volatile boolean sl;
    protected DownloadStatusChangeListener x;
    protected Context xr;
    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms zb;
    protected volatile boolean ab = false;
    private int hi = 0;
    protected Bridge ny = ch.ub().ul();

    abstract boolean ah(int i);

    abstract com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms d(Map<String, Object> map);

    abstract com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.xr ms(Map<String, Object> map, of<String, Object> ofVar);

    abstract void xr(boolean z, int i);

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(Map<String, Object> map) {
        if (ms()) {
            return xr(map);
        }
        return false;
    }

    protected boolean ms() {
        return (this.f3140ms == null || this.xr == null || this.ny == null || TextUtils.isEmpty(this.ka) || TextUtils.isEmpty(this.ah) || this.d == null) ? false : true;
    }

    public boolean xr(Map<String, Object> map) {
        if (this.f3140ms.kr() || TextUtils.isEmpty(this.ka)) {
            return false;
        }
        if (u.ah(this.xr) == 0) {
            try {
                Context context = this.xr;
                op.ms(context, t.ms(context, "tt_no_network"), 0);
            } catch (Exception unused) {
            }
            return true;
        }
        ka(map);
        return true;
    }

    private void ka(Map<String, Object> map) {
        int iAh = ah(map);
        ms(this.sl, iAh);
        if (this.xr == null || TextUtils.isEmpty(this.ka) || !c(map)) {
            return;
        }
        this.d.ms(xr(iAh), this.f3140ms);
        of<String, Object> ofVarMs = new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.ka);
        ofVarMs.put("is_feed_register_direct_download", map.get("is_feed_register_direct_download"));
        ofVarMs.put("download_manager_hash_code", map.get("download_manager_hash_code"));
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms msVarD = d(ofVarMs);
        if (msVarD == null || ms((com.bytedance.sdk.openadsdk.core.nw.d) null, msVarD, ofVarMs)) {
            return;
        }
        ms(true, iAh);
        ms(ofVarMs, msVarD);
    }

    private boolean c(Map<String, Object> map) {
        if (this.ny == null) {
            return true;
        }
        nw nwVar = this.ch;
        if (nwVar != null && nwVar.ka() == 1) {
            return true;
        }
        nw nwVar2 = this.ch;
        if (nwVar2 != null && nwVar2.ah()) {
            return true;
        }
        if (!((Boolean) this.ny.call(6, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ah(map))).ms(TTDownloadField.TT_DOWNLOAD_URL, this.ka)).xr(), Boolean.class)).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.1
            @Override // java.lang.Runnable
            public void run() {
                op.ms(ms.this.xr, "应用正在下载...", 0);
            }
        });
        return false;
    }

    boolean ms(com.bytedance.sdk.openadsdk.core.nw.d dVar, final com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms msVar, final Map<String, Object> map) {
        boolean zMs = com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms(map);
        final int iAh = ah(map);
        if (!this.d.d(zMs)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar2 = this.zb;
        if (msVar2 != null && msVar2.ms(new HashMap())) {
            return true;
        }
        this.d.ms(dVar, this.ah, this.ka, new com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr
            public void ms() {
                if (ms.this.ah(iAh)) {
                    ms.this.ms(true, iAh);
                    ms.this.ms((Map<String, Object>) map, msVar);
                } else {
                    ms.this.ms(msVar, map);
                }
            }
        });
        return true;
    }

    public void ms(boolean z, int i) {
        if (g.xr >= 5400 && ah(i)) {
            xr(z, i);
        }
    }

    public void ms(boolean z) {
        this.ab = z;
    }

    public void ms(DownloadStatusChangeListener downloadStatusChangeListener) {
        this.x = downloadStatusChangeListener;
    }

    public void ms(nw nwVar) {
        this.ch = nwVar;
    }

    public void ms(int i) {
        this.hi = i;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar) {
        this.zb = msVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.core.hi.ch.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.3
            @Override // java.lang.Runnable
            public void run() {
                ms.this.ms(msVar, map);
            }
        }, this.f3140ms);
        this.sl = false;
    }

    void ms(com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms msVar, Map<String, Object> map) {
        try {
            if (msVar == null) {
                ab(map);
                this.sl = false;
            } else {
                xr(msVar, map);
                this.sl = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void xr(com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms msVar, Map<String, Object> map) {
        if (this.ny == null) {
            return;
        }
        of<String, Object> ofVarMs = new of().ms(TTDownloadField.TT_ITEM_CLICK_LISTENER, null).ms(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER, msVar).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ah(map))).ms(map);
        if (g.xr < 4500) {
            this.ny.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVarMs).xr(), Void.class);
        } else {
            ofVarMs.put(TTDownloadField.TT_ITEM_CLICK_LISTENER, ms(map, ofVarMs));
            this.ny.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVarMs).xr(), Void.class);
        }
    }

    private void ab(Map<String, Object> map) {
        if (this.ny != null) {
            int iAh = ah(map);
            if (map != null) {
                map.put(TTDownloadField.TT_HASHCODE, Integer.valueOf(iAh));
            }
            this.ny.call(16, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
        }
    }

    protected com.bytedance.sdk.openadsdk.core.hi.ah.ah.ms xr(int i) {
        if (ah(i)) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ka();
        }
        if (this.ab) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.d();
        }
        return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.xr();
    }

    void ms(final Map<String, Object> map, final boolean z) {
        int i = this.hi;
        if (i == 1) {
            ub.ms(re.getContext());
            return;
        }
        if (i == 2) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.nw.d dVarMs = re.ms().ms(ms.this.f3140ms, ms.this.ka);
                    if (dVarMs != null && dVarMs.ka()) {
                        if (z) {
                            ms.this.ms(dVarMs, (Map<String, Object>) map);
                            return;
                        } else {
                            ms.this.ms((com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms) null, map);
                            return;
                        }
                    }
                    ub.ms(re.getContext());
                }
            });
        } else if (z) {
            ms((com.bytedance.sdk.openadsdk.core.nw.d) null, map);
        } else {
            ms((com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.nw.d dVar, Map<String, Object> map) {
        ms(xr(dVar, map), map);
    }

    public void xr(boolean z) {
        this.c = z;
    }

    public static int ah(Map<String, Object> map) {
        if (map == null) {
            return 0;
        }
        Object obj = map.get("download_manager_hash_code");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms xr(final com.bytedance.sdk.openadsdk.core.nw.d dVar, final Map<String, Object> map) {
        return new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.5
            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms, com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
            public void handleMarketFailedComplianceDialog() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms, com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
            public void handleComplianceDialog(boolean z) {
                if (z && ms.this.ms(dVar, (com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms) null, map)) {
                    return;
                }
                ms.this.ms((com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms) null, map);
            }
        };
    }
}
