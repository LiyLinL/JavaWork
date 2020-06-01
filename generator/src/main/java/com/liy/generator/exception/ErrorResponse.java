package com.liy.generator.exception;

/* Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
*/
public class ErrorResponse {

    private String msg;

    public ErrorResponse() {
    }

    public ErrorResponse( String msg ) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }
}
