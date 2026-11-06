package com.anythink.nativead.api;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ATNativePrepareExInfo extends ATNativePrepareInfo {
    private List<View> appInfoClickViewList;
    private List<View> creativeClickViewList;
    private List<View> directDownloadViewList;
    private List<View> permissionClickViewList;
    private List<View> privacyClickViewList;

    public List<View> getCreativeClickViewList() {
        List<View> list = this.creativeClickViewList;
        if (list != null && list.size() > 0 && this.closeView != null) {
            this.creativeClickViewList.remove(this.closeView);
        }
        return this.creativeClickViewList;
    }

    public List<View> getPermissionClickViewList() {
        List<View> list = this.permissionClickViewList;
        if (list != null && list.size() > 0 && this.closeView != null) {
            this.permissionClickViewList.remove(this.closeView);
        }
        return this.permissionClickViewList;
    }

    public void setPermissionClickViewList(List<View> list) {
        this.permissionClickViewList = list;
    }

    public void setCreativeClickViewList(List<View> list) {
        this.creativeClickViewList = list;
    }

    public List<View> getPrivacyClickViewList() {
        List<View> list = this.privacyClickViewList;
        if (list != null && list.size() > 0 && this.closeView != null) {
            this.privacyClickViewList.remove(this.closeView);
        }
        return this.privacyClickViewList;
    }

    public void setPrivacyClickViewList(List<View> list) {
        this.privacyClickViewList = list;
    }

    public List<View> getAppInfoClickViewList() {
        List<View> list = this.appInfoClickViewList;
        if (list != null && list.size() > 0 && this.closeView != null) {
            this.appInfoClickViewList.remove(this.closeView);
        }
        return this.appInfoClickViewList;
    }

    public void setAppInfoClickViewList(List<View> list) {
        this.appInfoClickViewList = list;
    }

    public List<View> getDirectDownloadViewList() {
        List<View> list = this.directDownloadViewList;
        if (list != null && !list.isEmpty() && this.closeView != null) {
            this.directDownloadViewList.remove(this.closeView);
        }
        return this.directDownloadViewList;
    }

    public void setDirectDownloadViewList(List<View> list) {
        this.directDownloadViewList = list;
    }
}
