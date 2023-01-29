package gdsc.moganatsueserver.domain.skindisease.exception;


import gdsc.moganatsueserver.global.error.exception.ErrorCode;
import gdsc.moganatsueserver.global.error.exception.MoganatsuException;

public class SkinDiseaseNotFound extends MoganatsuException {
    public static final MoganatsuException EXCEPTION = new SkinDiseaseNotFound();
    public SkinDiseaseNotFound() {
        super(ErrorCode.SKIN_NOT_FOUND);
    }
}
