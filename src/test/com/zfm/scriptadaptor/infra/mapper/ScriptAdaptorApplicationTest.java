package com.zfm.scriptadaptor.infra.mapper;

import com.zfm.scriptadaptor.domain.entity.Tenant;
//import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
@SpringBootTest
public class ScriptAdaptorApplicationTest {

    @Resource
    private TenantMapper tenantMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
//        List<Tenant> userList = tenantMapper.selectList(null);
        List<Tenant> list = tenantMapper.selectList(null);
        Assertions.assertEquals(5, list.size());
        list.forEach(System.out::println);
    }

}
