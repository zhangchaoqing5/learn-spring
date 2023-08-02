package org.kira.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kira.dao.sx.PersonMapper;
import org.kira.domain.entity.Person;
import org.springframework.stereotype.Service;

/**
 * @author zhang chaoqing
 * @date 2023/8/1 12:29
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {


}
