package com.byazt.qq;

import android.content.Context;
import com.byazt.dj.x;
import com.byazt.gx.DynamicBaseInternalScrollWidgetImp;
import com.byazt.gx.DynamicBaseScrollWidgetImp;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.gx.DynamicBaseWidgetImp;
import com.byazt.gx.DynamicButton;
import com.byazt.gx.DynamicClose;
import com.byazt.gx.DynamicDislike;
import com.byazt.gx.DynamicDislikeFeedBack;
import com.byazt.gx.DynamicImageFlipSlide;
import com.byazt.gx.DynamicImageView;
import com.byazt.gx.DynamicLeisureWidget;
import com.byazt.gx.DynamicLogoAd;
import com.byazt.gx.DynamicLogoUnion;
import com.byazt.gx.DynamicLottie;
import com.byazt.gx.DynamicMutedView;
import com.byazt.gx.DynamicPrivacyView;
import com.byazt.gx.DynamicRoot;
import com.byazt.gx.DynamicRootView;
import com.byazt.gx.DynamicSkipCountDown;
import com.byazt.gx.DynamicSkipCountDownBtn;
import com.byazt.gx.DynamicSkipCountDownContainer;
import com.byazt.gx.DynamicSplitLineView;
import com.byazt.gx.DynamicStarView;
import com.byazt.gx.DynamicTextView;
import com.byazt.gx.DynamicTimeOuter;
import com.byazt.gx.DynamicTimeOuterContainerWidgetImp;
import com.byazt.gx.DynamicTimeOuterRewardFullSkip;
import com.byazt.gx.DynamicTimeOuterSkip;
import com.byazt.gx.DynamicUnKnowView;
import com.byazt.gx.DynamicVerticalScrollWidgetImp;
import com.byazt.gx.DynamicVideoView;
import com.byazt.mq.m;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1492, 13})
public class hw {
    public static DynamicBaseWidget pr(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        DynamicBaseWidget dynamicUnKnowView = null;
        if (context == null || dynamicRootView == null || zoVar == null || zoVar.vk() == null) {
            return null;
        }
        switch (zoVar.vk().pr()) {
            case -1:
                dynamicUnKnowView = new DynamicUnKnowView(context, dynamicRootView, zoVar);
                break;
            case 0:
                dynamicUnKnowView = new DynamicTextView(context, dynamicRootView, zoVar);
                break;
            case 1:
                dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, zoVar);
                break;
            case 2:
                dynamicUnKnowView = new DynamicButton(context, dynamicRootView, zoVar);
                break;
            case 3:
                dynamicUnKnowView = new DynamicDislike(context, dynamicRootView, zoVar);
                break;
            case 4:
                dynamicUnKnowView = new DynamicLogoAd(context, dynamicRootView, zoVar);
                break;
            case 5:
                dynamicUnKnowView = new DynamicLogoUnion(context, dynamicRootView, zoVar);
                break;
            case 6:
            case 9:
            case 17:
                dynamicUnKnowView = new DynamicBaseWidgetImp(context, dynamicRootView, zoVar);
                break;
            case 7:
                dynamicUnKnowView = new DynamicVideoView(context, dynamicRootView, zoVar);
                break;
            case 8:
                dynamicUnKnowView = new DynamicRoot(context, dynamicRootView, zoVar);
                break;
            case 10:
                dynamicUnKnowView = new DynamicMutedView(context, dynamicRootView, zoVar);
                break;
            case 11:
                dynamicUnKnowView = new DynamicStarView(context, dynamicRootView, zoVar);
                break;
            case 12:
                dynamicUnKnowView = new DynamicDislikeFeedBack(context, dynamicRootView, zoVar);
                break;
            case 13:
                dynamicUnKnowView = new DynamicTimeOuter(context, dynamicRootView, zoVar);
                break;
            case 14:
                dynamicUnKnowView = new DynamicTimeOuterContainerWidgetImp(context, dynamicRootView, zoVar);
                break;
            case 15:
                dynamicUnKnowView = x.pr() ? new DynamicTimeOuterRewardFullSkip(context, dynamicRootView, zoVar) : new DynamicTimeOuterSkip(context, dynamicRootView, zoVar);
                break;
            case 16:
                dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, zoVar);
                break;
            case 18:
                dynamicUnKnowView = new DynamicSplitLineView(context, dynamicRootView, zoVar);
                break;
            case 19:
                dynamicUnKnowView = new DynamicSkipCountDownContainer(context, dynamicRootView, zoVar);
                break;
            case 20:
                dynamicUnKnowView = new DynamicSkipCountDown(context, dynamicRootView, zoVar);
                break;
            case 21:
                dynamicUnKnowView = new DynamicSkipCountDownBtn(context, dynamicRootView, zoVar);
                break;
            case 22:
                dynamicUnKnowView = new DynamicClose(context, dynamicRootView, zoVar);
                break;
            case 23:
                dynamicUnKnowView = new DynamicPrivacyView(context, dynamicRootView, zoVar);
                break;
            case 24:
                dynamicUnKnowView = new DynamicBaseScrollWidgetImp(context, dynamicRootView, zoVar);
                break;
            case 25:
                dynamicUnKnowView = new DynamicLeisureWidget(context, dynamicRootView, zoVar);
                break;
            case 26:
                dynamicUnKnowView = "vertical".equals(zoVar.vk().c().pj()) ? new DynamicVerticalScrollWidgetImp(context, dynamicRootView, zoVar) : new DynamicBaseInternalScrollWidgetImp(context, dynamicRootView, zoVar);
                break;
            case 27:
                dynamicUnKnowView = new DynamicTimeOuterSkip(context, dynamicRootView, zoVar);
                break;
            case 28:
                if (x.pr()) {
                    m renderRequest = dynamicRootView.getRenderRequest();
                    if (renderRequest == null) {
                        return null;
                    }
                    dynamicUnKnowView = new DynamicLottie(context, dynamicRootView, zoVar, renderRequest.b());
                }
                break;
            case 29:
                dynamicUnKnowView = new DynamicImageFlipSlide(context, dynamicRootView, zoVar);
                break;
        }
        if (dynamicUnKnowView != null && dynamicRootView.getRenderRequest() != null) {
            dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().aj());
        }
        return dynamicUnKnowView;
    }
}
