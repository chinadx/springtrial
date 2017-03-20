package cn.goodman.business.user.service;

import org.springframework.stereotype.Service;

/**
 * Created by china on 2017/3/20.
 */
@Service
public class ALoginService implements IFLoginService{
    @Override
    public void login(String userId, String password) {
        System.out.println("login from A...");
    }

    @Override
    public void token(String token, String refreshToken) {
        System.out.println("token from A...");
    }
}
