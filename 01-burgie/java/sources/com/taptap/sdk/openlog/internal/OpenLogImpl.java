package com.taptap.sdk.openlog.internal;

import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.openlog.TapTapOpenlogSdk;
import com.taptap.sdk.openlog.model.BusinessLogPayload;
import com.taptap.sdk.openlog.model.TechnicalLogPayload;
import com.taptap.sdk.openlog.utils.SerializeUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: OpenLogImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0016J&\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/openlog/internal/OpenLogImpl;", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "project", "", "version", "(Ljava/lang/String;Ljava/lang/String;)V", "isTechLogDisable", "", "region", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "reportBusinessLog", "", "customProject", "action", Common.Predefined.PROPERTIES, "", "reportTechnicalLog", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OpenLogImpl implements ITapOpenlog {
    private final String project;
    private final String version;

    public OpenLogImpl(String project, String version) {
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(version, "version");
        this.project = project;
        this.version = version;
    }

    @Override // com.taptap.sdk.kit.internal.openlog.ITapOpenlog
    public void reportBusinessLog(String customProject, String action, Map<String, String> properties) {
        Intrinsics.checkNotNullParameter(customProject, "customProject");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(properties, "properties");
        String str = customProject;
        if (str.length() == 0) {
            str = this.project;
        }
        BusinessLogPayload payload = new BusinessLogPayload(action, str, this.version, properties);
        String logContent = SerializeUtils.INSTANCE.stringify(payload.toMap());
        TapLoggerKt.logInfo(logContent);
        TapOpenLogRemote.INSTANCE.sendOpenlog("tapsdk", logContent);
    }

    @Override // com.taptap.sdk.kit.internal.openlog.ITapOpenlog
    public void reportTechnicalLog(String action, Map<String, String> properties) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(properties, "properties");
        if (isTechLogDisable(TapTapOpenlogSdk.INSTANCE.getRegion$tap_core_release(), this.project)) {
            TapLoggerKt.logInfo(AbstractJsonLexerKt.BEGIN_LIST + this.project + "] Technology log is not supported");
        } else {
            TechnicalLogPayload payload = new TechnicalLogPayload(action, this.project, this.version, properties);
            TapOpenLogRemote.INSTANCE.sendOpenlog("tapsdk-apm", SerializeUtils.INSTANCE.stringify(payload.toMap()));
        }
    }

    private final boolean isTechLogDisable(RegionType region, String project) {
        return region == RegionType.CN && !Intrinsics.areEqual(project, SdkModules.PAYMENT);
    }
}
