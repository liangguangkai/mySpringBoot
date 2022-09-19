package com.lgk.myspringboot.convert;



import com.lgk.myspringboot.entity.Man;
import com.lgk.myspringboot.pojo.vo.ManGameVO;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * @author liangguangkai
 * @version 1.0
 * @date 2022/8/15
 */
@Mapper(componentModel = "spring")
public interface ManConvert {
    /**
     * Man => ManGameVO
     *
     * @param man
     * @return ManGameVO
     */
    ManGameVO toManVO(Man man);


    List<ManGameVO> toManVOList(List<Man> man);



}
