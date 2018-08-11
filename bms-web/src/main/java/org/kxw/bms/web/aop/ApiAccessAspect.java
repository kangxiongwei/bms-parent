package org.kxw.bms.web.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.kxw.bms.web.annotation.RestfulApi;
import org.kxw.bms.web.model.HttpBaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Create by kangxiongwei on 2018/8/11 下午1:06
 */
@Aspect
@Component
public class ApiAccessAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAccessAspect.class);


    /**
     * 所有用RestfulApi标签围绕的切面
     *
     * @param jp
     * @param ra
     * @return
     */
    @Around(value = "@annotation(ra)")
    public Object access(ProceedingJoinPoint jp, RestfulApi ra) {
        HttpBaseResult result = null;
        long startTime = System.currentTimeMillis();
        try {
            result = (HttpBaseResult) jp.proceed();
        } catch (Throwable throwable) {
            LOGGER.error("调用API接口出错，异常为：", throwable);
            result = new HttpBaseResult(HttpBaseResult.SERVER_ERROR, throwable.getMessage());
        } finally {
            MethodSignature method = ((MethodSignature) jp.getSignature());
            Object[] args = jp.getArgs();
            String[] params = method.getParameterNames();
            String request = null;
            if (args != null && args.length > 0 && params != null && params.length > 0) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < params.length; i++) {
                    builder.append(params[i]).append("=").append(JSON.toJSONString(args[i])).append(",");
                }
                request = builder.toString();
            }
            LOGGER.info("调用接口{}.{}结束，总耗时{}ms，请求参数：{}，返回结果：{}",
                    method.getDeclaringType().getSimpleName(),
                    method.getName(),
                    System.currentTimeMillis() - startTime,
                    request,
                    JSON.toJSONString(result));
        }
        return result;
    }


}
