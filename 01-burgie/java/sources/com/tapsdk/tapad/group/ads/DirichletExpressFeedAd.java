package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.view.View;
import com.tapsdk.tapad.group.ads.feed.FeedOption;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletExpressFeedAd {
    private final MediationExpressFeedSession ad;

    public interface ExpressRenderListener {
        void onAdClicked(View view);

        void onAdClosed(View view);

        void onAdShow(View view);

        void onRenderFail(View view, DirichletExpressFeedAd dirichletExpressFeedAd, int i, String str);

        void onRenderSuccess(View view);
    }

    public DirichletExpressFeedAd(MediationExpressFeedSession mediationExpressFeedSession) {
        this.ad = mediationExpressFeedSession;
        mediationExpressFeedSession.setOuterAd(this);
    }

    public void destroy() {
        this.ad.destroy();
    }

    public Map<String, Object> getDirichletExtraInfo() {
        return this.ad.getDirichletExtraInfo();
    }

    public boolean isValid() {
        return MediationShowAdmissionBridge.isReady(this.ad, 6, this.ad.isValid());
    }

    public void loss(long j, String str, String str2) {
        this.ad.loss(j, str, str2);
    }

    public void render(FeedOption feedOption) {
        MediationExpressFeedSession mediationExpressFeedSession = this.ad;
        if (MediationShowAdmissionBridge.claimProviderRender(mediationExpressFeedSession, 6, mediationExpressFeedSession.isValid())) {
            this.ad.render(feedOption);
        }
    }

    public void setExpressRenderListener(ExpressRenderListener expressRenderListener) {
        this.ad.setExpressRenderListener(expressRenderListener);
    }

    public void win(long j) {
        this.ad.win(j);
    }

    public void render(Activity activity, FeedOption feedOption) {
        MediationExpressFeedSession mediationExpressFeedSession = this.ad;
        if (MediationShowAdmissionBridge.claimFullscreen(mediationExpressFeedSession, 6, activity, mediationExpressFeedSession.isValid())) {
            this.ad.render(activity, feedOption);
        }
    }
}
