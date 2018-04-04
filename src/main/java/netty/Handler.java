package netty;

import com.alibaba.fastjson.JSONObject;

public class Handler implements IHandler{
    @RequestMapping(ApiName = "sayHello")
    public String sayHello(JSONObject jsonObject) {
        System.out.println("sayHello: " + jsonObject + " this is from handler");
        return "hello world";
    }

    @Override
    public String handler(JSONObject request) {
        return null;
    }
}
