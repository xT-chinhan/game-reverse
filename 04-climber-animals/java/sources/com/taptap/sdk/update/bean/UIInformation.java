package com.taptap.sdk.update.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UIInformation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/update/bean/UIInformation;", "", "builder", "Lcom/taptap/sdk/update/bean/UIInformation$Builder;", "(Lcom/taptap/sdk/update/bean/UIInformation$Builder;)V", "appInfo", "", "getAppInfo", "()Ljava/lang/String;", "linkList", "", "Lcom/taptap/sdk/update/bean/UpdateFuncLink;", "getLinkList", "()Ljava/util/List;", "updateTitle", "getUpdateTitle", "Builder", "Companion", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UIInformation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appInfo;
    private final List<UpdateFuncLink> linkList;
    private final String updateTitle;

    public /* synthetic */ UIInformation(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private UIInformation(Builder builder) {
        this.updateTitle = builder.getUpdateTitle();
        this.appInfo = builder.getAppInfo();
        this.linkList = builder.getLinkList();
    }

    public final String getUpdateTitle() {
        return this.updateTitle;
    }

    public final String getAppInfo() {
        return this.appInfo;
    }

    public final List<UpdateFuncLink> getLinkList() {
        return this.linkList;
    }

    /* JADX INFO: compiled from: UIInformation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u000e\u001a\u00020\u00002\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/update/bean/UIInformation$Builder;", "", "()V", "appInfo", "", "getAppInfo", "()Ljava/lang/String;", "setAppInfo", "(Ljava/lang/String;)V", "linkList", "", "Lcom/taptap/sdk/update/bean/UpdateFuncLink;", "getLinkList", "()Ljava/util/List;", "setLinkList", "(Ljava/util/List;)V", "updateTitle", "getUpdateTitle$tap_update_release", "setUpdateTitle$tap_update_release", "build", "Lcom/taptap/sdk/update/bean/UIInformation;", "setUpdateTitle", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private String appInfo;
        private List<UpdateFuncLink> linkList;
        private String updateTitle;

        /* JADX INFO: renamed from: getUpdateTitle$tap_update_release, reason: from getter */
        public final String getUpdateTitle() {
            return this.updateTitle;
        }

        public final void setUpdateTitle$tap_update_release(String str) {
            this.updateTitle = str;
        }

        public final String getAppInfo() {
            return this.appInfo;
        }

        /* JADX INFO: renamed from: setAppInfo, reason: collision with other method in class */
        public final void m69setAppInfo(String str) {
            this.appInfo = str;
        }

        public final List<UpdateFuncLink> getLinkList() {
            return this.linkList;
        }

        /* JADX INFO: renamed from: setLinkList, reason: collision with other method in class */
        public final void m70setLinkList(List<UpdateFuncLink> list) {
            this.linkList = list;
        }

        public final Builder setUpdateTitle(String updateTitle) {
            this.updateTitle = updateTitle;
            return this;
        }

        public final Builder setAppInfo(String appInfo) {
            this.appInfo = appInfo;
            return this;
        }

        public final Builder setLinkList(List<UpdateFuncLink> linkList) {
            this.linkList = linkList;
            return this;
        }

        public final UIInformation build() {
            return new UIInformation(this, null);
        }
    }

    /* JADX INFO: compiled from: UIInformation.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/update/bean/UIInformation$Companion;", "", "()V", "newBuilder", "Lcom/taptap/sdk/update/bean/UIInformation$Builder;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Builder newBuilder() {
            return new Builder();
        }
    }
}
