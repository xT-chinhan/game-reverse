package com.anythink.basead.webtemplet.adformat;

import com.anythink.basead.webtemplet.WTWebView;
import com.anythink.basead.webtemplet.h;

/* JADX INFO: loaded from: classes.dex */
public class WTCommonJSBridgePlugin extends com.anythink.basead.webtemplet.d implements b {
    private final String c = getClass().getSimpleName();
    private b d;

    @Override // com.anythink.basead.webtemplet.d
    public void initialize(WTWebView wTWebView) {
        super.initialize(wTWebView);
        try {
            if (wTWebView.getJsCommunicationObject() == null || !(wTWebView.getJsCommunicationObject() instanceof b)) {
                return;
            }
            this.d = (b) wTWebView.getJsCommunicationObject();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void initSuccess(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.initSuccess(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void renderSuccess(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.renderSuccess(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void h5ShowException(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.h5ShowException(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void sendEventDA(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.sendEventDA(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewInit(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.playerViewInit(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewGetProgress(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.playerViewGetProgress(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewMute(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.playerViewMute(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewRemove(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.playerViewRemove(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewPauseOrResumePlay(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.playerViewPauseOrResumePlay(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void playerViewRelayout(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.playerViewRelayout(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void notifyClick(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.notifyClick(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void openInWebView(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.openInWebView(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void showFeedbackDialog(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.showFeedbackDialog(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void notifyClose(Object obj, String str) {
        h.f(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.notifyClose(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void controlShakeView(Object obj, String str) {
        h.f(str);
        System.currentTimeMillis();
        b bVar = this.d;
        if (bVar != null) {
            bVar.controlShakeView(obj, h.f(str));
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.b
    public void notifyReward(Object obj, String str) {
        h.f(str);
        System.currentTimeMillis();
        b bVar = this.d;
        if (bVar != null) {
            bVar.notifyReward(obj, h.f(str));
        }
    }
}
