package ms.bz.bd.c.Pgl;

import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: classes3.dex */
public final class pbli implements DisplayManager.DisplayListener {
    private DisplayManager pr;

    public pbli(DisplayManager displayManager) {
        this.pr = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
        try {
            Display[] displays = this.pr.getDisplays();
            int length = displays.length;
            if (length > 0) {
                f1 f1VarPr = f1.pr();
                f1VarPr.getClass();
                String strPr = f1.pr(displays);
                String strHw = f1.hw(displays);
                f1VarPr.pr(length);
                if (!TextUtils.isEmpty(strPr)) {
                    f1VarPr.pr(strPr);
                }
                if (!TextUtils.isEmpty(strHw)) {
                    f1VarPr.hw(strHw);
                }
                f1VarPr.pr(System.currentTimeMillis() / 1000);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
        try {
            Display[] displays = this.pr.getDisplays();
            int length = displays.length;
            if (length > 0) {
                f1 f1VarPr = f1.pr();
                f1VarPr.getClass();
                String strPr = f1.pr(displays);
                String strHw = f1.hw(displays);
                f1VarPr.pr(length);
                if (!TextUtils.isEmpty(strPr)) {
                    f1VarPr.pr(strPr);
                }
                if (!TextUtils.isEmpty(strHw)) {
                    f1VarPr.hw(strHw);
                }
                f1VarPr.hw(System.currentTimeMillis() / 1000);
            }
        } catch (Exception e) {
        }
    }
}
