package com.mar.sdk.plugin;

import android.util.Log;
import com.mar.sdk.IVisitor;
import com.mar.sdk.base.PluginFactory;

/* JADX INFO: loaded from: classes2.dex */
public class MARVisitorLogin {
    private static MARVisitorLogin marVisitorLogin;
    private IVisitor iVisitor;

    private MARVisitorLogin() {
    }

    public static MARVisitorLogin getInstance() {
        if (marVisitorLogin == null) {
            marVisitorLogin = new MARVisitorLogin();
        }
        return marVisitorLogin;
    }

    public void init() {
        this.iVisitor = (IVisitor) PluginFactory.getInstance().initPlugin(9);
    }

    public void visitorLogin() {
        if (this.iVisitor == null) {
            Log.w("MARSDK", "visitorLogin: not support visitor login plugin ");
        } else {
            this.iVisitor.visitorLogin();
        }
    }
}
