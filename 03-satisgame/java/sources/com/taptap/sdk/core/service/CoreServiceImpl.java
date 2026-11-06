package com.taptap.sdk.core.service;

import com.taptap.sdk.gid.api.GidService;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.service.CoreService;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.openlog.api.OpenLogService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoreServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/core/service/CoreServiceImpl;", "Lcom/taptap/sdk/kit/internal/service/CoreService;", "gidService", "Lcom/taptap/sdk/gid/api/GidService;", "openLogService", "Lcom/taptap/sdk/openlog/api/OpenLogService;", "(Lcom/taptap/sdk/gid/api/GidService;Lcom/taptap/sdk/openlog/api/OpenLogService;)V", "getGid", "", "obtainOpenlog", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "project", "version", "setGameUserId", "", "userId", "setOpenId", "openId", "setPreferredLanguage", "language", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CoreServiceImpl implements CoreService {
    private final GidService gidService;
    private final OpenLogService openLogService;

    public CoreServiceImpl(GidService gidService, OpenLogService openLogService) {
        Intrinsics.checkNotNullParameter(gidService, "gidService");
        Intrinsics.checkNotNullParameter(openLogService, "openLogService");
        this.gidService = gidService;
        this.openLogService = openLogService;
    }

    @Override // com.taptap.sdk.kit.internal.service.CoreService
    public String getGid() {
        return this.gidService.getGid();
    }

    @Override // com.taptap.sdk.kit.internal.service.CoreService
    public void setPreferredLanguage(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        TapLocalizeUtil.INSTANCE.setPreferredLanguage(language);
    }

    @Override // com.taptap.sdk.kit.internal.service.CoreService
    public void setGameUserId(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        TapIdentifierUtil.INSTANCE.setGameUserId(userId);
    }

    @Override // com.taptap.sdk.kit.internal.service.CoreService
    public void setOpenId(String openId) {
        TapIdentifierUtil.INSTANCE.setOpenId(openId);
        String str = openId;
        if (str == null || str.length() == 0) {
            this.openLogService.logout();
        } else {
            this.openLogService.login(openId);
        }
    }

    @Override // com.taptap.sdk.kit.internal.service.CoreService
    public ITapOpenlog obtainOpenlog(String project, String version) {
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(version, "version");
        return this.openLogService.obtainOpenlog(project, version);
    }
}
