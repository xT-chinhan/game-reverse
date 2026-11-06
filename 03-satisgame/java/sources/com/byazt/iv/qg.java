package com.byazt.iv;

import android.content.Context;
import com.byazt.lh.fs;
import com.byazt.osr.DynamicBaseInternalScrollWidgetImp;
import com.byazt.osr.DynamicBaseScrollWidgetImp;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.osr.DynamicBaseWidgetImp;
import com.byazt.osr.DynamicButton;
import com.byazt.osr.DynamicClose;
import com.byazt.osr.DynamicDislike;
import com.byazt.osr.DynamicDislikeFeedBack;
import com.byazt.osr.DynamicImageFlipSlide;
import com.byazt.osr.DynamicImageView;
import com.byazt.osr.DynamicLeisureWidget;
import com.byazt.osr.DynamicLogoAd;
import com.byazt.osr.DynamicLogoUnion;
import com.byazt.osr.DynamicLottie;
import com.byazt.osr.DynamicMutedView;
import com.byazt.osr.DynamicPrivacyView;
import com.byazt.osr.DynamicRoot;
import com.byazt.osr.DynamicRootView;
import com.byazt.osr.DynamicSkipCountDown;
import com.byazt.osr.DynamicSkipCountDownBtn;
import com.byazt.osr.DynamicSkipCountDownContainer;
import com.byazt.osr.DynamicSplitLineView;
import com.byazt.osr.DynamicStarView;
import com.byazt.osr.DynamicTextView;
import com.byazt.osr.DynamicTimeOuter;
import com.byazt.osr.DynamicTimeOuterContainerWidgetImp;
import com.byazt.osr.DynamicTimeOuterRewardFullSkip;
import com.byazt.osr.DynamicTimeOuterSkip;
import com.byazt.osr.DynamicUnKnowView;
import com.byazt.osr.DynamicVerticalScrollWidgetImp;
import com.byazt.osr.DynamicVideoView;
import com.byazt.twc.q;
import com.byazt.udb.oa;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1592, 26})
public class qg {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x0111  */
    public static DynamicBaseWidget n(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        DynamicBaseWidget dynamicUnKnowView = null;
        if (context != null && dynamicRootView != null && fsVar != null && fsVar.tj() != null) {
            switch (fsVar.tj().n()) {
                case -1:
                    dynamicUnKnowView = new DynamicUnKnowView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null && dynamicRootView.getRenderRequest() != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 0:
                    dynamicUnKnowView = new DynamicTextView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 1:
                    dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 2:
                    dynamicUnKnowView = new DynamicButton(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 3:
                    dynamicUnKnowView = new DynamicDislike(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 4:
                    dynamicUnKnowView = new DynamicLogoAd(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 5:
                    dynamicUnKnowView = new DynamicLogoUnion(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 6:
                case 9:
                case 17:
                    dynamicUnKnowView = new DynamicBaseWidgetImp(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 7:
                    dynamicUnKnowView = new DynamicVideoView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 8:
                    dynamicUnKnowView = new DynamicRoot(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 10:
                    dynamicUnKnowView = new DynamicMutedView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 11:
                    dynamicUnKnowView = new DynamicStarView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 12:
                    dynamicUnKnowView = new DynamicDislikeFeedBack(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 13:
                    dynamicUnKnowView = new DynamicTimeOuter(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 14:
                    dynamicUnKnowView = new DynamicTimeOuterContainerWidgetImp(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 15:
                    if (q.n()) {
                        dynamicUnKnowView = new DynamicTimeOuterRewardFullSkip(context, dynamicRootView, fsVar);
                    } else {
                        dynamicUnKnowView = new DynamicTimeOuterSkip(context, dynamicRootView, fsVar);
                    }
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 16:
                    dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 18:
                    dynamicUnKnowView = new DynamicSplitLineView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 19:
                    dynamicUnKnowView = new DynamicSkipCountDownContainer(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 20:
                    dynamicUnKnowView = new DynamicSkipCountDown(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 21:
                    dynamicUnKnowView = new DynamicSkipCountDownBtn(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 22:
                    dynamicUnKnowView = new DynamicClose(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 23:
                    dynamicUnKnowView = new DynamicPrivacyView(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 24:
                    dynamicUnKnowView = new DynamicBaseScrollWidgetImp(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 25:
                    dynamicUnKnowView = new DynamicLeisureWidget(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 26:
                    if ("vertical".equals(fsVar.tj().l().ha())) {
                        dynamicUnKnowView = new DynamicVerticalScrollWidgetImp(context, dynamicRootView, fsVar);
                    } else {
                        dynamicUnKnowView = new DynamicBaseInternalScrollWidgetImp(context, dynamicRootView, fsVar);
                    }
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 27:
                    dynamicUnKnowView = new DynamicTimeOuterSkip(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 28:
                    if (q.n()) {
                        oa renderRequest = dynamicRootView.getRenderRequest();
                        if (renderRequest == null) {
                            return null;
                        }
                        dynamicUnKnowView = new DynamicLottie(context, dynamicRootView, fsVar, renderRequest.h());
                    }
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                case 29:
                    dynamicUnKnowView = new DynamicImageFlipSlide(context, dynamicRootView, fsVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
                default:
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().rv());
                    }
                    break;
            }
        }
        return dynamicUnKnowView;
    }
}
