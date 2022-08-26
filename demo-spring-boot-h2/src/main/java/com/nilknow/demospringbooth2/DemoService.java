package com.nilknow.demospringbooth2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class DemoService {
    private final LoginUserRepository loginUserRepository;
    private final TransactionPropagationDemoService transactionPropagationDemoService;

    public DemoService(LoginUserRepository loginUserRepository, TransactionPropagationDemoService transactionPropagationDemoService) {
        this.loginUserRepository = loginUserRepository;
        this.transactionPropagationDemoService = transactionPropagationDemoService;
    }

    @Transactional
    public void demoMethod() throws Exception {
        LoginUserEntity entity = new LoginUserEntity();
        entity.setNickname("user_need_to_commit");
        loginUserRepository.save(entity);
        transactionPropagationDemoService.requireNewMethod();
    }

    @Transactional
    public void demoEmptyMethod() throws Exception {
        LoginUserEntity entity = new LoginUserEntity();
        entity.setNickname("user_need_to_commit");
        loginUserRepository.save(entity);
        transactionPropagationDemoService.requireNewEmptyMethod();
    }

    public Optional<LoginUserEntity> getLoginUser(String nickname){
        return loginUserRepository.findByNickname(nickname);
    }
}
