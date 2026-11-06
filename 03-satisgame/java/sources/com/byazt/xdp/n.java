package com.byazt.xdp;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface n<T extends View> {
    View getCloseButton();

    boolean getSkipOrCloseVisible();

    void n();

    void n(String str, String str2, boolean z);

    void n(boolean z, String str, String str2, boolean z2, boolean z3);

    void qg();

    void s();

    void setDislikeLeft(boolean z);

    void setListener(qg qgVar);

    void setPlayAgainEntranceText(String str);

    void setShowAgain(boolean z);

    void setShowBack(boolean z);

    void setShowDislike(boolean z);

    void setShowSound(boolean z);

    void setSoundMute(boolean z);

    void setVisible(boolean z);
}
