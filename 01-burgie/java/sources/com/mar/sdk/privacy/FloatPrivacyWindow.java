package com.mar.sdk.privacy;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mar.sdk.log.Log;
import com.mar.sdk.utils.AnsyImageUtil;
import com.mar.sdk.utils.ResourceHelper;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class FloatPrivacyWindow extends BaseFloatPrivacyManager {
    IOnItemClicked itemClickedListener;
    private TextView leftBackText;
    private TextView rightBackText;

    public interface IOnItemClicked {
        void onBackItemClick();

        void onClose();

        void onCloseItemClick();

        void onExpand();
    }

    public FloatPrivacyWindow(Activity context, int location, int defaultY, String url, IOnItemClicked callBack) {
        super(context, location, defaultY, url);
        this.itemClickedListener = callBack;
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    protected View getLeftView(LayoutInflater inflater, View.OnTouchListener touchListener) {
        View view = inflater.inflate(ResourceHelper.getIdentifier(this.mActivity, "R.layout.mar_float_window_left"), (ViewGroup) null);
        this.leftBackText = (TextView) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.back_item"));
        this.leftBackText.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.privacy.FloatPrivacyWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FloatPrivacyWindow.this.itemClickedListener.onBackItemClick();
            }
        });
        LinearLayout layLeft = (LinearLayout) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.layLeft"));
        layLeft.getBackground().setAlpha(80);
        FrameLayout closeItem = (FrameLayout) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.close_item"));
        closeItem.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.privacy.FloatPrivacyWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FloatPrivacyWindow.this.openOrCloseMenu();
                FloatPrivacyWindow.this.itemClickedListener.onCloseItemClick();
            }
        });
        ImageView icon = (ImageView) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.icon"));
        loadImg(icon);
        return view;
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    protected View getRightView(LayoutInflater inflater, View.OnTouchListener touchListener) {
        View view = inflater.inflate(ResourceHelper.getIdentifier(this.mActivity, "R.layout.mar_float_window_right"), (ViewGroup) null);
        this.rightBackText = (TextView) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.back_item"));
        this.rightBackText.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.privacy.FloatPrivacyWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FloatPrivacyWindow.this.itemClickedListener.onBackItemClick();
            }
        });
        LinearLayout layRight = (LinearLayout) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.layRight"));
        layRight.getBackground().setAlpha(80);
        FrameLayout closeItem = (FrameLayout) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.close_item"));
        closeItem.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.privacy.FloatPrivacyWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FloatPrivacyWindow.this.openOrCloseMenu();
                FloatPrivacyWindow.this.itemClickedListener.onCloseItemClick();
            }
        });
        ImageView icon = (ImageView) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.icon"));
        loadImg(icon);
        return view;
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    protected View getLogoView(LayoutInflater inflater) {
        View view = inflater.inflate(ResourceHelper.getIdentifier(this.mActivity, "R.layout.mar_float_window_logo"), (ViewGroup) null);
        ImageView imageView = (ImageView) view.findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.logo"));
        loadImg(imageView);
        return view;
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.mar.sdk.privacy.FloatPrivacyWindow$5] */
    private void loadImg(final ImageView imageView) {
        if (this.iconUrl == null || "".equals(this.iconUrl)) {
            try {
                InputStream inputStream = this.mActivity.getAssets().open("floating.png");
                Drawable drawable = Drawable.createFromStream(inputStream, null);
                imageView.setImageDrawable(drawable);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        new AnsyImageUtil(this.mActivity, this.iconUrl) { // from class: com.mar.sdk.privacy.FloatPrivacyWindow.5
            @Override // com.mar.sdk.utils.AnsyImageUtil
            public void onReceived(Drawable result) {
                imageView.setImageDrawable(result);
            }
        }.execute(new Void[0]);
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    protected void resetLogoViewSize(int hintLocation, View logoView) {
        logoView.clearAnimation();
        logoView.setTranslationX(0.0f);
        logoView.setScaleX(1.0f);
        logoView.setScaleY(1.0f);
        logoView.setAlpha(1.0f);
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    protected void dragingLogoViewOffset(View logoView, boolean isDraging, boolean isResetPosition, float offset) {
        if (!isDraging || offset <= 0.0f) {
            logoView.setTranslationX(0.0f);
            logoView.setScaleX(1.0f);
            logoView.setScaleY(1.0f);
        }
        if (isResetPosition) {
            if (Build.VERSION.SDK_INT >= 21) {
                logoView.setRotation(offset * 360.0f);
                return;
            }
            return;
        }
        logoView.setRotation(offset * 360.0f);
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    public void shrinkLeftLogoView(View smallView) {
        Log.i("MARSDK", "开始执行left操作" + smallView.getWidth());
        smallView.setTranslationX(((-smallView.getWidth()) / 3) * 2);
        smallView.setAlpha(0.7f);
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    public void shrinkRightLogoView(View smallView) {
        Log.i("MARSDK", "开始执行Right操作" + smallView.getWidth());
        smallView.setTranslationX((smallView.getWidth() / 3) * 2);
        smallView.setAlpha(0.7f);
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    public void leftViewOpened(View leftView) {
        this.itemClickedListener.onExpand();
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    public void rightViewOpened(View rightView) {
        this.itemClickedListener.onExpand();
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    public void leftOrRightViewClosed(View smallView) {
        this.itemClickedListener.onClose();
    }

    @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
    protected void onDestoryed() {
        if (isApplictionDialog() && (getContext() instanceof Activity)) {
            dismiss();
        }
    }

    public void show(String info) {
        super.show();
        if (this.leftBackText != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.leftBackText.setText(Html.fromHtml(info, 0));
            } else {
                this.leftBackText.setText(Html.fromHtml(info));
            }
        }
        if (this.rightBackText != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.rightBackText.setText(Html.fromHtml(info, 0));
            } else {
                this.rightBackText.setText(Html.fromHtml(info));
            }
        }
    }
}
