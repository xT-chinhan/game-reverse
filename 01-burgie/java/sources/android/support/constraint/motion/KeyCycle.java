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
import android.util.TypedValue;
import com.umeng.analytics.pro.cc;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    private static final String TAG = "KeyCycle";
    private String mTransitionEasing = null;
    private int mCurveFit = 0;
    private int mWaveShape = -1;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mProgress = Float.NaN;
    private int mWaveVariesBy = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    @Override // android.support.constraint.motion.Key
    public void load(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.KeyCycle);
        Loader.read(this, a);
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
        if (!Float.isNaN(this.mScaleX)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            attributes.add("transitionPathRotate");
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
        if (this.mCustomConstraints.size() > 0) {
            for (String s : this.mCustomConstraints.keySet()) {
                attributes.add("CUSTOM," + s);
            }
        }
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> oscSet) {
        for (String key : oscSet.keySet()) {
            if (key.startsWith("CUSTOM")) {
                String ckey = key.substring("CUSTOM".length() + 1);
                ConstraintAttribute cvalue = this.mCustomConstraints.get(ckey);
                if (cvalue != null && cvalue.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    oscSet.get(key).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, cvalue.getValueToInterpolate(), cvalue);
                }
            } else {
                float value = getValue(key);
                if (!Float.isNaN(value)) {
                    oscSet.get(key).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, value);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    public float getValue(String key) {
        switch (key) {
            case "alpha":
                return this.mAlpha;
            case "elevation":
                return this.mElevation;
            case "rotation":
                return this.mRotation;
            case "rotationX":
                return this.mRotationX;
            case "rotationY":
                return this.mRotationY;
            case "transitionPathRotate":
                return this.mTransitionPathRotate;
            case "scaleX":
                return this.mScaleX;
            case "scaleY":
                return this.mScaleY;
            case "translationX":
                return this.mTranslationX;
            case "translationY":
                return this.mTranslationY;
            case "translationZ":
                return this.mTranslationZ;
            case "waveOffset":
                return this.mWaveOffset;
            case "progress":
                return this.mProgress;
            default:
                Log.v("KeyCycle", "WARNING! KeyCycle UNKNOWN  " + key);
                return Float.NaN;
        }
    }

    @Override // android.support.constraint.motion.Key
    public void addValues(HashMap<String, SplineSet> splines) {
        Debug.logStack("KeyCycle", "add " + splines.size() + " values", 2);
        for (String s : splines.keySet()) {
            SplineSet splineSet = splines.get(s);
            switch (s) {
                case "alpha":
                    splineSet.setPoint(this.mFramePosition, this.mAlpha);
                    break;
                case "elevation":
                    splineSet.setPoint(this.mFramePosition, this.mElevation);
                    break;
                case "rotation":
                    splineSet.setPoint(this.mFramePosition, this.mRotation);
                    break;
                case "rotationX":
                    splineSet.setPoint(this.mFramePosition, this.mRotationX);
                    break;
                case "rotationY":
                    splineSet.setPoint(this.mFramePosition, this.mRotationY);
                    break;
                case "transitionPathRotate":
                    splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                    break;
                case "scaleX":
                    splineSet.setPoint(this.mFramePosition, this.mScaleX);
                    break;
                case "scaleY":
                    splineSet.setPoint(this.mFramePosition, this.mScaleY);
                    break;
                case "translationX":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                    break;
                case "translationY":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                    break;
                case "translationZ":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                    break;
                case "waveOffset":
                    splineSet.setPoint(this.mFramePosition, this.mWaveOffset);
                    break;
                case "progress":
                    splineSet.setPoint(this.mFramePosition, this.mProgress);
                    break;
                default:
                    Log.v("KeyCycle", "WARNING KeyCycle UNKNOWN  " + s);
                    break;
            }
        }
    }

    private static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyCycle c, TypedArray a) {
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                switch (mAttrMap.get(attr)) {
                    case 1:
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
                    case 2:
                        c.mFramePosition = a.getInt(attr, c.mFramePosition);
                        break;
                    case 3:
                        c.mTransitionEasing = a.getString(attr);
                        break;
                    case 4:
                        c.mCurveFit = a.getInteger(attr, c.mCurveFit);
                        break;
                    case 5:
                        c.mWaveShape = a.getInt(attr, c.mWaveShape);
                        break;
                    case 6:
                        c.mWavePeriod = a.getFloat(attr, c.mWavePeriod);
                        break;
                    case 7:
                        TypedValue type = a.peekValue(attr);
                        if (type.type == 5) {
                            c.mWaveOffset = a.getDimension(attr, c.mWaveOffset);
                        } else {
                            c.mWaveOffset = a.getFloat(attr, c.mWaveOffset);
                        }
                        break;
                    case 8:
                        c.mWaveVariesBy = a.getInt(attr, c.mWaveVariesBy);
                        break;
                    case 9:
                        c.mAlpha = a.getFloat(attr, c.mAlpha);
                        break;
                    case 10:
                        c.mElevation = a.getDimension(attr, c.mElevation);
                        break;
                    case 11:
                        c.mRotation = a.getFloat(attr, c.mRotation);
                        break;
                    case 12:
                        c.mRotationX = a.getFloat(attr, c.mRotationX);
                        break;
                    case 13:
                        c.mRotationY = a.getFloat(attr, c.mRotationY);
                        break;
                    case 14:
                        c.mTransitionPathRotate = a.getFloat(attr, c.mTransitionPathRotate);
                        break;
                    case 15:
                        c.mScaleX = a.getFloat(attr, c.mScaleX);
                        break;
                    case 16:
                        c.mScaleY = a.getFloat(attr, c.mScaleY);
                        break;
                    case 17:
                        c.mTranslationX = a.getDimension(attr, c.mTranslationX);
                        break;
                    case 18:
                        c.mTranslationY = a.getDimension(attr, c.mTranslationY);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT >= 21) {
                            c.mTranslationZ = a.getDimension(attr, c.mTranslationZ);
                        }
                        break;
                    case 20:
                        c.mProgress = a.getFloat(attr, c.mProgress);
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(attr) + "   " + mAttrMap.get(attr));
                        break;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x00b7  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.support.constraint.motion.Key
    public void setValue(String tag, Object value) {
        byte b;
        switch (tag.hashCode()) {
            case -1812823328:
                if (!tag.equals("transitionEasing")) {
                    b = -1;
                } else {
                    b = 9;
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
                    b = 11;
                }
                break;
            case -1225497656:
                if (!tag.equals("translationY")) {
                    b = -1;
                } else {
                    b = 12;
                }
                break;
            case -1001078227:
                if (!tag.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case -908189618:
                if (!tag.equals("scaleX")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case -908189617:
                if (!tag.equals("scaleY")) {
                    b = -1;
                } else {
                    b = 8;
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
                    b = 10;
                }
                break;
            case 92909918:
                if (!tag.equals("alpha")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 156108012:
                if (!tag.equals("waveOffset")) {
                    b = -1;
                } else {
                    b = cc.m;
                }
                break;
            case 184161818:
                if (!tag.equals("wavePeriod")) {
                    b = -1;
                } else {
                    b = cc.l;
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
                    b = cc.k;
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
                this.mScaleX = toFloat(value);
                break;
            case 8:
                this.mScaleY = toFloat(value);
                break;
            case 9:
                this.mTransitionEasing = value.toString();
                break;
            case 10:
                this.mTransitionPathRotate = toFloat(value);
                break;
            case 11:
                this.mTranslationX = toFloat(value);
                break;
            case 12:
                this.mTranslationY = toFloat(value);
                break;
            case 13:
                this.mTranslationZ = toFloat(value);
                break;
            case 14:
                this.mWavePeriod = toFloat(value);
                break;
            case 15:
                this.mWaveOffset = toFloat(value);
                break;
        }
    }
}
