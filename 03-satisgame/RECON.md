# 03 — Satisgame (再玩亿关)  `com.molehole.zaiwanyiguan` v6.10.21

## Engine
**Unity IL2CPP**, metadata **v31 KHÔNG mã hoá**. arm64-v8a (126MB libil2cpp.so). APK 600MB.
Game tập hợp **hàng trăm mini-game** (chủ đề coin/diamond/money: CoinPage, DiamondPuzzle, CountingMoney, DetectingGoldCoins… mỗi mini-game là 1 `*Page` + `*Controller`).
- Frameworks: **Spine** (spine-csharp/spine-unity, hoạt hình xương 2D), **MessagePack**, **Google Protobuf** (LC.*), **LeanCloud** (Realtime/Storage/LiveQuery = backend online), **TapSDK** (Core/Compliance/Login). Quảng cáo: anythink/bytedance/pangle (gói `com.anythink`, `com.byted*`).

## Dump (REA inspect_il2cpp_metadata)
- 104 assembly, 27.123 type, **185.824 method** (168.845 RVA), 35.407 string literal.
- `evidence.json` (198MB). `out/`: `dump.cs`, `Assembly-CSharp.cs` (8.2MB), `script.json`, `strings.txt`.
- Resolver cache dựng xong → `../_tools/resolve.py`.
- Java (jadx): `java/sources/` (13.138 class — nhiều SDK quảng cáo bytedance/anythink/pangle).

## ⭐ Việt hóa — THUẬN LỢI
Game **đã hỗ trợ sẵn tiếng Việt**: strings có `'Btn_Vietnamese'`, `'Vietnamese (Vietnam)'`, `'vi'`, cùng en/zh-Hans/zh-Hant/ja/ko.
- Có class **`LocalizationComponent`** điều khiển dịch.
- Font: `assets/fonts` + `assets/fonts.manifest` (bundle) → chứa font cho các ngôn ngữ; vì đã có tiếng Việt nên nhiều khả năng đủ dấu.
- Bảng chữ nhiều khả năng trong Addressables/TextAsset bundle; cần mở bằng AssetStudio/UnityPy để lấy/sửa bảng `vi`. Khoá chữ (ví dụ `Btn_Vietnamese`) → tra trong `LocalizationComponent`.

## Sửa nội dung game
- Save: **`SaveSystem`** (`LocalProfileSnapshot`, `LocalProfileReadStatus`) — profile local; đọc `SaveSystem`/`ISaveSystem` để biết định dạng + mã hoá.
- Tiền tệ: rất nhiều controller coin/diamond theo từng mini-game (giá trị client-side) → sửa được qua patch .so tại RVA (script.json) hoặc Frida.
- Thanh toán: `PaymentChannel`/`PaymentPurchase*` + TapSDK → IAP server-side, không bẻ.
- ⚠️ Có **LeanCloud online + TapSDK Compliance** (chống gian lận/thực danh TQ): sửa client có thể bị server từ chối đồng bộ. Việt hóa (chữ/font) thì không ảnh hưởng.

## Trạng thái
Reverse xong, đủ dữ liệu Việt hóa. Chưa sửa gì.
