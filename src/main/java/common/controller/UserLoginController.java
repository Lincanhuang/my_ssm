package common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import system.entity.SysUser;
import system.service.SysUserService;

@Controller
public class UserLoginController {

	@Resource
	SysUserService sysUserService;
	
	/**
	 * 登录跳转
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("user/login");
	}
	/**
	 * 注册跳转
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(){
		return "/user/register";
	}
	/**
	 * 登录提交
	 * @param entity		登录的UUser
	 * @param rememberMe	是否记住
	 * @param request		request，用来取登录之前Url地址，用来登录后跳转到没有登录之前的页面。
	 * @return
	 */
	@RequestMapping(value="submitLogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitLogin(SysUser entity,Boolean rememberMe,HttpServletRequest request,RedirectAttributes redirectAttributes){
		if (rememberMe == null) {
			rememberMe = false;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			UsernamePasswordToken upk = new UsernamePasswordToken(entity.getUsername(), entity.getPassword());
			upk.setRememberMe(rememberMe);
			SecurityUtils.getSubject().login(upk);
			SecurityUtils.getSubject().getPrincipal();
			resultMap .put("status", 200);
			resultMap.put("message", "登录成功");
			redirectAttributes.addFlashAttribute("request",request.getParameterMap());
			/**
			 * shiro 获取登录之前的地址
			 */
			SavedRequest savedRequest = WebUtils.getSavedRequest(request);
			String url = null ;
			if(null != savedRequest){
				url = savedRequest.getRequestUrl();
			}
			/**
			 * 我们平常用的获取上一个请求的方式，在Session不一致的情况下是获取不到的
			 * String url = (String) request.getAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE);
			 */
			//如果登录之前没有地址，那么就跳转到首页。
			if(StringUtils.isBlank(url)){
				url = request.getContextPath() + "/user/index.shtml";
			}
			redirectAttributes.addFlashAttribute("back_url",url);
			resultMap.put("url", url);
		/**
		 * 这里其实可以直接catch Exception，然后抛出 message即可，但是最好还是各种明细catch 好点。。
		 */
		} catch (DisabledAccountException e) {
			resultMap.put("status", 500);
			resultMap.put("message", "帐号已经禁用。");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "帐号或密码错误");
		}
		return resultMap;
	}
	
	@RequestMapping(value="success",method= {RequestMethod.POST,RequestMethod.GET})
	public void success(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(request.getHeader("accept"));
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Location", request.getParameter("back_url"));
	}
	
	@RequestMapping(value="fail",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> fail(ServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("back_url", request.getParameter("back_url"));
		return resultMap;
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value="logout",method =RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> logout(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			SecurityUtils.getSubject().logout();
			resultMap .put("status", 200);
		} catch (Exception e) {
			resultMap.put("status", 500);
		}
		return resultMap;
	}
	@RequestMapping(value="index",method =RequestMethod.GET)
	public String index() {
		return "index";
	}
}
