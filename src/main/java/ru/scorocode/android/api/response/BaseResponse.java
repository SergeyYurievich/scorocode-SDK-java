package ru.scorocode.android.api.response;

public class BaseResponse<ResponseEntity> {

    private boolean error;
    private int errCode;
    private String errMsg;
    private ResponseEntity result;

    public boolean hasError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public ResponseEntity getResult() {
        return result;
    }

    public void setResult(ResponseEntity result) {
        this.result = result;
    }
}
