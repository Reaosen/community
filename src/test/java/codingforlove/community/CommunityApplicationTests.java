package codingforlove.community;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void test() {
        System.out.println(RandomUtil.randomNumbers(6));
    }

}
