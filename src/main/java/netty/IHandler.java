package netty;

import com.alibaba.fastjson.JSONObject;

public interface IHandler {
    String handler(JSONObject request);
}
