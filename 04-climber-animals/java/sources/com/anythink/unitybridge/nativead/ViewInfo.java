package com.anythink.unitybridge.nativead;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ViewInfo {
    public INFO IconView;
    public INFO adLogoView;
    public INFO ctaView;
    public INFO descView;
    public INFO dislikeView;
    public INFO elementsView;
    public INFO imgMainView;
    public INFO rootView;
    public INFO titleView;

    protected class INFO {
        protected String name;
        protected int mX = 0;
        protected int mY = 0;
        protected int mWidth = 0;
        protected int mHeight = 0;
        protected String bgcolor = "";
        protected int textSize = 0;
        protected String textcolor = "";
        protected boolean isCustomClick = false;
        protected boolean usesPixel = true;

        public INFO() {
        }
    }

    public static void add2ParentView(FrameLayout frameLayout, View view, INFO info, int i) {
        FrameLayout.LayoutParams layoutParams;
        if (frameLayout == null || info == null) {
            return;
        }
        if (view == null || info.mWidth < 0 || (info.mHeight < 0 && info.mHeight != -2)) {
            Log.e("add2activity--[" + info.name + "]", " config error ,show error !");
            return;
        }
        Log.i("add2activity", "[" + info.name + "]   add 2 activity");
        if (info.usesPixel) {
            layoutParams = new FrameLayout.LayoutParams(info.mWidth, info.mHeight);
            layoutParams.leftMargin = info.mX;
            layoutParams.topMargin = info.mY;
        } else {
            Context context = frameLayout.getContext();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(CommonUtil.dip2px(context, info.mWidth), CommonUtil.dip2px(context, info.mHeight));
            layoutParams2.leftMargin = CommonUtil.dip2px(context, info.mX);
            layoutParams2.topMargin = CommonUtil.dip2px(context, info.mY);
            layoutParams = layoutParams2;
        }
        if (i > 0) {
            layoutParams.gravity = i;
        } else {
            layoutParams.gravity = 51;
        }
        view.setLayoutParams(layoutParams);
        try {
            if (!TextUtils.isEmpty(info.bgcolor)) {
                view.setBackgroundColor(Color.parseColor(info.bgcolor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        frameLayout.addView(view, layoutParams);
    }

    public static void addNativeAdView2Activity(final Activity activity, final ViewInfo viewInfo, final ATNativeAdView aTNativeAdView, final int i) {
        if (activity == null || aTNativeAdView == null) {
            MsgTools.printMsg("pActivity or native ad view is null");
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.nativead.ViewInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) aTNativeAdView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(aTNativeAdView);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (viewInfo.rootView != null) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewInfo.rootView.mWidth, viewInfo.rootView.mHeight);
                        int i2 = i;
                        if (i2 != -1) {
                            layoutParams.gravity = i2;
                        } else {
                            layoutParams.leftMargin = viewInfo.rootView.mX;
                            layoutParams.topMargin = viewInfo.rootView.mY;
                        }
                        if (!TextUtils.isEmpty(viewInfo.rootView.bgcolor)) {
                            aTNativeAdView.setBackgroundColor(Color.parseColor(viewInfo.rootView.bgcolor));
                        }
                        MsgTools.printMsg("Add native view to content start....");
                        activity.addContentView(aTNativeAdView, layoutParams);
                        MsgTools.printMsg("Add native view to content end....");
                        return;
                    }
                    MsgTools.printMsg("pViewInfo.rootView is null");
                }
            });
        }
    }

    public static ViewInfo createDefualtView(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        ViewInfo viewInfo = new ViewInfo();
        viewInfo.rootView.textSize = 12;
        viewInfo.rootView.textcolor = "#0X000000";
        viewInfo.rootView.bgcolor = "#0XFFFFFF";
        viewInfo.rootView.mWidth = i2;
        viewInfo.rootView.mHeight = i / 5;
        viewInfo.rootView.mX = 0;
        viewInfo.rootView.mY = 0;
        viewInfo.rootView.name = "rootView_def";
        viewInfo.imgMainView.textSize = 12;
        viewInfo.imgMainView.textcolor = "#0X000000";
        viewInfo.imgMainView.bgcolor = "#0XFFFFFF";
        viewInfo.imgMainView.mWidth = 25;
        viewInfo.imgMainView.mHeight = 25;
        viewInfo.imgMainView.mX = viewInfo.rootView.mX + 0;
        viewInfo.imgMainView.mY = viewInfo.rootView.mX + 0;
        viewInfo.imgMainView.name = "imgMainView_def";
        viewInfo.adLogoView.textSize = 12;
        viewInfo.adLogoView.textcolor = "#0X000000";
        viewInfo.adLogoView.bgcolor = "#0XFFFFFF";
        viewInfo.adLogoView.mWidth = (viewInfo.rootView.mWidth * 3) / 5;
        viewInfo.adLogoView.mHeight = viewInfo.rootView.mHeight / 2;
        viewInfo.adLogoView.mX = viewInfo.rootView.mX + 100;
        viewInfo.adLogoView.mY = viewInfo.rootView.mX + 10;
        viewInfo.adLogoView.name = "adlogo_def";
        viewInfo.IconView.textSize = 12;
        viewInfo.IconView.textcolor = "#0X000000";
        viewInfo.IconView.bgcolor = "#0XFFFFFF";
        viewInfo.IconView.mWidth = 25;
        viewInfo.IconView.mHeight = 25;
        viewInfo.IconView.mX = viewInfo.rootView.mX + 0;
        viewInfo.IconView.mY = viewInfo.rootView.mX + 0;
        viewInfo.IconView.name = "appicon_def";
        viewInfo.titleView.textSize = 12;
        viewInfo.titleView.textcolor = "#0X000000";
        viewInfo.titleView.bgcolor = "#0XFFFFFF";
        viewInfo.titleView.mWidth = 25;
        viewInfo.titleView.mHeight = 25;
        viewInfo.titleView.mX = viewInfo.rootView.mX + 0;
        viewInfo.titleView.mY = viewInfo.rootView.mX + 0;
        viewInfo.descView.textSize = 12;
        viewInfo.descView.textcolor = "#0X000000";
        viewInfo.descView.bgcolor = "#0XFFFFFF";
        viewInfo.descView.mWidth = 25;
        viewInfo.descView.mHeight = 25;
        viewInfo.descView.mX = viewInfo.rootView.mX + 0;
        viewInfo.descView.mY = viewInfo.rootView.mX + 0;
        viewInfo.descView.name = "desc_def";
        viewInfo.ctaView.textSize = 12;
        viewInfo.ctaView.textcolor = "#0X000000";
        viewInfo.ctaView.bgcolor = "#0XFFFFFF";
        viewInfo.ctaView.mWidth = 25;
        viewInfo.ctaView.mHeight = 25;
        viewInfo.ctaView.mX = viewInfo.rootView.mX + 0;
        viewInfo.ctaView.mY = viewInfo.rootView.mX + 0;
        viewInfo.ctaView.name = "cta_def";
        viewInfo.dislikeView.textSize = 12;
        viewInfo.dislikeView.textcolor = "#0X000000";
        viewInfo.dislikeView.bgcolor = "#0X000000";
        viewInfo.dislikeView.mWidth = 25;
        viewInfo.dislikeView.mHeight = 25;
        viewInfo.dislikeView.mX = viewInfo.rootView.mX + 0;
        viewInfo.dislikeView.mY = viewInfo.rootView.mX + 0;
        viewInfo.dislikeView.name = "dislike_def";
        viewInfo.elementsView = viewInfo.getDefaultViewInfoForElements(viewInfo.rootView);
        return viewInfo;
    }

    INFO getDefaultViewInfoForElements(INFO info) {
        INFO info2 = new INFO();
        info2.textSize = 12;
        info2.textcolor = "#FFFFFF";
        info2.bgcolor = "#7F000000";
        info2.mWidth = info.mWidth;
        info2.mHeight = 60;
        info2.mX = info.mX + 0;
        info2.mY = info.mX + 0;
        info2.name = "elements_def";
        return info2;
    }

    public INFO parseINFO(String str, String str2, int i, int i2) throws JSONException {
        INFO info = new INFO();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("x")) {
            info.mX = jSONObject.getInt("x") + i;
        }
        if (jSONObject.has("y")) {
            info.mY = jSONObject.getInt("y") + i2;
        }
        if (jSONObject.has("width")) {
            info.mWidth = jSONObject.getInt("width");
        }
        if (jSONObject.has("height")) {
            info.mHeight = jSONObject.getInt("height");
        }
        if (jSONObject.has("backgroundColor")) {
            info.bgcolor = jSONObject.getString("backgroundColor");
        }
        if (jSONObject.has("textColor")) {
            info.textcolor = jSONObject.getString("textColor");
        }
        if (jSONObject.has("textSize")) {
            info.textSize = jSONObject.getInt("textSize");
        }
        if (jSONObject.has("isCustomClick")) {
            info.isCustomClick = jSONObject.getBoolean("isCustomClick");
        }
        if (jSONObject.has("usesPixel")) {
            info.usesPixel = jSONObject.getBoolean("usesPixel");
        }
        info.name = str2;
        return info;
    }
}
