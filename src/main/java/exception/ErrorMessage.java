package exception;


public class ErrorMessage{
    private String code;
    private String message;

    public static ErrorMessageBuilder builder() {
        return new ErrorMessageBuilder();
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorMessage() {
    }

    public ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String toString() {
        String var10000 = this.getCode();
        return "AccountErrorMessage(code=" + var10000 + ", message=" + this.getMessage() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorMessage other)) {
            return false;
        } else {
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    return other$message == null;
                } else return this$message.equals(other$message);
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ErrorMessage;
    }

    public int hashCode() {

        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    public static class ErrorMessageBuilder {
        private String code;
        private String message;

        ErrorMessageBuilder() {
        }

        public ErrorMessageBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ErrorMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(this.code, this.message);
        }

        public String toString() {
            return "AccountErrorMessage.AccountErrorMessageBuilder(code=" + this.code + ", message=" + this.message + ")";
        }
    }
}
