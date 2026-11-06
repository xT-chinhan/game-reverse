package com.byazt.kld;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.anythink.core.common.d.i;
import com.byazt.af.x;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.pnm.w;
import com.byazt.tk.q;
import com.qq.e.comm.constants.ErrorCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1772, 26})
public class qg {
    public int n = i.w.y;
    public float[] q;
    public volatile SensorEventListener qg;
    public float[] s;

    public void n(boolean z, boolean z2, boolean z3, final pk pkVar) {
        w wVarXk = rv.qg().xk();
        if (wVarXk != null) {
            this.n = wVarXk.s();
        }
        if ((z || z2 || z3) && this.qg == null) {
            this.s = new float[9];
            this.q = new float[3];
            this.qg = new SensorEventListener() { // from class: com.byazt.kld.qg.1
                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i) {
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    qg.this.n(sensorEvent, pkVar);
                }
            };
            q qVarN = q.n(rv.getContext());
            if (z) {
                qVarN.n(this.qg, qVarN.n(10), this.n);
            }
            if (z2) {
                qVarN.n(this.qg, qVarN.n(4), this.n);
            }
            if (z3) {
                qVarN.n(this.qg, qVarN.n(15), this.n);
            }
        }
    }

    public void n() {
        if (this.qg != null) {
            q.n(rv.getContext()).n(this.qg);
            this.qg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(SensorEvent sensorEvent, pk pkVar) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            n(2002, sensorEvent, pkVar);
        } else if (type == 10) {
            n(2001, sensorEvent, pkVar);
        } else {
            if (type != 15) {
                return;
            }
            qg(sensorEvent, pkVar);
        }
    }

    private void qg(SensorEvent sensorEvent, pk pkVar) {
        if (sensorEvent == null || this.s == null || this.q == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        SensorManager.getRotationMatrixFromVector(this.s, sensorEvent.values);
        SensorManager.getOrientation(this.s, this.q);
        float degrees = (float) Math.toDegrees(this.q[0]);
        float degrees2 = (float) Math.toDegrees(this.q[1]);
        float degrees3 = (float) Math.toDegrees(this.q[2]);
        float f = (degrees + 360.0f) % 360.0f;
        float fMax = Math.max(-90.0f, Math.min(90.0f, degrees2));
        float f2 = (degrees3 + 360.0f) % 360.0f;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pitch", Math.round(((double) fMax) * 100.0d) / 100.0d);
            jSONObject.put("roll", Math.round(((double) f2) * 100.0d) / 100.0d);
            jSONObject.put("yaw", Math.round(((double) f) * 100.0d) / 100.0d);
            jSONObject.put("ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        n.n(2, ErrorCode.NOT_INIT, jSONObject.toString(), pkVar);
    }

    private void n(int i, SensorEvent sensorEvent, pk pkVar) {
        if (sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(x.n, Math.round(((double) sensorEvent.values[0]) * 100.0d) / 100.0d);
            jSONObject.put("y", Math.round(((double) sensorEvent.values[1]) * 100.0d) / 100.0d);
            jSONObject.put("z", Math.round(((double) sensorEvent.values[2]) * 100.0d) / 100.0d);
            jSONObject.put("ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        n.n(2, i, jSONObject.toString(), pkVar);
    }
}
