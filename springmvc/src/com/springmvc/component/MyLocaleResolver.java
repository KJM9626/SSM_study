package com.springmvc.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @author ��
 *�Զ���������Ϣ������
 */
public class MyLocaleResolver implements LocaleResolver {

	/**
	 *��������locale
	 */
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Locale locale=null;
//		�������locale�������ò���ָ����������Ϣ�����û������Ĭ�ϵ�
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
