package model;

public class RegisterLogic {
	public boolean execute(User user) {
		//パスワード認証画面設定確認（DBのパスワードを取得、確認）
		if(user.getPass().equals("")) {
			return true;
		}
		return false;
	}
}
