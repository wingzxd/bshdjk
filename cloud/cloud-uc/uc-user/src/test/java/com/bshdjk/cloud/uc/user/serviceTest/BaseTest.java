package com.bshdjk.cloud.uc.user.serviceTest;

import com.bshdjk.cloud.uc.user.UcUserApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {UcUserApplication.class})
@RunWith(SpringRunner.class)
public class BaseTest {

        @Test
        public void test() {
            System.out.println("ok");
        }
}
