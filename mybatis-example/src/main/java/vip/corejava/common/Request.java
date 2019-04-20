package vip.corejava.common;

import lombok.Data;

import javax.validation.Valid;

@Data
public class Request<F, Q> {
    @Valid
    private F form;
    @Valid
    private Q query;
    private Pagination pagination;
    private String sort;
}
