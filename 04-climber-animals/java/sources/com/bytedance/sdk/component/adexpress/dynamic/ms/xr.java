package com.bytedance.sdk.component.adexpress.dynamic.ms;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicClose;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislike;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislikeFeedBack;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLeisureWidget;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLogoAd;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLogoUnion;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLottie;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicMutedView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicPrivacyView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRoot;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDown;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDownBtn;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDownContainer;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSplitLineView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicStarView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuter;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterContainerWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterRewardFullSkip;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterSkip;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicUnKnowView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVideoView;
import com.bytedance.sdk.component.adexpress.xr.zb;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x0111  */
    public static DynamicBaseWidget ms(Context context, DynamicRootView dynamicRootView, x xVar) {
        DynamicBaseWidget dynamicUnKnowView = null;
        if (context != null && dynamicRootView != null && xVar != null && xVar.ch() != null) {
            switch (xVar.ch().ms()) {
                case -1:
                    dynamicUnKnowView = new DynamicUnKnowView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null && dynamicRootView.getRenderRequest() != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 0:
                    dynamicUnKnowView = new DynamicTextView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 1:
                    dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 2:
                    dynamicUnKnowView = new DynamicButton(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 3:
                    dynamicUnKnowView = new DynamicDislike(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 4:
                    dynamicUnKnowView = new DynamicLogoAd(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 5:
                    dynamicUnKnowView = new DynamicLogoUnion(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 6:
                case 9:
                case 17:
                    dynamicUnKnowView = new DynamicBaseWidgetImp(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 7:
                    dynamicUnKnowView = new DynamicVideoView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 8:
                    dynamicUnKnowView = new DynamicRoot(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 10:
                    dynamicUnKnowView = new DynamicMutedView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 11:
                    dynamicUnKnowView = new DynamicStarView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 12:
                    dynamicUnKnowView = new DynamicDislikeFeedBack(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 13:
                    dynamicUnKnowView = new DynamicTimeOuter(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 14:
                    dynamicUnKnowView = new DynamicTimeOuterContainerWidgetImp(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 15:
                    if (d.ms()) {
                        dynamicUnKnowView = new DynamicTimeOuterRewardFullSkip(context, dynamicRootView, xVar);
                    } else {
                        dynamicUnKnowView = new DynamicTimeOuterSkip(context, dynamicRootView, xVar);
                    }
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 16:
                    dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 18:
                    dynamicUnKnowView = new DynamicSplitLineView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 19:
                    dynamicUnKnowView = new DynamicSkipCountDownContainer(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 20:
                    dynamicUnKnowView = new DynamicSkipCountDown(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 21:
                    dynamicUnKnowView = new DynamicSkipCountDownBtn(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 22:
                    dynamicUnKnowView = new DynamicClose(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 23:
                    dynamicUnKnowView = new DynamicPrivacyView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 24:
                    dynamicUnKnowView = new DynamicBaseScrollWidgetImp(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 25:
                    dynamicUnKnowView = new DynamicLeisureWidget(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 26:
                    if ("vertical".equals(xVar.ch().ka().oh())) {
                        dynamicUnKnowView = new DynamicVerticalScrollWidgetImp(context, dynamicRootView, xVar);
                    } else {
                        dynamicUnKnowView = new DynamicBaseInternalScrollWidgetImp(context, dynamicRootView, xVar);
                    }
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 27:
                    dynamicUnKnowView = new DynamicTimeOuterSkip(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 28:
                    if (d.ms()) {
                        zb renderRequest = dynamicRootView.getRenderRequest();
                        if (renderRequest == null) {
                            return null;
                        }
                        dynamicUnKnowView = new DynamicLottie(context, dynamicRootView, xVar, renderRequest.op());
                    }
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                case 29:
                    dynamicUnKnowView = new DynamicImageFlipSlide(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
                default:
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().ny());
                    }
                    break;
            }
        }
        return dynamicUnKnowView;
    }
}
