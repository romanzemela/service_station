package pl.coderslab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter("/*")
public class PathFilter implements Filter {
    Pattern pattern = Pattern.compile("^\\/[a-zA-Z]*");

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Matcher matcher = pattern.matcher(request.getRequestURI());
        if (matcher.find()) {
            request.setAttribute("path", matcher.group(0));
        }

        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
