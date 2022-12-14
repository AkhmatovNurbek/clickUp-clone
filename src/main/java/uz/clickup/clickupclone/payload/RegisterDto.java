package uz.clickup.clickupclone.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class RegisterDto {
    @NotNull
    private String fullName;
    @NotNull
    private String password;
    @NotNull
    private String email;
}
