package com.zxly.o2o.request;

import com.aliter.entity.ShopAppMenuBean;
import com.android.volley.VolleyError;
import com.easemob.easeui.AppException;
import com.easemob.easeui.utils.GsonParser;
import com.google.gson.reflect.TypeToken;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.util.PreferUtil;

import java.util.List;

/**
 * Created by hejun on 2016/9/18.
 * 获取商户APP菜单权限
 */
public class GeShopAppMenuRequest extends BaseRequest{

    private ShopAppMenuBean shopAppMenuBeanArrayList = new ShopAppMenuBean();


    public GeShopAppMenuRequest(){
        if(Account.user!=null&&Account.user.getId()!=0){
            addParams("shopId", Account.user.getShopId());
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        if (listener != null) {
            listener.onFail(0000);
        }
    }

    @Override
    protected String method() {
        return "shopApp/menu";
    }

    @Override
    protected void fire(String data) throws AppException {



        try {
            TypeToken<ShopAppMenuBean> type = new TypeToken<ShopAppMenuBean>() {
            };
            shopAppMenuBeanArrayList = GsonParser.getInstance().fromJson(data, type);
            List<ShopAppMenuBean.MenuDataBean> menuDataBean = shopAppMenuBeanArrayList.getMenuData();
            PreferUtil.getInstance().setShopPackType(shopAppMenuBeanArrayList.getPackType());
            for (int i=0;i<menuDataBean.size();i++){
             String   tmp = menuDataBean.get(i).getMenuName();
                String   code = menuDataBean.get(i).getCode();
                if (tmp.equals("店铺文章")) {
                    if (code.equals("dpwz001")) {
                        PreferUtil.getInstance().setDpwz001(true);
                    } else {
                        PreferUtil.getInstance().setDpwz001(false);
                    }
                    continue;
                }
                if (tmp.equals("本地热文")) {
                    if (code.equals("bdrw001")) {
                        PreferUtil.getInstance().setBdrw001(true);
                    } else {
                        PreferUtil.getInstance().setBdrw001(false);
                    }
                    continue;
                }
                if (tmp.equals("网络热文")) {
                    if (code.equals("wlrw001")) {
                        PreferUtil.getInstance().setWlrw001(true);
                    } else {
                        PreferUtil.getInstance().setWlrw001(false);
                    }
                    continue;
                }
                if (tmp.equals("自定义文章")) {
                    if (code.equals("zdywz001")) {
                        PreferUtil.getInstance().setZdywz001(true);
                    } else {
                        PreferUtil.getInstance().setZdywz001(false);
                    }
                    continue;
                }
                if (tmp.equals("活动")) {
                    if (code.equals("hd001")) {
                        PreferUtil.getInstance().setHd001(true);
                    } else {
                        PreferUtil.getInstance().setHd001(false);
                    }
                    continue;
                }
                if (tmp.equals("我的网店")) {
                    if (code.equals("wdwd001")) {
                        PreferUtil.getInstance().setWdwd001(true);
                    } else {
                        PreferUtil.getInstance().setWdwd001(false);
                    }
                    continue;
                }
                if (tmp.equals("碎柚保")) {
                    if (code.equals("syb001")) {
                        PreferUtil.getInstance().setSyb001(true);
                    } else {
                        PreferUtil.getInstance().setSyb001(false);
                    }
                    continue;
                }
                if (tmp.equals("流量充值")) {
                    if (code.equals("llcz001")) {
                        PreferUtil.getInstance().setLlcz001(true);
                    } else {
                        PreferUtil.getInstance().setLlcz001(false);
                    }
                    continue;
                }
                if (tmp.equals("赚佣金")) {
                    if (code.equals("zyj001")) {
                        PreferUtil.getInstance().setZyj001(true);
                    } else {
                        PreferUtil.getInstance().setZyj001(false);
                    }
                    continue;
                }

                if (tmp.equals("店员榜单")) {
                    if (code.equals("dybd001")) {
                        PreferUtil.getInstance().setDybd001(true);
                    } else {
                        PreferUtil.getInstance().setDybd001(false);
                    }
                    continue;
                }
                if (tmp.equals("送货清单")) {
                    if (code.equals("shqd001")) {
                        PreferUtil.getInstance().setShqd001(true);
                    } else {
                        PreferUtil.getInstance().setShqd001(false);
                    }
                    continue;
                }

                if (tmp.equals("优惠领取")) {
                    if (code.equals("yhlq001")) {
                        PreferUtil.getInstance().setYhlq001(true);
                    } else {
                        PreferUtil.getInstance().setYhlq001(false);
                    }
                    continue;
                }

                if (tmp.equals("优惠统计")) {
                    if (code.equals("yhtj001")) {
                        PreferUtil.getInstance().setYhtj001(true);
                    } else {
                        PreferUtil.getInstance().setYhtj001(false);
                    }
                    continue;
                }

                if (tmp.equals("订单管理")) {
                    if (code.equals("ddgl001")) {
                        PreferUtil.getInstance().setDdgl001(true);
                    } else {
                        PreferUtil.getInstance().setDdgl001(false);
                    }
                    continue;
                }

                if (tmp.equals("赚钱攻略")) {
                    if (code.equals("zqgl001")) {
                        PreferUtil.getInstance().setZqgl001(true);
                    } else {
                        PreferUtil.getInstance().setZqgl001(false);
                    }
                    continue;
                }

                if (tmp.equals("客多多")) {
                    if (code.equals("kdd001")) {
                        PreferUtil.getInstance().setKdd001(true);
                    } else {
                        PreferUtil.getInstance().setKdd001(false);
                    }
                    continue;
                }

            }
        } catch (Exception e) {
            throw new AppException("数据解析异常");
        }
    }
}
