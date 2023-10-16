package maik.example.msauth.service;

import maik.example.msauth.dto.AuthUserDto;
import maik.example.msauth.entity.AuthUser;
import maik.example.msauth.entity.TokenDto;
public interface AuthUserService {
    public AuthUser save(AuthUserDto authUserDto);
    public TokenDto login(AuthUserDto authUserDto);
    public TokenDto validate(String token);
}
