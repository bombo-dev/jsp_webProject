package service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//요청시 동일한 처리가 필요할 때, 하나의 클래스에서 모두 처리 후 넘기는 형태의 클래스
// 이를, Filter 클래스라고 한다.
// 주로, Encoding 방식을 맞출때 가장 많이 사용된다.

//@WebFilter("/*")
public class Encoding implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
		
	}

}
