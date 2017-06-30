package com.zxly.o2o.request;

import com.aliter.entity.H5ShopBase;
import com.easemob.easeui.AppException;
import com.easemob.easeui.utils.GsonParser;
import com.google.gson.reflect.TypeToken;
import com.zxly.o2o.account.Account;


/**
 *     @author huangbin  @version 创建时间：2015-2-4 上午11:21:49    类说明: 
 */
public class H5Request extends BaseRequest {

    public H5ShopBase articles=new H5ShopBase();
    public boolean hasNext = true;
    public H5Request(int pageIndex, int pageSize) {

        addParams("shopId",Account.user.getShopId());
        addParams("pageIndex", pageIndex);
        addParams("pageSize", pageSize);
    }

    @Override
    protected void fire(String data) throws AppException {
        TypeToken<H5ShopBase> token = new TypeToken<H5ShopBase>() {
        };
        articles = GsonParser.getInstance().fromJson(data, token);



    }

    @Override
    protected String method() {
            return "/commend/product/list";

    }

}
