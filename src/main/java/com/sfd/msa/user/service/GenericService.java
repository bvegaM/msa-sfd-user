package com.sfd.msa.user.service;

import com.sfd.msa.user.exceptions.NotContentException;

import java.util.List;

public interface GenericService <T, ID>{


    List<T> findAll() throws NotContentException;

    T findById(ID id);

    T save(T body);
}
