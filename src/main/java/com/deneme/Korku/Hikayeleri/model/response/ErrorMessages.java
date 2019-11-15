package com.deneme.Korku.Hikayeleri.model.response;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Lütfen gerekli alanları doldurun !"),
    COULD_NOT_CREATE_USER_PROFILE("Kullanıcı profili oluşturulamadı.Lütfen sonra tekrar deneyiniz."),
    COULD_NOT_UPDATE_USER_PROFILE("Kullanıcı profili güncellenemedi.Lütfen sonra tekrar deneyiniz."),
    COULD_NOT_DELETE_USER_PROFILE("Kullanıcı profili silinemedi.Lütfen sonra tekrar deneyiniz."),
    NO_RECORD_FOUND("Kayıt bulunamadı."),
    RECORD_USERNAME_ALREADY_EXISTS("Bu kullanıcı adı zaten var."),
    RECORD_EMAIL_ALREADY_EXISTS("Bu email adresi ile daha önce kayıt oluşturulmuş."),
    INTERNAL_SERVER_ERROR("Upsss ! Bir şeyler yolunda gitmedi. Daha sonra tekrar deneyiniz."),
    AUTHENTICATION_FAILED("Giriş başarısız."),
    EMAIL_ADDRESS_NOT_VERIFIED("Email adresiniz doğrulanamadı.");


    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
