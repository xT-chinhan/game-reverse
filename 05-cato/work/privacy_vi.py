import re, sys
p=sys.argv[1]
s=open(p,encoding='utf-8').read()
def dec(m): return m.encode().decode('unicode_escape')
T={
 "用户条款与隐私":"Điều khoản & Quyền riêng tư",
 "不同意并退出":"Không đồng ý, thoát",
 "同意并继续":"Đồng ý và tiếp tục",
 "欢迎使用本游戏，在使用本游戏前，请您充分阅读并理解":"Chào mừng bạn đến với trò chơi! Trước khi chơi, vui lòng đọc kỹ và hiểu rõ ",
 "《用户协议》":"“Thỏa thuận người dùng”",
 "和":" và ",
 "《隐私政策》":"“Chính sách quyền riêng tư”",
}
LONG=("để nắm được cách chúng tôi xử lý thông tin cá nhân và mục đích xin quyền truy cập. "
 "Xin đặc biệt lưu ý các điều khoản về miễn trừ trách nhiệm, giới hạn quyền của bạn, cách giải quyết tranh chấp và thẩm quyền tài phán. "
 "Chúng tôi sẽ tuân thủ nghiêm ngặt pháp luật và chính sách quyền riêng tư để bảo vệ thông tin cá nhân của bạn. "
 "Để đảm bảo trải nghiệm chơi, chúng tôi sẽ xin các quyền cần thiết dưới đây; bạn có thể đồng ý hoặc từ chối, nhưng từ chối có thể khiến bạn không vào được trò chơi. "
 "Ngoài ra, tùy từng tính năng, chúng tôi có thể xin thêm một số quyền không bắt buộc; từ chối có thể làm một phần trải nghiệm không hoạt động bình thường. "
 "Các quyền cần thiết gồm: Quyền thiết bị (bắt buộc): đọc mã định danh thiết bị (AndroidID, MAC) để tạo tài khoản, lưu và khôi phục dữ liệu chơi, phát hiện bất thường và bảo đảm an toàn mạng, vận hành. "
 "Quyền bộ nhớ (bắt buộc): truy cập bộ nhớ để tải xuống và lưu nội dung, lưu và tải ảnh lên, đọc ghi cài đặt cá nhân, tạo tệp hệ thống và nhật ký.")
n=0
def rep(m):
    global n
    raw=m.group(2); txt=dec(raw)
    if txt in T: new=T[txt]
    elif txt.startswith("各条款"): new=LONG
    else: return m.group(0)
    n+=1
    new=new.replace('\\','\\\\').replace('"','\\"')
    return f'{m.group(1)}"{new}"'
s=re.sub(r'(const-string(?:/jumbo)? v\d+, )"((?:[^"\\]|\\.)*)"', rep, s)
open(p,'w',encoding='utf-8').write(s); print('replaced',n)
