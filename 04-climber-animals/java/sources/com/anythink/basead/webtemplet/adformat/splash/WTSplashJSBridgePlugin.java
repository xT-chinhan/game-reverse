package com.anythink.basead.webtemplet.adformat.splash;

import com.anythink.basead.webtemplet.WTWebView;
import com.anythink.basead.webtemplet.adformat.WTCommonJSBridgePlugin;

/* JADX INFO: loaded from: classes.dex */
public class WTSplashJSBridgePlugin extends WTCommonJSBridgePlugin {
    private final String c = getClass().getSimpleName();
    private a d;

    @Override // com.anythink.basead.webtemplet.adformat.WTCommonJSBridgePlugin, com.anythink.basead.webtemplet.d
    public void initialize(WTWebView wTWebView) {
        super.initialize(wTWebView);
        try {
            if (wTWebView.getJsCommunicationObject() == null || !(wTWebView.getJsCommunicationObject() instanceof a)) {
                return;
            }
            this.d = (a) wTWebView.getJsCommunicationObject();
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
