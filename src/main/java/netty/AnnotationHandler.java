package netty;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class AnnotationHandler implements IHandler {
    private IHandler handler;
    private Map<IHandler, Map<String, Method>> methodInfo = new ConcurrentHashMap<>();

    public AnnotationHandler(IHandler handler) {
        this.handler = handler;
        init();
    }
`
    private void init() {
        Method[] declaredMethods = handler.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            RequestMapping annotation = declaredMethod.getAnnotation(RequestMapping.class);
            if (annotation == null) {
                continue;
            }
            String apiName = annotation.ApiName();
            methodInfo.computeIfAbsent(handler, (k) -> {
                ConcurrentHashMap<String, Method> nameToMethod = new ConcurrentHashMap<>();
                nameToMethod.put(apiName, declaredMethod);
                return nameToMethod;
            });
        }
    }

    @Override
    public String handler(JSONObject request) {
        String apiName = request.getString("interface");

        return Optional.ofNullable(methodInfo.get(handler))
                .map(methodMap ->
                        Optional.ofNullable(methodMap.get(apiName))
                                .map(method -> {
                                    try {
                                        return method.invoke(handler, request).toString();
                                    } catch (IllegalAccessException | InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                    return "error"; }).orElse("error")
                ).orElseThrow(() -> new RuntimeException("方法不存在！" + apiName));
    }
}
