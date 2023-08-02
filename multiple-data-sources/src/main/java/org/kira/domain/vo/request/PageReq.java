package org.kira.domain.vo.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author zhang chaoqing
 * @date 2023/8/1 13:06
 */

@Data
@ApiModel("分页参数")
public class PageReq {

    @ApiModelProperty("页码,从1开始")
    @Min(0)
    private int pageNumber = 0;
    @ApiModelProperty("页长,默认10开始,最小值1")
    @Min(1)
    private int pageSize = 10;


    public Page plusPage() {
        return new Page(getPageNumber(), getPageSize());
    }


}
