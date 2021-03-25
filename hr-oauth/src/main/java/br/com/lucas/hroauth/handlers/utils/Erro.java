package br.com.lucas.hroauth.handlers.utils;

import br.com.lucas.hroauth.functions.StringFunction;

public class Erro {
    private String message;
    private String servletPath;

    public Erro(StringFunction message, StringFunction servletPath) {
        this.message = message.get();
        this.servletPath = servletPath.get();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServletPath() {
        return servletPath;
    }

    public void setServletPath(String servletPath) {
        this.servletPath = servletPath;
    }
}
