package hello.login.web.argumentresolver;

import hello.login.util.DateUtilStr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.text.DateFormat;
import java.util.Date;

@Slf4j
public class DateUtilArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

       log.info("supportsParameter 실행");
       boolean hasDateUtilAnnotation = parameter.hasParameterAnnotation(DateUtil.class);
       boolean hasDateUtilStrType = DateUtilStr.class.isAssignableFrom(parameter.getParameterType());
       return hasDateUtilAnnotation && hasDateUtilStrType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        DateUtilStr dateUtilStr = new DateUtilStr();
        dateUtilStr.setNow("2022-11-17");
        return dateUtilStr;
    }
}
