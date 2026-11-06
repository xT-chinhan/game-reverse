package android.support.constraint.motion;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.constraint.ConstraintAttribute;
import android.support.constraint.R;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.umeng.analytics.pro.cc;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private boolean mVisibility = false;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap<>();
    }

    @Override // android.support.constraint.motion.Key
    public void load(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.KeyAttribute);
        Loader.read(this, a);
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // android.support.constraint.motion.Key
    public void getAttributeNames(HashSet<String> attributes) {
        if (!Float.isNaN(this.mAlpha)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            attributes.add("rotation");
        }
        if (!Float.isNaN(this.mRotationX)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.mPivotX)) {
            attributes.add("transformPivotX");
        }
        if (!Float.isNaN(this.mPivotY)) {
            attributes.add("transformPivotY");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            attributes.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            attributes.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (this.mCustomConstraints.size() > 0) {
            for (String s : this.mCustomConstraints.keySet()) {
                attributes.add("CUSTOM," + s);
            }
        }
    }

    @Override // android.support.constraint.motion.Key
    public void setInterpolation(HashMap<String, Integer> interpolation) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            interpolation.put("alpha", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            interpolation.put("elevation", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            interpolation.put("rotation", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            interpolation.put("rotationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            interpolation.put("rotationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotX)) {
            interpolation.put("transformPivotX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotY)) {
            interpolation.put("transformPivotY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            interpolation.put("translationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            interpolation.put("translationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            interpolation.put("translationZ", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            interpolation.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            interpolation.put("scaleX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleY)) {
            interpolation.put("scaleY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            interpolation.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            for (String s : this.mCustomConstraints.keySet()) {
                interpolation.put("CUSTOM," + s, Integer.valueOf(this.mCurveFit));
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.support.constraint.motion.Key
    public void addValues(HashMap<String, SplineSet> splines) {
        for (String s : splines.keySet()) {
            SplineSet splineSet = splines.get(s);
            byte b = 1;
            if (s.startsWith("CUSTOM")) {
                String ckey = s.substring("CUSTOM".length() + 1);
                ConstraintAttribute cvalue = this.mCustomConstraints.get(ckey);
                if (cvalue != null) {
                    ((SplineSet.CustomSet) splineSet).setPoint(this.mFramePosition, cvalue);
                }
            } else {
                switch (s.hashCode()) {
                    case -1249320806:
                        b = s.equals("rotationX") ? (byte) 3 : (byte) -1;
                        break;
                    case -1249320805:
                        b = s.equals("rotationY") ? (byte) 4 : (byte) -1;
                        break;
                    case -1225497657:
                        b = s.equals("translationX") ? (byte) 10 : (byte) -1;
                        break;
                    case -1225497656:
                        b = s.equals("translationY") ? (byte) 11 : (byte) -1;
                        break;
                    case -1225497655:
                        b = s.equals("translationZ") ? (byte) 12 : (byte) -1;
                        break;
                    case -1001078227:
                        b = s.equals(NotificationCompat.CATEGORY_PROGRESS) ? cc.k : (byte) -1;
                        break;
                    case -908189618:
                        b = s.equals("scaleX") ? (byte) 8 : (byte) -1;
                        break;
                    case -908189617:
                        b = s.equals("scaleY") ? (byte) 9 : (byte) -1;
                        break;
                    case -760884510:
                        b = s.equals("transformPivotX") ? (byte) 5 : (byte) -1;
                        break;
                    case -760884509:
                        b = s.equals("transformPivotY") ? (byte) 6 : (byte) -1;
                        break;
                    case -40300674:
                        b = s.equals("rotation") ? (byte) 2 : (byte) -1;
                        break;
                    case -4379043:
                        if (!s.equals("elevation")) {
                            b = -1;
                        }
                        break;
                    case 37232917:
                        b = s.equals("transitionPathRotate") ? (byte) 7 : (byte) -1;
                        break;
                    case 92909918:
                        b = s.equals("alpha") ? (byte) 0 : (byte) -1;
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        if (!Float.isNaN(this.mAlpha)) {
                            splineSet.setPoint(this.mFramePosition, this.mAlpha);
                        }
                        break;
                    case 1:
                        if (!Float.isNaN(this.mElevation)) {
                            splineSet.setPoint(this.mFramePosition, this.mElevation);
                        }
                        break;
                    case 2:
                        if (!Float.isNaN(this.mRotation)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotation);
                        }
                        break;
                    case 3:
                        if (!Float.isNaN(this.mRotationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotationX);
                        }
                        break;
                    case 4:
                        if (!Float.isNaN(this.mRotationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotationY);
                        }
                        break;
                    case 5:
                        if (!Float.isNaN(this.mRotationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mPivotX);
                        }
                        break;
                    case 6:
                        if (!Float.isNaN(this.mRotationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mPivotY);
                        }
                        break;
                    case 7:
                        if (!Float.isNaN(this.mTransitionPathRotate)) {
                            splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                        }
                        break;
                    case 8:
                        if (!Float.isNaN(this.mScaleX)) {
                            splineSet.setPoint(this.mFramePosition, this.mScaleX);
                        }
                        break;
                    case 9:
                        if (!Float.isNaN(this.mScaleY)) {
                            splineSet.setPoint(this.mFramePosition, this.mScaleY);
                        }
                        break;
                    case 10:
                        if (!Float.isNaN(this.mTranslationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                        }
                        break;
                    case 11:
                        if (!Float.isNaN(this.mTranslationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                        }
                        break;
                    case 12:
                        if (!Float.isNaN(this.mTranslationZ)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                        }
                        break;
                    case 13:
                        if (!Float.isNaN(this.mProgress)) {
                            splineSet.setPoint(this.mFramePosition, this.mProgress);
                        }
                        break;
                    default:
                        Log.v("KeyAttributes", "UNKNOWN addValues \"" + s + "\"");
                        break;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:56:0x00c3  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.support.constraint.motion.Key
    public void setValue(String tag, Object value) {
        byte b;
        switch (tag.hashCode()) {
            case -1913008125:
                if (!tag.equals("motionProgress")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case -1812823328:
                if (!tag.equals("transitionEasing")) {
                    b = -1;
                } else {
                    b = 11;
                }
                break;
            case -1249320806:
                if (!tag.equals("rotationX")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case -1249320805:
                if (!tag.equals("rotationY")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case -1225497657:
                if (!tag.equals("translationX")) {
                    b = -1;
                } else {
                    b = cc.l;
                }
                break;
            case -1225497656:
                if (!tag.equals("translationY")) {
                    b = -1;
                } else {
                    b = cc.m;
                }
                break;
            case -987906986:
                if (!tag.equals("pivotX")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case -987906985:
                if (!tag.equals("pivotY")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case -908189618:
                if (!tag.equals("scaleX")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case -908189617:
                if (!tag.equals("scaleY")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case -40300674:
                if (!tag.equals("rotation")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case -4379043:
                if (!tag.equals("elevation")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 37232917:
                if (!tag.equals("transitionPathRotate")) {
                    b = -1;
                } else {
                    b = cc.k;
                }
                break;
            case 92909918:
                if (!tag.equals("alpha")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 579057826:
                if (!tag.equals("curveFit")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 1317633238:
                if (!tag.equals("mTranslationZ")) {
                    b = -1;
                } else {
                    b = cc.n;
                }
                break;
            case 1941332754:
                if (!tag.equals("visibility")) {
                    b = -1;
                } else {
                    b = 12;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                this.mAlpha = toFloat(value);
                break;
            case 1:
                this.mCurveFit = toInt(value);
                break;
            case 2:
                this.mElevation = toFloat(value);
                break;
            case 3:
                this.mProgress = toFloat(value);
                break;
            case 4:
                this.mRotation = toFloat(value);
                break;
            case 5:
                this.mRotationX = toFloat(value);
                break;
            case 6:
                this.mRotationY = toFloat(value);
                break;
            case 7:
                this.mPivotX = toFloat(value);
                break;
            case 8:
                this.mPivotY = toFloat(value);
                break;
            case 9:
                this.mScaleX = toFloat(value);
                break;
            case 10:
                this.mScaleY = toFloat(value);
                break;
            case 11:
                this.mTransitionEasing = value.toString();
                break;
            case 12:
                this.mVisibility = toBoolean(value);
                break;
            case 13:
                this.mTransitionPathRotate = toFloat(value);
                break;
            case 14:
                this.mTranslationX = toFloat(value);
                break;
            case 15:
                this.mTranslationY = toFloat(value);
                break;
            case 16:
                this.mTranslationZ = toFloat(value);
                break;
        }
    }

    private static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void read(KeyAttributes c, TypedArray a) {
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                switch (mAttrMap.get(attr)) {
                    case 1:
                        c.mAlpha = a.getFloat(attr, c.mAlpha);
                        break;
                    case 2:
                        c.mElevation = a.getDimension(attr, c.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(attr) + "   " + mAttrMap.get(attr));
                        break;
                    case 4:
                        c.mRotation = a.getFloat(attr, c.mRotation);
                        break;
                    case 5:
                        c.mRotationX = a.getFloat(attr, c.mRotationX);
                        break;
                    case 6:
                        c.mRotationY = a.getFloat(attr, c.mRotationY);
                        break;
                    case 7:
                        c.mScaleX = a.getFloat(attr, c.mScaleX);
                        break;
                    case 8:
                        c.mTransitionPathRotate = a.getFloat(attr, c.mTransitionPathRotate);
                        break;
                    case 9:
                        c.mTransitionEasing = a.getString(attr);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            c.mTargetId = a.getResourceId(attr, c.mTargetId);
                            if (c.mTargetId == -1) {
                                c.mTargetString = a.getString(attr);
                            }
                        } else if (a.peekValue(attr).type == 3) {
                            c.mTargetString = a.getString(attr);
                        } else {
                            c.mTargetId = a.getResourceId(attr, c.mTargetId);
                        }
                        break;
                    case 12:
                        c.mFramePosition = a.getInt(attr, c.mFramePosition);
                        break;
                    case 13:
                        c.mCurveFit = a.getInteger(attr, c.mCurveFit);
                        break;
                    case 14:
                        c.mScaleY = a.getFloat(attr, c.mScaleY);
                        break;
                    case 15:
                        c.mTranslationX = a.getDimension(attr, c.mTranslationX);
                        break;
                    case 16:
                        c.mTranslationY = a.getDimension(attr, c.mTranslationY);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            c.mTranslationZ = a.getDimension(attr, c.mTranslationZ);
                        }
                        break;
                    case 18:
                        c.mProgress = a.getFloat(attr, c.mProgress);
                        break;
                    case 19:
                        c.mPivotX = a.getDimension(attr, c.mPivotX);
                        break;
                    case 20:
                        c.mPivotY = a.getDimension(attr, c.mPivotY);
                        break;
                }
            }
        }
    }
}
