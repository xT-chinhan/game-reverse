package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ul;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends x {
    private final com.bytedance.sdk.openadsdk.core.le.ms.ms.xr w;

    public ny(Context context, lm lmVar, String str, boolean z) {
        super(context, lmVar, str, z);
        this.w = new com.bytedance.sdk.openadsdk.core.le.ms.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.1
            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ms() {
                ny.this.ab.set(1);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ny.this.ms("onIdle", 0L, 0L, (String) null, (String) null);
                } else if (ny.this.sl != null) {
                    ny.this.sl.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ms(Bridge bridge, Bridge bridge2) {
                if (bridge == null || bridge.values() == null) {
                    return;
                }
                ny.this.ab.set(2);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ny.this.ms("onIdle", 0L, 0L, (String) null, (String) null);
                } else if (ny.this.sl != null) {
                    ny.this.sl.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ms(Bridge bridge, int i) {
                ValueSet valueSetValues;
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                ny.this.ab.set(3);
                ny.this.x.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ny.this.ms("onDownloadActive", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), ny.this.d.ah());
                    return;
                }
                if (ny.this.sl != null) {
                    ny.this.sl.ms(valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), ny.this.d.ah());
                }
                if (ny.this.sl == null || ny.this.sl.ah() || ny.this.ka == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.b.ms.xr(ny.this.ka.xg());
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void xr(Bridge bridge, int i) {
                ValueSet valueSetValues;
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                ny.this.ab.set(4);
                ny.this.x.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ny.this.ms("onDownloadPaused", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), ny.this.d.ah());
                } else if (ny.this.sl != null) {
                    ny.this.sl.xr(valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), ny.this.d.ah());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ms(Bridge bridge) {
                ValueSet valueSetValues;
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                ny.this.ab.set(5);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ny.this.ms("onDownloadFailed", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), ny.this.d.ah());
                } else if (ny.this.sl != null) {
                    ny.this.sl.ah(valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), ny.this.d.ah());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void xr(Bridge bridge) {
                ValueSet valueSetValues;
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                ny.this.ab.set(7);
                ny.this.x.set(true);
                String strStringValue = !TextUtils.isEmpty(valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME)) ? valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME) : "";
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ny.this.ms("onInstalled", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), strStringValue, ny.this.d.ah());
                } else if (ny.this.sl != null) {
                    ny.this.sl.ms(strStringValue, ny.this.d.ah());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ah(Bridge bridge) {
                ValueSet valueSetValues;
                ny.this.ab.set(6);
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ny.this.ms("onDownloadFinished", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), ny.this.d.ah());
                } else if (ny.this.sl != null) {
                    ny.this.sl.ms(valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), ny.this.d.ah());
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public void ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.c, this.ka, (JSONObject) null, ch());
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.ka, ch(), z);
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.c, ch());
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public synchronized void c() {
        if (this.d == null) {
            return;
        }
        if (this.b != null && g.xr >= 6400 && !g.c()) {
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms((com.bytedance.sdk.openadsdk.core.le.ms.ms.ah) null, ch());
        }
        if (this.ch != null && this.ch.get()) {
            this.ch.set(false);
            if (this.b != null) {
                this.b.call(4, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
            }
        }
        zb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public synchronized void xr() {
        if (this.d == null) {
            return;
        }
        this.ch.set(true);
        if (this.b != null) {
            this.b.call(5, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER, this.w)).xr(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(JSONObject jSONObject, boolean z) {
        c(jSONObject, z);
    }

    private void c(JSONObject jSONObject, final boolean z) {
        h();
        if (getContext() == null || this.d == null || !ub()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.c, this.c, jSONObject, ch());
        final of<String, Object> ofVarMs = new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.d.xr()).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_ACTION_TYPE_BUTTON, 2);
        if (this.ka != null && !TextUtils.isEmpty(this.ka.df())) {
            ofVarMs.ms("id", Long.valueOf(Double.valueOf(this.ka.df()).longValue()));
        }
        if (ms()) {
            com.bytedance.sdk.openadsdk.core.le.ms.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.le.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.2
                @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
                public void handleComplianceDialog(boolean z2) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
                public void handleMarketFailedComplianceDialog() {
                    if (ofVarMs == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(0, ny.this.ch());
                    ny.this.hi().ms(ny.this.ao());
                    ofVarMs.remove(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER);
                    if (ny.this.ms((com.bytedance.sdk.openadsdk.core.nw.d) null, (com.bytedance.sdk.openadsdk.core.le.ms.ms.ms) null, ofVarMs, z)) {
                        return;
                    }
                    ny.this.xr(ofVarMs);
                }
            };
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(ofVarMs, msVar);
            if (ms((com.bytedance.sdk.openadsdk.core.nw.d) null, msVar, ofVarMs, z)) {
                return;
            }
            xr(true);
            ms(ofVarMs, msVar);
            return;
        }
        ms(ofVarMs, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.le.ms.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.core.hi.ch.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.3
            @Override // java.lang.Runnable
            public void run() {
                ny.this.ms(msVar, (Map<String, Object>) map);
            }
        }, this.ka);
        this.re = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.le.ms.ms.ms msVar, Map<String, Object> map) {
        try {
            if (msVar == null) {
                ms(map);
                this.re = false;
            } else {
                xr(msVar, map);
                this.re = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void xr(com.bytedance.sdk.openadsdk.core.le.ms.ms.ms msVar, Map<String, Object> map) {
        if (this.b == null) {
            return;
        }
        final of<String, Object> ofVarMs = new of().ms(TTDownloadField.TT_ITEM_CLICK_LISTENER, null).ms(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER, msVar).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(map);
        if (g.xr < 4500) {
            this.b.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVarMs).xr(), Void.class);
        } else {
            ofVarMs.put(TTDownloadField.TT_ITEM_CLICK_LISTENER, new com.bytedance.sdk.openadsdk.core.le.ms.ms.d() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.4
                @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.d
                public void ms(Bridge bridge, Bridge bridge2, Bridge bridge3) {
                    if (!ny.this.h && !ny.this.ka.sh()) {
                        ul.ms(ny.this.getContext(), ny.this.ka.ir(), ny.this.ka, ny.this.c);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.xr(1, ny.this.ch());
                    ofVarMs.remove(TTDownloadField.TT_ITEM_CLICK_LISTENER);
                    ny.this.b.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVarMs).xr(), Void.class);
                }
            });
            this.b.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVarMs).xr(), Void.class);
        }
    }

    private void ms(final Map<String, Object> map, final boolean z) {
        int i = this.nw;
        if (i == 1) {
            ub.ms(re.getContext());
        } else if (i == 2) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.nw.d dVarMs = re.ms().ms(ny.this.ka, ny.this.d.xr());
                    if (dVarMs != null && dVarMs.ka()) {
                        ny.this.ms(dVarMs, (Map<String, Object>) map, z);
                    } else {
                        ub.ms(re.getContext());
                    }
                }
            });
        } else {
            ms((com.bytedance.sdk.openadsdk.core.nw.d) null, map, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final Map<String, Object> map) {
        if (this.nw == 1) {
            return;
        }
        if (this.nw == 2) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("tt_market_download_check") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.nw.d dVarMs = re.ms().ms(ny.this.ka, ny.this.d.xr());
                    if (dVarMs == null || !dVarMs.ka()) {
                        return;
                    }
                    nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ny.this.ms((com.bytedance.sdk.openadsdk.core.le.ms.ms.ms) null, (Map<String, Object>) map);
                        }
                    });
                }
            });
        } else {
            ms((com.bytedance.sdk.openadsdk.core.le.ms.ms.ms) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final com.bytedance.sdk.openadsdk.core.nw.d dVar, final Map<String, Object> map, final boolean z) {
        ms(new com.bytedance.sdk.openadsdk.core.le.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.7
            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
            public void handleMarketFailedComplianceDialog() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
            public void handleComplianceDialog(boolean z2) {
                if (z2 && ny.this.ms(dVar, (com.bytedance.sdk.openadsdk.core.le.ms.ms.ms) null, (Map<String, Object>) map, z)) {
                    return;
                }
                ny.this.ms((com.bytedance.sdk.openadsdk.core.le.ms.ms.ms) null, (Map<String, Object>) map);
            }
        }, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms() {
        return this.b != null && com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.b, ch()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ab() {
        if (this.d == null) {
            return;
        }
        this.ch.set(false);
        if (this.b != null) {
            this.b.call(8, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_FORCE, Boolean.TRUE).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
        }
        xr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(com.bytedance.sdk.openadsdk.core.nw.d dVar, final com.bytedance.sdk.openadsdk.core.le.ms.ms.ms msVar, final Map<String, Object> map, boolean z) {
        com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVarHi = hi();
        if (!ahVarHi.d(z)) {
            return false;
        }
        if (ms(getContext(), this.ka, this.c)) {
            return true;
        }
        ahVarHi.ms(dVar, this.c, this.d.xr(), new com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ny.8
            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr
            public void ms() {
                if (!ny.this.ms()) {
                    ny.this.ms(msVar, (Map<String, Object>) map);
                } else {
                    ny.this.xr(true);
                    ny.this.ms((Map<String, Object>) map, msVar);
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(boolean z) {
        if (g.xr >= 5400 && z) {
            this.re = true;
            if (ms()) {
                try {
                    com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(true, com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.ka, this.i), ch());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ah("xgcdl", "throwable", th);
                }
            }
        }
    }

    private void h() {
        if (g.xr >= 5400 && ms() && !this.re) {
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(false, (com.bytedance.sdk.openadsdk.core.le.ms.ms.ah) null, ch());
        }
    }
}
