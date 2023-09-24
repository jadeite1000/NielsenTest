package exception;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ErrorResponse {
    private String version;
    private Integer httpStatusCode;
    private List<ErrorMessage> errors;

    public static ErrorResponseBuilder builder() {
        return new ErrorResponseBuilder();
    }

    public String getVersion() {
        return this.version;
    }

    public Integer getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public List<ErrorMessage> getErrors() {
        return this.errors;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorResponse other)) {
            return false;
        } else {
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$httpStatusCode = this.getHttpStatusCode();
                    Object other$httpStatusCode = other.getHttpStatusCode();
                    if (this$httpStatusCode == null) {
                        if (other$httpStatusCode == null) {
                            break label47;
                        }
                    } else if (this$httpStatusCode.equals(other$httpStatusCode)) {
                        break label47;
                    }

                    return false;
                }

                Object this$version = this.getVersion();
                Object other$version = other.getVersion();
                if (this$version == null) {
                    if (other$version != null) {
                        return false;
                    }
                } else if (!this$version.equals(other$version)) {
                    return false;
                }

                Object this$errors = this.getErrors();
                Object other$errors = other.getErrors();
                if (this$errors == null) {
                    return other$errors == null;
                } else return this$errors.equals(other$errors);
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ErrorResponse;
    }

    public int hashCode() {

        int result = 1;
        Object $httpStatusCode = this.getHttpStatusCode();
        result = result * 59 + ($httpStatusCode == null ? 43 : $httpStatusCode.hashCode());
        Object $version = this.getVersion();
        result = result * 59 + ($version == null ? 43 : $version.hashCode());
        Object $errors = this.getErrors();
        result = result * 59 + ($errors == null ? 43 : $errors.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getVersion();
        return "ErrorResponse(version=" + var10000 + ", httpStatusCode=" + this.getHttpStatusCode() + ", errors=" + this.getErrors() + ")";
    }

    public ErrorResponse() {
    }

    public ErrorResponse(String version, Integer httpStatusCode, List<ErrorMessage> errors) {
        this.version = version;
        this.httpStatusCode = httpStatusCode;
        this.errors = errors;
    }

    public static class ErrorResponseBuilder {
        private String version;
        private Integer httpStatusCode;
        private ArrayList<ErrorMessage> errors;

        ErrorResponseBuilder() {
        }

        public ErrorResponseBuilder version(String version) {
            this.version = version;
            return this;
        }

        public ErrorResponseBuilder httpStatusCode(Integer httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
            return this;
        }

        public ErrorResponseBuilder error(ErrorMessage error) {
            if (this.errors == null) {
                this.errors = new ArrayList<>();
            }

            this.errors.add(error);
            return this;
        }

        public ErrorResponseBuilder errors(Collection<? extends ErrorMessage> errors) {
            if (errors == null) {
                throw new NullPointerException("errors cannot be null");
            } else {
                if (this.errors == null) {
                    this.errors = new ArrayList<>();
                }

                this.errors.addAll(errors);
                return this;
            }
        }

        public ErrorResponseBuilder clearErrors() {
            if (this.errors != null) {
                this.errors.clear();
            }

            return this;
        }

        public ErrorResponse build() {
            List errorList = new ArrayList<>();
            switch (this.errors == null ? 0 : this.errors.size()) {
                case 0:
                    errorList = Collections.emptyList();
                    break;
                case 1:
                    if (this.errors != null) {
                        errorList = Collections.singletonList(this.errors.get(0));
                    }
                    break;
                default:
                    errorList = Collections.unmodifiableList(new ArrayList(this.errors));
            }

            return new ErrorResponse(this.version, this.httpStatusCode, errorList);
        }

        public String toString() {
            return "ErrorResponse.ErrorResponseBuilder(version=" + this.version + ", httpStatusCode=" + this.httpStatusCode + ", errors=" + this.errors + ")";
        }
    }
}