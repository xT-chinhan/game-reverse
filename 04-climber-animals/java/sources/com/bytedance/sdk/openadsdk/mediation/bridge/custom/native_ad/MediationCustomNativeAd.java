package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import com.bytedance.sdk.openadsdk.mediation.ms.ms;
import com.bytedance.sdk.openadsdk.mediation.ms.xr;
import com.bytedance.sdk.openadsdk.mediation.xr.ms.ch;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MediationCustomNativeAd extends ms implements Bridge, IMediationCustomNativeAd {
    private int ab;
    private String ah;
    private boolean ao;
    private String c;
    private String ch;
    private String d;
    private int h;
    private int hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private double f3979ms;
    private MediationCustomNativeDislikeDialog nw;
    private String ny;
    private int qv;
    private int sl;
    private Function t;
    private List<String> u;
    private String ub;
    private int x;
    private Map<String, Object> xr;
    private MediationNativeAdAppInfo y;
    private double zb;

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return null;
    }

    public View getVideoView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d) {
        this.f3979ms = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.xr = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.ah = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.ka = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.c = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i) {
        this.ab = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i) {
        this.x = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.ny = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.ch = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i) {
        this.hi = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i) {
        this.sl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d) {
        this.zb = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.u = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.ub = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z) {
        this.ao = z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i) {
        this.h = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i) {
        this.qv = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.y = mediationNativeAdAppInfo;
    }

    public ValueSet getValueSet() {
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8016, this.f3979ms);
        mediationValueSetBuilderCreate.add(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, this.xr);
        mediationValueSetBuilderCreate.add(8045, this.ah);
        mediationValueSetBuilderCreate.add(8046, this.d);
        mediationValueSetBuilderCreate.add(8048, this.ka);
        mediationValueSetBuilderCreate.add(8050, this.c);
        mediationValueSetBuilderCreate.add(8051, this.x);
        mediationValueSetBuilderCreate.add(8052, this.ab);
        mediationValueSetBuilderCreate.add(8061, this.ny);
        mediationValueSetBuilderCreate.add(8054, this.ch);
        mediationValueSetBuilderCreate.add(8420, this.hi);
        mediationValueSetBuilderCreate.add(8421, this.sl);
        mediationValueSetBuilderCreate.add(8082, this.zb);
        mediationValueSetBuilderCreate.add(8053, this.u);
        mediationValueSetBuilderCreate.add(8049, this.ub);
        mediationValueSetBuilderCreate.add(8033, this.ao);
        mediationValueSetBuilderCreate.add(8060, this.h);
        mediationValueSetBuilderCreate.add(8059, this.qv);
        if (this.y != null) {
            mediationValueSetBuilderCreate.add(8315, new MediationNativeAppInfoImpl(this.y));
        }
        return mediationValueSetBuilderCreate.build();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8226);
            sparseArray.put(-99999985, Integer.class);
            Integer num = (Integer) this.t.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8160);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.t.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdClick() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8130);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8113);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f, float f2) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8133);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8040, Float.valueOf(f));
            sparseArray.put(8041, Float.valueOf(f2));
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i, String str) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8134);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8042, view);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8145);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8146);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8150);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8118);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i, String str) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8117);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j, long j2) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8154);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8072, Long.valueOf(j));
            sparseArray.put(8073, Long.valueOf(j2));
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8152);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j, long j2) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8187);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j, long j2, String str, String str2) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8158);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8157);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j, String str, String str2) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8155);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8156);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8185);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8184);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i, String str) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8132);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8038, Integer.valueOf(i));
            sparseArray.put(8039, str);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 6085);
            sparseArray.put(-99999985, Void.class);
            this.t.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8110);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.t.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isServerBidding() {
        if (this.t != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8136);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.t.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return getValueSet();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i == 8127) {
            this.t = xr.ms(valueSet.objectValue(8034, Bridge.class));
        } else if (i == 6083) {
            render();
        } else {
            if (i == 6081) {
                return (T) getExpressView();
            }
            if (i == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder(xr.ms((Bridge) valueSet.objectValue(8071, Bridge.class))));
            } else {
                if (i == 8135) {
                    return (T) Boolean.valueOf(hasDislike());
                }
                if (i == 8149) {
                    onPause();
                } else if (i == 8148) {
                    onResume();
                } else if (i == 8109) {
                    onDestroy();
                } else {
                    if (i == 8121) {
                        return (T) isReadyCondition();
                    }
                    if (i == 8194) {
                        String strStringValue = valueSet.stringValue(8036);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.nw;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(strStringValue, map);
                        }
                    } else if (i == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.nw;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new ch(dislikeDialog);
                        }
                    } else {
                        if (i == 8320) {
                            return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                        }
                        if (i == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i == 8225) {
                            MediationApiLog.i(MediationConstant.TAG, "MediationCustomNativeAd receiveBidResult");
                            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
                        } else if (i == 6164) {
                            return (T) getVideoView();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i == 8127) {
            this.t = xr.ms(objectValue(sparseArray.get(8034), Object.class, null));
        } else if (i == 6083) {
            render();
        } else {
            if (i == 6081) {
                return (T) getExpressView();
            }
            if (i == 8159) {
                registerView((Activity) objectValue(sparseArray.get(20033), Activity.class, null), (ViewGroup) objectValue(sparseArray.get(8067), ViewGroup.class, null), (List) objectValue(sparseArray.get(8068), List.class, null), (List) objectValue(sparseArray.get(8069), List.class, null), (List) objectValue(sparseArray.get(8070), List.class, null), BridgeUtil.buildViewBinder(xr.ms(objectValue(sparseArray.get(8071), Object.class, null))));
            } else {
                if (i == 8135) {
                    return (T) Boolean.valueOf(hasDislike());
                }
                if (i == 8149) {
                    onPause();
                } else if (i == 8148) {
                    onResume();
                } else if (i == 8109) {
                    onDestroy();
                } else {
                    if (i == 8121) {
                        return (T) isReadyCondition();
                    }
                    if (i == 8194) {
                        String str = (String) objectValue(sparseArray.get(8036), String.class, null);
                        Map<String, Object> map = (Map) objectValue(sparseArray.get(8075), Map.class, null);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.nw;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(str, map);
                        }
                    } else if (i == 6072) {
                        Activity activity = (Activity) objectValue(sparseArray.get(20033), Activity.class, null);
                        Map<String, Object> map2 = (Map) objectValue(sparseArray.get(8075), Map.class, null);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.nw;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new ch(dislikeDialog);
                        }
                    } else {
                        if (i == 8320) {
                            return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                        }
                        if (i == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i == 8225) {
                            MediationApiLog.i(MediationConstant.TAG, "MediationCustomNativeAd receiveBidResult");
                            receiveBidResult(((Boolean) objectValue(sparseArray.get(8406), Boolean.class, Boolean.FALSE)).booleanValue(), ((Double) objectValue(sparseArray.get(8407), Double.class, Double.valueOf(0.0d))).doubleValue(), ((Integer) objectValue(sparseArray.get(8408), Integer.class, 0)).intValue(), (Map) objectValue(sparseArray.get(8075), Map.class, null));
                        } else if (i == 6164) {
                            return (T) getVideoView();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms, java.util.function.Supplier
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            SparseArray<Object> sparseArray = valueSetValues.sparseArray();
            appendProto2Params(sparseArray);
            return sparseArray;
        }
        return super.get();
    }
}
