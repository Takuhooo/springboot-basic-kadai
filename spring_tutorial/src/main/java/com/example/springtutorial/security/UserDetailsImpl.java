package com.example.springtutorial.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springtutorial.entity.User;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    // ユーザー情報の管理用フィールド
    private final User user;
    // ワイルドカードを使って互換性を確保
    private final Collection<? extends GrantedAuthority> authorities;

    // コンストラクタの型をワイルドカードに変更
    public UserDetailsImpl(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    // ハッシュ化済みのパスワードを返す
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // ログイン時に利用するユーザー名を返す
    @Override
    public String getUsername() {
        // ここは User エンティティの getter 名に合わせること
        // 例: user.getUserName() または user.getUsername() のどちらかを使用
        return user.getUserName();
    }

    // ロールのコレクションを返す
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 必要なら元の User を取得する getter を追加
    public User getUser() {
        return user;
    }
}
