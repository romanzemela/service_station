package pl.coderslab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Encoding implements Filter {
    private final String ENCODING =	"utf-8";
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
