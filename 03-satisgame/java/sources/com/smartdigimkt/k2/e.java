package com.smartdigimkt.k2;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.sdk.basead.webtemplet.adformat.WTCommonJSBridgePlugin;
import com.smartdigimkt.sdk.basead.webtemplet.adformat.intestitial.WTScreenJSBridgePlugin;
import com.smartdigimkt.sdk.basead.webtemplet.adformat.splash.WTSplashJSBridgePlugin;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static HashMap b = new HashMap();
    public final WTWebView a;

    public e(WTWebView wTWebView) {
        this.a = wTWebView;
        try {
            if (b == null) {
                b = new HashMap();
            }
            b.put(com.anythink.core.common.l.f.Z, WTCommonJSBridgePlugin.class);
            if (b == null) {
                b = new HashMap();
            }
            b.put(MediationConstant.RIT_TYPE_SPLASH, WTSplashJSBridgePlugin.class);
            if (b == null) {
                b = new HashMap();
            }
            b.put("inter", WTScreenJSBridgePlugin.class);
            if (b == null) {
                b = new HashMap();
            }
            b.put("reward", WTScreenJSBridgePlugin.class);
        } catch (ClassNotFoundException unused) {
        }
    }
}
