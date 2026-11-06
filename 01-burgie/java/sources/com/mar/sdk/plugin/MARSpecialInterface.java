package com.mar.sdk.plugin;

import android.app.Activity;
import com.mar.sdk.ISpecialInterface;
import com.mar.sdk.MARSDK;
import com.mar.sdk.SDKParams;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MARSpecialInterface implements ISpecialInterface {
    private static MARSpecialInterface instance;
    private List<ISpecialInterface> plugin = new ArrayList();

    private MARSpecialInterface() {
    }

    public static MARSpecialInterface getInstance() {
        if (instance == null) {
            instance = new MARSpecialInterface();
        }
        return instance;
    }

    public void setSpecialInterface(ISpecialInterface specialInterface) {
        this.plugin.add(specialInterface);
    }

    @Override // com.mar.sdk.ISpecialInterface
    public boolean isFromGameCenter(Activity context) {
        if (this.plugin == null || this.plugin.isEmpty()) {
            return false;
        }
        return this.plugin.get(0).isFromGameCenter(context);
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void showGameCenter(Activity context) {
        if (this.plugin != null && !this.plugin.isEmpty()) {
            for (ISpecialInterface specialInterface : this.plugin) {
                specialInterface.showGameCenter(context);
            }
        }
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void showPostDetail(Activity context, String postId, String extra) {
        if (this.plugin != null && !this.plugin.isEmpty()) {
            for (ISpecialInterface specialInterface : this.plugin) {
                specialInterface.showPostDetail(context, postId, extra);
            }
        }
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void performFeature(Activity context, String type) {
        if (this.plugin != null && !this.plugin.isEmpty()) {
            for (ISpecialInterface specialInterface : this.plugin) {
                specialInterface.performFeature(context, type);
            }
        }
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void callSpecailFunc(final Activity context, final String funcName, final SDKParams params) {
        if (this.plugin != null && !this.plugin.isEmpty()) {
            MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.plugin.MARSpecialInterface.1
                @Override // java.lang.Runnable
                public void run() {
                    for (ISpecialInterface specialInterface : MARSpecialInterface.this.plugin) {
                        specialInterface.callSpecailFunc(context, funcName, params);
                    }
                }
            });
        }
    }

    @Override // com.mar.sdk.ISpecialInterface
    public String getOtherChannel(Activity context) {
        if (this.plugin == null || this.plugin.isEmpty()) {
            return null;
        }
        return this.plugin.get(0).getOtherChannel(context);
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void gotoMoreGame() {
        if (this.plugin != null && !this.plugin.isEmpty()) {
            for (ISpecialInterface specialInterface : this.plugin) {
                specialInterface.gotoMoreGame();
            }
        }
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void openMoment() {
        if (this.plugin != null && !this.plugin.isEmpty()) {
            for (ISpecialInterface specialInterface : this.plugin) {
                specialInterface.openMoment();
            }
        }
    }
}
