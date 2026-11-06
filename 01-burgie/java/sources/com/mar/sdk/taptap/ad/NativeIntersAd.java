package com.mar.sdk.taptap.ad;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.AdInst;
import com.mar.sdk.log.Log;
import com.tapsdk.tapad.group.DirichletAdManager;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.DirichletAdRequest;
import com.tapsdk.tapad.group.ads.DirichletNativeFeedAd;
import com.tapsdk.tapad.group.views.DirichletAdNativeContainer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativeIntersAd extends AdInst {
    private static NativeIntersAd instance;
    private DirichletAdNative adNative;
    private View nativeIntersView;
    private DirichletNativeFeedAd tapFeedAd;

    public static synchronized NativeIntersAd getInstance() {
        if (instance == null) {
            instance = new NativeIntersAd();
        }
        return instance;
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doInit() {
        this.adNative = DirichletAdManager.get().createAdNative(MARSDK.getInstance().getContext());
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doLoad(String adId) {
        long spaceId = 0;
        try {
            spaceId = Long.parseLong(adId);
        } catch (Exception e) {
            Log.d("MARSDK-AD", "NativeIntersAd spaceId:0 Exception:" + e.toString());
        }
        DirichletAdRequest request = new DirichletAdRequest.Builder().withSpaceId(spaceId).build();
        this.adNative.loadNativeFeedAd(request, new DirichletAdNative.NativeFeedAdListener() { // from class: com.mar.sdk.taptap.ad.NativeIntersAd.1
            @Override // com.tapsdk.tapad.group.DirichletAdNative.NativeFeedAdListener
            public void onNativeFeedAdLoad(List<DirichletNativeFeedAd> list) {
                Log.d("MARSDK-AD", "信息流广告加载成功，数量: " + list.size());
                NativeIntersAd.this.onLoad(true, null);
                if (!list.isEmpty()) {
                    NativeIntersAd.this.tapFeedAd = list.get(0);
                    NativeIntersAd.this.onLoad(true, null);
                }
            }

            @Override // com.tapsdk.tapad.group.CommonListener
            public void onError(int code, String message) {
                Log.e("MARSDK-AD", "信息流广告加载失败: " + code + ", " + message);
                NativeIntersAd.this.onLoad(false, code + ", " + message);
            }
        });
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doShow() {
        if (this.tapFeedAd == null) {
            Log.d("MARSDK-AD", "NativeIntersAd tapFeedAd is null");
            return;
        }
        Activity mActivity = MARSDK.getInstance().getContext();
        View view = this.nativeIntersView;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.nativeIntersView.getParent()).removeView(this.nativeIntersView);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -1);
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        View viewInflate = inflater.inflate(mActivity.getResources().getIdentifier("activity_dirichlet_native", "layout", mActivity.getPackageName()), (ViewGroup) null);
        this.nativeIntersView = viewInflate;
        mActivity.addContentView(viewInflate, params);
        DirichletAdNativeContainer adNativeContainer = (DirichletAdNativeContainer) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_dirichlet", "id", mActivity.getPackageName()));
        View laybrg = (LinearLayout) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_laybrg", "id", mActivity.getPackageName()));
        ImageView imgview = (ImageView) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_big_img", "id", mActivity.getPackageName()));
        FrameLayout videoView = (FrameLayout) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_big_video", "id", mActivity.getPackageName()));
        ImageView close = (ImageView) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_close", "id", mActivity.getPackageName()));
        ImageView icon = (ImageView) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_icon_img", "id", mActivity.getPackageName()));
        TextView title = (TextView) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_title", "id", mActivity.getPackageName()));
        TextView desc = (TextView) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_desc", "id", mActivity.getPackageName()));
        View clickbtn = (ImageView) this.nativeIntersView.findViewById(mActivity.getResources().getIdentifier("mar_inters_btn_bg", "id", mActivity.getPackageName()));
        if (this.tapFeedAd.getTitle() != null && !this.tapFeedAd.getTitle().equals("")) {
            title.setText(this.tapFeedAd.getTitle());
        }
        if (this.tapFeedAd.getDescription() != null && !this.tapFeedAd.getDescription().equals("")) {
            desc.setText(this.tapFeedAd.getDescription());
        }
        if (this.tapFeedAd.getIconUrl() != null && !this.tapFeedAd.getIconUrl().equals("")) {
            Glide.with(mActivity).load(this.tapFeedAd.getIconUrl()).into(icon);
        }
        if (this.tapFeedAd.getImageMode() == 2) {
            videoView.setVisibility(0);
            imgview.setVisibility(8);
            if (this.tapFeedAd.getAdView() != null) {
                videoView.addView(this.tapFeedAd.getAdView());
            }
        } else {
            videoView.setVisibility(8);
            imgview.setVisibility(0);
            if (this.tapFeedAd.getImageInfoList() != null && this.tapFeedAd.getImageInfoList().size() > 0) {
                Glide.with(mActivity).load(this.tapFeedAd.getImageInfoList().get(0).imageUrl).into(imgview);
            }
        }
        close.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.taptap.ad.NativeIntersAd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                NativeIntersAd.this.doHide();
            }
        });
        List<View> clicklist = new ArrayList<>();
        clicklist.add(laybrg);
        clicklist.add(clickbtn);
        List<View> list = new ArrayList<>();
        this.tapFeedAd.registerViewForInteraction(MARSDK.getInstance().getContext(), adNativeContainer, clicklist, list, new DirichletNativeFeedAd.AdInteractionListener() { // from class: com.mar.sdk.taptap.ad.NativeIntersAd.3
            @Override // com.tapsdk.tapad.group.ads.DirichletNativeFeedAd.AdInteractionListener
            public void onAdClick(View view2, DirichletNativeFeedAd dirichletNativeFeedAd) {
                NativeIntersAd.this.onClick();
                NativeIntersAd.this.doHide();
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletNativeFeedAd.AdInteractionListener
            public void onAdShow(DirichletNativeFeedAd dirichletNativeFeedAd) {
            }
        });
        onShow(true, null);
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doHide() {
        DirichletNativeFeedAd dirichletNativeFeedAd = this.tapFeedAd;
        if (dirichletNativeFeedAd != null) {
            dirichletNativeFeedAd.destroy();
        }
        this.tapFeedAd = null;
        View view = this.nativeIntersView;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.nativeIntersView.getParent()).removeView(this.nativeIntersView);
        }
        onHide();
    }
}
