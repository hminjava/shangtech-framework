
package net.shangtech.framework.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * 文件名： BaseController.java
 * 作者： 宋相恒
 * 版本： 2013-6-24 下午08:58:26 v1.0
 * 日期： 2013-6-24
 * 描述：
 */
public class BaseController {
	
	protected int parsePageNo(String pageInfo){
		if(StringUtils.isBlank(pageInfo))
			return 1;
		if(!pageInfo.contains("-"))
			return Integer.parseInt(pageInfo);
		return Integer.parseInt(pageInfo.split("-")[0]);
	}
	
	protected int parsePageSize(String pageInfo, int pageSize){
		if(StringUtils.isBlank(pageInfo) || !pageInfo.contains("-"))
			return pageSize;
		return Integer.parseInt(pageInfo.split("-")[1]);
	}
	
	protected Integer getId(HttpServletRequest request){
		String id = request.getParameter("id");
		if(StringUtils.isNotBlank(id))
			return Integer.parseInt(id);
		return null;
	}
	
	public Integer getInt(HttpServletRequest request, String name){
		String value = request.getParameter(name);
		if(value != null && !"".equals(value))
			return Integer.parseInt(value);
		return null;
	}
	
	public String getString(HttpServletRequest request, String name){
		return request.getParameter(name);
	}

}

	