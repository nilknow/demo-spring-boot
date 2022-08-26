package com.nilknow.demospringbooth2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionPropagationDemoService {
    private final LoginUserRepository loginUserRepository;

    public TransactionPropagationDemoService(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void requireNewMethod() throws Exception {
        LoginUserEntity entity = new LoginUserEntity();
        entity.setNickname("user_need_to_rollback");
        loginUserRepository.save(entity);
        throw new Exception();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void requireNewEmptyMethod() throws Exception {
        throw new Exception();
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nestedMethod() {
        return;
    }
}
