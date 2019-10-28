package com.newer.domain;

import java.io.Serializable;
import java.util.Date;

public class buylist implements Serializable {
    private Integer buylist_id;//采购单明细ID
    private Integer buy_id;//采购单ID
    private Integer q_id;//请购单ID
    private Date out_time;//发货时间
    private Integer logistics_id;//物流编号

}
