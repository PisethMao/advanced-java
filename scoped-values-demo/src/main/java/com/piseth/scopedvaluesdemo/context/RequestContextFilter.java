package com.piseth.scopedvaluesdemo.context;

import com.piseth.scopedvaluesdemo.dto.RequestContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component("scopedValueContextFilter")
public class RequestContextFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String userId = request.getHeader("X-Demo-User");
        if (userId == null || userId.isBlank()) {
            userId = "guest";
        }
        RequestContext context = new RequestContext(UUID.randomUUID().toString(), userId);
        try {
            RequestContextHolder.callWith(context, () -> {
                filterChain.doFilter(request, response);
                return null;
            });
        } catch (ServletException | IOException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new ServletException("Request processing failed", exception);
        }
    }
}

