package com.belum.apitemplate.services;

import com.belum.apitemplate.domain.ClientInfo;

import java.io.UnsupportedEncodingException;

/**
 * Created by bel-sahn on 7/31/19
 */
public interface JwtService {
    String createJwt(ClientInfo payload) throws UnsupportedEncodingException;
    ClientInfo decodeJwt(String token) throws UnsupportedEncodingException;
}
