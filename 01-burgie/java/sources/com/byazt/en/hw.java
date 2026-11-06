package com.byazt.en;

import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.rd.hn;
import com.byazt.sd.a;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1242, 13})
public class hw extends com.byazt.rd.pr {
    public Window pr;
    public final String hw = "xgc_prop_bright";
    public final float hn = 255.0f;
    public final int x = -1;

    public hw(Window window) {
        this.pr = window;
        if (hn.pr().c() == -2.0f) {
            hn.pr().pr(c() / 255.0f);
        }
    }

    public int c() {
        return Settings.System.getInt(a.getContext().getContentResolver(), "screen_brightness", 0);
    }

    public void pr(double d) {
        hw(d);
    }

    public float pr(Window window) {
        return window.getAttributes().screenBrightness;
    }

    @Override // com.byazt.rd.pr
    public JSONObject x() {
        return a.hw().xb();
    }

    @Override // com.byazt.rd.pr
    public boolean pr(int i) {
        JSONObject jSONObjectX = x();
        if (jSONObjectX == null) {
            return false;
        }
        hn.pr();
        double dHw = -1.0d;
        if (i == 1) {
            double dOptDouble = jSONObjectX.optDouble(Constants.VALUE_FIELD, 0.0d);
            if (dOptDouble >= 1.0d) {
                dHw = 1.0d;
            } else if (dOptDouble > -1.0d) {
                dHw = dOptDouble;
            }
        } else {
            if (i != 2) {
                return false;
            }
            dHw = hn.pr().hw();
            if (dHw == -2.0d) {
                return false;
            }
        }
        if (dHw == 0.0d) {
            return false;
        }
        if (pr(this.pr) != -1.0f) {
            return true;
        }
        pr(((double) (c() / 255.0f)) + dHw);
        return true;
    }

    @Override // com.byazt.rd.pr
    public void hw(int i) {
        hw(-1.0d);
    }

    private void hw(double d) {
        WindowManager.LayoutParams attributes = this.pr.getAttributes();
        if (attributes != null) {
            if (d != -1.0d) {
                d = Math.max(0.0d, Math.min(d, 1.0d));
                if (d == 0.0d) {
                    d = -1.0d;
                }
            }
            attributes.screenBrightness = (float) d;
            this.pr.setAttributes(attributes);
        }
    }

    @Override // com.byazt.rd.pr
    public boolean hw() {
        return hn.pr().hn();
    }

    @Override // com.byazt.rd.pr
    public boolean hn() {
        if (this.pr == null) {
            return true;
        }
        double dC = hn.pr().c();
        return dC >= 0.95d || dC <= 0.05d;
    }
}
