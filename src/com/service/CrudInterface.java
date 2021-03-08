package com.service;

import com.example.model.network.Header;

//                             이런식으로 데이터를 받는게 제네릭 타입
public interface CrudInterface<Req, Res> {

    Boolean create(Header<Req> request) throws Exception;        // todo request object 추가

    Header<Res> read(int id) throws Exception;

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
