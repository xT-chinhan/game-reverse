# game-reverse

Reverse engineering 5 game Android (TapTap) bằng REA / jadx / apktool / UnityPy / Il2Cpp metadata.

| Thư mục | Game |
|---|---|
| `01-burgie` | Burgie (nấu ăn) |
| `02-yuzu-house` | Yuzu House (pet/avatar) |
| `03-satisgame` | Satisgame (mini-game) |
| `04-climber-animals` | Climber Animals |
| `05-cato` | CATO — Việt hóa toàn bộ + bỏ đăng nhập (xem `05-cato/VIETHOA.md`) |
| `_tools` | công cụ dùng chung (I2 Localization, vá so, dump, chạy Waydroid) |

- APK CATO tiếng Việt: xem mục **Releases**.
- Các file >100MB (bundle, `libil2cpp.so` của 03/04, APK) không đưa vào repo — danh sách trong `.gitignore`.
- `waydroid-run.sh`, `_tools/w.sh`, `_tools/shot.sh` đọc mật khẩu sudo từ biến `PW`.
