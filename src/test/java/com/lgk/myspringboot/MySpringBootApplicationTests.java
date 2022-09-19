package com.lgk.myspringboot;

import com.lgk.myspringboot.convert.ManConvert;

import com.lgk.myspringboot.entity.Man;
import com.lgk.myspringboot.pojo.vo.ManGameVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MySpringBootApplicationTests {

    @Resource
    ManConvert manConvert;

    @Test
    void contextLoads() {
        List<Man> manList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Man man = new Man();
            man.setId(1+i);

            man.setName("lgk"+i);
            manList.add(man);
        }


        List<ManGameVO> manVOList = manConvert.toManVOList(manList);
        System.out.println(manVOList);
    }

}
