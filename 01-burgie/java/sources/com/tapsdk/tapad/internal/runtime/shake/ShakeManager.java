package com.tapsdk.tapad.internal.runtime.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Array;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ShakeManager implements SensorEventListener {
    private static final long ACCEL_WINDOW_MS = 400;
    private static final int MAX_DEGREE_THRESHOLD = 360;
    private static final float MAX_SPEED_THRESHOLD = 1000.0f;
    private static final int MIN_CONTINUOUS = 3;
    private static final int MIN_DEGREE_THRESHOLD = 5;
    private static final float MIN_SPEED_THRESHOLD = 5.0f;
    private static final float ROTATION_REVERSAL_FRACTION = 0.5f;
    private static final long ROTATION_WINDOW_MS = 3000;
    private static final int SHAKE_HISTORY_SIZE = 8;
    private static final float SPEED_AMPLIFY = 10.0f;
    private static final String TAG = "ShakeManager";
    private static final long TRIGGER_COOLDOWN_MS = 3000;
    private static final int TRIGGER_X_DEGREE = 4;
    private static final int TRIGGER_X_SPEED = 1;
    private static final int TRIGGER_Y_DEGREE = 5;
    private static final int TRIGGER_Y_SPEED = 2;
    private static final int TRIGGER_Z_DEGREE = 6;
    private static final int TRIGGER_Z_SPEED = 3;
    private static final long UPDATE_INTERVAL_MS = 50;
    private static final long WARMUP_MS = 500;
    private int mAccelAccuracy;
    private boolean mAccelFirst;
    private boolean mAccelRegistered;
    private Sensor mAccelerometerSensor;
    private long mActivatedAtMs;
    private int mCallbackId;
    private boolean mDegreeAnyEnabled;
    private int mDegreeThresholdX;
    private int mDegreeThresholdY;
    private int mDegreeThresholdZ;
    private boolean mDegreeX;
    private boolean mDegreeY;
    private boolean mDegreeZ;
    private long mLastAccelUpdateMs;
    private final float[] mLastOrientation;
    private long mLastTriggerMs;
    private float mLastX;
    private float mLastY;
    private float mLastZ;
    private final float[] mOrientation;
    private int mRotationAccuracy;
    private final int[] mRotationDirection;
    private boolean mRotationFirst;
    private final float[] mRotationMatrix;
    private final float[] mRotationMax;
    private final float[] mRotationMin;
    private final float[] mRotationPosition;
    private boolean mRotationRegistered;
    private long mRotationStartMs;
    private Sensor mRotationVectorSensor;
    private SensorManager mSensorManager;
    private final float[][] mShakeHistory;
    private int mShakeHistoryLength;
    private final long[] mShakeHistoryStartMs;
    private boolean mSpeedAnyEnabled;
    private float mSpeedThresholdX;
    private float mSpeedThresholdY;
    private float mSpeedThresholdZ;
    private boolean mSpeedX;
    private boolean mSpeedY;
    private boolean mSpeedZ;
    private boolean mStarted;

    public ShakeManager(Context context) {
        this.mAccelRegistered = false;
        this.mRotationRegistered = false;
        this.mStarted = false;
        this.mSpeedAnyEnabled = false;
        this.mDegreeAnyEnabled = false;
        this.mCallbackId = -1;
        this.mAccelFirst = true;
        this.mShakeHistory = (float[][]) Array.newInstance((Class<?>) float.class, 3, 8);
        this.mShakeHistoryStartMs = new long[8];
        this.mRotationFirst = true;
        this.mLastOrientation = new float[3];
        this.mRotationPosition = new float[3];
        this.mRotationMin = new float[3];
        this.mRotationMax = new float[3];
        this.mRotationDirection = new int[3];
        this.mRotationMatrix = new float[16];
        this.mOrientation = new float[3];
        this.mLastTriggerMs = -1L;
        this.mActivatedAtMs = -1L;
        this.mAccelAccuracy = 2;
        this.mRotationAccuracy = 2;
        if (AndroidPrivacyPolicy.allowsSensor()) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(an.ac);
            this.mSensorManager = sensorManager;
            if (sensorManager != null) {
                this.mAccelerometerSensor = sensorManager.getDefaultSensor(1);
                this.mRotationVectorSensor = this.mSensorManager.getDefaultSensor(11);
            }
        }
    }

    private void beginWarmup(long j) {
        if (this.mActivatedAtMs < 0) {
            this.mActivatedAtMs = j;
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private boolean hasAccelReversal(int i, float f, long j) {
        int i2 = this.mShakeHistoryLength;
        if (i2 < 3) {
            return false;
        }
        float[] fArr = this.mShakeHistory[i];
        float f2 = fArr[i2 - 1];
        if (Math.abs(f2) <= f) {
            return false;
        }
        int i3 = this.mShakeHistoryLength - 3;
        while (true) {
            int i4 = this.mShakeHistoryLength;
            if (i3 >= i4) {
                for (int i5 = i4 - 2; i5 >= 0 && j - this.mShakeHistoryStartMs[i5] <= ACCEL_WINDOW_MS; i5--) {
                    if ((f2 > 0.0f && fArr[i5] < (-f)) || (f2 < 0.0f && fArr[i5] > f)) {
                        return true;
                    }
                }
                return false;
            }
            if (j - this.mShakeHistoryStartMs[i3] > ACCEL_WINDOW_MS || Math.abs(fArr[i3]) <= ROTATION_REVERSAL_FRACTION * f) {
                return false;
            }
            i3++;
        }
    }

    private void initRotation(float f, float f2, float f3, long j) {
        float[] fArr = this.mLastOrientation;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        for (int i = 0; i < 3; i++) {
            this.mRotationPosition[i] = 0.0f;
            this.mRotationMin[i] = 0.0f;
            this.mRotationMax[i] = 0.0f;
            this.mRotationDirection[i] = 0;
        }
        this.mRotationStartMs = j;
        this.mRotationFirst = false;
    }

    private boolean isGated(long j) {
        long j2 = this.mLastTriggerMs;
        if (j2 >= 0 && j - j2 < 3000) {
            return true;
        }
        long j3 = this.mActivatedAtMs;
        return j3 >= 0 && j - j3 < WARMUP_MS;
    }

    private static float normalizeDegrees(float f) {
        float f2 = f % 360.0f;
        if (f2 > 180.0f) {
            return f2 - 360.0f;
        }
        return f2 < -180.0f ? f2 + 360.0f : f2;
    }

    private void pushHistory(float f, float f2, float f3, long j) {
        if (this.mShakeHistoryLength == 8) {
            for (float[] fArr : this.mShakeHistory) {
                System.arraycopy(fArr, 1, fArr, 0, 7);
            }
            long[] jArr = this.mShakeHistoryStartMs;
            System.arraycopy(jArr, 1, jArr, 0, 7);
            this.mShakeHistoryLength--;
        }
        float[][] fArr2 = this.mShakeHistory;
        float[] fArr3 = fArr2[0];
        int i = this.mShakeHistoryLength;
        fArr3[i] = f;
        fArr2[1][i] = f2;
        fArr2[2][i] = f3;
        long[] jArr2 = this.mShakeHistoryStartMs;
        this.mShakeHistoryLength = i + 1;
        jArr2[i] = j;
    }

    private void recordTrigger(long j) {
        this.mLastTriggerMs = j;
        this.mAccelFirst = true;
        this.mShakeHistoryLength = 0;
        this.mRotationFirst = true;
        this.mRotationStartMs = 0L;
    }

    private void resetDetector() {
        this.mAccelFirst = true;
        this.mShakeHistoryLength = 0;
        this.mRotationFirst = true;
        this.mRotationStartMs = 0L;
        this.mLastTriggerMs = -1L;
        this.mActivatedAtMs = -1L;
    }

    private boolean updateRotation(int i, float f, int i2) {
        float[] fArr = this.mRotationPosition;
        fArr[i] = fArr[i] + normalizeDegrees(f - this.mLastOrientation[i]);
        this.mLastOrientation[i] = f;
        float f2 = this.mRotationPosition[i];
        float[] fArr2 = this.mRotationMin;
        fArr2[i] = Math.min(fArr2[i], f2);
        float[] fArr3 = this.mRotationMax;
        fArr3[i] = Math.max(fArr3[i], f2);
        int[] iArr = this.mRotationDirection;
        int i3 = iArr[i];
        if (i3 != 0) {
            return (i3 > 0 ? this.mRotationMax[i] - f2 : f2 - this.mRotationMin[i]) > ((float) i2) * ROTATION_REVERSAL_FRACTION;
        }
        float f3 = i2;
        if (f2 - this.mRotationMin[i] > f3) {
            iArr[i] = 1;
        } else if (this.mRotationMax[i] - f2 > f3) {
            iArr[i] = -1;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:70:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:77:0x00d7  */
    public void configureFromJson(String str, int i) {
        int iOptInt;
        int iOptInt2;
        float f;
        float fOptDouble;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        float fOptDouble2;
        boolean z7;
        boolean z8;
        int iOptInt3 = 45;
        float fOptDouble3 = 250.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            z = jSONObject.optInt("x_speed_enable", 0) == 1;
            try {
                z2 = jSONObject.optInt("y_speed_enable", 0) == 1;
                try {
                    z3 = jSONObject.optInt("z_speed_enable", 0) == 1;
                    try {
                        double d = 250.0f;
                        fOptDouble2 = (float) jSONObject.optDouble("x_speed", d);
                        try {
                            fOptDouble = (float) jSONObject.optDouble("y_speed", d);
                            try {
                                fOptDouble3 = (float) jSONObject.optDouble("z_speed", d);
                                z4 = jSONObject.optInt("x_degree_enable", 0) == 1;
                                try {
                                    z5 = jSONObject.optInt("y_degree_enable", 0) == 1;
                                    try {
                                        z6 = jSONObject.optInt("z_degree_enable", 0) == 1;
                                        try {
                                            iOptInt = jSONObject.optInt("x_degree", 45);
                                            try {
                                                iOptInt2 = jSONObject.optInt("y_degree", 45);
                                                try {
                                                    iOptInt3 = jSONObject.optInt("z_degree", 45);
                                                } catch (Exception e) {
                                                    f = fOptDouble3;
                                                    fOptDouble3 = fOptDouble2;
                                                    fOptDouble2 = fOptDouble3;
                                                    fOptDouble3 = f;
                                                }
                                            } catch (Exception e2) {
                                                iOptInt2 = 45;
                                            }
                                        } catch (Exception e3) {
                                            iOptInt = 45;
                                            iOptInt2 = 45;
                                        }
                                    } catch (Exception e4) {
                                        iOptInt = 45;
                                        iOptInt2 = 45;
                                        f = fOptDouble3;
                                        z6 = false;
                                    }
                                } catch (Exception e5) {
                                    iOptInt = 45;
                                    iOptInt2 = 45;
                                    f = fOptDouble3;
                                    z5 = false;
                                    z6 = z5;
                                    fOptDouble3 = fOptDouble2;
                                    fOptDouble2 = fOptDouble3;
                                    fOptDouble3 = f;
                                    if (z) {
                                        z7 = true;
                                    } else {
                                        z7 = true;
                                    }
                                    this.mSpeedAnyEnabled = z7;
                                    if (z4) {
                                        z8 = true;
                                    } else {
                                        z8 = true;
                                    }
                                    this.mDegreeAnyEnabled = z8;
                                    this.mSpeedX = z;
                                    this.mSpeedY = z2;
                                    this.mSpeedZ = z3;
                                    this.mSpeedThresholdX = clamp(fOptDouble2, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                                    this.mSpeedThresholdY = clamp(fOptDouble, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                                    this.mSpeedThresholdZ = clamp(fOptDouble3, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                                    this.mDegreeX = z4;
                                    this.mDegreeY = z5;
                                    this.mDegreeZ = z6;
                                    this.mDegreeThresholdX = clamp(iOptInt, 5, 360);
                                    this.mDegreeThresholdY = clamp(iOptInt2, 5, 360);
                                    this.mDegreeThresholdZ = clamp(iOptInt3, 5, 360);
                                    this.mCallbackId = i;
                                    resetDetector();
                                }
                            } catch (Exception e6) {
                                iOptInt = 45;
                                iOptInt2 = 45;
                                f = fOptDouble3;
                                z4 = false;
                                z5 = false;
                                z6 = z5;
                                fOptDouble3 = fOptDouble2;
                                fOptDouble2 = fOptDouble3;
                                fOptDouble3 = f;
                                if (z) {
                                    z7 = true;
                                } else {
                                    z7 = true;
                                }
                                this.mSpeedAnyEnabled = z7;
                                if (z4) {
                                    z8 = true;
                                } else {
                                    z8 = true;
                                }
                                this.mDegreeAnyEnabled = z8;
                                this.mSpeedX = z;
                                this.mSpeedY = z2;
                                this.mSpeedZ = z3;
                                this.mSpeedThresholdX = clamp(fOptDouble2, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                                this.mSpeedThresholdY = clamp(fOptDouble, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                                this.mSpeedThresholdZ = clamp(fOptDouble3, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                                this.mDegreeX = z4;
                                this.mDegreeY = z5;
                                this.mDegreeZ = z6;
                                this.mDegreeThresholdX = clamp(iOptInt, 5, 360);
                                this.mDegreeThresholdY = clamp(iOptInt2, 5, 360);
                                this.mDegreeThresholdZ = clamp(iOptInt3, 5, 360);
                                this.mCallbackId = i;
                                resetDetector();
                            }
                        } catch (Exception e7) {
                            iOptInt = 45;
                            iOptInt2 = 45;
                            f = 250.0f;
                            fOptDouble = 250.0f;
                        }
                    } catch (Exception e8) {
                        iOptInt = 45;
                        iOptInt2 = 45;
                        f = 250.0f;
                        fOptDouble = 250.0f;
                        z4 = false;
                        z5 = z4;
                        z6 = z5;
                        fOptDouble2 = fOptDouble3;
                        fOptDouble3 = f;
                        if (z) {
                            z7 = true;
                        } else {
                            z7 = true;
                        }
                        this.mSpeedAnyEnabled = z7;
                        if (z4) {
                            z8 = true;
                        } else {
                            z8 = true;
                        }
                        this.mDegreeAnyEnabled = z8;
                        this.mSpeedX = z;
                        this.mSpeedY = z2;
                        this.mSpeedZ = z3;
                        this.mSpeedThresholdX = clamp(fOptDouble2, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                        this.mSpeedThresholdY = clamp(fOptDouble, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                        this.mSpeedThresholdZ = clamp(fOptDouble3, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                        this.mDegreeX = z4;
                        this.mDegreeY = z5;
                        this.mDegreeZ = z6;
                        this.mDegreeThresholdX = clamp(iOptInt, 5, 360);
                        this.mDegreeThresholdY = clamp(iOptInt2, 5, 360);
                        this.mDegreeThresholdZ = clamp(iOptInt3, 5, 360);
                        this.mCallbackId = i;
                        resetDetector();
                    }
                } catch (Exception e9) {
                    iOptInt = 45;
                    iOptInt2 = 45;
                    f = 250.0f;
                    fOptDouble = 250.0f;
                    z3 = false;
                    z4 = z3;
                    z5 = z4;
                    z6 = z5;
                    fOptDouble2 = fOptDouble3;
                    fOptDouble3 = f;
                    if (z) {
                        z7 = true;
                    } else {
                        z7 = true;
                    }
                    this.mSpeedAnyEnabled = z7;
                    if (z4) {
                        z8 = true;
                    } else {
                        z8 = true;
                    }
                    this.mDegreeAnyEnabled = z8;
                    this.mSpeedX = z;
                    this.mSpeedY = z2;
                    this.mSpeedZ = z3;
                    this.mSpeedThresholdX = clamp(fOptDouble2, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                    this.mSpeedThresholdY = clamp(fOptDouble, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                    this.mSpeedThresholdZ = clamp(fOptDouble3, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                    this.mDegreeX = z4;
                    this.mDegreeY = z5;
                    this.mDegreeZ = z6;
                    this.mDegreeThresholdX = clamp(iOptInt, 5, 360);
                    this.mDegreeThresholdY = clamp(iOptInt2, 5, 360);
                    this.mDegreeThresholdZ = clamp(iOptInt3, 5, 360);
                    this.mCallbackId = i;
                    resetDetector();
                }
            } catch (Exception e10) {
                iOptInt = 45;
                iOptInt2 = 45;
                f = 250.0f;
                fOptDouble = 250.0f;
                z2 = false;
                z3 = z2;
                z4 = z3;
                z5 = z4;
                z6 = z5;
                fOptDouble2 = fOptDouble3;
                fOptDouble3 = f;
                if (z) {
                    z7 = true;
                } else {
                    z7 = true;
                }
                this.mSpeedAnyEnabled = z7;
                if (z4) {
                    z8 = true;
                } else {
                    z8 = true;
                }
                this.mDegreeAnyEnabled = z8;
                this.mSpeedX = z;
                this.mSpeedY = z2;
                this.mSpeedZ = z3;
                this.mSpeedThresholdX = clamp(fOptDouble2, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                this.mSpeedThresholdY = clamp(fOptDouble, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                this.mSpeedThresholdZ = clamp(fOptDouble3, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
                this.mDegreeX = z4;
                this.mDegreeY = z5;
                this.mDegreeZ = z6;
                this.mDegreeThresholdX = clamp(iOptInt, 5, 360);
                this.mDegreeThresholdY = clamp(iOptInt2, 5, 360);
                this.mDegreeThresholdZ = clamp(iOptInt3, 5, 360);
                this.mCallbackId = i;
                resetDetector();
            }
        } catch (Exception e11) {
            iOptInt = 45;
            iOptInt2 = 45;
            f = 250.0f;
            fOptDouble = 250.0f;
            z = false;
            z2 = false;
        }
        if (z || z2 || z3) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.mSpeedAnyEnabled = z7;
        if (z4 || z5 || z6) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.mDegreeAnyEnabled = z8;
        this.mSpeedX = z;
        this.mSpeedY = z2;
        this.mSpeedZ = z3;
        this.mSpeedThresholdX = clamp(fOptDouble2, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
        this.mSpeedThresholdY = clamp(fOptDouble, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
        this.mSpeedThresholdZ = clamp(fOptDouble3, MIN_SPEED_THRESHOLD, MAX_SPEED_THRESHOLD);
        this.mDegreeX = z4;
        this.mDegreeY = z5;
        this.mDegreeZ = z6;
        this.mDegreeThresholdX = clamp(iOptInt, 5, 360);
        this.mDegreeThresholdY = clamp(iOptInt2, 5, 360);
        this.mDegreeThresholdZ = clamp(iOptInt3, 5, 360);
        this.mCallbackId = i;
        resetDetector();
    }

    public boolean hasAccelerometerSensor() {
        return this.mAccelerometerSensor != null;
    }

    public boolean hasRotationVectorSensor() {
        return this.mRotationVectorSensor != null;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public int onAccelSample(float f, float f2, float f3, long j) {
        if (!this.mAccelFirst) {
            long j2 = this.mLastAccelUpdateMs;
            if (j >= j2) {
                long j3 = j - j2;
                if (j3 <= ACCEL_WINDOW_MS) {
                    if (j3 < UPDATE_INTERVAL_MS) {
                        return 0;
                    }
                    pushHistory((f - this.mLastX) * SPEED_AMPLIFY, (f2 - this.mLastY) * SPEED_AMPLIFY, (f3 - this.mLastZ) * SPEED_AMPLIFY, j2);
                    this.mLastAccelUpdateMs = j;
                    this.mLastX = f;
                    this.mLastY = f2;
                    this.mLastZ = f3;
                    if (this.mSpeedZ && hasAccelReversal(2, this.mSpeedThresholdZ, j)) {
                        return 3;
                    }
                    if (this.mSpeedY && hasAccelReversal(1, this.mSpeedThresholdY, j)) {
                        return 2;
                    }
                    return (this.mSpeedX && hasAccelReversal(0, this.mSpeedThresholdX, j)) ? 1 : 0;
                }
            }
        }
        this.mLastX = f;
        this.mLastY = f2;
        this.mLastZ = f3;
        this.mLastAccelUpdateMs = j;
        this.mShakeHistoryLength = 0;
        this.mAccelFirst = false;
        return 0;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        int i2;
        if (sensor == null) {
            return;
        }
        int type = sensor.getType();
        if (type == 1) {
            i2 = this.mAccelAccuracy;
            this.mAccelAccuracy = i;
        } else {
            if (type != 11) {
                return;
            }
            i2 = this.mRotationAccuracy;
            this.mRotationAccuracy = i;
        }
        if (i2 != i) {
            sensor.getName();
            resetDetector();
        }
    }

    public int onOrientationSample(float f, float f2, float f3, long j) {
        if (!this.mRotationFirst) {
            long j2 = this.mRotationStartMs;
            if (j >= j2 && j - j2 <= 3000) {
                boolean zUpdateRotation = updateRotation(0, f, this.mDegreeThresholdX);
                boolean zUpdateRotation2 = updateRotation(1, f2, this.mDegreeThresholdY);
                boolean zUpdateRotation3 = updateRotation(2, f3, this.mDegreeThresholdZ);
                if (this.mDegreeZ && zUpdateRotation3) {
                    return 6;
                }
                if (this.mDegreeY && zUpdateRotation2) {
                    return 5;
                }
                return (this.mDegreeX && zUpdateRotation) ? 4 : 0;
            }
        }
        initRotation(f, f2, f3, j);
        return 0;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!AndroidPrivacyPolicy.allowsSensor()) {
            stop();
            return;
        }
        if (!this.mStarted || sensorEvent == null || sensorEvent.sensor == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        beginWarmup(jCurrentTimeMillis);
        if (isGated(jCurrentTimeMillis)) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        int iOnAccelSample = 0;
        if (type == 1) {
            float[] fArr = sensorEvent.values;
            if (fArr.length >= 3) {
                iOnAccelSample = onAccelSample(fArr[0], fArr[1], fArr[2], jCurrentTimeMillis);
            }
        } else if (type == 11) {
            SensorManager.getRotationMatrixFromVector(this.mRotationMatrix, sensorEvent.values);
            SensorManager.getOrientation(this.mRotationMatrix, this.mOrientation);
            iOnAccelSample = onOrientationSample((float) Math.toDegrees(this.mOrientation[1]), (float) Math.toDegrees(this.mOrientation[2]), (float) Math.toDegrees(this.mOrientation[0]), jCurrentTimeMillis);
        }
        if (iOnAccelSample == 0 || this.mCallbackId < 0) {
            return;
        }
        recordTrigger(jCurrentTimeMillis);
        DirichletRuntime.getInstance().triggerCallbackWithCoords(this.mCallbackId, iOnAccelSample, -1);
    }

    public void release() {
        stop();
    }

    public void reset() {
        resetDetector();
    }

    public boolean start() {
        SensorManager sensorManager;
        Sensor sensor;
        Sensor sensor2;
        boolean zRegisterListener = false;
        if (!AndroidPrivacyPolicy.allowsSensor()) {
            stop();
            return false;
        }
        boolean z = this.mStarted;
        if (z || (sensorManager = this.mSensorManager) == null) {
            return z;
        }
        if (this.mSpeedAnyEnabled && (sensor2 = this.mAccelerometerSensor) != null) {
            zRegisterListener = sensorManager.registerListener(this, sensor2, 1);
            this.mAccelRegistered = zRegisterListener;
        }
        if (this.mDegreeAnyEnabled && (sensor = this.mRotationVectorSensor) != null) {
            boolean zRegisterListener2 = this.mSensorManager.registerListener(this, sensor, 1);
            this.mRotationRegistered = zRegisterListener2;
            zRegisterListener |= zRegisterListener2;
        }
        if (zRegisterListener) {
            resetDetector();
            this.mStarted = true;
        }
        return this.mStarted;
    }

    public void stop() {
        if (this.mStarted) {
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.mAccelRegistered = false;
            this.mRotationRegistered = false;
            this.mStarted = false;
        }
    }

    private static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public ShakeManager() {
        this.mAccelRegistered = false;
        this.mRotationRegistered = false;
        this.mStarted = false;
        this.mSpeedAnyEnabled = false;
        this.mDegreeAnyEnabled = false;
        this.mCallbackId = -1;
        this.mAccelFirst = true;
        this.mShakeHistory = (float[][]) Array.newInstance((Class<?>) float.class, 3, 8);
        this.mShakeHistoryStartMs = new long[8];
        this.mRotationFirst = true;
        this.mLastOrientation = new float[3];
        this.mRotationPosition = new float[3];
        this.mRotationMin = new float[3];
        this.mRotationMax = new float[3];
        this.mRotationDirection = new int[3];
        this.mRotationMatrix = new float[16];
        this.mOrientation = new float[3];
        this.mLastTriggerMs = -1L;
        this.mActivatedAtMs = -1L;
        this.mAccelAccuracy = 2;
        this.mRotationAccuracy = 2;
    }
}
