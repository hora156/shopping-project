package com.service;

import com.example.model.network.Header;

//                             이런식으로 데이터를 받는게 제네릭 타입
public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);        // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
