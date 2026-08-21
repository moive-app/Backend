package com.moive.MoiveBE.global.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@RequiredArgsConstructor
public enum CustomErrorCode {

    // Common (1xxx)
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 1001, "서버 내부에 오류가 있습니다."),
    INVALID_INPUT(BAD_REQUEST, 1002, "잘못된 입력값입니다."),

    // TODO Custom ErrorCode 를 추가해 주세요

    ;

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}
