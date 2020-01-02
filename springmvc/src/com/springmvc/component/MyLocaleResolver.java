package com.springmvc.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @author 明
 *自定义区域信息解析器
 */
public class MyLocaleResolver implements LocaleResolver {

	/**
	 *解析返回locale
	 */
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Locale locale=null;
//		如果带了locale参数就用参数指定的区域信息，如果没带就用默认的
		String localeStr=request.getParameter("locale");
		if(localeStr!=null&&!"".equals(localeStr)) {
			locale=new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
		}else {
			locale=request.getLocale();
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Locale locale) {
		throw new UnsupportedOperationException(
				"Cannot change HTTP accept header - use a different locale resolution strategy");
	}
}
