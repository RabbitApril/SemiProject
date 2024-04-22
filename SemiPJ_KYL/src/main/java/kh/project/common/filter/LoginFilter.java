package kh.project.common.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName = "loginFilter", urlPatterns = { "/board/*", "/mypage/*" })
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		if (session.getAttribute("aceptLogin") == null) {
//			로그인 성공 시 원래 가려던 url로 이동
//			GET 방식 전송 파라메터도 가지고 이동 
			
			String url = req.getRequestURI(); // 원래 가려던 URL 정보 읽어오기
			String query = req.getQueryString(); // Get query 문자열로 읽어오기 
			System.out.println("Req url : " + url);
			System.out.println("Requ query : " + query);
			String encodedUrl = null;
			
			if(query == null) { //전송 파라미터가 없다면
				encodedUrl = url;
			} else {
				encodedUrl = url + "?" + query;
			}
			
			// 경고 MSG
			String alertMsg = "";
			alertMsg = "&alertMsg = " + URLEncoder.encode("로그인 후 이용 가능합니다.","UTF-8");
			
			// 리다이렉트 시 원래 목적지 정보를 url 파라미터명으로 전송 
			res.sendRedirect(req.getContextPath() + "/login?url=" + encodedUrl + alertMsg);
		} else {
			String url = req.getRequestURI();
			System.out.println("Req url : " + url);
			chain.doFilter(request, response);
		}
	}
}
