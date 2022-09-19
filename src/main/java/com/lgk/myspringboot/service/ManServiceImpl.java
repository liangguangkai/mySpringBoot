package com.lgk.myspringboot.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgk.myspringboot.entity.Man;
import com.lgk.myspringboot.mapper.ManMapper;
import com.lgk.myspringboot.service.impl.ManService;
/**
 * @author liangguangkai
 * @date 2022/9/14 ${Time}
 * @version 1.0
 */   
@Service
public class ManServiceImpl extends ServiceImpl<ManMapper, Man> implements ManService{

}
