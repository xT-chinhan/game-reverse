package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 implements SensorEventListener {
    private static volatile e1 n;
    private SensorManager qg;
    private int s;
    private int q = 0;
    private float[] l = new float[3];
    private ArrayList w = new ArrayList();

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e028bb", new byte[]{36, 124, 17}));
        n = null;
    }

    private e1(Context context) {
        this.qg = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.qg = (SensorManager) applicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dd66ec", new byte[]{102, 99, 75, 81, 85, 102}));
        }
    }

    private synchronized void l() {
        try {
            SensorManager sensorManager = this.qg;
            if (sensorManager != null) {
                int i = this.s - 1;
                this.s = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b777b0", new byte[]{96, 38, 71, 124, 72});
        }
    }

    public static e1 n(Context context) {
        if (n == null) {
            synchronized (e1.class) {
                if (n == null) {
                    n = new e1(context);
                }
            }
        }
        return n;
    }

    private synchronized void q() {
        try {
            SensorManager sensorManager = this.qg;
            if (sensorManager != null) {
                if (this.s == 0) {
                    if (!this.qg.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.s++;
            }
        } catch (Exception unused) {
        }
    }

    public final JSONArray n() {
        byte b;
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        try {
            b = pblc.n() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b = -1;
        }
        if (b != 1) {
            return null;
        }
        q();
        try {
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.q == 0 && i < 10) {
                        i++;
                        wait(1000L);
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.l[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.l[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.l[2]);
            } catch (Exception unused2) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "31643e", new byte[]{49, 32, 70, 127, 11});
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.l[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.l[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.l[2]);
            }
            jSONArray.put(bigDecimal.setScale(2, 4));
            l();
            this.q = 0;
            return jSONArray;
        } catch (Throwable th) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(new BigDecimal(this.l[0]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.l[1]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.l[2]).setScale(2, 4));
            l();
            this.q = 0;
            throw th;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.l = sensorEvent.values;
        this.q = 1;
    }

    public final synchronized void qg() {
        JSONArray jSONArrayN = n();
        if (jSONArrayN == null) {
            return;
        }
        this.w.add(jSONArrayN);
        try {
            int size = this.w.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.w.subList(size - 50, size));
                this.w.clear();
                this.w = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized String s() {
        StringBuilder sb = new StringBuilder();
        int size = this.w.size();
        if (size <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = this.w;
            int i = size - 50;
            if (i <= 0) {
                i = 0;
            }
            List<JSONArray> listSubList = arrayList.subList(i, size);
            if (listSubList.size() > 0) {
                for (JSONArray jSONArray : listSubList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "364709", new byte[]{110}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "167965", new byte[]{108}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d16add", new byte[]{105}));
                    }
                }
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
