package cn.goodman.business.user.service;

/**
 * Created by china on 2017/3/20.
 */
public interface IFLoginService {
    public void login(String userId, String password);
    public void token(String token, String refreshToken);
}
