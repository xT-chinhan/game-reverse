package ms.bz.bd.c.Pgl;

import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: classes3.dex */
public final class pbli implements DisplayManager.DisplayListener {
    private DisplayManager n;

    public pbli(DisplayManager displayManager) {
        this.n = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
        try {
            Display[] displays = this.n.getDisplays();
            int length = displays.length;
            if (length > 0) {
                f1 f1VarN = f1.n();
                f1VarN.getClass();
                String strN = f1.n(displays);
                String strQg = f1.qg(displays);
                f1VarN.n(length);
                if (!TextUtils.isEmpty(strN)) {
                    f1VarN.n(strN);
                }
                if (!TextUtils.isEmpty(strQg)) {
                    f1VarN.qg(strQg);
                }
                f1VarN.n(System.currentTimeMillis() / 1000);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
        try {
            Display[] displays = this.n.getDisplays();
            int length = displays.length;
            if (length > 0) {
                f1 f1VarN = f1.n();
                f1VarN.getClass();
                String strN = f1.n(displays);
                String strQg = f1.qg(displays);
                f1VarN.n(length);
                if (!TextUtils.isEmpty(strN)) {
                    f1VarN.n(strN);
                }
                if (!TextUtils.isEmpty(strQg)) {
                    f1VarN.qg(strQg);
                }
                f1VarN.qg(System.currentTimeMillis() / 1000);
            }
        } catch (Exception unused) {
        }
    }
}
