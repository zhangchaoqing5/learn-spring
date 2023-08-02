package org.kira.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kira.domain.vo.request.PageReq;
import org.kira.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang chaoqing
 * @date 2023/8/1 12:33
 */
@RestController
@RequestMapping("person")
@Api(tags = "人员管理接口")
public class PersonController {


    @Autowired
    private PersonService personService;


    @PostMapping("list")
    @ApiOperation("人员列表")
    public Object list(@Validated @RequestBody PageReq pageReq) {
        Page page = personService.page(pageReq.plusPage());
        return page.getRecords();
    }

}
