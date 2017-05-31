package com.aliter.http;

/**
 * Created by mango on 2016/10/8.
 */
public class StatusUtils {

    public static class StatusResult{
        public int status;
        public String desc;
    }

    private static StatusResult mStatusResult = new StatusResult();

    public static StatusResult judgeStatus(int status,String desc) {

        switch (status) {
//            case AppConstants.STATUS_SUCCESS:
//                desc = AppConstants.SUCCESS_MSG;
//                break;
        }
        mStatusResult.status = status;
        mStatusResult.desc = desc;
        return mStatusResult;
    }


    public static String getErrorMsg(){
        return  mStatusResult.desc;
    }
}
