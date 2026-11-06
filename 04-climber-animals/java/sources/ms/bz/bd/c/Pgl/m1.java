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

/* JADX INFO: loaded from: classes4.dex */
public final class m1 implements SensorEventListener {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile m1 f4838ms;
    private int ah;
    private SensorManager xr;
    private int d = 0;
    private float[] ka = new float[3];
    private ArrayList c = new ArrayList();

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1aa956", new byte[]{112, 45, 66}));
        f4838ms = null;
    }

    private m1(Context context) {
        this.xr = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.xr = (SensorManager) applicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f61e55", new byte[]{100, 49, 76, 2, 5, 48}));
        }
    }

    private synchronized void d() {
        try {
            SensorManager sensorManager = this.xr;
            if (sensorManager != null) {
                if (this.ah == 0) {
                    if (!this.xr.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.ah++;
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void ka() {
        try {
            SensorManager sensorManager = this.xr;
            if (sensorManager != null) {
                int i = this.ah - 1;
                this.ah = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0da4b5", new byte[]{50, 117, 17, 127, 72});
        }
    }

    public static m1 ms(Context context) {
        if (f4838ms == null) {
            synchronized (m1.class) {
                if (f4838ms == null) {
                    f4838ms = new m1(context);
                }
            }
        }
        return f4838ms;
    }

    public final synchronized String ah() {
        StringBuilder sb = new StringBuilder();
        int size = this.c.size();
        if (size <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = this.c;
            int i = size - 50;
            if (i <= 0) {
                i = 0;
            }
            List<JSONArray> listSubList = arrayList.subList(i, size);
            if (listSubList.size() > 0) {
                for (JSONArray jSONArray : listSubList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3926f4", new byte[]{110}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "909460", new byte[]{100}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8d7c8d", new byte[]{53}));
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

    public final JSONArray ms() {
        byte b;
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        try {
            b = pble.ms() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b = -1;
        }
        if (b != 1) {
            return null;
        }
        d();
        try {
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.d == 0 && i < 10) {
                        i++;
                        wait(1000L);
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.ka[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.ka[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.ka[2]);
            } catch (Exception unused2) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f187b7", new byte[]{100, 32, 72, 124, 90});
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.ka[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.ka[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.ka[2]);
            }
            jSONArray.put(bigDecimal.setScale(2, 4));
            ka();
            this.d = 0;
            return jSONArray;
        } catch (Throwable th) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(new BigDecimal(this.ka[0]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.ka[1]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.ka[2]).setScale(2, 4));
            ka();
            this.d = 0;
            throw th;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.ka = sensorEvent.values;
        this.d = 1;
    }

    public final synchronized void xr() {
        JSONArray jSONArrayMs = ms();
        if (jSONArrayMs == null) {
            return;
        }
        this.c.add(jSONArrayMs);
        try {
            int size = this.c.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.c.subList(size - 50, size));
                this.c.clear();
                this.c = arrayList;
            }
        } catch (Throwable unused) {
        }
    }
}
