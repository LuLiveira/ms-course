package br.com.lucas.hroauth.vos;

import java.io.Serializable;
import java.util.Objects;

public class RoleVo implements Serializable {

    private Long id;

    private String name;

    public RoleVo() {
    }

    public RoleVo(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleVo roleVo = (RoleVo) o;
        return id.equals(roleVo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
