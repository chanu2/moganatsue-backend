package gdsc.moganatsueserver.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class MoganatsuException extends RuntimeException{
    ErrorCode errorCode;

}
