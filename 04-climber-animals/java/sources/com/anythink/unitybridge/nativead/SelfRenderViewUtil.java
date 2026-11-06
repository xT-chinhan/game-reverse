package com.anythink.unitybridge.nativead;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.basead.c.b;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.nativead.api.ATNativeImageView;
import com.anythink.nativead.api.ATNativeMaterial;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.utils.CommonUtil;
import com.anythink.unitybridge.view.SimpleWebViewActivity;
import com.bykv.vk.component.ttvideo.player.C;
import com.huawei.hms.ads.AppDownloadButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SelfRenderViewUtil {
    Activity mActivity;
    ImageView mDislikeView;
    FrameLayout mFrameLayout;
    int mNetworkType;
    ViewInfo mViewInfo;

    public SelfRenderViewUtil(Activity activity, ViewInfo viewInfo, int i) {
        this.mActivity = activity;
        this.mViewInfo = viewInfo;
        this.mNetworkType = i;
    }

    public FrameLayout bindSelfRenderView(ATNativeMaterial aTNativeMaterial, ATNativePrepareInfo aTNativePrepareInfo, ViewInfo viewInfo) {
        ATNativeImageView aTNativeImageView;
        AppDownloadButton textView;
        View view;
        View view2;
        this.mFrameLayout = new FrameLayout(this.mActivity);
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        TextView textView2 = new TextView(this.mActivity);
        TextView textView3 = new TextView(this.mActivity);
        List<View> arrayList = new ArrayList<>();
        List<View> arrayList2 = new ArrayList<>();
        View adMediaView = aTNativeMaterial.getAdMediaView(frameLayout);
        if (adMediaView != null) {
            MsgTools.printMsg("media view ---> " + aTNativeMaterial.getVideoUrl());
            if (viewInfo.imgMainView != null) {
                ViewInfo.add2ParentView(frameLayout, adMediaView, viewInfo.imgMainView, -1);
            }
        } else {
            MsgTools.printMsg("main image ---> " + aTNativeMaterial.getMainImageUrl());
            if (viewInfo.imgMainView != null) {
                ATNativeImageView aTNativeImageView2 = new ATNativeImageView(this.mActivity);
                ViewInfo.add2ParentView(frameLayout, aTNativeImageView2, viewInfo.imgMainView, -1);
                aTNativeImageView2.setImage(aTNativeMaterial.getMainImageUrl());
                aTNativePrepareInfo.setMainImageView(aTNativeImageView2);
            }
        }
        if (viewInfo.titleView != null) {
            if (!TextUtils.isEmpty(viewInfo.titleView.textcolor)) {
                textView2.setTextColor(Color.parseColor(viewInfo.titleView.textcolor));
            }
            if (viewInfo.titleView.textSize > 0) {
                textView2.setTextSize(viewInfo.titleView.textSize);
            }
            MsgTools.printMsg("title----> " + aTNativeMaterial.getTitle());
            textView2.setText(aTNativeMaterial.getTitle());
            textView2.setSingleLine();
            textView2.setMaxEms(15);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            ViewInfo.add2ParentView(frameLayout, textView2, viewInfo.titleView, -1);
            aTNativePrepareInfo.setTitleView(textView2);
        }
        if (viewInfo.descView != null) {
            if (!TextUtils.isEmpty(viewInfo.descView.textcolor)) {
                textView3.setTextColor(Color.parseColor(viewInfo.descView.textcolor));
            }
            if (viewInfo.descView.textSize > 0) {
                textView3.setTextSize(viewInfo.descView.textSize);
            }
            MsgTools.printMsg("desc----> " + aTNativeMaterial.getDescriptionText());
            textView3.setText(aTNativeMaterial.getDescriptionText());
            textView3.setMaxLines(3);
            textView3.setMaxEms(15);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            ViewInfo.add2ParentView(frameLayout, textView3, viewInfo.descView, -1);
            aTNativePrepareInfo.setDescView(textView3);
        }
        if (viewInfo.IconView != null) {
            FrameLayout frameLayout2 = new FrameLayout(this.mActivity);
            View adIconView = aTNativeMaterial.getAdIconView();
            if (adIconView == null) {
                aTNativeImageView = new ATNativeImageView(this.mActivity);
                frameLayout2.addView(aTNativeImageView, new FrameLayout.LayoutParams(-1, -1));
                aTNativeImageView.setImage(aTNativeMaterial.getIconImageUrl());
                MsgTools.printMsg("ad icon url----> " + aTNativeMaterial.getIconImageUrl());
            } else {
                MsgTools.printMsg("ad icon view----> " + adIconView);
                frameLayout2.addView(adIconView, new FrameLayout.LayoutParams(-1, -1));
                aTNativeImageView = null;
            }
            ViewInfo.add2ParentView(frameLayout, frameLayout2, viewInfo.IconView, -1);
            aTNativePrepareInfo.setIconView(aTNativeImageView);
        } else {
            aTNativeImageView = null;
        }
        if (viewInfo.ctaView != null) {
            try {
                if (this.mNetworkType == 39) {
                    textView = aTNativeMaterial.getCallToActionButton();
                    if (textView != null && (textView instanceof AppDownloadButton)) {
                        CustomAppDownloadButtonStyle customAppDownloadButtonStyle = new CustomAppDownloadButtonStyle(this.mActivity, viewInfo);
                        if (viewInfo.ctaView.textSize > 0) {
                            textView.setTextSize(CommonUtil.dip2px(this.mActivity, viewInfo.ctaView.textSize));
                        }
                        textView.setAppDownloadButtonStyle(customAppDownloadButtonStyle);
                        MsgTools.printMsg("cta----> download button");
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewInfo.ctaView.mWidth, viewInfo.ctaView.mHeight);
                        layoutParams.leftMargin = viewInfo.ctaView.mX;
                        layoutParams.topMargin = viewInfo.ctaView.mY;
                        layoutParams.gravity = 51;
                        frameLayout.addView((View) textView, (ViewGroup.LayoutParams) layoutParams);
                    }
                } else {
                    textView = null;
                }
            } catch (Throwable th) {
                if (MsgTools.isDebug) {
                    th.printStackTrace();
                }
            }
            if (textView == null) {
                textView = new TextView(this.mActivity);
                if (!TextUtils.isEmpty(viewInfo.ctaView.textcolor)) {
                    textView.setTextColor(Color.parseColor(viewInfo.ctaView.textcolor));
                }
                if (viewInfo.ctaView.textSize > 0) {
                    textView.setTextSize(viewInfo.ctaView.textSize);
                }
                textView.setGravity(17);
                textView.setSingleLine();
                textView.setMaxEms(15);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                MsgTools.printMsg("cta----> " + aTNativeMaterial.getCallToActionText());
                textView.setText(aTNativeMaterial.getCallToActionText());
                ViewInfo.add2ParentView(frameLayout, textView, viewInfo.ctaView, -1);
                aTNativePrepareInfo.setCtaView(textView);
            }
        } else {
            textView = null;
        }
        if (!TextUtils.isEmpty(aTNativeMaterial.getAdFrom())) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = CommonUtil.dip2px(this.mActivity, 3.0f);
            layoutParams2.bottomMargin = CommonUtil.dip2px(this.mActivity, 3.0f);
            layoutParams2.gravity = 80;
            TextView textView4 = new TextView(this.mActivity);
            textView4.setTextSize(1, 6.0f);
            textView4.setPadding(CommonUtil.dip2px(this.mActivity, 5.0f), CommonUtil.dip2px(this.mActivity, 2.0f), CommonUtil.dip2px(this.mActivity, 5.0f), CommonUtil.dip2px(this.mActivity, 2.0f));
            textView4.setBackgroundColor(-7829368);
            textView4.setTextColor(-1);
            textView4.setText(aTNativeMaterial.getAdFrom());
            MsgTools.printMsg("ad from----> " + aTNativeMaterial.getAdFrom());
            frameLayout.addView(textView4, layoutParams2);
            aTNativePrepareInfo.setAdFromView(textView4);
        }
        if (viewInfo.elementsView != null) {
            ATAdAppInfo adAppInfo = aTNativeMaterial.getAdAppInfo();
            if (adAppInfo != null) {
                MsgTools.printMsg("adAppInfo----> " + adAppInfo.toString());
                String appName = adAppInfo.getAppName();
                if (!TextUtils.isEmpty(appName)) {
                    MsgTools.printMsg("update title ----> " + appName);
                    textView2.setText(appName);
                }
                View viewCreateElementsView = createElementsView(viewInfo.elementsView, adAppInfo);
                if (viewCreateElementsView != null) {
                    ViewInfo.add2ParentView(frameLayout, viewCreateElementsView, viewInfo.elementsView, -1);
                }
            } else {
                MsgTools.printMsg("adAppInfo----> null");
            }
        }
        if (viewInfo.adLogoView != null) {
            View adLogoView = aTNativeMaterial.getAdLogoView();
            if (adLogoView != null) {
                MsgTools.printMsg("ad logo view----> " + adLogoView);
                ViewInfo.add2ParentView(frameLayout, adLogoView, viewInfo.adLogoView, -1);
                aTNativePrepareInfo.setAdLogoView(adLogoView);
                view2 = adLogoView;
            } else {
                String adChoiceIconUrl = aTNativeMaterial.getAdChoiceIconUrl();
                Bitmap adLogo = aTNativeMaterial.getAdLogo();
                ATNativeImageView aTNativeImageView3 = new ATNativeImageView(this.mActivity);
                if (!TextUtils.isEmpty(adChoiceIconUrl)) {
                    MsgTools.printMsg("ad choice url----> " + adChoiceIconUrl);
                    aTNativeImageView3.setImage(adChoiceIconUrl);
                    ViewInfo.add2ParentView(frameLayout, aTNativeImageView3, viewInfo.adLogoView, -1);
                    aTNativePrepareInfo.setAdLogoView(aTNativeImageView3);
                } else if (adLogo != null) {
                    MsgTools.printMsg("ad logo bitmap----> " + adLogo);
                    aTNativeImageView3.setImageBitmap(adLogo);
                    ViewInfo.add2ParentView(frameLayout, aTNativeImageView3, viewInfo.adLogoView, -1);
                    aTNativePrepareInfo.setAdLogoView(aTNativeImageView3);
                } else {
                    MsgTools.printMsg("start to add adMaterial label textview");
                    TextView textView5 = new TextView(this.mActivity);
                    textView5.setTextColor(-1);
                    textView5.setText("AD");
                    textView5.setTextSize(11.0f);
                    textView5.setPadding(CommonUtil.dip2px(this.mActivity, 3.0f), 0, CommonUtil.dip2px(this.mActivity, 3.0f), 0);
                    textView5.setBackgroundColor(Color.parseColor("#66000000"));
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.leftMargin = CommonUtil.dip2px(this.mActivity, 3.0f);
                    layoutParams3.topMargin = CommonUtil.dip2px(this.mActivity, 3.0f);
                    frameLayout.addView(textView5, layoutParams3);
                    MsgTools.printMsg("add adMaterial label textview 2 activity");
                    aTNativePrepareInfo.setAdLogoView(textView5);
                    view2 = null;
                }
                view2 = aTNativeImageView3;
            }
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(viewInfo.adLogoView.mWidth, viewInfo.adLogoView.mHeight);
            layoutParams4.leftMargin = viewInfo.adLogoView.mX;
            layoutParams4.topMargin = viewInfo.adLogoView.mY;
            aTNativePrepareInfo.setChoiceViewLayoutParams(layoutParams4);
            view = view2;
        } else {
            view = null;
        }
        if (viewInfo.dislikeView != null) {
            initDislikeView(viewInfo.dislikeView);
            MsgTools.printMsg("ad dislike----> " + this.mDislikeView);
            ViewInfo.add2ParentView(frameLayout, this.mDislikeView, viewInfo.dislikeView, -1);
            aTNativePrepareInfo.setCloseView(this.mDislikeView);
        }
        if (viewInfo.rootView != null) {
            dealWithClick(frameLayout, viewInfo.rootView.isCustomClick, arrayList, arrayList2, "root");
        }
        if (viewInfo.titleView != null) {
            dealWithClick(textView2, viewInfo.titleView.isCustomClick, arrayList, arrayList2, "title");
        }
        if (viewInfo.descView != null) {
            dealWithClick(textView3, viewInfo.descView.isCustomClick, arrayList, arrayList2, b.a.f);
        }
        if (viewInfo.IconView != null) {
            dealWithClick(aTNativeImageView, viewInfo.IconView.isCustomClick, arrayList, arrayList2, "icon");
        }
        if (viewInfo.adLogoView != null) {
            dealWithClick(view, viewInfo.adLogoView.isCustomClick, arrayList, arrayList2, "adLogo");
        }
        if (viewInfo.ctaView != null) {
            dealWithClick(textView, viewInfo.ctaView.isCustomClick, arrayList, arrayList2, b.a.k);
        }
        aTNativePrepareInfo.setClickViewList(arrayList);
        if (aTNativePrepareInfo instanceof ATNativePrepareExInfo) {
            ((ATNativePrepareExInfo) aTNativePrepareInfo).setCreativeClickViewList(arrayList2);
        }
        return frameLayout;
    }

    private void initDislikeView(ViewInfo.INFO info) {
        if (this.mDislikeView == null) {
            ImageView imageView = new ImageView(this.mActivity);
            this.mDislikeView = imageView;
            imageView.setImageResource(CommonUtil.getResId(this.mActivity, "btn_close", "drawable"));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(info.mWidth, info.mHeight);
        layoutParams.leftMargin = info.mX;
        layoutParams.topMargin = info.mY;
        if (!TextUtils.isEmpty(info.bgcolor)) {
            this.mDislikeView.setBackgroundColor(Color.parseColor(info.bgcolor));
        }
        this.mDislikeView.setLayoutParams(layoutParams);
    }

    private void dealWithClick(View view, boolean z, List<View> list, List<View> list2, String str) {
        if (view == null) {
            return;
        }
        int i = this.mNetworkType;
        if ((i == 8 || i == 22) && z) {
            MsgTools.printMsg("add customClick ----> " + str);
            list2.add(view);
        } else {
            MsgTools.printMsg("add click ----> " + str);
            list.add(view);
        }
    }

    private View createElementsView(ViewInfo.INFO info, ATAdAppInfo aTAdAppInfo) {
        if (info == null || aTAdAppInfo == null) {
            MsgTools.printMsg("createElementsView ----> " + info + ", " + aTAdAppInfo);
            return null;
        }
        String appVersion = aTAdAppInfo.getAppVersion();
        String publisher = aTAdAppInfo.getPublisher();
        String appPermissonUrl = aTAdAppInfo.getAppPermissonUrl();
        String appPrivacyUrl = aTAdAppInfo.getAppPrivacyUrl();
        String functionUrl = aTAdAppInfo.getFunctionUrl();
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(0);
        if (!TextUtils.isEmpty(functionUrl)) {
            TextView textView = new TextView(this.mActivity);
            setupElementView(info, "function", textView, "功能");
            setOpenUrlClickListener(textView, functionUrl);
            linearLayout.addView(textView);
        }
        if (!TextUtils.isEmpty(appPrivacyUrl)) {
            TextView textView2 = new TextView(this.mActivity);
            setupElementView(info, "privacy", textView2, "隐私");
            setOpenUrlClickListener(textView2, appPrivacyUrl);
            linearLayout.addView(textView2);
        }
        if (!TextUtils.isEmpty(appPermissonUrl)) {
            TextView textView3 = new TextView(this.mActivity);
            setupElementView(info, "permission", textView3, "权限");
            setOpenUrlClickListener(textView3, appPermissonUrl);
            linearLayout.addView(textView3);
        }
        if (!TextUtils.isEmpty(publisher)) {
            TextView textView4 = new TextView(this.mActivity);
            setupElementView(info, "publisher", textView4, publisher);
            linearLayout.addView(textView4);
        }
        if (!TextUtils.isEmpty(appVersion)) {
            TextView textView5 = new TextView(this.mActivity);
            setupElementView(info, "appVersion", textView5, "v" + appVersion);
            linearLayout.addView(textView5);
        }
        if (linearLayout.getChildCount() > 0) {
            return linearLayout;
        }
        return null;
    }

    private void setupElementView(ViewInfo.INFO info, String str, TextView textView, String str2) {
        try {
            textView.setTextColor(Color.parseColor(info.textcolor));
            textView.setTextSize(info.textSize);
            MsgTools.printMsg(str + "----> " + str2);
            textView.setText(str2);
            textView.setSingleLine();
            textView.setMaxEms(15);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            int iDip2px = CommonUtil.dip2px(this.mActivity, 2.0f);
            textView.setPadding(iDip2px, iDip2px, iDip2px, iDip2px);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            textView.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void setOpenUrlClickListener(View view, final String str) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.unitybridge.nativead.SelfRenderViewUtil.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    MsgTools.printMsg("open url: " + str);
                    Intent intent = new Intent(SelfRenderViewUtil.this.mActivity, (Class<?>) SimpleWebViewActivity.class);
                    intent.putExtra(SimpleWebViewActivity.EXTRA_URL, str);
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                    SelfRenderViewUtil.this.mActivity.startActivity(intent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
