package com.mar.sdk.privacy;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.utils.GUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseFloatPrivacyManager {
    public static final int LEFT = 0;
    private static final String LOCATION_X = "hintLocation";
    private static final String LOCATION_Y = "locationY";
    public static final int RIGHT = 1;
    protected String iconUrl;
    private boolean isApplictionDialog;
    private boolean isDraging;
    private boolean isExpandedHasOperator;
    private boolean isExpaned;
    private boolean isOpenExpandedAutoHide;
    private View leftView;
    private View logoView;
    protected Activity mActivity;
    private int mDefaultLocation;
    private GetViewCallback mGetViewCallback;
    private Handler mHandler;
    private CountDownTimer mHideExpandedTimer;
    private CountDownTimer mHideTimer;
    private int mHintLocation;
    private Interpolator mLinearInterpolator;
    private int mOffsetToBottom;
    private int mOffsetToTop;
    private int mResetLocationValue;
    private int mScreenHeight;
    private int mScreenWidth;
    private float mXDownInScreen;
    private float mXInScreen;
    private float mXInView;
    private float mYDownInScreen;
    private float mYInScreen;
    private float mYinview;
    private View rightView;
    private View.OnTouchListener touchListener;
    private Runnable updatePositionRunnable;
    ValueAnimator valueAnimator;
    private WindowManager wManager;
    private WindowManager.LayoutParams wmParams;

    public interface GetViewCallback {
        void dragingLogoViewOffset(View view, boolean z, boolean z2, float f);

        View getLeftView(LayoutInflater layoutInflater, View.OnTouchListener onTouchListener);

        View getLogoView(LayoutInflater layoutInflater);

        View getRightView(LayoutInflater layoutInflater, View.OnTouchListener onTouchListener);

        void leftOrRightViewClosed(View view);

        void leftViewOpened(View view);

        void onDestoryed();

        void resetLogoViewSize(int i, View view);

        void rightViewOpened(View view);

        void shrinkLeftLogoView(View view);

        void shrinkRightLogoView(View view);
    }

    protected abstract void dragingLogoViewOffset(View view, boolean z, boolean z2, float f);

    protected abstract View getLeftView(LayoutInflater layoutInflater, View.OnTouchListener onTouchListener);

    protected abstract View getLogoView(LayoutInflater layoutInflater);

    protected abstract View getRightView(LayoutInflater layoutInflater, View.OnTouchListener onTouchListener);

    protected abstract void leftOrRightViewClosed(View view);

    protected abstract void leftViewOpened(View view);

    protected abstract void onDestoryed();

    protected abstract void resetLogoViewSize(int i, View view);

    protected abstract void rightViewOpened(View view);

    protected abstract void shrinkLeftLogoView(View view);

    protected abstract void shrinkRightLogoView(View view);

    public boolean isApplictionDialog() {
        return this.isApplictionDialog;
    }

    public Context getContext() {
        return this.mActivity;
    }

    public void setOffsetToTop(int mOffsetToTop) {
        this.mOffsetToTop = mOffsetToTop;
    }

    public void setOffsetToBottom(int mOffsetToBottom) {
        this.mOffsetToBottom = mOffsetToBottom;
    }

    public boolean isOpenExpandedAutoHide() {
        return this.isOpenExpandedAutoHide;
    }

    public void setOpenExpandedAutoHide(boolean openExpandedAutoHide) {
        this.isOpenExpandedAutoHide = openExpandedAutoHide;
        if (!openExpandedAutoHide && this.mHideExpandedTimer != null) {
            this.mHideExpandedTimer.cancel();
            this.mHideExpandedTimer = null;
        }
    }

    public boolean isExpandedHasOperator() {
        return this.isExpandedHasOperator;
    }

    public void setExpandedHasOperator(boolean expandedHasOperator) {
        this.isExpandedHasOperator = expandedHasOperator;
        if (this.mHideExpandedTimer != null && !expandedHasOperator) {
            this.mHideExpandedTimer.start();
        }
    }

    public static class FloatDialogImp extends BaseFloatPrivacyManager {
        public FloatDialogImp(Activity context, int defaultY, String url) {
            super(context, defaultY, url);
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected View getLeftView(LayoutInflater inflater, View.OnTouchListener touchListener) {
            return null;
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected View getRightView(LayoutInflater inflater, View.OnTouchListener touchListener) {
            return null;
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected View getLogoView(LayoutInflater inflater) {
            return null;
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected void resetLogoViewSize(int hintLocation, View logoView) {
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected void dragingLogoViewOffset(View logoView, boolean isDraging, boolean isResetPosition, float offset) {
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected void shrinkLeftLogoView(View logoView) {
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected void shrinkRightLogoView(View logoView) {
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected void leftViewOpened(View leftView) {
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected void rightViewOpened(View rightView) {
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected void leftOrRightViewClosed(View logoView) {
        }

        @Override // com.mar.sdk.privacy.BaseFloatPrivacyManager
        protected void onDestoryed() {
        }
    }

    protected BaseFloatPrivacyManager(Activity context, int defaultY, String url) {
        this.mOffsetToBottom = 0;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mLinearInterpolator = new LinearInterpolator();
        this.isDraging = false;
        this.isApplictionDialog = false;
        this.touchListener = new View.OnTouchListener() { // from class: com.mar.sdk.privacy.BaseFloatPrivacyManager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        BaseFloatPrivacyManager.this.floatEventDown(event);
                        break;
                    case 1:
                    case 3:
                        BaseFloatPrivacyManager.this.floatEventUp();
                        break;
                    case 2:
                        BaseFloatPrivacyManager.this.floatEventMove(event);
                        break;
                }
                return true;
            }
        };
        this.valueAnimator = null;
        this.isExpaned = false;
        this.isOpenExpandedAutoHide = true;
        this.isExpandedHasOperator = false;
        this.updatePositionRunnable = new Runnable() { // from class: com.mar.sdk.privacy.BaseFloatPrivacyManager.6
            @Override // java.lang.Runnable
            public void run() {
                BaseFloatPrivacyManager.this.isDraging = true;
                BaseFloatPrivacyManager.this.checkPosition();
            }
        };
        this.mActivity = context;
        this.iconUrl = url;
    }

    protected BaseFloatPrivacyManager(Activity context, int location, int defaultY, String url) {
        this(context, defaultY, url);
        this.mDefaultLocation = location;
        this.mHintLocation = this.mDefaultLocation;
        initFloatWindow(defaultY);
        initTimer();
        initFloatView();
        this.mOffsetToTop = GUtils.getStatusBarHeight(this.mActivity);
    }

    private void initFloatView() {
        LayoutInflater inflater = LayoutInflater.from(this.mActivity);
        this.logoView = this.mGetViewCallback == null ? getLogoView(inflater) : this.mGetViewCallback.getLogoView(inflater);
        this.leftView = this.mGetViewCallback == null ? getLeftView(inflater, this.touchListener) : this.mGetViewCallback.getLeftView(inflater, this.touchListener);
        this.rightView = this.mGetViewCallback == null ? getRightView(inflater, this.touchListener) : this.mGetViewCallback.getRightView(inflater, this.touchListener);
        if (this.logoView == null) {
            throw new IllegalArgumentException("Must impl GetViewCallback or impl " + getClass().getSimpleName() + "and make getLogoView() not return null !");
        }
        this.logoView.setOnTouchListener(this.touchListener);
        this.leftView.setOnTouchListener(this.touchListener);
        this.rightView.setOnTouchListener(this.touchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTimer() {
        long j = 2000;
        long j2 = 10;
        this.mHideTimer = new CountDownTimer(j, j2) { // from class: com.mar.sdk.privacy.BaseFloatPrivacyManager.2
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                if (BaseFloatPrivacyManager.this.isExpaned) {
                    BaseFloatPrivacyManager.this.mHideTimer.cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (BaseFloatPrivacyManager.this.isExpaned) {
                    BaseFloatPrivacyManager.this.mHideTimer.cancel();
                    return;
                }
                if (!BaseFloatPrivacyManager.this.isDraging) {
                    if (BaseFloatPrivacyManager.this.mHintLocation == 0) {
                        if (BaseFloatPrivacyManager.this.mGetViewCallback == null) {
                            BaseFloatPrivacyManager.this.shrinkLeftLogoView(BaseFloatPrivacyManager.this.logoView);
                            return;
                        } else {
                            BaseFloatPrivacyManager.this.mGetViewCallback.shrinkLeftLogoView(BaseFloatPrivacyManager.this.logoView);
                            return;
                        }
                    }
                    if (BaseFloatPrivacyManager.this.mGetViewCallback == null) {
                        BaseFloatPrivacyManager.this.shrinkRightLogoView(BaseFloatPrivacyManager.this.logoView);
                    } else {
                        BaseFloatPrivacyManager.this.mGetViewCallback.shrinkRightLogoView(BaseFloatPrivacyManager.this.logoView);
                    }
                }
            }
        };
        if (this.isOpenExpandedAutoHide) {
            this.mHideExpandedTimer = new CountDownTimer(j, j2) { // from class: com.mar.sdk.privacy.BaseFloatPrivacyManager.3
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    if (!BaseFloatPrivacyManager.this.isExpaned) {
                        BaseFloatPrivacyManager.this.mHideExpandedTimer.cancel();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (!BaseFloatPrivacyManager.this.isExpaned) {
                        BaseFloatPrivacyManager.this.mHideExpandedTimer.cancel();
                    }
                    if (!BaseFloatPrivacyManager.this.isExpandedHasOperator) {
                        BaseFloatPrivacyManager.this.openOrCloseMenu();
                    }
                }
            };
        }
    }

    private void initFloatWindow(int defaultY) {
        this.wmParams = new WindowManager.LayoutParams();
        if (this.mActivity instanceof Activity) {
            Activity activity = this.mActivity;
            this.wManager = activity.getWindowManager();
            this.wmParams.type = 1003;
            this.isApplictionDialog = true;
        } else {
            this.wManager = (WindowManager) this.mActivity.getSystemService("window");
            this.wmParams.type = 1003;
            this.isApplictionDialog = false;
        }
        DisplayMetrics dm = new DisplayMetrics();
        this.wManager.getDefaultDisplay().getMetrics(dm);
        this.mScreenWidth = dm.widthPixels;
        this.mScreenHeight = dm.heightPixels;
        this.wmParams.format = 1;
        this.wmParams.gravity = 51;
        this.wmParams.flags = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME;
        this.mHintLocation = getSetting(LOCATION_X, this.mDefaultLocation);
        if (defaultY <= 0) {
            defaultY = (this.mScreenHeight / 2) / 3;
        }
        int y = getSetting(LOCATION_Y, defaultY);
        if (this.mHintLocation == 0) {
            this.wmParams.x = 0;
        } else {
            this.wmParams.x = this.mScreenWidth;
        }
        if (y != 0 && y != defaultY) {
            this.wmParams.y = y;
        } else {
            this.wmParams.y = defaultY;
        }
        this.wmParams.alpha = 1.0f;
        this.wmParams.width = -2;
        this.wmParams.height = -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void floatEventDown(MotionEvent event) {
        this.isDraging = false;
        this.mHideTimer.cancel();
        if (this.mHideExpandedTimer != null) {
            this.mHideExpandedTimer.cancel();
        }
        if (this.mGetViewCallback == null) {
            resetLogoViewSize(this.mHintLocation, this.logoView);
        } else {
            this.mGetViewCallback.resetLogoViewSize(this.mHintLocation, this.logoView);
        }
        this.mXInView = event.getX();
        this.mYinview = event.getY();
        this.mXDownInScreen = event.getRawX();
        this.mYDownInScreen = event.getRawY();
        this.mXInScreen = event.getRawX();
        this.mYInScreen = event.getRawY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void floatEventMove(MotionEvent event) {
        if (!this.isExpaned) {
            this.mXInScreen = event.getRawX();
            this.mYInScreen = event.getRawY();
            if (Math.abs(this.mXInScreen - this.mXDownInScreen) > this.logoView.getWidth() / 4 || Math.abs(this.mYInScreen - this.mYDownInScreen) > this.logoView.getWidth() / 4) {
                this.wmParams.x = (int) (this.mXInScreen - this.mXInView);
                this.wmParams.y = ((int) (this.mYInScreen - this.mYinview)) - (this.logoView.getHeight() / 2);
                updateViewPosition();
                double a = this.mScreenWidth / 2;
                float offset = (float) ((a - Math.abs(((double) this.wmParams.x) - a)) / a);
                if (this.mGetViewCallback == null) {
                    dragingLogoViewOffset(this.logoView, this.isDraging, false, offset);
                    return;
                } else {
                    this.mGetViewCallback.dragingLogoViewOffset(this.logoView, this.isDraging, false, offset);
                    return;
                }
            }
            this.isDraging = false;
            if (this.mGetViewCallback == null) {
                dragingLogoViewOffset(this.logoView, false, true, 0.0f);
            } else {
                this.mGetViewCallback.dragingLogoViewOffset(this.logoView, false, true, 0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void floatEventUp() {
        if (this.mXInScreen < this.mScreenWidth / 2) {
            this.mHintLocation = 0;
        } else {
            this.mHintLocation = 1;
        }
        this.valueAnimator = ValueAnimator.ofInt(64);
        this.valueAnimator.setInterpolator(this.mLinearInterpolator);
        this.valueAnimator.setDuration(1000L);
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mar.sdk.privacy.BaseFloatPrivacyManager.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                BaseFloatPrivacyManager.this.mResetLocationValue = ((Integer) animation.getAnimatedValue()).intValue();
                BaseFloatPrivacyManager.this.mHandler.post(BaseFloatPrivacyManager.this.updatePositionRunnable);
            }
        });
        this.valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.mar.sdk.privacy.BaseFloatPrivacyManager.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (Math.abs(BaseFloatPrivacyManager.this.wmParams.x) < 0) {
                    BaseFloatPrivacyManager.this.wmParams.x = 0;
                } else if (Math.abs(BaseFloatPrivacyManager.this.wmParams.x) > BaseFloatPrivacyManager.this.mScreenWidth) {
                    BaseFloatPrivacyManager.this.wmParams.x = BaseFloatPrivacyManager.this.mScreenWidth;
                }
                BaseFloatPrivacyManager.this.updateViewPosition();
                BaseFloatPrivacyManager.this.isDraging = false;
                if (BaseFloatPrivacyManager.this.mGetViewCallback == null) {
                    BaseFloatPrivacyManager.this.dragingLogoViewOffset(BaseFloatPrivacyManager.this.logoView, false, true, 0.0f);
                } else {
                    BaseFloatPrivacyManager.this.mGetViewCallback.dragingLogoViewOffset(BaseFloatPrivacyManager.this.logoView, false, true, 0.0f);
                }
                BaseFloatPrivacyManager.this.mHideTimer.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (Math.abs(BaseFloatPrivacyManager.this.wmParams.x) < 0) {
                    BaseFloatPrivacyManager.this.wmParams.x = 0;
                } else if (Math.abs(BaseFloatPrivacyManager.this.wmParams.x) > BaseFloatPrivacyManager.this.mScreenWidth) {
                    BaseFloatPrivacyManager.this.wmParams.x = BaseFloatPrivacyManager.this.mScreenWidth;
                }
                BaseFloatPrivacyManager.this.updateViewPosition();
                BaseFloatPrivacyManager.this.isDraging = false;
                if (BaseFloatPrivacyManager.this.mGetViewCallback == null) {
                    BaseFloatPrivacyManager.this.dragingLogoViewOffset(BaseFloatPrivacyManager.this.logoView, false, true, 0.0f);
                } else {
                    BaseFloatPrivacyManager.this.mGetViewCallback.dragingLogoViewOffset(BaseFloatPrivacyManager.this.logoView, false, true, 0.0f);
                }
                BaseFloatPrivacyManager.this.mHideTimer.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }
        if (Math.abs(this.mXInScreen - this.mXDownInScreen) > this.logoView.getWidth() / 5 || Math.abs(this.mYInScreen - this.mYDownInScreen) > this.logoView.getHeight() / 5) {
            this.isDraging = false;
        } else {
            openOrCloseMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPosition() {
        if (this.wmParams.x > 0 && this.wmParams.x < this.mScreenWidth) {
            if (this.mHintLocation == 0) {
                this.wmParams.x -= this.mResetLocationValue;
            } else {
                this.wmParams.x += this.mResetLocationValue;
            }
            updateViewPosition();
            double a = this.mScreenWidth / 2;
            float offset = (float) ((a - Math.abs(((double) this.wmParams.x) - a)) / a);
            if (this.mGetViewCallback == null) {
                dragingLogoViewOffset(this.logoView, false, true, 0.0f);
                return;
            } else {
                this.mGetViewCallback.dragingLogoViewOffset(this.logoView, this.isDraging, true, offset);
                return;
            }
        }
        if (Math.abs(this.wmParams.x) < 0) {
            this.wmParams.x = 0;
        } else if (Math.abs(this.wmParams.x) > this.mScreenWidth) {
            this.wmParams.x = this.mScreenWidth;
        }
        if (this.valueAnimator.isRunning()) {
            this.valueAnimator.cancel();
        }
        updateViewPosition();
        this.isDraging = false;
    }

    public void show() {
        try {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.mar.sdk.privacy.BaseFloatPrivacyManager.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BaseFloatPrivacyManager.this.wManager != null && BaseFloatPrivacyManager.this.wmParams != null && BaseFloatPrivacyManager.this.logoView != null) {
                        BaseFloatPrivacyManager.this.wManager.addView(BaseFloatPrivacyManager.this.logoView, BaseFloatPrivacyManager.this.wmParams);
                    }
                    if (BaseFloatPrivacyManager.this.mHideTimer != null) {
                        BaseFloatPrivacyManager.this.mHideTimer.start();
                    } else {
                        BaseFloatPrivacyManager.this.initTimer();
                        BaseFloatPrivacyManager.this.mHideTimer.start();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openOrCloseMenu() {
        if (!this.isDraging) {
            if (!this.isExpaned) {
                try {
                    this.wManager.removeViewImmediate(this.logoView);
                    if (this.mHintLocation == 1) {
                        this.wManager.addView(this.rightView, this.wmParams);
                        if (this.mGetViewCallback == null) {
                            rightViewOpened(this.rightView);
                        } else {
                            this.mGetViewCallback.rightViewOpened(this.rightView);
                        }
                    } else {
                        this.wManager.addView(this.leftView, this.wmParams);
                        if (this.mGetViewCallback == null) {
                            leftViewOpened(this.leftView);
                        } else {
                            this.mGetViewCallback.leftViewOpened(this.leftView);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.isExpaned = true;
                this.mHideTimer.cancel();
                if (this.mHideExpandedTimer != null && this.isExpaned) {
                    this.mHideExpandedTimer.start();
                    return;
                }
                return;
            }
            try {
                this.wManager.removeViewImmediate(this.mHintLocation == 0 ? this.leftView : this.rightView);
                this.wManager.addView(this.logoView, this.wmParams);
                if (this.mGetViewCallback == null) {
                    leftOrRightViewClosed(this.logoView);
                } else {
                    this.mGetViewCallback.leftOrRightViewClosed(this.logoView);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.isExpaned = false;
            this.mHideTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewPosition() {
        this.isDraging = true;
        try {
            if (!this.isExpaned) {
                if (this.wmParams.y - (this.logoView.getHeight() / 2) <= 0) {
                    this.wmParams.y = this.mOffsetToTop;
                    this.isDraging = true;
                } else if (this.wmParams.y + this.logoView.getHeight() >= this.mScreenHeight) {
                    this.wmParams.y = (this.mScreenHeight - this.logoView.getHeight()) - this.mOffsetToBottom;
                    this.isDraging = true;
                }
                this.wManager.updateViewLayout(this.logoView, this.wmParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismiss() {
        saveSetting(LOCATION_X, this.mHintLocation);
        saveSetting(LOCATION_Y, this.wmParams.y);
        this.logoView.clearAnimation();
        try {
            this.mHideTimer.cancel();
            if (this.mHideExpandedTimer != null) {
                this.mHideExpandedTimer.cancel();
            }
            if (this.isExpaned) {
                this.wManager.removeViewImmediate(this.mHintLocation == 0 ? this.leftView : this.rightView);
            } else {
                this.wManager.removeViewImmediate(this.logoView);
            }
            this.isExpaned = false;
            this.isDraging = false;
            if (this.mGetViewCallback == null) {
                onDestoryed();
            } else {
                this.mGetViewCallback.onDestoryed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getSetting(String key, int defaultValue) {
        try {
            SharedPreferences sharedata = this.mActivity.getSharedPreferences("floatLogo", 0);
            return sharedata.getInt(key, defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public void saveSetting(String key, int value) {
        try {
            SharedPreferences.Editor sharedata = this.mActivity.getSharedPreferences("floatLogo", 0).edit();
            sharedata.putInt(key, value);
            sharedata.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int dp2Px(float dp, Context mContext) {
        return (int) TypedValue.applyDimension(1, dp, mContext.getResources().getDisplayMetrics());
    }
}
