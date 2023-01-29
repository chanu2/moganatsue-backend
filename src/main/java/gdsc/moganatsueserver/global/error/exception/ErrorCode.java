package gdsc.moganatsueserver.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */


    SKIN_NOT_FOUND(404, "해당하는 정보의 피부 질환을 찾을 수 없습니다."),

    GROUP_NOT_HOST(400,  "방의 호스트가 아닙니다"),
    PARTICIPATION_NOT_FOUND(404, "참여하지 않은 방입니다."),

    /* 409 : CONFLICT : Resource의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    DUPLICATE_RESOURCE(409, "데이터가 이미 존재합니다."),








    ;

    private int status;
    private String reason;
}