package pl.coderslab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class Encoding implements Filter {
    private final String ENCODING = "utf-8";

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/login", "/logout")));

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");

        boolean loggedIn = (session != null && session.getAttribute("id") != null);
        boolean allowedPath = ALLOWED_PATHS.contains(path);

        if (loggedIn || allowedPath) {
            chain.doFilter(req, res);
        } else {
            session.setAttribute("url", getFullPath(req));
            res.sendRedirect("/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    private String getFullPath(HttpServletRequest request){
        StringBuilder builder = new StringBuilder();
        builder.append(request.getRequestURI());
        if(request.getQueryString() != null){
            builder.append("?").append(request.getQueryString());
        }
        return builder.toString();
    }

}
