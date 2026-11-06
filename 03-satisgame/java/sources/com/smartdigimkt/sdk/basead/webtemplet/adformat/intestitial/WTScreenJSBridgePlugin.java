package com.smartdigimkt.sdk.basead.webtemplet.adformat.intestitial;

import com.smartdigimkt.m2.a;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.sdk.basead.webtemplet.adformat.WTCommonJSBridgePlugin;

/* JADX INFO: loaded from: classes3.dex */
public class WTScreenJSBridgePlugin extends WTCommonJSBridgePlugin {
    @Override // com.smartdigimkt.sdk.basead.webtemplet.adformat.WTCommonJSBridgePlugin
    public void initialize(WTWebView wTWebView) {
        super.initialize(wTWebView);
        try {
            if (wTWebView.getJsCommunicationObject() == null || !(wTWebView.getJsCommunicationObject() instanceof a)) {
                return;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
