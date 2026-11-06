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
    private static volatile e1 pr;
    private int hn;
    private SensorManager hw;
    private int x = 0;
    private float[] c = new float[3];
    private ArrayList uc = new ArrayList();

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e028bb", new byte[]{36, 124, 17}));
        pr = null;
    }

    private e1(Context context) {
        this.hw = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.hw = (SensorManager) applicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dd66ec", new byte[]{102, 99, 75, 81, 85, 102}));
        }
    }

    private synchronized void c() {
        try {
            SensorManager sensorManager = this.hw;
            if (sensorManager != null) {
                int i = this.hn - 1;
                this.hn = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception e) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b777b0", new byte[]{96, 38, 71, 124, 72});
        }
    }

    public static e1 pr(Context context) {
        if (pr == null) {
            synchronized (e1.class) {
                if (pr == null) {
                    pr = new e1(context);
                }
            }
        }
        return pr;
    }

    private synchronized void x() {
        try {
            SensorManager sensorManager = this.hw;
            if (sensorManager != null) {
                if (this.hn == 0) {
                    if (!this.hw.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.hn++;
            }
        } catch (Exception e) {
        }
    }

    public final synchronized String hn() {
        StringBuilder sb = new StringBuilder();
        int size = this.uc.size();
        if (size <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = this.uc;
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
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    public final synchronized void hw() {
        JSONArray jSONArrayPr = pr();
        if (jSONArrayPr == null) {
            return;
        }
        this.uc.add(jSONArrayPr);
        try {
            int size = this.uc.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.uc.subList(size - 50, size));
                this.uc.clear();
                this.uc = arrayList;
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.c = sensorEvent.values;
        this.x = 1;
    }

    public final JSONArray pr() {
        byte b;
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        try {
            b = pblc.pr() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable th) {
            b = -1;
        }
        if (b != 1) {
            return null;
        }
        x();
        try {
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.x == 0 && i < 10) {
                        i++;
                        wait(1000L);
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.c[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.c[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.c[2]);
            } catch (Exception e) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "31643e", new byte[]{49, 32, 70, 127, 11});
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.c[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.c[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.c[2]);
            }
            jSONArray.put(bigDecimal.setScale(2, 4));
            c();
            this.x = 0;
            return jSONArray;
        } catch (Throwable th2) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(new BigDecimal(this.c[0]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.c[1]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.c[2]).setScale(2, 4));
            c();
            this.x = 0;
            throw th2;
        }
    }
}
