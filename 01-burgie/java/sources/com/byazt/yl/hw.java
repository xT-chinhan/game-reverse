package com.byazt.yl;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.byazt.ca.x;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.tapsdk.tapad.internal.runtime.mediation.AdapterEnvelope;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 687, 13})
public class hw {
    public float[] hn;
    public volatile SensorEventListener hw;
    public int pr = AdapterEnvelope.MAX_TRACE_FRAMES;
    public float[] x;

    public void pr(boolean z, boolean z2, boolean z3, final of ofVar) {
        if ((z || z2 || z3) && this.hw == null) {
            this.hn = new float[9];
            this.x = new float[3];
            this.hw = new SensorEventListener() { // from class: com.byazt.yl.hw.1
                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    hw.this.pr(sensorEvent, ofVar);
                }

                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i) {
                }
            };
            x xVarPr = x.pr(a.getContext());
            if (z) {
                xVarPr.pr(this.hw, xVarPr.pr(10), this.pr);
            }
            if (z2) {
                xVarPr.pr(this.hw, xVarPr.pr(4), this.pr);
            }
            if (z3) {
                xVarPr.pr(this.hw, xVarPr.pr(15), this.pr);
            }
        }
    }

    public void pr() {
        if (this.hw != null) {
            x.pr(a.getContext()).pr(this.hw);
            this.hw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(SensorEvent sensorEvent, of ofVar) {
        switch (sensorEvent.sensor.getType()) {
            case 4:
                pr(2002, sensorEvent, ofVar);
                break;
            case 10:
                pr(2001, sensorEvent, ofVar);
                break;
            case 15:
                hw(sensorEvent, ofVar);
                break;
        }
    }

    private void hw(SensorEvent sensorEvent, of ofVar) {
        if (sensorEvent == null || this.hn == null || this.x == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        SensorManager.getRotationMatrixFromVector(this.hn, sensorEvent.values);
        SensorManager.getOrientation(this.hn, this.x);
        float degrees = (float) Math.toDegrees(this.x[0]);
        float degrees2 = (float) Math.toDegrees(this.x[1]);
        float degrees3 = (float) Math.toDegrees(this.x[2]);
        float f = (degrees + 360.0f) % 360.0f;
        float fMax = Math.max(-90.0f, Math.min(90.0f, degrees2));
        float f2 = (degrees3 + 360.0f) % 360.0f;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pitch", Math.round(((double) fMax) * 100.0d) / 100.0d);
            jSONObject.put("roll", Math.round(((double) f2) * 100.0d) / 100.0d);
            jSONObject.put("yaw", Math.round(((double) f) * 100.0d) / 100.0d);
            jSONObject.put("ts", System.currentTimeMillis());
            if (ofVar != null) {
                jSONObject.putOpt("material", pr(ofVar));
            }
        } catch (Exception e) {
        }
        pr.pr(2, 2003, jSONObject.toString(), ofVar);
    }

    private void pr(int i, SensorEvent sensorEvent, of ofVar) {
        if (sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", Math.round(((double) sensorEvent.values[0]) * 100.0d) / 100.0d);
            jSONObject.put("y", Math.round(((double) sensorEvent.values[1]) * 100.0d) / 100.0d);
            jSONObject.put(an.aD, Math.round(((double) sensorEvent.values[2]) * 100.0d) / 100.0d);
            jSONObject.put("ts", System.currentTimeMillis());
            if (ofVar != null) {
                jSONObject.putOpt("material", pr(ofVar));
            }
        } catch (Exception e) {
        }
        pr.pr(2, i, jSONObject.toString(), ofVar);
    }

    public JSONObject pr(of ofVar) {
        if (ofVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("aid", ofVar.x());
                jSONObject.putOpt("cid", ofVar.fo());
                jSONObject.putOpt("req_id", ofVar.ny());
                return jSONObject;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
